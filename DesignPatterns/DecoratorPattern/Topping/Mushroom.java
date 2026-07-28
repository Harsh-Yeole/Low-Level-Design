package DecoratorPattern.Topping;
import DecoratorPattern.BasePizza.abstractBasePizza;
public class Mushroom extends abstractTopingDecorator {
    abstractBasePizza basePizza;
    public Mushroom(abstractBasePizza basePizza){
        this.basePizza=basePizza;
    }
    public int cost(){
        return basePizza.cost()+30;
    }
}
