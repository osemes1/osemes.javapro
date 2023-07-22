package logger;


class FileLoggerConfiguration {
    private String filePath;
    private String logDirectory;
    private LoggingLevel loggingLevel;
    private long maxFileSize;
    private String logFormat;

    public FileLoggerConfiguration(String filePath, String logDirectory, LoggingLevel loggingLevel, long maxFileSize, String logFormat) {
        this.filePath = filePath;
        this.logDirectory = logDirectory;
        this.loggingLevel = loggingLevel;
        this.maxFileSize = maxFileSize;
        this.logFormat = logFormat;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getLogDirectory() {
        return logDirectory;
    }

    public LoggingLevel getLoggingLevel() {
        return loggingLevel;
    }

    public long getMaxFileSize() {
        return maxFileSize;
    }

    public String getLogFormat() {
        return logFormat;
    }

}
