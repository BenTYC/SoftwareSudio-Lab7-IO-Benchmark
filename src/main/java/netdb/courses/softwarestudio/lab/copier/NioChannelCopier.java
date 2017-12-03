package netdb.courses.softwarestudio.lab.copier;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioChannelCopier {

	private static final int BUFFER_SIZE = 8192;

	public static double copy(File src, File dst) throws IOException {

		long startTime = System.nanoTime();

		ByteBuffer buffer = ByteBuffer.allocateDirect(BUFFER_SIZE);

		FileInputStream inStream = new FileInputStream(src);
		FileOutputStream outStream = new FileOutputStream(dst);

		FileChannel in = inStream.getChannel();
		FileChannel out = outStream.getChannel();

		while (in.read(buffer) != -1) {
			buffer.flip();
			out.write(buffer);
			buffer.clear();
		}

		in.close();
		inStream.close();

		out.close();
		outStream.close();

		long endTime = System.nanoTime();

		return (endTime - startTime) / 1e6;

	}

}
