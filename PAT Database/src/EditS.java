/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PATProject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.*;

/**
 *
 * @author tawalcza
 */
public class EditS {
    static String name;
    static String UBNumber;
    static String YearOfStudy;
    static DbConnect connection = DbConnect.connection;
    static final Scanner user = new Scanner(System.in);

    public static void editStuddent() {
        String query = 
                "UPDATE `students` SET `student_uob`=" + UBNumber + ",`student_name`=" + name + ",`yos`=" + YearOfStudy + ""
                + ",`group_name`=NULL,`tutor_uob`=NULL WHERE`students` (`student_uob`, `student_name`, `yos`, `group_name`, `tutor_uob`);";

        connection.executeQuery(query);
    }

    public static void setStudentYOS() {
        System.out.println("Enter year of study:");
        String studentYOS = user.nextLine();
        
        while (!isYOSValid(studentYOS)) {
            System.out.println("Please enter a year that student is actually on:");
            studentYOS = user.nextLine();
        }
        EditS.YearOfStudy = studentYOS;
    }

    public static boolean isYOSValid(String studentYOS) {
        Pattern p = Pattern.compile("[1-5]");
        Matcher m = p.matcher(studentYOS);
        return m.matches();
    }

    public static void setStudentName() {
        System.out.println("Enter student name:");
        String name = user.nextLine();
        
        while (!isNameValid(name)) {
            System.out.println("Please enter a valid name (Full name with upper letters)");
            name = user.nextLine();
        }
        EditS.name = name;
    }

    public static boolean isNameValid(String studentName) {
        Pattern p = Pattern.compile("[A-Z][a-z]+ [A-Z][a-z]+");
        Matcher m = p.matcher(studentName);
        return m.matches();
    }
    /*
    public static void setStudentUB() {
        System.out.println("Enter student uob");
        String studentUB = user.next();
        
        while (isUBValid(studentUB)) {
            System.out.println("Student uob should be an 8-digital, unique number. Please try again:");
            studentUB = user.next();
        }
    }
    */
    public static boolean isUBValid(String uob) {
        Pattern p = Pattern.compile("[0-9]{8}");
        Matcher m = p.matcher(uob);
        return m.matches();
    }

    public static List<String> get_all_student_uob() {
        List<String> uob = new ArrayList<>();
        try {
            String query = "SELECT `student_uob` FROM `students`";
            connection.executeQuery(query);
            while (connection.rs.next()) {
                String UBNumber = connection.rs.getString("student_uob");
                uob.add(UBNumber);
            }
        } catch (SQLException sqle) {
            System.out.println(sqle);
        }
        return uob;
    }

    public static boolean isUBUnique(String uob) {
        for (int i = 0; i < get_all_student_uob().size(); i++) {
            if (uob.equals(get_all_student_uob().get(i))) {
                return false;
            }
        }
        return true;
    }

}
