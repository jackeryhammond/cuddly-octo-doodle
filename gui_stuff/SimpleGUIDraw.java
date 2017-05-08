import javax.swing.*;

public class SimpleGUIDraw {

	public static void main (String[] args) {

		JFrame frame = new JFrame();

		//JButton button = new JButton("click me");
		JPanel myPanel = new MyDrawPanel();


		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(myPanel);
		
		frame.setSize(300,300);
		frame.setVisible(true);

	}
}