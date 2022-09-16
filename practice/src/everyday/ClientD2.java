
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientD2 {
    public static void main(String[] args) throws IOException {
        System.out.println("客户端启动");
        Socket client = new Socket("localhost", 666);
        OutputStream os = client.getOutputStream();
        os.write("你好吗".getBytes());
        InputStream is = client.getInputStream();
        byte[] b = new byte[1024];
        int len = is.read(b);
        System.out.println(new String(b,0,len));
        is.close();
        os.close();
        client.close();
    }
}
