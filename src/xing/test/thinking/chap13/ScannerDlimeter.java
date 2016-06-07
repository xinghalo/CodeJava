package xing.test.thinking.chap13;

import java.util.Scanner;

public class ScannerDlimeter {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner("12,321,321,3,321");
		scanner.useDelimiter("\\s*,\\s*");
		while(scanner.hasNextInt())
			System.out.println(scanner.nextInt());
	}
}
