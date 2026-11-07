package com.leetcode.solutions.crashcourse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NumberOfIslands {

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0'},
                {'1', '0', '0', '1'},
                {'0', '0', '1', '1'}
        };
        int result = numIslands(grid);
        System.out.println(result);

    }

    public static int numIslands(char[][] grid) {
        int count = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    count++;
                    sink(grid, r, c);
                }
            }
        }
        return count;
    }

    private static void sink(char[][] grid, int r, int c) {
        // base case: stop if r or c is off the grid, OR this cell is not '1'
        if (r < 0 || r > grid.length-1 || c < 0 || c > grid[0].length-1 || grid[r][c] != '1') {
            // do nothing
        } else {
            // otherwise: turn this cell into '0'
            grid[r][c] = '0';
            // then call sink on the 4 neighbors: up, down, left, right
            sink(grid, r - 1, c);
            sink(grid, r + 1, c);
            sink(grid, r, c - 1);
            sink(grid, r, c+1);
        }

    }
}
