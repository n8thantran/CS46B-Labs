package transport;

public class DamagedRover extends MarsRover{
    private final static int MAX_TRAVEL_METERS_BEFORE_EMPTY_BATTERY = 500;
    private final static int METERS_FROM_START_TO_CLIFF = 1000;
    private final static int N_SIMULATIONS = 500;

    private double position; // Distance from start. Range is
                             // -1000 to +1000. If Rover travels
                             // beyond this range, it falls off
                             // a cliff.
    private double metersTraveled; // Total meters traveled
                                   // back and forth.
    private boolean fell;          // If true, an expensive loss.

    public void simulateStormDamageTravel() {
        while (metersTraveled < MAX_TRAVEL_METERS_BEFORE_EMPTY_BATTERY) {
            double distanceNextTurn = (int) (1 + 4 * Math.random());
            boolean forwardNotBack = (Math.random() > 0.5);
            if (forwardNotBack) {
                double newPos = position + distanceNextTurn;
                position = newPos;
            }
            else {
                position = position - distanceNextTurn;
            }

            metersTraveled += distanceNextTurn;

            if(position > METERS_FROM_START_TO_CLIFF) {
                fell = true;
                break;
            }
            else {
                continue;
            }
        }
    }

    public double getMetersTraveled() {
        return metersTraveled;
    }

    public boolean getFell() {
        return fell;
    }

    public static void main(String[] args) {
        DamagedRover rova = new DamagedRover();
        rova.simulateStormDamageTravel();
        if(rova.getFell()) {
            System.out.println("Fell, Meters Travelled: " + rova.getMetersTraveled());
        } else {
            System.out.println("No more power, Meters Travelled: " + rova.getMetersTraveled());
        }

        DamagedRover rover = new DamagedRover();
        int fallCount = 0;
        for (int i = 0; i < N_SIMULATIONS; i++) {
            rover.simulateStormDamageTravel();
            if (rover.getFell()) {
                fallCount++;
            }
        }
        System.out.println("Rover fell off the cliff " + fallCount + " out of " + N_SIMULATIONS + " simulations.");
    }   

}
