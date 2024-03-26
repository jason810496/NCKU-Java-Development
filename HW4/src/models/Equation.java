package models;

public class Equation{
    private int[] coefficients;
    private int dimension;

    public Equation(){
        this.coefficients = new int[0];
        this.dimension = 0;
    }

    public Equation(int n){
        this.coefficients = new int[n+1];
        this.dimension = n;
    }

    public Equation(int[] coefficients){
        this.coefficients = coefficients;
        this.dimension = coefficients.length - 1;
    }

    public int getCoefficient(int i){
        return this.coefficients[i];
    }

    public int getDimension(){
        return this.dimension;
    }

    public boolean same(Equation other){
        if(this.dimension != other.getDimension()){
            return false;
        }
        for(int i = 0; i <= this.dimension; i++){
            if(this.coefficients[i] != other.getCoefficient(i)){
                return false;
            }
        }
        return true;
    }
}