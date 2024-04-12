// package homework;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import models.Equation;
import models.Matrix;
import models.LinearAlgebra;

public class HW4 {
    // use matrix to solve linear equations
    // one solution, no solution, infinite solutions
    // n dimensional space
    // m equations
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int STOP = -999;
        int cur;

        List<Equation> equations = new ArrayList<>();

        while (scanner.hasNextLine()) {
            cur = scanner.nextInt();
            if (cur == STOP) {
                break;
            }
            int[] coefficients = new int[n+1];
            coefficients[0] = cur;
            for (int i = 1; i <= n; i++) {
                coefficients[i] = scanner.nextInt();
            }
            equations.add(new Equation(coefficients));
        }

        Matrix matrix = LinearAlgebra.equationsToAugmentedMatrix(equations);

        int rank = LinearAlgebra.gaussianElimination(matrix);

        // matrix.print();

        System.out.println(LinearAlgebra.determineSolution(matrix,rank));

        scanner.close();
    }
}