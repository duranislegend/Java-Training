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
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * @author congyang
 *
 */
class RecursiveActionOperator2 extends RecursiveAction {

	private Path root;
	private String s;

	RecursiveActionOperator2(Path pt) {
		this.root = pt;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.concurrent.RecursiveTask#compute()
	 */
	@Override
	protected void compute() {
		// TODO Auto-generated method stub
		try {
			DirectoryStream<Path> ds = Files.newDirectoryStream(root);
			List<RecursiveAction> lists = new ArrayList<>();
			
			Iterator<Path> it = ds.iterator();
			while(it.hasNext()){
				Path p = it.next();
				//System.out.println(it.next());
			//}
			//for (Path p : ds) {
				if (Files.isDirectory(p)) {
					lists.add(new RecursiveActionOperator2(p));
					if (p.getParent().equals(root)) {
						System.out.print("..");
						System.out.println(p.toString());
					} else {
						System.out.print("\t");
						System.out.println(p.toString());
					}
				} else// if(p.toString().endsWith(s)){
				{
					if (p.getParent().equals(root)) {
						System.out.print("..");
						System.out.println(p.toString());
					} else {
						System.out.print("\t");
						System.out.printf("%s%n", p.getFileName());
					}
				}
			}
			ForkJoinTask.invokeAll(lists);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

public class CopyOfRecursiveActionDemo {
	public static void main(String... args) {
		ForkJoinPool fjp = new ForkJoinPool();
		ForkJoinTask fjt = new RecursiveActionOperator2(Paths.get(args[0]));
		fjp.invoke(fjt);
	}

}
