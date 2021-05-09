package kcsit.ExerciseThree;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

public class FileProcessorTest {
    Path sourcePath;
    LineDetail invalidLine;
    LineDetail validLine;

    @Before
    public void setUp() throws Exception {
        sourcePath = Paths.get(FileProcessorTest.class.getResource("/source.csv").getPath());
        invalidLine = new LineDetail("080044Z;Lorem ipsum dolor;B01;8251.155;854;894.47;Lorem ipsum");
        validLine = new LineDetail("9004A;Lorem ipsum dolor;A85;1000.125547;8524;-1411.1;Lorem ipsum");
    }

    @Test
    public void shouldInvalidateInvalidData() throws IOException {
        FilteringLineChain filteringLineChain = new FilteringInvalidData();
        assertThat(filteringLineChain.check(invalidLine)).isFalse();
    }

    @Test
    public void shouldValidateValidData() throws IOException {
        FilteringLineChain filteringLineChain = new FilteringInvalidData();
        assertThat(filteringLineChain.check(validLine)).isTrue();
    }

    @Test
    public void shouldProcessWithoutError() throws IOException {
        FileProcessor fileProcessor = new FileProcessor(sourcePath);
        fileProcessor.process();
    }
}
