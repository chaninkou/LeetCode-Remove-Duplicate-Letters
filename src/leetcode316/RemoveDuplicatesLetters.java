package leetcode316;

import java.util.Stack;

public class RemoveDuplicatesLetters {
	public String removeDuplicateLetters(String s) {
		// number of current count of character
        int[] counts = new int[26];
        
        // keep track of duplicates
        boolean[] visited = new boolean[26];
        
        char[] letters = s.toCharArray(); 
            
        for(char letter : letters){
            counts[letter - 'a']++;
        }
        
        // Use stack of character to store final solution
        Stack<Character> stack = new Stack<>();
        
        
        for(char letter : letters){
            int index = letter - 'a';
            
            counts[index]--;
            
            // If same character visited, skip
            if(visited[index]){
                continue;
            }
            
            // While top of stack is larger than current letter
            // and not the last letter in letters
            while(!stack.isEmpty() && letter < stack.peek() && counts[stack.peek() - 'a'] != 0){
                int deleteIndex = stack.pop() - 'a';
                visited[deleteIndex] = false;    
            }
            
            stack.push(letter);
            
            visited[index] = true;
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!stack.isEmpty()){
        	// Insert from first index
            sb.insert(0, stack.pop());
        }
        
        
        return sb.toString();
    }
}
