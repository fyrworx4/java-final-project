import java.io.*;

public class CafeOrderBackup {

    // Declare fields
    private String mealType;
    private String coffee;
    private int coffeeCount;
    private String food;
    private int foodCount;
    private Double price;
    private String customerName;

    // Default constructor
    CafeOrderBackup() {
        mealType = "";
        coffee = "";
        food = "";
        price = 0.0;
        customerName = "";
    }

    // Setters
    public void setMealType(String userMealType) {
        mealType = userMealType;
    }

    public void setCoffee(String userCoffee) {
        coffee = userCoffee;
    }

    public void setCoffeeCount(int userCoffeeCount) {
        coffeeCount = userCoffeeCount;
    }

    public void setFood(String userFood) {
        food = userFood;
    }

    public void setFoodCount(int userFoodCount) {
        foodCount = userFoodCount;
    }
    public void setName(String userName) {
        customerName = userName;
    }

    // Do things with the price
    public void addPrice(Double foodItemPrice) {
        price += foodItemPrice;
    }

    public Double getPrice() {
        return price;
    }

    // Method to print out the order
    public void printAll() {
        System.out.print(mealType + ", " + customerName + ", " + coffee + "(" + coffeeCount + "), " + food + "(" + foodCount + "), ");
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
            out.print(mealType + ", " + customerName + ", " + coffee + "(" + coffeeCount + "), " + food + "(" + foodCount + "), ");
            out.printf("$%.2f", price);
            out.println();
        }
        catch (IOException e) {
            System.out.println("Caught IOException: " + e.getMessage());
        }
    }
}
