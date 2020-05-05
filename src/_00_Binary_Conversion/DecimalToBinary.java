package _00_Binary_Conversion;

import java.util.ArrayList;

public class DecimalToBinary {
	// static String bin = "";
	static ArrayList<String> bin = new ArrayList<String>();

	static int numb = 20;
	static ArrayList<Integer> arrlst = new ArrayList<Integer>();
	static ArrayList<Integer> usedItems = new ArrayList<Integer>();

	static int getOneBefore(int i) {
		for (int j = 0; j < arrlst.size(); j++) {
			if (arrlst.get(j) == i) {
				return arrlst.get(j - 1);
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int n = 1;
		arrlst.add(n);

		for (int i = 1; n < numb; i++) {
			if (n * 2 > numb) {
				break;
			}
			n = n * 2;

			arrlst.add(n);

		}
		usedItems.add(n);
		int adder = 0;
		adder = n + (n / 2);
		// while(n != numb) {
		for (int i = arrlst.size() - 1; i > -1; i--) {
			if (n + arrlst.get(i) <= numb) {
				usedItems.add(arrlst.get(i));
				n += arrlst.get(i);
			}
		}

		// }
//		while(n != numb) {
//			if(n + (n/2) <= numb) {
//			//	usedItems.add((n/2));
//
//				n = n + (n/2);
//			}
//			adder = adder/2;
//			System.err.println(adder);
//			if(adder + n <= numb) {
//				usedItems.add(adder);
//				n = n + adder;
//			}
//			
//		}

		System.out.println(usedItems);
		System.out.println(arrlst);
		
		int counter = 0;
		for (int i = arrlst.size() - 1; i > -1; i--) {
			
			int n1 = arrlst.get(i);
			int n2 = -1;
			try {
				n2 = usedItems.get(counter);
				
			}catch(Exception e) {

			}
			boolean isEqual = n1 == n2;
			
			//System.out.println(arrlst.get(i) + " " + usedItems.get(counter) + " " + isEqual);
			//System.out.println(arrlst.size());

			//if(arrlst.get(i) == usedItems.get(counter)) {
			if(isEqual) {
				bin.add("1");
				//System.out.println("1");
				counter ++;
			}else {
				//System.out.println("0");
				bin.add("0");
			}
			if(counter > usedItems.size() - 1) {
				//bin.add("0");

				//break;
			}
		}
		
		
		
		
		System.out.println(bin);

	    System.out.println(Integer.toBinaryString(numb));

		// Converting a decimal number to binary is a little trickier.

		// EXAMPLE: Convert 43 to binary

		/*
		 * Step 1: Start with one and add a digit the left that is double the value of
		 * the previous number. Stop when you've passed the target number eg. 43 64 32
		 * 16 8 4 2 1
		 * 
		 * Step 2: Remove the left most value (the one that is higher than the target).
		 * eg. 43 32 16 8 4 2 1
		 * 
		 * Step 3: Find the combination of values that add up to the target number. eg.
		 * 43 32 16 8 4 2 1 43 = 32 + 8 + 2 + 1
		 * 
		 * Step 4: Every matching number in the list is a 1, and non-matching is a 0.
		 * eg. 43 32 16 8 4 2 1 43 = 32 + 8 + 2 + 1
		 * 
		 * 1 0 1 0 1 1 32 16 8 4 2 1
		 * 
		 * 43 in decimal is 101011 in binary!
		 */
	}
}
