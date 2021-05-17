import java.util.*;

public class CafeApp {
    public static void printMealType() {
        System.out.println("=== Select Breakfast or Lunch: ===");
        System.out.println("1. Breakfast");
        System.out.println("2. Lunch");
        System.out.print("Select Breakfast or Lunch [1, 2]: ");
    }
    public static void printCoffeeMenu() {
        System.out.println("=== Select Coffee: ===");
        System.out.println("1 Espresso      $3.50");
        System.out.println("2 Latte         $3.50");
        System.out.println("3 Cappuccino    $5.00");
        System.out.println("4 Cold Brew     $3.00");
        System.out.println("5 Quit Coffee selection");
        System.out.print("Select a coffee [1, 5]: ");
    }
    public static void printFoodMenu() {
        System.out.println("=== Select Food: ===");
        System.out.println("1 Tuna Sandwich      $10.00");
        System.out.println("2 Chicken Sandwich   $10.00");
        System.out.println("3 Burrito            $12.00");
        System.out.println("4 Yogurt Bowl        $8.00");
        System.out.println("5 Avocado Toast      $8.00");
        System.out.println("6 Quit Food selection");
        System.out.print("Select Food [1, 6]: ");
    }

    public static void main(String[] args) {
        // Scanner stuff
        Scanner scnr = new Scanner(System.in);

        // Create new CafeOrder
        CafeOrder cafeOrder = new CafeOrder();


        ////////////////////////////////////////
        ///   SELECTING BREAKFAST OR LUNCH   ///
        ////////////////////////////////////////
      
        // Declare variables
        int breakfastOrLunch = 0;
        boolean breakfastOrLunchSelected = false;

        // Print the Breakfast or Lunch menu
        printMealType();

        while(breakfastOrLunchSelected != true) {
            // Input validation
            try {
                breakfastOrLunch = scnr.nextInt();
                while ((breakfastOrLunch < 1) || (breakfastOrLunch > 2)) {
                    System.out.println("Error! Number must be greater than 0.");
                    System.out.print("Select Breakfast or Lunch [1, 2]: ");
                    breakfastOrLunch = scnr.nextInt();
                }
            }
            catch(InputMismatchException e) {
                System.out.println("Error! Number must be greater than 0.");
                System.out.print("Select Breakfast or Lunch [1, 2]: ");
                scnr.next();
                continue;
            }
            // If the code makes it to this stage, it means that the input is valid.
            // Assign breakfastOrLunch value into cafeOrder's mealType field.
            switch(breakfastOrLunch) {
                case 1:
                    cafeOrder.setMealType("Breakfast");
                    break;
                case 2:
                    cafeOrder.setMealType("Lunch");
                    break;
            }
            // Mark Meal Type selection as "finished"
            breakfastOrLunchSelected = true;
        }
        
        ////////////////////////////////////
        ///       SELECTING COFFEE       ///
        ////////////////////////////////////

        // Declare variables
        int coffeeSelection = 0;
        boolean coffeeSelected = false;

        while(coffeeSelected != true) {
            // Print out menu
            printCoffeeMenu();

            // Input validation
            try {
                coffeeSelection = scnr.nextInt();
                while ((coffeeSelection < 1) || (coffeeSelection > 5)) {
                    System.out.println("Error! Number must be greater than 0.");
                    System.out.print("Select a coffee [1, 5]: ");
                    coffeeSelection = scnr.nextInt();
                }
            }
            catch(InputMismatchException e) {
                System.out.println("Error! Number must be greater than 0.");
                System.out.print("Select a coffee [1, 5]: ");
                scnr.next();
                continue;
            }

            // Insert coffeeSelection value into coffee field within cafeOrder object
            // This chunk of code will only execute if the input is valid
            switch(coffeeSelection) {
                case 1:
                    cafeOrder.addCoffeeToOrder(1);
                    cafeOrder.addPrice(3.5);
                    break;
                case 2:
                    cafeOrder.addCoffeeToOrder(2);
                    cafeOrder.addPrice(3.5);                   
                    break;
                case 3:
                    cafeOrder.addCoffeeToOrder(3);
                    cafeOrder.addPrice(5.0);
                    break;
                case 4:
                    cafeOrder.addCoffeeToOrder(4);
                    cafeOrder.addPrice(3.0);
                    break;
                case 5:
                    coffeeSelected = true;
                    break;
            }          
        }

        ////////////////////////////////////
        ///        SELECTING FOOD        ///
        ////////////////////////////////////

        // Declare variables
        int foodSelection = 0;
        boolean foodSelected = false;

        while(foodSelected != true) {
            // Print out menu
            printFoodMenu();

            // Input validation
            try {
                foodSelection = scnr.nextInt();
                while ((foodSelection < 1) || (foodSelection > 6)) {
                    System.out.println("Error! Number must be greater than 0.");
                    System.out.print("Select Food [1, 6]: ");
                    foodSelection = scnr.nextInt();
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Error! Number must be greater than 0.");
                System.out.print("Select Food [1, 6]: ");
                scnr.next();
                continue;
            }

            // Insert foodSelection value into food field within cafeOrder object
            switch(foodSelection) {
                case 1:
                    cafeOrder.addFoodToOrder(1);
                    cafeOrder.addPrice(10.0);
                    break;
                case 2:
                    cafeOrder.addFoodToOrder(2);
                    cafeOrder.addPrice(10.0);
                    break;
                case 3:
                    cafeOrder.addFoodToOrder(3);
                    cafeOrder.addPrice(12.0);
                    break;
                case 4:
                    cafeOrder.addFoodToOrder(4);
                    cafeOrder.addPrice(8.0);
                    break;
                case 5:
                    cafeOrder.addFoodToOrder(5);
                    cafeOrder.addPrice(8.0);
                    break;
                case 6:
                    foodSelected = true;
                    break;
            }
        }
        
        //////////////////////////////////////////
        ///      ENTERING CUSTOMER'S NAME      ///
        //////////////////////////////////////////

        // Declare variables
        String customerName;
        boolean customerNameSubmitted = false;

        // Prompt for user input
        System.out.print("Enter customer's name: ");

        // Skip previous buffer thingy
        customerName = scnr.nextLine();

        while(customerNameSubmitted != true) {
            // Input validation
            try {
                customerName = scnr.nextLine();
            }
            catch (InputMismatchException e) {
                System.out.println("Error! Input must be a string: ");
                scnr.next();
                continue;
            }
            cafeOrder.setName(customerName);
            customerNameSubmitted = true;
        }
        
        // Assign coffeeCount and foodCount into cafeOrder

        // Print All
        cafeOrder.coffeeStringOutput();
        cafeOrder.foodStringOutput();
        cafeOrder.printAll();

        // Write to output
        cafeOrder.writeToOutput();

        scnr.close();
    }
}