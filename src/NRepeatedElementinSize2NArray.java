/**
 * @program: AlgorithmExercise
 * @description: 961.In a array A of size 2N, there are N+1 unique elements, and exactly one of these elements is repeated N times.  Return the element repeated N times.
 * @author: TangWang
 * @create: 2019-11-11 15:53
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for N-Repeated Element in Size 2N Array.
 * Memory Usage: 39.2 MB, less than 100.00% of Java online submissions for N-Repeated Element in Size 2N Array.
 **/
@SuppressWarnings("all")
public class NRepeatedElementinSize2NArray {

    /**
     * @description 利用抽屉原理，总能从相邻的 3 个位置中找到相同的元素，直接返回即可
     * @param A 原始数组
     * @return int 重复出现的元素
     * @author TangWang
     * @date 2019/11/11 15:54
     */
    public int repeatedNTimes(int[] A) {
        int first = A[0];
        int second = A[1];
        for(int i=2; i<A.length; i++) {
            int cur = A[i];
            if(cur==first || cur==second) {
                return cur;
            } else {
                first = second;
                second = cur;
            }
        }
        // 没找到的话，就只能是收尾两个位置的元素是重复的
        return A[0];
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,3};
        NRepeatedElementinSize2NArray nRepeatedElementinSize2NArray = new NRepeatedElementinSize2NArray();
        System.out.println(nRepeatedElementinSize2NArray.repeatedNTimes(array));
    }
}
