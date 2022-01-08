package com.bukvich.util.weatherstat;

import lombok.NonNull;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;

public abstract class AbstractDbTest {
    private static final Integer STARTUP_TIMEOUT = 600;
    private static final String PG_IMAGE = "postgres:13.2-alpine";

    private static PostgreSQLContainer<?> dbContainer;

    @DynamicPropertySource
    static synchronized void setupPostgresProperties(@NonNull DynamicPropertyRegistry registry) {
        if (dbContainer == null) {
            dbContainer =
                    new PostgreSQLContainer<>(PG_IMAGE)
                            .withTmpFs(Map.of("/var/lib/postgresql/data", "rw"))
                            .withStartupTimeout(Duration.ofSeconds(STARTUP_TIMEOUT));
            dbContainer.start();
        }

        registry.add(
                "spring.datasource.url", () -> dbContainer.getJdbcUrl() + "&stringtype=unspecified");
        registry.add("spring.datasource.username", dbContainer::getUsername);
        registry.add("spring.datasource.password", dbContainer::getPassword);
        registry.add(
                "spring.liquibase.url", () -> dbContainer.getJdbcUrl() + "&stringtype=unspecified");
        registry.add("spring.liquibase.user", dbContainer::getUsername);
        registry.add("spring.liquibase.password", dbContainer::getPassword);
    }

    private static boolean backupExists = false;

    @BeforeEach
    public synchronized void init() throws IOException, InterruptedException {
        if (!backupExists) {
            dbContainer.execInContainer(
                    "pg_dump",
                    "-U",
                    dbContainer.getUsername(),
                    "-Fc",
                    "-c",
                    dbContainer.getDatabaseName(),
                    "-f",
                    "/tmp/backup.sql");
            backupExists = true;
        } else {
            dbContainer.execInContainer(
                    "pg_restore",
                    "-U",
                    dbContainer.getUsername(),
                    "-c",
                    "-d",
                    dbContainer.getDatabaseName(),
                    "/tmp/backup.sql");
        }
    }
}
