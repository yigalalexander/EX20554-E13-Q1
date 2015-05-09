import javax.swing.*;

/**
 * Created by yigalalexander on 5/4/15.
 */
public class QuintoCell extends JButton
{
    private boolean stateChanged;
	private int myRow, myCol;
	private QuintoBoard parentBoard;

	public QuintoBoard getParentBoard() {
		return parentBoard;
	}

	public void setParentBoard(QuintoBoard parentBoard) {
		this.parentBoard = parentBoard;
	}



	public int getMyCol() {
		return myCol;
	}

	public int getMyRow() {
		return myRow;
	}



    public boolean isStateChanged() {
		return stateChanged;
	}

	public void flipState(boolean flipSurrounding) {


		//Flip around me
		if (flipSurrounding)
		{
			parentBoard.flipCell(myRow-1,myCol,false);
			parentBoard.flipCell(myRow+1,myCol,false);
			parentBoard.flipCell(myRow,myCol-1,false);
			parentBoard.flipCell(myRow,myCol+1,false);
		} else//Flip myself
		{
			this.stateChanged = !this.stateChanged;
			setBackground(this.stateChanged ?
					parentBoard.getSecondColor() : parentBoard.getFirstColor());
		}
	}



	public QuintoCell(QuintoBoard board, int size, int row, int col)
    {
        stateChanged=false;
		parentBoard=board;
		setSize(size,size);
		//setOpaque(true);
		myRow=row;
		myCol=col;
    }
}
