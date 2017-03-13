package lcy.ccdn.note;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class InputOutputStreamDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//标准输入
		/*System.setIn(new FileInputStream(args[0]));
		try(Scanner scanner = new Scanner(System.in)){
			while(scanner.hasNextLine()){
				System.out.print(scanner.next());
			}
		}*/
		//标准输出
		/*try(PrintStream printStream = new PrintStream(new FileOutputStream(args[0]))){
			System.setOut(printStream);
			System.out.println("hello Word");
		}*/
		//操作ByteArray
		/*byte[] data = new byte[]{1,2,3};
		byte[] temp = new byte[1];
		int length = -1;
		InputStream inputStream = new ByteArrayInputStream(data);
		while( (length = inputStream.read(temp)) != -1){
			System.out.println("---------------------");
			for(byte b :temp){
				System.out.println(b);
			}
		}
		System.out.println(temp.length);
		for(byte b :temp){
			System.out.println(b);
		}*/
		//指定byte[]，每次从来源就要以此读取byte[]长度的数据吗,用BufferedInputStream打包是否起缓冲作用。
		InputStream in = new FileInputStream(args[0]);
		BufferedInputStream buf = new BufferedInputStream(in,5);
		byte[] data = new byte[10];
		int length = -1;
		//length = in.read(data);
		length = buf.read(data);
		System.out.println(length);
		for(byte b:data){
			System.out.print(b);
		}
		
		in.close();
		buf.close();

	}

}
