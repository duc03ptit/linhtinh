package UDP;

import java.io.IOException;
import java.net.*;
import java.util.HashSet;
import java.util.Set;

public class DataType_y2pgJjvK {
    public static void main(String[] args) {
        try {
            DatagramSocket client = new DatagramSocket();
            InetAddress address = InetAddress.getByName("203.162.10.109");
            int port = 2207;
            byte[] sendBuffer;
            byte[] receivedBuffer = new byte[1024];

            String msv = ";B21DCCN246;y2pgJjvK";
            sendBuffer = msv.getBytes();
            DatagramPacket dp1 = new DatagramPacket(sendBuffer, sendBuffer.length, address, port);
            client.send(dp1);

            DatagramPacket dp2 = new DatagramPacket(receivedBuffer, receivedBuffer.length);
            client.receive(dp2);
            String receivedStr = new String(dp2.getData(), 0, dp2.getLength());
            System.out.println(receivedStr);

            String[] parts = receivedStr.split(";");
            String requestId = parts[0];
            int n = Integer.valueOf(parts[1]);
            String[] parts1 = parts[2].split(",");

            Set<Integer> s = new HashSet<>();
            for (String x : parts1) {
                int tmp = Integer.valueOf(x);
                s.add(tmp);
            }

            String res = requestId + ";";
            for (int i = 1; i <= n; i++) {
                if (!s.contains(i)) {
                    res += i + ",";
                }
            }
            res = res.substring(0, res.length()-1);
            System.out.println(res);
            sendBuffer = res.getBytes();
            DatagramPacket dp3 = new DatagramPacket(sendBuffer, sendBuffer.length, address, port);
            client.send(dp3);

        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
