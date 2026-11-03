'''
Was it a car or a cat I saw?

Considerations:
Lower Case / Uppser Case
Non AlphaNumeric Characters
Empty string
Single Character

'''
class Solution:
    def isPalindrome(self, s: str) -> bool:
        left = 0
        right = len(s) - 1

        while left < right: # It's okay for left = right, it accounts for odd length
            # Skip any non alpha numeric characters
            if not s[left].isalnum():
                left += 1
                continue

            if not s[right].isalnum():
                right -= 1
                continue
            
            if s[left].lower() != s[right].lower():
                return False

            left += 1
            right -= 1
        
        return True