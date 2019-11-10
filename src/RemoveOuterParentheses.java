/**
 * @ClassName RemoveOuterParentheses
 * @Description 删除最外层括号，1021
 * @Author Tristan
 * @Date 2019/10/16 22:45
 * @Version 1.0
 **/
public class RemoveOuterParentheses {

    public String removeOuterParentheses(String S) {
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

    public static void main(String[] args) {
        String input = "()()";
        RemoveOuterParentheses removeOuterParentheses = new RemoveOuterParentheses();
        System.out.println(removeOuterParentheses.removeOuterParentheses(input));
    }
}
