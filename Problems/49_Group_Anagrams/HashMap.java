/*
Approach 1: Sorted anagram as key
- Grouping the strings by the sorted anagram (key)
- Use hashMap to save the anagram group by the key

Time complexity: O(n*logk)
- log k for sorting 

Space Complexity:   O(n)

Note: 
HashMap has better space complexity than Map in Java because it uses a different data structure. 
HashMap uses a hash table, which is a data structure that stores data in buckets based on the hash 
code of the data. This means that HashMap can store more data in the same amount of space as Map.
*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String word: strs) {
            // sort each word to the unique anagram form, which is the map key
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            // new unique anagram, create new entry to the map
            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }

            // add current string to the entry that belongs to the unique anagram
            map.get(sorted).add(word);
        }

        return new ArrayList<>(map.values());
    }
}

/*
Approach 2: Frequency of character in anagram as key
- Grouping the strings by the sorted anagram (key)
- Use hashMap to save the anagram group by the key

Time complexity: O(n * ?)
- encoding might be faster than sorting

Space Complexity: O(n)
*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 编码到分组的映射
        HashMap<String, List<String>> codeToGroup = new HashMap<>();
        for (String s : strs) {
            // 对字符串进行编码
            String code = encode(s);
            // 把编码相同的字符串放在一起
            codeToGroup.putIfAbsent(code, new LinkedList<>());
            codeToGroup.get(code).add(s);
        }

        // 获取结果
        List<List<String>> res = new LinkedList<>();
        for (List<String> group : codeToGroup.values()) {
            res.add(group);
        }

        return res;
    }

    // 利用每个字符的出现次数进行编码
    String encode(String s) {
        char[] count = new char[26];
        for (char c : s.toCharArray()) {
            int delta = c - 'a';
            count[delta]++;
        }
        return new String(count);
    }
}

