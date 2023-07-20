import java.util.Arrays;

public class MovingFEArray {
    public static void main(String[] args) {
        // Initial
        int size = 3;
        int array[][] = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};

        // Catching first element
        int[] tempFirst = array[0];

        // Deleting first element
        int[][] deletedFirst = new int[size-1][4];
        System.arraycopy(array, 1, deletedFirst, 0, size-1);
        array = deletedFirst;

        // Enlarging and input the first on the last element.
        int[][] tempArray = new int[size][4];    
        System.arraycopy(array, 0, tempArray, 0, size-1);
        tempArray[array.length] = tempFirst;

        array = tempArray;

        /*
        Test cases
        */

        for (int[] element : array) {
            System.out.println(Arrays.toString(element));
        }
    }
}