package leetcode316;

import java.util.Stack;

public class RemoveDuplicatesLetters {
	public String removeDuplicateLetters(String s) {
		// number of current count of character
        int[] counts = new int[26];
        
        // keep track if there is duplicates
        boolean[] visited = new boolean[26];
        
        char[] letters = s.toCharArray(); 
            
        for(char letter : letters){
            counts[letter - 'a']++;
        }
        
        // use stack to store solution
        Stack<Character> stack = new Stack<>();
        
        
        for(char letter : letters){
            int index = letter - 'a';
            
            counts[index]--;
            
            // if same character is seen
            if(visited[index]){
                continue;
            }
            
            // conditions
            while(!stack.isEmpty() && letter < stack.peek() && counts[stack.peek() - 'a'] != 0){
                int deleteIndex = stack.pop() - 'a';
                visited[deleteIndex] = false;    
            }
            
            stack.push(letter);
            
            visited[index] = true;
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!stack.isEmpty()){
        	// since it is a stack
            sb.insert(0, stack.pop());
        }
        
        
        return sb.toString();
    }
}
