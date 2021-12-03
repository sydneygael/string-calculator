import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {

    public int Add(String numbers) {
        if (null == numbers || numbers.isBlank()){
            return 0;
        } else {
            List<Integer> numbersList = Arrays.stream(numbers.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            return numbersList.stream().reduce(Integer::sum).orElse(0);
        }
    }
}
