import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {

    //start with => //
    // ([^0-9]) => the delimiter is everything except numbers
    //\n => the line separator
    // infinite chars
    public static final String REGEX = "//([^0-9])\n(.*)";

    public int Add(String numbers) {
        if (null == numbers || numbers.isBlank()){
            return 0;
        } else {
            List<Integer> numbersList = getNumbers(numbers);
            checkNegative(numbersList);
            return numbersList.stream().reduce(Integer::sum).orElse(0);
        }
    }

    private void checkNegative(List<Integer> numbers) {
        StringBuilder stringBuilder = new StringBuilder();
        numbers.stream().filter( number -> number <0).forEach(number -> stringBuilder.append(number).append(","));
        if(!stringBuilder.toString().isEmpty()) {
            throw new RuntimeException("negatives not allowed "+stringBuilder.toString());
        }
    }

    private List<Integer> getNumbers(String numbers) {
        return Arrays.stream(getSplit(numbers))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }


    private String[] getSplit(String delimiterAndNumbers) {
        if(delimiterAndNumbers.startsWith("//")) {
            Matcher matcher = Pattern.compile(REGEX).matcher(delimiterAndNumbers);
            if (matcher.matches()) {
                String delimiter = matcher.group(1);
                String toSplit = matcher.group(2);
                return  toSplit.split(delimiter);
            }
            throw new RuntimeException("Wrong regex for custom delimiter");
        }
        return delimiterAndNumbers.split(",|\n");
    }
}
