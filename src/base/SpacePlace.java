package base;

public class SpacePlace {
    private int xOrg;
    private int yOrg;
    private Coordinates coordinates; // Consolidated data into a separate class

    public SpacePlace() {
        xOrg = 0;
        yOrg = 0;
        coordinates = new Coordinates(0, 0, 0, 0);
    }

    public SpacePlace(double theta, double phi) {
        super();
        coordinates = new Coordinates(0, 0, theta, phi);
    }

    public int getxOrg() {
        return xOrg;
    }

    public void setxOrg(int xOrg) {
        this.xOrg = xOrg;
    }

    public int getyOrg() {
        return yOrg;
    }

    public void setyOrg(int yOrg) {
        this.yOrg = yOrg;
    }

    public double getTheta() {
        return coordinates.getTheta();
    }

    public void setTheta(double theta) {
        coordinates.setTheta(theta);
    }

    public double getPhi() {
        return coordinates.getPhi();
    }

    public void setPhi(double phi) {
        coordinates.setPhi(phi);
    }

    // Inner class to represent coordinates
    private static class Coordinates {
        private double theta;
        private double phi;

        public Coordinates(int xOrg, int yOrg, double theta, double phi) {
            this.theta = theta;
            this.phi = phi;
        }

        public double getTheta() {
            return theta;
        }

        public void setTheta(double theta) {
            this.theta = theta;
        }

        public double getPhi() {
            return phi;
        }

        public void setPhi(double phi) {
            this.phi = phi;
        }
    }
}
