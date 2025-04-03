package ms2_mph_mtg;

import java.util.Scanner;

public class MotorPH_MS2_payrollcode {

	public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        long empNum;
        String empName = "Unknown";
        double hourSalary, weeklyTime, overtimeHours;
        double regPay, overtimePay, grossPay, netPay;
        double sss, philHealth, pagIbig, incomeTax, totalDeductions;

        System.out.print("Enter Employee No: ");
        empNum = inp.nextLong();
        System.out.print("Enter hourly salary: ");
        hourSalary = inp.nextDouble();
        System.out.print("Enter Weekly Time (in hours): ");
        weeklyTime = inp.nextDouble();

        switch ((int) empNum) {
            case 10001 -> empName = "Manuel Garcia III";
            case 10002 -> empName = "Antonio Lim";
            case 10003 -> empName = "Bianca Sofia Aquino";
            case 10004 -> empName = "Isabella Reyes";
            case 10005 -> empName = "Eduard Hernandez";
             case 10006 -> empName = "Andrea Mae Villanueva";
            case 10007 -> empName = "Brad San Jose";
            case 10008 -> empName = "Alice Romualdez";
            case 10009 -> empName = "Rosie Atienza";
            case 100010 -> empName = "Roderick Alvaro";
             case 100011 -> empName = "Anthony Salcedo";
            case 100012 -> empName = "Josie Lopez";
            case 100013 -> empName = "Martha Farala";
            case 100014 -> empName = "Leila Martinez";
            case 100015 -> empName = "Fredrick Romualdez";
             case 100016 -> empName = "Christian Mata";
            case 100017 -> empName = "Selena DE Leon";
            case 100018 -> empName = "Allison San Jose";
            case 100019 -> empName = "Cydney Rosario";
            case 100020 -> empName = "Mark Bautista";
             case 100021 -> empName = "Darlene Lazaro";
            case 100022 -> empName = "Kolby Delos Santos";
            case 100023 -> empName = "Vella Santos";
            case 100024 -> empName = "Tomas Del Rosario";
            case 100025 -> empName = "Jacklyn Tolentino";
             case 100026 -> empName = "Percival Gutierrez";
            case 100027 -> empName = "Garfield Manalaysay";
            case 100028 -> empName = "Lizeth Villegas";
            case 100029 -> empName = "Carol Ramos";
            case 100030 -> empName = "Emelia Macedo";
             case 100031 -> empName = "Delia Aguilar";
            case 100032 -> empName = "John Rafael Castro";
            case 100033 -> empName = "Carlos Ian Martinez";
            case 100034 -> empName = "Beatriz Santos";
            
        }

        if (weeklyTime <= 40) {
            regPay = hourSalary * weeklyTime;
            overtimeHours = 0;
            overtimePay = 0;
        } else {
            overtimeHours = weeklyTime - 40;
            regPay = hourSalary * 40;
            overtimePay = (hourSalary * 1.5) * overtimeHours;
        }

        grossPay = regPay + overtimePay;

        
        sss = grossPay * 0.045; 
        philHealth = grossPay * 0.03; 
        pagIbig = 100; 
        incomeTax = (grossPay - (sss + philHealth + pagIbig)) * 0.12; 
        totalDeductions = sss + philHealth + pagIbig + incomeTax;
        netPay = grossPay - totalDeductions;

     
        System.out.println("======================");
        System.out.println("====PAYROLL SYSTEM====");
        System.out.println("======================");
        System.out.printf("Employee Number: %d\n", empNum);
        System.out.printf("Employee Name: %s\n", empName);
        System.out.printf("Hourly Salary: %.2f\n", hourSalary);
        System.out.printf("Weekly Hours: %.2f\n", weeklyTime);
        System.out.printf("Regular Pay: %.2f\n", regPay);
        System.out.printf("Overtime Pay: %.2f\n", overtimePay);
        System.out.printf("Gross Pay: %.2f\n", grossPay);
        System.out.printf("SSS Deduction: %.2f\n", sss);
        System.out.printf("PhilHealth Deduction: %.2f\n", philHealth);
        System.out.printf("Pag-IBIG Deduction: %.2f\n", pagIbig);
        System.out.printf("Income Tax Deduction: %.2f\n", incomeTax);
        System.out.printf("Total Deductions: %.2f\n", totalDeductions);
        System.out.printf("Net Pay: %.2f\n", netPay);
    }
}
