package logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileLogger {
    private static final Logger logger = LoggerFactory.getLogger(FileLogger.class);
    private FileLoggerConfiguration config;
    private DateFormat dateFormat;
    private StringBuilder buffer;
    private FileWriter fileWriter;
    private long currentFileSize;

    public FileLogger(FileLoggerConfiguration config) throws IOException {
        this.config = config;
        this.dateFormat = new SimpleDateFormat("dd.MM.yyyy-HH:mm:ss.SSS");
        this.buffer = new StringBuilder();
        this.currentFileSize = 0;

        // Create a log directory if it doesn't exist
        File logDirectory = new File(config.getLogDirectory());
        if (!logDirectory.exists()) {
            logDirectory.mkdirs();
        }

        createNewLogFile();
    }

    public void debug(String message) throws IOException {
        log("DEBUG", message);
    }

    public void info(String message) throws IOException {
        log(" INFO", message);
    }

    private void log(String level, String message) throws IOException {
        String timestamp = dateFormat.format(new Date());
        String formattedMessage = String.format(config.getLogFormat(),
                timestamp, level, message);

        long newLineSize = System.lineSeparator().length();
        long logEntrySize = formattedMessage.length() + newLineSize;

        if (currentFileSize + logEntrySize >= config.getMaxFileSize()) {
            writeLog();
            createNewLogFile();
        }

        buffer.append(formattedMessage);
        buffer.append(System.lineSeparator()); // Add a newline after each log message
        currentFileSize += logEntrySize;
    }

    private void writeLog() throws IOException {
        if (buffer.length() > 0) { // Only write logs if the buffer is not empty
            fileWriter.append(buffer.toString());
            fileWriter.flush();
            buffer.setLength(0);
        }
    }

    private void createNewLogFile() throws IOException {
        if (fileWriter != null) {
            fileWriter.close();
        }

        // Create a new log file with a unique timestamp
        String newFilePath = getUniqueFileName();
        this.fileWriter = new FileWriter(newFilePath, true);
        currentFileSize = 0;
    }

    private String getUniqueFileName() {
        String fileName = config.getFilePath();
        int dotIndex = fileName.lastIndexOf(".");
        String name = fileName.substring(0, dotIndex);
        String extension = fileName.substring(dotIndex);
        long currentTimeMillis = System.currentTimeMillis();
        String uniqueFileName = name + "_" + currentTimeMillis + extension;
        return uniqueFileName;
    }

    public void close() throws IOException {
        writeLog();
        fileWriter.close();
    }
}
