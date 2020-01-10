/**
 * @program: AlgorithmExercise
 * @description: Given an integer number n, return the difference between the product of its digits and the sum of its digits.
 * @author: TangWang
 * @create: 2020-01-10 13:21
 **/

public class SubstractTheProductAndSumOfDigitsOfAnInteger {

    /***
     * Example：
     *  Input: n = 234
     *  Output: 15
     * Explanation:
     *  Product of digits = 2 * 3 * 4 = 24
     *  Sum of digits = 2 + 3 + 4 = 9
     *  Result = 24 - 9 = 15
     */


    /***
     * @description 方法 1：通过模和除 10，得到每一位的数字。
     * @param n 输入值
     * @return int n 中各数字的乘积与和之间的差
     * @author TangWang
     * @date 2020/1/10 13:24
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Subtract the Product and Sum of Digits of an Integer.
     * Memory Usage: 32.7 MB, less than 100.00% of Java online submissions for Subtract the Product and Sum of Digits of an Integer.
     */
    public int method1(int n) {
        int product = 1;
        int sum = 0;
        int currentNumber;
        while(n>0) {
            currentNumber = n%10;
            sum += currentNumber;
            product *= currentNumber;
            n /= 10;
        }
        return product - sum;
    }

    public int subtractProductAndSum(int n) {
        return method1(n);
    }

    public static void main(String[] args) {
        SubstractTheProductAndSumOfDigitsOfAnInteger substractTheProductAndSumOfDigitsOfAnInteger = new SubstractTheProductAndSumOfDigitsOfAnInteger();
        int n = 234;
        System.out.println(substractTheProductAndSumOfDigitsOfAnInteger.subtractProductAndSum(n));
    }
}
