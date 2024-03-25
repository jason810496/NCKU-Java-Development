package homework;
import java.util.Scanner;

import models.Point;

public class HW3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Point main = new Point(0,0);
        Point other = new Point(0,0);
        Point move = new Point(0,0);
        Point[] list = {main, other, move};

        // stdin
        for(int i = 0; i < 3; i++){
            list[i].SetPoint(scanner.nextInt(), scanner.nextInt());
        }
        main.Print();

        // move
        main.Move(move.RetrieveVertical(), move.RetrieveHorizontal());
        main.Print();

        // rotate
        for(int i=0;i<4;i++){
            main.Rotate();
            main.Print();
        }

        // Manhattan distance
        System.out.println(main.calculateManhattanDistance(other));

        // Chebyshev distance
        System.out.println(main.ChebyshevDistance(other));

        scanner.close();
    }
}