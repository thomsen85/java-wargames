package edu.ntnu.thosve.formations;

import edu.ntnu.thosve.units.Unit;

import java.util.List;

public class RectangleFormation extends Formation{
    public RectangleFormation(int xBottomLeft, int yBottomLeft, int xTopRight, int yTopRight) {
        super(xBottomLeft, yBottomLeft, xTopRight, yTopRight);
    }

    @Override
    public void spreadUnits(List<Unit> units) {
        int columns = 1;
        int rows = 1;

        int height = yTopRight - yBottomLeft;
        int width = xTopRight - xBottomLeft;


        while (columns * rows < units.size()) {
            if (width / (columns + 1) > height / (rows + 1)) {
                columns += 1;
            } else {
                rows += 1;
            }
        }

        for(int row = 0; row < rows; row++ ) {
            for(int column = 0; column < columns; column++) {
                double x = column * ( (double) width / (columns-1)) + xBottomLeft;
                double y =  row * ( (double) height / (rows-1)) + yBottomLeft;
                int index = column + (row*columns);
                if (index < units.size()) {
                    units.get(index).setPos(x, y);
                }
            }
        }
    }

}
