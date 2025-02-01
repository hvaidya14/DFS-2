// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//BFS
//TIME COMPLEXITY : O(M*N)
// SPACE COMPLEXITY :O(M+N)
class Solution {
    int count =0;
    public int numIslands(char[][] grid) {
        if (grid == null) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs= {{-1, 0}, {1, 0}, {0,-1}, {0, 1}};
        for (int i=0;i<m ;i++) {
            for (int j=0;j<n;j++) {
                if (grid[i][j] == '1') {
                    count++;
                    Queue<int[]> q = new LinkedList<>(); 
                    q.add(new int[]{i,j});
                    grid[i][j] = '2';
                    while(!q.isEmpty()) {
                        int[] curr = q.poll();
                        for (int[] dir:dirs) {
                            int nr = curr[0] + dir[0];
                            int nc = curr[1] + dir[1];
                            if (nr < m && nr >=0 && nc < n && nc>=0 && grid[nr][nc] =='1') {
                                q.add(new int[]{nr,nc});
                                grid[nr][nc] = '2';
                            }
                        }
                    }
                }
            }
        }

        return count;
    }
}


//TC :O(m*n)
//sc : O(m*n)
//DFS 
class Solution {
    int count =0;
    public int numIslands(char[][] grid) {
        if (grid == null) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs= {{-1, 0}, {1, 0}, {0,-1}, {0, 1}};
        for (int i=0;i<m ;i++) {
            for (int j=0;j<n;j++) {
                if (grid[i][j] == '1') {
                    count++;
                    grid[i][j] = '2';
                    dfs(i, j, dirs, m, n, grid);
                }
            }
        }
        return count;

    }
    private void dfs(int i, int j, int[][] dirs, int m, int n, char[][] grid) {
        for (int[] dir:dirs) {
            int nr = i + dir[0];
            int nc = j + dir[1];
            if (nr < m && nr >=0 && nc < n && nc>=0 && grid[nr][nc] =='1') {
                grid[nr][nc] = '2';
                dfs(nr,nc,dirs, m, n, grid);
            }
        }
        return;
    }
}
