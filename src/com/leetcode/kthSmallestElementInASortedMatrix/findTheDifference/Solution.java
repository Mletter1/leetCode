package com.leetcode.kthSmallestElementInASortedMatrix.findTheDifference;
/**
 * Created by mletter1 on 9/4/16.
 */
public class Solution {
  public int kthSmallest(int[][] matrix, int k) {
    quickSortMatrix(matrix, 0, 0, matrix.length-1, matrix[0].length-1);
    // printMatrix(matrix);
    return this.getItemAtPositionK(matrix, k);
  }
  public int getItemAtPositionK(int[][] matrix, int k){
    if(k <= matrix[0].length){
      return matrix[0][k-1];
    }
    for(int x = 1; x < matrix.length; x++){
      // System.out.println((x+1)*matrix.length + " " + k);
      if(((x+1)*matrix.length) >= k){
        int base = matrix.length*x;
        int count = 1;
        for(int y = 0;y < matrix[x].length; y++){
          // System.out.println(base+count);
          if((base+count)==k){
            return matrix[x][y];
          }
          count++;
        }
      }
    }
    return matrix[0][0];

  }
  public void quickSortMatrix(int[][] matrix, int highX,int highY, int lowX, int lowY){
    if(highLessThanLow(matrix, highX, highY, lowX, lowY)){
      // System.out.println("break :"+highX+":"+highY+ "  " +lowX+":"+lowY);
      return;
    }
    // System.out.println(highX+":"+highY+ "  " +lowX+":"+lowY);
    int [] p = partition(matrix, highX, highY, lowX, lowY);
    // System.out.println(p[0]+":"+p[1]);
    quickSortMatrix(matrix, p[0], p[1], lowX, lowY);
    if(p[1] - 1 < 0){
      quickSortMatrix(matrix, highX, highY, p[0] - 1, (matrix[0].length - 1));
    }else{
      quickSortMatrix(matrix, highX, highY, p[0], p[1]-1);
    }
    return;
  }
  private boolean highLessThanLow(int[][] matrix, int highX,int highY, int lowX, int lowY){
    if(highX > lowX){
      return true;
    }
    if(highX == lowX && highY >= lowY){
      return true;
    }
    return false;
  }
  /**
   * Given Matrix
   * [
   *   [1,2,3],
   *   [4,5,6],
   *   [7,8,9],
   * ]
   * [0][0] == 1 is highX and highY
   * [2][2] == 9 is lowX  and  lowY
   *
   */
  public int[] partition(int[][] matrix, int highX,int highY, int lowX, int lowY){
    //part[xVal,yVal]
    int temp = 0;
    int [] swap = new int[2];
    swap[0] = highX;
    swap[1] = highY;
    for(int x = highX; x <= lowX; x++){
      // System.out.println(x);
      if(x == highX && x != lowX){
        for(int y = highY; y < matrix[0].length; y++){
          if(matrix[x][y] <= matrix[lowX][lowY]){
            temp = matrix[x][y];
            matrix[x][y] = matrix[swap[0]][swap[1]];
            matrix[swap[0]][swap[1]] = temp;
            increment(matrix, swap);
          }
        }
      }
      else if(x == lowX && x == highX){
        for(int y = highY; y < lowY; y++){
          if(matrix[x][y] <= matrix[lowX][lowY]){
            temp = matrix[x][y];
            matrix[x][y] = matrix[swap[0]][swap[1]];
            matrix[swap[0]][swap[1]] = temp;
            increment(matrix, swap);
          }
        }
      }
      else if(x == lowX && x != highX){
        for(int y = 0; y < lowY; y++){
          if(matrix[x][y] <= matrix[lowX][lowY]){
            temp = matrix[x][y];
            matrix[x][y] = matrix[swap[0]][swap[1]];
            matrix[swap[0]][swap[1]] = temp;
            increment(matrix, swap);
          }
        }
      }else{// not on highX or lowX
        for(int y = 0; y < matrix[0].length; y++){
          if(matrix[x][y] <= matrix[lowX][lowY]){
            //System.out.println(swap[0]+":"+swap[1]);
            temp = matrix[x][y];
            matrix[x][y] = matrix[swap[0]][swap[1]];
            matrix[swap[0]][swap[1]] = temp;
            increment(matrix, swap);
          }
        }
      }
    }
    // System.out.println(swap[0]+":"+swap[1]);
    temp = matrix[swap[0]][swap[1]];
    matrix[swap[0]][swap[1]] = matrix[lowX][lowY];
    matrix[lowX][lowY] = temp;
    return swap;
  }
  public void printMatrix(int[][]matrix){
    String s = " [";
    for(int[] array: matrix){
      s += " [";
      for(int num: array){
        s += num + " ";
      }
      s += " ]";
    }
    s +=" ]";
    System.out.println(s);
  }
  private void increment(int[][]matrix, int[] swap){
    if(swap[1] + 1 >= matrix[0].length){
      swap[0]++;
      swap[1] = 0;
    }else{
      swap[1]++;
    }
  }
}
