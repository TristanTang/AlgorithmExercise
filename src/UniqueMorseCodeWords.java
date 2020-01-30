import java.util.HashSet;

/**
 * @program: AlgorithmExercise
 * @description: 将输入的字符串中的字符转成摩尔斯码表示，然后查看字符串中有多少个不同的表示
 * @author: TangWang
 * @create: 2019-10-16 16:37
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Unique Morse Code Words.
 * Memory Usage: 35.4 MB, less than 100.00% of Java online submissions for Unique Morse Code Words.
 **/
@SuppressWarnings("all")
public class UniqueMorseCodeWords {

    /**
     * @Description 输入字符串输入，返回字符串数组转为莫尔斯码表示后的种类
     * @param words 字符串数组
     * @Return int 不同的莫尔斯码表示的数量
     * @Author WangTang
     * @Date 2019/10/16 16:40
     */
    public static int uniqueMorseRepresentations(String[] words) {
        if(words==null || words.length==0) {
            return 0;
        }
        String[] characterMap = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet wordsSet = new HashSet();
        for(String word : words) {
            StringBuilder stringBuilder = new StringBuilder();
            char[] character = word.toCharArray();
            for(char c : character) {
                stringBuilder.append(characterMap[c-'a']);
            }
            wordsSet.add(stringBuilder.toString());
        }
        return wordsSet.size();
    }

    public static void main(String[] args) {
        String[] words = new String[]{"gin", "zen", "gig", "msg"};
        System.out.println(uniqueMorseRepresentations(words));
    }
}
