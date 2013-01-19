/**
 * 
 */
package model;

import java.util.Date;

/**
 * @author Tommy Pedersen
 *
 */
public class Car implements Point {
	private Track track;
	private String imageFilename;
	private long time;
	private double x;
	private double y;
	private double turn;
	private double leftMostTurn;
	private double rightMostTurn;
	private double angle;
	private byte direction;
	private double speed;
	private double topSpeed;
	private double backSpeed;
	private double acceleration;
	private double decceleration;
	private int checkPointsPassed;
	private int laps;
	
	public static final byte FORWARD = 1;
	public static final byte IDLE = 0;
	public static final byte BACKWARD = -1;
	
	/**
	 * Create a new car.
	 * 
	 * @param track
	 * @param x
	 * @param y
	 * @param angle
	 */
	public Car(Track track, String imageFilename, int x, int y, double angle) {
		this.imageFilename = imageFilename;
		this.time = new Date().getTime();
		this.x = x;
		this.y = y;
		this.turn = 0;
		this.leftMostTurn = -.02;
		this.rightMostTurn = .02;
		this.angle = angle;
		this.direction = IDLE;
		this.speed = 0;
		this.topSpeed = 2.0;
		this.backSpeed = -.5;
		this.acceleration = .005;
		this.decceleration = .003;
		this.checkPointsPassed = 0;
		this.laps = 0;
		
		setTrack(track);
	}

	/**
	 * @return the track
	 */
	public Track getTrack() {
		return track;
	}

	/**
	 * @param track the track to set
	 */
	public void setTrack(Track track) {
		if (this.track != track) {
			if (this.track != null)
				this.track.removeCar(this);
			this.track = track;
			if (this.track != null)
				this.track.addCar(this);
		}
	}
	
	private void drive() {
		long now = new Date().getTime();
		if (time >= now)
			return;
		while (time < now) {
			if (direction == FORWARD) {
				speed += acceleration;
			} else if (direction == BACKWARD) {
				speed -= acceleration;
			} else if (direction == IDLE) {
				if (speed > 0) {
					speed -= Math.min(speed, decceleration);
				} else if (speed < 0) {
					speed += Math.min(-speed, decceleration);
				}
			}
			speed = Math.max(backSpeed, Math.min(topSpeed, speed));
			angle += turn*speed;
			x += Math.sin(angle)*speed;
			y -= Math.cos(angle)*speed;
			time += 10;
		}
		if (CheckPoint.checkPointPassed(this, track.getCheckPoints().get(checkPointsPassed), track.getCheckPoints().get(checkPointsPassed+1)))
			checkPointsPassed++;
		if (checkPointsPassed > track.getCheckPoints().size()-2) {
			checkPointsPassed = 0;
			laps++;
		}
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
	 * @return the X
	 */
	public int getX() {
		drive();
		return (int) x;
	}

	/**
	 * @return the Y
	 */
	public int getY() {
		drive();
		return (int) y;
	}

	/**
	 * @param y the startY to set
	 */
	public void setLocation(int x, int y) {
		drive();
		this.x = x;
		this.y = y;
	}
	
	

	/**
	 * @return the turn
	 */
	public double getTurn() {
		return turn;
	}

	/**
	 * @param turn the turn to set
	 */
	public void setTurn(double turn) {
		this.turn = Math.max(leftMostTurn, Math.min(rightMostTurn, turn));
	}

	/**
	 * @return the leftMostTurn
	 */
	public double getLeftMostTurn() {
		return leftMostTurn;
	}

	/**
	 * @param leftMostTurn the leftMostTurn to set
	 */
	public void setLeftMostTurn(double leftMostTurn) {
		this.leftMostTurn = leftMostTurn;
	}

	/**
	 * @return the rightMostTurn
	 */
	public double getRightMostTurn() {
		return rightMostTurn;
	}

	/**
	 * @param rightMostTurn the rightMostTurn to set
	 */
	public void setRightMostTurn(double rightMostTurn) {
		this.rightMostTurn = rightMostTurn;
	}

	/**
	 * @return the angle
	 */
	public double getAngle() {
		drive();
		return angle;
	}

	/**
	 * @param angle the angle to set
	 */
	public void setAngle(double angle) {
		drive();
		this.angle = angle;
	}
	
	

	/**
	 * @return the direction
	 */
	public byte getDirection() {
		drive();
		return direction;
	}

	/**
	 * @param direction the direction to set
	 */
	public void setDirection(byte direction) {
		drive();
		this.direction = direction;
	}

	/**
	 * @return the speed
	 */
	public double getSpeed() {
		drive();
		return speed;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(double speed) {
		drive();
		this.speed = speed;
	}
	
	

	/**
	 * @return the topSpeed
	 */
	public double getTopSpeed() {
		return topSpeed;
	}

	/**
	 * @param topSpeed the topSpeed to set
	 */
	public void setTopSpeed(double topSpeed) {
		this.topSpeed = topSpeed;
	}

	/**
	 * @return the backSpeed
	 */
	public double getBackSpeed() {
		return backSpeed;
	}

	/**
	 * @param backSpeed the backSpeed to set
	 */
	public void setBackSpeed(double backSpeed) {
		this.backSpeed = backSpeed;
	}

	/**
	 * @return the acceleration
	 */
	public double getAcceleration() {
		return acceleration;
	}

	/**
	 * @param acceleration the acceleration to set
	 */
	public void setAcceleration(double acceleration) {
		this.acceleration = acceleration;
	}

	/**
	 * @return the decceleration
	 */
	public double getDecceleration() {
		return decceleration;
	}

	/**
	 * @param decceleration the decceleration to set
	 */
	public void setDecceleration(double decceleration) {
		this.decceleration = decceleration;
	}

	/**
	 * @return the checkPointsPassed
	 */
	public int getCheckPointsPassed() {
		return checkPointsPassed;
	}

	/**
	 * @param checkPointsPassed the checkPointsPassed to set
	 */
	public void setCheckPointsPassed(int checkPointsPassed) {
		this.checkPointsPassed = checkPointsPassed;
	}

	/**
	 * @return the laps
	 */
	public int getLaps() {
		return laps;
	}

	/**
	 * @param laps the laps to set
	 */
	public void setLaps(int laps) {
		this.laps = laps;
	}
}