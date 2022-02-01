package calculator;

public class StringCalculatorUtils {
    private static final String EMPTY_STRING = "";
    private static final String SPLIT_REGEX = " ";
    private static final float DEFAULT_FLOAT_VALUE = 0F;

    private StringCalculatorUtils() {
    }

    public static float calculate(String input) {
        String[] inputs = input.split(SPLIT_REGEX);
        float result = DEFAULT_FLOAT_VALUE;
        String sign = EMPTY_STRING;
        for (int i = 0; i < inputs.length; i++) {
            if (isSign(i)) {
                sign = inputs[i];
                continue;
            }
            int num = convertNumFromString(inputs[i]);
            result = calculateSign(result, sign, num);
        }
        return result;
    }

    private static boolean isSign(int i) {
        return i % 2 == 1;
    }

    private static int convertNumFromString(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("변환할 수 없는 문자가 포함되어 있습니다: " + input);
        }
    }

    private static float calculateSign(float num1, String sign, int num2) {
        if (num1 == DEFAULT_FLOAT_VALUE) {
            return num2;
        }
        switch (sign) {
            case "+":
                return plus(num1, num2);
            case "-":
                return minus(num1, num2);
            case "*":
                return mul(num1, num2);
            case "/":
                return sub(num1, num2);
            default:
                throw new IllegalArgumentException("잘못된 부호 입니다.");
        }
    }

    private static float plus(float num1, int num2) {
        return num1 + num2;
    }

    private static float minus(float num1, int num2) {
        return num1 - num2;
    }

    private static float mul(float num1, int num2) {
        return num1 * num2;
    }

    private static float sub(float num1, int num2) {
        return num1 / num2;
    }
}
