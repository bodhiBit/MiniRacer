/**
 * 
 */
package gui;

/**
 * @author Tommy Pedersen
 *
 */
public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		MainWindow frame = new MainWindow();
		frame.setVisible(true);
		while(true) {
			try {
				Thread.sleep(33);
				frame.update();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
