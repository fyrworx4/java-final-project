import java.io.*;
import java.util.*;

public class CafeOrder {

    // Declare fields
    private String mealType;
    private Double price = 0.0;
    private String customerName;

    // Declare HashMaps
    private HashMap<String, Integer> coffeeCounts = new HashMap<String, Integer>();
    private HashMap<String, Integer> foodCounts = new HashMap<String, Integer>();

    // More Strings
    private String coffeeString = "";
    private String foodString = "";

    // Default constructor
    public CafeOrder() {
        coffeeCounts.put("Espresso", 0);
        coffeeCounts.put("Latte", 0);
        coffeeCounts.put("Cappuccino", 0);
        coffeeCounts.put("Cold Brew", 0);

        foodCounts.put("Tuna Sandwhich", 0);
        foodCounts.put("Chicken Sandwhich", 0);
        foodCounts.put("Burrito", 0);
        foodCounts.put("Yogurt Bowl", 0);
        foodCounts.put("Avacado Toast", 0);
    }

    // Mutators
    public void setMealType(String userMealType) {
        mealType = userMealType;
    }

    public void addCoffeeToOrder(int userCoffee) {
        switch(userCoffee) {
            case 1:
                coffeeCounts.put("Espresso", coffeeCounts.get("Espresso") + 1);
                break;
            case 2:
                coffeeCounts.put("Latte", coffeeCounts.get("Latte") + 1);
                break;
            case 3:
                coffeeCounts.put("Cappuccino", coffeeCounts.get("Cappuccino") + 1);
                break;
            case 4:
                coffeeCounts.put("Cold Brew", coffeeCounts.get("Cold Brew") + 1);
                break;
        }
    }

    public void addFoodToOrder(int userFood) {
        switch(userFood) {
            case 1:
                foodCounts.put("Tuna Sandwhich", foodCounts.get("Tuna Sandwhich") + 1);
                break;
            case 2:
                foodCounts.put("Chicken Sandwhich", foodCounts.get("Chicken Sandwhich") + 1);
                break;
            case 3:
                foodCounts.put("Burrito", foodCounts.get("Burrito") + 1);
                break;
            case 4:
                foodCounts.put("Yogurt Bowl", foodCounts.get("Yogurt Bowl") + 1);
                break;
            case 5:
                foodCounts.put("Avacado Toast", foodCounts.get("Avacado Toast") + 1);
                break;
        }
    }

    public void setName(String userName) {
        customerName = userName;
    }

    public void addPrice(Double foodItemPrice) {
        price += foodItemPrice;
    }

    // Create special strings for coffee and food orders
    public void coffeeStringOutput() {
        if(coffeeCounts.get("Espresso") > 0) {
            coffeeString += "Espresso(" + coffeeCounts.get("Espresso") + "), ";
        }
        if(coffeeCounts.get("Latte") > 0) {
            coffeeString += "Latte(" + coffeeCounts.get("Latte") + "), ";
        }
        if(coffeeCounts.get("Cappuccino") > 0) {
            coffeeString += "Cappuccino(" + coffeeCounts.get("Cappuccino") + "), ";
        }
        if(coffeeCounts.get("Cold Brew") > 0) {
            coffeeString += "Cold Brew(" + coffeeCounts.get("Cold Brew") + "), ";
        }
    }

    public void foodStringOutput() {
        if(foodCounts.get("Tuna Sandwhich") > 0) {
            foodString += "Tuna Sandwhich(" + foodCounts.get("Tuna Sandwhich") + "), ";
        }
        if(foodCounts.get("Chicken Sandwhich") > 0) {
            foodString += "Chicken Sandwhich(" + foodCounts.get("Chicken Sandwhich") + "), ";
        }
        if(foodCounts.get("Burrito") > 0) {
            foodString += "Burrito(" + foodCounts.get("Burrito") + "), ";
        }
        if(foodCounts.get("Yogurt Bowl") > 0) {
            foodString += "Yogurt Bowl(" + foodCounts.get("Yogurt Bowl") + "), ";
        }
        if(foodCounts.get("Avacado Toast") > 0) {
            foodString += "Avacado Toast(" + foodCounts.get("Avacado Toast") + "), ";
        }
    }

    
    // Method to print out the order
    public void printAll() {
        System.out.print(mealType + ", " + customerName + ", " + coffeeString + foodString);
        System.out.printf("$%.2f", price);
        System.out.println();
    }
   
    
    // Method to append order to output.txt
    public void writeToOutput() {
        try(
            FileWriter fw = new FileWriter("output.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw)
            )
        {
            out.print(mealType + ", " + customerName + ", " + coffeeString + foodString);
            out.printf("$%.2f", price);
            out.println();
        }
        catch (IOException e) {
            System.out.println("Caught IOException: " + e.getMessage());
        }
    }
}
