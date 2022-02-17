package Sudoku;
/**
 *  Interface that represents a sudoku.
 * @author Ali Bakly
*/
public interface SudokuSolver {
	/**
	 * Tries to solve the given sudoku.
	 * 
	 * @return false if sudoku is unsolvable, otherwise true
	 */
	boolean solve();

	/**
	 * Puts digit in the box row, col.
	 * 
	 * @param row   The row
	 * @param col   The column
	 * @param digit The digit to insert in box row, col
	 * @throws IllegalArgumentException if row, col or digit is outside the range
	 *                                  [0..9]
	 */
	void add(int row, int col, int digit);

	/**
	 * Removes digit in the box row, col.
	 * 
	 * @param row   The row, indexing starts with 0
	 * @param col   The column, indexing starts with 0
	 * @throws IllegalArgumentException if row, col if outside the range [0..8] 
	 */
	void remove(int row, int col);

	/**
	 * Retrieves digit in box row, col.
	 * 
	 * @return digit in box row, col
	 * @param row   The row, indexing starts with 0
	 * @param col   The column, indexing starts with 0
	 * @throws IllegalArgumentException if row, col if outside the range [0..8] 
	 *                                  or if digit is outside the range [0..9]
	 */
	int get(int row, int col);

	/**
	 * Checks that all filled in digits follows the the sudoku rules.
	 * 
	 * @return true if filled in digits follow the rules, otherwise false
	 */
	boolean isValid();

	/**
	 * Empties the sudoku grid.
	 */
	void clear();

	/**
	 * Fills the grid with the digits in m. The digit 0 represents an empty box.
	 * 
	 * @param m the matrix with the digits to insert
	 * @throws IllegalArgumentException if m has the wrong dimension or contains
	 *                                  values outside the range [0..9]
	 */
	void setMatrix(int[][] m);

	/**
	 * Retrieves the current grid of numbers in the sudoku.
	 * 
	 * @return matrix with the numbers in the sudoku.
	 */
	int[][] getMatrix();
}
