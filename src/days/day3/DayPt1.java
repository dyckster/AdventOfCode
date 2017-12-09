package days.day3;

public class DayPt1 {
    private enum Direction {
        NORTH, SOUTH, EAST, WEST
    }

    private static final int INPUT = 277678;

    public static void main(String[] args) {
        int x = 0;
        int y = 0;
        int layerSteps = 1;
        Boolean newLayer = true;
        Direction direction = Direction.EAST;
        for (int i = 1; ; ) {
            for (int j = 0; j < layerSteps; j += 1) {
                switch (direction) {
                    case NORTH:
                        y += 1;
                        break;
                    case SOUTH:
                        y -= 1;
                        break;
                    case EAST:
                        x += 1;
                        break;
                    case WEST:
                        x -= 1;
                        break;
                }

                i += 1;
                if (i == INPUT) {
                    System.out.println(Math.abs(x) + Math.abs(y));
                    System.exit(0);
                }
            }
            switch (direction) {
                case NORTH:
                    direction = Direction.WEST;
                    break;
                case SOUTH:
                    direction = Direction.EAST;
                    break;
                case EAST:
                    direction = Direction.NORTH;
                    break;
                case WEST:
                    direction = Direction.SOUTH;
                    break;
            }
            newLayer = !newLayer;
            if (newLayer) {
                layerSteps += 1;
            }
        }
    }
}
