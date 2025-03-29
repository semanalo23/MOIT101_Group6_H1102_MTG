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
        employees.add(new Employee(10004, "Isabella Reyes", LocalDate.of(1994, 6, 16), 168, 60000, 1125, 900, 100, 613.55));
        employees.add(new Employee(10005, "Eduard Hernandez", LocalDate.of(1989, 9, 23), 168, 52670, 1125, 790.5, 100, 433.04));
        employees.add(new Employee(10006, "Andrea Mae Villanueva", LocalDate.of(1988, 2, 14), 168, 52670, 1125, 790.5, 100, 433.04));
        employees.add(new Employee(10007, "Brad San Jose", LocalDate.of(1996, 3, 15), 168, 42975, 1125, 644.6, 100, 194.31));
        employees.add(new Employee(10008, "Alice Romualdez", LocalDate.of(1992, 5, 14), 168, 22500, 1012.50, 337.5, 100, 4.34));
        employees.add(new Employee(10009, "Rosie Atienza", LocalDate.of(1948, 9, 24), 168, 22500, 1012.50, 337.5, 100, 4.34));
        employees.add(new Employee(100010, "Roderick Alvaro", LocalDate.of(1988, 3, 30), 168, 52670, 1125, 790.5, 100, 433.04));
        employees.add(new Employee(100011, "Anthony Salcedo", LocalDate.of(1993, 9, 14), 168, 50825, 1125, 762.4, 100, 395.06));
        employees.add(new Employee(100012, "Josie Lopez", LocalDate.of(1987, 1, 14), 168, 38475, 1125, 577.1, 100, 83.5));
        employees.add(new Employee(100013, "Martha Farala", LocalDate.of(1942, 1, 11), 168, 24000, 1080, 360, 100, 32.54));
        employees.add(new Employee(100014, "Leila Martinez", LocalDate.of(1970, 7, 11), 168, 24000, 1080, 360, 100, 32.54));
        employees.add(new Employee(100015, "Fredrick Romualdez", LocalDate.of(1985, 3, 10), 168, 53500, 1125, 802.5, 100, 453.5));
        employees.add(new Employee(100016, "Christian Mata", LocalDate.of(1978, 10, 21), 168, 42975, 1125, 644.6, 100, 194.31));
        employees.add(new Employee(100017, "Selena De Leon", LocalDate.of(1975, 2, 20), 168, 41850, 1125, 627.75, 100, 166.6));
        employees.add(new Employee(100018, "Allison San Jose", LocalDate.of(1986, 6, 24), 168, 22500, 1012.50, 337.5, 100, 4.34));
        employees.add(new Employee(100019, "Cydney Rosario", LocalDate.of(1996, 10, 6), 168, 22500, 1012.50, 337.5, 100, 4.34));
        employees.add(new Employee(100020, "Mark Bautista", LocalDate.of(1991, 2, 12), 168, 23250, 1035, 348.75, 100, 18.7));
        employees.add(new Employee(100021, "Darlene Lazaro", LocalDate.of(1985, 11, 25), 168, 23250, 1035, 348.75, 100, 18.7));
        employees.add(new Employee(100022, "Kolby Delos Santos", LocalDate.of(1980, 2, 26), 168, 24000, 1080, 360, 100, 32.54));
        employees.add(new Employee(100023, "Vella Santos", LocalDate.of(1983, 12, 31), 168, 22500, 1012.50, 337.5, 100, 4.34));
        employees.add(new Employee(100024, "Tomas Del Rosario", LocalDate.of(1978, 12, 18), 168, 22500, 1012.50, 337.5, 100, 4.34));
        employees.add(new Employee(100025, "Jacklyn Tolentino", LocalDate.of(1984, 5, 19), 168, 24000, 1080, 360, 100, 32.54));
        employees.add(new Employee(100026, "Percival Gutierrez", LocalDate.of(1970, 12, 18), 168, 24750, 1125, 371.25, 100, 46.41));
        employees.add(new Employee(100027, "Garfield Manalaysay", LocalDate.of(1986, 8, 28), 168, 24750, 1125, 371.25, 100, 46.41));
        employees.add(new Employee(100028, "Lizeth Villegas", LocalDate.of(1981, 12, 12), 168, 24000, 1080, 360, 100, 32.54));
        employees.add(new Employee(100029, "Carol Ramos", LocalDate.of(1978, 8, 20), 160, 22500, 1012.50, 337.5, 100, 4.34));
        employees.add(new Employee(100030, "Emelia Maceda", LocalDate.of(1973, 4, 14), 168, 22500, 1012.50, 337.5, 100, 4.34));
        employees.add(new Employee(100031, "Delia Aguilar", LocalDate.of(1989, 1, 27), 168, 22500, 1012.50, 337.5, 100, 4.34));
        employees.add(new Employee(100032, "John Rafael Castro", LocalDate.of(1992, 2, 9), 168, 52670, 1125, 790.05, 100, 433.04));
        employees.add(new Employee(100033, "Carlos Ian Martinez", LocalDate.of(1990, 11, 16), 168, 52670, 1125, 790.05, 100, 433.04));
        employees.add(new Employee(100034, "Beatriz Santos", LocalDate.of(1990, 8, 7), 168, 52670, 1125, 790.05, 100, 433.04));


        for (Employee emp : employees) {
            emp.displayPayslip();
        }
    }
}

