# SudokuSolver
A simple Sudoku solver implemented with backtracking in Java and a GUI made with the Java framework Swing.
# Table of contents

- [Running the application](#running-the-application)
- [Documentation](#documentation)
- [The Algorithm](#the-algorithm)

# Running the application
Given you have a Java Runtime environment installed on the computer all you have to do is running SudokuApplication.java. You will then find the GUI after the button Example is pressed:

<img width="500" alt="SudokuGUI" src="https://user-images.githubusercontent.com/21970392/154867939-773a77aa-9004-497a-ae92-12955956dc80.png">

The GUI is written with the Swing frameworks and the buttons are self explanatory.

# Documentation
All classes, interfaces and public methods have been provided documentation, according to the Javadoc documentation generator. You can find these by opening the file allclasses-index.html in your browser or IDE.

# The Algorithm
The grid is represented by a matrix of dimensions 9x9. Rows and columns are indexed from 0 to 8 and each space takes a number between 1-9. 0 represents an empty space. To solve the problem you initially start at the first space (grid square), which is given by ```solve(0, 0)``` in the code. The base case for when a solution have been found is when we have reacheded row 9 (return true). Otherwise, for each space there are then two cases
* Current space is not filled in.
  1. Loop through numbers 1-9.
      - If the number at the given position is valid then fill that space with the number.
          1. Make a recursive call to the next space.
          2. If the recursive call returns true then a solution have been found and we are finished(return true), if not remove the number.
* Current space is filled in.
  1. Check if the number at the given space is valid. If not then there is no solution(return false). Otherwise make a recursive call to the next space.
      - If the recursive call returns true then a solution have been found and we are finished(return true).
  2. If the recursive call does not find a solution there is none and return false.
