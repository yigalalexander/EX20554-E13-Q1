import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

/**
 * Created by yigalalexander on 5/4/15.
 */
public class QuintoGame
{

	public static void main(String args[])
	{
		int w=0;
		int h=0;
		String buffer = new String();
		Color firstColor, secondColor;

		int matrixBoxHeight,matrixBoxWidth;


		do {
			buffer=JOptionPane.showInputDialog("Enter the width of the matrix");
			try {
				w=Integer.parseInt(buffer);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null,"Incorrect number format!");
			}
		} while (!(w>0));


		do {
			buffer=JOptionPane.showInputDialog("Enter the height of the matrix");
			try {
				h=Integer.parseInt(buffer);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null,"Incorrect number format!");
			}
		} while (!(h>0));

		// ask for colors
		firstColor=JColorChooser.showDialog(null, "Choose first color",Color.BLACK);
		secondColor=JColorChooser.showDialog(null, "Choose second color",Color.BLACK);

		QuintoBoard mainBoard = new QuintoBoard(w,h,firstColor,secondColor);

		mainBoard.setVisible(true);

		// create a JFrame
		// Add
	}
}
