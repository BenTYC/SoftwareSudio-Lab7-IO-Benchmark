package netdb.courses.softwarestudio.lab.copier;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessCopier {

	public static double copy(File src, File dst) throws IOException {

		long startTime = System.nanoTime();

		RandomAccessFile srcRand = new RandomAccessFile(src, "r");
		RandomAccessFile dstRand = new RandomAccessFile(dst, "rws");

		int data = -1;
		while ((data = srcRand.read()) != -1) {
			dstRand.write(data);
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