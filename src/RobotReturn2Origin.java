/**
 * @program: AlgorithmExercise
 * @description: 657.There is a robot starting at position (0, 0), the origin, on a 2D plane. Given a sequence of its moves, judge if this robot ends up at (0, 0) after it completes its moves.  The move sequence is represented by a string, and the character moves[i] represents its ith move. Valid moves are R (right), L (left), U (up), and D (down). If the robot returns to the origin after it finishes all of its moves, return true. Otherwise, return false.  Note: The way that the robot is "facing" is irrelevant. "R" will always make the robot move to the right once, "L" will always make it move left, etc. Also, assume that the magnitude of the robot's movement is the same for each move.
 * @author: TangWang
 * @create: 2019-11-12 14:41
 * Runtime: 4 ms, faster than 98.15% of Java online submissions for Robot Return to Origin.
 * Memory Usage: 38 MB, less than 98.65% of Java online submissions for Robot Return to Origin.
 **/
@SuppressWarnings("all")
public class RobotReturn2Origin {
    /**
     * @description 思路 1：U 和 D 是一个维度(U是 -1，D 是 1)；L 和 R 是一个维度(L 是 -1，R 是 1)
     * @param moves
     * @return boolean
     * @author TangWang
     * @date 2019/11/12 14:43
     */
    public boolean judgeCircle(String moves) {
        // 左右的偏移
        int horizontalOffset = 0;
        // 上下的偏移
        int verticalOffset = 0;
        for (char c : moves.toCharArray()) {
            switch (c) {
                case 'L':
                    horizontalOffset -= 1;
                    break;
                case 'R':
                    horizontalOffset += 1;
                    break;
                case 'U':
                    verticalOffset += 1;
                    break;
                case 'D':
                    verticalOffset -= 1;
                    break;
                default:
                    break;
            }
        }
        if(horizontalOffset==0 && verticalOffset==0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String test = "UD";
        RobotReturn2Origin robotReturn2Origin = new RobotReturn2Origin();
        System.out.println(robotReturn2Origin.judgeCircle(test));
    }
}
