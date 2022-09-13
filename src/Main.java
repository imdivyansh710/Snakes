import java.awt.Color;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game ob=new Game();
		JFrame jf =new JFrame();
		ob.setBackground(Color.DARK_GRAY);
		jf.setTitle("snakes");
		jf.setSize(905, 700);
		jf.setResizable(false);
		jf.setVisible(true);
	    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    jf.add(ob);
		

	}

}
