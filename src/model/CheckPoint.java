/**
 * 
 */
package model;

/**
 * @author Tommy Pedersen
 *
 */
public class CheckPoint implements Point {
	private int x;
	private int y;
	private int radius;
	
	/**
	 * @param x
	 * @param y
	 */
	public CheckPoint(int x, int y, int radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	
	public static double distance(Point point1, Point point2) {
		return Math.sqrt(Math.pow(Math.abs(point1.getX()-point2.getX()), 2) + Math.pow(Math.abs(point1.getY()-point2.getY()), 2));
	}
	
	public static boolean checkPointPassed(Car car, CheckPoint checkPoint1, CheckPoint checkPoint2) {
		if (distance(car, checkPoint2) > checkPoint2.getRadius())
			return false;
		else
			return distance(car, checkPoint1) > distance(car, checkPoint2);
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the radius
	 */
	public int getRadius() {
		return radius;
	}

	/**
	 * @param radius the radius to set
	 */
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	
}