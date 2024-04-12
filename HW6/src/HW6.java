package homework;
import java.util.Scanner;


public class HW6 {
    public static void main(String[] args) {
        // scan two float string number in stdin
        Scanner scanner = new Scanner(System.in);
        String ooxxResult = scanner.nextLine();
        // "##X#O#OXX (length = 9)"
        // empty : #
        // player1 : X
        // player2 : O
        // check if invalid input

        int countX = 0;
        int countO = 0;
        boolean winX = false;
        boolean winO = false;


        for (int i = 0; i < ooxxResult.length(); i++) {
            if (ooxxResult.charAt(i) == 'X') {
                countX++;
            } else if (ooxxResult.charAt(i) == 'O') {
                countO++;
            }
        }

        if (countX < countO) {
            System.out.println("invalid");
            return;
        }

        // check if X win
        if (ooxxResult.charAt(0) == 'X' && ooxxResult.charAt(1) == 'X' && ooxxResult.charAt(2) == 'X') {
            winX = true;
        } else if (ooxxResult.charAt(3) == 'X' && ooxxResult.charAt(4) == 'X' && ooxxResult.charAt(5) == 'X') {
            winX = true;
        } else if (ooxxResult.charAt(6) == 'X' && ooxxResult.charAt(7) == 'X' && ooxxResult.charAt(8) == 'X') {
            winX = true;
        } else if (ooxxResult.charAt(0) == 'X' && ooxxResult.charAt(3) == 'X' && ooxxResult.charAt(6) == 'X') {
            winX = true;
        } else if (ooxxResult.charAt(1) == 'X' && ooxxResult.charAt(4) == 'X' && ooxxResult.charAt(7) == 'X') {
            winX = true;
        } else if (ooxxResult.charAt(2) == 'X' && ooxxResult.charAt(5) == 'X' && ooxxResult.charAt(8) == 'X') {
            winX = true;
        } else if (ooxxResult.charAt(0) == 'X' && ooxxResult.charAt(4) == 'X' && ooxxResult.charAt(8) == 'X') {
            winX = true;
        } else if (ooxxResult.charAt(2) == 'X' && ooxxResult.charAt(4) == 'X' && ooxxResult.charAt(6) == 'X') {
            winX = true;
        }

        // check if O win
        if (ooxxResult.charAt(0) == 'O' && ooxxResult.charAt(1) == 'O' && ooxxResult.charAt(2) == 'O') {
            winO = true;
        } else if (ooxxResult.charAt(3) == 'O' && ooxxResult.charAt(4) == 'O' && ooxxResult.charAt(5) == 'O') {
            winO = true;
        } else if (ooxxResult.charAt(6) == 'O' && ooxxResult.charAt(7) == 'O' && ooxxResult.charAt(8) == 'O') {
            winO = true;
        } else if (ooxxResult.charAt(0) == 'O' && ooxxResult.charAt(3) == 'O' && ooxxResult.charAt(6) == 'O') {
            winO = true;
        } else if (ooxxResult.charAt(1) == 'O' && ooxxResult.charAt(4) == 'O' && ooxxResult.charAt(7) == 'O') {
            winO = true;
        } else if (ooxxResult.charAt(2) == 'O' && ooxxResult.charAt(5) == 'O' && ooxxResult.charAt(8) == 'O') {
            winO = true;
        } else if (ooxxResult.charAt(0) == 'O' && ooxxResult.charAt(4) == 'O' && ooxxResult.charAt(8) == 'O') {
            winO = true;
        } else if (ooxxResult.charAt(2) == 'O' && ooxxResult.charAt(4) == 'O' && ooxxResult.charAt(6) == 'O') {
            winO = true;
        }

        if ( (winO || winX ) && (countX+countO > 5) ){
            System.out.println("invalid");
            return;
        }

        System.err.println("valid");

    }
}