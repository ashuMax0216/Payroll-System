package model;

import exception.InvalidSalaryException;

public class Employee {
    private String employeeId;
    private String name;
    private String designation;
    private String department;
    private double basicPay;

    public Employee(String employeeId, String name, String designation,
                    String department, double basicPay) throws InvalidSalaryException {
        if (basicPay <= 0) throw new InvalidSalaryException(
            "Basic pay must be greater than 0!");
        this.employeeId  = employeeId;
        this.name        = name;
        this.designation = designation;
        this.department  = department;
        this.basicPay    = basicPay;
    }

    public void updateSalary(double newBasicPay) throws InvalidSalaryException {
        if (newBasicPay <= 0) throw new InvalidSalaryException(
            "New salary must be greater than 0!");
        this.basicPay = newBasicPay;
        System.out.println("Salary updated successfully for " + name);
    }

    public Payslip generatePayslip() {
        return new Payslip(employeeId, basicPay);
    }

    public void displayInfo() {
        System.out.println("--------------------------------------");
        System.out.println("ID          : " + employeeId);
        System.out.println("Name        : " + name);
        System.out.println("Designation : " + designation);
        System.out.println("Department  : " + department);
        System.out.printf ("Basic Pay   : Rs. %.2f%n", basicPay);
        System.out.println("--------------------------------------");
    }

    // Getters
    public String getEmployeeId()  { return employeeId; }
    public String getName()        { return name; }
    public String getDesignation() { return designation; }
    public String getDepartment()  { return department; }
    public double getBasicPay()    { return basicPay; }
}