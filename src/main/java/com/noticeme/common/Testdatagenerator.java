package com.noticeme.common;

import com.noticeme.model.Benachrichtigung;
import com.noticeme.model.Note;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

public class Testdatagenerator {

    private static final List<Note> TEST_DATA = List.of(new Note("Testtitel", "Testnote", LocalDateTime.now(), "daheim"),
            new Note("Leernote", "Leertitel", LocalDateTime.of(2021, Month.MARCH, 3, 4, 5)),
            new Benachrichtigung("Benachrichtigung", "Notiz", LocalDateTime.now(), "wo", LocalDateTime.of(2022, Month.MARCH, 5, 4, 3)));

//List.of(new Note("Testtitel", "Testnote", LocalDateTime.of(2001, Month.AUGUST, 9, 15, 15), "daheim"),
//            new Note("Leernote", "Leertitel", LocalDateTime.of(2021, Month.MARCH, 3, 4, 5)),
//            new Benachrichtigung("Benachrichtigung", "Notiz", LocalDateTime.of(2022, Month.SEPTEMBER, 1, 8, 0), "wo", LocalDateTime.of(2022, Month.MARCH, 5, 4, 3)));


    public static List<Note> generateTestDaten() {
        return TEST_DATA;
    }

}
