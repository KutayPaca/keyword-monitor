package newkeywordmonitor;

import java.io.IOException;
import java.util.List;
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
            List<KeywordRule> rules = KeywordConfig.build();

            monitor.checkFile("src/main/resources/test.txt", rules, logger);

        } catch (IOException e) {
            logger.log(Level.SEVERE, "File or Logger error: " + e.getMessage());
        } catch (NotValidException e) {
            logger.log(Level.SEVERE, "Detected keywords:\n" + e.getMessage());
        }
    }
}
