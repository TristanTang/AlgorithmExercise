import java.util.*;

/**
 * @program: LongestSubsequenceWithTheSameDifference
 * @description: 最长子序列的长度，LeetCode 1218
 * @author: WangTang
 * @create: 2019-10-16 16:37
 **/
@SuppressWarnings("all")
public class LongestSubsequenceWithTheSameDifference {

    /**
     * @Description 查找从前往后最长子序列的长度
     * @param arr 数组
     * @param difference 子序列前一个 + difference = 子序列后一个
     * @Return int 最长递增子序列的长度
     * @Author WangTang
     * @Date 2019/10/16 16:46
     */
    private static int findMaxLength(int[] arr, int difference) {
        int result = 1;
        HashSet<Integer> numberSet = new HashSet<>();
        HashMap<Integer, Integer> numberLength = new HashMap<>();
        for(int number : arr) {
            numberSet.add(number);
            numberLength.put(number, 1);
        }

        Iterator<Integer> iterator = numberSet.iterator();
        while(iterator.hasNext()){
            int number = iterator.next();
            int theOtherNumber = number+difference;
            if(numberSet.contains(theOtherNumber)) {
                int newLength = numberLength.get(number) + numberLength.get(theOtherNumber);
                numberLength.put(number, newLength);
                numberLength.put(theOtherNumber, newLength);
                result = Math.max(newLength, result);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{1,5,7,8,5,3,4,2,1};
        int difference = -2;
        System.out.println(findMaxLength(numbers, difference));
    }
}
