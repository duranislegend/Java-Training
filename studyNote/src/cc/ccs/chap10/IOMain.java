package cc.ccs.chap10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class IOMain {
	
	public static void main(String args[]) throws FileNotFoundException, IOException {
		/*
		 * ����Դ��Ŀ�Ķ�Ϊ�ĵ�*/
		//IO.dump(new FileInputStream(args[0]),new FileOutputStream(args[1]));
		URL url = new URL(args[0]);
		InputStream src = url.openStream();
		OutputStream dest = new FileOutputStream(args[1]);
		IO.dump(src, dest);
	}

}
