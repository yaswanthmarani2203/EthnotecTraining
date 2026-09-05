
package ethnotec.Basics.HungerBox;

import java.util.ArrayList;

interface Orderable
{
    public double getPrice();
    public String getDescription();
    public void prepare();
}
interface Discounts
{
    public double applyDiscount(double discount);
}
abstract class MenuItems implements Orderable, Discounts
{
    private String name;
    private double price;
    int totalOrders=0;
    private String category;
    public MenuItems(String name, double price, String category)
    {
        this.name = name;
        this.price = price;
        this.category = category;
    }
    public String getName()
    {
        return name;
    }
    public void setname()
    {
        this.name = name;
    }
    public double getPrice()
    {
        return price;
    }
    public void setPrice(double price)
    {
        this.price = price;
    }
    public String getCategory()
    {
        return category;
    }
    public void setCategory(String category)
    {
        this.category = category;
    }
    public String getDescription()
    {
        return "The MenuItem" +getName()+"Of price"+getPrice()+"And the Cash";
    }
    public double applyDiscount(double discount)
    {
        return price = discount/100*price;
    }
    public abstract void prepare();
}
class VegItems extends MenuItems
{
    boolean isJain;
    public VegItems(String name, double price)
    {
        super(name,price,category"Veg");
        isJain = false;
    }
}

class Res
{
    private String name;
    private  String address;
    ArrayList<MenuItems>items;
}

public class HungerBox {

    public static void main(String[] args) {

    }

}
