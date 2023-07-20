import java.util.Scanner;

public class prototype {
    public static void main(String[] args) {
        Scanner object = new Scanner(System.in);
        int n = object.nextInt();

        object.nextLine();

        while (n-- > 0) {
            String kode = object.nextLine();
            System.out.println(check(kode) ? "YES" : "NO");
        }

        object.close();
    }

    public static boolean check(String code){
        if (code.length() == 11 && (code.charAt(0) == '2' || (code.charAt(0) == '1' && code.charAt(1) == '8'))){
            int oddSack = 0;
            int evenSack = 0;

            for (int i = 0; i < code.length(); i++) {
                int valueFromCode = Character.getNumericValue(code.charAt(i));
                if (i % 2 == 0){ // odd
                    int multipliedValue = valueFromCode * 2;

                    if (multipliedValue > 9){ // 2 digit
                        String multipliedString = Integer.toString(multipliedValue);
                        oddSack += (Character.getNumericValue(multipliedString.charAt(0)) + Character.getNumericValue(multipliedString.charAt(1)));
                    } else { // 1 digit
                        oddSack += multipliedValue;
                    }
                } else { // even
                    evenSack += valueFromCode;
                }
            }

            int summary = oddSack + evenSack;
            return(summary % 10 == 0 ? true : false);

        } else {
            return false;
        }

    }

}