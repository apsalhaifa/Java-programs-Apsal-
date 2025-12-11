package COLLECTION;
import java.util.ArrayList;
import java.util.Scanner;

public class Task2 {
	

}
package COLLECTION;

import java.util.ArrayList;
import java.util.Scanner;

// Customer class
class Customer {
    int id;
    String name;
    double salary;

    Customer(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: ₹" + salary;
    }
}

// Main class

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Customer> eligibleList = new ArrayList<>();
        ArrayList<Customer> notEligibleList = new ArrayList<>();

        while (true) {

            System.out.print("Enter Customer ID: ");
            int id = sc.nextInt();
            sc.nextLine(); // remove newline

            System.out.print("Enter Customer Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Monthly Salary: ");
            double salary = sc.nextDouble();

            Customer cust = new Customer(id, name, salary);

            // Eligibility rule
            if (salary >= 25000) {
                eligibleList.add(cust);
            } else {
                notEligibleList.add(cust);
            }

            System.out.print("Do you want to enter another customer? (yes/no): ");
            sc.nextLine();
            String repeat = sc.nextLine().toLowerCase();

            if (!repeat.equals("yes")) {
                break;
            }
        }

        // Display results
        System.out.println("\n===== Eligible Customers =====");
        for (Customer c : eligibleList) {
            System.out.println(c);
        }

        System.out.println("\n===== Not Eligible Customers =====");
        for (Customer c : notEligibleList) {
            System.out.println(c);
        }

        sc.close();
    }
}
