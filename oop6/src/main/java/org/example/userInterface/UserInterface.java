package org.example.userInterface;

import org.example.structures.patient.Patient;
import org.example.structures.range.Range;

import java.util.Scanner;

public class UserInterface {
    Scanner scanner;

    public UserInterface(Scanner sc){
        scanner = sc;
    }

    public Patient inputPatient(){
        System.out.println("id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("medCardNo");
        int medCardNo = Integer.parseInt(scanner.nextLine());
        System.out.println("surname");
        String surname = scanner.nextLine();
        System.out.println("name");
        String name = scanner.nextLine();
        System.out.println("fatherName");
        String fatherName = scanner.nextLine();
        System.out.println("address");
        String address = scanner.nextLine();
        System.out.println("phoneNumber");
        long phoneNumber = Long.parseLong(scanner.nextLine());
        System.out.println("diagnos");
        String diagnos = scanner.nextLine();
        return new Patient(id,medCardNo,surname,name,fatherName,address,phoneNumber,diagnos);
    }

    public int inputRemoveMedCardNo(){
        System.out.println("medCardNo:");
        return Integer.parseInt(scanner.nextLine());
    }

    public Range inputRange(){
        System.out.println("Enter range (like 22-33):");
        String[] split = scanner.nextLine().split("-");
        return new Range(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
    }

    public long inputFirstNumberOfThePhone(){
        System.out.println("first number of the phone:");
        return Long.parseLong(scanner.nextLine());
    }

    public String inputDiagnos(){
        System.out.println("diagnos:");
        return scanner.nextLine();
    }

    public int menu(){
            System.out.println("""
                    1.Add a patient:
                    2.Delete a patient by medCardNo:
                    3.Save to default file:
                    4.Save to binary file:
                    5.Read from default file:
                    6.Read from binary file:
                    7.Sort patients by medCardNo:
                    8.Print patients with medCardNo in range of:
                    9.Print patients with first number of their phoneNumber
                    10.Print diagnosis/amounts of patients
                    0.Exit""");
            return Integer.parseInt(scanner.nextLine());
        }
}
