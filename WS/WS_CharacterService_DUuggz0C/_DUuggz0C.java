/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WS_CharacterService_DUuggz0C;

import java.util.*;

/**
 *
 * @author MinhDuc
 */
public class _DUuggz0C {
    public static void main(String[] args) {
        String studentCode = "B21DCCN194";
        String qCode = "DUuggz0C";
        List<Integer> a = requestCharacter(studentCode, qCode);
        System.out.println(a);
        int k = a.getFirst() % a.size();
        
        while (k > 0) {
            int tmp = a.getFirst();
            a.remove(0);
            a.add(tmp);
            k--;
        }
        System.out.println(a);
        submitCharacterCharArray(studentCode, qCode, a);
    }

    private static java.util.List<java.lang.Integer> requestCharacter(java.lang.String studentCode, java.lang.String qCode) {
        WS_CharacterService_DUuggz0C.CharacterService_Service service = new WS_CharacterService_DUuggz0C.CharacterService_Service();
        WS_CharacterService_DUuggz0C.CharacterService port = service.getCharacterServicePort();
        return port.requestCharacter(studentCode, qCode);
    }

    private static void submitCharacterCharArray(java.lang.String studentCode, java.lang.String qCode, java.util.List<java.lang.Integer> data) {
        WS_CharacterService_DUuggz0C.CharacterService_Service service = new WS_CharacterService_DUuggz0C.CharacterService_Service();
        WS_CharacterService_DUuggz0C.CharacterService port = service.getCharacterServicePort();
        port.submitCharacterCharArray(studentCode, qCode, data);
    }



    
}
