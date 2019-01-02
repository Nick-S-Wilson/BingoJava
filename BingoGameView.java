package edu.cuny.csi.csc330.groupproject;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class BingoGameView extends JFrame{
	
	private static String VERSION = "0.1";
	private static String[] listNum = new String[25];
	private static String DEFAULT_TITLE = "Bingo (" + VERSION + ")";
	
	private static Integer DEFAULT_X = 200;
	private static Integer DEFAULT_Y = 50;
	private static Integer DEFAULT_W = 500;
	private static Integer DEFAULT_H = 275;
	private static String[] LETTER = {"B", "I", "N", "G", "O"};
	
	private static Dimension BOARD_DIM = new Dimension(130,130);
	private static Integer BOARD_POSITIONS = 30;
	private static int[] undoArray = new int[25];
	private static int count;
	

	public BingoGameView(BingoController listener) {
		actionListener = listener;
		windowListener = listener;
		setList(BingoController.gameModel.to1DArray());
		guiInit();
	}
	
	public BingoGameView() {
		guiInit();
	}
	
	public BingoGameView(GraphicsConfiguration gc) {
		super(gc);
		guiInit();
	}
	
	private JPanel mainPanel;
	private JPanel boardPanel;
	private JPanel infoPanel;
	private JPanel controlPanel;
	private JPanel displayPanel;
	
	private JButton [] boardPositions;
	private JButton rollButton;
	private JButton resetButton;
	private JButton undoButton;
	
	private JLabel currentGame;
	private JLabel currentGameValue;
	private JLabel gameOutcome;
	private JLabel gameOutcomeValue;
	private JLabel rollLetter;
	private JLabel rollLetterValue;
	private JLabel rollNumber;
	private JLabel rollNumberValue;
	
	
	private int currentGameIndex;
	private char letter;
	private int number;
	
	private ActionListener actionListener;
	private WindowListener windowListener;
	
	
	public JButton getResetButton() {
		return resetButton;
	}
	
	public JButton getRollButton() {
		return rollButton;
	}
	
	public JButton getUndoButton() {
		return undoButton;
	}
	
	public void setLetter(char let) {
		this.letter = let;
	}
	
	public void setNumber(int num) {
		this.number = num;
	}
	
	public void setList(String[] arr) {
		for(int i = 0; i<arr.length; i++) {
			listNum[i] = arr[i];
		}
	}
	
	private void init() {
		currentGameIndex = 1;
		letter = ' ';
		number = 0;
		this.setSize(DEFAULT_W, DEFAULT_H);
		this.setLocation(DEFAULT_X, DEFAULT_Y);
		this.setTitle(DEFAULT_TITLE);
	}
	
	private void disableBoard() {
		count = 0;
		for(int i = 5; i < boardPositions.length; ++i) {
			if(boardPositions[i].isEnabled()) {
				undoArray[count] = i;
				boardPositions[i].setEnabled(false);
				count++;
			}
		}
	}
	
	private void undisableBoard() {
		int j = 0;
		for(int i = 5; i < boardPositions.length; ++i) {
			if(!boardPositions[i].isEnabled() && undoArray[j] == i) {
				boardPositions[i].setEnabled(true);
				j++;
			}
		}
//		int i = 5;
//		System.out.println("Count: " + count);
//		for(int j = 0; j < count; j++) {
//			int loc = undoArray[j];
//			System.out.println("undoArray[" +j + "]: " + (undoArray[j] + 1));
//			System.out.println("value: " + boardPositions[loc]);
//		}
//		while(i < count) {
//			int loc = undoArray[i];
//			boardPositions[loc].setEnabled(true);
//		}
	}
		
	private void markWin(short code) {
		switch(code) {
		case 1:
			//row 1
			boardPositions[5].setFont(new Font("Dialog", Font.BOLD, 50));
			boardPositions[6].setFont(new Font("Dialog", Font.BOLD, 50));
			boardPositions[7].setFont(new Font("Dialog", Font.BOLD, 50));
			boardPositions[8].setFont(new Font("Dialog", Font.BOLD, 50));
			boardPositions[9].setFont(new Font("Dialog", Font.BOLD, 50));
			boardPositions[5].setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			boardPositions[6].setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			boardPositions[7].setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			boardPositions[8].setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			boardPositions[9].setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			break;
		case 2:
			//row 2
			boardPositions[10].setFont(new Font("Dialog", Font.BOLD, 50));
			boardPositions[11].setFont(new Font("Dialog", Font.BOLD, 50));
			boardPositions[12].setFont(new Font("Dialog", Font.BOLD, 50));
			boardPositions[13].setFont(new Font("Dialog", Font.BOLD, 50));
			boardPositions[14].setFont(new Font("Dialog", Font.BOLD, 50));
			boardPositions[10].setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			boardPositions[11].setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			boardPositions[12].setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			boardPositions[13].setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			boardPositions[14].setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			break;
		case 3:
			//row 3
			boardPositions[15].setFont(new Font("Dialog", Font.BOLD, 50));
			boardPositions[16].setFont(new Font("Dialog", Font.BOLD, 50));
			boardPositions[17].setFont(new Font("Dialog", Font.BOLD, 50));
			boardPositions[18].setFont(new Font("Dialog", Font.BOLD, 50));
			boardPositions[19].setFont(new Font("Dialog", Font.BOLD, 50));
			boardPositions[15].setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			boardPositions[16].setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			boardPositions[17].setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			boardPositions[18].setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			boardPositions[19].setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			break;
		case 4:
			//row 4
			boardPositions[20].setFont(new Font("Dialog", Font.BOLD, 50));
			boardPositions[21].setFont(new Font("Dialog", Font.BOLD, 50));
			boardPositions[22].setFont(new Font("Dialog", Font.BOLD, 50));
			boardPositions[23].setFont(new Font("Dialog", Font.BOLD, 50));
			boardPositions[24].setFont(new Font("Dialog", Font.BOLD, 50));
			boardPositions[20].setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			boardPositions[21].setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			boardPositions[22].setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			boardPositions[23].setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			boardPositions[24].setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			break;
		case 5:
			//row 5
			boardPositions[25].setFont(new Font("Dialog", Font.BOLD, 50));
			boardPositions[26].setFont(new Font("Dialog", Font.BOLD, 50));
			boardPositions[27].setFont(new Font("Dialog", Font.BOLD, 50));
			boardPositions[28].setFont(new Font("Dialog", Font.BOLD, 50));
			boardPositions[29].setFont(new Font("Dialog", Font.BOLD, 50));
			boardPositions[25].setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			boardPositions[26].setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			boardPositions[27].setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			boardPositions[28].setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			boardPositions[29].setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			break;
		case 6:
			//column 1
			boardPositions[5].setFont(new Font("Dialog", Font.BOLD, 50));
			boardPositions[10].setFont(new Font("Dialog", Font.BOLD, 50));
			boardPositions[15].setFont(new Font("Dialog", Font.BOLD, 50));
			boardPositions[20].setFont(new Font("Dialog", Font.BOLD, 50));
			boardPositions[25].setFont(new Font("Dialog", Font.BOLD, 50));
			boardPositions[5].setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			boardPositions[10].setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			boardPositions[15].setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			boardPositions[20].setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			boardPositions[25].setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			break;
		case 7:
			//column 2
			boardPositions[6].setFont(new Font("Dialog", Font.BOLD, 50));
			boardPositions[11].setFont(new Font("Dialog", Font.BOLD, 50));
			boardPositions[16].setFont(new Font("Dialog", Font.BOLD, 50));
			boardPositions[21].setFont(new Font("Dialog", Font.BOLD, 50));
			boardPositions[26].setFont(new Font("Dialog", Font.BOLD, 50));
			boardPositions[6].setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			boardPositions[11].setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			boardPositions[16].setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			boardPositions[21].setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			boardPositions[26].setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			break;
		case 8:
			//column 3
			boardPositions[7].setFont(new Font("Dialog", Font.BOLD, 50));
			boardPositions[12].setFont(new Font("Dialog", Font.BOLD, 50));
			boardPositions[17].setFont(new Font("Dialog", Font.BOLD, 50));
			boardPositions[22].setFont(new Font("Dialog", Font.BOLD, 50));
			boardPositions[27].setFont(new Font("Dialog", Font.BOLD, 50));
			boardPositions[7].setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			boardPositions[12].setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			boardPositions[17].setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			boardPositions[22].setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			boardPositions[27].setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			break;
		case 9:
			//column 4
			boardPositions[8].setFont(new Font("Dialog", Font.BOLD, 50));
			boardPositions[13].setFont(new Font("Dialog", Font.BOLD, 50));
			boardPositions[18].setFont(new Font("Dialog", Font.BOLD, 50));
			boardPositions[23].setFont(new Font("Dialog", Font.BOLD, 50));
			boardPositions[28].setFont(new Font("Dialog", Font.BOLD, 50));
			boardPositions[8].setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			boardPositions[13].setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			boardPositions[18].setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			boardPositions[23].setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			boardPositions[28].setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			break;
		case 10:
			//column 5
			boardPositions[9].setFont(new Font("Dialog", Font.BOLD, 50));
			boardPositions[14].setFont(new Font("Dialog", Font.BOLD, 50));
			boardPositions[19].setFont(new Font("Dialog", Font.BOLD, 50));
			boardPositions[24].setFont(new Font("Dialog", Font.BOLD, 50));
			boardPositions[29].setFont(new Font("Dialog", Font.BOLD, 50));
			boardPositions[9].setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			boardPositions[14].setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			boardPositions[19].setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			boardPositions[24].setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			boardPositions[29].setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			break;
		case 11:
			//diag down
			boardPositions[5].setFont(new Font("Dialog", Font.BOLD, 50));
			boardPositions[11].setFont(new Font("Dialog", Font.BOLD, 50));
			boardPositions[17].setFont(new Font("Dialog", Font.BOLD, 50));
			boardPositions[23].setFont(new Font("Dialog", Font.BOLD, 50));
			boardPositions[29].setFont(new Font("Dialog", Font.BOLD, 50));
			boardPositions[5].setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			boardPositions[11].setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			boardPositions[17].setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			boardPositions[23].setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			boardPositions[29].setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			break;
		case 12:
			//diag up
			boardPositions[9].setFont(new Font("Dialog", Font.BOLD, 50));
			boardPositions[13].setFont(new Font("Dialog", Font.BOLD, 50));
			boardPositions[17].setFont(new Font("Dialog", Font.BOLD, 50));
			boardPositions[21].setFont(new Font("Dialog", Font.BOLD, 50));
			boardPositions[25].setFont(new Font("Dialog", Font.BOLD, 50));
			boardPositions[9].setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			boardPositions[13].setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			boardPositions[17].setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			boardPositions[21].setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			boardPositions[25].setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			break;
		default:
			break;
		}
	}

	private void unmarkWin(short code) {
		switch(code) {
		case 1:
			//row 1
			boardPositions[5].setFont(new Font("Dialog", Font.PLAIN, 44));
			boardPositions[6].setFont(new Font("Dialog", Font.PLAIN, 44));
			boardPositions[7].setFont(new Font("Dialog", Font.PLAIN, 44));
			boardPositions[8].setFont(new Font("Dialog", Font.PLAIN, 44));
			boardPositions[9].setFont(new Font("Dialog", Font.PLAIN, 44));
			boardPositions[5].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
			boardPositions[6].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
			boardPositions[7].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
			boardPositions[8].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
			boardPositions[9].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
			break;
		case 2:
			//row 2
			boardPositions[10].setFont(new Font("Dialog", Font.PLAIN, 44));
			boardPositions[11].setFont(new Font("Dialog", Font.PLAIN, 44));
			boardPositions[12].setFont(new Font("Dialog", Font.PLAIN, 44));
			boardPositions[13].setFont(new Font("Dialog", Font.PLAIN, 44));
			boardPositions[14].setFont(new Font("Dialog", Font.PLAIN, 44));
			boardPositions[10].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
			boardPositions[11].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
			boardPositions[12].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
			boardPositions[13].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
			boardPositions[14].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
			break;
		case 3:
			//row 3
			boardPositions[15].setFont(new Font("Dialog", Font.PLAIN, 44));
			boardPositions[16].setFont(new Font("Dialog", Font.PLAIN, 44));
			boardPositions[17].setFont(new Font("Dialog", Font.PLAIN, 44));
			boardPositions[18].setFont(new Font("Dialog", Font.PLAIN, 44));
			boardPositions[19].setFont(new Font("Dialog", Font.PLAIN, 44));
			boardPositions[15].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
			boardPositions[16].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
			boardPositions[17].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
			boardPositions[18].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
			boardPositions[19].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
			break;
		case 4:
			//row 4
			boardPositions[20].setFont(new Font("Dialog", Font.PLAIN, 44));
			boardPositions[21].setFont(new Font("Dialog", Font.PLAIN, 44));
			boardPositions[22].setFont(new Font("Dialog", Font.PLAIN, 44));
			boardPositions[23].setFont(new Font("Dialog", Font.PLAIN, 44));
			boardPositions[24].setFont(new Font("Dialog", Font.PLAIN, 44));
			boardPositions[20].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
			boardPositions[21].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
			boardPositions[22].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
			boardPositions[23].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
			boardPositions[24].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
			break;
		case 5:
			//row 5
			boardPositions[25].setFont(new Font("Dialog", Font.PLAIN, 44));
			boardPositions[26].setFont(new Font("Dialog", Font.PLAIN, 44));
			boardPositions[27].setFont(new Font("Dialog", Font.PLAIN, 44));
			boardPositions[28].setFont(new Font("Dialog", Font.PLAIN, 44));
			boardPositions[29].setFont(new Font("Dialog", Font.PLAIN, 44));
			boardPositions[25].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
			boardPositions[26].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
			boardPositions[27].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
			boardPositions[28].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
			boardPositions[29].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
			break;
		case 6:
			//column 1
			boardPositions[5].setFont(new Font("Dialog", Font.PLAIN, 44));
			boardPositions[10].setFont(new Font("Dialog", Font.PLAIN, 44));
			boardPositions[15].setFont(new Font("Dialog", Font.PLAIN, 44));
			boardPositions[20].setFont(new Font("Dialog", Font.PLAIN, 44));
			boardPositions[25].setFont(new Font("Dialog", Font.PLAIN, 44));
			boardPositions[5].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
			boardPositions[10].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
			boardPositions[15].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
			boardPositions[20].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
			boardPositions[25].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
			break;
		case 7:
			//column 2
			boardPositions[6].setFont(new Font("Dialog", Font.PLAIN, 44));
			boardPositions[11].setFont(new Font("Dialog", Font.PLAIN, 44));
			boardPositions[16].setFont(new Font("Dialog", Font.PLAIN, 44));
			boardPositions[21].setFont(new Font("Dialog", Font.PLAIN, 44));
			boardPositions[26].setFont(new Font("Dialog", Font.PLAIN, 44));
			boardPositions[5].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
			boardPositions[11].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
			boardPositions[16].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
			boardPositions[21].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
			boardPositions[26].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
			break;
		case 8:
			//column 3
			boardPositions[7].setFont(new Font("Dialog", Font.PLAIN, 44));
			boardPositions[12].setFont(new Font("Dialog", Font.PLAIN, 44));
			boardPositions[17].setFont(new Font("Dialog", Font.PLAIN, 44));
			boardPositions[22].setFont(new Font("Dialog", Font.PLAIN, 44));
			boardPositions[27].setFont(new Font("Dialog", Font.PLAIN, 44));
			boardPositions[7].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
			boardPositions[12].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
			boardPositions[17].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
			boardPositions[22].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
			boardPositions[27].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
			break;
		case 9:
			//column 4
			boardPositions[8].setFont(new Font("Dialog", Font.PLAIN, 44));
			boardPositions[13].setFont(new Font("Dialog", Font.PLAIN, 44));
			boardPositions[18].setFont(new Font("Dialog", Font.PLAIN, 44));
			boardPositions[23].setFont(new Font("Dialog", Font.PLAIN, 44));
			boardPositions[28].setFont(new Font("Dialog", Font.PLAIN, 44));
			boardPositions[8].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
			boardPositions[13].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
			boardPositions[18].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
			boardPositions[23].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
			boardPositions[28].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
			break;
		case 10:
			//column 5
			boardPositions[9].setFont(new Font("Dialog", Font.PLAIN, 44));
			boardPositions[14].setFont(new Font("Dialog", Font.PLAIN, 44));
			boardPositions[19].setFont(new Font("Dialog", Font.PLAIN, 44));
			boardPositions[24].setFont(new Font("Dialog", Font.PLAIN, 44));
			boardPositions[29].setFont(new Font("Dialog", Font.PLAIN, 44));
			boardPositions[9].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
			boardPositions[14].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
			boardPositions[19].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
			boardPositions[24].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
			boardPositions[29].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
			break;
		case 11:
			//diag down
			boardPositions[5].setFont(new Font("Dialog", Font.PLAIN, 44));
			boardPositions[11].setFont(new Font("Dialog", Font.PLAIN, 44));
			boardPositions[17].setFont(new Font("Dialog", Font.PLAIN, 44));
			boardPositions[23].setFont(new Font("Dialog", Font.PLAIN, 44));
			boardPositions[29].setFont(new Font("Dialog", Font.PLAIN, 44));
			boardPositions[5].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
			boardPositions[11].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
			boardPositions[17].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
			boardPositions[23].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
			boardPositions[29].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
			break;
		case 12:
			//diag up
			boardPositions[9].setFont(new Font("Dialog", Font.PLAIN, 44));
			boardPositions[13].setFont(new Font("Dialog", Font.PLAIN, 44));
			boardPositions[17].setFont(new Font("Dialog", Font.PLAIN, 44));
			boardPositions[21].setFont(new Font("Dialog", Font.PLAIN, 44));
			boardPositions[25].setFont(new Font("Dialog", Font.PLAIN, 44));
			boardPositions[9].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
			boardPositions[13].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
			boardPositions[17].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
			boardPositions[21].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
			boardPositions[25].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
			break;
		default:
			break;
		}
	}
	
	public void roll() {
		this.rollLetterValue.setText(String.format("%c", letter));
		this.rollNumberValue.setText(String.format("%d", number));
	}
	
	private void refreshBoard() {
		for(int i = 5 ; i < boardPositions.length ; ++i) {
			boardPositions[i].setEnabled(true);
			if(i == 17) {
				boardPositions[i].setText("Free");
				boardPositions[i].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
				boardPositions[i].setEnabled(false);
			}
			else {
				boardPositions[i].setText(listNum[i-5]);
				boardPositions[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
			}
			boardPositions[i].setFont(new Font("Dialog", Font.PLAIN, 40));
		}
		letter = ' ';
		number = 0;
		this.rollLetterValue.setText(String.format("%c", letter));
		this.rollNumberValue.setText(String.format("%d", number));
	}
	
	public void reset(boolean winState)  {
		this.refreshBoard();
		if(winState)
			currentGameIndex++;
		this.currentGameValue.setText(String.format("%d", currentGameIndex));
		this.gameOutcomeValue.setText(" ");
	}
	
	public void undo(int position, boolean won, short code) {
		if(won == true) {
			unmarkWin(code);
			undisableBoard();
			currentGameIndex--;
			this.gameOutcomeValue.setText(" ");
		}
		boardPositions[position - 1].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		boardPositions[position - 1].setFont(new Font("Dialog", Font.ROMAN_BASELINE, 40));
		boardPositions[position - 1].setEnabled(true);
	}
	
	public void takePosition(int position, boolean won, short code) {
		boardPositions[position-1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
		if(won == false) {
			boardPositions[position-1].setEnabled(false);
		}
		else {
			markWin(code);
			disableBoard();
			currentGameIndex++;
			this.gameOutcomeValue.setText("BINGO!!");
		}
	}
	
	private void guiInit() {
		init();
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		mainPanel = new JPanel(new FlowLayout(FlowLayout.LEFT), true);
		boardPanel = new JPanel(new GridLayout(6,5), true);
		this.boardPositions = new JButton[BOARD_POSITIONS];
		for(int m = 0; m < 5; ++m) {
			boardPositions[m] = new JButton(LETTER[m]);
			boardPositions[m].setName(Integer.toString(m+1));
			boardPositions[m].setFont(new Font("Dialog", Font.ROMAN_BASELINE, 40));
			boardPositions[m].setPreferredSize(BOARD_DIM);
			boardPositions[m].setBackground(Color.CYAN);
			boardPositions[m].setEnabled(false);
			boardPanel.add(boardPositions[m]);
		}
		for(int i = 5; i < boardPositions.length; ++i) {
			if(i == 17) {
				boardPositions[i] = new JButton("Free");
				boardPositions[i].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
				boardPositions[i].setEnabled(false);
			}
			else
				boardPositions[i] = new JButton(listNum[i-5]);
			boardPositions[i].setName(Integer.toString(i+1));
			boardPositions[i].setFont(new Font("Dialog", Font.PLAIN, 40));
			boardPositions[i].setPreferredSize(BOARD_DIM);
			boardPositions[i].setBackground(Color.WHITE);
			boardPanel.add(boardPositions[i]);
		}
		
		
		//DISPLAY PANEL
		displayPanel = new JPanel(new GridLayout(4,2), true);
		rollLetter = createStatusLabel("Letter: ");
		displayPanel.add(rollLetter);
		rollLetterValue = createSymbolLabel(String.format("%c", letter));
		displayPanel.add(rollLetterValue);
		
		rollNumber = createStatusLabel("Number: ");
		displayPanel.add(rollNumber);
		rollNumberValue = createSymbolLabel(String.format("%d", number));
		displayPanel.add(rollNumberValue);
		
		currentGame = createStatusLabel("Game: ");
		displayPanel.add(currentGame);
		currentGameValue = createSymbolLabel( String.format("%d", currentGameIndex) );
		displayPanel.add(currentGameValue);
		
		gameOutcome = createStatusLabel("Winner: ");
		displayPanel.add(gameOutcome);
		gameOutcomeValue = createSymbolLabel(" ");
		displayPanel.add(gameOutcomeValue);

		
		//CONTROL PANEL
		controlPanel = new JPanel(new GridLayout(1, 2), true);
		rollButton = createControlButton("Roll");
		resetButton = createControlButton("Reset");
		undoButton = createControlButton("Undo");
		controlPanel.add(rollButton);
		controlPanel.add(resetButton);
		controlPanel.add(undoButton);
		
		
		//INFO PANEL
		infoPanel = new JPanel(new GridLayout(2,1), true);
		infoPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 2, true));
		infoPanel.add(displayPanel);	
		infoPanel.add(controlPanel);
				
				
		//MAIN PANEL	
		mainPanel.add(boardPanel);
		mainPanel.add(infoPanel);
		
		
		this.add(mainPanel);
		this.setResizable(false);
		this.pack();		
		addActionListeners();
		addOtherListeners();
	}
	
	private void addActionListeners() {
		if(this.actionListener == null)
			return; 
		this.rollButton.addActionListener(this.actionListener);
		this.resetButton.addActionListener(this.actionListener);
		this.undoButton.addActionListener(this.actionListener);
		for(int i = 0 ; i < boardPositions.length ; ++i) {
			boardPositions[i].addActionListener(this.actionListener);
		}
	}
	
	private void addOtherListeners() {
		addWindowListener(windowListener);
	}
	
	private JButton createControlButton(String label)  {
		JButton button = new JButton(label);
		button.setName(label);
		button.setFont(new Font("Dialog", Font.BOLD, 22));
		button.setPreferredSize(new Dimension(120, 40));
		button.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
		button.setBackground(Color.ORANGE);
		
		return button; 
	}
	
	private JLabel createSymbolLabel(String symbol)  {
		JLabel label = new JLabel(symbol);
		label.setName(symbol);
		label.setFont(new Font("Dialog", Font.BOLD, 22));
		label.setPreferredSize(new Dimension(100, 35));
		//label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		label.setBackground(Color.PINK);
		
		return label; 
	}
	
	private JLabel createStatusLabel(String title)  {
		JLabel label = new JLabel(title);
		label.setName(title);
		label.setFont(new Font("Dialog", Font.BOLD, 18));
		label.setPreferredSize(new Dimension(100, 35));
		//label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		label.setBackground(Color.YELLOW);
		
		return label; 
	}
	
	public static void present() {
		
		// The recommended way of starting a Swing / GUI Thread 
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
	            	
				BingoController listener = new BingoController(); 
				BingoGameView game = new BingoGameView(listener);
				listener.setGameView(game);
	            	
				game.setVisible(true);
			}
		} );
	}
	
	public static void main(String[] args) {
		// create viewable instance 
		present();
  
	}
}
