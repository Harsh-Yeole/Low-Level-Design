package DecoratorPattern.Topping;
import DecoratorPattern.BasePizza.abstractBasePizza;
public class ExtraCheese extends abstractTopingDecorator {
    abstractBasePizza basePizza;
    public ExtraCheese(abstractBasePizza basePizza){
        this.basePizza=basePizza;
    }
    public int cost(){
        return basePizza.cost()+50;
    }
    
}
