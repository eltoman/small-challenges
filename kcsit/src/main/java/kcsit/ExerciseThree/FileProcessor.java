package kcsit.ExerciseThree;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class FileProcessor {

    private final Path source;
    private FilteringLineChain filteringLineChain;

    public FileProcessor(Path source) {
        this.filteringLineChain = new FilteringInvalidData();
        this.source = source;
    }

    public void process() throws IOException {
        FileConsumerFactory fileConsumerFactory = new FileConsumerFactory();
        try (Stream<String> stream = Files.lines(source)) {
            stream.forEach(line -> {
                LineDetail lineDetail = new LineDetail(line);
                if(shouldProcess(lineDetail)) {
                    FileConsumer fileConsumer = fileConsumerFactory.createFileConsumer(lineDetail.toString());
                    fileConsumer.consume(lineDetail.toString());
                }
            });
        }
    }

    private boolean shouldProcess(LineDetail lineDetail){
        return filteringLineChain.check(lineDetail);
    }

    static class FileConsumerFactory {
        FileConsumer createFileConsumer(String line) {
            //Some logic here to create a valid file consumer.
            //For this example it only return a Default File Consumer
            //You don’t need to care about this method.
            return new DefaultFileConsumer();
        }
    }

    interface FileConsumer {
        void consume(String line);
    }

    static class DefaultFileConsumer implements FileConsumer {
        @Override
        public void consume(String line) {
            //Some code is done here, but it is not important for this exercise
        }
    }
}
