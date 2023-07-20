import java.util.Arrays;
import java.util.Scanner;

public class EnlargeArray {
    static int addingPoint = 0;
    static int size = 1;
    public static void main(String[] args) {
        String[][] array2d = new String[size][4];
        Scanner object = new Scanner(System.in);
        

        while (true) {
            System.out.println("Input :");
            for (int i = addingPoint; i < size; i++) {
                for (int j = 0; j < 4; j++) {   
                    array2d[i][j] = object.nextLine();
                }
            }

            System.out.print("Command :");
            String command = object.nextLine();
            
            if (command.equals("Y")) {
                String[][] tempArray = new String[size+1][4];    
                System.arraycopy(array2d, 0, tempArray, 0, size);
                array2d = tempArray;
                size += 1;
                addingPoint += 1;
    
            } else {
                break;
            }
        }
        
        for (String[] strings : array2d) {
            System.out.println("2 :" + Arrays.toString(strings));
        }

        object.close();
    }
}
