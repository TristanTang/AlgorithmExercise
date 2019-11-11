/**
 * @ClassName DefangIpAddress
 * @Description 1108.IP 地址无效化。
 * @Author Tristan
 * @Date 2019/10/16 20:24
 * 时间： 0ms，用时击败 100%，内存击败 100%
 **/
public class DefangIpAddress {
    /**
     * @Description 将输入字符串中 "." 替换为 "[.]"
     * @date 20:26 2019/10/16
     * @param address IPV4 地址
     * @return java.lang.String 替换后的字符串
     * @author Tristan
     */
    public String defangIpAddr(String address) {
        StringBuilder result = new StringBuilder();
        for(char c : address.toCharArray()) {
            if(c=='.') {
                result.append("[.]");
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String address="255.100.50.0";
        DefangIpAddress defangIpAddress = new DefangIpAddress();
        System.out.println(defangIpAddress.defangIpAddr(address));
    }
}
