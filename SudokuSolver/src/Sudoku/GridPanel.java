package Sudoku;


import javax.swing.JPanel;

import java.awt.*;
import javax.swing.JTextField;
/** 
 * Represents a sudoku Grid.
 * @author Ali Bakly
*/
public class GridPanel extends JPanel{
	private JTextField[][] textMatrix;
	
	/**
	 * Creates the colored sudoku grid panel with a matrix which elements consists of textfields.
	 */
	public GridPanel(){
		makeGrid();
	}
	
	private void makeGrid(){
		Font font1 = new Font("SansSerif", Font.BOLD, 40);
		textMatrix = new JTextField[9][9];
		this.setLayout(new GridLayout(9, 9));
		for(int i = 0; i<81; i++) {
				JTextField textField = new JTextField(4);
				textField.setHorizontalAlignment(JTextField.CENTER);
				textField.setFont(font1);
				boolean toColor = (i%9>=0 && i%9<=2) || ((i%9>=6 && i%9<=8));
				if(i<27 && toColor) {
					textField.setBackground(Color.ORANGE);
				} else if(i>=27 && i<54  && !toColor) {
					textField.setBackground(Color.ORANGE);
				} else if(i>=54 && i<81 && toColor) {
					textField.setBackground(Color.ORANGE);
				}
				textMatrix[i/9][i%9] = textField;
				this.add(textField);
		}
	
	}
	/**
	 * Retrieves the matrix representation of current sudoku.
	 * 
	 * @return matrix with filled in digits, 0 if not filled.
	 * @throws IllegalArgumentException if 0 is an input.
	 * @throws IllegalArgumentException if input is not an int.
	 */
	public int[][] getIntMatrix(){
		int[][] matrix = new int[textMatrix.length][textMatrix[0].length]; 
		for(int i = 0; i<matrix.length; i++) {
			for(int j = 0; j<matrix[0].length; j++) {
				if(textMatrix[i][j].getText().isEmpty()) {
					matrix[i][j] = 0;
				}else {
					if(textMatrix[i][j].getText().contains("0")) {
						throw new IllegalArgumentException();
					}
					matrix[i][j] = Integer.parseInt(textMatrix[i][j].getText());				
				}
			}	
		}
		return matrix;
	}
	
	/**
	 * Fills textfield grid with the digits in m, 0 is converted into an empty textfield. 
	 */
	public void setMatrix(int[][] m){
		for(int i = 0; i<m.length; i++) {
			for(int j = 0; j<m[0].length; j++) {
				if(String.valueOf(m[i][j]).equals("0")) {
					textMatrix[i][j].setText("");
				} else {
					textMatrix[i][j].setText(String.valueOf(m[i][j]));
				}
			}	
		}
	}
	
	/**
	 * Empties the textfield grid.
	 */
	public void clearGrid() {
		for(int i = 0; i<textMatrix.length; i++) {
			for(int j = 0; j<textMatrix[0].length; j++) {
				textMatrix[i][j].setText("");
			}	
		}
	}
	
}
