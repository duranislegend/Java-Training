package cc.ccs.chap10;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IO {
	public static void dump(InputStream input, OutputStream output) throws IOException {
		try (InputStream in = input; OutputStream out = output) {
			byte[] data = new byte[1024];
			int length = -1;
			while ((length = in.read(data)) != -1) {
				out.write(data, 0, length);
			}
		}
	}
}
