package kcsit.ExerciseFour;


import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Collection;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/**
 * Class responsible for formatting Row objects and write the output to a given output
 */

public class Formatter {

    private final Collection<Element> entries;

    private final Collection<Row> rows;


    public static void main(String[] args) throws IOException {


        //Sample Data preparation (Random data just for the sake of simplicity for this exercise)

        Random r = new Random();

        final Collection<Row> rows = IntStream.range(1, 235_000)

                .mapToObj(value -> new Row(r.nextInt(235_000))).collect(Collectors.toSet());


        final Collection<Element> elementList = IntStream.range(1, 1_000_000)

                .mapToObj(value -> new Element(r.nextInt(235_000))).collect(Collectors.toSet());


        //Sample use case. For the sake of simplicity in this exercise, it is initialized in the main method

        final Formatter formatter = new Formatter(elementList, rows);


        try (Writer writer = new PrintWriter(System.out)) {

            formatter.execute(writer);

        }

    }


    public Formatter(Collection<Element> entries, Collection<Row> rows) {

        this.entries = entries;

        this.rows = rows;

    }


    public void execute(Writer writer) throws IOException {

        for (Row row : this.rows) {

            makeFlow(row, writer);

        }

    }


    /**
     * <p>
     * <p>
     * Method that formats lines based on the content of the given {@code Row} and based on the content of the given
     * <p>
     * list of {@code Element}. The line is formatted as follow:
     *
     * </p>
     *
     * <p>
     * <p>
     * For each {@code Element id} that matches a {@code Row id}, a new line is written to the output. Each line is
     * <p>
     * separated by a ';'
     *
     * </p>
     */

    void makeFlow(Row row, Writer output) throws IOException {

        //Extracts only the elements which id matches the row.getId()

        final Collection<Element> matchingEntries = this.entries.stream()

                .filter(entry -> entry.getId() == row.getId()).collect(Collectors.toSet());


        for (Element element : matchingEntries) {

            output.write(row.getId());

            output.write(";");

            output.write(element.getId());

            output.write(";");

            output.write(row.getContent());

            output.write(";");

            output.write(element.getContent());

            output.write(System.lineSeparator());

        }


        //This call must remains here as it is

        ExternalClass.execute(this.entries, row);

    }








    }



