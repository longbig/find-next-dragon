package leetcode2024.compitetion.week413;

/**
 * @author yuyunlong
 * @date 2024/9/1 10:40
 * @description
 */
public class CompetitionQ1 {

    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        if (coordinate1 == null || coordinate2 == null) {
            return false;
        }
        int[][] array = new int[][]{
                {0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0}
        };
        char[] array1 = coordinate1.toCharArray();
        char[] array2 = coordinate2.toCharArray();
        int indexA = array1[0] - 'a';
        int indexAy = array1[1] - '0';
        int indexB = array2[0] - 'a';
        int indexBy = array2[1] - '0';
        return array[7 - indexA][indexAy - 1] == array[7 - indexB][indexBy - 1];

    }

    public static void main(String[] args) {
        char a = 'a';
        System.out.println(a - 'a');
    }
}
