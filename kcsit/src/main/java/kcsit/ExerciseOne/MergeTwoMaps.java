package kcsit.ExerciseOne;

import java.util.Map;

public class MergeTwoMaps {

    public Map<String, Long> execute(Map<String, Long> map1, Map<String, Long> map2) {
        map2.forEach((key, value) ->
                map1.merge(key, value, (v1, v2)
                        -> v1+v2
                ));
        return map1;
    }
}
