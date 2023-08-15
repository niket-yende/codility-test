package contest.c2016.question2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * Find out how many dwarfs can fit on a raft such that it's balanced when crossing a river.
 * Reference: https://app.codility.com/programmers/trainings/2/dwarfs_rafting/
 */
public class DwarfsRafting {
    static Map<String, Map<String, Integer>> sectionMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);

        System.out.println("Enter n:");
        int n = Integer.parseInt(br.readLine().trim());

        System.out.println("Enter S representing barrel positions:");
        String s = br.readLine().trim();

        System.out.println("Enter T representing occupied seats:");
        String t = br.readLine().trim();

        int out = solution(n, s, t);
        System.out.println(out);

        wr.close();
        br.close();
    }

    static int solution(int n, String s, String t) {
        int addedDwarfs = 0;

        List<String> barrelPositions = Arrays.asList(s.split(" "));
        List<String> dwarfPositions = Arrays.asList(t.split(" "));

        Integer minDwarfs = plotDwarfs(n, barrelPositions, dwarfPositions);

        for (Map.Entry<String, Map<String, Integer>> mapEntry : sectionMap.entrySet()) {
            String section = mapEntry.getKey();
            System.out.println("Processing section: "+section);
            Map<String, Integer> innerMap = mapEntry.getValue();
            Integer dwarfs = innerMap.get("dwarfs");
            Integer existing = innerMap.get("existing");
            if(dwarfs >= minDwarfs) {
                addedDwarfs += (minDwarfs - existing);
            } else {
                addedDwarfs += minDwarfs;
            }
        }

        return addedDwarfs;
    }

    // Plot dwarfs
    static Integer plotDwarfs(int n, List<String> barrelPositions, List<String> dwarfPositions) {
        int minDwarfs;
        int medianPoint = n / 2;
        int mid = (64+medianPoint);
        int mid1 = (mid+1);
        int end = (mid+medianPoint);
        int bottomMedian = (medianPoint+1);
        List<String> leftFront = fillSection(65+","+1, mid +","+medianPoint);
        List<String> rightFront = fillSection(mid1+","+1, end +","+medianPoint);
        List<String> leftBack = fillSection(65+","+bottomMedian, mid +","+n);
        List<String> rightBack = fillSection(mid1+","+bottomMedian, end +","+n);
        Map<String, Integer> minDwarfsMap = new HashMap<>();

        // Represents x-axis denoting 'A-Z'
        for (int i = 65; i < 65+n; i++) {
            for (int j = 1; j <= n ; j++) {
                char c = (char) i;
                String position = j + String.valueOf(c);

                String section = "";
                if(leftFront.contains(position)) {
                    section = "leftFront";
                } else if (rightFront.contains(position)) {
                    section = "rightFront";
                } else if (leftBack.contains(position)) {
                    section = "leftBack";
                } else if (rightBack.contains(position)) {
                    section = "rightBack";
                }

                Map<String, Integer> innerMap = sectionMap.get(section) == null ? new HashMap<>() : sectionMap.get(section);
                int dwarfsCount = innerMap.containsKey("dwarfs") ? innerMap.get("dwarfs") + 1 : 1;

                boolean isDwarfPosition = false;
                if(dwarfPositions.contains(position)) {
                    int existing = innerMap.containsKey("existing") ? innerMap.get("existing") + 1 : 1;
                    innerMap.put("existing", existing);
                    isDwarfPosition = true;
                } else if(!barrelPositions.contains(position)) {
                    innerMap.put("existing", 0);
                    isDwarfPosition = true;
                }

                if(isDwarfPosition) {
                    innerMap.put("dwarfs", dwarfsCount);
                    minDwarfsMap.put(section, dwarfsCount);
                    sectionMap.put(section, innerMap);
                }
            }
        }
        Collection<Integer> values = minDwarfsMap.values();
        minDwarfs = values.stream().mapToInt(Integer::intValue).min().orElse(Integer.MAX_VALUE);
        return minDwarfs;
    }

    static List<String> fillSection(String startPoint, String endPoint) {
        List<String> list = new ArrayList<>();

        String[] startCoordinates = startPoint.split(",");
        int startX1 = Integer.parseInt(startCoordinates[0]);
        int startY1 = Integer.parseInt(startCoordinates[1]);

        String[] endCoordinates = endPoint.split(",");
        int startX2 = Integer.parseInt(endCoordinates[0]);
        int startY2 = Integer.parseInt(endCoordinates[1]);

        for (int i = startX1; i <= startX2; i++) {
            for (int j = startY1; j <= startY2; j++) {
                char c = (char) i;
                String position = j + String.valueOf(c);
                list.add(position);
            }
        }
        return list;
    }


}
