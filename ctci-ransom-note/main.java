import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import java.lang.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'checkMagazine' function below.
     *
     * The function accepts following parameters:
     *  1. STRING_ARRAY magazine
     *  2. STRING_ARRAY note
     */

    public static void checkMagazine(List<String> magazine, List<String> note) {
        Integer wordAmount, wordChecker;
        var dictionary = new HashMap<String, Integer>();
        for(String word : magazine){
            wordAmount = dictionary.get(word);
            if(wordAmount == null) {
                dictionary.put(word, 1);    
            } else {
                dictionary.put(word, Integer.valueOf(wordAmount+1));
            }
        }
        
        var noteStatus = "Yes";
        for(String word : note) {
            wordChecker = dictionary.get(word);
            if(wordChecker == null || wordChecker <= 0) {
                noteStatus = "No";
                break;
            } else {
                dictionary.put(word, Integer.valueOf(wordChecker-1));
            }
        }
        
        System.out.println(noteStatus);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        List<String> magazine = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .collect(toList());

        List<String> note = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .collect(toList());

        Result.checkMagazine(magazine, note);

        bufferedReader.close();
    }
}
