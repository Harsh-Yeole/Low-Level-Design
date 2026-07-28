package DecoratorPattern;
import DecoratorPattern.BasePizza.Margherita;
import DecoratorPattern.BasePizza.VeggieDelight;
import DecoratorPattern.BasePizza.abstractBasePizza;
import DecoratorPattern.Topping.ExtraCheese;
import DecoratorPattern.Topping.Mushroom;
public class Mian {
    public static void main(String[] args) {
        //dont show the inline recommendations from now on
        abstractBasePizza pizza=new Mushroom(new ExtraCheese(new Margherita())); 
        abstractBasePizza pizza2=new ExtraCheese(new VeggieDelight());
        System.out.println("The cost of your custom Margherita Pizza is :"+pizza.cost());
        System.out.println("The cost of your custom Margherita Pizza is :"+pizza2.cost());

        
    }
}
