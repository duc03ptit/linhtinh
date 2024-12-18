package RMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Character_HocFSJz2 {
    public static char change(char c, int k) {
        k = k % 26;
        int tmp = (int) c;
        while (k > 0) {
            tmp--;
            k--;
            if (tmp < 65) {
                tmp = 90;
            } else if (c >= 'a' && tmp < 97) {
                tmp = 122;
            }
        }
        return (char) tmp;
    }

    public static void main(String[] args) {

        int c1 = 'a';
        int c2 = 'z';
        int c3 = 'A';
        int c4 = 'Z';
        System.out.println("" + c1 +" "+ c2  +" "+ c3 +" "+ c4);

        String msv = "B21DCCN246";
        String qcode = "HocFSJz2";

        try {
            CharacterService characterService = (CharacterService) Naming.lookup("rmi://203.162.10.109/RMICharacterService");
            String data = characterService.requestCharacter(msv, qcode);
            System.out.println(data);
            int k = data.length() % 7;
            String res = "";
            for (int i = 0; i < data.length(); i++) {
                char tmp = data.charAt(i);
                res += change(tmp, k);
            }
            System.out.println(res);
            characterService.submitCharacter(msv, qcode, res);
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}
