import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: FindTheMostFrequentNumber
 * @description: 查找出现次数最多的数字
 * @author: WangTang
 * @create: 2019-10-16 16:37
 **/
@SuppressWarnings("all")
public class FindTheMostFrequentNumber {

    /**
     * @Description 输入数字列表，返回出现次数最多的数字
     * @param numberList 输入的数字列表
     * @Return java.lang.Integer 出现次数最多的数字
     * @Author WangTang
     * @Date 2019/10/16 17:24
     */
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
