package TCP;

import java.io.*;
import java.net.Socket;

public class DataStream_Qos9IWx6 {
    public static char change(char c, int k) {
        k = k % 26;
        int tmp = c;
        while (k > 0) {
            tmp = tmp - 1;
            k--;
            if (tmp < 65) tmp = 90;
            else if (c > 'a' && tmp < 97) tmp = 122;
        }
        return (char) tmp;
    }
    public static void main(String[] args) {
//        int c = 'a';
//        int c1 = 'z';
//        int c2 = 'A';
//        int c3 = 'Z';
//        System.out.println(c);
//        System.out.println(c1);
//        System.out.println(c2);
//        System.out.println(c3);
//        System.out.println(change('Q', 9)); // H

        try {
            Socket socket = new Socket("203.162.10.109", 2207);
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();

            DataInputStream dis = new DataInputStream(in);
            DataOutputStream dos = new DataOutputStream(out);

            String msv = "B21DCCN246;Qos9IWx6";
            dos.writeUTF(msv);
            dos.flush();

            String str = dis.readUTF();
            System.out.println(str);
            Integer c = dis.readInt();
            System.out.println(c);

            String res = "";

            for (int i = 0; i < str.length(); i++) {
                char tmp = str.charAt(i);
                res += change(tmp, c);
            }
            System.out.println(res);
            dos.writeUTF(res);
            dos.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
