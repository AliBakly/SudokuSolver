package Sudoku;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.*;

/**
 *  Represents a sudoku graphical user interface.
 * @author Ali Bakly
*/
public class SudokuController {
	/**
	 * Creates the sudoku graphical user interface.
	 */
	public SudokuController() {
		SwingUtilities.invokeLater(() -> createWindow());
		}
	
		private void createWindow() {
			
		JFrame frame = new JFrame("Sudoku");
		frame.setPreferredSize(new Dimension(800,800));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel buttonPanel = new JPanel();
		Container pane = frame.getContentPane();
		pane.setLayout(new BoxLayout(pane, BoxLayout.PAGE_AXIS));
		
		GridPanel gridPanel = new GridPanel();

		gridPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, gridPanel.getMaximumSize().height));
		buttonPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, buttonPanel.getMinimumSize().height));
		
		buttonPanel.setLayout(new FlowLayout());
		JButton buttonSolve = new SolveButton(gridPanel);
		JButton buttonClear = new JButton("Clear");
		JButton buttonExample = new JButton("Example");
		pane.add(gridPanel);
		buttonPanel.add(buttonSolve);
		buttonPanel.add(buttonClear);
		buttonPanel.add(buttonExample);
		pane.add(buttonPanel);
		
		((SolveButton) buttonSolve).addSolveAction();
		
		buttonClear.addActionListener(e->{
			gridPanel.clearGrid();
		});
		
		  int grid[][] = { 
					{0, 0, 8, 0, 0, 9, 0, 6, 2}, 
					{0, 0, 0, 0, 0, 0, 0, 0, 5},
					{1, 0, 2, 5, 0, 0, 0, 0, 0}, 
					{0, 0, 0, 2, 1, 0, 0, 9, 0}, 
					{0, 5, 0, 0, 0, 0, 6, 0, 0},
					{6, 0, 0, 0, 0, 0, 0, 2, 8}, 
					{4, 1, 0, 6, 0, 8, 0, 0, 0}, 
					{8, 6, 0, 0, 3, 0, 1, 0, 0},
					{0, 0, 0, 0, 0, 0, 4, 0, 0} 
              };
		  
		buttonExample.addActionListener(e->{
			gridPanel.setMatrix(grid);
		});
		
		frame.pack();
		frame.setVisible(true);
		
		}

}
