import exception.EmployeeNotFoundException;
import exception.InvalidSalaryException;
import service.PayrollService;

import java.util.Scanner;

public class Main {
    static PayrollService payroll = new PayrollService();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║     EMPLOYEE PAYROLL SYSTEM v1.0     ║");
        System.out.println("╚══════════════════════════════════════╝");

        while (true) {
            printMenu();
            System.out.print("Enter choice: ");
            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1" -> addEmployee();
                case "2" -> removeEmployee();
                case "3" -> updateSalary();
                case "4" -> generatePayslip();
                case "5" -> payroll.listAllEmployees();
                case "6" -> listByDepartment();
                case "7" -> payroll.showPayrollSummary();
                case "8" -> {
                    System.out.println("Thank you for using Payroll System. Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice! Enter 1-8.");
            }
        }
    }

    static void printMenu() {
        System.out.println("\n==============================");
        System.out.println("  1. Add Employee");
        System.out.println("  2. Remove Employee");
        System.out.println("  3. Update Salary");
        System.out.println("  4. Generate Payslip");
        System.out.println("  5. List All Employees");
        System.out.println("  6. List By Department");
        System.out.println("  7. Payroll Summary");
        System.out.println("  8. Exit");
        System.out.println("==============================");
    }

    static void addEmployee() {
        try {
            System.out.print("Enter name        : ");
            String name = sc.nextLine().trim();
            System.out.print("Enter designation : ");
            String designation = sc.nextLine().trim();
            System.out.print("Enter department  : ");
            String department = sc.nextLine().trim();
            System.out.print("Enter basic pay   : ");
            double basicPay = Double.parseDouble(sc.nextLine().trim());
            payroll.addEmployee(name, designation, department, basicPay);
        } catch (InvalidSalaryException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid salary entered!");
        }
    }

    static void removeEmployee() {
        System.out.print("Enter Employee ID: ");
        String id = sc.nextLine().trim();
        try {
            payroll.removeEmployee(id);
        } catch (EmployeeNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void updateSalary() {
        System.out.print("Enter Employee ID  : ");
        String id = sc.nextLine().trim();
        System.out.print("Enter new basic pay: ");
        try {
            double salary = Double.parseDouble(sc.nextLine().trim());
            payroll.updateSalary(id, salary);
        } catch (EmployeeNotFoundException | InvalidSalaryException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid salary entered!");
        }
    }

    static void generatePayslip() {
        System.out.print("Enter Employee ID: ");
        String id = sc.nextLine().trim();
        try {
            payroll.generatePayslip(id);
        } catch (EmployeeNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void listByDepartment() {
        System.out.print("Enter department name: ");
        String dept = sc.nextLine().trim();
        payroll.listByDepartment(dept);
    }
}