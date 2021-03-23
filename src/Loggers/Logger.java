package Loggers;

import java.util.Date;

public abstract class Logger {
    protected Date date;
    protected Logger instance = null;


    void log(String message) {
        date = new Date();
        System.out.println(String.format("[%s]: %s", date, message));
    }
}
