package com.jpmc.util;

import org.junit.jupiter.api.Test;

import com.jpmc.util.LocalDateProvider;

public class LocalDateProviderTests {
    @Test
    void makeSureCurrentDate() {
        System.out.println("current date (YYYY-MM-DD) is: " + LocalDateProvider.singleton().currentDate());
    }
    
    @Test
    void makeSurePassedDateIsCorrect() {
        System.out.println("Passed date (YYYY-MM-DD) is: " + LocalDateProvider.singleton().parseDate("2023-03-07"));
    }
}
