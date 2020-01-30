/**
 * @program: AlgorithmExercise
 * @description: 1221.Balanced strings are those who have equal quantity of 'L' and 'R' characters.  Given a balanced string s split it in the maximum amount of balanced strings.  Return the maximum amount of splitted balanced strings.
 * @author: TangWang
 * @create: 2019-11-11 10:57
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Split a String in Balanced Strings.
 * Memory Usage: 34.2 MB, less than 100.00% of Java online submissions for Split a String in Balanced Strings.
 **/
@SuppressWarnings("all")
public class SplitaStringinBalancedSubstrings {

    /***
     * @description 从前往后遍历 s，当发现字符 L 和 R 的数量相等时，就算一个满足条件的子字符串
     * @param s 完整字符串
     * @return int 合格的子字符串的数量
     * @author TangWang
     * @date 2019/11/11 10:59
     */
    public int method1(String s) {
        int count = 0;
        // 字符 L 比 R 多的数量
        int lMoreThanR = 0;
        for(char c : s.toCharArray()) {
            if(c=='L') {
                lMoreThanR += 1;
            } else {
                lMoreThanR -= 1;
            }
            if(lMoreThanR==0) {
                count += 1;
            }
        }
        return count;
    }

    public int balancedStringSplit(String s) {
        return method1(s);
    }

    public static void main(String[] args) {
        String s = "RLRRLLRLRL";
        SplitaStringinBalancedSubstrings splitaStringinBalancedSubstrings = new SplitaStringinBalancedSubstrings();
        System.out.println(splitaStringinBalancedSubstrings.balancedStringSplit(s));
    }
}
