package save.data;

public class Food {
    String foodName;
    double price;

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String name) {
        foodName = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double d) {
        price = d ;
    }
    public int compareTo(Food food){
        return (int)(food.getPrice()*1000-price*1000);
    }
}
