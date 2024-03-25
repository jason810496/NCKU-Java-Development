package models;

public class Point{
    private int vertical;
    private int horizontal;

    public Point(int vertical, int horizontal){
        this.vertical = vertical;
        this.horizontal = horizontal;
    }

    public void SetPoint(int vertical, int horizontal){
        this.vertical = vertical;
        this.horizontal = horizontal;
    }

    public void Move(int x,int y){
        this.vertical += x;
        this.horizontal += y;
    }

    public void Rotate(){
        // Rotate 90 degrees clockwise from the origin
        int temp = this.vertical;
        this.vertical = this.horizontal;
        this.horizontal = -temp;
    }

    public int RetrieveVertical()
    {
        return this.vertical;
    }

    public int RetrieveHorizontal()
    {
        return this.horizontal;
    }

    public int calculateManhattanDistance(Point other){
        return Math.abs(this.vertical - other.vertical) + Math.abs(this.horizontal - other.horizontal);
    }

    public double ChebyshevDistance(Point other)
    {
        return Math.max(Math.abs(this.vertical - other.vertical), Math.abs(this.horizontal - other.horizontal));
    }

    public void Print(){
        System.out.println(this.vertical + " " + this.horizontal);
    }
}