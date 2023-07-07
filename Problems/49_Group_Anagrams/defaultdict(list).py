# Just appreciating the simplicity of Python

# Note: 
# sorted() will always return a list
# .join() method in Python is used to join a sequence of strings together with a delimiter. The syntax is: str.join(sequence)
# A defaultdict is a subclass of dict that provides a default value for keys that do not exist. A hashmap is a data structure that maps keys to values. 
# The main difference between the two is that a defaultdict will always return a list for keys that do not exist, while a hashmap will return None.

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        answer = defaultdict(list)
        for word in strs:
            answer["".join(sorted(word))].append(word)
        return list(answer.values())
