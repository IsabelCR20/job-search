package net.isabelcr.jobsearch;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;

import net.isabelcr.jobsearch.api.APIFunctions;
import net.isabelcr.jobsearch.api.APIJobs;
import net.isabelcr.jobsearch.cli.CLIArguments;
import net.isabelcr.jobsearch.cli.CLIFunction;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class JobSearch {
    public static void main(String[] args) {
        System.out.println("Hola! ");
        JCommander commander = CommanderFunctions
                .buildCommanderWithName("job-search", CLIArguments::newInstance);

        Stream<CLIArguments> streamOfCli =  parseArguments
                (commander, args, JCommander::usage)  // Revisa si se requiere invocar la ayuda
                .orElse(Collections.emptyList())
                .stream()
                .map(obj -> (CLIArguments)obj);

        Optional<CLIArguments> cliArgsOpt = streamOfCli
                .filter(cli-> !cli.isHelp())
                .filter(cli->cli.getKeyword() != null)
                .findFirst();

        cliArgsOpt.map(CLIFunction::toMap)
                .map(JobSearch::executeRequest)   // Por cada elemento ejecuta la funcion
                .orElse(Stream.empty())
                .forEach(System.out::println);
    }

    public static Optional<List<Object>> parseArguments
            (JCommander commander, String[] args, Consumer<JCommander> onError){
        try{
            commander.parse(args);
            return Optional.of(commander.getObjects());
        } catch(ParameterException paramEx){
            onError.accept(commander);
        }
        return Optional.empty();
    }

// ya
    private static Stream<JobPosition> executeRequest(Map<String, Object> params){
        APIJobs ApiJobs = APIFunctions
                .buildAPI(APIJobs.class, "https://jobs.github.com");
        return Stream.of(params).map(ApiJobs::jobs)
                .flatMap(Collection::stream);
    }
}
