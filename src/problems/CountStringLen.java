package problems;

import java.util.List;

/**
 * Created by leon on 8/31/17.
 */
public class CountStringLen {
    public int getBytesLen(List<String> data) {
        int len = 0;
        int lineBreakLen = length(System.lineSeparator());
        for(String s : data) {
            len += (length(s) + lineBreakLen);
        }
        return len;
    }

    private static int length(CharSequence sequence) {
        int count = 0;
        for (int i = 0, len = sequence.length(); i < len; i++) {
            char ch = sequence.charAt(i);
            if (ch <= 0x7F) {
                count++;
            } else if (ch <= 0x7FF) {
                count += 2;
            } else if (Character.isHighSurrogate(ch)) {
                count += 4;
                ++i;
            } else {
                count += 3;
            }
        }
        return count;
    }
}
