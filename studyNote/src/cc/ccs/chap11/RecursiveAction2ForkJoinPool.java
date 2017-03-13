package cc.ccs.chap11;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

class Query extends RecursiveAction {
	Path path;
	String pattern;
	Query(Path path,String pattern){
		this.path = path;
		this.pattern = pattern;
	}
	@Override
	protected void compute() {
		// TODO Auto-generated method stub
		try {
			DirectoryStream<Path> streams = Files.newDirectoryStream(path);
			List<Query> paths = new ArrayList<>();
			for(Path path : streams){
				if(Files.isDirectory(path)){
					//������ļ��У��ֽ�Ϊ�������ռ��������߳���ִ���������
					paths.add(new Query(path,pattern));
				}
				if(path.toString().endsWith(pattern)){
					System.out.println(path.toString());
				}
				
			}
			//ִ������������������������ɺ󷵻�
			ForkJoinTask.invokeAll(paths);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

public class RecursiveAction2ForkJoinPool {
	public static void main(String[] args){
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		Query query = new Query(Paths.get(args[0]),args[1]);
		forkJoinPool.invoke(query);
	}
}
