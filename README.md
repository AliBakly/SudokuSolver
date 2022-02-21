# SudokuSolver
A simple Sudoku solver implemented with backtracking and a GUI.
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
The grid is represented by a matrix of dimensions 9x9. Rows and columns are indexed from 0 to 8 and each space takes a number between 1-9. 0 represents an empty space. To solve the problem you initially start at the first space (grid square), which is given by ```solve(0, 0)``` in the code. For each space there are then two cases
* Case 1
  1. Sub Item A
  2. Sub Item B
* Case 2
  1. Sub Item A
  2. Sub Item B
