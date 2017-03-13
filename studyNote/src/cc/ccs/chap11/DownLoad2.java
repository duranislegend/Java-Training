package cc.ccs.chap11;


import java.io.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DownLoad2 {
	public static void main(String[] args) throws IOException{
		final URL[] urls = {new URL("http://www.hao268.com/"),new URL("http://www.ifeng.com/")};
		final String[] files = {"bd","268"};
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh-mm-ss");
		System.out.println(sdf.format(new Date()));
		for(int i = 0; i < urls.length; i++){
			final int index = i;
			new Thread(){
				@Override
				public void run(){
					try{
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh-mm-ss");
						dump(urls[index].openStream(),new FileOutputStream(files[index]));
						System.out.println(sdf.format(new Date()));
					}catch(IOException e){
						e.getStackTrace();
					}
				}
			}.start();
		}
	}
	private static void dump(InputStream input, OutputStream output) throws IOException{
		try(InputStream in = input; OutputStream out = output){
			byte[] date = new byte[1024];
			int length = -1;
			while((length = in.read(date)) != -1){
				out.write(date,0,length);
			}
		}
	}
}
