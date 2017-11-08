/*Michelle Bushoy
 * Project 3
 * Tuesday and Thursday, 6:15-7:15
 * Omar Masood
 *“I affirm that I have not given or received any unauthorized help on this assignment, and that this work is my own.”
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AcmeFireworksApp extends JFrame {

	protected static JFrame frame;

	public static void main(String[] args) {

		JFrame frame = new JFrame("Acme Fireworks Simulator");
		AcmeFireworks panel = new AcmeFireworks();
		frame.add(panel);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setSize(500, 500);
		frame.setVisible(true);

	}

}
