package lcy.ccdn.note;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

class CharUtil {
	public static void dump(Reader src, Writer desc) throws IOException {
		try (Reader input = src; Writer out = desc) {
			char[] chars = new char[1024];
			int length = -1;
			while ((length = input.read(chars)) != -1) {
				out.write(chars, 0, length);
			}
		}
	}
}

public class CharIODemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// StringReader示例
		/*
		 * String s = "hello world"; StringReader strReader = new
		 * StringReader(s); //String des = null; //StringWriter strWrite = new
		 * StringWriter(des); StringWriter strWriter = new StringWriter();
		 * strWriter.write("sss"); strWriter.write(2); CharUtil.dump(strReader,
		 * strWriter); System.out.println(strWriter.toString());
		 */

		// FileReader示例
		/*
		 * Reader input = new FileReader(args[0]); Writer output = new
		 * FileWriter(args[1]); char[] chars = new char[1024]; int length = -1;
		 * while((length = input.read(chars)) != -1){ output.write(chars, 0,
		 * length); //output.write(chars); }
		 * //System.out.println(strWriter.toString()); input.close();
		 * output.close();
		 */
		// strReader.close();
		// strWriter.close();

		// InputStreamRead示例
		/*
		 * try (InputStream inputStream = new FileInputStream(args[0]); Reader
		 * input = new InputStreamReader(inputStream, "UTF-8"); OutputStream
		 * outputStream = new FileOutputStream(args[1]); Writer out = new
		 * OutputStreamWriter(outputStream, "gb2312");) { // Writer out = new
		 * StringWriter(); char[] chars = new char[1024]; int length = -1; while
		 * ((length = input.read(chars)) != -1) { out.write(chars, 0, length); }
		 * }
		 */
		// System.out.println(out.toString());
		// BufferedReader示例
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in))) {
			String s = reader.readLine();
			PrintWriter writer = new PrintWriter(System.out);
			writer.println(s);
			writer.close();
		}

	}

}
