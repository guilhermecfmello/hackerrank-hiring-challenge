import java.util.*;

public class Main {
    public static void main(String[] args) {
        String stringA = "kkkk";
        var result = Result.sherlockAndAnagrams(stringA);

        System.out.println("Possibles anagrams amount: " + result);
    }
}

class Result {

    public static int sherlockAndAnagrams(String s) {
        var hash = buildHashmap(s);
        int window = 1, anagramAmount = 0;
        String base, potentialAnagram;
        HashMap<String, HashMap<String, Integer>> cache = new HashMap<String, HashMap<String, Integer>>();
        HashMap<String, Integer> cacheItem;
        for(int i=0; i < s.length(); i++) {
            for(window = 1; window < s.length() - i; window++) {
                base = s.substring(i, i + window);
                cacheItem = cache.computeIfAbsent(base, k -> new HashMap<String, Integer>());
                for(int j = i + 1; j <= s.length() - window; j++) {
                    potentialAnagram = s.substring(j, j + window);
                    var anagramCache = cacheItem.get(potentialAnagram);
                    if(anagramCache == null) {
                        if(isAnagram(base, potentialAnagram)) {
                            cacheItem.put(potentialAnagram, 1);
                            anagramAmount++;
                        } else {
                            cacheItem.put(potentialAnagram, 0);
                        }
                    } else {
                        if(anagramCache > 0)
                            anagramAmount++;
                    }
                }
            }
        }
        return anagramAmount;
    }

    public static boolean isAnagram(String base, String compare) {
        var hash = buildHashmap(base);
        return compareStringWithHashmap(hash, compare);
    }

    public static HashMap<String, Integer> buildHashmap(String s) {
        HashMap<String, Integer> hash = new HashMap<String, Integer>();
        Integer charAmount;
        for(int i=0; i < s.length(); i++) {
            charAmount = hash.get(String.valueOf(s.charAt(i)));
            if(charAmount == null) {
                hash.put(String.valueOf(s.charAt(i)), 1);
            } else {
                hash.put(String.valueOf(s.charAt(i)), charAmount + 1);
            }

        }
        return hash;
    }

    public static boolean compareStringWithHashmap(HashMap<String, Integer> hash, String s) {
        Integer charAmount;
        for(int i=0; i < s.length(); i++) {
            charAmount = hash.get(String.valueOf(s.charAt(i)));
            if(charAmount == null || charAmount <= 0) {
                return false;
            } else {
                hash.put(String.valueOf(s.charAt(i)), charAmount - 1);
            }
        }
        return true;
    }

    public static void printHashmap(HashMap<String, Integer> hash) {
        System.out.println("@@@@@@@@@@@@ Printing Hashmap @@@@@@@@@@@@");
        for (Map.Entry<String, Integer> item : hash.entrySet()) {
            String key = item.getKey();
            Object value = item.getValue();
            System.out.println("Hash[" + key + "]: " + value);
        }
    }
}