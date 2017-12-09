package days.day3;

import javax.swing.*;
import java.applet.Applet;
import java.awt.*;

public class Day3 extends JFrame {

    private static final int ENTRY_POINT = 1;
    private static final int MAX_DATA = 277678;
    private static final int INPUT = 23;

    private static final int FRAME_H = 1000;
    private static final int FRAME_W = 1000;
    private static final int CENTER = FRAME_H / 2;

    private static final int STEP = 2; //px


    public Day3() {
        setSize(new Dimension(FRAME_W, FRAME_H));
        setVisible(true);
    }

    public static void main(String[] args) {
        new Day3();
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        Graphics2D g = (Graphics2D) graphics;
        final int repeats = 2;
        int current = 1;

        int directionIndex = 0;
        int lastX = CENTER;
        int lastY = CENTER;

        for (int i = 0; i < MAX_DATA; i++) {
            System.out.println(i);
            for (int r = 0; r < repeats; r++) {
                int dirX = Direction.values()[directionIndex].x;
                int dirY = Direction.values()[directionIndex].y;

                for (int c = 0; c < current; c++) {
                    g.drawLine(lastX, lastY, lastX + dirX, lastY + dirY);
                    lastX += dirX;
                    lastY += dirY;
                }
                current++;
                directionIndex++;
                if (directionIndex >= Direction.values().length) {
                    directionIndex = 0;
                }
            }
        }
    }

    private enum Direction {
        RIGHT(STEP, 0),
        TOP(0, -STEP),
        LEFT(-STEP, 0),
        BOTTOM(0, STEP);
        int x;
        int y;

        Direction(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

}
