package com.nagarro.remotelearning;

import com.nagarro.remotelearning.model.Sex;
import com.nagarro.remotelearning.model.Student;
import com.nagarro.remotelearning.repository.GenericRepository;
import com.nagarro.remotelearning.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static GenericRepository<Student> studentRepository;

    public static void main(String[] args) {
        try (Connection connection = DatabaseUtil.getConnection()) {
            studentRepository = new GenericRepository<>(Student.class);
            runMenu();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void runMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Student Management System");
            System.out.println("1. Save Student");
            System.out.println("2. Save and Return Generated ID");
            System.out.println("3. Find Student by ID");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Save All Students");
            System.out.println("7. Filter Students by Field");
            System.out.println("8. Find Paginated Students");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    saveStudent(scanner);
                    break;
                case 2:
                    saveAndReturnGeneratedId(scanner);
                    break;
                case 3:
                    findStudentById(scanner);
                    break;
                case 4:
                    updateStudent(scanner);
                    break;
                case 5:
                    deleteStudent(scanner);
                    break;
                case 6:
                    saveAllStudents(scanner);
                    break;
                case 7:
                    filterStudentsByField(scanner);
                    break;
                case 8:
                    findPaginatedStudents(scanner);
                    break;
                case 9:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }

        scanner.close();
    }

    private static void saveStudent(Scanner scanner) {
        Student student = inputStudentData(scanner);
        studentRepository.save(student);
        System.out.println("Student saved successfully.");
    }

    private static void saveAndReturnGeneratedId(Scanner scanner) {
        Student student = inputStudentData(scanner);
        int generatedId = studentRepository.saveAndReturnGeneratedId(student);
        System.out.println("Student saved with ID: " + generatedId);
    }

    private static void findStudentById(Scanner scanner) {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Student student = studentRepository.findById(id);
        if (student != null) {
            System.out.println("Student found: " + student);
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void updateStudent(Scanner scanner) {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Student student = studentRepository.findById(id);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        Student updatedStudent = inputStudentData(scanner);
        updatedStudent.setId(id); // Make sure the ID is retained
        studentRepository.update(updatedStudent);
        System.out.println("Student updated successfully.");
    }

    private static void deleteStudent(Scanner scanner) {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline

        studentRepository.delete(id);
        System.out.println("Student deleted successfully.");
    }

    private static void saveAllStudents(Scanner scanner) {
        System.out.print("Enter the number of students to save: ");
        int count = scanner.nextInt();
        scanner.nextLine(); // consume newline

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            System.out.println("Enter details for student " + (i + 1) + ":");
            students.add(inputStudentData(scanner));
        }

        studentRepository.saveAll(students);
        System.out.println("All students saved successfully.");
    }

    private static void filterStudentsByField(Scanner scanner) {
        System.out.print("Enter field name to filter by: ");
        String fieldName = scanner.nextLine();

        System.out.print("Enter field value: ");
        String fieldValue = scanner.nextLine();

        List<Student> students = studentRepository.filterByField(fieldName, fieldValue);
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            students.forEach(System.out::println);
        }
    }

    private static void findPaginatedStudents(Scanner scanner) {
        System.out.print("Enter page number: ");
        int pageNumber = scanner.nextInt();

        System.out.print("Enter page size: ");
        int pageSize = scanner.nextInt();
        scanner.nextLine(); // consume newline

        List<Student> students = studentRepository.findPaginated(pageNumber, pageSize);
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            students.forEach(System.out::println);
        }
    }

    private static Student inputStudentData(Scanner scanner) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter CNP: ");
        String cnp = scanner.nextLine();

        System.out.print("Enter sex (Male/Female): ");
        String sexString = scanner.nextLine();
        Sex sex = Sex.valueOf(sexString.toUpperCase());

        System.out.print("Enter date of birth (yyyy-MM-dd): ");
        String dobString = scanner.nextLine();
        LocalDate dob = LocalDate.parse(dobString);

        System.out.print("Enter address ID: ");
        int addressId = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Student student = new Student();
        student.setName(name);
        student.setCnp(cnp);
        student.setSex(sex);
        student.setDateOfBirth(dob);
        student.setAddress(addressId);

        return student;
    }
}
