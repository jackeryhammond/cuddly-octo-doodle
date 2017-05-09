import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleAnimation  {
	
	int x = 10;
	int y = 10;

	public static void main(String[] args) {

		SimpleAnimation gui = new SimpleAnimation();

		gui.go();

	}

	public void go() {

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		MyDrawPanel dp = new MyDrawPanel();

		frame.getContentPane().add(BorderLayout.CENTER, dp);

		frame.setSize(1000,1000);
		frame.setVisible(true);

		for(int i = 0; i < 990; i++) {

			x++;
			y++;
			
			dp.repaint();

			try { 
				Thread.sleep(10);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}


	}


	class MyDrawPanel extends JPanel {

		public void paintComponent(Graphics g) {
			g.setColor(Color.RED);
			g.fillOval(x,y,40,40);
		}
	}


}