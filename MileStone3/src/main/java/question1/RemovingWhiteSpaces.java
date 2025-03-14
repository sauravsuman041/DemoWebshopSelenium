package question1;

import java.lang.*;

public class RemovingWhiteSpaces {
	
	public static String removeWhiteSpaces(String str) {
		StringBuilder newStr = new StringBuilder("");
		
		for(char c : str.toCharArray()) {
			if(!(c==' ')) {
				newStr.append(c);
			}
		}
		
		return newStr.toString();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "Hello    how are   you";
		String str2 = "J  ava   Prog   ramming";
		
		System.out.println(RemovingWhiteSpaces.removeWhiteSpaces(str1));
		System.out.println(RemovingWhiteSpaces.removeWhiteSpaces(str2));

	}

}
