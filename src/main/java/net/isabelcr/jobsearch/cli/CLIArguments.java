package net.isabelcr.jobsearch.cli;

import com.beust.jcommander.Parameter;

public class CLIArguments {

    @Parameter(required = true,
        descriptionKey = "Palabra clave",
        description = "Palabra clave des",
        validateWith = CLIKeyWordValidator.class)
    private String keyword;

    @Parameter(names={"--location", "-l"},
            description = "La busqueda puede " +
                    "incluir unicabion")
    private String location;

    @Parameter(names={"--page", "-p"},
            description = "La paginacion devuelve" +
                    " 50 elementos")
    private int page;

    @Parameter(names={"--fulltime", "-ft"},
            description = "Se especifica si la " +
                    "busqueda es de tiempo completo")
    private boolean isFullTime = false;

    @Parameter(names={"--markdown", "-md"},
            description = "Se especifica si la " +
                    "busqueda es en MarkDown")
    private boolean isMarkDown = false;

    @Parameter(names={"--help", "-h"},
            description = "Disponibilidad de la ayuda",
            help = true,
            validateWith = CLIHelpValidator.class)
    private boolean isHelp;

    private CLIArguments(){

    }

    public static CLIArguments newInstance(){
        return new CLIArguments();
    }

    public String getKeyword() {
        return keyword;
    }

    public String getLocation() {
        return location;
    }

    public int getPage() {
        return page;
    }

    public boolean isFullTime() {
        return isFullTime;
    }

    public boolean isMarkDown() {
        return isMarkDown;
    }

    public boolean isHelp() {
        return isHelp;
    }

    @Override
    public String toString() {
        return "CLIArguments{" +
                "keyword='" + keyword + '\'' +
                ", location='" + location + '\'' +
                ", page=" + page +
                ", isFullTime=" + isFullTime +
                ", isMarkDown=" + isMarkDown +
                ", isHelp=" + isHelp +
                '}';
    }
}
