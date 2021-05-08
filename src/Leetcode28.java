/**
 * @author lizehui
 * @date 2021/4/1 14:42
 */
public class Leetcode28 {
    void getNext(int[] next, char[] s) {
        int j = -1;
        next[0] = j;
        for(int i = 1; i < s.length; i++) { // 注意i从1开始
            while (j >= 0 && s[i] != s[j + 1]) { // 前后缀不相同了
                j = next[j]; // 向前回溯
            }
            if (s[i] == s[j + 1]) { // 找到相同的前后缀
                j++;
            }
            next[i] = j; // 将j（前缀的长度）赋给next[i]
        }
    }
    int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int[] next = new int[needle.length()];
        getNext(next, needle.toCharArray());
        int j = -1; // // 因为next数组里记录的起始位置为-1
        for (int i = 0; i < haystack.length(); i++) { // 注意i就从0开始
            while(j >= 0 && haystack.charAt(i) != needle.charAt(j+1)) { // 不匹配
                j = next[j]; // j 寻找之前匹配的位置
            }
            if (haystack.charAt(i) == needle.charAt(j+1)) { // 匹配，j和i同时向后移动
                j++;
            }
            if (j == (needle.length() - 1) ) { // 文本串s里出现了模式串t
                return (i - needle.length() + 1);
            }
        }
        return -1;
        //return haystack.indexOf(needle);
    }
}
