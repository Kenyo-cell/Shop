package Loggers;

public class FileLogger extends Logger{
    protected String path;
    // SRP - FileLogger used only for logging info to file
    // LSP - FileLogger is next stage extending Logger class
    public Logger getInstance(String path) {
        if (instance == null) {
            instance = new FileLogger(path);
        }
        return instance;
    }
    private FileLogger(String path) {
        this.path = path;
    }

    @Override
    public void log(String message) {

    }
}
