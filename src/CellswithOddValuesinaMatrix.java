import java.util.HashSet;
import java.util.Set;

/**
 * @program: AlgorithmExercise
 * @description: 1252.Given n and m which are the dimensions of a matrix initialized by zeros and given an array indices where indices[i] = [ri, ci]. For each pair of [ri, ci] you have to increment all cells in row ri and column ci by 1.  Return the number of cells with odd values in the matrix after applying the increment to all indices
 * @author: TangWang
 * @create: 2019-11-11 00:40
 **/
@SuppressWarnings("all")
public class CellswithOddValuesinaMatrix {

    /***
     * @Description 思路：1.遍历 indices，得到行和列。2.然后去除重复的行，去除重复的列。3.最初都是偶数，行和列交叉的，结果是偶数；行和列不交叉的，结果为奇数。
     * @param rowCount 行数
     * @param columnCount 列数
     * @param indices 变换奇偶的元素
     * @Return int 奇数数量
     * @Author TangWang
     * @Date 2019/11/11 09:22
     * 性能：Runtime: 1 ms, faster than 100.00% of Java；Memory Usage: 40.8 MB, less than 100.00% of Java
     */
    public int method3(int rowCount, int columnCount, int[][] indices) {
        int count = 0;
        Set<Integer> rows = new HashSet<>();
        Set<Integer> columns = new HashSet<>();
        if(indices!=null) {
            if (indices.length > 0) {
                // 出现多次与 %2 后的效果一样
                for (int i = 0; i < indices.length; i++) {
                    int rowIndex = indices[i][0];
                    int columnIndex = indices[i][1];
                    if(rows.contains(rowIndex)) {
                        rows.remove(rowIndex);
                    } else {
                        rows.add(rowIndex);
                    }
                    if(columns.contains(columnIndex)) {
                        columns.remove(columnIndex);
                    } else {
                        columns.add(columnIndex);
                    }
                }
                // 先计算所有的变奇数的次数
                count += rows.size() * columnCount + columns.size() * rowCount;
                // 行与列相交的，变成偶数，需要减去；因为重叠的元素相当于两次变奇偶性的操作，所以需要*2；
                count -= rows.size() * columns.size() * 2;
            }
        }
        return count;
    }

    /**
     * 使用 set 来存储集合元素，这样就不用遍历了
     * @param rowCount 矩阵行数
     * @param columnCount 矩阵列数
     * @param indices 指示修改元素的参数数组
     * @return 奇数数量
     */
    public int method2(int rowCount, int columnCount, int[][] indices) {
        Set<Integer> elements = new HashSet<>();
        if(indices!=null) { ;
            if (indices.length > 0) {
                for (int i = 0; i < indices.length; i++) {
                    int rowIndex = indices[i][0];
                    int columnIndex = indices[i][1];
                    // 更新第 rowIndex 行
                    for(int col=0; col<columnCount; col++) {
                        int element = rowIndex * columnCount + col;
                        if(elements.contains(element)) {
                            elements.remove(element);
                        } else {
                            elements.add(element);
                        }
                    }
                    // 更新第 columnIndex 列
                    for(int row=0; row<rowCount; row++) {
                        int element = row * columnCount + columnIndex;
                        if(elements.contains(element)) {
                            elements.remove(element);
                        } else {
                            elements.add(element);
                        }
                    }
                }
            }
        }
        return elements.size();
    }

    /**
     * 思路：先初始化 rowCount*columnCount 的全是0的矩阵，然后按照 indices 来修改，最后输出数组中奇数的数量。复杂度是 O(n^2)
     * @param rowCount 行数
     * @param columnCount 列数
     * @param indices 改变奇偶的行和列
     * @return 奇数的数量
     */
    public int method1(int rowCount, int columnCount, int[][] indices){
        int[][] matrix = new int[rowCount][columnCount];
        int count = 0;
        if(indices!=null) {
            int row = indices.length;
            if(row>0) {
                for(int i=0; i<row; i++) {
                    int rowIndex = indices[i][0];
                    int columnIndex = indices[i][1];
                    addByRow(matrix, rowIndex, columnCount);
                    addByColumn(matrix, columnIndex, rowCount);
                    count = getOddElementCount(matrix, rowCount, columnCount);
                }
            }

        }
        return count;
    }

    /**
     * 将某行的所有元素异或1
     * @param matrix 矩阵
     * @param rowIndex 行号
     * @param column 列数
     */
    public void addByRow(int[][] matrix, int rowIndex, int column) {
        for(int i=0; i<column; i++) {
            matrix[rowIndex][i] ^= 1;
        }
    }

    /**
     * 将某列的所有元素异或1
     * @param matrix
     * @param columnIndex
     * @param row
     */
    public void addByColumn(int[][] matrix, int columnIndex, int row) {
        for(int i=0; i<row; i++) {
            matrix[i][columnIndex] ^= 1;
        }
    }

    /**
     * 统计矩阵中奇数的数量
     * @param matrix 矩阵
     * @return 奇数的数量
     */
    public int getOddElementCount(int[][] matrix, int row, int column) {
        int count = 0;
        for(int i=0; i<row; i++) {
            for(int j=0; j<column; j++) {
                if(matrix[i][j]==1) {
                    count+=1;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 2;
        int m = 2;
        int[][] indices = new int[][]{{1,1},{0,0}};
        CellswithOddValuesinaMatrix cellswithOddValuesinaMatrix = new CellswithOddValuesinaMatrix();
        System.out.println(cellswithOddValuesinaMatrix.method3(n, m, indices));
    }
}