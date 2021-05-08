package kcsit.ExerciseTwo;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ComputeUniqueCharsInStringTest {
    @Test
    public void shouldComputeBigTest() {
        ComputeUniqueCharsInString computeUniqueCharsInString = new ComputeUniqueCharsInString();
        String bigTest = "$VmpKVloxbFhOV3RKUnpreFkyZHZTMk16VW5aamJWVm5XVmMxYTB3eU9YbEpSMFpxV1R[KV2VtTjVRbkJpYlZwMlkyMHhhR1JIYkhaaWFVSjJZbWxDYUVsSFVteGtiV3hxV2xOM1oyTXpWbXBoUTBKb1kzbENhbUl5";
        assertThat(computeUniqueCharsInString.execute(bigTest)).isEqualTo(48l);
    }

    @Test
    public void shouldComputeUniqueCharsInASimpleString() {
        ComputeUniqueCharsInString computeUniqueCharsInString = new ComputeUniqueCharsInString();
        assertThat(computeUniqueCharsInString.execute("Aa12")).isEqualTo(4l);
        assertThat(computeUniqueCharsInString.execute("AAAAa12EEE22E1")).isEqualTo(5l);
        assertThat(computeUniqueCharsInString.execute("A[}")).isEqualTo(3l);
    }

    @Test
    public void shouldReturnZeroWhenNullString() {
        ComputeUniqueCharsInString computeUniqueCharsInString = new ComputeUniqueCharsInString();
        assertThat(computeUniqueCharsInString.execute("")).isEqualTo(0l);
        assertThat(computeUniqueCharsInString.execute(" ")).isEqualTo(0l);
        assertThat(computeUniqueCharsInString.execute(null)).isEqualTo(0l);
    }
}