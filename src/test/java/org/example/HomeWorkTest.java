package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HomeWorkTest {

    // Метод реализованный на TreeMap
    @Test
    void findMaxSubstringTest(){
        HomeWork homeWork = new HomeWork();
        // Тест из задания
        assertEquals("abcd", homeWork.findMaxSubstring("abcddcba"));
        assertEquals("dcbaX", homeWork.findMaxSubstring("abcddcbaX"));
        // Проверим на null
        assertEquals("", homeWork.findMaxSubstring(null));
        // На пустую строку
        assertEquals("", homeWork.findMaxSubstring(null));
        // Другие проверки
        assertEquals("abcde", homeWork.findMaxSubstring("abcddcbaabcde"));
        assertEquals("dc", homeWork.findMaxSubstring("ddddddddddddcccccccc"));
    }

    // Теми же тестами проверяю метод реализованный на String
    @Test
    void findMaxSubstringSimpleTest(){
        HomeWork homeWork = new HomeWork();
        // Тест из задания
        assertEquals("abcd", homeWork.findMaxSubstringSimple("abcddcba"));
        assertEquals("dcbaX", homeWork.findMaxSubstringSimple("abcddcbaX"));
        // Проверим на null
        assertEquals("", homeWork.findMaxSubstringSimple(null));
        // На пустую строку
        assertEquals("", homeWork.findMaxSubstringSimple(null));
        // Другие проверки
        assertEquals("abcde", homeWork.findMaxSubstringSimple("abcddcbaabcde"));
        assertEquals("dc", homeWork.findMaxSubstringSimple("ddddddddddddcccccccc"));
    }

    @Test
    void checkTest(){
        HomeWork homeWork = new HomeWork();
        // Тест из задания
        assertTrue(homeWork.check("The quick brown fox jumps over the lazy dog"));
        // Тест на null
        assertFalse(homeWork.check(null));
        // Проверяем на пустую строку
        assertFalse(homeWork.check(""));
        // Обычная строка со всеми буквами
        assertTrue(homeWork.check("abcdefghijklmnopqrstuvwxyz"));
        // Обычная строка не со всеми буквами
        assertFalse(homeWork.check("abcdefghijklmnopqrstuvwxy"));
        // Обычная строка со всеми буквами по 2 раза
        assertTrue(homeWork.check("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"));
        // Обычная строка со всеми буквами с заглавными
        assertTrue(homeWork.check("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"));
        // Проверим на разные знаки
        assertTrue(homeWork.check(" .,:!?-;_+&%$#@!abcdefghijklmnopqrstuvwxyz"));
    }
}
