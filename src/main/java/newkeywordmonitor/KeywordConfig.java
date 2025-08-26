package newkeywordmonitor;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

public class KeywordConfig {
    public static List<KeywordRule> build(){
        return List.of(
                new KeywordRule.Builder().keyword("ERROR").level(Level.SEVERE).build(),
                new KeywordRule.Builder().keyword("FAIL").level(Level.SEVERE).build(),
                new KeywordRule.Builder().keyword("CRITICAL").level(Level.SEVERE).build(),
                new KeywordRule.Builder().keyword("WARNING").level(Level.WARNING).build(),
                new KeywordRule.Builder().keyword("SUSPICIOUS").level(Level.WARNING).build(),
                new KeywordRule.Builder().keyword("DEPRECATED").level(Level.WARNING).build(),
                new KeywordRule.Builder().keyword("INFO").level(Level.INFO).build(),
                new KeywordRule.Builder().keyword("NOTE").level(Level.INFO).build(),
                new KeywordRule.Builder().keyword("LOG").level(Level.INFO).build()
        );
    }
}
