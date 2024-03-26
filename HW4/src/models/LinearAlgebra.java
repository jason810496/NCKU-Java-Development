package models;

import java.util.List;

import models.Equation;
import models.Matrix;

public class LinearAlgebra {
    public static Matrix equationsToAugmentedMatrix(List<Equation> equations) {
        int rows = equations.size();
        int cols = equations.get(0).getDimension() + 1;
        int[][] augmentedMatrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            Equation equation = equations.get(i);
            for (int j = 0; j < cols; j++) {
                augmentedMatrix[i][j] = equation.getCoefficient(j);
            }
        }
        return new Matrix(augmentedMatrix);
    }

    public static int gaussianElimination(Matrix matrix) {
        int rows = matrix.getRow();
        int cols = matrix.getCol();
        int rank = 0;

        for (int i = 0; i < rows; i++) {
            int pivot = matrix.get(i,i);
            if (pivot == 0) {
                for (int j = i + 1; j < rows; j++) {
                    if (matrix.get(j, i) != 0) {
                        matrix.swapRows(i, j);
                        pivot = matrix.get(i, i);
                        break;
                    }
                }
            }
            if (pivot == 0) {
                continue;
            }
            for (int j = i + 1; j < rows; j++) {
                int factor = matrix.get(j, i) / pivot;
                for (int k = i; k < cols; k++) {
                    matrix.set(j, k, matrix.get(j, k) - factor * matrix.get(i, k));
                }
            }
            rank++;
        }

        for(int i=0;i<rows;i++){
            for(int j=i+1;j<rows;j++){
                if ( matrix.getRows(i).same(matrix.getRows(j)) ) {
                    matrix.setRowZero(j);
                }
            }
        }
        return rank;
    }

    public static int getRank(Matrix matrix) {
        int rank = 0;
        int rows = matrix.getRow();
        int cols = matrix.getCol();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix.get(i, j) != 0) {
                    rank++;
                    break;
                }
            }
        }
        return rank;
    }

    public static String determineSolution(Matrix matrix, int rank) {
        int rows = matrix.getRow();
        int cols = matrix.getCol();

        Equation zero = new Equation(rows);
        for(int i=0;i<rows;i++){
            if(matrix.getRows(i).same(zero)){
                return "Infinite solutions";
            }
        }

        if (rank < cols - 1) {
            return "No solution";
        }
        // } else if (rank == cols - 1) {
        //     return "The only solution";
        // }
        return "The only solution";
    }
}
