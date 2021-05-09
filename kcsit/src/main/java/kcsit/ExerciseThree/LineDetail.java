package kcsit.ExerciseThree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LineDetail {
    List<String> fields;

    public LineDetail(String csvLine) {
        this.fields = new ArrayList<>();
        this.fields.addAll(Arrays.asList(csvLine.split(";")));
    }

    public List<String> getFields() {
        return fields;
    }
    public void setFields(List<String> fields) {
        this.fields = fields;
    }

    @Override
    public String toString() {
        return fields.stream().map(Object::toString)
                .collect(Collectors.joining(";"));
    }
}
