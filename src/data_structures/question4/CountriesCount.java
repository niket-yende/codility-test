package data_structures.question4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * Count the number of different countries that a map contains.
 * Reference: https://app.codility.com/programmers/trainings/7/countries_count/
 */
public class CountriesCount {
    static Map<String, Integer> plotMap = new HashMap<>();
    static int prevColor;
    static String prevPoint;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);

        System.out.println("Enter no. of rows and colums of the map:");
        String[] array = br.readLine().split(" ");
        int x = Integer.parseInt(array[0]);
        int y = Integer.parseInt(array[1]);
        Integer[][] matrix = new Integer[x][y];

        System.out.println("Enter matrix elements:");
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.println("matrix["+i+"]["+j+"]:");
                matrix[i][j] = Integer.parseInt(br.readLine().trim());
            }
        }

        int out = solution(matrix);
        System.out.println(out);

        wr.close();
        br.close();
    }

    static int solution(Integer[][] matrix) {
        int countryCode = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(!plotMap.containsKey(i+","+j)) {
                    countryCode = findAndPlotMap(matrix, i, j, countryCode);
                }
            }
        }

        return countryCode;
    }

    static int findAndPlotMap(Integer[][] matrix, int x, int y, int countryCode) {
        int currentColor = matrix[x][y];

        List<String> neighbours = findNeighbouringPoints(matrix, x, y);
        boolean isMatchingNeighbour = false;
        String key = x+","+y;
        int calculatedCode = countryCode;

        for (String neighbour: neighbours) {
            String[] coordinates = neighbour.split(",");
            int currentX = Integer.parseInt(coordinates[0]);
            int currentY = Integer.parseInt(coordinates[1]);
            int neighbouringColor = matrix[currentX][currentY];

            if(currentColor == neighbouringColor) {
                calculatedCode = getCountryCode(currentX+","+currentY, calculatedCode);
                isMatchingNeighbour = true;
                break;
            }
        }

        // This point is not processed
        if(!isMatchingNeighbour) {
            calculatedCode = getCountryCode(key, calculatedCode);
        }

        plotMap.put(key, calculatedCode);
        // Plot neighbours having same color
        plotSimilarNeighbours(matrix, x, y, neighbours, calculatedCode);

        return Math.max(countryCode, calculatedCode);
    }

    static List<String> findNeighbouringPoints(Integer[][] matrix, int x, int y) {
        List<String> neighbours = new ArrayList<>();
        List<String> availableList = Arrays.asList((x-1)+","+y, (x+1)+","+y, x+","+(y-1), x+","+(y+1));

        for (String point: availableList) {
            String[] coordinates = point.split(",");
            int currentX = Integer.parseInt(coordinates[0]);
            int currentY = Integer.parseInt(coordinates[1]);
            if(currentY >= 0 && currentY < matrix[0].length && currentX >=0 && currentX < matrix.length) {
                neighbours.add(currentX+","+currentY);
            }
        }

        return neighbours;
    }

    static void plotSimilarNeighbours(Integer[][] matrix, int x, int y, List<String> neighbours, int countryCode) {
        int currentColor = matrix[x][y];
        for (String point: neighbours) {
            String key = point;
            if(!plotMap.containsKey(key)) {
                String[] coordinates = point.split(",");
                int currentX = Integer.parseInt(coordinates[0]);
                int currentY = Integer.parseInt(coordinates[1]);
                int color = matrix[currentX][currentY];
                if(currentColor == color){
                    plotMap.put(key, countryCode);
                }
            }
        }
    }

    static int getCountryCode(String key, int countryCode){
        if(plotMap.containsKey(key)) {
            return plotMap.get(key);
        } else {
            countryCode = countryCode + 1;
            return countryCode;
        }
    }
}
