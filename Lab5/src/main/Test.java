package main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long x;
		while (true) {
			System.out.println("enter the x coordinate:");
			try {
				x = sc.nextLong();
			}catch (InputMismatchException e){
				sc.nextLine();
				System.out.println("it looks like what you entered is not an integer");
				continue;
			}
			sc.nextLine();
			break;
		}
	}

}
