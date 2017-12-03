package netdb.courses.softwarestudio.lab.copier;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class BufferedRandomAccessCopier {

	private static final int BUFFER_SIZE = 8192;

	public static double copy(File src, File dst) throws IOException {

		long startTime = System.nanoTime();

		RandomAccessFile srcRand = new RandomAccessFile(src, "r");
		RandomAccessFile dstRand = new RandomAccessFile(dst, "rws");

		byte[] buffer = new byte[BUFFER_SIZE];

		int dataSize = -1;
		while ((dataSize = srcRand.read(buffer)) != -1) {
			dstRand.write(buffer, 0, dataSize);
		}

		if (srcRand != null) {
			srcRand.close();
		}
		if (dstRand != null) {
			dstRand.close();
		}

		long endTime = System.nanoTime();
		return (endTime - startTime) / 1e6;

	}
}
