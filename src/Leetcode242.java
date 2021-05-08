import java.util.Arrays;

/**
 * @author lizehui
 * @date 2021/3/29 15:04
 */
public class Leetcode242 {
    public boolean isAnagram(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(tc);
        return Arrays.equals(sc, tc);
    }
}
