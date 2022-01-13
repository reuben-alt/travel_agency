package fr.lernejo.travelsite;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@org.springframework.stereotype.Service
public class Service {

    public final PredictionEngineClient predictionEngineClient;

    public Service(PredictionEngineClient predictionEngineClient) {
        this.predictionEngineClient = predictionEngineClient;
    }

    private List<Temperature> getTemperaturesFromCountryList(List<String> countries) {
        List<Temperature> temp = new ArrayList<>();
        for (int i = 0; i < countries.size(); i++) {
            Temperature t = getTemp(countries.get(i));
            if (t != null) temp.add(t);
        } return temp;
    }
        public List<String> readCountryFromFile () {
            try {
                InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("countries.txt");
                String content = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
                Stream<String> lines = content.lines();
                return lines.filter(e -> e != null).toList();
            } catch (IOException e) {return null;}
        }

        public Temperature getTemp (String country){
            try {
                return this.predictionEngineClient.temperature(country).execute().body();
            } catch (IOException e) {e.printStackTrace();}
            return null;
        }


        public List<Destination> getTravel (Inscription inscription){
            List<Destination> destinationsList = new ArrayList<>();List<Temperature> allTemp = getTemperaturesFromCountryList(readCountryFromFile());
            Temperature tempUser = getTemp(inscription.userCountry());
            double moyTempUser = ((tempUser != null) ? (tempUser.temperatures.get(0).temperature.doubleValue() + tempUser.temperatures.get(1).temperature.doubleValue()) / 2 : 9999.9999);
            if (allTemp.size() != 0 && moyTempUser != 9999.9999)
                for (int i = 0 ; i < allTemp.size() ; i++){
                    if (allTemp.get(i) != null){
                        double tempAveerage =  (allTemp.get(i).temperatures.get(0).temperature.doubleValue() + allTemp.get(i).temperatures.get(1).temperature.doubleValue() )/ 2 ;
                        if (inscription.weatherExpectation().equals(WeatherExpectation.COLDER.toString())){
                            if( (moyTempUser - inscription.minimumTemperatureDistance()) >= tempAveerage) destinationsList.add(new Destination(allTemp.get(i).country , tempAveerage));
                        }else{
                            if ( (moyTempUser + inscription.minimumTemperatureDistance()) <= tempAveerage) destinationsList.add(new Destination(allTemp.get(i).country,tempAveerage));}
                    }
                }
            return destinationsList;
        }
    }

