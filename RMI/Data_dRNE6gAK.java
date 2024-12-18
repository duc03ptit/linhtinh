package RMI;

import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class Data_dRNE6gAK {
    public static void main(String[] args) {
        String msv = "B21DCCN246";
        String qcode = "dRNE6gAK";

        try {
            DataService dataService = (DataService) Naming.lookup("rmi://203.162.10.109/RMIDataService");
            int amount = (int) dataService.requestData(msv, qcode);
            System.out.println(amount);
            ArrayList<Integer> res = new ArrayList<>();
            ArrayList<Integer> root = new ArrayList<>();
            root.add(10);
            root.add(5);
            root.add(2);
            root.add(1);
            if (amount == 0) {
                dataService.submitData(msv, qcode, "-1");
            } else {
                for (int i : root) {
                    while (amount >= i) {
                        res.add(i);
                        amount -= i;
                    }
                }
                System.out.println(res);
                if (amount > 0) {
                    dataService.submitData(msv, qcode, "-1");
                } else {
                    String resStr = res.size() + "; ";
                    for (int i : res) {
                        resStr += i + ",";
                    }
                    resStr = resStr.substring(0, resStr.length()-1);
                    dataService.submitData(msv, qcode, resStr);
                }
            }

        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }

    }
}
//
//50
//        | Input: 50 | Expected: 5; 10,10,10,10,10 | Submitted: -1