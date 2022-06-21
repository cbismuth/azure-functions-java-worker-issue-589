package com.github.cbismuth.azfuncjava11;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingTest.class);

    @Test
    public void testLoggerConfiguration() {
        LOGGER.info("Logger successfully initialized");
    }
}
