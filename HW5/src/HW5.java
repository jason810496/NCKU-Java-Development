package homework;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
// import javafx.util.Pair;



public class HW5 {
    public static class Pair<K, V> {
        private K key;
        private V value;
        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
        public K getKey() {
            return key;
        }
        public V getValue() {
            return value;
        }
    }

    public static int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static boolean[][] visited;
    public static void main(String[] args) {
        // scan two float string number in stdin
        Scanner scanner = new Scanner(System.in);
        String target;
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // input
        String[][] arr = new String[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                String chr = scanner.next();
                arr[i][j] = chr;
            }
        }
        target = scanner.next();

        // search 
        boolean found = false;
        for (int i = 0; i < n && !found; i++) {
            for (int j = 0; j < m && !found ; j++) {
                if( search(arr, target, i, j,"") ){
                    found = true;
                    break;
                }
            }
        }

        System.out.println(found ? "true" : "false");
    }

    public static boolean search(String[][] arr, String target, int I, int J, String current){
        int n = arr.length;
        int m = arr[0].length;

        if (current.equals(target) ){
            return true;
        }

        if( current.length() > target.length() ){
            return false;
        }

        for(int k=0;k<4;k++){
            int i = I + directions[k][0];
            int j = J + directions[k][1];
            if( i>=0 && i<n && j>=0 && j<m && !visited[i][j] ){
                if( target.equals(current + arr[i][j] ) ){
                    return true;
                }
                if( target.startsWith(current + arr[i][j]) ){
                    visited[i][j] = true;
                    if( search(arr, target, i, j,current+arr[i][j]) ){
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }

        return false;
    }

}