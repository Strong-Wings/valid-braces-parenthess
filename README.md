# Определение валидной последовательности скобок () 

Используем стек, в котором храним открывающиеся скобки с соответствующими индексами.
По достижении закрывающейся скобки проверяем, не пустой ли стек.
Если не пустой - добавляем обе скобки в список валидных скобок validBraces.
Сортируем список validBraces по индексам и объединяем в строку.
Выводим входную строку, валидную последовательность скобок и её длину.

Пример вывода:

```
Input string: "(()"
Valid string: "()" with 2 braces

Input string: ")()())"
Valid string: "()()" with 4 braces

Input string: ")(()())"
Valid string: "(()())" with 6 braces

Input string: ")("
Valid string: "" with 0 braces

Input string: ")(()()"
Valid string: "()()" with 4 braces

Input string: "((((((((()))))))))"
Valid string: "((((((((()))))))))" with 18 braces

Input string: ")))))))))))))))))()"
Valid string: "()" with 2 braces

Input string: "()()))()((()())()()((((((())()())"
Valid string: "()()()(()())()()((())()())" with 26 braces
```