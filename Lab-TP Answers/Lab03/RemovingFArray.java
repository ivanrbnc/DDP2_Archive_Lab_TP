import java.util.Arrays;

public class RemovingFArray {
    public static void main(String[] args) {
        // Initial
        int size = 3;
        int array[][] = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};

        // Smalling the size
        int[][] tempArray = new int[size-1][4];    
        System.arraycopy(array, 1, tempArray, 0, size-1);
        size -= 1;
        array = tempArray;
        
        /*
        Test cases
        */

        for (int[] element : array) {
            System.out.println(Arrays.toString(element));
        }
    }
}