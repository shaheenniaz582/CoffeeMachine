import java.util.Scanner;
import java.lang.String;

public class CoffeeMachine {
    // Instance variables

    private int water;
    private int milk;
    private int beans;
    private int cups;
    private int money;

    // Constructor

    public CoffeeMachine(int water, int milk, int beans, int cups, int money) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cups = cups;
        this.money = money;
    }

    // methods

    public void fill() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("Write how many ml of water do you want to add:");
        int newWater = scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        int newMilk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        int newBeans = scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        int newCups = scanner.nextInt();
        this.water += newWater;
        this.milk += newMilk;
        this.beans += newBeans;
        this.cups += newCups;
    }

    public void remaining() {
        System.out.println();
        System.out.print("The coffee machine has:\n" +
                this.water + " of water\n" +
                this.milk + " of milk\n" +
                this.beans + " of coffee beans\n" +
                this.cups + " of disposable cups\n" +
                "$" + this.money + " of money\n");
    }

    public void take() {
        System.out.println();
        System.out.print("I gave you $" + this.money);
        System.out.println();
        this.money = 0;
    }

    public void buy(String choice){
        switch (choice) {
            case "1":
                if (this.water < 250 ) {
                    System.out.println("Sorry, not enough water!");
                } else if (this.beans < 16) {
                    System.out.println("Sorry, not enough beans!");
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    this. water -= 250;
                    this.beans -= 16;
                    this.money += 4;
                    this.cups -= 1;
                }
                break;
            case "2":
                if (this.water < 350 ) {
                    System.out.println("Sorry, not enough water!");
                } else if (this.beans < 20) {
                    System.out.println("Sorry, not enough beans!");
                } else if(this.milk < 75) {
                    System.out.println("Sorry, not enough milk!");
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    this. water -= 350;
                    this.milk -= 75;
                    this.beans -= 20;
                    this.money += 7;
                    this.cups -= 1;
                }
                break;
            case "3":
                if (this.water < 200 ) {
                    System.out.println("Sorry, not enough water!");
                } else if (this.beans < 12) {
                    System.out.println("Sorry, not enough beans!");
                } else if(this.milk < 100) {
                    System.out.println("Sorry, not enough milk!");
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    this. water -= 200;
                    this.milk -= 100;
                    this.beans -= 12;
                    this.money += 6;
                    this.cups -= 1;
                }
                break;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        CoffeeMachine coffeeMachine = new CoffeeMachine(400, 540, 120, 9, 550);

        do {
            System.out.println();
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            input = scanner.next();
            switch (input) {
                case "buy":
                    System.out.println();
                    System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: \n");
                    String choice = scanner.next();
                    coffeeMachine.buy(choice);
                    break;
                case "fill":
                    coffeeMachine.fill();
                    break;
                case "take":
                    coffeeMachine.take();
                    break;
                case "remaining":
                    coffeeMachine.remaining();
                    break;
            }
        } while (!input.equals("exit"));
    }
}
