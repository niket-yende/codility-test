package other.question1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class FoodRating {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine().trim());
        System.out.println("n: "+n);
        int[][] ratings = new int[n][2];
        for (int i_ratings = 0; i_ratings < n; i_ratings++) {
            String[] arr_ratings = br.readLine().split(" ");
            for (int j_ratings = 0; j_ratings < arr_ratings.length; j_ratings++) {
                ratings[i_ratings][j_ratings] = Integer.parseInt(arr_ratings[j_ratings]);
            }
        }

        int out_ = solution(n, ratings);
        System.out.println(out_);

        pr.close();
        br.close();
    }

    private static int solution(int n, int[][] ratings) {
        int result = 0;
        int highestRating = 1;
        System.out.println("Reached solution: n "+n);

        Map<Integer, ArrayList<Integer>> avgRatingMap = avgRatings(n, ratings);
        for (Map.Entry<Integer, ArrayList<Integer>> entry : avgRatingMap.entrySet()) {
            int foodId = entry.getKey();
            ArrayList<Integer> values = entry.getValue();

            int avgRating = findAverageRating(values);

            if(avgRating > highestRating) {
                highestRating = avgRating;
                if(result == 0 || foodId < result) {
                    result = foodId;
                }
            }
        }

        return result;
    }

    private static int findAverageRating(ArrayList<Integer> ratings) {
        if(ratings.size() == 1) {
            return ratings.get(0);
        }
        int sum = ratings.stream().mapToInt(Integer::intValue).sum();
        double avg = sum / ratings.size();
        return (int) Math.round(avg);
    }

    private static Map<Integer, ArrayList<Integer>> avgRatings(int n, int[][] ratings) {
        Map<Integer, ArrayList<Integer>> avgRatingMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            // Accessing a 2d array
            int foodId = ratings[i][0];
            int foodRating = ratings[i][1];
            ArrayList<Integer> existingRating = new ArrayList<>();

            if(avgRatingMap.containsKey(foodId)){
                existingRating = (ArrayList<Integer>) avgRatingMap.get(foodId);
            }
            existingRating.add(foodRating);
            avgRatingMap.put(foodId, existingRating);
        }

        return avgRatingMap;
    }
}
