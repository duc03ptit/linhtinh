/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WS_DataService_vpcsjnzK;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



/**
 *
 * @author MinhDuc
 */
public class _vpcsjnzK {
    
    public static void main(String[] args) {
        String studentCode = "B21DCCN246";
        String qcode = "vpcsjnzK";
        
        List<Integer> data = getData(studentCode, qcode);
        System.out.println(data);
        
        List<Integer> chan = data.stream()
                .filter(number -> number % 2 == 0)
                .collect(Collectors.toList());
        
        List<Integer> le = data.stream()
                .filter(number -> number % 2 == 1)
                .collect(Collectors.toList());
        
        List<Integer> res = new ArrayList<>();
        
        int minSize = Math.min(chan.size(), le.size());
        for (int i = 0; i < minSize; i++) {
            res.add(chan.get(i));
            res.add(le.get(i));
        }
        
        int i = minSize;
        while (i < chan.size()) res.add(chan.get(i++));
        while (i < le.size()) res.add(le.get(i++));
        submitDataIntArray(studentCode, qcode, res);
        
    }

    private static java.util.List<java.lang.Integer> getData(java.lang.String studentCode, java.lang.String qCode) {
        WS_DataService_vpcsjnzK.DataService_Service service = new WS_DataService_vpcsjnzK.DataService_Service();
        WS_DataService_vpcsjnzK.DataService port = service.getDataServicePort();
        return port.getData(studentCode, qCode);
    }

    private static void submitDataIntArray(java.lang.String studentCode, java.lang.String qCode, java.util.List<java.lang.Integer> data) {
        WS_DataService_vpcsjnzK.DataService_Service service = new WS_DataService_vpcsjnzK.DataService_Service();
        WS_DataService_vpcsjnzK.DataService port = service.getDataServicePort();
        port.submitDataIntArray(studentCode, qCode, data);
    }


}
