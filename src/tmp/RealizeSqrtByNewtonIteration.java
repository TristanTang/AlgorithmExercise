package tmp;

/**
 * 通过牛顿迭代法求平方根
 * 思路：
 *  1.求 m 的平方根，相当于求 x^2-m=0， 也就是 y=x^2-m 与 x轴 的交点
 *  2.牛顿迭代的思路是从某个点开始计算切线，然后求这条切线与 x轴的交点，即为下一个点。
 *  3.切线方程： y-f(xn) = f'(xn)(x-xn)。当 y = 0，可以得到 xn+1 = xn - f(xn)/f'(xn)
 */
public class RealizeSqrtByNewtonIteration {
    public static double mySqrt(double number) {
        double ERROR = Math.pow(10,-8);
        double x1 = number;
        double x2;
        int round = 0;
        while(true) {
            x2 = x1/2 + number/(2*x1);
            if(Math.abs(x1-x2) < ERROR) {
                break;
            }
            round += 1;
            x1 = x2;
        }
        System.out.println("Newton, round:" + round);
        return x2;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(10000));
    }
}
