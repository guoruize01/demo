package everyday;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerD1 {
    public static void main(String[] args) throws Exception{
        System.out.println("服务器启动");
        ServerSocket ss = new ServerSocket(666);
        Socket server = ss.accept();
        InputStream is = server.getInputStream();
        byte[] b = new byte[1024];
        int len = is.read(b);
        String msg = new String(b,0,len);
        System.out.println(msg);
        is.close();
        server.close();
    }
}
