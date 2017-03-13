package cc.ccs.chap14;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class BootClassLoader {

	public static void main(String[] args) throws MalformedURLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		System.out.println(System.getProperty("sun.boot.class.path"));
		System.out.println(System.getProperty("java.ext.dirs"));
		Class<String> clz1 = String.class;
		URL url = new URL("file:/D:/java/workspace");
		ClassLoader loader = new URLClassLoader(new URL[]{url});
		Class clz2 = loader.loadClass("java.lang.String");
		System.out.println(clz1 == clz2);
		System.out.println(clz1.getClassLoader());
		System.out.println(clz2.getClassLoader());
		
	}

}
