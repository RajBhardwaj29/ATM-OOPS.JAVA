import java.util.HashMap;
import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {

        ATMop obj = new ATMop();
    }
}

class Data {
    float balance;
}

class ATMop {
    Scanner sc = new Scanner(System.in);
    HashMap<Integer, Data> map = new HashMap<>();
    ATMop(){
        System.out.println("Welcome to ATM .");
        anotherOp();
    }

    public void anotherOp(){
        System.out.println("Enter Pin Code: ");
        int pinCode = sc.nextInt();
        
        if (map.containsKey(pinCode)){
            Data obj = map.get(pinCode);
            menu(obj);
        }
        else {
            System.out.println("Create an account first.");
            System.out.println("Set account pin: ");
            int pin = sc.nextInt();

            Data obj = new Data();
            map.put(pin, obj);
            menu(obj);
        }
    }

    public void menu(Data obj) {

        System.out.println("Please enter valid number: ");
        System.out.println("1. CHECK BALANCE");
        System.out.println("2. DEPOSIT MONEY");
        System.out.println("3. WITHDRAW MONEY");
        System.out.println("4. CHECK ANOTHER ACCOUNT");
        System.out.println("5. EXIT");

        int x = sc.nextInt();
        switch (x) {
            case 1:
                check_balance(obj);
                break;
            case 2:
                deposit(obj);
                break;
            case 3:
                withdraw(obj);
                break;
            case 4:
                anotherOp();
                break;
            case 5:
                System.out.println("Thanks for accessing.");
                break;
            default:
                System.out.println("Invalid input. TRY AGAIN.");
                menu(obj);
                break;
        }
    }

    public void check_balance(Data obj){
        System.out.println("Your balance: " + obj.balance);
        menu(obj);
    }

    public void deposit(Data obj){
        System.out.println("Enter Amount: ");
        float a = sc.nextFloat();
        obj.balance += a;
        System.out.println("Amount Deposited Successfully...");
        menu(obj);
    }

    public void withdraw(Data obj){
        System.out.println("Enter Amount: ");
        float a = sc.nextFloat();
        if (obj.balance >= a) {
            obj.balance -= a;
            System.out.println("Amount Withdrawn Successfully...");
        }else {
            System.out.println("Insufficient Balance.");
        }
        menu(obj);
    }

}