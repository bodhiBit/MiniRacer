package gui;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JLabel;

import model.Car;
import model.CheckPoint;
import model.Track;

/**
 * 
 * @author Tommy Pedersen
 *
 */
@SuppressWarnings("serial")
public class MainWindow extends JFrame {
	private Track track;
	private ArrayList<CarLabel> carLabels;

	private JPanel contentPane;
	private JPanel gamePanel;
	private JLabel trackLabel;
	private double angle;
	

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		gamePanel = new JPanel();
		gamePanel.setLayout(null);
		contentPane.add(gamePanel, BorderLayout.CENTER);
		
		trackLabel = new JLabel();
		gamePanel.add(trackLabel);
		
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent ke) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent ke) {
				// TODO Auto-generated method stub
				System.out.print("Key "+ke.getKeyCode()+" released:\t");
				switch (ke.getKeyCode()) {
				case 37:
					System.out.print("Don't turn left!");
					track.getCars().get(0).setTurn(0);
					break;
				case 38:
					System.out.print("Don't drive forward!");
					track.getCars().get(0).setDirection(Car.IDLE);
					break;
				case 39:
					System.out.print("Don't turn right!");
					track.getCars().get(0).setTurn(0);
					break;
				case 40:
					System.out.print("Don't drive backward!");
					track.getCars().get(0).setDirection(Car.IDLE);
					break;
				}
				System.out.println();
			}
			
			@Override
			public void keyPressed(KeyEvent ke) {
				// TODO Auto-generated method stub
				System.out.print("Key "+ke.getKeyCode()+" pressed: \t");
				switch (ke.getKeyCode()) {
				case 37:
					System.out.print("Turn left!");
					track.getCars().get(0).setTurn(-1);
					break;
				case 38:
					System.out.print("Drive forward!");
					track.getCars().get(0).setDirection(Car.FORWARD);
					break;
				case 39:
					System.out.print("Turn right!");
					track.getCars().get(0).setTurn(1);
					break;
				case 40:
					System.out.print("Drive backward!");
					track.getCars().get(0).setDirection(Car.BACKWARD);
					break;
				}
				System.out.println();
			}
		});
		
		newGame(1);
	}
	
	public void newGame(int numberOfCars) {
		if (carLabels == null) {
			carLabels = new ArrayList<CarLabel>();
		} else {
			while (carLabels.size() > 0) {
				gamePanel.remove(carLabels.remove(carLabels.size()-1));
			}
		}
		track = myTrack();
		trackLabel.setIcon(new ImageIcon(getClass().getResource("res/images/"+track.getImageFilename())));
		trackLabel.setSize(trackLabel.getIcon().getIconWidth(), trackLabel.getIcon().getIconHeight());
		for (int i=0;i<numberOfCars;i++) {
			track.createCar("car.png");
		}
		for (Car car : track.getCars()) {
			CarLabel carLabel = new CarLabel(car);
			carLabels.add(carLabel);
			gamePanel.add(carLabel);
			gamePanel.setComponentZOrder(carLabel, 0);
		}
	}
	
	private Track myTrack() {
		Track track = new Track("Racetrack.jpg");
		track.setStartLocation(290, 348);
		track.addCheckPoints(new CheckPoint(290, 348, 25));
		track.addCheckPoints(new CheckPoint(110, 348, 25));
		// TODO
		return track;
	}
	
	public void update() {
		if (carLabels != null) {
			for (CarLabel carLabel : carLabels) {
				carLabel.update();
			}
		}
	}

}
