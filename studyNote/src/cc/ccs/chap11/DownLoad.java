package cc.ccs.chap11;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

 class DownLoad {
	public static void main(String[] args) throws IOException{
		URL[] urls = {new URL("http://www.ifeng.com/"),new URL("http://www.hao268.com/")};
		String[] files = {"bd.html","168.html"};
		SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		System.out.println(df.format(new Date()));
		for(int i = 0; i < urls.length; i++){
			dump(urls[i].openStream(),new FileOutputStream(files[i]));
			System.out.println(df.format(new Date()));
			
		}
	}

	private static void dump(InputStream input , OutputStream output) throws IOException{
		try(InputStream in = input; OutputStream out = output){
			byte[] data = new byte[1024];
			int length = -1;
			while((length = in.read(data)) != -1){
				out.write(data,0,length);
			}
		}
	}
}
