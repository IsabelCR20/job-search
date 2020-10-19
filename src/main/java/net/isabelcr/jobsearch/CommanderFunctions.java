package net.isabelcr.jobsearch;

import com.beust.jcommander.JCommander;

import java.util.function.Supplier;

public class CommanderFunctions {

    public static JCommander buildCommander(Object obj){
        return JCommander.newBuilder().addObject(obj).build();
    }

    public static <T> JCommander buildCommanderWithName
            (String cliname, Supplier<T> argumentSupplier){
        //JCommander commander = buildCommander(argumentSupplier.get());
        JCommander commander = JCommander.newBuilder().addObject(argumentSupplier.get()).build();
        commander.setProgramName(cliname);
        return commander;
    }

}



/*
static <T> JCommander buildCommanderWithName(String cliname, Supplier<T> argumentSupplier){
        JCommander commander = buildCommander(argumentSupplier.get());

        JCommander commander = JCommander.newBuilder()
                .addCommand(argumentSupplier.get())
                .build();

        commander.setProgramName(cliname);
                return commander;
                /
                }
 */