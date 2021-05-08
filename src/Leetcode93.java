import java.util.ArrayList;
import java.util.List;

/**
 * @author lizehui
 * @date 2021/5/7 17:01
 */
public class Leetcode93 {
    private List<String> result = new ArrayList<>();

    private List<String> path = new ArrayList<>();

    private String s;

    public List<String> restoreIpAddresses(String s) {
        this.s = s;
        backTracking(0, 0);
        return result;
    }

    private void backTracking(int startIndex, int num) {
        if (num > 4) {
            return;
        }
        if (num == 4 && startIndex == s.length()) {
            result.add(String.join(".", path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (check(s.substring(startIndex, i + 1))) {
                path.add(s.substring(startIndex, i + 1));
                num++;
                backTracking(i + 1, num);
                num--;
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean check(String c) {
        if (!"0".equals(c) && c.charAt(0) == '0') {
            return false;
        }
        try {
            int temp = Integer.parseInt(c);
            if (temp >= 0 && temp <= 255) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public static void main(String[] args) {
        new Leetcode93().restoreIpAddresses("25525511135");
    }
}
