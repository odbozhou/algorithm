package designpatten;

import java.util.ArrayList;
import java.util.List;

public class CommandPatten {
    public static void main(String[] args) {
        Light light = new Light();
        Command command1 = new LightOnCommand(light);
        Command command2 = new LightOffCommand(light);
        SimpleControl simpleControl = new SimpleControl();
        simpleControl.setCommand(command1);
        simpleControl.lightOn();
        simpleControl.reset();
        simpleControl.setCommand(command2);
        simpleControl.lightOff();
        simpleControl.reset();
        System.out.println("…………resets…………");
        simpleControl.resets();
    }
}

class Light {
    public void on() {
        System.out.println("light on");
    }

    public void off() {
        System.out.println("light off");
    }
}

interface Command {
    void execute();

    void reset();
}

class LightOnCommand implements Command {

    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void reset() {
        light.off();
    }
}

class LightOffCommand implements Command {

    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void reset() {
        light.on();
    }
}

class SimpleControl {
    private Command command;
    private Command lastCommand;
    private List<Command> commandsHis = new ArrayList<>(8);

    public void setCommand(Command command) {
        this.command = command;
    }

    public void lightOn() {
        command.execute();
        lastCommand = command;
        commandsHis.add(command);
    }

    public void lightOff() {
        command.execute();
        lastCommand = command;
        commandsHis.add(command);
    }

    public void reset() {
        lastCommand.reset();
    }
     public void resets() {
        if (!commandsHis.isEmpty()) {
            for (Command command : commandsHis) {
                command.reset();
            }
            commandsHis.clear();
        }
    }

}
