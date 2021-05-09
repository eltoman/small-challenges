package kcsit.ExerciseThree;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FilteringInvalidData extends FilteringLineChain{

    Path  invalidDataFilePath = Paths.get(FilteringInvalidData.class.getResource("/invalid_data.csv").getPath());
    private static int INDEX_TO_CHECK = 2;

    @Override
    public boolean check(LineDetail lineDetail) {
        String fieldValueToCheck = lineDetail.getFields().get(INDEX_TO_CHECK).toUpperCase();
        if(getInvalidData().contains(fieldValueToCheck)) return false;
        return checkNext(lineDetail);
    }

    private List<String> getInvalidData(){
        List<String> invalidData = new ArrayList<>();
        FileProcessor.FileConsumerFactory fileConsumerFactory = new FileProcessor.FileConsumerFactory();
        try (Stream<String> stream = Files.lines(invalidDataFilePath)) {
            stream.forEach(line -> {
                invalidData.add(line.toUpperCase());
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return invalidData;
    }
}
