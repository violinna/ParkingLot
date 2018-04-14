/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkinlot;

import parkinglot.Controller.Command;
import static org.junit.Assert.*;
import org.junit.Test;
/**
 *
 * @author violin
 */
public class CommandTest {
    Command command = new Command();
    
    @Test
    public void checkCommandInList() throws Exception {
        assertFalse(command.commandsMap.isEmpty());
        assertTrue(command.commandsMap.containsKey("create_parking_lot"));
        assertFalse(command.commandsMap.containsKey("mytestcommand"));
    }
}
