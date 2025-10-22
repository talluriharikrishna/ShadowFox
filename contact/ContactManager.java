import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactManager {
    private static final List<Contact> contacts = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Simple Contact Manager - ShadowFox Intern Submission");
        boolean running = true;
        while (running) {
            printMenu();
            String option = sc.next().trim();
            switch (option) {
                case "1": addContact(); break;
                case "2": viewContacts(); break;
                case "3": updateContact(); break;
                case "4": deleteContact(); break;
                case "5": searchContact(); break;
                case "q":
                case "Q": running = false; break;
                default: System.out.println("Invalid option.");
            }
            System.out.println();
        }
        System.out.println("Exiting. Bye!");
    }

    private static void printMenu() {
        System.out.println("1) Add contact");
        System.out.println("2) View all contacts");
        System.out.println("3) Update contact (by name)");
        System.out.println("4) Delete contact (by name)");
        System.out.println("5) Search contact (by name)");
        System.out.println("Q) Quit");
        System.out.print("Choose: ");
    }

    private static void addContact() {
        sc.nextLine(); // consume newline
        System.out.print("Name: ");
        String name = sc.nextLine().trim();
        System.out.print("Phone: ");
        String phone = sc.nextLine().trim();
        System.out.print("Email: ");
        String email = sc.nextLine().trim();
        contacts.add(new Contact(name, phone, email));
        System.out.println("Contact added.");
    }

    private static void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts.");
            return;
        }
        int i = 1;
        for (Contact c : contacts) {
            System.out.println(i++ + ". " + c);
        }
    }

    private static Contact findByName(String name) {
        for (Contact c : contacts) {
            if (c.getName().equalsIgnoreCase(name)) return c;
        }
        return null;
    }

    private static void updateContact() {
        sc.nextLine();
        System.out.print("Enter name to update: ");
        String name = sc.nextLine().trim();
        Contact c = findByName(name);
        if (c == null) {
            System.out.println("Contact not found.");
            return;
        }
        System.out.print("New name (leave empty to keep): ");
        String newName = sc.nextLine().trim();
        if (!newName.isEmpty()) c.setName(newName);
        System.out.print("New phone (leave empty to keep): ");
        String newPhone = sc.nextLine().trim();
        if (!newPhone.isEmpty()) c.setPhone(newPhone);
        System.out.print("New email (leave empty to keep): ");
        String newEmail = sc.nextLine().trim();
        if (!newEmail.isEmpty()) c.setEmail(newEmail);
        System.out.println("Contact updated.");
    }

    private static void deleteContact() {
        sc.nextLine();
        System.out.print("Enter name to delete: ");
        String name = sc.nextLine().trim();
        Contact c = findByName(name);
        if (c == null) {
            System.out.println("Contact not found.");
            return;
        }
        contacts.remove(c);
        System.out.println("Contact deleted.");
    }

    private static void searchContact() {
        sc.nextLine();
        System.out.print("Enter name to search: ");
        String name = sc.nextLine().trim();
        boolean found = false;
        for (Contact c : contacts) {
            if (c.getName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println(c);
                found = true;
            }
        }
        if (!found) System.out.println("No matching contacts.");
    }
}
