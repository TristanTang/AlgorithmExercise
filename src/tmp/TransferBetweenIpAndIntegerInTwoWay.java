package tmp;

/**
 * @program: AlgorithmExercise
 * @description: IP 地址和整数双向转换
 * @author: TangWang
 * @create: 2019-11-11 11:21
 **/

public class TransferBetweenIpAndIntegerInTwoWay {
    /**
     * @description ip 地址到整数的转换，不验证合法性
     * @param ip ip 地址
     * @return int 转换后的整数
     * @author TangWang
     * @date 2019/11/11 11:22
     */
    public int ip2int(String ip) {
        String[] segments = ip.split("\\.");
        int ip1 = Integer.parseInt(segments[0]);
        ip1 = ip1 << 24;
        int ip2 = Integer.parseInt(segments[1]);
        ip2 <<=16;
        int ip3 = Integer.parseInt(segments[2]);
        ip3 <<=8;
        int ip4 = Integer.parseInt(segments[3]);

        System.out.println(Integer.toBinaryString(ip1));
        System.out.println(Integer.toBinaryString(ip2));
        System.out.println(Integer.toBinaryString(ip3));
        System.out.println(Integer.toBinaryString(ip4));
        int result = ip1 | ip2 | ip3 | ip4;
        System.out.println(Integer.toBinaryString(result));
        return result;
    }

    /**
     * @description 整数转换到 ip 地址
     * @param integer 整数
     * @return 转换后的 ip 地址
     * @author TangWang
     * @date 2019/11/11 11:35
     */
    public String int2ip(int integer) {
        return Integer.toString(get8BitInt(integer, 24)) + "."
                + Integer.toString(get8BitInt(integer, 16)) + "."
                + Integer.toString(get8BitInt(integer, 8)) + "."
                + Integer.toString(get8BitInt(integer, 0));
    }

    /**
     * @description 根据偏移量，截取 integer 中 8 位长度的二进制串对应的整数
     * @param integer 原来的整数
     * @param offset 偏移量，想右偏移多少
     * @return int 截取到的整数
     * @author TangWang
     * @date 2019/11/11 14:35
     */
    public int get8BitInt(int integer, int offset) {
        int template = 255;
        template <<= offset;
        System.out.println("template: " + Integer.toBinaryString(template));
        int result = integer & template;
        System.out.println("result before moving right: " + Integer.toBinaryString(result));
        result >>>= offset;
        System.out.println("result after moving right: " + Integer.toBinaryString(result));
        return result;
    }

    public static void main(String[] args) {
        int num = 8;
        String ipString = "192.168.0.1";
        System.out.println("输入的 ip 地址字符串是：" + ipString);
        TransferBetweenIpAndIntegerInTwoWay transferBetweenIpAndIntegerInTwoWay = new TransferBetweenIpAndIntegerInTwoWay();
        int ipInteger = transferBetweenIpAndIntegerInTwoWay.ip2int(ipString);
        System.out.println("转换后的整数是：" + ipInteger);
        ipString = transferBetweenIpAndIntegerInTwoWay.int2ip(ipInteger);
        System.out.println("转换回来的 ip 地址字符串是：" + ipString);
    }
}
