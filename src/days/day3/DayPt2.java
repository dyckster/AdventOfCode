package days.day3;

import java.util.HashMap;

public class DayPt2 {
    private enum Direction {
        NORTH, SOUTH, EAST, WEST
    }

    private static class Location {
        int x;
        int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return (x + "," + y);
        }
    }

    private static int getValue(HashMap<String, Integer> map, int x, int y) {
        int value = 0;
        Location location = new Location(x, y);
        if (map.containsKey(location.toString())) {
            value = map.get(location.toString());
        }
        return value;
    }

    private static final int INPUT = 277678;

    public static void main(String[] args) {
        int x = 0;
        int y = 0;
        int layerSteps = 1;
        Boolean newLayer = true;
        Direction direction = Direction.EAST;
        HashMap<String, Integer> valueMap = new HashMap<>();
        valueMap.put(new Location(0, 0).toString(), 1);
        while (true) {
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

                int value = 0;

                value += getValue(valueMap, x, y + 1);
                value += getValue(valueMap, x, y - 1);
                value += getValue(valueMap, x + 1, y);
                value += getValue(valueMap, x + 1, y + 1);
                value += getValue(valueMap, x + 1, y - 1);
                value += getValue(valueMap, x - 1, y);
                value += getValue(valueMap, x - 1, y + 1);
                value += getValue(valueMap, x - 1, y - 1);

                if (value >= INPUT) {
                    System.out.println(value);
                    System.exit(0);
                } else {
                    valueMap.put(new Location(x, y).toString(), value);
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
