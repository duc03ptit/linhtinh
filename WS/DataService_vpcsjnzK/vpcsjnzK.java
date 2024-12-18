/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataService_vpcsjnzK;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MinhDuc
 */
public class vpcsjnzK {
    public static void main(String[] args) {
        String msv = "B21DCCN246";
        String qcode = "vpcsjnzK";
        List<Integer> data = getData(msv, qcode);
        System.out.println(data);
        
        ArrayList<Integer> chan = new ArrayList<>();
        ArrayList<Integer> le = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        for (Integer i : data) {
            if (i % 2 == 0) {
                chan.add(i);
            } else {
                le.add(i);
            }
        }
        int minSize = Math.min(chan.size(), le.size());
        
        for (int i = 0; i < minSize; i++) {
            res.add(chan.get(i));
            res.add(le.get(i));
        }
        
        int i = minSize;
        while (i < chan.size()) {
            res.add(chan.get(i));
            i++;
        }
        i = minSize;
        while (i < le.size()) {
            res.add(le.get(i));
            i++;
        }
        System.out.println(res);
        
        submitDataIntArray(msv, qcode, res);
    }

    private static java.util.List<java.lang.Integer> getData(java.lang.String studentCode, java.lang.String qCode) {
        DataService_vpcsjnzK.DataService_Service service = new DataService_vpcsjnzK.DataService_Service();
        DataService_vpcsjnzK.DataService port = service.getDataServicePort();
        return port.getData(studentCode, qCode);
    }

    private static void submitDataIntArray(java.lang.String studentCode, java.lang.String qCode, java.util.List<java.lang.Integer> data) {
        DataService_vpcsjnzK.DataService_Service service = new DataService_vpcsjnzK.DataService_Service();
        DataService_vpcsjnzK.DataService port = service.getDataServicePort();
        port.submitDataIntArray(studentCode, qCode, data);
    }
    
    
    
    
}
