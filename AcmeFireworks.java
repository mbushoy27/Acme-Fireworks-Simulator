
/*Michelle Bushoy
 * Project 3
 * Tuesday and Thursday, 6:15-7:15
 * Omar Masood
 *“I affirm that I have not given or received any unauthorized help on this assignment, and that this work is my own.”
 */

/*
 * This program is a simulator for Acme Fireworks Company for designers to use to develop new fireworks. A user can 
 * choose a firework color, firework type,time and enter a speed and angle to get the firework that they would like 
 * to see.
 */

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AcmeFireworks extends JPanel implements ActionListener, ChangeListener {
	protected String colorChoice;
	protected String fireworkChoice;
	protected JLabel launchAngle;
	protected TextField angle; // text box for angle
	protected String angleChoice;
	protected JLabel launchSpeed;
	protected TextField speed; // text box for speed
	protected String speedChoice;
	protected JComboBox colors; // drop down w color choices
	protected JComboBox fireworks; // drop down w firework choices
	protected JButton go;
	protected JSlider time;
	protected JLabel timeLabel; // telling user to choose a time;
	final int sliderMin = 0; // slider min
	final int sliderMax = 10; // slider max
	double newAngleChoice; // value of angle textfield
	double newSpeedChoice; // value of speed textfield
	double timeValue; // value of time slider
	int x; // x coordinate for projectile
	int y; // y coordinate for projectile
	final double gravity = 6.673 * (Math.pow(10, -11));

	String[] colorString = { "Choose a color", "red", "orange", "blue", "green", "yellow" };
	String[] fireworkString = { "Choose a firework type", "firework1", "firework2", "firework3", "firework4",
			"firework5" };

	AcmeFireworks() {

		// x = (int) (newSpeedChoice * (Math.cos(newAngleChoice)) * timeValue);
		// y = (int) ( (newSpeedChoice * (Math.sin(newAngleChoice)) * timeValue)
		// - ((0.5) * gravity * (Math.pow(timeValue, 2))));

		colors = new JComboBox(colorString);
		colors.addActionListener(this);
		add(colors);

		fireworks = new JComboBox(fireworkString);
		fireworks.addActionListener(this);
		add(fireworks);

		launchAngle = new JLabel("Enter a launch angle: ");
		add(launchAngle);

		angle = new TextField(10);
		angle.addActionListener(this);
		add(angle);

		launchSpeed = new JLabel("Enter a launch speed: ");
		add(launchSpeed);

		speed = new TextField(10);
		speed.addActionListener(this);
		add(speed);

		timeLabel = new JLabel("Choose a time");
		add(timeLabel);

		time = new JSlider(sliderMin, sliderMax);
		time.addChangeListener(this);
		time.setMinorTickSpacing(1);
		time.setMajorTickSpacing(10);
		time.setPaintTicks(true); // setting tick marks
		time.setPaintLabels(true);
		add(time);

		go = new JButton("GO!");
		go.addActionListener(this);
		add(go);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		


		System.out.println("go");
		if (e.getSource() == colors) {
			colorChoice = (String) colors.getSelectedItem();
		} else if (e.getSource() == fireworks) {
			fireworkChoice = (String) fireworks.getSelectedItem();
		} else if (e.getSource() == angle) {
			angleChoice = angle.getText();
			newAngleChoice = (double) Double.parseDouble(angleChoice); //changing string to double

		} else if (e.getSource() == speed) {
			speedChoice = speed.getText();
			newSpeedChoice = (double) Double.parseDouble(speedChoice); //changing string to double

		} else if (e.getSource() == go) { //go button
			repaint();
		}
	}

	public void paintComponent(Graphics g) {

		if (colorChoice == "red") {
			x = (int) (newSpeedChoice * (Math.cos(Math.toRadians(newAngleChoice))) * timeValue); 
			y = (int) ((newSpeedChoice * (Math.sin(Math.toRadians(newAngleChoice))) * timeValue)
					- ((0.5) * gravity * (Math.pow(timeValue, 2))));
			g.setColor(Color.RED);
			if (fireworkChoice == "firework1") {
				g.drawLine(250, 250, 250, 100);// up
				g.drawLine(250, 250, 250, 400);// down
				g.drawLine(250, 250, 100, 250);// left
				g.drawLine(250, 250, 400, 250);// right
				g.drawLine(250, 250, 400, 150); // up right
				g.drawLine(250, 250, 100, 150); // up left
				g.drawLine(250, 250, 400, 350);
				g.drawLine(250, 250, 100, 350);
				g.drawLine(250, 250, 175, 150);
				g.drawLine(250, 250, 175, 225);
				g.drawLine(250, 250, 175, 275);
				g.drawLine(250, 250, 325, 225);
				g.drawLine(250, 250, 325, 275);
				g.drawLine(250, 250, 325, 150);
				g.drawLine(250, 250, 175, 350);
				g.drawLine(250, 250, 325, 350);
				g.drawLine(250, 250, x, y);

			} else if (fireworkChoice == "firework2") {
				g.fillOval(250, 250, 10, 10);
				g.fillOval(260, 260, 20, 20);
				g.fillOval(275, 220, 40, 40); // big 1
				g.fillOval(250, 240, 8, 8);
				g.fillOval(265, 250, 5, 5);
				g.fillOval(265, 240, 7, 7);
				g.fillOval(248, 213, 25, 25);
				g.fillOval(290, 268, 10, 10);
				g.fillOval(303, 264, 8, 8);
				g.fillOval(312, 257, 10, 10);
				g.fillOval(263, 165, 50, 50);
				g.fillOval(315, 200, 35, 35);
				g.fillOval(317, 123, 70, 70);
				g.fillOval(355, 195, 15, 15);
				g.fillOval(290, 140, 20, 20);
				g.fillOval(x, y, 20, 20);
				g.drawLine(250, 250, x, y);
			} else if (fireworkChoice == "firework3") {
				g.drawLine(400, 400, 100, 100);
				g.drawLine(400, 400, 200, 100);
				g.drawLine(400, 400, 300, 100);
				g.drawLine(400, 400, 400, 100); // straight
				g.drawOval(420, 400, 20, 20);
				g.fillOval(420, 350, 20, 20);
				g.drawOval(420, 300, 20, 20);
				g.fillOval(420, 250, 20, 20);
				g.drawOval(420, 200, 20, 20);
				g.fillOval(420, 150, 20, 20);
				g.drawOval(420, 100, 20, 20);
				g.fillOval(420, 50, 20, 20);
				g.drawOval(200, 400, 20, 20);
				g.drawOval(260, 140, 20, 20);
				g.fillOval(15, 200, 20, 20);
				g.drawLine(250, 250, x, y);
				g.drawOval(x, y, 20, 20);
			} else if (fireworkChoice == "firework4") {
				int n = 9;
				int stepCoordinates = 10; // step for x and y
				int stepSize = 20; // step for width and height
				for (int p = 0; p < n; p++) {
					g.drawOval(0 + stepCoordinates * p, 0 + stepCoordinates * p, 500 - stepSize * p,
							500 - stepSize * p);

				}
				g.drawOval(250, 250, 20, 20);
				g.drawOval(300, 300, 20, 20);
				g.drawOval(350, 350, 20, 20);
				g.drawOval(200, 200, 20, 20);
				g.drawOval(150, 150, 20, 20);
				g.drawOval(x, y, 20, 20);
				g.drawLine(250, 250, x, y);
			} else if (fireworkChoice == "firework5") {
				g.drawLine(250, 400, 250, 100);
				g.drawLine(250, 250, x, y);
				g.fillOval(x, y, 20, 20);
				int n = 8;
				int step = 40;
				for (int i = 0; i < n; i++) { // lines on left
					g.drawLine(100, 100 + step * i, 200, 100 + step * i);
				}
				for (int j = 0; j < n; j++) { // lines on right
					g.drawLine(300, 100 + step * j, 400, 100 + step * j);
				}
				int step2 = 55;
				int n2 = 6;
				for (int k = 0; k < n2; k++) { // circles in mid
					g.drawOval(240, 100 + step2 * k, 20, 20);
				}

			}
		} else if (colorChoice == "orange") {
			x = (int) (newSpeedChoice * (Math.cos(Math.toRadians(newAngleChoice))) * timeValue);
			y = (int) ((newSpeedChoice * (Math.sin(Math.toRadians(newAngleChoice))) * timeValue)
					- ((0.5) * gravity * (Math.pow(timeValue, 2))));
			g.setColor(Color.ORANGE);
			if (fireworkChoice == "firework1") {
				g.drawLine(250, 250, 250, 100);// up
				g.drawLine(250, 250, 250, 400);// down
				g.drawLine(250, 250, 100, 250);// left
				g.drawLine(250, 250, 400, 250);// right
				g.drawLine(250, 250, 400, 150); // up right
				g.drawLine(250, 250, 100, 150); // up left
				g.drawLine(250, 250, 400, 350);
				g.drawLine(250, 250, 100, 350);
				g.drawLine(250, 250, 175, 150);
				g.drawLine(250, 250, 175, 225);
				g.drawLine(250, 250, 175, 275);
				g.drawLine(250, 250, 325, 225);
				g.drawLine(250, 250, 325, 275);
				g.drawLine(250, 250, 325, 150);
				g.drawLine(250, 250, 175, 350);
				g.drawLine(250, 250, 325, 350);
				g.drawLine(250, 250, x, y);
			} else if (fireworkChoice == "firework2") {
				g.fillOval(250, 250, 10, 10);
				g.fillOval(260, 260, 20, 20);
				g.fillOval(275, 220, 40, 40); // big 1
				g.fillOval(250, 240, 8, 8);
				g.fillOval(265, 250, 5, 5);
				g.fillOval(265, 240, 7, 7);
				g.fillOval(248, 213, 25, 25);
				g.fillOval(290, 268, 10, 10);
				g.fillOval(303, 264, 8, 8);
				g.fillOval(312, 257, 10, 10);
				g.fillOval(263, 165, 50, 50);
				g.fillOval(315, 200, 35, 35);
				g.fillOval(317, 123, 70, 70);
				g.fillOval(355, 195, 15, 15);
				g.fillOval(290, 140, 20, 20);
				g.fillOval(x, y, 20, 20);
				g.drawLine(250, 250, x, y);
			} else if (fireworkChoice == "firework3") {
				g.drawLine(400, 400, 100, 100);
				g.drawLine(400, 400, 200, 100);
				g.drawLine(400, 400, 300, 100);
				g.drawLine(400, 400, 400, 100); // straight
				g.drawOval(420, 400, 20, 20);
				g.fillOval(420, 350, 20, 20);
				g.drawOval(420, 300, 20, 20);
				g.fillOval(420, 250, 20, 20);
				g.drawOval(420, 200, 20, 20);
				g.fillOval(420, 150, 20, 20);
				g.drawOval(420, 100, 20, 20);
				g.fillOval(420, 50, 20, 20);
				g.drawOval(200, 400, 20, 20);
				g.drawOval(260, 140, 20, 20);
				g.fillOval(15, 200, 20, 20);
				g.drawLine(250, 250, x, y);
				g.drawOval(x, y, 20, 20);
			} else if (fireworkChoice == "firework4") {
				int n = 9;
				int stepCoordinates = 10; // step for x and y
				int stepSize = 20; // step for width and height
				for (int p = 0; p < n; p++) {
					g.drawOval(0 + stepCoordinates * p, 0 + stepCoordinates * p, 500 - stepSize * p,
							500 - stepSize * p);

				}
				g.drawOval(250, 250, 20, 20);
				g.drawOval(300, 300, 20, 20);
				g.drawOval(350, 350, 20, 20);
				g.drawOval(200, 200, 20, 20);
				g.drawOval(150, 150, 20, 20);
				g.drawOval(x, y, 20, 20);
				g.drawLine(250, 250, x, y);

			} else if (fireworkChoice == "firework5") {
				g.drawLine(250, 400, 250, 100);
				g.drawLine(250, 250, x, y);
				g.fillOval(x, y, 20, 20);
				int n = 8;
				int step = 40;
				for (int i = 0; i < n; i++) { // lines on left
					g.drawLine(100, 100 + step * i, 200, 100 + step * i);
				}
				for (int j = 0; j < n; j++) { // lines on right
					g.drawLine(300, 100 + step * j, 400, 100 + step * j);
				}
				int step2 = 55;
				int n2 = 6;
				for (int k = 0; k < n2; k++) { // circles in mid
					g.drawOval(240, 100 + step2 * k, 20, 20);
				}

			}
		} else if (colorChoice == "blue") {
			x = (int) (newSpeedChoice * (Math.cos(Math.toRadians(newAngleChoice))) * timeValue);
			y = (int) ((newSpeedChoice * (Math.sin(Math.toRadians(newAngleChoice))) * timeValue)
					- ((0.5) * gravity * (Math.pow(timeValue, 2))));
			g.setColor(Color.BLUE);
			if (fireworkChoice == "firework1") {
				g.drawLine(250, 250, 250, 100);// up
				g.drawLine(250, 250, 250, 400);// down
				g.drawLine(250, 250, 100, 250);// left
				g.drawLine(250, 250, 400, 250);// right
				g.drawLine(250, 250, 400, 150); // up right
				g.drawLine(250, 250, 100, 150); // up left
				g.drawLine(250, 250, 400, 350);
				g.drawLine(250, 250, 100, 350);
				g.drawLine(250, 250, 175, 150);
				g.drawLine(250, 250, 175, 225);
				g.drawLine(250, 250, 175, 275);
				g.drawLine(250, 250, 325, 225);
				g.drawLine(250, 250, 325, 275);
				g.drawLine(250, 250, 325, 150);
				g.drawLine(250, 250, 175, 350);
				g.drawLine(250, 250, 325, 350);
				g.drawLine(250, 250, x, y);
			} else if (fireworkChoice == "firework2") {
				g.fillOval(250, 250, 10, 10);
				g.fillOval(260, 260, 20, 20);
				g.fillOval(275, 220, 40, 40); // big 1
				g.fillOval(250, 240, 8, 8);
				g.fillOval(265, 250, 5, 5);
				g.fillOval(265, 240, 7, 7);
				g.fillOval(248, 213, 25, 25);
				g.fillOval(290, 268, 10, 10);
				g.fillOval(303, 264, 8, 8);
				g.fillOval(312, 257, 10, 10);
				g.fillOval(263, 165, 50, 50);
				g.fillOval(315, 200, 35, 35);
				g.fillOval(317, 123, 70, 70);
				g.fillOval(355, 195, 15, 15);
				g.fillOval(290, 140, 20, 20);
				g.fillOval(x, y, 20, 20);
				g.drawLine(250, 250, x, y);
			} else if (fireworkChoice == "firework3") {
				g.drawLine(400, 400, 100, 100);
				g.drawLine(400, 400, 200, 100);
				g.drawLine(400, 400, 300, 100);
				g.drawLine(400, 400, 400, 100); // straight
				g.drawOval(420, 400, 20, 20);
				g.fillOval(420, 350, 20, 20);
				g.drawOval(420, 300, 20, 20);
				g.fillOval(420, 250, 20, 20);
				g.drawOval(420, 200, 20, 20);
				g.fillOval(420, 150, 20, 20);
				g.drawOval(420, 100, 20, 20);
				g.fillOval(420, 50, 20, 20);
				g.drawOval(200, 400, 20, 20);
				g.drawOval(260, 140, 20, 20);
				g.fillOval(15, 200, 20, 20);
				g.drawLine(250, 250, x, y);
				g.drawOval(x, y, 20, 20);
			} else if (fireworkChoice == "firework4") {
				int n = 9;
				int stepCoordinates = 10; // step for x and y
				int stepSize = 20; // step for width and height
				for (int p = 0; p < n; p++) {
					g.drawOval(0 + stepCoordinates * p, 0 + stepCoordinates * p, 500 - stepSize * p,
							500 - stepSize * p);

				}
				g.drawOval(250, 250, 20, 20);
				g.drawOval(300, 300, 20, 20);
				g.drawOval(350, 350, 20, 20);
				g.drawOval(200, 200, 20, 20);
				g.drawOval(150, 150, 20, 20);
				g.drawOval(x, y, 20, 20);
				g.drawLine(250, 250, x, y);
			} else if (fireworkChoice == "firework5") {
				g.drawLine(250, 400, 250, 100);
				g.drawLine(250, 250, x, y);
				g.fillOval(x, y, 20, 20);
				int n = 8;
				int step = 40;
				for (int i = 0; i < n; i++) { // lines on left
					g.drawLine(100, 100 + step * i, 200, 100 + step * i);
				}
				for (int j = 0; j < n; j++) { // lines on right
					g.drawLine(300, 100 + step * j, 400, 100 + step * j);
				}
				int step2 = 55;
				int n2 = 6;
				for (int k = 0; k < n2; k++) { // circles in mid
					g.drawOval(240, 100 + step2 * k, 20, 20);
				}
			}
		} else if (colorChoice == "green") {
			x = (int) (newSpeedChoice * (Math.cos(Math.toRadians(newAngleChoice))) * timeValue);
			y = (int) ((newSpeedChoice * (Math.sin(Math.toRadians(newAngleChoice))) * timeValue)
					- ((0.5) * gravity * (Math.pow(timeValue, 2))));
			g.setColor(Color.GREEN);
			if (fireworkChoice == "firework1") {
				g.drawLine(250, 250, 250, 100);// up
				g.drawLine(250, 250, 250, 400);// down
				g.drawLine(250, 250, 100, 250);// left
				g.drawLine(250, 250, 400, 250);// right
				g.drawLine(250, 250, 400, 150); // up right
				g.drawLine(250, 250, 100, 150); // up left
				g.drawLine(250, 250, 400, 350);
				g.drawLine(250, 250, 100, 350);
				g.drawLine(250, 250, 175, 150);
				g.drawLine(250, 250, 175, 225);
				g.drawLine(250, 250, 175, 275);
				g.drawLine(250, 250, 325, 225);
				g.drawLine(250, 250, 325, 275);
				g.drawLine(250, 250, 325, 150);
				g.drawLine(250, 250, 175, 350);
				g.drawLine(250, 250, 325, 350);
				g.drawLine(250, 250, x, y);
			} else if (fireworkChoice == "firework2") {
				g.fillOval(250, 250, 10, 10);
				g.fillOval(260, 260, 20, 20);
				g.fillOval(275, 220, 40, 40); // big 1
				g.fillOval(250, 240, 8, 8);
				g.fillOval(265, 250, 5, 5);
				g.fillOval(265, 240, 7, 7);
				g.fillOval(248, 213, 25, 25);
				g.fillOval(290, 268, 10, 10);
				g.fillOval(303, 264, 8, 8);
				g.fillOval(312, 257, 10, 10);
				g.fillOval(263, 165, 50, 50);
				g.fillOval(315, 200, 35, 35);
				g.fillOval(317, 123, 70, 70);
				g.fillOval(355, 195, 15, 15);
				g.fillOval(290, 140, 20, 20);
				g.fillOval(x, y, 20, 20);
				g.drawLine(250, 250, x, y);
			} else if (fireworkChoice == "firework3") {
				g.drawLine(400, 400, 100, 100);
				g.drawLine(400, 400, 200, 100);
				g.drawLine(400, 400, 300, 100);
				g.drawLine(400, 400, 400, 100); // straight
				g.drawOval(420, 400, 20, 20);
				g.fillOval(420, 350, 20, 20);
				g.drawOval(420, 300, 20, 20);
				g.fillOval(420, 250, 20, 20);
				g.drawOval(420, 200, 20, 20);
				g.fillOval(420, 150, 20, 20);
				g.drawOval(420, 100, 20, 20);
				g.fillOval(420, 50, 20, 20);
				g.drawOval(200, 400, 20, 20);
				g.drawOval(260, 140, 20, 20);
				g.fillOval(15, 200, 20, 20);
				g.drawLine(250, 250, x, y);
				g.drawOval(x, y, 20, 20);
			} else if (fireworkChoice == "firework4") {
				int n = 9;
				int stepCoordinates = 10; // step for x and y
				int stepSize = 20; // step for width and height
				for (int p = 0; p < n; p++) {
					g.drawOval(0 + stepCoordinates * p, 0 + stepCoordinates * p, 500 - stepSize * p,
							500 - stepSize * p);

				}
				g.drawOval(250, 250, 20, 20);
				g.drawOval(300, 300, 20, 20);
				g.drawOval(350, 350, 20, 20);
				g.drawOval(200, 200, 20, 20);
				g.drawOval(150, 150, 20, 20);
				g.drawOval(x, y, 20, 20);
				g.drawLine(250, 250, x, y);
			} else if (fireworkChoice == "firework5") {
				g.drawLine(250, 400, 250, 100);
				g.drawLine(250, 250, x, y);
				g.fillOval(x, y, 20, 20);
				int n = 8;
				int step = 40;
				for (int i = 0; i < n; i++) { // lines on left
					g.drawLine(100, 100 + step * i, 200, 100 + step * i);
				}
				for (int j = 0; j < n; j++) { // lines on right
					g.drawLine(300, 100 + step * j, 400, 100 + step * j);
				}
				int step2 = 55;
				int n2 = 6;
				for (int k = 0; k < n2; k++) { // circles in mid
					g.drawOval(240, 100 + step2 * k, 20, 20);
				}
			}
		} else if (colorChoice == "yellow") {
			x = (int) (newSpeedChoice * (Math.cos(Math.toRadians(newAngleChoice))) * timeValue);
			y = (int) ((newSpeedChoice * (Math.sin(Math.toRadians(newAngleChoice))) * timeValue)
					- ((0.5) * gravity * (Math.pow(timeValue, 2))));
			g.setColor(Color.YELLOW);
			if (fireworkChoice == "firework1") {
				g.drawLine(250, 250, 250, 100);// up
				g.drawLine(250, 250, 250, 400);// down
				g.drawLine(250, 250, 100, 250);// left
				g.drawLine(250, 250, 400, 250);// right
				g.drawLine(250, 250, 400, 150); // up right
				g.drawLine(250, 250, 100, 150); // up left
				g.drawLine(250, 250, 400, 350);
				g.drawLine(250, 250, 100, 350);
				g.drawLine(250, 250, 175, 150);
				g.drawLine(250, 250, 175, 225);
				g.drawLine(250, 250, 175, 275);
				g.drawLine(250, 250, 325, 225);
				g.drawLine(250, 250, 325, 275);
				g.drawLine(250, 250, 325, 150);
				g.drawLine(250, 250, 175, 350);
				g.drawLine(250, 250, 325, 350);
				g.drawLine(250, 250, x, y);
			} else if (fireworkChoice == "firework2") {
				g.fillOval(250, 250, 10, 10);
				g.fillOval(260, 260, 20, 20);
				g.fillOval(275, 220, 40, 40); // big 1
				g.fillOval(250, 240, 8, 8);
				g.fillOval(265, 250, 5, 5);
				g.fillOval(265, 240, 7, 7);
				g.fillOval(248, 213, 25, 25);
				g.fillOval(290, 268, 10, 10);
				g.fillOval(303, 264, 8, 8);
				g.fillOval(312, 257, 10, 10);
				g.fillOval(263, 165, 50, 50);
				g.fillOval(315, 200, 35, 35);
				g.fillOval(317, 123, 70, 70);
				g.fillOval(355, 195, 15, 15);
				g.fillOval(290, 140, 20, 20);
				g.fillOval(x, y, 20, 20);
				g.drawLine(250, 250, x, y);
			} else if (fireworkChoice == "firework3") {
				g.drawLine(400, 400, 100, 100);
				g.drawLine(400, 400, 200, 100);
				g.drawLine(400, 400, 300, 100);
				g.drawLine(400, 400, 400, 100); // straight
				g.drawOval(420, 400, 20, 20);
				g.fillOval(420, 350, 20, 20);
				g.drawOval(420, 300, 20, 20);
				g.fillOval(420, 250, 20, 20);
				g.drawOval(420, 200, 20, 20);
				g.fillOval(420, 150, 20, 20);
				g.drawOval(420, 100, 20, 20);
				g.fillOval(420, 50, 20, 20);
				g.drawOval(200, 400, 20, 20);
				g.drawOval(260, 140, 20, 20);
				g.fillOval(15, 200, 20, 20);
				g.drawLine(250, 250, x, y);
				g.drawOval(x, y, 20, 20);
			} else if (fireworkChoice == "firework4") {
				int n = 9;
				int stepCoordinates = 10; // step for x and y
				int stepSize = 20; // step for width and height
				for (int p = 0; p < n; p++) {
					g.drawOval(0 + stepCoordinates * p, 0 + stepCoordinates * p, 500 - stepSize * p,
							500 - stepSize * p);

				}
				g.drawOval(250, 250, 20, 20);
				g.drawOval(300, 300, 20, 20);
				g.drawOval(350, 350, 20, 20);
				g.drawOval(200, 200, 20, 20);
				g.drawOval(150, 150, 20, 20);
				g.drawOval(x, y, 20, 20);
				g.drawLine(250, 250, x, y);
			} else if (fireworkChoice == "firework5") {
				g.drawLine(250, 400, 250, 100);
				g.drawLine(250, 250, x, y);
				g.fillOval(x, y, 20, 20);
				int n = 8;
				int step = 40;
				for (int i = 0; i < n; i++) { // lines on left
					g.drawLine(100, 100 + step * i, 200, 100 + step * i);
				}
				for (int j = 0; j < n; j++) { // lines on right
					g.drawLine(300, 100 + step * j, 400, 100 + step * j);
				}
				int step2 = 55;
				int n2 = 6;
				for (int k = 0; k < n2; k++) { // circles in mid
					g.drawOval(240, 100 + step2 * k, 20, 20);
				}

			}

		}
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == "time") {
			timeValue = time.getValue();
		}
	}

}
