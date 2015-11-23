package orbits;

public class Orbit {
	private double eccentricity, inclination, longitudeOfAscNode, argOfPeriapsis, meanAnomaly;
	private int semimajorAxis, radiusOfBody, massOfBody;
	private String body;
	
	public String toString(){
		return "Body: " + body +
				" Radius of body: " + radiusOfBody +
				" SMI: " + semimajorAxis +
				" Inc: " + inclination +
				" Ecc: " + eccentricity +
				" LongitudeOfAscNode: " + longitudeOfAscNode +
				" ArgOfPeriapsis: " + argOfPeriapsis +
				" MeanAnomaly: " + meanAnomaly;
	}
	
	
	
	/**
	 * @return the massOfBody
	 */
	public int getMassOfBody() {
		return massOfBody;
	}
	/**
	 * @param massOfBody the massOfBody to set
	 */
	public void setMassOfBody(int massOfBody) {
		this.massOfBody = massOfBody;
	}	
	/**
	 * @return the eccentricity
	 */
	public double getEccentricity() {
		return eccentricity;
	}
	/**
	 * @param eccentricity the eccentricity to set
	 */
	public void setEccentricity(double eccentricity) {
		this.eccentricity = eccentricity;
	}
	/**
	 * @return the inclination
	 */
	public double getInclination() {
		return inclination;
	}
	/**
	 * @param inclination the inclination to set
	 */
	public void setInclination(double inclination) {
		this.inclination = inclination;
	}
	/**
	 * @return the longitudeOfAscNode
	 */
	public double getLongitudeOfAscNode() {
		return longitudeOfAscNode;
	}
	/**
	 * @param longitudeOfAscNode the longitudeOfAscNode to set
	 */
	public void setLongitudeOfAscNode(double longitudeOfAscNode) {
		this.longitudeOfAscNode = longitudeOfAscNode;
	}
	/**
	 * @return the argOfPeriapsis
	 */
	public double getArgOfPeriapsis() {
		return argOfPeriapsis;
	}
	/**
	 * @param argOfPeriapsis the argOfPeriapsis to set
	 */
	public void setArgOfPeriapsis(double argOfPeriapsis) {
		this.argOfPeriapsis = argOfPeriapsis;
	}
	/**
	 * @return the meanAnomaly
	 */
	public double getMeanAnomaly() {
		return meanAnomaly;
	}
	/**
	 * @param meanAnomaly the meanAnomaly to set
	 */
	public void setMeanAnomaly(double meanAnomaly) {
		this.meanAnomaly = meanAnomaly;
	}
	/**
	 * @return the semimajorAxis
	 */
	public int getSemimajorAxis() {
		return semimajorAxis;
	}
	/**
	 * @param semimajorAxis the semimajorAxis to set
	 */
	public void setSemimajorAxis(int semimajorAxis) {
		this.semimajorAxis = semimajorAxis;
	}
	/**
	 * @return the radiusOfBody
	 */
	public int getRadiusOfBody() {
		return radiusOfBody;
	}
	/**
	 * @param radiusOfBody the radiusOfBody to set
	 */
	public void setRadiusOfBody(int radiusOfBody) {
		this.radiusOfBody = radiusOfBody;
	}
	/**
	 * @return the body
	 */
	public String getBody() {
		return body;
	}
	/**
	 * @param body the body to set
	 */
	public void setBody(String body) {
		this.body = body;
	}	
}
