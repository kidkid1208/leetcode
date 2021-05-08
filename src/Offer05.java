/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * @author lizehui
 * @date 2021/3/31 17:01
 */
public class Offer05 {
    public String replaceSpace(String s) {
        char[] set = s.toCharArray();
        int count = 0;
        for (char c : set) {
            if (c == ' ') {
                count++;
            }
        }
        char[] newSet = new char[set.length + 2 * count];
        int pos = set.length - 1;
        int posn = newSet.length - 1;
        while (posn >= 0) {
            if (set[pos] == ' ') {
                newSet[posn--] = '0';
                newSet[posn--] = '2';
                newSet[posn--] = '%';
                pos--;
            }else {
                newSet[posn--] = set[pos--];
            }
        }
        return new String(newSet);
    }

    public static void main(String[] args) {
        System.out.println(new Offer05().replaceSpace("We are happy."));
    }
}
