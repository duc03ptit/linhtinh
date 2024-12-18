package UDP;

import java.io.IOException;
import java.net.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class String_9MpQGn31 {
    public static void main(String[] args) {
        try {
            DatagramSocket client = new DatagramSocket();
            InetAddress address = InetAddress.getByName("203.162.10.109");
            int port = 2208;
            byte[] sendBuffer;
            byte[] receiveBuffer = new byte[1024];

            String msv = ";B21DCCN246;9MpQGn31";
            sendBuffer = msv.getBytes();
            DatagramPacket packet = new DatagramPacket(sendBuffer, sendBuffer.length, address, port);
            client.send(packet);

            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            client.receive(receivePacket);
            String received = new String(receivePacket.getData(), 0, receivePacket.getLength());
//            String received = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println(received);

            String[] parts = received.split(";");

            String requestId = parts[0];
            String str = parts[1];

//            Stack<Character> st = new Stack<Character>();
//            String res = "";
//            for (int i = 0; i < str.length(); i++) {
//                if (st.empty()) {
//                    st.push(str.charAt(i));
//                } else if (st.peek() == str.charAt(i)) {
//                    st.push(str.charAt(i));
//                } else if (st.peek() != str.charAt(i)) {
//                    res = res + st.size() + st.peek();
//                    st.clear();
//                    st.push(str.charAt(i));
//                }
//            }
//            res = requestId + ";" + res + st.size() + st.peek();

            String res = requestId + ";";
            Map<Character, Integer> mp = new HashMap<Character, Integer>();
            for (int i = 0; i < str.length(); i++) {
                if (mp.containsKey(str.charAt(i))) {
                    mp.put(str.charAt(i), mp.get(str.charAt(i)) + 1);
                } else {
                    mp.put(str.charAt(i), 1);
                }
            }
            for (int i = 0; i < str.length(); i++) {
                if (mp.containsKey(str.charAt(i))) {
                    res += mp.get(str.charAt(i)) +""+ str.charAt(i);
                    mp.remove(str.charAt(i));
                }
            }
            System.out.println(res);
            sendBuffer = res.getBytes();
            DatagramPacket datagramPacket1 = new DatagramPacket(sendBuffer, sendBuffer.length, address, port);
            client.send(datagramPacket1);


        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
