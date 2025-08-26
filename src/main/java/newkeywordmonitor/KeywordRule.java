package newkeywordmonitor;

import java.util.logging.Level;

public class KeywordRule {
    private final String keyword;
    private final Level level;

    private KeywordRule(Builder builder) {
        this.keyword = builder.keyword;
        this.level = builder.level;
    }

    public String getKeyword() {
        return keyword;
    }
    public Level getLevel() {
        return level;
    }

    public static class Builder {
        private String keyword;
        private Level level;

        public Builder keyword(String keyword) {
            this.keyword = keyword;
            return this;
        }

        public Builder level(Level level) {
            this.level = level;
            return this;
        }

        public KeywordRule build() {
            return new KeywordRule(this);
        }
    }
}
