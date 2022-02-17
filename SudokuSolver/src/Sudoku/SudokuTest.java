package Sudoku;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SudokuTest {
	private Sudoku sudoku;
	private final int[][] board1 ={ //valid
			 {0, 0, 0, 0, 0, 0, 0, 0, 0}, 
             {0, 0, 0, 0, 0, 0, 0, 0, 0},
             {0, 0, 0, 0, 0, 0, 0, 0, 0},
             {0, 0, 0, 0, 0, 0, 0, 0, 0},
             {0, 0, 0, 0, 0, 0, 0, 0, 0},
             {0, 0, 0, 0, 0, 0, 0, 0, 0},
             {0, 0, 0, 0, 0, 0, 0, 0, 0},
             {0, 0, 0, 0, 0, 0, 0, 0, 0},
             {0, 0, 0, 0, 0, 0, 0, 0, 0}
             };
	
	private final int[][] board2 = { //invalid
			{1, 4, 4, 0, 0, 0, 0, 0, 3},
			{2, 5, 0, 0, 0, 1, 0, 0, 0},
			{3, 0, 9, 0, 0, 0, 0, 0, 0},
			{0, 8, 0, 0, 2, 0, 0, 0, 4},
			{0, 0, 0, 4, 1, 0, 0, 2, 0},
			{9, 0, 0, 0, 0, 0, 6, 0, 0},
			{0, 0, 3, 0, 0, 0, 0, 0, 9},
			{4, 0, 0, 0, 0, 2, 0, 0, 0},
			{0, 0, 1, 0, 0, 8, 0, 0, 7},
			};
	
	private final int[][] board3 = { // valid (from project handout)
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
	
	private final int[][] board4 = { //invalid
			{5, 5, 5, 5, 5, 5, 5, 5, 5}, 
            {5, 5, 5, 5, 5, 5, 5, 5, 5},
            {5, 5, 5, 5, 5, 5, 5, 5, 5},
            {5, 5, 5, 5, 5, 5, 5, 5, 5},
            {5, 5, 5, 5, 5, 5, 5, 5, 5},
            {5, 5, 5, 5, 5, 5, 5, 5, 5},
            {5, 5, 5, 5, 5, 5, 5, 5, 5},
            {5, 5, 5, 5, 5, 5, 5, 5, 5},
            {5, 5, 5, 5, 5, 5, 5, 5, 5}
            };
	
	@BeforeEach
	void setUp() throws Exception {
		sudoku = new Sudoku();
	}

	@AfterEach
	void tearDown() throws Exception {
		sudoku = null;
	}

	@Test
	void testIsValid() {
		sudoku.setMatrix(board1);
		assertTrue(sudoku.isValid());
		sudoku.setMatrix(board2);
		assertFalse(sudoku.isValid());
		sudoku.setMatrix(board3);
		assertTrue(sudoku.isValid());
		sudoku.setMatrix(board4);
		assertFalse(sudoku.isValid());

	}
	
	@Test
	void testSolve() {
		sudoku.setMatrix(board1);
		assertTrue(sudoku.solve());
		sudoku.setMatrix(board2);
		assertFalse(sudoku.solve());
		sudoku.setMatrix(board3);
		assertTrue(sudoku.solve());
		sudoku.setMatrix(board4);
		assertFalse(sudoku.solve());
	}
	
	@Test
	void testAdd() {
		sudoku.setMatrix(board3);
		assertEquals(sudoku.get(7, 0), 8);
		sudoku.add(7, 0, 5);
		assertEquals(sudoku.get(7, 0), 5);
	}
	
	@Test
	void testRemove() {
		sudoku.setMatrix(board3);
		assertEquals(sudoku.get(7, 0), 8);
		sudoku.remove(7, 0);
		assertEquals(sudoku.get(7, 0), 0);
	}
	
	@Test
	void testGet() {
		sudoku.setMatrix(board3);
		assertEquals(sudoku.get(0, 0), 0);
		assertEquals(sudoku.get(6, 3), 6);
		assertEquals(sudoku.get(2, 3), 5);
	}
	
	@Test
	void testClear() {
		sudoku.setMatrix(board1);
		sudoku.clear();
		int[] tempArray = new int[9];
		Arrays.fill(tempArray, 0);
		int[][] matrix = sudoku.getMatrix();
		for(int i = 0; i<9; i++) {
			assertArrayEquals(matrix[i], tempArray);
		}
	}
	
	@Test
	void testsetAndgetMatrix() {
		sudoku.setMatrix(board3);
		for(int i = 0; i<9; i++) {
			assertArrayEquals(sudoku.getMatrix()[i], board3[i]);
		}
	}
	

}
