package lygirl.testjavastream;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class GroupingByTest {
    @Test
    public void testGroupBy() {
        List<Dish> menu = new ArrayList<>();
        menu.add(Dish.builder().name("A").calories(470).build());
        menu.add(Dish.builder().name("B").calories(800).build());
        menu.add(Dish.builder().name("C").calories(900).build());
        menu.add(Dish.builder().name("D").calories(320).build());
        menu.add(Dish.builder().name("E").calories(550).build());
        Map<CaloricLevel, List<Dish>> dishedByCaloriclevel =
            menu.stream()
                .collect(
                    groupingBy(Dish::getCaloricLevel)
                );
        log.debug("dishedByCaloriclevel : {}", dishedByCaloriclevel);
        assertThat(menu.get(0).getCaloricLevel()).isEqualTo(CaloricLevel.NORMAL);
        assertThat(menu.get(1).getCaloricLevel()).isEqualTo(CaloricLevel.FAT);
        assertThat(menu.get(3).getCaloricLevel()).isEqualTo(CaloricLevel.DIET);
    }
}
