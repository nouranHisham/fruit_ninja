package LogicPackage.Commands;

public class Invoker {
    private GameCommands commands;

    public void setCommands(GameCommands commands) {
        this.commands = commands;
    }
    public void execute(){
        commands.execute();
    }
}
