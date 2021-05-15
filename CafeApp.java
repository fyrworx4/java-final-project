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


        while (breakfastOrLunchSelected != true) {
            // Input validation
            try {
                breakfastOrLunch = scnr.nextInt();
                while ((breakfastOrLunch < 1) || (breakfastOrLunch > 2)) {
                    System.out.println("Error! Number must be greater than 0.");
                    System.out.print("Select Breakfast or Lunch [1, 2]: ");
                    breakfastOrLunch = scnr.nextInt();
                }
            }
            catch (InputMismatchException e) {
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
        int previousCoffeeSelection = 0;
        int coffeeCount = 0;
        boolean coffeeSelected = false;

        // Print out menu
        printCoffeeMenu();


        while (coffeeSelected != true) {
            // Input validation
            try {
                coffeeSelection = scnr.nextInt();
                while ((coffeeSelection < 1) || (coffeeSelection > 5)) {
                    System.out.println("Error! Number must be greater than 0.");
                    System.out.print("Select a coffee [1, 5]: ");
                    coffeeSelection = scnr.nextInt();
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Error! Number must be greater than 0.");
                System.out.print("Select a coffee [1, 5]: ");
                scnr.next();
                continue;
            }
            // Assign previousCoffeeSelection to coffeeSelection's value for comparison, only for the 1st coffee selection
            if (previousCoffeeSelection == 0) {
                previousCoffeeSelection = coffeeSelection;
            }
            // This only runs when the coffee selected is the same as the previous one
            if (coffeeSelection == previousCoffeeSelection) {
                // Insert coffeeSelection value into coffee field within cafeOrder object
                switch(coffeeSelection) {
                    case 1:
                        cafeOrder.setCoffee("Espresso");
                        cafeOrder.addPrice(3.5);
                        break;
                    case 2:
                        cafeOrder.setCoffee("Latte");
                        cafeOrder.addPrice(3.5);
                        break;
                    case 3:
                        cafeOrder.setCoffee("Cappuccino");
                        cafeOrder.addPrice(5.0);
                        break;
                    case 4:
                        cafeOrder.setCoffee("Cold Brew");
                        cafeOrder.addPrice(3.0);
                        break;
                }
                coffeeCount += 1;
                // Reprint coffee menu for multiple orders
                printCoffeeMenu();
            }
            else if (coffeeSelection == 5) {
                coffeeSelected = true;
            }
            else {
                System.out.println("You must select the same type of coffee. You have selected #" + previousCoffeeSelection);
                System.out.print("Select a coffee [1, 5]: ");
            }            
        }

        ////////////////////////////////////
        ///        SELECTING FOOD        ///
        ////////////////////////////////////

        // Declare variables
        int foodSelection = 0;
        int previousFoodSelection = 0;
        int foodCount = 0;
        boolean foodSelected = false;

        // Print food menu
        printFoodMenu();

        while (foodSelected != true) {
            // Input validation
            try {
                foodSelection = scnr.nextInt();
                while ((foodSelection < 1) || (foodSelection > 6)) {
                    System.out.println("Error! Number must be greater than 0.");
                    System.out.print("Select Food [1, 6]: ");
                    coffeeSelection = scnr.nextInt();
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Error! Number must be greater than 0.");
                System.out.print("Select Food [1, 6]: ");
                scnr.next();
                continue;
            }
            // Like before, this only runs the first time. previousFoodSelection only gets assigned once
            if (previousFoodSelection == 0) {
                previousFoodSelection = foodSelection;
            }
            // This will run only if the current foodSelection matches the previous one
            if (foodSelection == previousFoodSelection) {
                // Insert foodSelection value into food field within cafeOrder object
                switch(foodSelection) {
                    case 1:
                        cafeOrder.setFood("Tuna Sandwich");
                        cafeOrder.addPrice(10.0);
                        break;
                    case 2:
                        cafeOrder.setFood("Chicken Sandwich");
                        cafeOrder.addPrice(10.0);
                        break;
                    case 3:
                        cafeOrder.setFood("Burrito");
                        cafeOrder.addPrice(12.0);
                        break;
                    case 4:
                        cafeOrder.setFood("Yogurt Bowl");
                        cafeOrder.addPrice(8.0);
                        break;
                    case 5:
                        cafeOrder.setFood("Avocado Toast");
                        cafeOrder.addPrice(8.0);
                        break;
                }
                foodCount += 1;
                // Reprint food menu for multiple orders
                printFoodMenu();
            }
            else if (foodSelection == 6) {
                foodSelected = true;
            }
            else {
                System.out.println("You must select the same type of meal. You have selected #" + previousFoodSelection);
                System.out.print("Select Food [1, 6]: ");
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

        while (customerNameSubmitted != true) {
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
        cafeOrder.setCoffeeCount(coffeeCount);
        cafeOrder.setFoodCount(foodCount);

        // Print All
        cafeOrder.printAll();

        // Write to output
        cafeOrder.writeToOutput();

        scnr.close();
    }
}