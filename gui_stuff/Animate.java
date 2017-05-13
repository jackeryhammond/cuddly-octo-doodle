import javax.swing.*;
import java.awt.*;

public class Animate {
	int x = 1;
	int y = 1;

	public static void main(String[] args) {

		Animate animate = new Animate();
		animate.go();

	}

	public void go(){

		//Initialise window
		JFrame frame = new JFrame("Animate");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		MyDrawP dp = new MyDrawP();

		frame.getContentPane().add(dp);

		frame.setSize(500,270);
		frame.setVisible(true);

		//Animation
		for(int i = 0; i < 124; i++, x++, y++){
			dp.repaint();

			try {
				Thread.sleep(50);
			}
			catch(Exception e) {
			}


		}

	}

	class MyDrawP extends JPanel {

		public void paintComponent(Graphics g) {

			g.setColor(Color.white);
			g.fillRect(0,0,500,250);
			g.setColor(Color.blue);
			g.fillRect(x, y, 500-x*2, 250-y*2);

		}
	}
}