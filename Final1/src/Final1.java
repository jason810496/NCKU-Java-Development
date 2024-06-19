package homework;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Final1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = Integer.parseInt(scanner.next());

        for(int k=0;k<n;k++){
            String equa = scanner.next();
            // System.out.println("in:"+equa);
            solve(equa);
        }

    }

    private static void solve(String equa){
        final String Split  = "=";
        
        Integer splitIdx = equa.indexOf(Split);
        String firstHalf = equa.substring(0,splitIdx);
        String secondHalf = equa.substring(splitIdx+1,equa.length());

        
        
        // System.out.println("sol:"+firstHalf);
        List<Integer> firstPair = parseEqua(firstHalf);
        // System.err.println("firstPair");
        // System.err.println(firstPair.get(0));
        // System.err.println(firstPair.get(1) );
        // System.out.println("sol:"+secondHalf);
        List<Integer> secondPair = parseEqua(secondHalf);
        // System.err.println("secondPair");
        // System.err.println(secondPair.get(0));
        // System.err.println(secondPair.get(1) );

        
        Integer[] ans = new Integer[]{firstPair.get(0)-secondPair.get(0) , -firstPair.get(1)+secondPair.get(1)};
        // System.out.println("ans pair:");
        // System.out.println(ans[0]);
        // System.out.println(ans[1]);

        if( ans[0] == ans[1] && ans[0] == 0 ){
            System.out.println("Infinite solutions");
            return;
        }
        
        if( ans[0] == 0 && ans[1] != 0 ){
            System.out.println("No solution");
        }
        else {
            System.out.print("x=");
            System.out.println(ans[1] / ans[0] );
        }
        
    }

    private static List<Integer> parseEqua(String equa){
        int n = equa.length();
        final String X = "x";
        final List<Character> Signs = new ArrayList<>();
        Signs.add('-');
        Signs.add('+');
        Integer xSum = 0 ;
        Integer constSum =  0;
        Integer cur = 0;
        Integer curSign = 1;

        for(int i=0;i<n;i++){
            Character ch  = equa.charAt(i);
            // System.out.print("current char: ");
            // System.out.println(ch);

            if( Character.isDigit(ch) ){
                // System.err.println("isDigit" + ch );
                cur  = cur*10 + ch-'0';
            }
            else if ( Character.isLetter(ch) ) { // x
                // System.err.println("isLetter" + ch );
                if( cur == 0 ){
                    xSum += curSign;
                    cur = 0;
                    curSign = 1;
                    continue;
                }
                xSum += cur * curSign;
                cur = 0;
                curSign = 1;
            }
            else if( Signs.contains(ch) ){ // + -
                // System.err.println("isSigns" + ch );
                if(cur !=0 ){
                    constSum += cur * curSign;
                    cur = 0;
                }

                if(ch == '+' ){
                    curSign = 1;
                }
                else{
                    curSign = -1;
                }
            }

            // System.out.print("X:");
            // System.out.print(xSum);
            // System.out.print(",Const:");
            // System.out.println(constSum);
        }
        if( cur !=0 ){
            constSum += cur * curSign;
            cur = 0;
        }
        // System.out.println("after process");
        // System.out.print("X:");
        // System.out.print(xSum);
        // System.out.print(",Const:");
        // System.out.println(constSum);

        List<Integer> ans = new ArrayList<>();
        ans.add(xSum);
        ans.add(constSum);
        return ans;
    }
    
}