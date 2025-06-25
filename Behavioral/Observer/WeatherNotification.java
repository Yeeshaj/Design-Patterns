package Behavioral.Observer;

import java.util.*;

public class WeatherNotification {

    public static void main(String args[]) {

        WeatherStation station = new WeatherStation();
        Observer tvdisplay = new TVDisplay();
        Observer phonedisplay = new PhoneDisplay();

        station.addObserver(tvdisplay);
        station.addObserver(phonedisplay);

        station.setTemperature(100);
    }

    
}
interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyAllObserver();
}

class WeatherStation implements Subject {

    private List<Observer> observers;
    float temperature;

    WeatherStation() {
        this.observers = new ArrayList<>();
    }
    
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyAllObserver() {
       for(Observer observer : observers) {
        observer.update(temperature);
       }
    }

    void setTemperature(float temperature){
        this.temperature = temperature;
        notifyAllObserver();
    }

}

interface Observer {
    void update(float temperature);
}

class PhoneDisplay implements Observer {

    @Override
    public void update(float temperature) {
        System.out.println("Phone Display: Temperature updated to "+temperature+"°C");
    }

}

class TVDisplay implements Observer {

    public void update(float temperature) {
        System.out.println("TV Display: Temperature updated to "+temperature+"°C");
    }
}