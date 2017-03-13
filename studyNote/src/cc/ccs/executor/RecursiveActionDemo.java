/**
 * 
 */
package cc.ccs.executor;

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
import java.util.concurrent.RecursiveTask;

/**
 * @author congyang
 *
 */
class RecursiveActionOperator extends RecursiveAction{

	private Path p;
	private String s;
	RecursiveActionOperator(Path p,String s){
		this.p = p;
		this.s = s;
	}
	/* (non-Javadoc)
	 * @see java.util.concurrent.RecursiveTask#compute()
	 */
	@Override
	protected void compute() {
		// TODO Auto-generated method stub
		try {
			DirectoryStream<Path> ds = Files.newDirectoryStream(p);
			List<RecursiveAction> lists = new ArrayList<>();
			for(Path p : ds){
				
				if(Files.isDirectory(p)){
					lists.add(new RecursiveActionOperator(p,s));
					System.out.println(p.toString());
				}else// if(p.toString().endsWith(s)){
				{
					System.out.printf("%s%n",p.getFileName());
				}
			}
			ForkJoinTask.invokeAll(lists);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
public class RecursiveActionDemo {
	public static void main(String...args ){
		ForkJoinPool fjp = new ForkJoinPool();
		ForkJoinTask fjt = new RecursiveActionOperator(Paths.get(args[0]),args[1]);
		fjp.invoke(fjt);
	}
	

}
