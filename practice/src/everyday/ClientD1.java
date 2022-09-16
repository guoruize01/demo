

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ClientD1 {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost",666);
        OutputStream os = client.getOutputStream();
        os.write("你好，tcp".getBytes());
        os.close();
        client.close();
    }
}
