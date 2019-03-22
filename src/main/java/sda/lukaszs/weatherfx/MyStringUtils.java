package sda.lukaszs.weatherfx;

import java.util.HashMap;
import java.util.Map;


public class MyStringUtils {

    private static Map<Character, Character> MAP_NORM;

    public static String stripAccents(String s){
        if (s != null) {
            initNormMap();
            StringBuilder sb = new StringBuilder(s);
            for(int i = 0; i < s.length(); i++) {
                Character c = MAP_NORM.get(sb.charAt(i));
                if(c != null) {
                    sb.setCharAt(i, c);
                }
            }
            return sb.toString();
        }
        return null;
    }

    private static void initNormMap(){
        MAP_NORM = new HashMap<>();
        MAP_NORM.put('ą', 'a');
        MAP_NORM.put('ć', 'c');
        MAP_NORM.put('ł', 'l');
        MAP_NORM.put('ę', 'e');
        MAP_NORM.put('ż', 'z');
        MAP_NORM.put('ź', 'z');
        MAP_NORM.put('ó', 'o');
        MAP_NORM.put('ń', 'n');
        MAP_NORM.put('ś', 's');
        MAP_NORM.put('Ą', 'A');
        MAP_NORM.put('Ć', 'C');
        MAP_NORM.put('Ł', 'L');
        MAP_NORM.put('Ę', 'E');
        MAP_NORM.put('Ż', 'Z');
        MAP_NORM.put('Ź', 'Z');
        MAP_NORM.put('Ó', 'O');
        MAP_NORM.put('Ń', 'N');
        MAP_NORM.put('Ś', 'S');
    }
}
