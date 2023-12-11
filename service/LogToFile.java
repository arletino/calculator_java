package service;

import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.SimpleFormatter;

public class LogToFile {
    
    public static Logger logger = Logger.getAnonymousLogger();

    public LogToFile(String path) {
        try {
            FileHandler fileHandler = new FileHandler("log1.txt", true);
            SimpleFormatter simpleFormatter = new SimpleFormatter();
            fileHandler.setFormatter(simpleFormatter);
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public LogToFile() {
        this ("log.txt");
    }

    public void info(String str){
        logger.info(str);
    }
    public void warning(String str){
        logger.warning(str);
    }
    public void finest(String str){
        logger.finest(str);
    }

    public void closeLogger() {
       Handler[] temp = logger.getHandlers(); 
        for (Handler handler : temp) {
            handler.close();            
        }
    }
    
}
