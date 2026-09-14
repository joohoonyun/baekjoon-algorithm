import java.util.*;

class Solution {
    int[] dx = new int[]{1, 0, -1, 0};
    int[] dy = new int[]{0, 1, 0, -1};
    int[][] visited;
    public int solution(int[][] maps) {
        int x = maps.length;
        int y = maps[0].length;
        visited = new int[x][y];
        
        return bfs(0, 0, x, y, maps);
    }
    
    private int bfs(int start, int end, int x, int y, int[][] maps) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{start, end});
        visited[start][end] = 1;
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nx = now[0];
            int ny = now[1];
            
            
            if (nx == x-1 && ny == y-1) {
                return visited[nx][ny];
            }
            
            for (int i=0; i<4; ++i) {
                int nextX = nx + dx[i];
                int nextY = ny + dy[i];
                
                if (nextX < 0 || nextY < 0 || nextX >= x || nextY >= y) continue;
                if (maps[nextX][nextY] == 0) continue;
                if (visited[nextX][nextY] != 0) continue;
                
                q.add(new int[]{nextX, nextY});
                visited[nextX][nextY] = visited[nx][ny] + 1;
            }
        }
        return -1;
    }
}