/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WS_DataService_Zj7wANXZ;

import java.util.*;

/**
 *
 * @author MinhDuc
 */
public class _Zj7wANXZ {
    public static String change(int n) {
        String res = "";
        while (n > 0) {
            int tmp = n % 2;
            res = tmp + "" + res;
            n = n / 2;
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(change(2));
        String studentCode = "B21DCCN194";
        String qCode = "Zj7wANXZ";
        List<Integer> a = getData(studentCode, qCode);
        System.out.println(a);
        List<String> res = new ArrayList<>();
        for (int x : a) {
            res.add(change(x));
        }
        System.out.println(res);
        submitDataStringArray(studentCode, qCode, res);
        
        
    }
   

    private static void submitDataStringArray(java.lang.String studentCode, java.lang.String qCode, java.util.List<java.lang.String> data) {
        WS_DataService_Zj7wANXZ.DataService_Service service = new WS_DataService_Zj7wANXZ.DataService_Service();
        WS_DataService_Zj7wANXZ.DataService port = service.getDataServicePort();
        port.submitDataStringArray(studentCode, qCode, data);
    }

    private static java.util.List<java.lang.Integer> getData(java.lang.String studentCode, java.lang.String qCode) {
        WS_DataService_Zj7wANXZ.DataService_Service service = new WS_DataService_Zj7wANXZ.DataService_Service();
        WS_DataService_Zj7wANXZ.DataService port = service.getDataServicePort();
        return port.getData(studentCode, qCode);
    }
    
}
