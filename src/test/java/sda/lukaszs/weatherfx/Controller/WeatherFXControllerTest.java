package sda.lukaszs.weatherfx.Controller;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import sda.lukaszs.weatherfx.MyStringUtils;

import static org.junit.jupiter.api.Assertions.*;

class WeatherFXControllerTest {

    @ParameterizedTest
    @CsvSource({"Łódź,Lodz","Gdańsk,Gdansk","Poznań,Poznan","Wrocław,Wroclaw","Kraków,Krakow","Białystok,Bialystok","Przemyśl,Przemysl","Zażółć gęślą jaźń,Zazolc gesla jazn","ZAŻÓŁĆ GĘŚLĄ JAŹŃ,ZAZOLC GESLA JAZN"})
    void stripAccentsTest(String input, String expected){
        assertEquals(MyStringUtils.stripAccents(input),expected);
    }
}