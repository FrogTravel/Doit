package doit.core.examples.console;

import doit.core.exceptions.DoitException;

/**
 * Created by Almaz on 16.08.2015.
 */
public enum Command {
    HELP("help"),
    REGISTER("register"),
    AUTHORIZE("authorize"),
    ADD_PROJECT("create project"),
    DELETE_PROJECT("delete project"),
    ADD_TASK("add task"),
    REMOVE_TASK("remove task"),
    SAVE_ALL("save all"),
    LOAD_ALL("load all"),
    EXIT("exit");

    final String commandName;

    private Command(String commandName){
        this.commandName = commandName;
    }

    public static Command forName(String commandName) throws DoitException{
        for (Command command: values()){
            if(command.commandName.equals(commandName))
                return command;
        }

        throw new DoitException("Unsupported operation");
    }

}
