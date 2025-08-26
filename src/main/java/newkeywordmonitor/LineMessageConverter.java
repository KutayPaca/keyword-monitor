package newkeywordmonitor;

import java.util.List;

public class LineMessageConverter {

    public static String toLineMessage(Integer lineNumber, String keyword){
        return  "Line " + lineNumber + ": \"" + keyword + "\" found.";
    }
}
