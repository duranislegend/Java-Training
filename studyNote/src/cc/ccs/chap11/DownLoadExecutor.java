package cc.ccs.chap11;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executor;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

class Page{
	private URL[] urls;
	private String[] files;
	private Executor executor;
	
	Page(URL[] urls, String[] files,Executor executor){
		this.urls = urls;
		this.files = files;
		this.executor = executor;
	}
	void dump(InputStream src,OutputStream dest) throws IOException{
		try(InputStream in = src;OutputStream out = dest){
			byte[] data = new byte[1024];
			int length = -1;
			while((length = in.read(data)) != -1){
				out.write(data,0,length);
			}
		}
	}
	void downLoad(){
		for(int i = 0;  i < urls.length; i++){
			final int index = i;
			final SimpleDateFormat df = new SimpleDateFormat();
			System.out.println(df.format(new Date()));
			executor.execute(new Runnable(){
				@Override
				public void run(){
					try {
						dump(urls[index].openStream(),new FileOutputStream(new File(files[index])));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally{
						System.currentTimeMillis();
					}
				}
			});
		}
	}
	
}


public class DownLoadExecutor {
	public static void main(String[] args) throws MalformedURLException  {
		URL[] urls = { new URL("http://www.baidu.com"),
				new URL("http://www.ifeng.com") };
		String[] files = { "bd.html",
				"if.html" };
		new Page(urls, files, new DirectExecutor()).downLoad();
		//new Page(urls,files,new ThreadPerTaskExecutor()).downLoad();
	}

}
