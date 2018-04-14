/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import parkinglot.Controller.InputConverter;

/**
 *
 * @author violin
 */
public class Main {

    public static void main(String[] args) {
      InputConverter converter = new InputConverter();
        switch (args.length) {
            case 0:
                System.out.println("Please enter 'quit' to close the program");
                System.out.println("Waiting for input...");
                // Interactive command-line input/output
                // Run an infinite loop
                for (;;) {
                    try {
                        if (inputString.equalsIgnoreCase("quit")) {
                            break;
                        } else if ((inputString == null) || (inputString.isEmpty())) {
                            
                        } else {
                            converter.parseTextInput(inputString.trim());
                        }
                    } catch(IOException e) {
                        System.out.println("Oops! Error in reading the input from console.");
                        e.printStackTrace();
                    }
                }
                break;
            case 1:
                // File input/output
                converter.parseFileInput(args[0]);
                break;
            default:
                System.out.println("Invalid input. Usage: java -jar <jar_file_path> <input_file_path>");
        }
    }
    
}
