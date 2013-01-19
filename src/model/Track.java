/**
 * 
 */
package model;

import java.util.ArrayList;

/**
 * @author bodhiBit
 *
 */
public class Track {
	private String imageFilename;
	private ArrayList<Car> cars;
	private ArrayList<CheckPoint> checkPoints;
	private int startX;
	private int startY;
	private double startAngle;
	
	/**
	 * 
	 * @param imageFilename
	 */
	public Track(String imageFilename) {
		this.imageFilename = imageFilename;
		this.cars = new ArrayList<Car>();
		this.checkPoints = new ArrayList<CheckPoint>();
	}
	
	

	/**
	 * @return the imageFilename
	 */
	public String getImageFilename() {
		return imageFilename;
	}



	/**
	 * @param imageFilename the imageFilename to set
	 */
	public void setImageFilename(String imageFilename) {
		this.imageFilename = imageFilename;
	}



	/**
	 * @return the cars
	 */
	public ArrayList<Car> getCars() {
		return new ArrayList<Car>(cars);
	}
	
	public Car createCar(String imageFilename) {
		Car car = new Car(this, imageFilename, startX, startY, startAngle);
		return car;
	}

	/**
	 * @param cars the cars to set
	 */
	public void addCar(Car car) {
		if (!this.cars.contains(car)) {
			this.cars.add(car);
			car.setTrack(this);
		}
	}

	/**
	 * @param cars the cars to set
	 */
	public void removeCar(Car car) {
		if (this.cars.contains(car)) {
			this.cars.remove(car);
			car.setTrack(null);
		}
	}

	/**
	 * @return the checkPoints
	 */
	public ArrayList<CheckPoint> getCheckPoints() {
		return new ArrayList<CheckPoint>(checkPoints);
	}

	/**
	 * @param checkPoints the checkPoints to set
	 */
	public void addCheckPoints(CheckPoint checkPoint) {
		if (!this.checkPoints.contains(checkPoint)) {
			this.checkPoints.add(checkPoint);
		}
	}
	
	/**
	 * @param checkPoints the checkPoints to set
	 */
	public void removeCheckPoints(CheckPoint checkPoint) {
		if (this.checkPoints.contains(checkPoint)) {
			this.checkPoints.remove(checkPoint);
		}
	}

	/**
	 * @return the startX
	 */
	public int getStartX() {
		return startX;
	}

	/**
	 * @return the startY
	 */
	public int getStartY() {
		return startY;
	}

	/**
	 * @param startY the startY to set
	 */
	public void setStartLocation(int startX, int startY) {
		this.startX = startX;
		this.startY = startY;
	}

	/**
	 * @return the startAngle
	 */
	public double getStartAngle() {
		return startAngle;
	}

	/**
	 * @param startAngle the startAngle to set
	 */
	public void setStartAngle(double startAngle) {
		this.startAngle = startAngle;
	}
	
	
	
}