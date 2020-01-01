/**
 * @program: AlgorithmExercise
 * @description: 905.Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.  You may return any answer array that satisfies this condition.
 * @author: TangWang
 * @create: 2019-11-11 15:25
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Sort Array By Parity.
 * Memory Usage: 39.9 MB, less than 95.14% of Java online submissions for Sort Array By Parity.
 **/

public class SortArrayByParity {
    /**
     * @description 将数组中偶数都移到奇数前面
     * @param A 原始数组
     * @return int[] 偶数都在奇数前面的数组
     * @author TangWang
     * @date 2019/11/11 15:26
     */
    public int[] sortArrayByParity(int[] A) {
        if(A!=null && A.length>0) {
            method1(A);
        }
        return A;
    }

    /**
     * @description 思路 1：从后往前找偶数，找到一个就记录位置；从前往后找奇数，找到一个就记录位置；然后交换两个位置的元素位置；直到左右两个相遇；
     * @param array
     * @return void
     * @author TangWang
     * @date 2019/11/11 15:29
     */
    private void method1(int[] array) {
        int leftIndex = 0;
        int rightIndex = array.length-1;
        while(leftIndex<rightIndex){
            while(leftIndex<rightIndex && array[leftIndex]%2==0) {
                leftIndex++;
            }
            while(rightIndex>leftIndex && array[rightIndex]%2==1) {
                rightIndex--;
            }
            if(leftIndex<rightIndex) {
                int tmp = array[leftIndex];
                array[leftIndex] = array[rightIndex];
                array[rightIndex] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        SortArrayByParity sortArrayByParity = new SortArrayByParity();
        int[] array = new int[]{3,1,2,4};
        array = sortArrayByParity.sortArrayByParity(array);
        System.out.println(array);
    }
}
