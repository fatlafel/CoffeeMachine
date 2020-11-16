package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static int water = 400;
    static int milk = 540;
    static int beans = 120;
    static int cups = 9;
    static int money = 550;

    public static void showIngredients() {
        System.out.println("\nThe coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println("\u0024" + money + " of money");
    }

    public static void buyCoffee(int water, int milk, int coffeeBeans, int cost) {
        CoffeeMachine.water -= water;
        CoffeeMachine.milk -= milk;
        CoffeeMachine.beans -= coffeeBeans;
        CoffeeMachine.money += cost;
        cups--;
    }

    public static int getEnoughIngredientStatus(int water, int milk, int coffeeBeans) {
        /*  0: enough Ingredients
            1: water needed
            2: milk needed
            3: Beans needed
            4: cups needed  */
        if (CoffeeMachine.water - water < 0) {
            return 1;
        }
        if (CoffeeMachine.milk - milk < 0) {
            return 2;
        }
        if (CoffeeMachine.beans - coffeeBeans < 0) {
            return 3;
        }
        if (cups - 1 < 0) {
            return 4;
        }
        return 0;
    }

    public static boolean isEnoughResources(int status) {
        switch (status) {
            case 0:
                System.out.println("I have enough resources, making you a coffee!");
                return true;
            case 1:
                System.out.println("Sorry, not enough water!");
                return false;
            case 2:
                System.out.println("Sorry, not enough milk!");
                return false;
            case 3:
                System.out.println("Sorry, not enough coffee beans!");
                return false;
            case 4:
                System.out.println("Sorry, not enough cups!");
                return false;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
            switch (scanner.next()) {
                case "buy":
                    System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                    String coffee = scanner.next();
                    switch (coffee) {
                        case "1":
                            if (isEnoughResources(getEnoughIngredientStatus(250, 0, 16))) {
                                buyCoffee(250, 0, 16, 4);
                            }
                            break;
                        case "2":
                            if (isEnoughResources(getEnoughIngredientStatus(350, 75, 20))) {
                                buyCoffee(350, 75, 20, 7);
                            }
                            break;
                        case "3":
                            if (isEnoughResources(getEnoughIngredientStatus(200, 100, 12))) {
                                buyCoffee(200, 100, 12, 6);
                            }
                            break;
                        case "back":
                            break;
                    }
                    break;
                case "fill":
                    System.out.println("\nWrite how many ml of water do you want to add:");
                    water += scanner.nextInt();
                    System.out.println("Write how many ml of milk do you want to add:");
                    milk += scanner.nextInt();
                    System.out.println("Write how many grams of coffee beans do you want to add:");
                    beans += scanner.nextInt();
                    System.out.println("Write how many disposable cups of coffee do you want to add:");
                    cups += scanner.nextInt();
                    break;
                case "take":
                    System.out.println("\nI gave you \u0024" + money);
                    money = 0;
                    break;
                case "remaining":
                    showIngredients();
                    break;
                case "exit":
                    System.exit(0);
                default:
                    System.out.println("Unknown command. Try again.");
                    break;
            }
        }
    }
}
