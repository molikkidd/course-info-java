package com.pluralsight.courseinfo.cli.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PluralSightCourseTest {

    @Test
    void durationInMinutes() {
        PluralSightCourse course = new PluralSightCourse("id", "test-course", "00:20:55", "url", false);
        assertEquals(20, course.durationInMinutes());
    }

    @Test
    void durationInMinutesOverHour() {
        PluralSightCourse course = new PluralSightCourse("id", "test-course", "01:20:55.88", "url", false);
        assertEquals(80, course.durationInMinutes());
    }

    @Test
    void durationInMinutesZero() {
        PluralSightCourse course = new PluralSightCourse("id", "test-course", "00:00:00.00", "url", false);
        assertEquals(0, course.durationInMinutes());
    }

}