package ms2_mph_mtg;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;
import java.time.LocalTime;
import java.time.Duration;
import java.time.format.DateTimeFormatter;

public class MotorPH_MS2_payrollcode {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long empNum;
        String empName = "Unknown";
        double hourSalary, weeklyTime, overtimeHours;
        double regPay, overtimePay, grossPay, netPay;
        double sss, philHealth, pagIbig, incomeTax, totalDeductions, lateDeduction = 0;

        System.out.print("Enter Employee No: ");
        empNum = scanner.nextLong();
        System.out.print("Enter hourly salary: ");
        hourSalary = scanner.nextDouble();

        // Consume newline left-over
        scanner.nextLine();

        // Birthdate input and age calculation
        System.out.print("Enter birthdate (yyyy-MM-dd): ");
        LocalDate birthDate = LocalDate.parse(scanner.nextLine());
        int age = Period.between(birthDate, LocalDate.now()).getYears(); 

        // Define time format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        System.out.print("Enter login time (HH:mm): ");
        LocalTime loginTime = LocalTime.parse(scanner.nextLine(), formatter);

        System.out.print("Enter logout time (HH:mm): ");
        LocalTime logoutTime = LocalTime.parse(scanner.nextLine(), formatter);

        // 🔍 Fix for logout time: Assume anything before 06:00 is PM, not AM
        if (logoutTime.isBefore(loginTime)) {
            logoutTime = logoutTime.plusHours(12); // Convert to PM if needed
        }

        // Define grace period limit (8:10 AM)
        LocalTime gracePeriodEnd = LocalTime.of(8, 10);

        // Check if employee is late
        boolean isLate = loginTime.isAfter(gracePeriodEnd);

        if (isLate) {
            System.out.println("⚠ Late login detected! Salary deduction will be applied.");
        }

        // Calculate working hours, minus 1 hour for lunch
        Duration duration = Duration.between(loginTime, logoutTime).minusHours(1);
        long hoursWorked = duration.toHours();
        long minutesWorked = duration.toMinutesPart();
        double decimalHours = hoursWorked + (minutesWorked / 60.0);

        weeklyTime = decimalHours;

        // Employee name based on ID
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

        // Calculate pay
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

        // Apply late deduction (1% of gross pay)
        if (isLate) {
            lateDeduction = grossPay * 0.01;
        }

        // Deductions
        sss = grossPay * 0.045;
        philHealth = grossPay * 0.03;
        pagIbig = 100;
        incomeTax = (grossPay - (sss + philHealth + pagIbig)) * 0.12;
        totalDeductions = sss + philHealth + pagIbig + incomeTax + lateDeduction;
        netPay = grossPay - totalDeductions;

        // Output
        System.out.println("\n======================");
        System.out.println("====PAYROLL SYSTEM====");
        System.out.println("======================");
        System.out.printf("Employee Number: %d\n", empNum);
        System.out.printf("Employee Name: %s\n", empName);
        System.out.printf("Birthdate: %s (Age: %d)\n", birthDate, age); // 👈 NEW LINE (Age added)
        System.out.printf("Hourly Salary: %.2f\n", hourSalary);
        System.out.printf("Login Time: %s\n", loginTime);
        System.out.printf("Logout Time: %s\n", logoutTime);
        System.out.printf("Total hours worked (excluding lunch): %.2f\n", decimalHours);
        if (isLate) {
            System.out.printf("Late Deduction: -%.2f\n", lateDeduction);
        }
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
