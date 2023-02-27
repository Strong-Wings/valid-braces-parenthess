package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        determineValidParentheses("(()");
        determineValidParentheses(")()())");
        determineValidParentheses(")(()())");
        determineValidParentheses(")(");
        determineValidParentheses(")(()()");
        determineValidParentheses("((((((((()))))))))");
        determineValidParentheses(")))))))))))))))))()");
        determineValidParentheses("()()))()((()())()()((((((())()())");
    }

    /**
     * Используем стек, в котором храним открывающиеся скобки с соответствующими индексами.
     * По достижении закрывающейся скобки проверяем, не пустой ли стек.
     * Если не пустой - добавляем обе скобки в список валидных скобок validBraces.
     * Сортируем список validBraces по индексам и объединяем в строку.
     * Выводим входную строку, валидную последовательность скобок и её длину.
     *
     * @param inputString входная строка
     */
    private static void determineValidParentheses(String inputString) {
        List<CharacterAndIndex> validBraces = new ArrayList<>();
        Stack<CharacterAndIndex> stack = new Stack<>();

        for (int index = 0; index < inputString.length(); index++) {
            char currentCharacter = inputString.charAt(index);
            if (currentCharacter == '(') {
                stack.push(new CharacterAndIndex(currentCharacter, index));
            } else if (currentCharacter == ')' && !stack.isEmpty()) {
                validBraces.add(stack.pop());
                validBraces.add(new CharacterAndIndex(currentCharacter, index));
            }
        }
        var validString = validBraces.stream()
                .sorted(Comparator.comparing(CharacterAndIndex::getIndex))
                .map(CharacterAndIndex::getCharacter)
                .map(String::valueOf)
                .collect(Collectors.joining());

        System.out.printf("Input string: \"%s\"\n", inputString);
        System.out.printf("Valid string: \"%s\" with %d braces\n\n", validString, validString.length());
    }

    /**
     * Класс для хранения символа и соответствующего ему индекса строки
     *
     */
    private static class CharacterAndIndex {
        char character;
        int index;
        public CharacterAndIndex(char c, int i) {
            this.character = c;
            this.index = i;
        }

        public char getCharacter() {
            return this.character;
        }

        public int getIndex() {
            return this.index;
        }
    }
}
