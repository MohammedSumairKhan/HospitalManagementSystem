package com.practise;
import java.util.Scanner;

//Abstract class showcasing abstraction
abstract class Person {
 protected String name;
 protected int age;

 public Person(String name, int age) {
     this.name = name;
     this.age = age;
 }

 public abstract void displayDetails();
}

//Encapsulation: Patient class
class Patient extends Person {
 private String patientId;
 private String ailment;

 public Patient(String name, int age, String patientId, String ailment) {
     super(name, age);
     this.patientId = patientId;
     this.ailment = ailment;
 }

 public String getPatientId() {
     return patientId;
 }

 public void displayDetails() {
     System.out.println("Patient ID: " + patientId);
     System.out.println("Name: " + name);
     System.out.println("Age: " + age);
     System.out.println("Ailment: " + ailment);
 }
}

//Inheritance: Doctor class
class Doctor extends Person {
 private String doctorId;
 private String specialization;

 public Doctor(String name, int age, String doctorId, String specialization) {
     super(name, age);
     this.doctorId = doctorId;
     this.specialization = specialization;
 }

 public String getDoctorId() {
     return doctorId;
 }

 public void displayDetails() {
     System.out.println("Doctor ID: " + doctorId);
     System.out.println("Name: " + name);
     System.out.println("Age: " + age);
     System.out.println("Specialization: " + specialization);
 }
}

//Main system
public class HospitalManagementSystem {
 private static Patient[] patients = new Patient[10];
 private static Doctor[] doctors = new Doctor[5];
 private static int patientCount = 0;
 private static int doctorCount = 0;

 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     int choice;

     do {
         System.out.println("\n--- Hospital Management System ---");
         System.out.println("1. Add Patient");
         System.out.println("2. Add Doctor");
         System.out.println("3. View Patients");
         System.out.println("4. View Doctors");
         System.out.println("5. Exit");
         System.out.print("Enter your choice: ");
         choice = scanner.nextInt();

         switch (choice) {
             case 1:
                 addPatient(scanner);
                 break;
             case 2:
                 addDoctor(scanner);
                 break;
             case 3:
                 viewPatients();
                 break;
             case 4:
                 viewDoctors();
                 break;
             case 5:
                 System.out.println("Exiting system...");
                 break;
             default:
                 System.out.println("Invalid choice! Please try again.");
         }
     } while (choice != 5);

     scanner.close();
 }

 // Adding a patient
 private static void addPatient(Scanner scanner) {
     if (patientCount >= patients.length) {
         System.out.println("Patient list is full!");
         return;
     }

     System.out.print("Enter Patient Name: ");
     scanner.nextLine(); // Clear buffer
     String name = scanner.nextLine();
     System.out.print("Enter Patient Age: ");
     int age = scanner.nextInt();
     System.out.print("Enter Patient ID: ");
     scanner.nextLine(); // Clear buffer
     String patientId = scanner.nextLine();
     System.out.print("Enter Ailment: ");
     String ailment = scanner.nextLine();

     patients[patientCount++] = new Patient(name, age, patientId, ailment);
     System.out.println("Patient added successfully!");
 }

 // Adding a doctor
 private static void addDoctor(Scanner scanner) {
     if (doctorCount >= doctors.length) {
         System.out.println("Doctor list is full!");
         return;
     }

     System.out.print("Enter Doctor Name: ");
     scanner.nextLine(); // Clear buffer
     String name = scanner.nextLine();
     System.out.print("Enter Doctor Age: ");
     int age = scanner.nextInt();
     System.out.print("Enter Doctor ID: ");
     scanner.nextLine(); // Clear buffer
     String doctorId = scanner.nextLine();
     System.out.print("Enter Specialization: ");
     String specialization = scanner.nextLine();

     doctors[doctorCount++] = new Doctor(name, age, doctorId, specialization);
     System.out.println("Doctor added successfully!");
 }

 // Viewing all patients
 private static void viewPatients() {
     if (patientCount == 0) {
         System.out.println("No patients registered.");
         return;
     }

     System.out.println("\n--- List of Patients ---");
     for (int i = 0; i < patientCount; i++) {
         patients[i].displayDetails();
         System.out.println();
     }
 }

 // Viewing all doctors
 private static void viewDoctors() {
     if (doctorCount == 0) {
         System.out.println("No doctors registered.");
         return;
     }

     System.out.println("\n--- List of Doctors ---");
     for (int i = 0; i < doctorCount; i++) {
         doctors[i].displayDetails();
         System.out.println();
     }
 }
}

