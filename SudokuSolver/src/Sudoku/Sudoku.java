package Sudoku;

/** 
 * Represents a sudoku.
 * @author Ali Bakly
*/
public class Sudoku implements SudokuSolver{

	private int[][] board;
	
	/**
	 * Creates new sudoku with empty grid. 
	 */
	public Sudoku() {
		board = new int[9][9];
		setEmptyBoard();
	}
	
	private void setEmptyBoard() {
		for(int i =0; i<9; i++) {
			for(int j =0; j<9; j++) {
				board[i][j]=0;
			}
		}
	}
	
	/**
	 * Tries to solve the given sudoku.
	 * 
	 * @return false if sudoku is unsolvable, otherwise true
	 */
	@Override
	public boolean solve() {
		if(isValid()==false) {
			return false;
		}
		return solve(0, 0);
	}
	
	private boolean solve(int r, int c) {
		
		if(r == 9) {
			return true;
		}
		
		if(board[r][c]==0) {
			for(int i = 1; i<=9; i++) {
				if(isValidPosition(r, c, i)) {
					board[r][c] = i;
					if(c != 8) {
						if(solve(r, c+1)) {
							return true;
						} else {
							board[r][c] = 0;
						}
					}else {
						if(solve(r+1, 0)) {
							return true;
						}else {
							board[r][c] = 0;
						}
					}
				}
			}
		} else {
			if(!(isValidPosition(r, c , board[r][c]))) {
				return false;
			} else {
				if(c != 8) {
					if(solve(r, c+1)) {
						return true;
					}
				}else {
					if(solve(r+1, 0)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * Puts digit in the box row, col. The digit 0 represents an empty box.
	 * 
	 * @param row   The row, indexing starts with 0
	 * @param col   The column, indexing starts with 0
	 * @param digit The digit to insert in box row, col
	 * @throws IllegalArgumentException if row, col if outside the range [0..8] 
	 *                                  or if digit is outside the range [0..9]
	 */
	@Override
	public void add(int row, int col, int digit) {
		if(row>=0 && row<=8 && col>=0 && col<=8 && digit>=0 && digit<=9) {
			board[row][col] = digit;
		}else {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Removes digit in the box row, col.
	 * 
	 * @param row   The row, indexing starts with 0
	 * @param col   The column, indexing starts with 0
	 * @throws IllegalArgumentException if row, col if outside the range [0..8] 
	 */
	@Override
	public void remove(int row, int col) {
		if(row>=0 && row<=8 && col>=0 && col<=8) {
			board[row][col] = 0;
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * Retrieves digit in box row, col.
	 * 
	 * @return digit in box row, col
	 * @param row   The row, indexing starts with 0
	 * @param col   The column, indexing starts with 0
	 * @throws IllegalArgumentException if row, col if outside the range [0..8] 
	 *                                  or if digit is outside the range [0..9]
	 */
	@Override
	public int get(int row, int col) {
		if(row>=0 && row<=8 && col>=0 && col<=8) {
			return board[row][col];
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * Checks that all filled in digits follows the the sudoku rules.
	 * 
	 * @return true if filled in digits follow the rules, otherwise false
	 */
	@Override
	public boolean isValid() {
		for(int i = 0; i<9; i++) {
			for(int j = 0; j<9; j++) {
				if(isValidPosition(i, j, board[i][j])==false) {
					return false;
				}
			}
		}
		return true;
	}
	
	private boolean isValidPosition(int r, int c, int nbr) {
		if(rowIsValid(r, c, nbr) == true && colIsValid(r, c, nbr) == true && subSquareIsValid(r, c, nbr) == true) {
			return true;
		}
		return false;
	}
	
	private boolean rowIsValid(int r, int c, int nbr) {
		for(int i = 0; i<9; i++) {
			if(board[r][i] == nbr && board[r][i]!=0 && i!=c) {
				return false;
			}
		}
		return true;
	}
	
	private boolean colIsValid(int r, int c, int nbr) {
		for(int i = 0; i<9; i++) {
			if(board[i][c] == nbr && board[i][c]!=0 && i!=r) {
				return false;
			}
		}
		return true;
	}
	
	private boolean subSquareIsValid(int r, int c, int nbr) {
		int rowSubSquare = r -  r % 3;
		int colSubSquare = c - c % 3;
		
		for(int i = 0; i<3; i++) {
			for(int j = 0; j<3; j++) {
				int currentNbr = board[rowSubSquare+i][colSubSquare+j];
				if( currentNbr== nbr && currentNbr!=0 && rowSubSquare+i!=r &&colSubSquare+j!=c) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	/**
	 * Empties the sudoku grid.
	 */
	@Override
	public void clear() {
		setEmptyBoard();
	}

	/**
	 * Fills the grid with the digits in m. The digit 0 represents an empty box.
	 * 
	 * @param m the matrix with the digits to insert
	 * @throws IllegalArgumentException if m has the wrong dimension or contains
	 *                                  values outside the range [0..9]
	 */
	@Override
	public void setMatrix(int[][] m) {
		if(m.length!=9 || m[0].length!=9) {
			throw new IllegalArgumentException();
		}
		for(int i = 0; i<m.length; i++) {
			for(int j = 0; j<m[0].length; j++) {
				if(!(m[i][j]>=0 && m[i][j]<=9)) {
					throw new IllegalArgumentException();
				}
			}
		}	
		board = m;
	}
	
	/**
	 * Retrieves the current grid of numbers in the sudoku.
	 * 
	 * @return matrix with the numbers in the sudoku.
	 */
	@Override
	public int[][] getMatrix() {
		return board;
	}
}
