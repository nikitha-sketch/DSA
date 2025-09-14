import java.util.*;

class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exactMatchSet = new HashSet<>(Arrays.asList(wordlist));
        Map<String, String> caseInsensitiveMap = new HashMap<>();
        Map<String, String> vowelInsensitiveMap = new HashMap<>();

        // Build maps (store first occurrence)
        for (String word : wordlist) {
            String lower = word.toLowerCase();
            caseInsensitiveMap.putIfAbsent(lower, word);
            vowelInsensitiveMap.putIfAbsent(normalizeVowels(lower), word);
        }

        String[] results = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            // 1) exact (case-sensitive)
            if (exactMatchSet.contains(query)) {
                results[i] = query;
                continue;
            }

            String lowerQuery = query.toLowerCase();
            // 2) case-insensitive
            if (caseInsensitiveMap.containsKey(lowerQuery)) {
                results[i] = caseInsensitiveMap.get(lowerQuery);
                continue;
            }

            // 3) vowel-error
            String vowelNormalized = normalizeVowels(lowerQuery);
            if (vowelInsensitiveMap.containsKey(vowelNormalized)) {
                results[i] = vowelInsensitiveMap.get(vowelNormalized);
                continue;
            }

            // 4) no match
            results[i] = "";
        }
        return results;
    }

    // Helper must be a class method (not nested). Input is already lowercased where used.
    private String normalizeVowels(String word) {
        return word.replaceAll("[aeiou]", "*");
    }
}
