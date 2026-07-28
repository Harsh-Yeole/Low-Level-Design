package ObserverPattern;
import ObserverPattern.Observable.WeatherObservableInterface;
import ObserverPattern.Observable.WeatherObservable;
import ObserverPattern.Observer.MobileDisplayObserver;
import ObserverPattern.Observer.DisplayObserverInterface;
public class Main {
    public static void main(String[] args) {
        WeatherObservableInterface broadcaster = new WeatherObservable();
        float t=27.00f;
        broadcaster.setTemperature(t);
        DisplayObserverInterface m1=new MobileDisplayObserver(broadcaster) ;
        broadcaster.add(m1);
        t=29.50f;
        broadcaster.setTemperature(t);
    }
}
