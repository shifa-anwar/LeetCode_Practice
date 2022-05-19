/*
Flood Fill
An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.You
are also given three integers sr, sc, and newColor. You should perform a flood fill on the image starting from the 
pixel image[sr][sc].To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally 
to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those 
pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with newColor.
Return the modified image after performing the flood fill.

Example 1:
Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, newColor = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.

Example 2:
Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, newColor = 2
Output: [[2,2,2],[2,2,2]]
 
Constraints:
m == image.length
n == image[i].length
1 <= m, n <= 50
0 <= image[i][j], newColor < 216
0 <= sr < m
0 <= sc < n
*/
1. class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
       int color = image[sr][sc]; //given pixel colour
        fill(image,sr,sc,newColor,color);
        return image;
    }
    public static void fill(int[][] image, int sr, int sc, int newColor,int color)
    {
        if(sr<0||sc<0||sr>=image.length||sc>=image[0].length||image[sr][sc]!=color ||image[sr][sc]==newColor)
        //if pixel color is changed already or color of pixel is not equal to given starting pixel colour
        {
            return;
        }
        if(sr==image.length && sc == image[0].length)//if we are at last row and column
        {
          return;  
        }
         image[sr][sc]=newColor;//change pixel colour
      fill(image,sr-1,sc,newColor,color);//top
       fill(image,sr,sc-1,newColor,color);//left
        fill(image,sr+1,sc,newColor,color);//down
        fill(image,sr,sc+1,newColor,color);//right
    }
}
/*
Complexity Analysis
Time Complexity: O(N), where N is the number of pixels in the image. We might process every pixel.
Space Complexity:O(N), the size of the implicit call stack when calling dfs.
*/
//2.in this type we have to return only the direction

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        boolean visit[][] = new boolean[arr.length][arr[0].length];
        floodfill(arr, 0, 0, "",visit);
    }
    
    // asf -> answer so far
    public static void floodfill(int[][] maze, int sr, int sc, String asf,boolean visit[][]) {
    if(sr<0||sc<0||sr>=maze.length||sc>=maze[0].length||maze[sr][sc]==1||visit[sr][sc]==true)
    {
    return;    
    }
    if(sr==maze.length-1 && sc==maze[0].length-1)
    {
    System.out.println(asf);
    return;    
    }
    visit[sr][sc]=true;
    floodfill(maze,sr-1,sc,asf+'t',visit);//top
    floodfill(maze,sr,sc-1,asf+'l',visit);//left
    floodfill(maze,sr+1,sc,asf+'d',visit);//down
    floodfill(maze,sr,sc+1,asf+'r',visit);//right
    visit[sr][sc]=false;
    }
}
/*
Time Complexity :
O(4*n2) which can simply be written as O(n2).
This is because each cell of the matrix is processed at most 4 times. For Example, a particular cell can be called by its top, down, left or right cell.

SPACE COMPLEXITY :
O(n2)
Since an extra 2D array is used for storing "visited" cells therefore the space complexity is quadratic.
*/