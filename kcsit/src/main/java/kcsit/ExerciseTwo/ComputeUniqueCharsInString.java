package kcsit.ExerciseTwo;

public class ComputeUniqueCharsInString {

    /* There is a unknown difference in last test case.
     * Create others unit test and it's OK...
     * should be 46 but the result is 48, I didn't understand why...
    */
    public Long execute(String text){
        if(text == null || text.isBlank()) return 0l;
        return text.chars()
                .distinct()
                .count();
    }
}
