package Leetcode;
import java.util.*;

class Solution {
    public int islandPerimeter(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int perimeter = 0;
        //U,D,L,R
        int[] dy = {-1,1,0,0};
        int[] dx = {0,0,-1,1};

        Queue<int[]> q = new LinkedList<>(); 

        for(int i = 0; i<grid.length;i++){
            for(int j =0 ; j<grid[i].length;j++){
                if(grid[i][j]==1){
                    q.add(new int[]{i,j});
                    break;
                }
            }
            if(!q.isEmpty()){
                break;
            }
        }

        while(!q.isEmpty()){
            int[] box = q.remove();
            int y = box[0];
            int x = box[1];
            visited[y][x] = true;
            
            for(int k=0; k<4;k++){
                int ny = y + dy[k], nx = x + dx[k];
                if(grid[ny][nx] == 0 || ny < 0 || nx < 0 || ny > grid.length || nx > grid[0].length){
                    perimeter++;
                }
                else if(visited[ny][nx] == false){
                    q.add(new int[]{ny,nx});
                }
            }

        }
        return perimeter;
    }
}