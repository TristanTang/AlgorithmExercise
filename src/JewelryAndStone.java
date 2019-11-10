import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/**
 * @ClassName JewelryAndStone
 * @Description LeetCode 771.宝石与石头， 时间几百 99.98%，内存几百 90.87%
 * @Author Tristan
 * @Date 2019/10/16 19:48
 * @Version 1.0
 **/
public class JewelryAndStone {

    /**
     * @param J 表示宝石的字符串
     * @param S 表示拥有的石头的字符串
     * @return int S 中是宝石的数量
     * @Description 输入宝石J和石头S两个字符串，返回 S 中包含宝石书来给你
     * @date 19:49 2019/10/16
     * @author Tristan
     */
    public int numJewelsInStones(String J, String S) {
        if(S==null || J==null) {
            return 0;
        }
        int num = 0;

        boolean[] jewelArray = new boolean[52];
        for(char j : J.toCharArray()) {
            if(j>='a'&&j<='z') {
                jewelArray[j-'a'] = true;
            } else {
                jewelArray[j-'A' + 26] = true;
            }
        }
        for(char s : S.toCharArray()) {
            if(s>='a' && s<='z'&& jewelArray[s-'a']) {
                num+=1;
            } else if(s>='A' && s<='Z' && jewelArray[s-'A'+26]) {
                num+=1;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        String J = "aA";
        String S = "aAAbbbb";
        JewelryAndStone jewelryAndStone = new JewelryAndStone();
        System.out.println(jewelryAndStone.numJewelsInStones(J, S));
    }
}
