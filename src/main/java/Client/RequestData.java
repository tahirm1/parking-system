/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Client;

import java.io.Serializable;
import java.util.Map;

/**
 *
 * @author mariatahir
 */
public class RequestData implements Serializable {

    private String commandName;
    private Map<String, String> data;

    public RequestData(String commandName, Map<String, String> data) {
        this.commandName = commandName;
        this.data = data;
    }

    public Map<String, String> getData() {
        return data;
    }

    public String getCommandName() {
        return commandName;
    }

}
