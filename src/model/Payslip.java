package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Payslip {
    private String employeeId;
    private double basicPay;
    private double hra;          // House Rent Allowance (20% of basic)
    private double da;           // Dearness Allowance (10% of basic)
    private double taxDeduction; // Tax (10% of basic)
    private double pfDeduction;  // Provident Fund (5% of basic)
    private double netSalary;
    private String generatedOn;

    public Payslip(String employeeId, double basicPay) {
        this.employeeId  = employeeId;
        this.basicPay    = basicPay;
        this.hra         = basicPay * 0.20;
        this.da          = basicPay * 0.10;
        this.taxDeduction= basicPay * 0.10;
        this.pfDeduction = basicPay * 0.05;
        this.netSalary   = basicPay + hra + da - taxDeduction - pfDeduction;
        this.generatedOn = LocalDateTime.now()
            .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public void printPayslip(String employeeName, String designation) {
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║           SALARY PAYSLIP             ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.printf( "║  Employee  : %-23s║%n", employeeName);
        System.out.printf( "║  ID        : %-23s║%n", employeeId);
        System.out.printf( "║  Designation: %-22s║%n", designation);
        System.out.printf( "║  Generated : %-23s║%n", generatedOn);
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║           EARNINGS                   ║");
        System.out.printf( "║  Basic Pay : Rs. %-20.2f║%n", basicPay);
        System.out.printf( "║  HRA (20%%) : Rs. %-20.2f║%n", hra);
        System.out.printf( "║  DA  (10%%) : Rs. %-20.2f║%n", da);
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║           DEDUCTIONS                 ║");
        System.out.printf( "║  Tax (10%%) : Rs. %-20.2f║%n", taxDeduction);
        System.out.printf( "║  PF  (5%%)  : Rs. %-20.2f║%n", pfDeduction);
        System.out.println("╠══════════════════════════════════════╣");
        System.out.printf( "║  NET SALARY: Rs. %-20.2f║%n", netSalary);
        System.out.println("╚══════════════════════════════════════╝");
    }

    // Getters
    public double getNetSalary()    { return netSalary; }
    public double getBasicPay()     { return basicPay; }
    public double getTaxDeduction() { return taxDeduction; }
    public double getPfDeduction()  { return pfDeduction; }
    public String getGeneratedOn()  { return generatedOn; }
}