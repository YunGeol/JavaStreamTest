package lygirl.testjavastream;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Dish {
    private String name;
    private int calories;

    public CaloricLevel getCaloricLevel() {
        if (this.getCalories() <= 400) {
            return CaloricLevel.DIET;
        } else if (this.getCalories() <= 700) {
            return CaloricLevel.NORMAL;
        } else {
            return CaloricLevel.FAT;
        }
    }
}
