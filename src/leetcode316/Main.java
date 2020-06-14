package leetcode316;

public class Main {
	public static void main(String[] args) {
		String s = "cbacdcbc";
		
		System.out.println("Input: " + s);
		
		RemoveDuplicatesLetters solution = new RemoveDuplicatesLetters();
		
		System.out.println("Solution: " + solution.removeDuplicateLetters(s));
	}
}
