package models;

import models.Equation;

public class Matrix {
    private int[][] matrix;
    private int rows;
    private int cols;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.matrix = new int[rows][cols];
    }

    public Matrix(int[][] matrix) {
        this.matrix = matrix;
        this.rows = matrix.length;
        this.cols = matrix[0].length;
    }

    public int getRow() {
        return this.rows;
    }

    public Equation getRows(int i) {
        return new Equation(this.matrix[i]);
    }

    public int getCol() {
        return this.cols;
    }

    public int[] getCols(int j) {
        int[] col = new int[this.rows];
        for (int i = 0; i < this.rows; i++) {
            col[i] = this.matrix[i][j];
        }
        return col;
    }

    public int get(int i, int j) {
        return this.matrix[i][j];
    }

    public void set(int i, int j, int value) {
        this.matrix[i][j] = value;
    }

    public void swapRows(int i, int j) {
        int[] temp = this.matrix[i];
        this.matrix[i] = this.matrix[j];
        this.matrix[j] = temp;
    }

    public void setRowZero(int i) {
        for (int j = 0; j < this.cols; j++) {
            this.matrix[i][j] = 0;
        }
    }

    public void print() {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                System.out.print(this.matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
