package B;

import java.util.*;

public class Shape {
    
    double centerX;
    double centerY;

    double r;

    double vertexX;
    double vertexY;
    TreeMap<Double, Double> vertices;

    Shape(String init){

        vertices = new TreeMap<>();
        String[] tmp = init.split("\\s+");
        r = 9999;

        for(int i = 0; i < tmp.length - 1; i+=2){

            double x = Double.parseDouble(tmp[i]);
            double y = Double.parseDouble(tmp[i + 1]);
            vertices.put(x, y);
            centerX += x;
            centerY += y;
        }

        centerX = 2 * centerX / tmp.length;
        centerY = 2 * centerY / tmp.length;

        for(Map.Entry<Double, Double> entry : vertices.entrySet()){
            if(Math.pow(Math.abs(entry.getKey() - centerX), 2) + Math.pow(Math.abs(entry.getValue() - centerY), 2) <= Math.pow(r, 2)){
                r = Math.sqrt(Math.pow(Math.abs(entry.getKey() - centerX), 2) + Math.pow(Math.abs(entry.getValue() - centerY), 2));
                vertexX = entry.getKey();
                vertexY = entry.getValue();
            }
        }

    }

    public boolean cut(Shape b){
        boolean in = false;
        boolean out = false;
        double dis = Math.sqrt(Math.pow(Math.abs(centerX - b.centerX), 2) + Math.pow(Math.abs(centerY - b.centerY), 2));
        if(dis < r + b.r){
            in = true;
            for(Map.Entry<Double, Double> entry : b.vertices.entrySet()){
                double dis1 = Math.sqrt(Math.pow(Math.abs(entry.getKey() - centerX), 2) + Math.pow(Math.abs(entry.getValue() - centerY), 2));
                if(dis1 > r){
                    out = true;
                }
            }
        }
        if(out && in){
            return true;
        }
        return false;
    }

    public int encircles(Shape b){
        double dis = Math.sqrt(Math.pow(Math.abs(centerX - b.centerX), 2) + Math.pow(Math.abs(centerY - b.centerY), 2));
        if(dis < r){
            return 2;
        }
        if(dis < r + b.r){
            return 1;
        }
        return 0;
    }


}
