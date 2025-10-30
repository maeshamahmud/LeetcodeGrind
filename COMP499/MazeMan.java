package COMP499;

import java.util.*;

public class MazeMan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt(), c = sc.nextInt();
        sc.nextLine();
        char[][] maze = new char[r][c];
        int dotCount = 0;
        List<int[]> letters = new ArrayList<>();
        boolean[][] visited = new boolean[r][c];

        for(int i = 0; i<r; i++){
            String row = sc.nextLine();
            for(int j = 0; j<c; j++){
                maze[i][j] = row.charAt(j);
                char ch = maze[i][j];
                if(ch == '.'){
                    dotCount++;
                }
                if ( ch >= 'A' && ch <= 'W') {
                    letters.add(new int[]{i, j});   
                }
            }
        }

        //u,d,l,r
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};

        int players = 0;
        int remainingDots = dotCount;

        for(int i = 0 ; i<letters.size();i++){
            int[] currLetter = letters.get(i);
            int startR = currLetter[0];
            int startC = currLetter[1];
            Stack<int[]> s = new Stack<>();
            for(int j = 0; j<4;j++){
                int nr = startR + dr[j], nc = startC + dc[j];
                if(nr>=0 && nr<r && nc>=0 && nc<c && (maze[nr][nc]=='.' || maze[nr][nc] == ' ') && !visited[nr][nc]){
                    s.push(new int[]{nr,nc});
                }
            }

            int eatenThisDoor = 0;

            while (!s.isEmpty()) {
                int[] cur = s.pop();
                int cr = cur[0], cc = cur[1];

                if (visited[cr][cc]) continue;   
                visited[cr][cc] = true;

                if (maze[cr][cc] == '.') eatenThisDoor++;  

                for (int k = 0; k < 4; k++) {
                    int nr = cr + dr[k], nc = cc + dc[k];
                    if (nr < 0 || nr >= r || nc < 0 || nc >= c) continue;
                    char cell = maze[nr][nc];
                    if (!(cell == '.' || cell == ' ')) continue; 
                    if (visited[nr][nc]) continue;
                    s.push(new int[]{nr, nc});
                }
            }

            if (eatenThisDoor > 0) {
                players++;
                remainingDots -= eatenThisDoor;
            }
        }
        sc.close();   
        System.out.println(players + " " + remainingDots);
    }
}
