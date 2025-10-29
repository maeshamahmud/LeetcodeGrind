import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Labyrinth{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //height
        int m = sc.nextInt(); //width
        char[][] maze = new char[n][m];
        int startX = -1, startY = -1, endX = -1, endY = -1;
        
        for(int i = 0; i<n; i++){
            String row = sc.next();
            for(int j = 0; j<m; j++){
                maze[i][j]= row.charAt(j);
                if(row.charAt(j) == 'A'){
                    startY = i;
                    startX = j;
                }
                if(row.charAt(j) == 'B'){
                    endY = i;
                    endX = j;
                }
            }
        }

        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        q.add(new int[]{startY, startX});
        visited[startY][startX] = true;

        int[] dx = {0,1,0,-1}; //u,r,d,l
        int[] dy = {-1,0,1,0};
        char[] dir = {'U','R','D','L'};
        int[][] py = new int[n][m];
        int[][] px = new int[n][m];
        char[][] steps = new char[n][m];
        boolean found = false;

        //BFS loop
        while(!q.isEmpty()){
            int[] current = q.poll();
            int x = current[1];
            int y = current[0];
            int ny,nx;
            if(y == endY && x ==endX){
                found = true;
                break;
            }
            for(int i=0; i<4; i++){
                nx = x + dx[i];
                ny = y + dy[i];
                if(nx>=0 && nx<m && ny>=0 && ny<n){
                    if(maze[ny][nx] != '#'){
                        if(!visited[ny][nx]){
                            q.add(new int[]{ny,nx});
                            visited[ny][nx] = true;
                            px[ny][nx] = x;
                            py[ny][nx] = y;
                            steps[ny][nx] = dir[i];
                        }
                    }
                }
            }
        }

        if (!visited[endY][endX]) {
            System.out.println("NO");
            return;
        }
        
        StringBuilder path = new StringBuilder();
        int cy = endY, cx = endX;
        while (!(cy == startY && cx == startX)) {
            path.append(steps[cy][cx]);     
            int pry = py[cy][cx], prx = px[cy][cx];
            cy = pry; cx = prx;
        }
        
        path.reverse();
        System.out.println("YES");
        System.out.println(path.length());
        System.out.println(path.toString());
    }
}