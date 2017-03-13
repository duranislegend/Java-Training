package lcy.ccdn.note;

import java.util.Scanner;
public class AbstractImpl extends AbstractDemo {
	Scanner scanner = new Scanner(System.in);
	@Override
	public int nextInt() {
		// TODO Auto-generated method stub
		
		return scanner.nextInt();
	}

	@Override
	public void print(String s) {
		// TODO Auto-generated method stub
		System.out.print(s);
		
	}

	@Override
	public void println(String s) {
		// TODO Auto-generated method stub
		System.out.println(s);
	}

}
