package lcy.ccdn.note;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.lang.System.out;

public class PathDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Path path = Paths.get(System.getProperty("user.home"));
		Path path2 = Paths.get("workspace");
		Path path3 = path.resolve(path2);
		for(Path p : path3){
			out.print(p.toString());
		}
		out.println();
		out.printf("path3.getNameCount():%d\n",path3.getNameCount());
		out.printf("path3.getName(0):%s\n",path3.getName(0));
		out.printf("path3.getFileSystem():%s\n",path3.getFileSystem());
		out.printf("path3.subpath(0, 2):%s\n",path3.subpath(0, 2));
		
		out.printf("path3.getRoot():%s\n",path3.getRoot());
		out.printf("path3.getParent():%s\n",path3.getParent());
		out.printf("path3.getFileName():%s\n",path3.getFileName());
		
		Path path4 = Paths.get("src");
		out.println(path4);
		out.println(path4.toAbsolutePath());
		try {
			out.println(path4.toRealPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Path path5 = path2.relativize(path4);
		out.println(path2.toAbsolutePath());
		out.println(path5);
		out.println(path4.equals(Paths.get("D:\\java\\workspace\\tets\\src")));
		out.println(path4.equals(Paths.get("src")));
		out.println(path4.equals(Paths.get("src")));
		try {
			out.println(Files.isSameFile(path4, Paths.get("D:\\java\\workspace\\tets\\src")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			out.println(Files.isSameFile(path4, Paths.get("src")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.println(path4.startsWith("D:\\java\\workspace"));
		out.println(path4.toAbsolutePath().startsWith("D:\\java\\workspace"));
		
		//Files
		Path path6 = Paths.get("src1");
		boolean b = Files.exists(path6,new LinkOption[]{LinkOption.NOFOLLOW_LINKS});
		out.printf("b:%b \n",b);
		out.printf("%-3d", 1);
		
		
		
		

	}

}
