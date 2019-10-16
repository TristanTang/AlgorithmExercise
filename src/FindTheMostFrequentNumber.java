import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 查找出现次数最多的数字
 * @author Tristan
 */
public class FindTheMostFrequentNumber {

    private static Integer findTheMostFrequentNumber(List<Integer> numberList) {
        Integer result = null;
        if(numberList!=null && !numberList.isEmpty()) {
            Map<Integer, Integer> counterMap = new HashMap<>();
            Integer mostFrequency = 0;
            int tmpFrequency;
            for(Integer number : numberList) {
                if(counterMap.containsKey(number)) {
                    tmpFrequency = counterMap.get(number) + 1;
                } else {
                    tmpFrequency = 1;
                }
                counterMap.put(number, tmpFrequency);
                if(tmpFrequency>mostFrequency) {
                    mostFrequency = tmpFrequency;
                    result = number;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> numberList = new ArrayList<>();
        numberList.add(0);
        numberList.add(1);
        numberList.add(2);
        numberList.add(2);
        numberList.add(2);
        numberList.add(1);
        numberList.add(1);
        numberList.add(1);
        System.out.println(findTheMostFrequentNumber(numberList));
    }
}
