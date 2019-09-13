public class QuadTree_leetcode427 {

    public Node construct(int[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return  null;
        }
        return dfs(grid, 0, grid.length-10, 0, grid[0].length-1);
    }

    public Node dfs(int[][] grid, int r1, int r2, int c1, int c2) {
        if(r1 > r2 || c1 > c2) {
            return null;
        }

        int val = grid[r1][c1];
        boolean isLeaf = true;
        for(int i=r1;i<=r2;i++) {
            for(int j=c1;j<=c2;j++) {
                if(grid[i][j] != val) {
                    isLeaf = false;
                    break;
                }
            }
        }

        if(isLeaf) {
            return new Node(val == 1, true, null, null, null, null);
        }

        Node node = new Node(false, false, null, null, null, null);
        int rowCenter = (int) (r1+r2)/2;
        int colCenter = (int) (c1+c2)/2;

        node.topLeft = dfs(grid, r1, rowCenter, c1, colCenter);
        node.topRight = dfs(grid, r1, rowCenter, colCenter+1, c2);
        node.bottomLeft = dfs(grid, rowCenter+1, r2, c1, colCenter);
        node.bottomRight = dfs(grid, rowCenter+1, r2, colCenter+1, c2);
        return node;
    }

    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {}

        public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    };
}
