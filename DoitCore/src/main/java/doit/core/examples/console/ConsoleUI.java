package doit.core.examples.console;

import doit.core.entites.DoitProject;
import doit.core.entites.DoitUser;
import doit.core.exceptions.DoitAuthorizationException;
import doit.core.exceptions.DoitException;
import doit.core.utils.DoitContext;

import java.util.Scanner;

/**
 * Created by Almaz on 16.08.2015.
 *
 *
 * This class only for Core Team purpose!
 */
public class ConsoleUI {
    private static Scanner scanner = new Scanner(System.in);
    private static boolean isRunning = false;
    private static DoitContext context = DoitContext.getInstance();
    private static DoitUser currentUser;


    public static void main(String[] args) {
        printHelloMessage();
        isRunning = true;
        
        while (isRunning){
            Command command = getCommand();
            switch (command){
                case EXIT: exit(); break;
                case HELP: help(); break;
                case REGISTER: register(); break;
                case AUTHORIZE: authorize(); break;
                case ADD_PROJECT: addProject(); break;
                case DELETE_PROJECT: removeProject(); break;
                /*
                case ADD_TASK: addTask(); break;
                case REMOVE_TASK:removeTask(); break;
                case LOAD_ALL:loadAll(); break; */
                case SAVE_ALL:saveAll(); break;
                default: printMessage("Operation not suppoted yet");
            }
        }
    }

    private static void removeProject(){
        if(currentUser != null){
            String projectName = getAnswer("Please, enter the project name");
            try {
                context.deleteProject(currentUser, projectName);
                printProjects();
            } catch (DoitException e){
                System.out.println("Something wrong happened");
                System.out.println(e);
            }
        } else {
            System.out.println("Authorize firstly, please");
        }
    }
    private static void addProject(){
        if(currentUser != null){
            String projectName = getAnswer("Please, enter the project name");
            try {
                context.createProject(currentUser, projectName);
                printProjects();
            } catch (DoitException e){
                System.out.println("Something wrong happened");
                System.out.println(e);
            }
        } else {
            System.out.println("Authorize firstly, please");
        }
    }
    private static void authorize() {
        String login = getAnswer("Please, enter the login");
        String pass = getAnswer("Please, enter the password");

        authorize(login, pass);
    }
    private static void authorize(String login, String password){
        try {
            DoitUser user = context.authorize(login, password);
            if(user != null) {
                currentUser = user;
                System.out.println("You are authorized!");
            }
        } catch (DoitAuthorizationException e){
            System.out.println(e);
        }
    }
    private static void register(){
        String login = getAnswer("Please, enter the login");
        String pass = getAnswer("Please, enter the password");

        try{
            DoitUser user = context.register(login, pass);
            authorize(login, pass);
        } catch (DoitException e){
            System.out.println("Oooops, something wrong happened");
        }
    }
    private static void saveAll(){
        printMessage("Operation not suppoted yet");
    }
    private static void exit() {
        boolean saveChanges = getBooleanAnswer("Save changes? ");

        if(saveChanges){
            saveAll();
        }
        isRunning = false;
        printGoodByeMessage();
    }
    private static void help(){
        System.out.println("This is console demo Doit project for core team");
        System.out.println("Supporting operations");
        for (Command c: Command.values()){
            System.out.println("   " + c.commandName);
        }
    }


    private static void printProjects(){
        if(currentUser != null){
            System.out.println("Projects: ");
            for (DoitProject pr: currentUser.getProjects()){
                System.out.println(" " + pr.getName());
            }
        }
    }
    private static void printHelloMessage() {
        System.out.println("Hi, stranger!");
        System.out.println("What do you want?");
        printTypingHelpMessage();
    }
    private static void printGoodByeMessage() {
        System.out.println("Good bye! See you soon");
    }
    private static void printTypingHelpMessage(){
        System.out.println("Type 'help' for more information");
    }
    private static void printMessage(String message) {
        System.out.println(message);
    }
    private static Command getCommand() {
        String commandName = getAnswer();
        try {
            return Command.forName(commandName);
        } catch (DoitException ex){
            System.out.println("Ooooops!");
            System.out.println(ex.getMessage());

            printTypingHelpMessage();
            System.out.println("Please, enter command");
            return getCommand();
        }
    }
    private static String getAnswer(){
        System.out.print("-> ");
        return scanner.nextLine();
    }
    private static boolean getBooleanAnswer(String question){
        System.out.println(question);
        System.out.println("Please, type Y or N");
        String answer = getAnswer();

        switch (answer.toLowerCase()){
            case "y": return true;
            case "n": return false;
        }

        return getBooleanAnswer(question);
    }
    private static String getAnswer(String question){
        System.out.println(question);
        return getAnswer();
    }
}

