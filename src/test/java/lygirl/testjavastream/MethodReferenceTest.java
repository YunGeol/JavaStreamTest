package lygirl.testjavastream;

import lombok.Builder;
import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparing;
import static org.assertj.core.api.Assertions.assertThat;

public class MethodReferenceTest {
    @Test
    public void testMethodRef() {
        List<Apple> apples = new ArrayList<>();
        apples.add(Apple.builder().weight(14).build());
        apples.add(Apple.builder().weight(12).build());
        apples.add(Apple.builder().weight(16).build());
        apples.add(Apple.builder().weight(10).build());
        apples.add(Apple.builder().weight(11).build());
        apples.sort(comparing(Apple::getWeight));
        assertThat(apples.get(0).getWeight()).isEqualTo(10);
        assertThat(apples.get(4).getWeight()).isEqualTo(16);
    }

    @Builder
    @Data
    private static class Apple {
        private int weight;
    }
}
