package keywordmonitor;

import java.io.IOException;
import java.util.Map;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        try {

            FileHandler fh = new FileHandler("keywordmonitor.log", true);
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);

            KeywordMonitorService monitor = new KeywordMonitorService();

            // Keyword → Level Map
            Map<String, Level> forbiddenKeywords = Map.of(
                    "ERROR", Level.SEVERE,
                    "FAIL", Level.SEVERE,
                    "CRITICAL", Level.SEVERE,
                    "WARNING", Level.WARNING,
                    "SUSPICIOUS", Level.WARNING,
                    "DEPRECATED", Level.WARNING,
                    "INFO", Level.INFO,
                    "NOTE", Level.INFO,
                    "LOG", Level.INFO
            );

            monitor.checkFile("src/main/resources/test.txt", forbiddenKeywords, logger);

        } catch (IOException e) {
            logger.log(Level.SEVERE, "File or Logger error: " + e.getMessage());
        } catch (NotValidException e) {
            logger.log(Level.SEVERE, "Detected keywords:\n" + e.getMessage());
        }
    }
}
