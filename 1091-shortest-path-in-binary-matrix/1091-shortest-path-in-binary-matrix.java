class Solution {
    int[] dx = new int[]{0, -1, 1, 0, 1, -1, -1, 1};
    int[] dy = new int[]{1, 0, 0, -1, 1, -1, 1, -1}; // 대각선까지

    public int shortestPathBinaryMatrix(int[][] grid) {
        int x = grid[0].length-1;
        int y = grid.length-1;

        if (grid[x][y] == 1 || grid[0][0] == 1) { // 목적지가 1이면 어차피 갈 수 없다.
            return -1;
        }

        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[x+1][y+1];
        q.add(new int[]{0,0,1});
        visited[0][0] = true;
        

        while (!q.isEmpty()) {
            int[] polled = q.poll();
            int cx = polled[0];
            int cy = polled[1];
            int distance = polled[2];

            if (cx == x && cy == y) { // 방문한 위치가 목적지라면 거리를 return
                return distance;
            }

            for (int i=0; i<8; ++i) {
                int nx = cx + dx[i]; // 방문예정 x축
                int ny = cy + dy[i]; // 방문예정 y축

                if (nx > x || ny > y || nx < 0 || ny < 0) continue;
                if (visited[nx][ny]) continue;
                if (grid[nx][ny] == 1) continue; // 1은 못감

                q.add(new int[]{nx, ny, distance+1});
                visited[nx][ny] = true;
            }
        }
        return -1;
    }
}