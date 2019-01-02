package edu.cuny.csi.csc330.groupproject;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

public class BingoController implements
		ActionListener,
		WindowListener   {
	
	public static BingoGame gameModel;
	private BingoGameView gameView;

	public BingoController() {
		init();
	}
	
	public void setGameView(BingoGameView gameView) {
		this.gameView = gameView;
	}
	
	private void init() {
		gameModel = new BingoGame();
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		Object source = ae.getSource();
		System.out.println("BingoController action performed: " + source.getClass().getSimpleName());
		
		//reset button
		if(source == this.gameView.getResetButton())  {
			gameModel.resetGame();
			gameView.setList(gameModel.to1DArray());
			gameView.reset(gameModel.getWon());
		}
		
		// roll button
		else if(source == this.gameView.getRollButton()) {
			gameModel.roll();
			gameView.setLetter(gameModel.getRollLetter());
			gameView.setNumber(gameModel.getRollNumber());
			gameView.roll();
		}
		
		else if(source == this.gameView.getUndoButton()) {
			int loc = (gameModel.previousBoardMove.getR() + 1) * 5
					+ (gameModel.previousBoardMove.getC() + 1);
			gameView.undo(loc, gameModel.getWon(), 
					gameModel.getWinCombinationCode());
			gameModel.undo();
		}
		
		// one of the numbers were clicked
		else if(source.getClass().equals(JButton.class)) {
			boardActionPerformed((JButton)source);
		}
		
	}
	
	private void boardActionPerformed(JButton button) {
		System.out.println("BingoController action performed: " + button.getName());
		
		int position = Integer.parseInt(button.getName() );
		int mod = position % 5;
		int quo = position / 5;
		
		int r,c;
		if(mod > 0) {
			r = quo - 1;
			c = mod - 1;
		}
		else {
			r = quo - 2;
			c = 4;
		}
		
		gameModel.setPosition(r,c);
		gameView.takePosition(position, gameModel.getWon(), 
				gameModel.getWinCombinationCode());
	}
	
	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("windowOpened() Event");
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		String ObjButtons[] = {"YES", "NO"};
		
		int rc = JOptionPane.showOptionDialog(null, 
				"Are you sure you want to exit?", "Online Examination System",
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
				ObjButtons, ObjButtons[1]);
		
		System.out.println("windowClosing() " + rc);
		
		if(rc == 0)
			System.exit(0);
	}
	
	@Override
	public void windowClosed(WindowEvent e) {
		
	}
	
	@Override
	public void windowIconified(WindowEvent e) {
		
	}
	
	@Override
	public void windowDeiconified(WindowEvent e) {
		
	}
	
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}
	
	
	public static void main(String[] args) {
		BingoGameView.present();

	}

}
