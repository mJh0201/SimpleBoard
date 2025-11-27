package test;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		System.out.println("입력 : ");
		String input = "";
		
		while (!input.equals("종료")) {
			input = sc.nextLine();
			sb.append(input);
			sb.append("\n");
		}
		
		sb.delete(sb.length()-3, sb.length());
		System.out.println(sb.toString());
	}
}
