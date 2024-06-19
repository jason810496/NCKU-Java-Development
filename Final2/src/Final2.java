package homework;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Final2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 10;
        int m = 10;
        final int MARK = 8;
        int[][] mp = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int cur = scanner.nextInt();
                mp[i][j] = cur;
            }
        }

        int[][] vh = new int[][]{ {0,1} , {1,0} , {0,-1} , {-1,0} };
        int[][] sl = new int[][]{ {-1,-1} , {1,-1} , {-1,1} , {1,1} };
        int[][] pos = new int[][]{ {0,1} , {1,0} , {0,-1} , {-1,0},{-1,-1} , {1,-1} , {-1,1} , {1,1} };

        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         System.out.print(mp[i][j]);
        //         if( j!=m-1){
        //             System.out.print(" ");
        //         }
        //     }
        //     System.out.println();
        // }
        // System.out.println("----------------------");

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<8;k++){
                    int vi = pos[k][0];
                    int vj = pos[k][1];

                    int curi = i;
                    int curj = j;
                    int iter = 1;
                    int cnt = 0;
                    int marki = -1;
                    int markj = -1;
                    if( mp[curi][curj] == 1 ){
                        cnt+=1;
                    }
                    else{
                        marki = curi;
                        markj = curj;
                    }

                    while( inside(curi + vi, curj + vj ) && iter < 5 ){
                        iter+=1;
                        curi+=vi;
                        curj+=vj;

                        if( mp[curi][curj] == 1 ){
                            cnt+=1;
                        }
                        else{
                            marki = curi;
                            markj = curj;
                        }

                    }

                    if( cnt == 4 && marki!=-1){
                        mp[marki][markj] = MARK;
                    }
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mp[i][j] == MARK ){
                    System.out.print("X");
                }
                else{
                    System.out.print(mp[i][j]);
                }
                
                if( j!=m-1){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private static boolean inside(int i ,int j){
        return (0<=i && i< 10 ) && ( 0<=j && j<10);
    }
    
}