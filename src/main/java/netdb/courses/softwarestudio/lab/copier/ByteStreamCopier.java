package netdb.courses.softwarestudio.lab.copier;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteStreamCopier {

	public static double copy(File src, File dst) throws IOException {

		long startTime = System.nanoTime();

		InputStream in = new FileInputStream(src);
		OutputStream out = new FileOutputStream(dst);
		int data = -1;

		while ((data = in.read()) != -1) {
			out.write(data);
		}

		if (in != null) {
			in.close();
		}
		if (out != null) {
			out.close();
		}

		long endTime = System.nanoTime();
		return (endTime - startTime) / 1e6;
	}

}
