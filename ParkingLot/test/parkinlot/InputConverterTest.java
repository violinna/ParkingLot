/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkinlot;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import parkinglot.Controller.InputConverter;

/**
 *
 * @author violin
 */
public class InputConverterTest {
    InputConverter converter = new InputConverter();
    
    private final ByteArrayOutputStream outContent = 
            new ByteArrayOutputStream();
    
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }
    @Test
    public void parseTextInput() throws Exception {
        converter.parseTextInput("status");
        assertEquals("Invalidinput\nSorry,parkinglotisnotcreated", 
                outContent.toString().trim().replace(" ", ""));
    }
}
