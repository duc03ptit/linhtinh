/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WS_ObjectService_1A5b2wor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author MinhDuc
 */
public class _1A5b2wor {
    public static void main(String[] args) {
        try {
            String studentCode = "B21DCCN194";
            String qCode = "1A5b2wor";
            Employee employee = requestEmployee(studentCode, qCode);
            String p = "yyyy-MM-dd'T'hh:mm:ss.SSS'Z'";
            
            Date startDate = new SimpleDateFormat(p).parse(employee.getStartDate().normalize().toString());
            Date endDate = new SimpleDateFormat(p).parse(employee.getEndDate().normalize().toString());
            
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startDate);
          
            
            int res = 0;
            while (!calendar.getTime().after(endDate)) {
                Date curr = calendar.getTime();
                String dateStr = curr.toString();
//                if (!dateStr.startsWith("Sun") && !dateStr.startsWith("Sat")) res++;
                System.out.println(curr);
                int daysOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
                System.out.println(daysOfWeek);
                if (daysOfWeek != 1 && daysOfWeek != 7) res++;
                calendar.add(Calendar.DAY_OF_MONTH, 1);
            }
            
            System.out.println(startDate);
            System.out.println(endDate);
            employee.setWorkingDays(res);
            submitEmployee(studentCode, qCode, employee);
        } catch (ParseException ex) {
            Logger.getLogger(_1A5b2wor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static WS_ObjectService_1A5b2wor.Employee requestEmployee(java.lang.String studentCode, java.lang.String qCode) {
        WS_ObjectService_1A5b2wor.ObjectService_Service service = new WS_ObjectService_1A5b2wor.ObjectService_Service();
        WS_ObjectService_1A5b2wor.ObjectService port = service.getObjectServicePort();
        return port.requestEmployee(studentCode, qCode);
    }

    private static void submitEmployee(java.lang.String studentCode, java.lang.String qCode, WS_ObjectService_1A5b2wor.Employee object) {
        WS_ObjectService_1A5b2wor.ObjectService_Service service = new WS_ObjectService_1A5b2wor.ObjectService_Service();
        WS_ObjectService_1A5b2wor.ObjectService port = service.getObjectServicePort();
        port.submitEmployee(studentCode, qCode, object);
    }




}
