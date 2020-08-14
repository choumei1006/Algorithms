package demo.IO_NIO;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author:choumei
 * @date:2020/8/7 19:43
 * @Description: 使用IO/NIO实现文件的拷贝
 */
public class CopyFile {

    /**
     * 使用IO实现
     * @param source
     * @param target
     */
    public static void copyFileIO(String source, String target) {
        try(InputStream in = new FileInputStream(source);
                OutputStream os = new FileOutputStream(target)){
            byte[] buffer = new byte[4096];
            int byteToRead;
            while((byteToRead = in.read(buffer)) != -1){
                os.write(buffer, 0, byteToRead);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 使用NIO实现文件拷贝
     */
    public static void copyFileNIO(String source, String target){
        try(FileInputStream fis = new FileInputStream(source);
            FileOutputStream fos = new FileOutputStream(target)){

            FileChannel inChannel = fis.getChannel();
            FileChannel ourChannel = fos.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(4096);
            while(inChannel.read(buffer) != -1){
                buffer.flip();
                ourChannel.write(buffer);
                buffer.clear();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
