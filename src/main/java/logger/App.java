package logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        try {
            // Specify the log directory
            String logDirectoryPath = "c:\\temp\\dz024\\logs";

            // Create the log directory if it doesn't exist
            File logDirectory = new File(logDirectoryPath);
            if (!logDirectory.exists()) {
                logDirectory.mkdirs();
            }

            // Create the log file with the specified directory and unique timestamp
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
            String logFileName = "log_" + sdf.format(new Date()) + ".txt";
            File logFile = new File(logDirectory, logFileName);

            // Get the absolute path of the log file
            String logFilePath = logFile.getAbsolutePath();

            FileLoggerConfiguration config = new FileLoggerConfiguration(logFilePath, logDirectoryPath, LoggingLevel.INFO, 1024L, "[%s][%s]--%s");
            FileLogger logger = new FileLogger(config);

            for (int i = 1; i <= 20; i++) {
                String message = "Test message, test message, TEST_MESSAGE " + i;
                logger.debug(message);
                logger.info(message);
                // Test delay
                Thread.sleep(100);
            }

            // Finished loggers work, write the remainder of the buffer, if any
            logger.close();
        } catch (IOException e) {
            logger.error("An I/O error occurred: ", e);
        } catch (InterruptedException e) {
            logger.error("Thread interrupted: ", e);
            Thread.currentThread().interrupt();
        }
    }
}
