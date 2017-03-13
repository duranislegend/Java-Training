package lcy.ccdn.note;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

class ConsoleFileVisitor extends SimpleFileVisitor<Path> {
	@Override
	public FileVisitResult preVisitDirectory(Path dir,
			BasicFileAttributes basicattr) throws IOException {
		printSpace(dir);
		System.out.printf("[%s]%n", dir.getFileName());
		return java.nio.file.FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFile(Path dir, BasicFileAttributes basicattr) {
		printSpace(dir);
		System.out.printf("%s%n", dir.getFileName());
		;
		return java.nio.file.FileVisitResult.CONTINUE;

	}

	@Override
	public FileVisitResult visitFileFailed(Path dir, IOException e) {
		System.err.println(e);
		return java.nio.file.FileVisitResult.CONTINUE;
	}

	void printSpace(Path p) {
		// System.out.printf("%"+"%d"+"d",p.getNameCount());
		System.out.printf("%" + p.getNameCount() + "s", "");
	}

}
class DelFileVisitor extends SimpleFileVisitor<Path>{
	@Override
	public FileVisitResult preVisitDirectory(Path p,BasicFileAttributes attrs){
		return java.nio.file.FileVisitResult.CONTINUE;
	}
	@Override
	public FileVisitResult visitFile(Path p,BasicFileAttributes attrs) throws IOException{
		Files.deleteIfExists(p);
		return java.nio.file.FileVisitResult.CONTINUE;
	}
	@Override
	public FileVisitResult visitFileFailed(Path p,IOException e){
		System.err.println(e);
		return java.nio.file.FileVisitResult.CONTINUE;
	}
	@Override
	public FileVisitResult postVisitDirectory(Path p,IOException e) throws IOException{
		Files.deleteIfExists(p);
		return java.nio.file.FileVisitResult.CONTINUE;
	}
}

public class FilesDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		/*
		 * PosixFileAttributes posixarrt =
		 * Files.readAttributes(path,PosixFileAttributes.class);
		 * Set<PosixFilePermission> perms =
		 * //PosixFilePermissions.fromString("rwxr-x---");
		 * posixarrt.permissions(); FileAttribute<Set<PosixFilePermission>>
		 * attrs = PosixFilePermissions.asFileAttribute(perms);
		 */
		// BasicFileAttributes basicattr =
		// Files.readAttributes(path,BasicFileAttributes.class);
		// Files.createFile(path);

		Path path = Paths.get("d:/java/workspace/file/test");
		System.out.println(path.toString());
		// 1.用Files.createDirectories创建目录
		//Files.createDirectories(path);
		Path file = Paths.get("test.xml");
		Path path3 = path.resolve(file);
		System.out.println(path3.toString());
		// 2.用Files.createFile创建文件
		if (Files.notExists(path3)) {
			//Files.createFile(path3);
		}

		//Path path4 = Paths.get("D:/java/workspace/tets/src");
		// 3.用Files.newDirectoryStream用列出单层目录
		/*
		 * try (DirectoryStream<Path> directoryStream =
		 * Files.newDirectoryStream(path4)) { List<String> lists = new
		 * ArrayList<>(); for (Path entry : directoryStream) { //
		 * 4.用Files.isDirectory()判断文件是否是文件夹 if (Files.isDirectory(entry)) {
		 * System.out.printf("[%s]%n", entry.getFileName()); } else {
		 * lists.add(entry.getFileName().toString());
		 * 
		 * } } Iterator iterator = lists.iterator(); while(iterator.hasNext())
		 * System.out.printf("%s%n", iterator.next()); }
		 */
		// 3.1 DirectoryStream列出目录时，用Golb过滤

		/*try (DirectoryStream<Path> ds = Files.newDirectoryStream(path4,
				"*me.java")) {
			for (Path entry : ds) {
				System.out.println(entry.toString());
			}
		}*/

		// 3.2DirectoryStream列出目录时，用Filter过滤
		/*DirectoryStream.Filter<Path> dirs = new DirectoryStream.Filter<Path>() {
			@Override
			public boolean accept(Path p) {
				// 如果文档是文件夹为真
				return Files.isDirectory(p);
			}
		};
		try (DirectoryStream<Path> ds = Files.newDirectoryStream(path4, dirs)) {
			for (Path entry : ds) {
				System.out.println(entry.toString());
			}
		}*/
		//3.3用PathMatcher.matches过滤目录
		/*String syntax = "glob";
		String pattern = "*er.java";
		PathMatcher pathMat = FileSystems.getDefault().getPathMatcher(syntax +":" + pattern);
		try(DirectoryStream<Path> ds = Files.newDirectoryStream(path4)){
			for(Path p : ds){
				Path pa = Paths.get(p.getFileName().toString());
				if(pathMat.matches(pa)){
					System.out.println(p.toString());
				}
			}
		}*/
		// 4.用FileVisitor接口，Files.walkFileTree遍历全部文件。
		// Files.walkFileTree(path4, new ConsoleFileVisitor());
		//5删除文件
		/*Path path5 = Paths.get("d:/java/workspace/file");
		Files.walkFileTree(path5, new DelFileVisitor());*/
		//Files.deleteIfExists(path5);
		//6.复制文档
		//Path path6 = Paths.get("d:/java/workspace/file/2.xml");
		//Files.copy(path3, path6, StandardCopyOption.REPLACE_EXISTING);
		//7.移动文档
		//Files.move(path3, path6, StandardCopyOption.REPLACE_EXISTING);
		
		//8.读写文件
		Path path7 = Paths.get("D:/java/workspace/tets/src/lcy/ccdn/note/FilesDemo.java");
		List<String> lists = Files.readAllLines(path7,StandardCharsets.UTF_8);
		for(String s :lists){
			System.out.println(s);
		}
		Path path8  = Paths.get("D:/java/workspace/tets/src/lcy/ccdn/note/test.text");
		if(Files.notExists(path8)){
			Files.createFile(path8);
		}
		Files.write(path8, lists, StandardCharsets.UTF_8,StandardOpenOption.WRITE);
		
		 
		
		
	}
}
