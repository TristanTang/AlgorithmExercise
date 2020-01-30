/**
 * 压缩字符串
 * 字符串压缩：当输入连续相同的字符时，通过“次数+字符”的形式进行压缩，例如输入“abcaaabbc”，返回“abc3a2bc”，如果输入“aaaaaa”，返回“6a”，如果输入“abcabc”，则返回“abcabc”；
 * @author Tristan
 */
@SuppressWarnings("all")
public class CompressString {

    /**
     * 压缩字符串操作
     * @param inputString 输入字符串
     * @return 压缩后的字符串
     */
    private static String handler(String inputString) {
        StringBuffer stringBuffer = new StringBuffer();
        if(inputString.length()>0) {
            int segmentLength = 1;
            // 前面的片段
            for(int i=1; i<inputString.length(); i++) {
                if (inputString.charAt(i) == inputString.charAt(i-1)) {
                    segmentLength += 1;
                } else {
                    appendCompressedString(stringBuffer, segmentLength, inputString.charAt(i-1));
                    segmentLength = 1;
                }
            }
            // 最后一个片段
            appendCompressedString(stringBuffer, segmentLength, inputString.charAt(inputString.length()-1));
        }
        return stringBuffer.toString();
    }

    /**
     * 将字符添加到字符串中
     * @param addToString 最终字符串
     * @param character 新字符
     * @param counter 新字符出现的次数
     */
    private static void appendCompressedString(StringBuffer addToString, int counter, char character) {
        if (counter > 1) {
            addToString.append(counter);
            addToString.append(character);
        } else {
            addToString.append(character);
        }
    }

    public static void main(String[] args) {
        String inputString = "abc";
        System.out.println(handler(inputString));
        inputString = "abcaaabbc";
        System.out.println(handler(inputString));
        inputString = "aaaaaa";
        System.out.println(handler(inputString));
    }
}
