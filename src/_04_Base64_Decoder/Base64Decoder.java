package _04_Base64_Decoder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class Base64Decoder {
	/*
	 * Base 64 is a way of encoding binary data using text.
	 * Each number 0-63 is mapped to a character. 
	 * NOTE: THIS IS NOT THE SAME AS ASCII OR UNICODE ENCODING!
	 * Since the numbers 0 through 63 can be represented using 6 bits, 
	 * every four (4) characters will represent twenty four (24) bits of data.
	 * 4 * 6 = 24
	 * 
	 * For this exercise, we won't worry about what happens if the total bits being converted
	 * do not divide evenly by 24.
	 * 
	 * If one char is 8 bits, is this an efficient way of storing binary data?
	 * (hint: no)
	 * 
	 * It is, however, useful for things such as storing media data inside an HTML file (for web development),
	 * so that way a web site does not have to look for an image, sound, library, or whatever in a separate location.
	 * 
	 * View this link for a full description of Base64 encoding
	 * https://en.wikipedia.org/wiki/Base64
	 */
	
	
	final static char[] base64Chars = {
		'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 
		'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
		'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 
		'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
		'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'
	};
	
	//1. Complete this method so that it returns the the element in
	//   the base64Chars array that corresponds to the passed in char.
	public static byte convertBase64Char(char c){
		for (byte i = 0; i < base64Chars.length; i++) {
			if(c == base64Chars[i]) {
				return i;
			}
		}
		return -1;
	}
	
	//2. Complete this method so that it will take in a string that is 4 
	//   characters long and return an array of 3 bytes (24 bits). The byte 
	//   array should be the binary value of the encoded characters.
	private static String [] bintobyte(String bin) {
		String[] b = new String[bin.length()/8];
		for (int i = 0; i < bin.length(); i++) {
			b[i / 8] = b[i / 8] + bin.charAt(i);
			b[i / 8] = b[i / 8].replace("null", "");

		}
		return b;
	}
	
	public static byte[] convert4CharsTo24Bits(String s){
	    byte[] result = new byte[4];
	    int charVal;
	    double sum = 0;
	    char[] messChar = s.toCharArray();
	    //System.out.println(s);
	    for (int i = 0; i < messChar.length; i++) {
	    	//System.out.println("messChar: " + messChar[i]);
	    	for (int j = 0; j < 64; j++) {
		    	if(messChar[i] == base64Chars[j]) {
		    		charVal = j;//(convertBase64Char(messChar[j])) ;
		    		//System.out.println("charval: " + charVal);
		    		//System.out.println("messChar.length - 1 - i: " + (messChar.length - 1 - i));
		    		
		    		sum = sum + j * Math.pow(64,  messChar.length - 1 - i); 
		    	}
	    	}
	        //result = (charVal * Math.pow(64, messChar.length - 1-i)) + ""; 
	        //System.out.println(result);
	        //System.out.println(charVal);    
	    
	        
	        
	    }
	    //String[] t = bintobyte(Integer.toBinaryString((int) sum));
	    //System.out.println(sum);
	    System.out.println("sum: " + sum);
	    int i = 0;
	    //sum = 65536;
	    while (sum >= Math.pow(256, i)) {
			i++;
		}
	    
	    i = i - 1;	    
	    System.out.println("I: " +i);
    	int[] pos = new int[i + 1];
    	int fitNumb = 0;
    	int leftover = (int) sum;
    	String str = "";
    	while (i > -1) {
    		pos[i]  = (int) (leftover / Math.pow(256, i));
    		System.out.println("PosI " + pos[i]);
    		//str = str + pos[i];
    		result[i] = (byte) pos[i];
    		leftover = (int) (leftover - pos[i] * Math.pow(256, i));
    		i--;
		}
    	//System.out.println(i + " " + fitNumb);
    	
    	
    	
	    //for (int i = 0; i < t.length; i++) {
		    //result[i] = ((Integer) Integer.parseInt(t[i], 2)).byteValue();
		    //System.out.println("sum: " + Integer.parseInt(t[i], 2) + " " + result[i]);
		    

		    
		//}


	    //System.out.println("charVal: " + charVal);
	    //return (byte[]) Integer.toBinaryString(Integer.parseInt(result.toString()));
	    return result;
	}
	
	
	//3. Complete this method so that it takes in a string of any length
	//   and returns the full byte array of the decoded base64 characters.
	public static byte[] base64StringToByteArray(String file) {
		return null;
	}
}
