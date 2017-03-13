package cc.ccs.chap12;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Path path = Paths.get(System.getProperty("user.home") ,"Documents","Downloads");
		for(Path p : path){
			System.out.println(p.toAbsolutePath());
		}

	}

}
