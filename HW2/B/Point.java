package B;

import edu.princeton.cs.introcs.*;

public final class Point {
    private final double x;    // x-coordinate
    private final double y;    // y-coordinate

    // random point
    public Point() {
        x = StdRandom.uniform(0.0, 1.0);
        y = StdRandom.uniform(0.0, 1.0);
    }

    // point initialized from parameters
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // accessor methods
    public double x() { return x; }
    public double y() { return y; }
    public double r() { return Math.sqrt(x*x + y*y); }
    public double theta() { return Math.atan2(y, x); }

    // Euclidean distance between this point and that point
    public double distanceTo(Point that) {
        double dx = this.x - that.x;
        double dy = this.y - that.y;
        return Math.sqrt(dx*dx + dy*dy);
    }

    // return a string representation of this point
    public String toString() {
        return "(" + x + ", " + y + ")";
    }



    // // test client
    // public static void main(String[] args) {
    //     Point p = new Point();
    //     StdOut.println("p  = " + p);
    //     StdOut.println("   x     = " + p.x());
    //     StdOut.println("   y     = " + p.y());
    //     StdOut.println("   r     = " + p.r());
    //     StdOut.println("   theta = " + p.theta());
    //     StdOut.println();

    //     Point q = new Point(0.5, 0.5);
    //     StdOut.println("q  = " + q);
    //     StdOut.println("dist(p, q) = " + p.distanceTo(q));
    // }
}
