/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjectService_2VJvgvh7;

/**
 *
 * @author MinhDuc
 */
public class _2VJvgvh7 {
    public static void main(String[] args) {
        String msv = "B21DCCN246";
        String qcode = "2VJvgvh7";
        ProductY py = requestProductY(msv, qcode);
        System.out.println(py);
        float tmp = py.getPrice() * (1 + py.getTaxRate() / 100) * (1 - py.getDiscount() / 100);
        py.setFinalPrice(tmp);
        System.out.println(py);
        submitProductY(msv, qcode, py);
        
    }

    private static ProductY requestProductY(java.lang.String studentCode, java.lang.String qCode) {
        ObjectService_2VJvgvh7.ObjectService_Service service = new ObjectService_2VJvgvh7.ObjectService_Service();
        ObjectService_2VJvgvh7.ObjectService port = service.getObjectServicePort();
        return port.requestProductY(studentCode, qCode);
    }

    private static void submitProductY(java.lang.String studentCode, java.lang.String qCode, ObjectService_2VJvgvh7.ProductY object) {
        ObjectService_2VJvgvh7.ObjectService_Service service = new ObjectService_2VJvgvh7.ObjectService_Service();
        ObjectService_2VJvgvh7.ObjectService port = service.getObjectServicePort();
        port.submitProductY(studentCode, qCode, object);
    }
    
}
