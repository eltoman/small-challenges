package kcsit.ExerciseTwo;

public class ComputeUniqueCharsInString {

    public Long execute(String text){
        if(text == null || text.isBlank()) return 0l;

        return text.chars()
                .distinct()
                .count();
    }
}
