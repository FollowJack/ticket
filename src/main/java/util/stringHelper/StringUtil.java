package util.stringHelper;

/**
 * Created by Deniel on 30.10.2014.
 */
public class StringUtil {
    public static boolean isNullOrWhiteSpace(String string){
        return string == null || isWhiteSpace(string);
    }

    private static boolean isWhiteSpace(String string) {
        int length = string.length();
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                if (!Character.isWhitespace(string.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
