package problems;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by leon on 9/11/17.
 */
public class DecodeString {
    public String decodeString(String s) {
        if(s == null || s.length() == 0) return "";
        Deque<String> s1 = new LinkedList<>();
        Deque<Integer> s2 = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        int i = 0;
        while(i < s.length()) {
            int count = 0;
            while(s.charAt(i) >= '0' && s.charAt(i) <= '9' ) {
                count = count * 10 + (s.charAt(i++) - '0');
            }
            if(s.charAt(i) == '[') {
                s2.offerFirst(count);
                i++;
            }

            StringBuilder sb = new StringBuilder();
            while(i < s.length() && isLetter(s, i)) {
                sb.append(s.charAt(i++));
            }
            s1.offerFirst(sb.toString());

            while(i < s.length() && s.charAt(i) == ']') {
                i++;
                String temp = s1.pollFirst() + res.toString();
                int num = s2.pollFirst();
                res.setLength(0);
                while(num > 0 && temp.length() > 0) {
                    res.append(temp);
                    num--;
                }
                while(i < s.length() && isLetter(s, i)) {
                    res.append(s.charAt(i++));
                }
            }
        }

        return res.toString();
    }

    private boolean isLetter(String s, int i) {
        return s.charAt(i) >= 'a' && s.charAt(i) <= 'z' || s.charAt(i) >= 'A' && s.charAt(i) <= 'Z';
    }
}
