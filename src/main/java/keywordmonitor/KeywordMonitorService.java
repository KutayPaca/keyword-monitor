package keywordmonitor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KeywordMonitorService {

    public void checkFile(String filePath, Map<String, Level> forbiddenKeywords, Logger logger)
            throws IOException, NotValidException {

        List<String> errors = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 1;

            while ((line = br.readLine()) != null) {
                for (Map.Entry<String, Level> entry : forbiddenKeywords.entrySet()) {
                    String keyword = entry.getKey();
                    Level level = entry.getValue();

                    if (line.contains(keyword)) { // Büyük/küçük harf duyarlı
                        String message = "Line " + lineNumber + ": \"" + keyword + "\" found.";
                        errors.add(message);
                        logger.log(level, message); // hem terminal hem dosya
                    }
                }
                lineNumber++;
            }
        }

        System.out.println("File check completed.");

        if (!errors.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (String error : errors) {
                sb.append(error).append("\n");
            }
            throw new NotValidException(sb.toString());
        }
    }
}
