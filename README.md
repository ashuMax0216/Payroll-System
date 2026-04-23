# 💼 Employee Payroll System

A menu-driven CLI-based Employee Payroll System built in Java, designed to manage employee records and automate salary calculations with earnings and deductions.

---

## 🛠️ Tech Stack

| Technology | Usage |
|---|---|
| Java | Core programming language |
| OOP | Classes, Objects, Encapsulation |
| Collections | HashMap, ArrayList |
| Exception Handling | Custom exceptions for validation |
| File Handling | Transaction logging to file |

---

## 📁 Project Structure

```
PayrollSystem/
├── src/
│   ├── exception/
│   │   ├── EmployeeNotFoundException.java
│   │   └── InvalidSalaryException.java
│   ├── model/
│   │   ├── Employee.java
│   │   └── Payslip.java
│   ├── service/
│   │   ├── PayrollService.java
│   │   └── FileHandler.java
│   └── Main.java
├── payroll_log.txt         ← auto-generated on first run
└── README.md
```

---

## ✨ Features

- ✅ Add new employees with designation and department
- ✅ Remove employees by ID
- ✅ Update employee salary
- ✅ Generate formatted payslip with earnings & deductions
- ✅ List all employees
- ✅ Filter employees by department
- ✅ Payroll summary with total basic pay and net salary
- ✅ All actions logged to `payroll_log.txt`
- ✅ Input validation with custom exceptions

---

## 💰 Salary Calculation Logic

| Component | Calculation |
|---|---|
| Basic Pay | User defined |
| HRA (House Rent Allowance) | 20% of Basic Pay |
| DA (Dearness Allowance) | 10% of Basic Pay |
| Tax Deduction | 10% of Basic Pay |
| PF Deduction | 5% of Basic Pay |
| **Net Salary** | **Basic + HRA + DA - Tax - PF** |

---

## 🚀 How to Run

### Prerequisites
- Java JDK 17 or above → [Download here](https://adoptium.net)
- VS Code with Extension Pack for Java → [Download here](https://code.visualstudio.com)

### Steps

**1. Clone the repository**
```bash
git clone https://github.com/yourusername/PayrollSystem.git
cd PayrollSystem
```

**2. Open in VS Code**
```bash
code .
```

**3. Run the project**
- Open `Main.java`
- Click the ▶ Run button (top right)
- OR press `Ctrl + F5`

---

## 📋 Menu Options

```
==============================
  1. Add Employee
  2. Remove Employee
  3. Update Salary
  4. Generate Payslip
  5. List All Employees
  6. List By Department
  7. Payroll Summary
  8. Exit
==============================
```

---

## 🧪 Sample Output

```
╔══════════════════════════════════════╗
║           SALARY PAYSLIP             ║
╠══════════════════════════════════════╣
║  Employee  : Rahul Sharma            ║
║  ID        : EMP1001                 ║
║  Designation: Software Engineer      ║
║  Generated : 2026-04-21 10:00:00     ║
╠══════════════════════════════════════╣
║           EARNINGS                   ║
║  Basic Pay : Rs. 50000.00            ║
║  HRA (20%) : Rs. 10000.00            ║
║  DA  (10%) : Rs. 5000.00             ║
╠══════════════════════════════════════╣
║           DEDUCTIONS                 ║
║  Tax (10%) : Rs. 5000.00             ║
║  PF  (5%)  : Rs. 2500.00             ║
╠══════════════════════════════════════╣
║  NET SALARY: Rs. 57500.00            ║
╚══════════════════════════════════════╝
```

---

## ⚠️ Exception Handling

| Exception | Trigger |
|---|---|
| `EmployeeNotFoundException` | Invalid employee ID entered |
| `InvalidSalaryException` | Salary entered is zero or negative |
| `NumberFormatException` | Non-numeric value entered for salary |

---

## 📝 Log File Sample (`payroll_log.txt`)

```
[2026-04-21 10:00:00] ADD_EMPLOYEE | EMP_ID: EMP1001 | Name: Rahul, Designation: Engineer
[2026-04-21 10:01:00] PAYSLIP_GENERATED | EMP_ID: EMP1001 | Net Salary: 57500.0
[2026-04-21 10:02:00] SALARY_UPDATE | EMP_ID: EMP1001 | Old: 50000.0 -> New: 60000.0
```

---

## 🔮 Future Enhancements

- [ ] MySQL database integration
- [ ] Role-based access (Admin / Employee)
- [ ] Export payslip to PDF
- [ ] Monthly payroll history
- [ ] PIN-based employee login

---

## 👨‍💻 Author

Ashish kumar 
B.Tech IT | 1st Year
GitHub: [ashuMax0216](https://github.com/ashuMax0216)

---

## 📄 License

This project is open source and available under the [MIT License](LICENSE).