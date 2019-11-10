package tmp;

/**
 * 使用二分法求平方根
 */
public class RealizeSqrtByBisectionMethod {

    public static double mySqrt(double number){
        if (number<0.0) {
            throw new ArithmeticException();
        }
        int round = 0;
        double ERROR = Math.pow(10, -8);
        double leftBound = 0.0;
        double rightBound = number;
        double mid;
        double error;
        while(true) {
            mid = leftBound + (rightBound - leftBound)/2;
            error = mid*mid - number;
            if(Math.abs(error)<ERROR) {
                break;
            }
            if (error<0.0) {
                leftBound = mid;
            } else {
                rightBound = mid;
            }
            round++;
        }
        System.out.println("iteration round: " + round);
        return mid;
    }

    public static void main(String[] args) {
        double number = 10000.0;
        System.out.println(mySqrt(number));
    }
}
