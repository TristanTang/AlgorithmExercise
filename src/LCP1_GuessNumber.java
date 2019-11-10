/**
 * @ClassName LCP1_GuessNumber
 * @Description LCP1.猜数字
 * @Author Tristan
 * @Date 2019/10/16 19:41
 * @Version 1.0
 **/
public class LCP1_GuessNumber {
    public int game(int[] guess, int[] answer) {
        int result = 0;
        for(int i=0; i<3; i++) {
            if(guess[i]==answer[i]) {
                result+=1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] guess = new int[]{2,2,3};
        int[] answer = new int[]{3,2,1};
        LCP1_GuessNumber lcp1_guessNumber = new LCP1_GuessNumber();
        System.out.println(lcp1_guessNumber.game(guess, answer));
    }
}
