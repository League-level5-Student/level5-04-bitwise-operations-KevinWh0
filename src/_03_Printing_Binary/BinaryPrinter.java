package _03_Printing_Binary;


import java.util.ArrayList;

public class BinaryPrinter {
	// Complete the methods below so they print the passed in parameter in binary.
	// Use bit shifting and bit masking to print the binary numbers.
	// TODO Do not use the Integer.toBinaryString method!
	// Don't be afraid to use the methods that are already complete to finish the
	// others.
	// Create a main method to test your methods.
	static ArrayList<String> bin = new ArrayList<String>();

	static int numb = 20;
	static ArrayList<Integer> arrlst = new ArrayList<Integer>();
	static ArrayList<Integer> usedItems = new ArrayList<Integer>();
	
	public static String strToBinary(String input) {
		
		bin.clear();
		arrlst.clear();
		usedItems.clear();
		
		numb = Integer.parseInt(input);

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

		}
		String str = "";
		for(int i = 0; i < bin.size(); i++) {
			str = str + bin.get(i);
			
		}
		
		
		return str;
	}

	public void printByteBinary(byte b) {
		System.out.println(strToBinary(b + ""));
	}

	public void printShortBinary(short s) {
		System.out.println(strToBinary(s + ""));

	}

	public void printIntBinary(int i) {
		System.out.println(strToBinary(i + ""));

	}

	public void printLongBinary(long l) {
		System.out.println(strToBinary(l + ""));
	}

	public static void main(String[] args) {
		BinaryPrinter b = new BinaryPrinter();

		//System.out.println(strToBinary("10"));
		b.printByteBinary((byte) 1);
		b.printShortBinary((short) 10);
		b.printIntBinary(4324);
		b.printLongBinary(53480834);

	}
}
