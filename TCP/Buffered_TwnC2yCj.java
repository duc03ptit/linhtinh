package TCP;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Buffered_TwnC2yCj {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("203.162.10.109", 2208);
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            String msv = "B21DCCN246;TwnC2yCj";
            bw.write(msv);
            bw.newLine();
            bw.flush();

            String str = br.readLine();
            System.out.println(str);

            Map<Character, Integer> mp = new HashMap<>();

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == ' ') continue;
                if (mp.containsKey(c)) {
                    mp.put(c, mp.get(c) + 1);
                } else {
                    mp.put(c, 1);
                }
            }
            String res = "";
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == ' ') continue;
                if (mp.containsKey(c)) {
                    if (mp.get(c) >= 2) {
                        res += c + ":" + mp.get(c) + ",";
                        mp.put(c, 0);
                    }
                }
            }
            System.out.println(res);
            bw.write(res);
            bw.newLine();
            bw.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
