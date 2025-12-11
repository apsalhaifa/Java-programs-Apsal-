package COLLECTION;

import java.util.ArrayList;
import java.util.Scanner;

// Applicant class
class Applicant {
    int id;
    String name;
    double experience;

    Applicant(int id, String name, double experience) {
        this.id = id;
        this.name = name;
        this.experience = experience;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Experience: " + experience + " years";
    }
}

// Main class
public class Task1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Applicant> shortlisted = new ArrayList<>();
        ArrayList<Applicant> rejected = new ArrayList<>();

        while (true) {

            System.out.print("Enter Applicant ID: ");
            int id = sc.nextInt();
            sc.nextLine(); // consume newline

            System.out.print("Enter Applicant Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Years of Experience: ");
            double exp = sc.nextDouble();

            Applicant applicant = new Applicant(id, name, exp);

            if (exp >= 2) {
                shortlisted.add(applicant);
            } else {
                rejected.add(applicant);
            }

            System.out.print("Do you want to enter another applicant? (yes/no): ");
            sc.nextLine();
            String choice = sc.nextLine().toLowerCase();

            if (!choice.equals("yes")) {
                break;
            }
        }

        System.out.println("\n===== Shortlisted Applicants =====");
        for (Applicant a : shortlisted) {
            System.out.println(a);
        }

        System.out.println("\n===== Rejected Applicants =====");
        for (Applicant a : rejected) {
            System.out.println(a);
        }

        sc.close();
    }
}
