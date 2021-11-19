package study.programmers.level2;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MaximumExpression {
    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String MULTIPLY = "*";
    private static final int ALL_CASE_COUNT = 6;
    private static final int OPERATION_COUNT = 3;

    public long solution(String expression) {
        Deque<String> expressionStack = createExpressionStatck(expression);
        return Arrays.stream(createOpeartionMix())
            .map(operations -> Math.abs(operateByOrder(new ArrayDeque<>(expressionStack), operations)))
            .max(Comparator.comparingLong(Long::longValue))
            .orElse(0L);
    }

    private Deque<String> createExpressionStatck(String expression) {
        Deque<String> expressionStack = new ArrayDeque<>();

        Pattern pattern = Pattern.compile("\\d{1,3}|[+\\-*]");
        Matcher matcher = pattern.matcher(expression);

        while (matcher.find()) {
            String group = matcher.group();
            expressionStack.push(group);
        }
        return expressionStack;
    }

    private String[] toArray(Deque<String> expressionStack) {
        String[] expressionArray = expressionStack.toArray(new String[]{});
        List<String> expressionList = Arrays.asList(expressionArray);
        Collections.reverse(expressionList);
        return expressionList.toArray(new String[]{});
    }

    private String[][] createOpeartionMix() {
        String[] operationArray = {PLUS, MINUS, MULTIPLY};
        String[][] operationCombine = new String[ALL_CASE_COUNT][];
        int index = 0;
        for (int i = 0; i < OPERATION_COUNT; i++) {
            for (int j = 0; j < OPERATION_COUNT; j++) {
                if (i != j) {
                    for (int k = 0; k < OPERATION_COUNT; k++) {
                        if (i != k && j != k) {
                            operationCombine[index++] = new String[]{operationArray[i], operationArray[j], operationArray[k]};
                        }
                    }
                }
            }
        }
        return operationCombine;
    }

    private long operateByOrder(Deque<String> expressionStack, String[] operations) {
        for (String operation : operations) {
            String[] expressionArray = toArray(expressionStack);
            expressionStack.clear();
            operateAll(expressionStack, expressionArray, operation);
        }
        return Long.parseLong(expressionStack.pop());
    }

    private void operateAll(Deque<String> expressionStack, String[] expressionArray, String operator) {
        for (int i = 0; i < expressionArray.length; i++) {
            String expression = expressionArray[i];
            if (isOperator(expression)) {
                if (expression.equals(operator)) {
                    expressionStack.push(Long.toString(operate(expressionStack, expressionArray[++i], operator)));
                } else {
                    expressionStack.push(expression);
                }
            } else {
                expressionStack.push(expression);
            }
        }
    }

    private long operate(Deque<String> expressionStack, String nextTerm, String operator) {
        long stackValue = Long.parseLong(expressionStack.pop());
        long nextNumber = Long.parseLong(nextTerm);
        switch (operator) {
            case PLUS:
                return stackValue + nextNumber;
            case MINUS:
                return stackValue - nextNumber;
            case MULTIPLY:
                return stackValue * nextNumber;
            default:
                return 0;
        }
    }

    private boolean isOperator(String str) {
        return str.equals(PLUS) || str.equals(MINUS) || str.equals(MULTIPLY);
    }
}
