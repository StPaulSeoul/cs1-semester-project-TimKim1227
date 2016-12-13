import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.*;
import java.applet.Applet;

public class ContainerShip1 extends Applet {

	private String name;
	private int capacity;
	private Container1[] box;
	private static int count1;
	
	public ContainerShip1(String name, int capacity) {
		this.name = name;
		this.capacity = capacity;
	}

	public static void main(String[] args) {
		Stack s = new Stack();
		ContainerShip1 ship1 = ask1();
		Container1[] box = new Container1[ship1.capacity];
		ship1.box = box;
		for (int i = 0; i < ship1.capacity; i++) {
			ship1.box[i] = ask2();
			s.push(ship1.box[i]);
		}

		int cnt = ship1.capacity;
		int max = cnt;
	
		while (true) {
			int answer = ask3();
			count1 = cnt;
			
			if (answer == 1) {
				//show(s,cnt);
			} else if (answer == 2) {
				if (cnt < max) {
					ship1.box[cnt] = ask2();
					cnt++;
				} else
					errorFull();
			} else if (answer == 3) {
				System.out.println("how many?");
				int num = ask4();
				if(num>ship1.capacity){
					errorCapacity();
				}else{
					if (cnt > 0 && cnt != -1) {
						for (int i = 0; i < num; i++) {
							s.pop();
							cnt--;
						}
					}
				}
			} else
				System.exit(0);
		}
	}

	public static ContainerShip1 ask1() {
		String name = JOptionPane.showInputDialog(null,"What is the ship name?","Name",0);
		String a = JOptionPane.showInputDialog(null,"What is the maximum capacity of this ship?","Capacity",0);
		int capacity1 = Integer.parseInt(a);
		ContainerShip1 ship1 = new ContainerShip1(name,capacity1);
		return ship1;
	}

	public static Container1 ask2() {
		String color = JOptionPane.showInputDialog(null,"What is the color of this container?","Color",0);
		String w = JOptionPane.showInputDialog(null,"What is the weight of this container?","Weight",0);
		int weight1 = Integer.parseInt(w);
		Container1 box1 = new Container1(color,weight1);
		return box1;
	}

	public static int ask3(){
		String result = String.format("What do you want to do?%n1. List the container box%n2. Add container box%n3. Remove container box%n4. Quit%n");
		String w = JOptionPane.showInputDialog(null,result,"Weight",0);
		int answer = Integer.parseInt(w);
		return answer;
	}
	
	public static int ask4(){
		String w = JOptionPane.showInputDialog(null,"How many?","Remove",0);
		int answer = Integer.parseInt(w);
		return answer;
	}
	
	public static void errorCapacity(){
		JFrame frame = new JFrame("ERROR");
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();    
        frame.add(panel);
        placeComponents(panel);
        frame.setVisible(true);
	}
	
	public static void errorFull(){
		JFrame frame = new JFrame("ERROR");
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();    
        frame.add(panel);
        placeComponents1(panel);
        frame.setVisible(true);
	}
	
	public static void show(Stack s,int cnt,ContainerShip1 ship){
		JFrame frame = new JFrame("Container");
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();    
        frame.add(panel);
        //placeComponents2(panel,s,cnt,ship);
        frame.setVisible(true);
	}
	
	private static void placeComponents(JPanel panel) {
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
	
	/*private static void placeComponents2(JPanel panel,Stack s,int cnt,ContainerShip1 ship) {
		panel.setLayout(null);
		JLabel info;
		for(int i=0;i<cnt;i++){
			ship.box[i].
			ship.box[i].color;
			info = new JLabel();
			info.setBounds(10, 50+(i*25), 200, 25);
			panel.add(info);
		}
		
	}*/
}