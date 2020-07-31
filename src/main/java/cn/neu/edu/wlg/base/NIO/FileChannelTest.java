package cn.neu.edu.wlg.base.NIO;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest {

    public static void main(String[] args) throws IOException {
        // 1. 创建一个RandomAccessFile对象
        RandomAccessFile raf = new RandomAccessFile("D:\\project\\java\\JavaLearn\\src\\main\\java\\cn\\neu\\edu\\wlg\\base\\NIO\\NIOData.txt", "rw");
        // 通过RandomAccessFile对象的getChannel()方法
        FileChannel inChannel = raf.getChannel();
        // 2. 创建一个读数据缓冲区对象
        ByteBuffer buf = ByteBuffer.allocate(48);
        // 3. 从通道中读取数据
        int byteRead = inChannel.read(buf);
        inChannel.write(buf);
        while (-1 != byteRead) {
            System.out.println("Read:" + byteRead);
            // Buffer有两种模式：读模式和写模式。在写模式下调用flip()之后，Buffer从写模式变成读模式
            buf.flip();
            // 如果还有未读内容
            while (buf.hasRemaining()) {
                System.out.println((char) buf.get());
            }
            // 清空缓冲区
            buf.clear();
            byteRead = inChannel.read(buf);
        }
        // 关闭RandomAccessFile对象
        raf.close();
    }
}
