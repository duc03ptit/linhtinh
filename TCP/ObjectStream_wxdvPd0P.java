package TCP;

import java.io.*;
import java.net.Socket;

public class ObjectStream_wxdvPd0P {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("203.162.10.109", 2209);
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();

            ObjectInputStream ois = new ObjectInputStream(in);
            ObjectOutputStream oos = new ObjectOutputStream(out);

            String msv = "B21DCCN246;wxdvPd0P";
            oos.writeObject(msv);
            oos.flush();

            Product product = (Product) ois.readObject();
            System.out.println(product);

            int tmp = (int) product.getPrice();
            int res = 0;

            while (tmp > 0) {
                res += tmp % 10;
                tmp /= 10;
            }

            product.setDiscount(res);


            oos.writeObject(product);
            oos.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
