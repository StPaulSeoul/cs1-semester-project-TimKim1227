import java.util.Stack;

import javax.swing.*;
import java.applet.Applet;

public class ContainerShip1 extends Applet {

	private int capacity;										//Define Variable
	private Container1[] box;

	public ContainerShip1(int capacity) {						//Create ContainerShip1 Class
		this.capacity = capacity;
	}
	
	//Main----------------------------------------------------------------------------------------------------------------------------------------
	
	public static void main(String[] args) {
		ContainerShip1 ship1 = ask1();							//Define Variable
		Container1[] box = new Container1[ship1.capacity];

		ship1.box = box;

		Stack<Container1> s = new Stack<Container1>();			//Create Stack

		for (int i = 0; i < ship1.capacity; i++) {				//Ask About Each Container Box.
			ship1.box[i] = ask2();
			s.push(ship1.box[i]);
		}

		int cnt = ship1.capacity;								//Defining Variable
		int max = cnt;

		while (true) {											//Loop
			int answer = ask3();								//Ask for the User Response

			if (answer == 1) {									//When User Inputs 1, Show Lists Of Container Boxes
				show(cnt, ship1.box);
			} else if (answer == 2) {							//When User Inputs 2, Add a Container Box
				if (cnt < max) {
					ship1.box[cnt] = ask2();
					cnt++;
				} else
					errorFull();								//When Ship Is Already Full, Show Error Message
			} else if (answer == 3) {							//When User Inputs 3, Remove n Container Box(es)
				System.out.println("how many?");
				int num = ask4();								//Ask How Many To Remove			
				if (num > ship1.capacity) 						
					errorCapacity();							//If There Are To Many Remove, Show Error Message
				else {				
					if (cnt > 0 && cnt != -1) {					//Until # Of Containers reaches 0
						for (int i = 0; i < num; i++) {
							s.pop();							//Remove Container Box(es) from the top
							cnt--;
						}
					}
				}
			} else
				System.exit(0);									//When User Inputs 4, Exit the program			
		}
	}
	
	//Methods-------------------------------------------------------------------------------------------------------------------------------------
	
	/*
	 * JOptionPane.showInputDialog --> Open The Window That Can Get User Input
	 * String.format --> Create A String That Is In A Particular Arrangement
	 */
	
	public static ContainerShip1 ask1() {						//Ask Capacity of the ship
		String a = JOptionPane.showInputDialog(null, "What is the maximum capacity of this ship?", "Information", 0);
		int capacity1 = Integer.parseInt(a);
		ContainerShip1 ship1 = new ContainerShip1(capacity1);
		return ship1;
	}

	public static Container1 ask2() {							//Ask The Color and Weight of Container Box(es)
		String color = JOptionPane.showInputDialog(null, "What is the color of this container?", "Color of Container", 0);
		String w = JOptionPane.showInputDialog(null, "What is the weight of this container?", "Weight of Container", 0);
		int weight1 = Integer.parseInt(w);
		Container1 box1 = new Container1(color, weight1);
		return box1;
	}

	public static int ask3() {									//Display Options and get Input from the User
		String result = String.format(
				"What do you want to do?%n1. List the container box%n2. Add container box%n3. Remove container box%n4. Quit%n");
		String w = JOptionPane.showInputDialog(null, result, "Weight", 0);
		int answer = Integer.parseInt(w);
		return answer;
	}

	public static int ask4() {									//Ask How Many Container Box(es) To Remove
		String w = JOptionPane.showInputDialog(null, "How many?", "Remove", 0);
		int answer = Integer.parseInt(w);
		return answer;
	}
	
	/*	
	 * JFrame Stuffs-------------------------------------------------------------------------------------------------------------------------------
	 *	JFrame.setSize --> Sets The Size of Window
	 * 	JFrame.setDefaultCloseOperation --> Sets How The Window Is Closed
	 * 	JFrame.setBounds --> Set The Positions Of The Components
	 * 	JFrame.add --> Add the Component to the Window
	 * 	JFrame.setVisible --> Show Window On the Screen
	 * --------------------------------------------------------------------------------------------------------------------------------------------
	 */

	public static void errorCapacity() {						//When The Ship Is Full, Show Error Message
		JFrame frame = new JFrame("ERROR");
		frame.setSize(350, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		frame.add(panel);
		placeComponents(panel);
		frame.setVisible(true);
	}

	public static void errorFull() {							//When The Ship Gets full, Show Error Message
		JFrame frame = new JFrame("ERROR");
		frame.setSize(350, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		frame.add(panel);
		placeComponents1(panel);
		frame.setVisible(true);
	}

	public static void show(int cnt, Container1[] box) {		//Display Lists Of Container Box(es)
		JFrame frame = new JFrame("Container");
		frame.setSize(300, 200+25*cnt);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		frame.add(panel);
		placeComponents2(panel, cnt, box);
		frame.setVisible(true);
	}

	private static void placeComponents(JPanel panel) {			//Set error message
		panel.setLayout(null);
		JLabel error = new JLabel("Too much containers to remove!");
		error.setBounds(10, 50, 200, 25);
		panel.add(error);
	}

	private static void placeComponents1(JPanel panel) {
		panel.setLayout(null);
		JLabel error = new JLabel("The ship is full!");
		error.setBounds(10, 50, 200, 25);
		panel.add(error);
	}

	private static void placeComponents2(JPanel panel, int cnt, Container1[] box) {		//Writing Contents for the Lists of Container Box(es)
		panel.setLayout(null);
		JLabel info;
		for (int i = 0; i < cnt; i++) {
			String information = String.format("%d. Color: %7s  Weight: %10d",i+1, box[i].color, box[i].weight);
			info = new JLabel(information);
			info.setBounds(10, 50 + (i * 25), 300, 125);			//i*25 Equals To One Line Below Here
			panel.add(info);
		}
	}
	
}