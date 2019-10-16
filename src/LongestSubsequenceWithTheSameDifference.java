import java.util.*;

public class LongestSubsequenceWithTheSameDifference {

    /**
     *
     * @param numberSequence
     * @return
     */
    private static int findMaxLength(List<Integer> numberSequence, int difference) {
        int result = 1;
        System.out.println("序列：" + numberSequence.toString() + "，差值：" + difference);
        HashSet<Integer> numberSet = new HashSet<>();
        HashMap<Integer, HashSet> numberGroups = new HashMap<>();
        for(int number : numberSequence) {
            numberSet.add(number);
            HashSet numberGroup = new HashSet();
            numberGroup.add(number);
            numberGroups.put(number, numberGroup);
        }

        Iterator<Integer> iterator = numberSet.iterator();
        while(iterator.hasNext()){
            int number = iterator.next();
            int theOtherNumber = number+difference;
            if(numberSet.contains(theOtherNumber)) {
                HashSet numberGroup1 = numberGroups.get(number);
                HashSet numberGroup2 = numberGroups.get(theOtherNumber);
                numberGroup1.addAll(numberGroup2);
                numberGroups.put(number, numberGroup1);
                numberGroups.put(theOtherNumber, numberGroup1);
                result = Math.max(result, numberGroup1.size());
            }
        }
        System.out.println("最长等差子序列长度：" + result);
        return result;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3,0,-3,4,-4,7,6);
        int difference = 3;
        findMaxLength(numbers, difference);
    }
}
