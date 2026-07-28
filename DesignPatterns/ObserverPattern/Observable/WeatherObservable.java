package ObserverPattern.Observable;
import ObserverPattern.Observer.DisplayObserverInterface;
import java.util.ArrayList;
import java.util.List;
public class WeatherObservable implements WeatherObservableInterface {
    private float temperature;
    private List<DisplayObserverInterface> displayObservers;
    public WeatherObservable() {
        displayObservers = new ArrayList<>();
    }
    
    @Override
   public void add(DisplayObserverInterface displayObserver) {
        displayObservers.add(displayObserver);
    }
    
    @Override
    public void remove(DisplayObserverInterface displayObserver) {
        displayObservers.remove(displayObserver);
    }
    
    @Override
    public void notifyObservers() {
        for (DisplayObserverInterface observer : displayObservers) {
            observer.update();
        }
    }
    
    @Override
    public void setTemperature(float temperature) {
        this.temperature = temperature;
        notifyObservers();
    }
    
    @Override
    public void getTemperteture() {
        System.out.println("Current Temperature: " + temperature);
    }
    
}
