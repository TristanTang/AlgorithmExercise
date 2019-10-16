import java.util.Arrays;
import java.util.HashSet;

public class UniqueMorseCodeWords {
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
