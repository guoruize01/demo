import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerD2 {
    public static void main(String[] args) throws Exception{
        System.out.println("服务器启动");
        ServerSocket ss = new ServerSocket(666);
        Socket server = ss.accept();
        InputStream is = server.getInputStream();
        byte[] b= new byte[1024];
        int len = is.read(b);
        String msg = new String(b,0,len);
        System.out.println(msg);
//        回写数据
        OutputStream os = server.getOutputStream();
        os.write("i am ok,thank u".getBytes());
        os.close();
        is.close();
        server.close();
    }
}
