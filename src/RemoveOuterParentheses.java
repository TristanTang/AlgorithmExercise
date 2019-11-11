/**
 * @ClassName RemoveOuterParentheses
 * @Description 删除最外层括号，1021
 * @Author TangWang
 * @Date 2019/10/16 22:45
 * @Version 1.0
 * Runtime: 2 ms, faster than 98.30% of Java online submissions for Remove Outermost Parentheses.
 * Memory Usage: 37.2 MB, less than 93.51% of Java online submissions for Remove Outermost Parentheses.
 **/
public class RemoveOuterParentheses {

    public String removeOuterParentheses(String S) {
        if(S==null || S.length()==0){
            return S;
        }
        return method2(S);
    }

    /**
     * @description 通过计数过滤到最外层括号，其他通过使用 StringBuild 拼接到新字符串中
     * @param S 原始字符串
     * @return 去除最外层括号的字符串
     * @author TangWang
     * @date 2019/11/11 14:48
     */
    public String method1(String S) {
        StringBuilder result = new StringBuilder();
        int leftCount = 0;
        for(char parenthes : S.toCharArray()) {
            if(parenthes=='('){
                if(leftCount>0) {
                    result.append(parenthes);
                }
                leftCount+=1;
            } else {
                leftCount-=1;
                if(leftCount>0) {
                    result.append(parenthes);
                }
            }
        }
        return result.toString();
    }

    /**
     * @description 通过计数存储最外层括号的坐标位置，其他通过 substring 得到，然后一次性复制。
     * @param S 原始字符串
     * @return 去除最外层括号的字符串
     * @author TangWang
     * @date 2019/11/11 14:56
     */
    public String method2(String S) {
        StringBuilder result = new StringBuilder();
        int length = S.length();
        int leftPosition = 0;
        int lMoreThanR = 0;
        int currentPosition = 0;
        while(currentPosition<length) {
            // 记录左括号位置
            leftPosition = currentPosition;
            lMoreThanR = 1;
            currentPosition+=1;
            // 找到右括号的位置
            while(currentPosition<length) {
                if(S.charAt(currentPosition)=='(') {
                    lMoreThanR+=1;
                    currentPosition++;
                } else {
                    lMoreThanR-=1;
                    if(lMoreThanR==0) {
                        break;
                    }
                    currentPosition++;
                }
            }
            // 截取拼接
            result.append(S.substring(leftPosition+1, currentPosition));
            currentPosition += 1;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String input = "(()())(())";
        RemoveOuterParentheses removeOuterParentheses = new RemoveOuterParentheses();
        System.out.println(removeOuterParentheses.removeOuterParentheses(input));
    }
}
