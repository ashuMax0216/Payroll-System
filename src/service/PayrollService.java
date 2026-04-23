package service;

import exception.EmployeeNotFoundException;
import exception.InvalidSalaryException;
import model.Employee;
import model.Payslip;

import java.util.HashMap;
import java.util.Map;

public class PayrollService {
    private Map<String, Employee> employees = new HashMap<>();
    private int empCounter = 1000;

    public Employee addEmployee(String name, String designation,
                                String department, double basicPay)
                                throws InvalidSalaryException {
        String id = "EMP" + (++empCounter);
        Employee emp = new Employee(id, name, designation, department, basicPay);
        employees.put(id, emp);
        System.out.println("Employee added successfully! ID: " + id);
        FileHandler.log("ADD_EMPLOYEE", id, "Name: " + name +
                        ", Designation: " + designation);
        return emp;
    }

    public Employee getEmployee(String id) throws EmployeeNotFoundException {
        Employee emp = employees.get(id);
        if (emp == null) throw new EmployeeNotFoundException(
            "Employee not found with ID: " + id);
        return emp;
    }

    public void removeEmployee(String id) throws EmployeeNotFoundException {
        Employee emp = getEmployee(id);
        employees.remove(id);
        System.out.println("Employee " + emp.getName() + " removed successfully.");
        FileHandler.log("REMOVE_EMPLOYEE", id, "Name: " + emp.getName());
    }

    public void updateSalary(String id, double newSalary)
            throws EmployeeNotFoundException, InvalidSalaryException {
        Employee emp = getEmployee(id);
        double oldSalary = emp.getBasicPay();
        emp.updateSalary(newSalary);
        FileHandler.log("SALARY_UPDATE", id,
            "Old: " + oldSalary + " -> New: " + newSalary);
    }

    public void generatePayslip(String id) throws EmployeeNotFoundException {
        Employee emp = getEmployee(id);
        Payslip payslip = emp.generatePayslip();
        payslip.printPayslip(emp.getName(), emp.getDesignation());
        FileHandler.log("PAYSLIP_GENERATED", id,
            "Net Salary: " + payslip.getNetSalary());
    }

    public void listAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }
        System.out.println("\n===== ALL EMPLOYEES =====");
        for (Employee emp : employees.values()) {
            emp.displayInfo();
        }
    }

    public void listByDepartment(String department) {
        System.out.println("\n===== DEPARTMENT: " + department + " =====");
        boolean found = false;
        for (Employee emp : employees.values()) {
            if (emp.getDepartment().equalsIgnoreCase(department)) {
                emp.displayInfo();
                found = true;
            }
        }
        if (!found) System.out.println("No employees found in this department.");
    }

    public void showPayrollSummary() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }
        double totalBasic = 0, totalNet = 0;
        System.out.println("\n===== PAYROLL SUMMARY =====");
        System.out.printf("%-10s %-15s %-12s %-12s%n",
            "ID", "Name", "Basic Pay", "Net Salary");
        System.out.println("-".repeat(52));
        for (Employee emp : employees.values()) {
            Payslip p = emp.generatePayslip();
            System.out.printf("%-10s %-15s %-12.2f %-12.2f%n",
                emp.getEmployeeId(), emp.getName(),
                emp.getBasicPay(), p.getNetSalary());
            totalBasic += emp.getBasicPay();
            totalNet   += p.getNetSalary();
        }
        System.out.println("-".repeat(52));
        System.out.printf("%-10s %-15s %-12.2f %-12.2f%n",
            "", "TOTAL", totalBasic, totalNet);
    }
}
