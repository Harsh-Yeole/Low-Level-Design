package ObserverPattern.Observable;
import ObserverPattern.Observer.DisplayObserverInterface;
public interface WeatherObservableInterface {
    public void add(DisplayObserverInterface displayObserver);
    public void remove(DisplayObserverInterface displayObserver);
    public void notifyObservers();
    public void setTemperature(float temperature);
    public void getTemperteture();
} 
