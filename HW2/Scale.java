package HW2;

import java.awt.Color;

import edu.princeton.cs.introcs.Picture;

public class Scale {
    public static void main(String[] args) {
        String filename = args[0];
        int width  = Integer.parseInt(args[1]);
        int height = Integer.parseInt(args[2]);
        Picture source = new Picture(filename);
        Picture target = new Picture(width, height);

        for (int targetCol = 0; targetCol < width; targetCol++) {
            for (int targetRow = 0; targetRow < height; targetRow++) {
                int sourceCol = targetCol * source.width()  / width;
                int sourceRow = targetRow * source.height() / height;
                Color color = source.get(sourceCol, sourceRow);
                target.set(targetCol, targetRow, color);
            }
        }

        source.show();
        target.show();
    }
}