package edu.ics211.h08;

import java.util.ArrayList;

/**
 * Class for recursively finding a solution to a Hexadecimal Sudoku problem.
 *
 * @author Alton Lee
 * @author Emily Pang
 * @author Biagioni, Edoardo, Cam Moore date August 5, 2016 missing solveSudoku,
 *         to be implemented by the students in ICS 211
 */
public class HexadecimalSudoku {

  /**
   * Find an assignment of values to sudoku cells that makes the sudoku valid.
   *
   * @param sudoku the sudoku to be solved.
   * @return whether a solution was found if a solution was found, the sudoku is
   *         filled in with the solution if no solution was found, restores the
   *         sudoku to its original value.
   */
  public static boolean solveSudoku(int[][] sudoku) {
    return solveSudoku(sudoku, 0, 0);
  }


  /**
   * Recursion method helper. Helped by Emily Pang (bless her soul). Referenced
   * http://codepumpkin.com/sudoku-solver-using-backtracking/
   * 
   * @param sudoku - sudoku to be solved
   * @param row - current row
   * @param col - current column
   * @return true if solution found, false if none
   */
  public static boolean solveSudoku(int[][] sudoku, int row, int col) {
    // If sudoku is solved...
    if (col == 16 || row == 16) {
      return true;

      // Else if not, move thru sudoku cells
    } else if (sudoku[row][col] != -1) {
      // If it's not the end of a row...
      if (col != 15) {
        // Move 1 column
        return solveSudoku(sudoku, row, col + 1);
      } else {
        // Else move to next row, start at 1st column
        return solveSudoku(sudoku, row + 1, 0);
      }

      // If empty sudoku cell, try to solve
    } else if (sudoku[row][col] == -1) {
      ArrayList<Integer> legal = legalValues(sudoku, row, col);
      // If there are legal values...
      if (legal != null) {
        // Iterate thru all legal values of that cell
        for (int i = 0; i < legal.size(); i++) {
          sudoku[row][col] = legal.get(i);
          // If it worked, quit recursion
          if (solveSudoku(sudoku, row, col)) {
            return true;
            // Else, bad value
          } else {
            sudoku[row][col] = -1;
          }
        }
        // If no legal values
      } else {
        return false;
      }
    }
    return false;
  }


  /**
   * Find the legal values for the given sudoku and cell. Referenced
   * http://codepumpkin.com/sudoku-solver-using-backtracking/
   *
   * @param sudoku the sudoku being solved.
   * @param row the row of the cell to get values for.
   * @param column the column of the cell.
   * @return an ArrayList of the valid values.
   */
  public static ArrayList<Integer> legalValues(int[][] sudoku, int row, int column) {
    ArrayList<Integer> legal = new ArrayList<Integer>();
    checkSudoku(sudoku, true);
    // Checks if number can be used in that row, col, and box
    for (int i = 0; i < 16; i++) {
      if (containsNumber(sudoku, row, column, i)) {
        legal.add(i);
      }
    }
    // If no valid number, return null
    if (legal.isEmpty()) {
      return null;
    }
    return legal;
  }


  /**
   * checks that the sudoku rules hold in this sudoku puzzle. cells that contain 0
   * are not checked.
   *
   * @param sudoku the sudoku to be checked.
   * @param printErrors whether to print the error found, if any.
   * @return true if this sudoku obeys all of the sudoku rules, otherwise false.
   */
  public static boolean checkSudoku(int[][] sudoku, boolean printErrors) {
    if (sudoku.length != 16) {
      if (printErrors) {
        System.out.println("sudoku has " + sudoku.length + " rows, should have 16");
      }
      return false;
    }
    for (int i = 0; i < sudoku.length; i++) {
      if (sudoku[i].length != 16) {
        if (printErrors) {
          System.out.println(
              "sudoku row " + i + " has " + sudoku[i].length + " cells, should have 16");
        }
        return false;
      }
    }
    /* check each cell for conflicts */
    for (int i = 0; i < sudoku.length; i++) {
      for (int j = 0; j < sudoku.length; j++) {
        int cell = sudoku[i][j];
        if (cell == -1) {
          continue; /* blanks are always OK */
        }
        if ((cell < 0) || (cell > 16)) {
          if (printErrors) {
            System.out.println("sudoku row " + i + " column " + j + " has illegal value "
                + String.format("%02X", cell));
          }
          return false;
        }
        /* does it match any other value in the same row? */
        for (int m = 0; m < sudoku.length; m++) {
          if ((j != m) && (cell == sudoku[i][m])) {
            if (printErrors) {
              System.out.println("sudoku row " + i + " has " + String.format("%X", cell)
                  + " at both positions " + j + " and " + m);
            }
            return false;
          }
        }
        /* does it match any other value it in the same column? */
        for (int k = 0; k < sudoku.length; k++) {
          if ((i != k) && (cell == sudoku[k][j])) {
            if (printErrors) {
              System.out.println("sudoku column " + j + " has "
                  + String.format("%X", cell) + " at both positions " + i + " and " + k);
            }
            return false;
          }
        }
        /* does it match any other value in the 4x4? */
        for (int k = 0; k < 4; k++) {
          for (int m = 0; m < 4; m++) {
            int testRow = (i / 4 * 4) + k; /* test this row */
            int testCol = (j / 4 * 4) + m; /* test this col */
            if ((i != testRow) && (j != testCol) && (cell == sudoku[testRow][testCol])) {
              if (printErrors) {
                System.out.println("sudoku character " + String.format("%X", cell)
                    + " at row " + i + ", column " + j + " matches character at row "
                    + testRow + ", column " + testCol);
              }
              return false;
            }
          }
        }
      }
    }
    return true;
  }


  /**
   * Converts the sudoku to a printable string.
   *
   * @param sudoku the sudoku to be converted.
   * @param debug whether to check for errors.
   * @return the printable version of the sudoku.
   */
  public static String toString(int[][] sudoku, boolean debug) {
    if ((!debug) || (checkSudoku(sudoku, true))) {
      String result = "";
      for (int i = 0; i < sudoku.length; i++) {
        if (i % 4 == 0) {
          result = result + "+---------+---------+---------+---------+\n";
        }
        for (int j = 0; j < sudoku.length; j++) {
          if (j % 4 == 0) {
            result = result + "| ";
          }
          if (sudoku[i][j] == -1) {
            result = result + "  ";
          } else {
            result = result + String.format("%X", sudoku[i][j]) + " ";
          }
        }
        result = result + "|\n";
      }
      result = result + "+---------+---------+---------+---------+\n";
      return result;
    }
    return "illegal sudoku";
  }


  /**
   * Checks if number is present in current row, column, or box. Referenced
   * http://codepumpkin.com/sudoku-solver-using-backtracking/
   * 
   * @param sudoku - board
   * @param row - row to check
   * @param col - column to check
   * @param number - number to compare to
   * @return - true if number is present, false if not
   */
  static boolean containsNumber(int[][] sudoku, int row, int col, int number) {
    // Check if can place in row
    for (int i = 0; i < sudoku[row].length; i++) {
      if (sudoku[row][i] == number) {
        return false;
      }
    }
    // Check if can place in column
    for (int i = 0; i < sudoku.length; i++) {
      if (sudoku[i][col] == number) {
        return false;
      }
    }
    // Check if can place in box
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        int r = (row / 4 * 4) + i;
        int c = (col / 4 * 4) + j;
        if (sudoku[r][c] == number) {
          return false;
        }
      }
    }
    return true;
  }
}
