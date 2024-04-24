package B;

import java.util.ArrayList;

public class Shape {
    //Center
    Point center;

    //Nearest point
    Point nearestPoint;

    //R
    double r = 9999;

    //Array point
    ArrayList<Point> vertices;

    //Constructor
    Shape(String init){

        String[] tmp = init.split("\\s+");

        int size = tmp.length;
        vertices = new ArrayList<>();

        double tmpCenterX = 0;
        double tmpCenterY = 0;

        double tmpNearestPointX = 0;
        double tmpNearestPointY = 0;

        for(int i = 0; i < size - 1; i+=2){

            double x = Double.parseDouble(tmp[i]);
            double y = Double.parseDouble(tmp[i + 1]);
            vertices.add(new Point(x, y));
            tmpCenterX += x;
            tmpCenterY += y;

        }
        //Set value for center
        double centerX = 2 * tmpCenterX / size;
        double centerY = 2 * tmpCenterY / size;
        center = new Point(centerX, centerY);


        for(Point p : vertices){
            if(p.distanceTo(center) < r){
                r = p.distanceTo(center);
                tmpNearestPointX = p.x();
                tmpNearestPointY = p.y();
            }
        }
        
        nearestPoint = new Point(tmpNearestPointX, tmpNearestPointY);


    }

    public boolean cut(Shape b){
        boolean in = false;
        boolean out = false;
        Point centerOf_b = b.center;
        double dis = centerOf_b.distanceTo(center);
        if(dis < r + b.r){
            in = true;
            for(Point p : b.vertices){
                if(p.distanceTo(center) > r){
                    out = true;
                    break;
                }
            }

        }
        if(out && in){
            return true;
        }
        return false;
    }

    public int encircles(Shape b){
        double dis = b.center.distanceTo(center);
        if(dis < r){
            return 2;
        }
        if(dis < r + b.r){
            return 1;
        }
        return 0;
    }


}
