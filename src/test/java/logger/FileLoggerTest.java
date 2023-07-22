package logger;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class FileLoggerTest {
    private static final String TEST_LOG_FORMAT = "%s [%-5s] %s%n";
    private static final long TEST_MAX_FILE_SIZE = 1000; // In bytes

    private static FileLogger logger;
    private static String logFilePath;

    @TempDir
    static Path tempDir;

    @BeforeAll
    public static void setup() throws IOException {
        String testLogDirectory = tempDir.resolve("test_logs").toString();
        String testFilePath = testLogDirectory + File.separator + "test_log.txt";

        FileLoggerConfiguration config = new FileLoggerConfiguration(
                testFilePath, testLogDirectory, LoggingLevel.DEBUG, TEST_MAX_FILE_SIZE, TEST_LOG_FORMAT
        );
        logger = new FileLogger(config);
        logFilePath = config.getLogDirectory() + File.separator + "test_log.txt";
    }

    @AfterAll
    public static void cleanup() throws IOException {
        logger.close();
    }

    @Test
    public void testLogFileCreation() {
        // Ensure that the log file is created
        Assertions.assertTrue(new File(logFilePath).exists());
    }

    @Test
    public void testLoggingMessage() throws IOException {
        String testMessage = "Test log message";

        logger.debug(testMessage);
        logger.info(testMessage);

        // Flush the logs to ensure they are written to the file
        logger.close();

        // Check if the log messages are present in the file
        String fileContent = TestUtils.readFileContent(logFilePath);
        Assertions.assertTrue(fileContent.contains("[DEBUG] " + testMessage));
        Assertions.assertTrue(fileContent.contains("[INFO ] " + testMessage));
    }
}
