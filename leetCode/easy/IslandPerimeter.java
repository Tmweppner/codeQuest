// Island Perimeter
// TODO:
// You are given a map in form of a two-dimensional integer grid where 1
// represents land and 0 represents water. Grid cells are connected
// horizontally/vertically (not diagonally). The grid is completely surrounded
// by water, and there is exactly one island (i.e., one or more connected land
// cells). The island doesn't have "lakes" (water inside that isn't connected to
// the water around the island). One cell is a square with side length 1. The
// grid is rectangular, width and height don't exceed 100. Determine the
// perimeter of the island.
//
// Example:
//
// [[0,1,0,0],
//  [1,1,1,0],
//  [0,1,0,0],
//  [1,1,0,0]]
//
// Answer: 16







public class Solution {
    public int islandPerimeter(int[][] grid) {
        if(grid.length == 1 && grid[0][0] == 1 && grid[0].length == 1){
            return 4;
        }
        if(grid[0].length == 1 && grid.length > 1){
            return around1D(grid);
        }
        else if(grid.length == 1 && grid[0].length > 1){
            return around_1D(grid);
        }
        int edges = 0;
        for(int i =0; i < grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                edges+= around(grid,i,j);
                }

            }
        }
        return edges;
    }



//for cases like [ [1,0,1,1,0] ]
    public int around_1D(int[][] grid){
        int count = 0;
        int edge = 0;
        for(int i =0; i<grid[0].length; i++){
            if(grid[0][i] == 1){
                count = count + 1;
            }
            else{
                if(count ==1){
                    edge += 4;
                    count = 0;
                }
                else if(count>1){
                    edge += (count * 4) -((count-1)*2);
                    count =0;
                }
            }
        }
        if(count != 0){
            if(count == 1){
                edge+=4;
                count = 0;
            }
            else if(count>1){
                int first = count * 4;
                int second = count -1;
                second = second * 2;
                int total = first - second;
                edge = edge + total;
                count =0;
            }

        }
        return edge;

    }




//for cases like [1,0,1,0,1,1,1,0]
    public int around1D(int[][] grid){
        int count = 0;
        int edge = 0;
        for(int i =0; i<grid.length; i++){
            if(grid[i][0] == 1){
                count ++;
            }
            else{
                if(count == 1){
                    edge += 4;
                    count = 0;
                }
                else if(count>1){
                    edge += (count * 4) -((count-1)*2);
                    count =0;
                }
            }
        }
        if(count != 0){
            if(count == 1){
                edge+=4;
                count = 0;
            }
            else if(count>1){
                edge += (count * 4) -((count-1)*2);
                count =0;
            }

        }
        return edge;

    }

    public int around(int[][] grid, int x, int y){
        int edges = 4;
        //on edge of grid

        if(x == 0){//top

            if(y==0){//top left
                if(grid[x+1][y] == 1){//check right
                    edges--;
                }

                if(grid[x][y+1]==1){//check down
                    edges--;
                }
            }

            else if(y == grid[0].length -1){//top right
             //   edges--;
                if(grid[x][y-1]==1){//check up
                    edges--;
                }
                if(grid[x+1][y] == 1){//check right
                    edges--;
                }
            }
            else{//top center
                if(grid[x][y-1]==1){//check up
                    edges--;
                }
                if(grid[x+1][y] == 1){//check right
                    edges--;
                }
                if(grid[x][y+1] == 1){//check down
                    edges--;
                }
            }

            return edges;
        }
        else if(x == grid.length - 1){//bottom
            if(y==0){//bottom left
                if(grid[x-1][y] == 1){
                    edges--;
                }
                if(grid[x][y+1]==1){
                    edges--;
                }
                return edges;
            }
            else if(y == grid[0].length - 1){//bottom right
                if(grid[x-1][y] == 1){
                    edges--;
                }
                if(grid[x][y-1]==1){
                    edges--;
                }
                return edges;
            }
            else{//bottom center
                if(grid[x-1][y] == 1){
                    edges--;
                }
                if(grid[x][y-1]==1){
                    edges--;
                }
                if(grid[x][y+1]==1){
                    edges--;
                }
                return edges;
            }

        }



        if(y==0){//left center
            if(grid[x-1][y] == 1){
                edges--;
            }
            if(grid[x+1][y]==1){
                edges--;
            }
            if(grid[x][y+1]==1){
                edges--;
            }
            return edges;
        }
        else if(y == grid[0].length -1){//right center
            if(grid[x-1][y] == 1){
                edges--;
            }
            if(grid[x+1][y]==1){
                edges--;
            }
            if(grid[x][y-1]==1){
                edges--;
            }
            return edges;

        }

        //normal case
        if(grid[x+1][y] == 1){
            edges--;
        }
        if(grid[x-1][y] == 1){
            edges--;
        }
        if(grid[x][y+1]==1){
            edges--;
        }
        if(grid[x][y-1]==1){
            edges--;
        }
        return edges;

   }
}
