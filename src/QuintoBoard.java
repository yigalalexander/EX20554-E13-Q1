import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Created by yigalalexander on 5/4/15.
 */
public class QuintoBoard extends JFrame {

	public static final int cellSize = 30;
	public static final int cellPadding = 2;
	private Color firstColor, secondColor;
	protected QuintoCell matrix[][];

	private int boardWidth;
	private int boardHeight;
	JButton clearButton;

	public Color getFirstColor() {
		return firstColor;
	}

	public void setFirstColor(Color firstColor) {
		this.firstColor = firstColor;
	}

	public Color getSecondColor() {
		return secondColor;
	}

	public void setSecondColor(Color secondColor) {
		this.secondColor = secondColor;
	}




	public QuintoBoard(int width, int height, Color fColor, Color sColor) {
		super("Quinto");
		boardHeight = height;
		boardWidth = width;
		matrix = new QuintoCell[boardHeight][boardWidth];
		firstColor = fColor;
		secondColor = sColor;

		try {
			UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
		} catch (Exception e) {
			e.printStackTrace();
		}

		JPanel buttonsPanel = new JPanel();
		clearButton = new JButton("Clear");
		clearButton.addActionListener(new ButtonListener());

		buttonsPanel.add(clearButton);
		buttonsPanel.setPreferredSize(new Dimension(50, 50));

		JPanel cellsPanel = new JPanel();

		cellsPanel.setLayout(new GridLayout(boardHeight, boardWidth));
		cellsPanel.setPreferredSize(new Dimension(boardWidth * cellSize,
						boardHeight * cellSize));

		for (int i = 0; i < boardHeight; i++)
		{
			for (int j = 0; j < boardWidth; j++)
			{
				matrix[i][j] = new QuintoCell(this, cellSize, i, j);
				matrix[i][j].setBackground(firstColor);
				matrix[i][j].addActionListener(new ButtonListener());
				cellsPanel.add(matrix[i][j]);
			}
		}
		setLayout(new GridLayout(2, 1));
		this.add(cellsPanel);
		this.add(buttonsPanel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();


		setResizable(false);

	}

	public boolean allChanged() {

		for (int i = 0; i < boardHeight; i++) {
			for (int j = 0; j < boardWidth; j++) {
				if (!matrix[i][j].isStateChanged())
					return false;
			}
		}
		return true;
	}

	public boolean flipCell(int row, int col, boolean flipSurrounding)
	{
		if (row>=0 && row <boardHeight && col >=0 && col < boardWidth)
		{
			matrix[row][col].flipState(flipSurrounding);
			return true;
		}
		return false;
	}

	public void clearBoard()
	{
		for (int i = 0; i < boardHeight; i++)
		{
			for (int j = 0; j < boardWidth; j++)
			{
				if (matrix[i][j].isStateChanged())
					matrix[i][j].flipState(false);
			}
		}
	}

	private class ButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource()==clearButton)
			{
				clearBoard();
			} else
			{
				((QuintoCell)e.getSource()).flipState(true);
				if (allChanged())
				{
					JOptionPane.showMessageDialog(((QuintoCell)((QuintoCell) e.getSource())).getParentBoard(),"You Won!");
					clearBoard();
				}

			}
		}


	}

}
