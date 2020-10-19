package net.isabelcr.jobsearch.cli;

import java.util.HashMap;
import java.util.Map;

public interface CLIFunction {

    public static Map<String, Object> toMap(CLIArguments cliArgs){
        Map<String, Object> params = new HashMap<>();
        params.put("description", cliArgs.getKeyword());
        params.put("location", cliArgs.getLocation());
        params.put("full_time", cliArgs.isFullTime());
        params.put("page", cliArgs.getPage());

        if(cliArgs.isMarkDown()){
            params.put("markdown", true);
        }
        return params;
    }

}
