package ObserverPattern.Observer;
import ObserverPattern.Observable.WeatherObservableInterface;
public class MobileDisplayObserver implements DisplayObserverInterface {
    WeatherObservableInterface weatherObserver;
    public MobileDisplayObserver(WeatherObservableInterface weatherObserver) {
        this.weatherObserver = weatherObserver;
    }
    public void update() {
        weatherObserver.getTemperteture();
    }
    
}
