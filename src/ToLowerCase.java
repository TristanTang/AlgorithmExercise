/**
 * @program: AlgorithmExercise
 * @description: 709.Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
 * @author: TangWang
 * @create: 2019-11-11 11:06
 **/
@SuppressWarnings("all")
public class ToLowerCase {

    /***
     * @description 将字符串中的大写字幕转为小写
     * @param str 输入字符串
     * @return 转换后的字符串
     * @author TangWang
     * @date 2019/11/11 11:07
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for To Lower Case.
     * Memory Usage: 34.3 MB, less than 98.70% of Java online submissions for To Lower Case.
     */
    public String method1(String str) {
        if(str==null) {
            return null;
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            for(int i=0; i<str.length(); i++) {
                char character = str.charAt(i);
                if(character>='A' && character<='Z') {
                    stringBuffer.append((char)(character-'A'+'a'));
                } else {
                    stringBuffer.append(character);
                }
            }
            return stringBuffer.toString();
        }
    }

    public String toLowerCase(String str) {
        return method1(str);
    }

    public static void main(String[] args) {

        System.out.println();
    }
}
