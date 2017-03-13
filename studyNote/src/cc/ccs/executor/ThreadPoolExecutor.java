/**
 * 
 */
package cc.ccs.executor;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.text.SimpleDateFormat;

import cc.ccs.executor.DircetExecutor;
import cc.ccs.executor.Page;
import cc.ccs.executor.ThreadPerTaskExecutor;

/**
 * @author congyang
 *
 */

public class ThreadPoolExecutor {
	public static void main(String... args) throws Exception{
	long l = System.currentTimeMillis();
	Date date = new Date(l);
	SimpleDateFormat sdf = new SimpleDateFormat("yy-mm-dd HH:mm:ss");
	System.out.println(sdf.format(date));
	
	String path = Param.getPath();
	System.out.println(path);
	String[] files = {path +  File.separator + "baidu.html",path + File.separator + "yahoo.html",path +  File.separator +"qq.html"};
	URL[] urls = {new URL("http://www.baidu.com"),new URL("http://www.yahoo.com/"),new URL("http://www.qq.com/")};
	Page page = new Page(urls,files,new DircetExecutor());
	page.download();
	Page pageThreadPerTask = new Page(urls,files,new ThreadPerTaskExecutor());
	//pageThreadPerTask.download();
	System.out.println(sdf.format(new Date(System.currentTimeMillis())));
	}
}
