package _00_Binary_Conversion;

import java.util.ArrayList;

public class BinaryToDecimal {
	static ArrayList<Integer> arrlst = new ArrayList<Integer>();

	static int numb = 0;

	static String binary = "10";

	public static void main(String[] args) {
		// Binary numbers in Java can be represented with the '0b' prefix.
		// For example:
		// System.out.println(0b111);
		
		
        StringBuilder input1 = new StringBuilder(); 
        
        input1.append(binary); 
  
        input1 = input1.reverse(); 
        
        binary = input1.toString();
		

		int lengthOfBin = binary.length();

		int n = 1;
		arrlst.add(n);

		for (int i = lengthOfBin; i > 1; i--) {
			n = n * 2;
			arrlst.add(n);

		}

		String[] splitChars = binary.split("");
		for (int i = splitChars.length - 1; i > -1; i--) {

			if (splitChars[i].equals("1")) {
				numb += arrlst.get(i);
			}

		}

		System.out.println(arrlst);
		System.out.println(numb);

		// This prints 7, because 111 is 7 in binary.

		// EXAMPLE: Convert 0 1 0 1 1 0 from binary to decimal

		/*
		 * To convert binary to decimal, use the following algorithm: 1. Start from the
		 * right most digit of the binary number and assign that bit the value of 1. eg:
		 * 0 1 0 1 1 0 1 2. As you move to the left, assign the next digit a value that
		 * is double the previous digit. eg: 0 1 0 1 1 0 32 16 8 4 2 1
		 * 
		 * 3. For every 1 in the binary number, add all of the corresponding values
		 * together. eg: 0 1 0 1 1 0 32 16 8 4 2 1
		 * 
		 * 16 + 4 + 2 = 22 010110 in binary is equal to 22 in decimal!
		 * 
		 */
	}
}
