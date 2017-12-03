package netdb.courses.softwarestudio.lab.benchmark;

import java.io.File;
import java.io.IOException;

import netdb.courses.softwarestudio.lab.copier.BufferedByteStreamCopier;
import netdb.courses.softwarestudio.lab.copier.BufferedRandomAccessCopier;
import netdb.courses.softwarestudio.lab.copier.ByteStreamCopier;
import netdb.courses.softwarestudio.lab.copier.NioChannelCopier;
import netdb.courses.softwarestudio.lab.copier.RandomAccessCopier;

public class App {
	public static void main(String[] args) throws IOException {

		File src = new File("file.txt");

		double randTime = RandomAccessCopier.copy(src,
				new File("rand_file.txt"));

		System.out.println("RandomAccessCopier :\t" + Math.round(randTime)
				+ " ms.");

		double randBuffTime = BufferedRandomAccessCopier.copy(src, new File(
				"buff_rand_file.txt"));

		System.out.println("BufferedRandomAccessCopier :\t"
				+ Math.round(randBuffTime) + " ms.");

		double byteStreamTime = ByteStreamCopier.copy(src, new File(
				"byte_stream_file.txt"));

		System.out.println("ByteStreamCopier :\t" + Math.round(byteStreamTime)
				+ " ms.");

		double buffByteStreamTime = BufferedByteStreamCopier.copy(src,
				new File("buff_byte_stream_file.txt"));

		System.out.println("BufferedByteStreamCopier :\t"
				+ Math.round(buffByteStreamTime) + " ms.");

		double nioTime = NioChannelCopier.copy(src, new File("nio_file.txt"));

		System.out.println("NioChannelCopier :\t" + Math.round(nioTime)
				+ " ms.");

	}
}
