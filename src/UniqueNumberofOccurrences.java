import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: AlgorithmExercise
 * @description: 1207.Given an array of integers arr, write a function that returns true if and only if the number of occurrences of each value in the array is unique.
 * @author: TangWang
 * @create: 2019-11-11 16:16
 **/

public class UniqueNumberofOccurrences {

    /**
     * @description 判断 arr 中元素的出现次数是否都不一样。如果都不一样就返回 true，否则返回 false
     * @param arr 原始数组
     * @return boolean
     * @author TangWang
     * @date 2019/11/11 16:17
     */
    public boolean uniqueOccurrences(int[] arr) {
        return method1(arr);
    }

    /**
     * @description 思路 1：使用 HashMap 统计每个元素出现的次数；2.如果元素数量和元素出现的次数的集合的数量一样，就表示出现的次数没有相同的
     * @param array
     * @return boolean
     * @author TangWang
     * @date 2019/11/11 16:19
     * Runtime: 2 ms, faster than 88.16% of Java online submissions for Unique Number of Occurrences.
     * Memory Usage: 35.9 MB, less than 100.00% of Java online submissions for Unique Number of Occurrences.
     */
    private boolean method1(int[] array) {
        // 先统计所有数字出现次数
        HashMap<Integer, Integer> numOccurrences = new HashMap<>();
        for(int num : array){
            // 如果不在 map 中，就默认返回0
            numOccurrences.put(num, numOccurrences.getOrDefault(num, 0) + 1);
        }
        // 如果 key 的数量和 value 的数量一样，表示出现的次数都不同
        int numCount = numOccurrences.size();
        Set occurrenceSet = new HashSet(numOccurrences.values());
        return numCount==occurrenceSet.size();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,2,1,1,3};
        UniqueNumberofOccurrences uniqueNumberofOccurrences = new UniqueNumberofOccurrences();
        System.out.println(uniqueNumberofOccurrences.uniqueOccurrences(arr));
    }
}
