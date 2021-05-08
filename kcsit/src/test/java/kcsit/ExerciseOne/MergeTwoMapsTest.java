package kcsit.ExerciseOne;

import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;

public class MergeTwoMapsTest {

    @Test
    public void execute() {
        MergeTwoMaps tool = new MergeTwoMaps();
        Map<String,Long> map1 = new HashMap<>() {{
            put("A", 1l);
            put("B", 1l);
            put("D", 300l);
            put("E", 250l);
        }};
        Map<String,Long> map2 = new HashMap<>() {{
            put("A", 1l);
            put("B", 1000l);
            put("C", 1000l);
            put("E", 250l);
        }};
        Map<String,Long> expect = new HashMap<>() {{
            put("A", 2l);
            put("B", 1001l);
            put("C", 1000l);
            put("D", 300l);
            put("E", 500l);
        }};

        assertThat(expect).containsExactlyEntriesOf(tool.execute(map1, map2));
    }
}