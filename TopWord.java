import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TopWord {
    public static void main(String[] args) {
        
        String filePath = "text.txt"; 
        
        File file = new File(filePath);
        
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        Map<String, Integer> wordCountMap = new HashMap<>();
        
        while (scanner.hasNext()) {
            String word = scanner.next().toLowerCase();
            word = word.replaceAll("[^a-zA-Z]", ""); 
            
            if (!word.isEmpty()) {
                if (wordCountMap.containsKey(word)) {
                    wordCountMap.put(word, wordCountMap.get(word) + 1);
                } else {
                    wordCountMap.put(word, 1);
                }
            }
        }
        
        
        scanner.close();
        
        List<Map.Entry<String, Integer>> list = new ArrayList<>(wordCountMap.entrySet());
        
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, 
                               Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue(); 
            }
        });
        
        System.out.println("Top 10 most frequent words:");
        for (int i = 0; i < Math.min(10, list.size()); i++) {
            Map.Entry<String, Integer> entry = list.get(i);
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}