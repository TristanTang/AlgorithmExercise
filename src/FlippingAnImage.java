/**
 * @program: FlippingAnImage
 * @description: 图片水平翻转后，每一位都求反。 LeetCode 832
 * @author: WangTang
 * @create: 2019-10-16 16:37
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Flipping an Image.
 * Memory Usage: 36.5 MB, less than 100.00% of Java online submissions for Flipping an Image.
 **/
public class FlippingAnImage {

    /**
     * @Description 数组水平翻转
     * @param image 二维数组表示的图片
     * @Return void
     * @Author WangTang
     * @Date 2019/10/16 16:49
     */
    private void flipHorizonally(int[][] image) {
        int rowCount = image.length;
        int left, right, tmp;
        for(int rowIndex=0; rowIndex<rowCount; rowIndex++){
            left = 0;
            right = rowCount - 1;
            int[] row = image[rowIndex];
            while(left<right){
                tmp = row[left];
                row[left] = row[right];
                row[right] = tmp;
                left++;
                right--;
            }
        }
    }

    /**
     * @Description 数组每一位求反
     * @param image 二位数组
     * @Return void
     * @Author WangTang
     * @Date 2019/10/16 16:50
     */
    private void invertImage(int[][] image) {
        int rowCount = image.length;
        int columnCount = rowCount;
        for(int rowIndex=0; rowIndex<rowCount; rowIndex++) {
            int[] row = image[rowIndex];
            for(int columnIndex=0; columnIndex<columnCount; columnIndex++) {
                row[columnIndex] ^= 1;
            }
        }
    }

    /**
     * @Description 先水平翻转二位数组，然后每一位取反
     * @param A 输入的二位矩阵
     * @Return int[][] 操作后的矩阵
     * @Author WangTang
     * @Date 2019/10/16 17:06
     */
    public int[][] flipAndInvertImage(int[][] A) {
        flipHorizonally(A);
        invertImage(A);
        return A;
    }

    public static void main(String[] args) {
        int[][] image1 = new int[][]{{1,1,0},{1,0,1},{0,0,0}};
        FlippingAnImage flippingAnImage = new FlippingAnImage();
        int[][] result1 = flippingAnImage.flipAndInvertImage(image1);
        int[][] image2 = new int[][]{{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};

    }
}
