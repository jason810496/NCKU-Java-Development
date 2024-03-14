package homework;
import java.util.Scanner;
import java.math.BigDecimal;

public class HW1 {
    public static void main(String[] args) {
        // scan two float string number in stdin
        Scanner scanner = new Scanner(System.in);
        String firstFloat = scanner.next();
        String secondFloat = scanner.next();

        // the float number may be too large to store in float and double
        // so we use BigDecimal to store the float number

        // convert the string to BigDecimal
        BigDecimal first = new BigDecimal(firstFloat);
        BigDecimal second = new BigDecimal(secondFloat);

        // add the two float number
        BigDecimal sum = first.add(second);

        // print the result
        System.out.println(sum);
    }
}