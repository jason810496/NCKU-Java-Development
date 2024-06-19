package homework;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Final3 {
    private static int n = 6;
    private static int[][] mp = new int[n+2][n+2];
    private static int[][] vec = { {0,1} , {1,0} , {0,-1} , {-1,0} };
    private static final int HASH = 1000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                int cur = scanner.nextInt();
                mp[i][j] = cur;
            }
        }

        int Q = scanner.nextInt();
        for(int q=0;q<Q;q++){
            int p1x,p1y,p2x,p2y;
            p1x = scanner.nextInt()+1;
            p1y = scanner.nextInt()+1;
            p2x = scanner.nextInt()+1;
            p2y = scanner.nextInt()+1;

            int tmp = p1x;
            p1x = p1y;
            p1y = tmp;

            tmp = p2x;
            p2x = p2y;
            p2y = tmp;

            boolean ans = bfs(p1x, p1y, p2x, p2y);

            if( ans ){
                System.out.println("pair matched");
            }
            else{
                System.out.println("bad pair");
            }

            // debug();
        }
    }

    private static int pair2int(int x,int y){
        return x*HASH + y;
    }

    private static int[] int2pair(int num){
        int[] ans = new int[]{num/HASH,num%HASH};
        return ans;
    }
    

    private static boolean bfs(int p1x,int p1y,int p2x,int p2y){
        // System.out.print("srcCard ");
        // System.out.println(mp[p1x][p1y]);


        List<int[]> que = new ArrayList<>();
        // 0: encode pos , 1: lastVec, 2: turnCount
        boolean[][] visited = new boolean[n+2][n+2];
        int[][] parent = new int[n+2][n+2];

        parent[p1x][p1y] = -1;
        visited[p1x][p1y] = true;
        que.add(new int[]{ pair2int(p1x, p1y) , -1 , 0 } );

        while(!que.isEmpty()){
            int[] tmp = que.get(0);
            que.remove(0);
            int lastVec = tmp[1];
            int turnCount = tmp[2];

            int[] tmpPair = int2pair(tmp[0]);
            int curX = tmpPair[0];
            int curY = tmpPair[1];

            
            // System.out.print(" X ");
            // System.out.print(curX);
            // System.out.print(" Y ");
            // System.out.print(curY);
            // System.out.print(" lastVec ");
            // System.out.print(lastVec);
            // System.out.print(" turnCount ");
            // System.out.print(turnCount);
            // System.out.println();


            for(int k=0;k<4;k++){
                int nxtX = curX + vec[k][0];
                int nxtY = curY + vec[k][1];

                // System.out.print("nxtX ");
                // System.out.print(nxtX);
                // System.out.print(" nxtY");
                // System.out.print(nxtY);
                // System.out.print("\n");
                
                if( ! inside(nxtX, nxtY) ){
                    continue;
                }
                
                // System.out.print("inside : ");
                // System.out.print("nxtX ");
                // System.out.print(nxtX);
                // System.out.print(" nxtY ");
                // System.out.print(nxtY);
                // System.out.print("\n");
                int newTurn = turnCount;
                if( lastVec != -1 && lastVec != k ){
                    newTurn+= 1;
                }

                if( newTurn > 2 ){
                    continue;
                }

                if( mp[nxtX][nxtY] == 0 && !visited[nxtX][nxtY]){
                    
                    parent[nxtX][nxtY] = pair2int(curX,curY);
                    visited[nxtX][nxtY] = true;

                    que.add(new int[]{ pair2int(nxtX, nxtY) , k , newTurn} );
                    continue;
                }

                if( nxtX == p2x && nxtY == p2y){
                    parent[nxtX][nxtY] = pair2int(curX,curY);
                    // System.out.println("backtrack");
                    while(parent[nxtX][nxtY] != -1 ){
                        mp[nxtX][nxtY] = 0;
                        tmpPair = int2pair(parent[nxtX][nxtY]);
                        nxtX = tmpPair[0];
                        nxtY = tmpPair[1];
                    }
                    mp[nxtX][nxtY] = 0;
                    // System.out.println("backtrack finsh");

                    return true;
                }
                
                
            }
        }

        return false;
    }

    private static boolean inside(int i ,int j){
        return (0<=i && i<=n+1 ) && ( 0<=j && j<=n+1);
    }

    private static void debug(){
        for(int i=0;i<=n+1;i++){
            for(int j=0;j<=n+1;j++){
                System.out.print(mp[i][j]);
                if( j!=n+1 ){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println("----------------------");
    }
}