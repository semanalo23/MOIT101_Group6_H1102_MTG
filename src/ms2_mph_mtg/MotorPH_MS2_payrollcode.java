package ms2_mph_mtg;

// Imports 
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

class Employee {  // Move Employee class outside MotorPH_MS2_payrollcode
    private int empNum;
    private String empName;
    private LocalDate birthday;
    private int hoursWorked;
    private double basicSalary;
    
    private double sss;
    private double philHealth;
    private double pagIbig;
    private double incomeTax;

    public Employee(int empNum, String empName, LocalDate birthday, int hoursWorked, double basicSalary,
                    double sss, double philHealth, double pagIbig, double incomeTax) {
        this.empNum = empNum;
        this.empName = empName;
        this.birthday = birthday;
        this.hoursWorked = hoursWorked;
        this.basicSalary = basicSalary;
        this.sss = sss;
        this.philHealth = philHealth;
        this.pagIbig = pagIbig;
        this.incomeTax = incomeTax;
    }

    public double calculateNetPay() {
        double totalDeductions = sss + philHealth + pagIbig + incomeTax;
        return basicSalary - totalDeductions;
    }

    public void displayPayslip() {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");

        System.out.println("========================================");
        System.out.println("Employee Number: " + empNum);
        System.out.println("Employee Name: " + empName);
        System.out.println("Birthday: " + birthday.format(dateFormatter));
        System.out.println();
        System.out.println("Hours Worked: " + hoursWorked);
        System.out.println("Basic Salary: " + df.format(basicSalary));
        System.out.println();
        System.out.println("Deductions:");
        System.out.println("SSS: " + df.format(sss));
        System.out.println("PhilHealth: " + df.format(philHealth));
        System.out.println("Pag-Ibig: " + df.format(pagIbig));
        System.out.println("Income Tax: " + df.format(incomeTax));
        System.out.println();
        System.out.println("Net Pay: " + df.format(calculateNetPay()));
        System.out.println("========================================\n");
    }
}

public class MotorPH_MS2_payrollcode {  // Remove inner class
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(10001, "Manuel Garcia III", LocalDate.of(1983, 10, 11), 168, 90000, 1125, 900, 100, 1800));
        employees.add(new Employee(10002, "Antonio Lim", LocalDate.of(1988, 6, 19), 168, 60000, 1000, 800, 150, 1600));
        employees.add(new Employee(10003, "Bianca Sofia Aquino", LocalDate.of(1989, 8, 4), 168, 60000, 1100, 850, 120, 1700));

        for (Employee emp : employees) {
            emp.displayPayslip();
        }
    }
}

