package other.test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Java program to find top n frequent words
 */
public class FindTopNFrequentWords {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "orange", "banana", "apple", "orange", "apple");
        int n = 2;

        List<String> output = solution(words, n);
        System.out.println(output);
    }

    public static List<String> solution(List<String> words, int n){
        words = words.stream().map(String:: toLowerCase).collect(Collectors.toList());
        Set<String> wordsSet = new HashSet<>(words);
        Map<String, Integer> wordFrequencyMap = new HashMap<>();

        for (String word: wordsSet) {
            int frequency = Collections.frequency(words, word);
            wordFrequencyMap.put(word, frequency);
        }

        // Sort the map by values (frequencies) in descending order
        List<Map.Entry<String, Integer>> sortedEntries = wordFrequencyMap.entrySet().stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .collect(Collectors.toList());

        // Take the top N entries from the sorted list
        List<String> topNWords = sortedEntries.stream()
                .limit(n)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        return topNWords;
    }
}
