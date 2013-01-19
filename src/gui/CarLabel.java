/**
 * 
 */
package gui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import model.Car;

/**
 * @author bodhiBit
 *
 */
@SuppressWarnings("serial")
public class CarLabel extends JLabel {
	private Car car;
	private ImageIcon image;
	private ImageIcon imageRotated;
	

	/**
	 * @param car
	 */
	public CarLabel(Car car) {
		super();
		this.car = car;
		
		this.image = new ImageIcon(getClass().getResource("res/images/"+getCar().getImageFilename()));
		this.imageRotated = new ImageIcon();
		setIcon(imageRotated);
		update();
	}

	/**
	 * @return the car
	 */
	public Car getCar() {
		return car;
	}

	/**
	 * @param car the car to set
	 */
	public void setCar(Car car) {
		this.car = car;
		update();
	}

	public void update() {
		imageRotated.setImage(ImageUtils.rotateImage(image.getImage(), Math.toDegrees(car.getAngle())));
		setSize(imageRotated.getIconWidth(), imageRotated.getIconHeight());
		setLocation(car.getX()-getWidth()/2, car.getY()-getHeight()/2);
	}
}