/**
 * 
 */
package orbits;

import java.util.Scanner;

/**
 * @author Richard
 *
 */
public class Numberwork {
	private static void enterOrbitDetails(Orbit o, Scanner sc){
		System.out.print("Name of the body: ");
		o.setBody(sc.nextLine());
		sc.nextLine(); // Purge that buffer fam
		System.out.print("Mass of body: ");
		o.setMassOfBody(sc.nextInt());
		System.out.print("Radius of body: ");
		o.setRadiusOfBody(sc.nextInt());
		System.out.print("Semimajor axis: ");
		o.setSemimajorAxis(sc.nextInt());
		System.out.print("Inclination: ");
		o.setInclination(sc.nextDouble());
		System.out.print("Eccentricity: ");
		o.setEccentricity(sc.nextDouble());
		System.out.print("Longitude of the Ascending node: ");
		o.setLongitudeOfAscNode(sc.nextDouble());
		System.out.print("Argument of periapsis: ");
		o.setArgOfPeriapsis(sc.nextDouble());
		System.out.print("Mean anomaly at epoch");
		o.setMeanAnomaly(sc.nextDouble());
	}
	public static void main(String[] args) {
		Orbit o = new Orbit();
		Scanner sc = new Scanner(System.in);
		enterOrbitDetails(o, sc);
		System.out.println(o.toString());
	}

}
