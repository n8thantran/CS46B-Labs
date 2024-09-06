package planets;

public class Planet {

    // NASA publishes masses of planets at
    // http://nssdc.gsfc.nasa.gov/planetary/factsheet/.
    // Mass units are 10^24 kg.
    private final static float MASS_UNIT = 1.0e24f;
    private final static Planet[] THE_PLANETS = {
            new Planet("Mercury", 0.33f * MASS_UNIT),
            new Planet("Venus", 4.87f * MASS_UNIT),
            new Planet("Earth", 5.97f * MASS_UNIT),
            new Planet("Mars", 0.642f * MASS_UNIT),
            new Planet("Jupiter", 1898 * MASS_UNIT),
            new Planet("Saturn", 568 * MASS_UNIT),
            new Planet("Uranus", 86.8f * MASS_UNIT),
            new Planet("Neptune", 102f * MASS_UNIT)
            // No more Pluto :-(
    };

    private String name;
    private float massKg;

    public Planet(String name, float massKg) {
        this.name = name;
        this.massKg = massKg;
    }

    public static Planet[] getAll() {
        return THE_PLANETS;
    }

    public String getName() {
        return this.name;
    }

    public float getMass() {
        return this.massKg;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setMass(float newMass) {
        this.massKg = newMass;
    }
    
    // Loop through the array with a for loop and then check if the largest mass is larger than the variable
    public static float getLargest(Planet[] planets) {

        float largest = 0;
        for(int i = 0; i < planets.length; i++) {
            if(planets[i].getMass() > largest) {
                largest = planets[i].getMass();
            }
        }
        return largest;
    }

    public String toString() {
        return this.name + ":" + this.massKg;
    }

    public static void main(String[] args) {
        Planet mercury = new Planet("Mercury", 0.33f * MASS_UNIT);
        mercury.setName("Venus");
        mercury.setMass(1000);
        Planet venus = new Planet("Uranus", 86.8f * MASS_UNIT);
        Planet[] planetos ={mercury, venus};
        System.out.println(mercury.getName());
        System.out.println(mercury.getMass());
        System.out.println(mercury);
        System.out.println(getLargest(planetos));
    }

}