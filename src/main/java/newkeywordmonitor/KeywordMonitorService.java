package newkeywordmonitor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class KeywordMonitorService {

    public void checkFile(String filePath, List<KeywordRule> rules, Logger logger)
            throws IOException, NotValidException {

        List<String> errors = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 1;

            while ((line = br.readLine()) != null) {
                String finalLine = line;
                int finalLineNumber = lineNumber;

               /* rules.stream()
                        .filter(rule -> finalLine.contains(rule.getKeyword()))
                        .map(rule -> LineMessageConverter.toLineMessage(finalLineNumber, rule.getKeyword()))
                        .forEach(errors::add); */

                for (KeywordRule rule : rules) {
                    if (line.contains(rule.getKeyword())) {
                        String message = "Line " + lineNumber + ": \"" + rule.getKeyword() + "\" found.";
                        errors.add(message);
                        logger.log(rule.getLevel(), message);
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
