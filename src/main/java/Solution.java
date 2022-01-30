import java.awt.desktop.SystemSleepEvent;
import java.util.*;

class Solution {
    List<Map<Character, Integer>> rowMap = new ArrayList<>();
    List<Map<Character, Integer>> colMap = new ArrayList<>();
    List<Map<Character, Integer>> gridMap = new ArrayList<>();

    public Solution() {
        for (int i = 0; i < 9; i++) {
            rowMap.add(new HashMap<>());
            colMap.add(new HashMap<>());
            gridMap.add(new HashMap<>());
        }
    }

    public boolean isValidSudoku(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        boolean result = true;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    rowMap.get(i).put(board[i][j], rowMap.get(i).getOrDefault(board[i][j], 0) + 1);
                    colMap.get(j).put(board[i][j], colMap.get(j).getOrDefault(board[i][j], 0) + 1);
                    int index = getGridIndex(i, j);
                    gridMap.get(index).put(board[i][j], gridMap.get(index).getOrDefault(board[i][j], 0) + 1);
                    int res= rowMap.get(i).get(board[i][j])+colMap.get(j).get(board[i][j])+gridMap.get(getGridIndex(i, j)).get(board[i][j]);
                    if(res!=3)
                        result=false;
                }
            }
        }


        return result;

    }

    private int getGridIndex(int i, int j) {
        switch (i / 3) {
            case 0:
                switch (j / 3) {
                    case 0:
                        return 0;
                    case 1:
                        return 3;
                    default:
                        return 6;
                }
            case 1:
                switch (j / 3) {
                    case 0:
                        return 1;
                    case 1:
                        return 4;
                    default:
                        return 7;
                }
            default:
                switch (j / 3) {
                    case 0:
                        return 2;
                    case 1:
                        return 5;
                    default:
                        return 8;
                }
        }
    }

}