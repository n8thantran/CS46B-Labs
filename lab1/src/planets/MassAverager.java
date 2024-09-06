package planets;

public class MassAverager {

    // Complete this. Retrieve the array of planets, then compute average mass.
    public float getMeanPlanetaryMass() {
        Planet[] THE_PLANETS = Planet.getAll();
        float MassTotal = 0;

        for(int i = 0; i < THE_PLANETS.length; i++) {
            MassTotal += THE_PLANETS[i].getMass();
        }
        return MassTotal/THE_PLANETS.length;
    }

    //
    // In almost all classes in almost all 46B homework assignments, the main()
    // method is for you to test your code. The autograder doesn't look at the
    // output from main().
    //
    // Since this assignment is simple, there's really only 1 useful version of
    // main(), and you can fill it in here. Later, when your assignments are more
    // complicated, your main() will change several or many times as you develop
    // different pieces of your assignment. It also serves as a great place to writ
    // test cases. Later in the semester, we will learn even more ways to guarantee
    // your code is correct
    public static void main(String[] args) {
        MassAverager averager = new MassAverager();
        System.out.println(averager.getMeanPlanetaryMass());
    }

}
