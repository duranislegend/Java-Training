/**
 * 
 */
package cc.ccs.executor;
import java.net.URL;
import java.util.concurrent.Executor;
import java.io.*;
/**
 * @author congyang
 *
 */
public class Page {
	private URL[] urls;
	private String[] files;
	private Executor executor;
	public Page(URL[] urls,String[] files,Executor executor){
		this.urls = urls;
		this.files = files;
		this.executor = executor;
	}
	public void dump(InputStream src,OutputStream desc) throws IOException{
		try(InputStream input =src;OutputStream output = desc){
			byte[] data = new byte[1024];
			int length = -1;
			while((length = input.read(data)) != -1){
				output.write(data,0,length);
			}
		}
	}
	public  void  download(){
		for(int i = 0; i < urls.length; i++){
			final int index = i;
			executor.execute(new Runnable(){
				@Override
				public void run(){
					
					try {
						dump(urls[index].openStream(),new FileOutputStream(new File(files[index])));
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			
		}
	}
}
