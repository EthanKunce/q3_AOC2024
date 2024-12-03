/*
 * Author:		Ethan Kunce
 * Date:		03 December 2024
 * ProgramName:	MullItOver
 * Desc:		Boiler Plate Text
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MullItOver {
    
    public static void main(String [] args) throws FileNotFoundException
    {
        // Matcher mullMatcher = new Matcher(new Pattern("mul\\(\\d{1,3},\\d{1,3}\\)"))
        StringBuilder aggregatedText = new StringBuilder();
        Scanner fileReader = new Scanner(new File("input.txt"));
        int sum = 0;

        System.out.println();
        
        while(fileReader.hasNextLine())
        {
            aggregatedText.append(fileReader.nextLine());
        }
        Pattern mullPattern = Pattern.compile("mul\\(\\d{1,3},\\d{1,3}\\)|do\\(\\)|don't\\(\\)", Pattern.MULTILINE );
        Matcher mullMatcher = mullPattern.matcher(aggregatedText);
        // System.out.println(aggregatedText.toString());
        while(mullMatcher.find())
        {
            System.out.println(mullMatcher.group());    //prints the match found from the nullMatcher.find() call. 
            String temp = mullMatcher.group();          // calling multiple times still finds the same match from find() call

            int lhsOperand = Integer.parseInt(temp.substring(4, temp.indexOf(",")));
            int rhsOperand = Integer.parseInt(temp.substring(temp.indexOf(",")+1, temp.length()-1));
            // plus 1 is added to the first argument because its inclusive while the second is exclusive, so 1 is subtracted for that arguement
            sum += lhsOperand * rhsOperand;
        }

        System.out.println(sum);
        fileReader.close();
    } // End Main Method
    
} // End Class