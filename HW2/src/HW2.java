package homework;

import java.util.HashMap;
import java.util.Scanner;
import java.math.BigDecimal;
import java.math.BigInteger;

public class HW2 {
    /*
    A pure infinitely-repeating decimal number is defined as a decimal where all digits in the fractional part are non-zero and
    repeat infinitely. For example, 3.142857 represents a pure infinitely-repeating decimal number with the repeating sequence
    142857. Conversely, 3.6142857 is not a pure infinitely-repeating decimal number as it contains non-repeating digits in its
    fractional part. In this problem, it is assumed that all decimal numbers provided are pure infinitely-repeating. Please write a
    program to compute the sum of two pure infinitely-repeating decimal numbers.
     */

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        //The first line is an integer n indicating the number of test cases. Each test case consists of two pure infinitely-repeating
        //decimal numbers x and y. Both x and y may be positive. For example, 9.2 indicates 9.ത2; 3.56 indicates 3.56

        int n = scanner.nextInt();
        while(n-- > 0){
            BigDecimal x = scanner.nextBigDecimal();
            BigDecimal y = scanner.nextBigDecimal();
            solve(x, y);
        }
    }

    static public void solve(BigDecimal x, BigDecimal y){
        Fraction f1 = new Fraction(x);
        Fraction f2 = new Fraction(y);
        // System.err.println(f1);
        // System.err.println(f2);
        Fraction result = f1.add(f2);

        long parent = Long.parseLong(result.numerator);
        long child = Long.parseLong(result.denominator);
        long rem = (int) (parent % child);
        String decimal="";
        HashMap<Long, Integer> tmp = new HashMap<>();

        while(rem != 0){

            if (tmp.containsKey(rem)){
                break;
            }
            tmp.put( rem, decimal.length());
            decimal += rem*10 / child;

            rem = (rem * 10) % child;
        }

        System.out.print(String.format("%d", parent / child));
        if (decimal.length() > 0){
            System.out.println("."+decimal);
        }
        else{
            System.out.println();
        }
    }

    static private class Fraction {
        public String numerator;
        public String denominator;

        public Fraction(String numerator, String denominator){
            this.numerator = numerator;
            this.denominator = denominator;
            this.simplify();
        }

        public Fraction(BigDecimal x){
            String[] parts = x.toString().split("\\.");
            int len = parts[1].length();
            this.numerator = parts[1];
            this.denominator = "9".repeat(len);

            // System.err.println("parts: " + parts[0] + " " + parts[1] + " " + len);

            long num = Long.parseLong(parts[0]) * Long.parseLong(this.denominator) + Long.parseLong(parts[1]);
            this.numerator = Long.toString(num);
            this.simplify();
        }

        public Fraction add(Fraction other){
            String num1 = this.numerator;
            String den1 = this.denominator;
            String num2 = other.numerator;
            String den2 = other.denominator;

            String num = (new BigDecimal(num1).multiply(new BigDecimal(den2))).add(new BigDecimal(num2).multiply(new BigDecimal(den1))).toString();
            String den = (new BigDecimal(den1).multiply(new BigDecimal(den2))).toString();

            Fraction result = new Fraction(num, den);
            result.simplify();  
            return result;
        }

        public String toString(){
            return this.numerator + "/" + this.denominator;
        }

        public void simplify(){
            // Euclidean algorithm
            BigInteger a = new BigInteger(this.numerator);
            BigInteger b = new BigInteger(this.denominator);
            BigInteger gcd = a.gcd(b);
            this.numerator = a.divide(gcd).toString();
            this.denominator = b.divide(gcd).toString();
        }
    }
}