class Solution {
    int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int x = grid[0].length-1;
        int y = grid.length-1;

        if (grid[0][0] == 1 || grid[y][x] == 1) {
            return -1;
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1}); // 0, 0부터 시작
        int[][] visited = new int[x+1][y+1]; // x, y 가 배열의 길이인지 체크해야함
        visited[0][0] = 1;
        
        while (!q.isEmpty()) {
            int[] popped = q.poll();
            int px = popped[0];
            int py = popped[1];
            int distance = popped[2];

            if (px == x && py == y) {
                return distance;
            }
            
            // 8방향 위, 아래, 왼, 오, 대각선 4방향
            for (int i=0; i<8; ++i) {
                int nx = px + dx[i];
                int ny = py + dy[i];
                // 밖으로 벗어나는 영역이면 pass
                if (nx > x || ny > y || nx < 0 || ny < 0) continue;
                if (visited[nx][ny] == 1) continue;
                if (grid[nx][ny] == 1) continue; 
                
                q.add(new int[]{nx, ny, distance+1});
                visited[nx][ny] = 1;
            }
        }
        return -1;
    }
}