/*
 * Copyright Debezium Authors.
 *
 * Licensed under the Apache Software License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package io.debezium.connector.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.c3p0.internal.C3P0ConnectionProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomConnectionProvider extends C3P0ConnectionProvider {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomConnectionProvider.class);

    @Override
    public Connection getConnection() throws SQLException {
        Connection connection = super.getConnection();

        try (Statement stmt = connection.createStatement()) {
            stmt.execute("SET session_replication_role = 'replica';");
            LOGGER.info("session_replication_role is set to replica!");
        }
        catch (Exception e) {
            LOGGER.warn("session_replication_role is not set to replica!");
        }

        return connection;
    }
}
