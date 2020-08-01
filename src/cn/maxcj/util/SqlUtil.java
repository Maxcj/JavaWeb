package cn.maxcj.util;

/**
 * @author maxcj
 */
public class SqlUtil {

    public static int countStr(String str,String sToFind) {
        int num = 0;
        while (str.contains(sToFind)) {
            str = str.substring(str.indexOf(sToFind) + sToFind.length());
            num ++;
        }
        return num;
    }
}
