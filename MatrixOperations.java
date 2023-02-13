public class MatrixOperations {

    public static Integer[] add2IntList(Integer[] a, Integer[] b) {
        Integer[] sum = new Integer[2];
        sum[0] = a[0] + b[0];
        sum[1] = a[1] + b[1];

        return sum;
    }

    public static Boolean checkBounds(Integer[] pos, Canvas canvas) {
        if (pos[0] >= canvas.height || pos[0] < 0 || pos[1] >= canvas.width || pos[1] < 0) {
            return false;
        }
        return true;
    }

}
