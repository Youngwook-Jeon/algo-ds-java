package problems.programmers;

import java.util.*;

class 교점에별만들기 {
    private static class Point {
        public long x, y;

        private Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    public String[] solution(int[][] line) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                int[] l1 = new int[]{line[i][0], line[i][1], line[i][2]};
                int[] l2 = new int[]{line[j][0], line[j][1], line[j][2]};
                if (hasNoIntersectionPoints(l1, l2)) continue;

                Point p = findLatticePointOfTwoLines(l1, l2);
                if (p != null) points.add(p);
            }
        }

        Point minPoint = findMinimumPoint(points);
        Point maxPoint = findMaximumPoint(points);

        int width = (int) (maxPoint.x - minPoint.x + 1);
        int height = (int) (maxPoint.y - minPoint.y + 1);

        char[][] coord = new char[height][width];
        for (char[] r : coord) {
            Arrays.fill(r, '.');
        }

        for (Point p : points) {
            Point transformed = transform(p, minPoint, maxPoint);
            coord[(int) transformed.y][(int) transformed.x] = '*';
        }

        String[] ans = new String[coord.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = new String(coord[i]);
        }

        return ans;
    }

    private boolean hasNoIntersectionPoints(int[] l1, int[] l2) {
        return (l1[0] * l2[1] == l1[1] * l2[0]);
    }

    private Point findLatticePointOfTwoLines(int[] l1, int[] l2) {
        double x = ((double)l1[1] * l2[2] - l1[2] * l2[1]) / (l1[0] * l2[1] - l1[1] * l2[0]);
        double y = ((double)l1[2] * l2[0] - l1[0] * l2[2]) / (l1[0] * l2[1] - l1[1] * l2[0]);

        if (x % 1 != 0 || y % 1 != 0) return null;

        return new Point((long)x, (long)y);
    }

    private Point findMinimumPoint(List<Point> points) {
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;
        for (Point p : points) {
            if (p.x < x) x = p.x;
            if (p.y < y) y = p.y;
        }

        return new Point(x, y);
    }

    private Point findMaximumPoint(List<Point> points) {
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;
        for (Point p : points) {
            if (p.x > x) x = p.x;
            if (p.y > y) y = p.y;
        }

        return new Point(x, y);
    }

    private Point transform(Point p, Point minPoint, Point maxPoint) {
        long x = p.x - minPoint.x;
        long y = maxPoint.y - p.y;
        return new Point(x, y);
    }

    public static void main(String[] args) {
        교점에별만들기 makeStars = new 교점에별만들기();
        int[][] line = new int[][]{{0, 1, -1}, {1, 0, -1}, {1, 0, 1}};
        String[] ans = makeStars.solution(line);
        Arrays.stream(ans)
                .forEach(System.out::println);
    }
}
