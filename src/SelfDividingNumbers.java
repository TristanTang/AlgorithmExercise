import java.util.ArrayList;
import java.util.List;

/**
 * @program: AlgorithmExercise
 * @description: 728.A self-dividing number is a number that is divisible by every digit it contains.  For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.  Also, a self-dividing number is not allowed to contain the digit zero.  Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.
 * @author: TangWang
 * @create: 2019-11-12 17:02
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Self Dividing Numbers.
 * Memory Usage: 34 MB, less than 30.00% of Java online submissions for Self Dividing Numbers.
 **/
@SuppressWarnings("all")
public class SelfDividingNumbers {

    public List<Integer> selfDividingNumbers(int left, int right) {
        return method1(left, right);
    }

    /**
     * @description 遍历 left 到 right 的数字，判断每一个数字是否能够被它包含的数整除。如果能整除，就添加到结果中。
     * @param left 左边界
     * @param right 右边界
     * @return java.util.List<java.lang.Integer>
     * @author TangWang
     * @date 2019/11/12 17:17
     */
    public List<Integer> method2(int left, int right) {
        List<Integer> result = new ArrayList<>();
        int eachNum;
        int tmpNum;
        boolean sign;
        for(int num=left; num<=right; num++) {
            sign = true;
            tmpNum = num;
            while(tmpNum>0) {
                eachNum = tmpNum % 10;
                if (eachNum==0 || num%eachNum!=0) {
                    sign = false;
                    break;
                }
                tmpNum /= 10;
            }
            if(sign) {
                result.add(num);
            }

        }
        return result;
    }

    /**
     * @description 遍历 left 到 right 的数字，判断每一个数字是否能够被它包含的数整除。如果能整除，就添加到结果中。
     * @param left 左边界
     * @param right 右边界
     * @return java.util.List<java.lang.Integer>
     * @author TangWang
     * @date 2019/11/12 17:17
     */
    public List<Integer> method1(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for(int num=left; num<=right; num++) {
            if(canBeDevided(num)) {
                result.add(num);
            }
        }
        return result;
    }

    /**
     * @description 判断某个整数是否能够被它包含的数字整除
     * @param num 输入的整数
     * @return boolean 如果能够整除，就返回 True； 否则返回 false;
     * @author TangWang
     * @date 2019/11/12 17:16
     */
    private boolean canBeDevided(int num) {
        int eachNum;
        int initialNum = num;
        while(num>0) {
            eachNum = num % 10;
            if (eachNum==0 || initialNum%eachNum!=0) {
                return false;
            }
            num /= 10;
        }
        return true;
    }

    public static void main(String[] args) {
        SelfDividingNumbers selfDividingNumbers = new SelfDividingNumbers();
        System.out.println(selfDividingNumbers.selfDividingNumbers(1, 22));
    }
}
