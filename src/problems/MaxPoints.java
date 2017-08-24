package problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Given n points on a 2D plane,
 * find the maximum number of points that lie on the same straight line.
 */
public class MaxPoints {

    public int maxPoints(Point[] points) {
        Map<Line, Integer> map = new HashMap<>();
        for (int i = 1; i < points.length; i++) {
            for (int j = 0; j < i; j++) {
                Line line = calLine(points[i], points[j]);
                if (map.containsKey(line)) {
                    int count = map.get(line);
                    map.put(line, count++);
                } else {
                    map.put(line, 1);
                }
            }
        }
        return 0;
    }

    public Line calLine(Point a, Point b) {
        Slope slope = new Slope(a.x - b.x, a.y - b.y);
        return new Line(slope, 0);
    }

}

class Line {

    Slope slope;
    int intersection;

    public Line(Slope slope, int intersection) {
        this.slope = slope;
        this.intersection = intersection;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    public boolean equals(Line e) {
        return true;
    }
}

class Slope {
    int a;
    int b;
    boolean positive;

    public Slope(int a, int b) {
        int gdc = GDC(Math.abs(a), Math.abs(b));
        this.a = a / gdc;
        this.b = b / gdc;
        this.positive = (a/b > 0);
    }

    public int GDC(int a, int b) {
        if (b == 0) return a;
        return GDC(b, a % b);
    }
}

class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
