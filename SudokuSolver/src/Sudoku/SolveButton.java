package Sudoku;

import javax.swing.JButton;

import javax.swing.JOptionPane;

/**
 *  Represents a button that initiates solving the sudoku.
 * @author Ali Bakly
*/
public class SolveButton extends JButton{
	private GridPanel gridPanel;
	
	/**
	 * Creates a button with the the text "Solve".
	 */
	public SolveButton(GridPanel gridPanel) {
		super("Solve");
		this.gridPanel = gridPanel;
	}
	
	/**
	 * Adds an actionListener which attempts to solve and display the sudoku when triggered.
	 */
	public void addSolveAction() {
		
		this.addActionListener(e->{
			
			try {
				int[][] matrix = gridPanel.getIntMatrix(); //throws IllegalArgumentException if input are not integers or input is 0
				SudokuSolver sudoku = new Sudoku();
				sudoku.setMatrix(matrix); //throws IllegalArgumentException if integers don't lie withing [0 and 9]
				boolean solved = sudoku.solve();
				if(solved) {
					matrix = sudoku.getMatrix();
					gridPanel.setMatrix(matrix);
				} else {
					JOptionPane.showMessageDialog(null,"Unsolvable Sudoku, try other numbers.");
				}
				
			} catch(IllegalArgumentException e2) {
				JOptionPane.showMessageDialog(null,"Wrong input.");
			}

		});
	}
}

