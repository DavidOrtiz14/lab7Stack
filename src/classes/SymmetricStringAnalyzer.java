package classes;

import java.util.Stack;

import javax.xml.stream.events.Characters;

import com.sun.org.apache.xml.internal.utils.CharKey;



public class SymmetricStringAnalyzer {
	private String s;  



	public SymmetricStringAnalyzer(String s) {
		this.s = s; 
	}
	
	/**
	 * Determines if the string s is symmetric
	 * @return true if it is; false, otherwise. 
	 */
	public boolean isValidContent() { 
	     SLLStack<Character> stack = new SLLStack<Character>();
		for (int i=0; i < s.length(); i++) { 
	        char c =s.charAt(i); 
	        if (Character.isLetter(c)){
	            if (Character.isUpperCase(c)){
	                 stack.push(c); 
	            }
	            
	            else if (stack.isEmpty()){
	                  return false; 
	            }
	                else {
	                  char t = stack.top(); 
	                  if (t == Character.toUpperCase(c)){
	                      stack.pop();  
	                  }
	                  else{ 
	                     return false; 
	                  }    
	                 }
	        }
	             else {
	                 return false; 
	             }
	     } 
	     return true; 
	 }

	
	public String toString() { 
		return s; 
	}

	public String parenthesizedExpression() 
	throws StringIsNotSymmetricException 
	{
		String nStr=" ";
		if(isValidContent()){
			for(int y=0;y<s.length();y++){
				if(Character.isUpperCase(s.charAt(y))){
					nStr=nStr+" "+"<"+s.charAt(y)+" ";
				}
				else{
					nStr=" "+nStr+s.charAt(y)+">"+" ";
				}
			}
		}
		
		return nStr;  // need to change if necessary....
	}

}
