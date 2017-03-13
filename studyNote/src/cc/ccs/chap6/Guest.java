package cc.ccs.chap6;

import java.util.Scanner;

public class Guest {
	public static void main(String[] args){
		ArrayList list = new ArrayList();
		Scanner scanner = new Scanner(System.in);
		System.out.println("input guest name:");
		String name ;
		while(true){
			name = scanner.nextLine();
			if(name.equals("quit")){
				break;
			}
			list.add(name);
		}
		System.out.println("guest name:");
		for(int i = 0; i < list.size(); i++){
			System.out.println(list.get(i));
		}
	}

}
