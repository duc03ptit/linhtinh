/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WS_DataService_xQipmFdp;

import java.util.*;

/**
 *
 * @author MinhDuc
 */
public class _xQipmFdp {
    public static void main(String[] args) {
        String studentCode = "B21DCCN170";
        String qCode = "xQipmFdp";
        int n = (int) getDataDouble(studentCode, qCode);
        System.out.println(n);
        List<Integer> a = new ArrayList<>();
       
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                a.add(i);
            }
        }
        a.addFirst(a.size());
        System.out.println(a);
        submitDataIntArray(studentCode, qCode, a);
    }

    private static double getDataDouble(java.lang.String studentCode, java.lang.String qCode) {
        WS_DataService_Zj7wANXZ.DataService_Service service = new WS_DataService_Zj7wANXZ.DataService_Service();
        WS_DataService_Zj7wANXZ.DataService port = service.getDataServicePort();
        return port.getDataDouble(studentCode, qCode);
    }

    private static void submitDataIntArray(java.lang.String studentCode, java.lang.String qCode, java.util.List<java.lang.Integer> data) {
        WS_DataService_Zj7wANXZ.DataService_Service service = new WS_DataService_Zj7wANXZ.DataService_Service();
        WS_DataService_Zj7wANXZ.DataService port = service.getDataServicePort();
        port.submitDataIntArray(studentCode, qCode, data);
    }
    
}
