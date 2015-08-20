package doit.ui.console.clamshell.example;

import org.clamshellcli.api.Command;
import org.clamshellcli.api.Context;

import java.util.Collections;
import java.util.Map;

/**
 * Created by Almaz on 20.08.2015.
 */
public class ClamShellExample implements Command{
    private static final String NAMESPACE = "doit";
    private static final String ACTION_NAME = "make";

    @Override
    public Command.Descriptor getDescriptor(){
        return new Command.Descriptor() {
            @Override public String getNamespace() {return NAMESPACE;}

            @Override
            public String getName() {
                return ACTION_NAME;
            }

            @Override
            public String getDescription() {
                return "Make me very happy";
            }

            @Override
            public String getUsage() {
                return "Type 'make'";
            }

            @Override
            public Map<String, String> getArguments() {
                return Collections.emptyMap();
            }
        };
    }

    @Override
    public Object execute(Context context) {
        context.getIoConsole().print("А так можете?!");
        return context;
    }

    @Override
    public void plug(Context context) {
        context.getIoConsole().print("Initializing example");
    }

    @Override
    public void unplug(Context context) {
        context.getIoConsole().print("Deinit example");
    }
}
