
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asoomro
 */
public class FindByName {
    /**
     * This method should modify a Query string according to our input (user's input when they are trying to edit something
     * @param Query = the String that you will feed to .executeQuery method
     * @param input = users input, to specify what he is looking for. 
     * if the Query is set to look at "name" column, its expected that the input will be of that sort
     */
    public void modifyInput(String Query, String input){
    String p = "\"%";
    p += input;
    input = p.concat("%\"");    
    Query += input;
    System.out.println(Query); //just for test
    }
    /*
    the scanner will be replaced by the one we already have in UI class
    just to see if it works as intended.
    */
    public static void main(String[] args) {
      Scanner keyboard = new Scanner(System.in); 
      String test = keyboard.nextLine();
      String FindByName = "UPDATE tableName SET studentName = \"*desired output needs to be developed*\" WHERE name LIKE";   
      FindByName obj = new FindByName();
      obj.modifyInput(FindByName, test);
    }
}
