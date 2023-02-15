public class MatrixOperations {

    public static int[] add2IntList(int[] a, int[] b) {
        int[] sum = new int[2];
        sum[0] = a[0] + b[0];
        sum[1] = a[1] + b[1];

        return sum;
    }

    public static Boolean checkBounds(int[] pos, Canvas canvas) {
        if (pos[0] >= canvas.height || pos[0] < 0 || pos[1] >= canvas.width || pos[1] < 0) {
            return false;
        }
        return true;
    }

}
