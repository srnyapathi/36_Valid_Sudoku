import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Solution2 {
    public boolean isValidSudoku(char[][] board) {
        int N = 9;
        HashSet<Character>[] rowSet = new HashSet[N];
        HashSet<Character>[] colSet = new HashSet[N];
        HashSet<Character>[] gridSet = new HashSet[N];

        for (int row = 0; row < N; row++) {
            rowSet[row] = new HashSet<Character>();
            colSet[row] = new HashSet<Character>();
            gridSet[row] = new HashSet<Character>();
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                var val = board[r][c];

                if (val == '.')
                    continue;
                if (rowSet[r].contains(val))
                    return false;
                rowSet[r].add(val);
                if (colSet[c].contains(val))
                    return false;
                colSet[c].add(val);

                int index = (r / 3) * 3 + c / 3;

                if (gridSet[index].contains(val))
                    return false;
                gridSet[index].add(val);

            }

        }
        return true;
    }

}

