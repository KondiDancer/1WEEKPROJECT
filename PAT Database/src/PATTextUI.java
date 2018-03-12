/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author dthakker
 */
//import MiniProject.LabClass;
import java.util.*;

/**
 * Provides a text based user interface for the LabClass project.
 *
 * @author Ian Bradley
 * @version 14-03-2008
 */
public class PATTextUI {
    // instance variables - replace the example below with your own

    //private LabClass labClass;
    Scanner myScanner;

    /**
     * Constructor for objects of class TextUI
     */
    public PATTextUI() {
        //labClass = new LabClass();
        myScanner = new Scanner(System.in);
    }

    /**
     * provides the main user interface with the program
     */
    public void menu() {
        String command;
        do{
            displayMenu();
            command = getCommand();
            execute(command);

        } while (!command.equals("Quit"));
    }

    /**
     * displays the menu string on the terminal display
     */
    private void displayMenu() {
        String menuString = "Your Choices are :\n";
        menuString += "     Display all groups                                        [Full]\n";
        menuString += "     Find groups by name                                       [Find]\n";
        menuString += "     Add student                                               [AddS]\n";
        menuString += "     Add tutor                                                 [AddT]\n";
        menuString += "     Remove student/tutor                                      [Remove]\n";
        menuString += "     Edit student/tutor                                        [Edit]\n";
        menuString += "     Edit group                                                [EditG]\n";
        menuString += "     Create group                                              [Create]\n";
        menuString += "     Quit                                                      [Quit]\n";
        menuString += "Enter Choice : ";
        System.out.print(menuString);

    }

    /**
     * obtains the user's command one command per line
     *
     * @return the user command
     */
    private String getCommand() {
        return myScanner.nextLine();
    }

    /**
     * processes the legal commands
     *
     * @param command the command entered by the user
     */
    private void execute(String command){
        switch (command) {
            case "Quit":
                System.out.println("Bye");
                break;
        /* display all groups */
            case "Full":
                break;
        /* find group by name */
            case "Find":
                break;
        /* add student */
            case "AddS":
                break;
        /* add tutor */
            case "AddT":
                break;
        /* remove student tutor */
            case "Remove":
                break;
        /* edit student tutor */
            case "Edit":
                break;
        /* edit groups */
            case "EditG":
                break;
        /* create groups */
            case "Create":
                break;
            default:
                System.out.println("Invalid Command : "
                        + command);
                break;
        }

    }

}
