import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: AlgorithmExercise
 * @description: 1313.We are given a list nums of integers representing a list compressed with run-length encoding.  Consider each adjacent pair of elements [a, b] = [nums[2*i], nums[2*i+1]] (with i >= 0).  For each such pair, there are a elements with value b in the decompressed list.  Return the decompressed list.
 * @author: TangWang
 * @create: 2020-01-30 09:03
 **/
@SuppressWarnings("all")
public class DecompressRunLengthEncodedList {

    public int[] decompressRLElist(int[] nums) {
        return method2(nums);
    }

    /***
     * firstly, iterate through the array to get the length of the result array;
     * secondly, allocate an array;
     * finally, assign the array;
     * Runtime: 2 ms, faster than 71.79% of Java online submissions for Decompress Run-Length Encoded List.
     * Memory Usage: 45.1 MB, less than 100.00% of Java online submissions for Decompress Run-Length Encoded List.
     */
    private int[] method1(int[] nums) {
        boolean isCount = true;
        int index = 0;
        int currentCount=0;
        int currentNumber;
        // 获得数组长度
        int sumCount = 0;
        while(index<nums.length) {
            if (isCount) {
                // 当前数字是个数
                sumCount += nums[index];
            }
            index++;
            isCount = !isCount;
        }
        int[] result = new int[sumCount];
        // 遍历，赋值
        index = 0;
        isCount = true;
        int resultIndex = 0;
        while(index<nums.length) {
            if(isCount) {
                currentCount = nums[index];
            } else {
                currentNumber = nums[index];
                for(int i=0; i<currentCount; i++) {
                    result[resultIndex]=currentNumber;
                    resultIndex++;
                }
            }
            index++;
            isCount=!isCount;
        }
        return result;
    }

    /***
     * Runtime: 21 ms, faster than 5.17% of Java online submissions for Decompress Run-Length Encoded List.
     * Memory Usage: 46.9 MB, less than 100.00% of Java online submissions for Decompress Run-Length Encoded List.
     * @param nums
     * @return int[]
     * @author TangWang
     * @date 2020/1/30 09:40
     */
    private int[] method2(int[] nums) {
        List<Integer> numberList = new LinkedList<>();
        boolean isCount = true;
        int currentCount=0;
        for (int number : nums) {
            if(isCount) {
                currentCount = number;
            } else {
                for(int i=0; i<currentCount; i++) {
                    numberList.add(number);
                }
            }
            isCount=!isCount;
        }
        return Arrays.stream(numberList.toArray(new Integer[numberList.size()])).mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        DecompressRunLengthEncodedList decompressRunLengthEncodedList = new DecompressRunLengthEncodedList();
        int[] nums = {1,2,3,4};
        System.out.println(decompressRunLengthEncodedList.decompressRLElist(nums));
    }
}
