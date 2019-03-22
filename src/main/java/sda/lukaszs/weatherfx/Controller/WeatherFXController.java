package sda.lukaszs.weatherfx.Controller;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sda.lukaszs.weatherfx.Model.Weather;
import sda.lukaszs.weatherfx.Service.WeatherService;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.Normalizer;
import java.util.ResourceBundle;

public class WeatherFXController implements Initializable {

    @FXML
    public Button fxButtonSearch;
    @FXML
    public ImageView fxImageConditionIcon;
    @FXML
    public Label fxLocationCountry;
    @FXML
    public TextField fxTextFieldCity;
    @FXML
    public Label fxLocationRegion;
    @FXML
    public Label fxLocationCoordinates;
    @FXML
    public Label fxConditionDescription;
    @FXML
    public Label fxConditionTemperature;
    @FXML
    public Label fxCurrentWindSpeed;
    @FXML
    public Label fxCurrentWindDirection;
    @FXML
    public Label fxCurrentPressure;
    @FXML
    public Label fxCurrentCloud;
    @FXML
    public Label fxCurrentHumidity;
    @FXML
    public Label fxConditionDayTime;
    @FXML
    public Label fxLocationCity;


    public void setCity() {
        String cityNormalized = Normalizer.normalize(fxTextFieldCity.getText(), Normalizer.Form.NFD);
        String city = cityNormalized.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
        fillLabels(WeatherService.getInstance().getWeatherAt(city));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fxLocationCity.setText("");
        fxLocationCountry.setText("");
        fxLocationRegion.setText("");
        fxLocationCoordinates.setText("");

        fxConditionDescription.setText("");
        fxConditionTemperature.setText("\u2103");
        fxConditionDayTime.setText("");

        fxCurrentWindSpeed.setText("");
        fxCurrentWindDirection.setText("");
        fxCurrentPressure.setText("");
        fxCurrentHumidity.setText("");
        fxCurrentCloud.setText("");
    }

    private void fillLabels(Weather weather){
        fxLocationCity.setText(weather.getLocation().getName());
        fxLocationCountry.setText(weather.getLocation().getCountry());
        fxLocationRegion.setText(weather.getLocation().getTzID());
        fxLocationCoordinates.setText(String.format("%s, %d", weather.getLocation().getLat(), weather.getLocation().getLon()));

        fxImageConditionIcon.setImage(new Image(String.format("http:%s", weather.getCurrent().getCondition().getIcon())));
        fxConditionDescription.setText(weather.getCurrent().getCondition().getText());
        fxConditionTemperature.setText(String.format("%d\u2103", weather.getCurrent().getTempC()));
        fxConditionDayTime.setText(weather.getCurrent().isDay() ? "Dzień" : "Noc");

        fxCurrentWindSpeed.setText(String.format("%s km/h", weather.getCurrent().getWindKph()));
        fxCurrentWindDirection.setText(String.format("%s (%d\u00B0)", weather.getCurrent().getWindDir(), weather.getCurrent().getWindDegree()));
        fxCurrentPressure.setText(String.format("%d hPa", weather.getCurrent().getPressureMB()));
        fxCurrentHumidity.setText(String.format("%d%%", weather.getCurrent().getHumidity()));
        fxCurrentCloud.setText(String.format("%d%%", weather.getCurrent().getCloud()));


    }
}
