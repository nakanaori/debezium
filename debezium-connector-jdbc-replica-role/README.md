# Notes

- Clone from https://github.com/debezium/debezium branch 2.7

# Building

## Pre-requisite
- Git 2.2.1 or later
- JDK 17 or later, e.g. OpenJDK
- Docker Engine or Docker Desktop 1.9 or later
- Apache Maven 3.8.4 or later (or invoke the wrapper with ./mvnw for Maven commands)

### With Unit and Integration test
- do `mvn clean verify`

### Without Integration test
- do ```mvn clean verify -DskipITs```

### Building just the artifacts, without running tests, CheckStyle, etc.
- do ```mvn clean verify -Dquick```
