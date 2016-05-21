import java.awt.FlowLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUI extends JFrame implements Observer,Runnable{
	
	/**
	 * 
	 */
	private JLabel moneyLb;
	private JButton upgradeBt;
	private Game game;
	
	public GUI(){
		game = new Game();
		game.addObserver(this);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.initComponent();
		this.pack();
		
	}
	
	private void initComponent(){
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		moneyLb = new JLabel(""+game.getMoney());
		upgradeBt = new JButton("UPGRADE");
		super.add(moneyLb);
		super.add(upgradeBt);
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		//System.out.println("KUYKUYKUYKUYKUYKUYKUYKUYKUYKUYKUYKUYKUY");
		moneyLb.setText(""+game.getMoney());
	}
	

	@Override
	public void run() {
		this.setVisible(true);
		game.startGame();
	}
	
	public static void main(String[] args) {
		GUI g = new GUI();
		g.run();
	}
}
