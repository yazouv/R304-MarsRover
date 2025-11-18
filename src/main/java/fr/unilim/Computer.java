package fr.unilim;

import java.util.HashMap;
import java.util.Map;

public class Computer {
    private Map<String, Command> commands = new HashMap<>();

    public void setCommand(String button, Command cmd) {
        commands.put(button, cmd);
    }

    public void executeCommand(String bouton) {
        Command cmd = commands.get(bouton);
        if (cmd != null) cmd.execute();
    }
}
