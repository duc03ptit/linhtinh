/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WS_CharacterService_brbyTQ74;

import java.util.*;

/**
 *
 * @author MinhDuc
 */
public class _brbyTQ74 {
    public static void main(String[] args) {
        String studentCode = "B21DCCN170";
        String qCode = "brbyTQ74";
        
        List<String> data = requestStringArray(studentCode, qCode);
        System.out.println(data);
        Collections.sort(data, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        System.out.println(data);
        submitCharacterStringArray(studentCode, qCode, data);
    }

    private static java.util.List<java.lang.String> requestStringArray(java.lang.String studentCode, java.lang.String qCode) {
        WS_CharacterService_DUuggz0C.CharacterService_Service service = new WS_CharacterService_DUuggz0C.CharacterService_Service();
        WS_CharacterService_DUuggz0C.CharacterService port = service.getCharacterServicePort();
        return port.requestStringArray(studentCode, qCode);
    }

    private static void submitCharacterStringArray(java.lang.String studentCode, java.lang.String qCode, java.util.List<java.lang.String> data) {
        WS_CharacterService_DUuggz0C.CharacterService_Service service = new WS_CharacterService_DUuggz0C.CharacterService_Service();
        WS_CharacterService_DUuggz0C.CharacterService port = service.getCharacterServicePort();
        port.submitCharacterStringArray(studentCode, qCode, data);
    }
}
