package cn.maxcj.util;

/**
 * @author maxcj
 */
public class SqlUtil {
    private static int count = 0;


    public static int countStr(String str1, String str2) {
        if (!str1.contains(str2)) {
            return 0;
        } else if (str1.contains(str2)) {
            count++;
            countStr(str1.substring(str1.indexOf(str2) + str2.length()), str2);
        }
        return count;
    }
}
