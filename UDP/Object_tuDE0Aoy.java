package UDP;

import java.io.*;
import java.net.*;

public class Object_tuDE0Aoy {
    public static void main(String[] args) {

        try {
            DatagramSocket client = new DatagramSocket();
            InetAddress address = InetAddress.getByName("203.162.10.109");
            int port = 2209;
            byte[] sendBuffer;
            byte[] receivedBuffer = new byte[1024];

            String msv = ";B21DCCN246;tuDE0Aoy";
            sendBuffer = msv.getBytes();
            DatagramPacket dp1 = new DatagramPacket(sendBuffer, sendBuffer.length, address, port);
            client.send(dp1);

            DatagramPacket dp2 = new DatagramPacket(receivedBuffer, receivedBuffer.length);
            client.receive(dp2);
            byte[] requestIdByte = new byte[8];
            System.arraycopy(receivedBuffer, 0, requestIdByte, 0, 8);
//            byte[] requestIdBytes = new byte[8];
//            for (int i = 0; i < 8; i++) {
//                requestIdBytes[i] = receivedBuffer[i];
//            }
            String requestId = new String(requestIdByte);
            System.out.println(requestId);

            ByteArrayInputStream bais = new ByteArrayInputStream(receivedBuffer, 8, receivedBuffer.length-8);
            ObjectInputStream ois = new ObjectInputStream(bais); // trong ois laf 1 stream

            Product product = (Product) ois.readObject();
            System.out.println(product);

            String[] names = product.getName().split(" ");
            String tmp = names[0];
            names[0] = names[names.length-1];
            names[names.length-1] = tmp;
            product.setName(String.join(" ", names));

            String quantityStr = String.valueOf(product.getQuantity());
            StringBuilder builder = new StringBuilder(quantityStr);
            builder.reverse();
            product.setQuantity(Integer.valueOf(builder.toString()));

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(product);
            oos.flush();
            byte[] productByte = baos.toByteArray();

            byte[] sendObject = new byte[8 + productByte.length];
            System.arraycopy(requestIdByte, 0, sendObject, 0, 8);
            System.arraycopy(productByte,0, sendObject, 8, productByte.length);

            DatagramPacket dp3 = new DatagramPacket(sendObject, sendObject.length, address, port);
            client.send(dp3);

        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
