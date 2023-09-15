// not prior for now 

class Solution {
    
    public int minCostConnectPoints(int[][] points) {
        int dist = 0, pointer = 0;
        Point[] ps = initPoints(points);
        
        while (pointer < points.length) {
            Point point = ps[pointer++];
            
            dist += point.dist == Integer.MAX_VALUE ? 0 : point.dist;
            
            int nextPoint = findNextPoint(ps, point, pointer);
            
            if (nextPoint > -1)
                swap(ps, nextPoint, pointer);
        }
        
        return dist;
    }
    
    private class Point {
        int x, y, dist;
        
        public Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    
    private Point[] initPoints(int[][] points) {
        Point[] ps = new Point[points.length];
        
        for (int i = 0; i < points.length; i++) {
            int[] p = points[i];
            
            ps[i] = new Point(p[0], p[1], Integer.MAX_VALUE);
        }
        
        return ps;
    }
    
    private int findNextPoint(Point[] ps, Point point, int start) {
        int idx = -1, min = Integer.MAX_VALUE;
        
        for (int i = start; i < ps.length; i++) {
            int m = Math.abs(point.x - ps[i].x) + Math.abs(point.y - ps[i].y);
            
            ps[i].dist = Math.min(ps[i].dist, m);
            
            if (ps[i].dist < min) {
                min = ps[i].dist;
                idx = i;
            }
        }
        
        return idx;
    }
    
    private void swap(Point[] ps, int i, int j) {
        Point tmp = ps[i];
        
        ps[i] = ps[j];
        ps[j] = tmp;
    }
}