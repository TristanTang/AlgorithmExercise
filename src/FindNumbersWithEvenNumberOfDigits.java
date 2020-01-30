/**
 * @program: AlgorithmExercise
 * @description: 1295. Find Numbers with Even Number of Digits.Given an array nums of integers, return how many of them contain an even number of digits
 * @author: TangWang
 * @create: 2020-01-01 21:38
 **/
@SuppressWarnings("all")
public class FindNumbersWithEvenNumberOfDigits {

    /**
     * 返回 nums 数组中数字位数为偶数的数量
     * @param nums
     * @return
     */
    public int findNumbers(int[] nums) {
        return calculateDigital2(nums);
    }

    /**
     * 将数字转为字符串，然后看字符串长度
     * Runtime: 2 ms, faster than 36.90% of Java online submissions for Find Numbers with Even Number of Digits.
     * Memory Usage: 39 MB, less than 100.00% of Java online submissions for Find Numbers with Even Number of Digits.
     * @param nums
     * @return
     */
    private int calculateByString(int[] nums) {
        int result = 0;
        for(int num : nums) {
            String tmp = String.valueOf(num);
            if(tmp.length()%2==0){
                result+=1;
            }
        }
        return result;
    }

    /**
     * 思路：一直除以10，直到等于0，除的次数就是长度
     * Runtime: 1 ms, faster than 96.58% of Java online submissions for Find Numbers with Even Number of Digits.
     * Memory Usage: 38.6 MB, less than 100.00% of Java online submissions for Find Numbers with Even Number of Digits.
     * @param nums
     * @return
     */
    private int calculateByDigital(int[] nums) {
        int result = 0;
        for(int num : nums) {
            int length = 1;
            while(true) {
                num /= 10;
                if(num==0) {
                    break;
                }
                length+=1;
            }
            if(length%2==0) {
                result += 1;
            }
        }
        return result;
    }

    /**
     * 思路：初始化为1，一直乘以10，直到大于num
     * Runtime: 1 ms, faster than 96.58% of Java online submissions for Find Numbers with Even Number of Digits.
     * Memory Usage: 38.6 MB, less than 100.00% of Java online submissions for Find Numbers with Even Number of Digits.
     * @param nums
     * @return
     */
    private int calculateDigital1(int[] nums) {
        int result = 0;
        boolean isEven = false;
        for(int num : nums) {
            isEven = false; // 最初默认长度为1，所以不是偶数
            int tmp = 1;
            while(true) {
                tmp *= 10;
                if(tmp>num) {
                    break;
                }
                // 每次长度+1,奇偶性变换一次
                isEven = !isEven;
            }
            if(isEven) {
                result += 1;
            }
        }
        return result;
    }

    /**
     * 结合约束来进行判断，从而避免乘除法
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Numbers with Even Number of Digits.
     * Memory Usage: 38.4 MB, less than 100.00% of Java online submissions for Find Numbers with Even Number of Digits
     * @param nums
     * @return
     */
    private int calculateDigital2(int[] nums) {
        int BREAK_POINT0 = 10;
        int BREAK_POINT1 = 100;
        int BREAK_POINT2 = 1000;
        int BREAK_POINT3 = 10000;
        int result = 0;
        for(int num : nums) {
            if((num>= BREAK_POINT0 && num<BREAK_POINT1)
            || (num>=BREAK_POINT2 && num<BREAK_POINT3)
            || num==100000) {
                result += 1;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] numbers = {12, 345, 2, 6, 7896};

        FindNumbersWithEvenNumberOfDigits findNumbersWithEvenNumberOfDigits = new FindNumbersWithEvenNumberOfDigits();
        System.out.println(findNumbersWithEvenNumberOfDigits.findNumbers(numbers));
    }
}