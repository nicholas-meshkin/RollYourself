package rollYourself.RollYourself;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class StatRoller {
	public List<Integer> getStatList(){
        List<Integer> statList = new ArrayList<>();
        for (int i = 0;i<6;i++) {
            statList.add(getStat());
        }//TODO add method to reroll if total is below a certain level
        return statList;
    }
    public static int getStat() {
        List<Integer> currentRoll = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 4; i++) {
            currentRoll.add(rand.nextInt(6) + 1);
        }
        currentRoll.remove(currentRoll.indexOf(min(currentRoll)));
        return sum(currentRoll);
    }

    public static int sum(List<Integer> input) {
        int sum = 0;
        for (Integer item : input) {
            sum += item;
        }
        return sum;
    }
    public static Integer min(List<Integer> input) {
        Integer min = input.get(0);
        for (Integer item : input) {
            if (item < min) {
                min = item;
            }
        }
        return min;
    }
}