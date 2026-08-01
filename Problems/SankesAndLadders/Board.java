package SankesAndLadders;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Board {
    Cell[][] board;
    int size;
    private final List<Jump> jumps = new ArrayList<>();

    Board(int size) {
        this.size = size;
        board = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new Cell();
            }
        }
    }

    public void construct() {
        printBoard();
        Scanner sc = new Scanner(System.in);
        System.out.println("No.of ladders?");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter all ladder details:startx,starty,endx,endy:");
            int sx = sc.nextInt();
            int ex = sc.nextInt();
            int sy = sc.nextInt();
            int ey = sc.nextInt();
            sc.nextLine();

            int[] start = getInternalCoordinates(sx, sy);
            int[] end = getInternalCoordinates(ex, ey);

            Jump jump = new Jump(start[0], start[1], end[0], end[1], true, i + 1);
            board[start[0]][start[1]].intialise(jump);
            jumps.add(jump);
        }

        System.out.println("No.of snakes?");
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter all snake details:startx,starty,endx,endy:");
            int sx = sc.nextInt();
            int ex = sc.nextInt();
            int sy = sc.nextInt();
            int ey = sc.nextInt();
            sc.nextLine();

            int[] start = getInternalCoordinates(sx, sy);
            int[] end = getInternalCoordinates(ex, ey);

            Jump jump = new Jump(start[0], start[1], end[0], end[1], false, i + 1);
            board[start[0]][start[1]].intialise(jump);
            jumps.add(jump);
        }
        sc.close();
        printBoard();
    }

    private int[] getInternalCoordinates(int row, int col) {
        int adjustedRow = row;
        int adjustedCol = col;

        if (adjustedRow % 2 != 0) {
            adjustedCol = size - 1 - adjustedCol;
        }

        return new int[]{adjustedRow, adjustedCol};
    }

    public int next(int curr, int sum) {
        int next = curr + sum;
        if (next >= size * size) {
            return next;
        }
        int x = next / size;
        int y = next % size;
        if (board[x][y].jump == null) {
            return (size * x) + y;
        } else {
            return board[x][y].next(size);
        }
    }

    public void printBoard() {
        printBoard(new HashMap<>());
    }

    public void printBoard(Map<player, Integer> positions) {
        System.out.println("Board layout:");
        for (int displayRow = 0; displayRow < size; displayRow++) {
            int internalRow = size - 1 - displayRow;
            for (int displayCol = 0; displayCol < size; displayCol++) {
                int internalCol = displayCol;
                if ((displayRow % 2) != 0) {
                    internalCol = size - 1 - displayCol;
                }

                int cellNumber = (internalRow * size) + internalCol;
                String label = getCellLabel(cellNumber, positions, internalRow, internalCol);
                System.out.printf("%6s", label);
            }
            System.out.println();
        }
    }

    private String getCellLabel(int cellNumber, Map<player, Integer> positions, int row, int col) {
        StringBuilder symbols = new StringBuilder();
        for (Map.Entry<player, Integer> entry : positions.entrySet()) {
            if (entry.getValue() != null && entry.getValue() == cellNumber) {
                if (symbols.length() > 0) {
                    symbols.append(",");
                }
                symbols.append(entry.getKey().getSymbol());
            }
        }

        for (Jump jump : jumps) {
            boolean isStart = (jump.sx == row && jump.sy == col);
            boolean isEnd = (jump.ex == row && jump.ey == col);

            if (isStart || isEnd) {
                if (symbols.length() > 0) {
                    symbols.append(",");
                }
                String type = jump.isLadder() ? "L" : "S";
                String suffix = isStart ? "s" : "e";
                symbols.append(type + jump.getId() + suffix);
            }
        }

        if (symbols.length() > 0) {
            return symbols.toString();
        }
        return String.valueOf(cellNumber);
    }
}
