import java.util.Arrays;

public class MovingEFArray {
    public static void main(String[] args) {
        // Initial
        int size = 3;
        int array[][] = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};

        // Catching last element
        int[] tempLast = array[array.length-1];

        // Deleting last element
        int[][] deletedLast = new int[size-1][4];
        System.arraycopy(array, 0, deletedLast, 0, size-1);
        array = deletedLast;

        // Enlarging and input the last on the first element.
        int[][] tempArray = new int[size][4];    
        System.arraycopy(array, 0, tempArray, 1, size-1);
        tempArray[0] = tempLast;
        array = tempArray;

        /*
        Test cases
        */

        for (int[] element : array) {
            System.out.println(Arrays.toString(element));
        }
    }
}