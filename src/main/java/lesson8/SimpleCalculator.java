package lesson8;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SimpleCalculator {
    private String expression;
    private List<Character> signs = new ArrayList<>();
    private List<BigDecimal> baseNumbers = new ArrayList<>();

    public SimpleCalculator(String expression) {
        this.expression = expression;
    }

    private String intoParentheses() {

        if (!expression.contains("(") && !expression.contains(")")) {
            return expression;
        }
        else {
            char [] b =expression.toCharArray();
            int a = 0;
            for (int n =0; n< b.length; n++) {
                if (b[n]=='(')
                    a++;
            }

            for (int i = 0; i < a; i++) {
                try {

                    int index1 = expression.indexOf('(');
                    int index2 = expression.indexOf(')');

                    String first = expression.substring(0, index1);
                    String second = expression.substring(index2 + 1);
                    String brick = expression.substring(index1 + 1, index2);

                    BigDecimal result;
                    List<BigDecimal> finalNumbers = createNewList(brick);

                    result = finalNumbers.get(0);
                    for (int j = 0; j < signs.size(); j++) {
                        if (signs.get(j) == '+') {
                            result = result.add(finalNumbers.get(j + 1));
                        } else {
                            result = result.subtract(finalNumbers.get(j + 1));
                        }
                    }
                    baseNumbers.add(result);
                    expression = first + "X" + second;
                    signs.clear();
                    finalNumbers.clear();

                } catch (RuntimeException e) {
                    throw new RuntimeException("Нарушена простановка скобок");
                }
            }
        }
        return expression;
    }

    private List<BigDecimal> determinateSignAndNumbers(String expression) {

        List<BigDecimal> numbers = new ArrayList<>();

        char[] chars = expression.toCharArray();
        String result = "";
        BigDecimal number;

        for (int i = 0; i < chars.length; i++) {

            if (chars[i] == '+' || chars[i] == '-' || chars[i] == '*' || chars[i] == '/') {
                signs.add(chars[i]);
                try {
                    if(chars[i-1]  != 'X') {
                        number = BigDecimal.valueOf(Double.parseDouble(result));
                        numbers.add(number);
                    }
                } catch (NumberFormatException e ) {
                    throw new NumberFormatException("Неверно указан формат числа");
                }
                result = "";
            }
            else if (chars[i] == 'X') {
                numbers.add(baseNumbers.get(0));
                baseNumbers.remove(0);
            }

            else {
                result += chars[i];
                if (i == expression.length() - 1) {
                    try {
                        number = BigDecimal.valueOf(Double.parseDouble(result));
                        numbers.add(number);
                    } catch (NumberFormatException e) {
                        throw new NumberFormatException("Неверно указан формат числа");
                    }
                }
            }
        }
        return numbers;
    }

    private List<BigDecimal> createNewList(String expression) {

        List<BigDecimal> numbers = determinateSignAndNumbers(expression);
        List<BigDecimal> finalNumbers = new ArrayList<>();

        BigDecimal finalresult = new BigDecimal(String.valueOf(numbers.get(0)));

        for (int i = 0; i < signs.size(); i++) {
            if (i == signs.size() - 1) {
                if (signs.get(i) == '-') {
                    finalNumbers.add(finalresult);
                    finalNumbers.add(numbers.get(i + 1));
                }
                if (signs.get(i) == '+') {
                    finalNumbers.add(finalresult);
                    finalNumbers.add(numbers.get(i + 1));
                }
                if (signs.get(i) == '*')
                    finalNumbers.add(numbers.get(i).multiply(numbers.get(i + 1)));
                if (signs.get(i) == '/')
                    finalNumbers.add(numbers.get(i).divide(numbers.get(i + 1)));
            }
            else if (signs.get(i) == '*') {
                finalresult = numbers.get(i).multiply(numbers.get(i + 1));
                numbers.set(i + 1, finalresult);
            } else if (signs.get(i) == '/') {
                finalresult = numbers.get(i).divide(numbers.get(i + 1));
                numbers.set(i + 1, finalresult);
            } else if (signs.get(i) == '+' || signs.get(i) == '-') {
                finalNumbers.add(numbers.get(i));
                finalresult = numbers.get(i + 1);
            }
        }
        signs.removeIf(character -> character == '*' || character == '/');
        return finalNumbers;
    }

    public BigDecimal calculate() {

        intoParentheses();

        BigDecimal result;
        List<BigDecimal> finalNumbers = createNewList(expression);

        try {

            result = finalNumbers.get(0);
            for (int i = 0; i < signs.size(); i++) {
                if (signs.get(i) == '+') {
                    result = result.add(finalNumbers.get(i + 1));
                } else {
                    result = result.subtract(finalNumbers.get(i + 1));
                }
            }
            return result;
        } catch (IndexOutOfBoundsException e) {
            throw new RuntimeException("Введены некорректные символы");
        }
    }
}
