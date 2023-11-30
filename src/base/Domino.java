package base;

/**
 * Represents a domino piece with high and low values.
 * Handles placement and orientation of the domino.
 * 
 * @author Kevan Buckley, maintained by __student
 * @version 2.0, 2014
 */
public class Domino implements Comparable<Domino> {
    private int high;
    private int low;
    private Position position;
    boolean placed = false;

    public Domino(int high, int low) {
        this.high = high;
        this.low = low;
        this.position = new Position();
    }

    public void place(int hx, int hy, int lx, int ly) {
        this.position.setCoordinates(hx, hy, lx, ly);
        placed = true;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[");
        result.append(Integer.toString(high));
        result.append(Integer.toString(low));
        result.append("]");
        if (!placed) {
            result.append("unplaced");
        } else {
            result.append(position.toString());
        }
        return result.toString();
    }

    /**
     * Turn the domino around 180 degrees clockwise.
     */
    public void invert() {
        position.invert();
    }

    public boolean isHorizontal() {
        return position.isHorizontal();
    }

    public int compareTo(Domino arg0) {
        if (this.high < arg0.high) {
            return 1;
        }
        return this.low - arg0.low;
    }

    /**
     * Represents the position and orientation of the domino.
     */
    private class Position {
        private int hx;
        private int hy;
        private int lx;
        private int ly;

        public void setCoordinates(int hx, int hy, int lx, int ly) {
            this.hx = hx;
            this.hy = hy;
            this.lx = lx;
            this.ly = ly;
        }

        public void invert() {
            int tx = hx;
            hx = lx;
            lx = tx;

            int ty = hy;
            hy = ly;
            ly = ty;
        }

        public boolean isHorizontal() {
            return hy == ly;
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder();
            result.append("(");
            result.append(Integer.toString(hx + 1));
            result.append(",");
            result.append(Integer.toString(hy + 1));
            result.append(")");
            result.append("(");
            result.append(Integer.toString(lx + 1));
            result.append(",");
            result.append(Integer.toString(ly + 1));
            result.append(")");
            return result.toString();
        }
    }

	public boolean isPlaced() {
		return placed;
	}

	public boolean ishl() {
		// TODO Auto-generated method stub
		return false;
	}
}
