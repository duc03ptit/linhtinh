package TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

public class ByteStream_1SyAVk8R {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("203.162.10.109", 2206);
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();

            String msv = "B21DCCN246;1SyAVk8R";
            byte[] msg = msv.getBytes();
            out.write(msg);

            byte[] buffer = new byte[1024];
            int bytesRead = in.read(buffer);
            String receivedString = new String(buffer, 0, bytesRead, "UTF-8");
            System.out.println(receivedString);
            Map<Character, Integer> mp = new HashMap<>();
            String resStr = "";
            for (int i = 0; i < receivedString.length(); i++) {
                String tmp = "";
                mp.clear();
                for (int j = i; j < receivedString.length(); j++) {
                    if (mp.containsKey(receivedString.charAt(j))) {
                        if (tmp.length() > resStr.length()) {
                            resStr = tmp;
                        }
                        break;
                    }
                    tmp += receivedString.charAt(j);
                    mp.put(receivedString.charAt(j), 1);
                }
            }
            resStr = resStr + ";" + resStr.length();
            out.write(resStr.getBytes());
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}



