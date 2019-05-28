import java.util.*;

public class Kata_01_Screen_Locking_Patterns {

    public static void main(String[] args) {
//        assertEquals(0, sl.calculateCombinations('A',10));
//        assertEquals(0, sl.calculateCombinations('A',0));
//        assertEquals(0, sl.calculateCombinations('E',14));
//        assertEquals(1, sl.calculateCombinations('B',1));
//        assertEquals(5, sl.calculateCombinations('C',2));
//        assertEquals(8, sl.calculateCombinations('E',2));
//        assertEquals(256, sl.calculateCombinations('E',4));

//        System.out.println(calculateCombinations('A', 10));
//        System.out.println(calculateCombinations('A', 0));
//        System.out.println(calculateCombinations('A', 0));
//        System.out.println(calculateCombinations('E', 14));
//        System.out.println(calculateCombinations('B', 1));
//        System.out.println(calculateCombinations('C', 2));
//        System.out.println(calculateCombinations('E', 2));
        System.out.println(calculateCombinations('E', 4));
    }

    public static int calculateCombinations(char startPosition, int patternLength) {
        Character[][] matrix = new Character[][]{{'A', 'B', 'C'}, {'D', 'E', 'F'}, {'G', 'H', 'I'}};
        List<String> path = new ArrayList<>();
        Set<String> result = new HashSet<>();
        System.out.println(startPosition);
        System.out.println(patternLength);
        if(patternLength == 0){
            return 0;
        }

        int startRow = 0;
        int startCol = 0;

        boolean setRowCol = false;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == startPosition) {
                    startRow = row;
                    startCol = col;
                    setRowCol = true;
                    break;
                }
            }
            if (setRowCol) {
                break;
            }
        }


        int count = findPaths(startRow, startCol, startPosition + "", patternLength, path, result, matrix);

        System.out.println(Arrays.toString(result.toArray()));
        return count;

    }

    private static int findPaths(int row, int col, String direction, int patternLength, List<String> path, Set<String> result, Character[][] matrix) {
        if (!isInBounds(row, col, matrix) || path.size() >= patternLength) {
//            System.out.println(Arrays.toString(path.toArray()));

            if(path.size() == patternLength && isInBounds(row, col, matrix)){
                String collect = String.join("| ", path);
                result.add(collect);
                return  result.size();
            }

            return result.size();
        }

        path.add(direction);

        if (!isVisited(row, col, matrix)) {
            getPath(row, col, patternLength, path, result,matrix);
        }
//        else if(!isVisited(row + 1, col, matrix)){
//            getPath(row + 2, col, patternLength, path, result,matrix);
//        }else if(!isVisited(row - 1 , col, matrix)){
//            getPath(row - 2, col, patternLength, path, result,matrix);
//        }else if(!isVisited(row  , col + 1, matrix)){
//            getPath(row , col + 2, patternLength, path, result,matrix);
//        }else if(!isVisited(row  , col - 1, matrix)){
//            getPath(row , col - 2, patternLength, path, result,matrix);
//        }



        path.remove(path.size() - 1);
        return result.size();
    }

    private static void getPath(int row, int col, int patternLength, List<String> path, Set<String> result, Character[][] matrix) {
        mark(row, col, matrix);
        findPaths(row, col + 1, "R", patternLength, path, result, matrix);
        findPaths(row, col - 1, "L", patternLength, path, result, matrix);
        findPaths(row + 1, col, "D", patternLength, path, result, matrix);
        findPaths(row - 1, col, "U", patternLength, path, result, matrix);

        // diagonals
        findPaths(row + 1, col + 1, "RD", patternLength, path, result, matrix);
        findPaths(row - 1 , col + 1 , "RU", patternLength, path, result, matrix);
        findPaths(row + 1, col - 1, "LD", patternLength, path, result, matrix);
        findPaths(row - 1, col - 1 , "LU", patternLength, path, result, matrix);

        findPaths(row + 2, col + 1, "RDRD", patternLength, path, result, matrix);
        findPaths(row - 2 , col + 1 , "RURD", patternLength, path, result, matrix);
        findPaths(row + 2, col - 1, "LDRD", patternLength, path, result, matrix);
        findPaths(row - 2, col - 1 , "LURD", patternLength, path, result, matrix);

        findPaths(row + 1, col + 2, "RDCD", patternLength, path, result, matrix);
        findPaths(row - 1 , col + 2 , "RUCD", patternLength, path, result, matrix);
        findPaths(row + 1, col - 2, "LDCD", patternLength, path, result, matrix);
        findPaths(row - 1, col - 2 , "LUCD", patternLength, path, result, matrix);

        unMark(row, col, matrix);
    }


    private static void unMark(int row, int col, Character[][] matrix) {
        matrix[row][col] = '-';
    }

    private static void mark(int row, int col, Character[][] matrix) {
        matrix[row][col] = 'v';
    }

    private static boolean isVisited(int row, int col, Character[][] matrix) {
        return matrix[row][col] == 'v';
    }

    private static boolean isInBounds(int row, int col, Character[][] matrix) {
        return row >= 0 && row <= matrix.length - 1 &&
                col >= 0 && col <= matrix[0].length - 1;
    }
}
