package org.example;

import java.util.List;


public class HomeWork {

    /**
     * <h1>Задание 1.</h1>
     * Метод возвращает подстроку максимальной длины в которой не повторяются символы
     * Если найдено несколько подстрок одинаковой длины - вернуть первую.
     *
     * Пример 1 вход= abcddcba, выход = abcd
     * Так как найдены две подстроки с неповторяющимися значениями:
     * 1) abcd
     * 2) dcba
     * Они динаковой длины, по этому возвращаем 1 строку
     *
     * Пример 2 вход= abcddcbaX, выход = dcbaX
     * Так как эта подстрока самая большая
     *
     * @param str входная не пустая строка
     * @return максимальная подстрока из уникальных значений
     * Сигнатуру метода не меняем
     */
public String findMaxSubstring(String str) {

        // Проверка на null
        if (str == null) {
            return "";
        }
        // Используем TreeMap, где ключ - размер строки, значение сама строка
        TreeMap tree = new TreeMap<Integer, String>();
        // Временная строка
        String tmp = new String();
        // Разобъем строку на массив символов для цикла
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            // Если символа нет в временной строке, то добавляем его в строку
            if (tmp.indexOf(charArray[i]) < 0) {
                tmp = tmp + charArray[i];
                // Если символ есть, заканчиваем строку
            } else {
                // Если строка такой длины уже есть, не вносим ее в tree
                tree.putIfAbsent(tmp.length(), tmp);
                tmp = new String();
                tmp = tmp + charArray[i];
            }
            // Проверка последней строки цикла перед закрытием
            if (i == charArray.length - 1) {
                tree.putIfAbsent(tmp.length(), tmp);
            }
        }

        System.out.println(tree.get(tree.lastKey()));
        return tree.get(tree.lastKey()).toString();
    }

    // Без TreeMap только на строках
    public String findMaxSubstringSimple(String str) {

        // Проверка на null
        if (str == null) {
            return "";
        }

        int maxSize = 0;
        String finalStr = new String();
        // Временная строка
        String tmp = new String();
        // Разобъем строку на массив символов для цикла
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            // Если символа нет в временной строке, то добавляем его
            if (tmp.indexOf(charArray[i]) < 0) {
                tmp = tmp + charArray[i];
                // Если символ есть, заканчиваем строку и проверяем ее размер
            } else {
                // Если размер больше текущего максимального, меняем финальную строку и макс. раземер
                if (maxSize < tmp.length()) {
                    maxSize = tmp.length();
                    finalStr = tmp;
                }
                tmp = new String();
                tmp = tmp + charArray[i];
            }
            // Проверка последней строки цикла перед закрытием
            if (i == charArray.length - 1) {
                if (maxSize < tmp.length()) {
                    finalStr = tmp;
                }
            }
        }

        System.out.println(finalStr);
        return finalStr;
    }

    /**
     * Задача со зведочкой (опционально)
     * <br/>
     * Можно решать так же для английского алфавита, проверять что присутствуют буквы от A до Z хотя бы по одному разу.
     * <br/>
     * A pangram is a sentence that contains every single letter of the alphabet at least once. For example, the sentence "The quick brown fox jumps over the lazy dog" is a pangram, because it uses the letters A-Z at least once (case is irrelevant).
     *
     * Given a string, detect whether or not it is a pangram. Return True if it is, False if not. Ignore numbers and punctuation.
     * @see <a href="https://www.codewars.com/kata/545cedaa9943f7fe7b000048">https://www.codewars.com/kata/545cedaa9943f7fe7b000048</a>
     */
    // Метод реализован для англ языка, можно параметризовать под выбор языка
    public boolean check(String sentence) {

        if(sentence == null || sentence.isEmpty()){
            return false;
        }
        // Строки можно менять при параметризации языка
        // строка алфавита в нижнем регистре
        String abc = "abcdefghijklmnopqrstuvwxyz";
        // regex для языка: [^а-яёА-ЯЁ] - рус,  [^a-zA-Z] - англ, [^a-zA-Zа-яёА-ЯЁ] - рус и анг
        String regexAbc = "[^a-zA-Z]";

        HashSet set = new HashSet();
        char[] charArray = abc.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            set.add(charArray[i]);
        }

        // Оставляем в строке только англ и рус буквы в нижнем регистре, если их нет вернем false
        sentence = sentence.replaceAll(regexAbc, "").toLowerCase();
        if (sentence.isEmpty()){
            return false;
        }
        // Оставшуюся строку разбиваем на символы в массив
        char[] chArray = sentence.toCharArray();
        for (int i = 0; i < chArray.length; i++) {
            // удаляем букву из множества
            set.remove(chArray[i]);
        }
        // Если не все буквы удалены, то строка не pangram
        if (set.size() > 0) {
            return false;
        }
        return true;
    }

}
