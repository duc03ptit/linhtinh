package RMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Object_K5CukziK {
    public static String genEventCode(Event event) {
        String code = "S";
        if (event.getExpectedAttendance() >= 1000) {
            code = "L";
        } else if (event.getExpectedAttendance() >= 500) {
            code = "M";
        }
        String[] parts = event.getEventName().toUpperCase().split(" ");
        code += "" + parts[0].charAt(0) + parts[parts.length-1].charAt(parts[parts.length-1].length()-1);
        try {
            Date d1 = new SimpleDateFormat("yyyy-MM-dd").parse(event.getEventDate());
            String date = new SimpleDateFormat("ddMM").format(d1);
            code += date;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return code;
    }
    public static void main(String[] args) {
        String msv = "B21DCCN246";
        String qcode = "K5CukziK";
        try {
            ObjectService objectService = (ObjectService) Naming.lookup("rmi://203.162.10.109/RMIObjectService");
            Event event = (Event) objectService.requestObject(msv, qcode);
            System.out.println(event);
            event.setEventCode(genEventCode(event));
            System.out.println(event);
            objectService.submitObject(msv, qcode, event);
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }


    }
}
