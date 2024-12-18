/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WS_ObjectService_yc0pUECc;
import WS_ObjectService_1A5b2wor.StudentY;
import java.util.*;
/**
 *
 * @author MinhDuc
 */
public class _yc0pUECc {
    public static void main(String[] args) {
        String studentCode = "B21DCCN170";
        String qCode = "yc0pUECc";
        List<StudentY> data = requestListStudentY(studentCode, qCode);
        System.out.println(data);

        
        Map<String, StudentY> mp = new HashMap<>();
        for (StudentY studentY : data) {
            String m = studentY.getSubject();
            if (mp.containsKey(m)) {
                if (mp.get(m).getScore()<studentY.getScore()) {
                    mp.remove(m);
                    mp.put(m, studentY);
                }
            } else {
                mp.put(m, studentY);
            }
        }
        List<StudentY> res = new ArrayList<>();
        for (StudentY studentY : data) {
            if (mp.containsValue(studentY)) {
                res.add(studentY);
            }
        }
        System.out.println(res);
        submitListStudentY(studentCode, qCode, res);
    }

    private static java.util.List<WS_ObjectService_1A5b2wor.StudentY> requestListStudentY(java.lang.String studentCode, java.lang.String qCode) {
        WS_ObjectService_1A5b2wor.ObjectService_Service service = new WS_ObjectService_1A5b2wor.ObjectService_Service();
        WS_ObjectService_1A5b2wor.ObjectService port = service.getObjectServicePort();
        return port.requestListStudentY(studentCode, qCode);
    }

    private static void submitListStudentY(java.lang.String studentCode, java.lang.String qCode, java.util.List<WS_ObjectService_1A5b2wor.StudentY> object) {
        WS_ObjectService_1A5b2wor.ObjectService_Service service = new WS_ObjectService_1A5b2wor.ObjectService_Service();
        WS_ObjectService_1A5b2wor.ObjectService port = service.getObjectServicePort();
        port.submitListStudentY(studentCode, qCode, object);
    }


    
}