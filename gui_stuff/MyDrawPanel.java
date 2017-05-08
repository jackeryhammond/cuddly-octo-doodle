import java.awt.*;
import javax.swing.*;

/**
	Simple class that extends JPanel for me to play with and experiment.
*/

class MyDrawPanel extends JPanel {
	
	public void paintComponent(Graphics g) {

		Graphics2D g2d = (Graphics2D) g; //this is because you need to tell
		//the JVM that we want to use the Graphics2D methods, g is a GRAPHICS reference
		//and not a Graphics2D reference, even though g might reference a Graphics2D object

		g.fillRect(0,0,this.getWidth(),this.getHeight());

		int red = (int) (Math.random() * 256);
		int green = (int) (Math.random() * 256);
		int blue = (int) (Math.random() * 256);

		Color startColour = new Color(red, green, blue);

		red = (int) (Math.random() * 256);
		green = (int) (Math.random() * 256);
		blue = (int) (Math.random() * 256);

		Color endColour = new Color(red, green, blue);

		GradientPaint gradient = new GradientPaint(70, 70, startColour, 150, 150, endColour);
		// GradientPaint(starting point, sp, starting colour, ending point, ep, ending colour);

		g2d.setPaint(gradient);
		//this sets the virtual paint brush to paint a gradient instead of a solid colour

		g2d.fillOval(70,70,100,100);
		//fill oval with whatever the paint brush is programmed to do, in our case it is a gradient.
		

	}
}