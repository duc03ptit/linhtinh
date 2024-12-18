package RMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.*;

public class Byte_jR8JhiwG {
    public static void main(String[] args) {
        String msv = "B21DCCN246";
        String qcode = "jR8JhiwG";

        try {
            ByteService byteService = (ByteService) Naming.lookup("rmi://203.162.10.109/RMIByteService");
            byte[] receivedByte = byteService.requestData(msv, qcode);
            System.out.println(Arrays.toString(receivedByte));
            String data = Arrays.toString(receivedByte);
//            String data = "[20, 80, 74, 10, 43, 12, 42, 39, 60, 45, 12, 74, 90, 77, 6]";
            System.out.println(data);
            data = data.substring(1, data.length()-1);
            String[] parts = data.split(",");
            ArrayList<Integer> arrayList = new ArrayList<>();
            int K = Integer.valueOf(parts[parts.length-1].trim());
            System.out.println(K);
            Map<Integer, Integer> mp = new HashMap<>();
            for (int i = 0; i < parts.length-1; i++) {
                int tmp = Integer.valueOf(parts[i].trim());
                arrayList.add(tmp);
                mp.put(tmp, i+1);
            }
            Collections.sort(arrayList, Collections.reverseOrder());
            System.out.println(arrayList);
            int res = arrayList.get(K-1);
            int vt = mp.get(res);
            byte[] send = new byte[2];
            send[0] = (byte) res;
            send[1] = (byte) vt;

            System.out.println(res +" "+ vt);
            byteService.submitData(msv, qcode, send);
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }

    }
}

//20, 80, 74, 10, 43, 12, 42, 39, 60, 45, 12, 74, 90, 77, 6
//        | Original Array: 20, 80, 74, 10, 43, 12, 42, 39, 60, 45, 12, 74, 90, 77 | K: 6 |
//Expected: 60, 9 | Submitted: 49, 50
