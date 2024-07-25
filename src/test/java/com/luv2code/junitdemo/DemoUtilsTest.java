package com.luv2code.junitdemo;

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DemoUtilsTest {

    private DemoUtils demoUtils;

    @BeforeEach
    void setUp() {
        demoUtils = new DemoUtils();
    }

    @Test
    @DisplayName("Equals and Not Equals")
    @Order(3)
    void testEqualsAndNotEquals() {
        int expected = 6;
        int unexpected = 8;

        // execute
        int actual = demoUtils.add(2, 4);

        // assert
        Assertions.assertEquals(expected, actual, "2+4 must be 6");
        Assertions.assertNotEquals(unexpected, actual, "2+4 must not be 8");
    }

    @Test
    @DisplayName("Null and Not Null")
    @Order(-7)
    void testCheckIsNullOrNotNull() {
        String str1 = null;
        String str2 = "luv2code";

        // assert
        assertNull(demoUtils.checkNull(str1), "Object should be null");
        assertNotNull(demoUtils.checkNull(str2), "Object should not be null");
    }

    @Test
    @DisplayName("Same and Not Same")
    void testSameAndNotSame() {
        String str = "luv2code";

        assertSame(demoUtils.getAcademy(), demoUtils.getAcademyDuplicate(), "Objects should refer to same object");
        assertNotSame(str, demoUtils.getAcademy(), "Objects should not refer to same object");
    }

    @Test
    @DisplayName("True and False")
    void testTrueFalse() {
        int gradeOne = 10;
        int gradeTwo = 5;

        assertTrue(demoUtils.isGreater(gradeOne, gradeTwo), "This should return true");
        assertFalse(demoUtils.isGreater(gradeTwo, gradeOne), "This should return false");
    }

    @Test
    @DisplayName("Array Equals")
    void testArrayEquals() {
        String[] stringArray = {"A", "B", "C"};

        assertArrayEquals(stringArray, demoUtils.getFirstThreeLettersOfAlphabet(), "Arrays should be the same");
    }

    @Test
    @DisplayName("Iterable equals")
    void testIterableEquals() {
        List<String> stringList = List.of("luv", "2", "code");

        assertIterableEquals(stringList, demoUtils.getAcademyInList(), "Expected list should be same as actual list");
    }

    @Test
    @DisplayName("Lines match")
    void testLinesMatch() {
        List<String> stringList = List.of("luv", "2", "code");

        assertLinesMatch(stringList, demoUtils.getAcademyInList(), "Lines should match");
    }

    @Test
    @DisplayName("Throws and Does Not Throw")
    void testThrowsAndDoesNotThrow() {
        assertThrows(Exception.class, () -> {demoUtils.throwException(-1); }, "Should throw exception");

        assertDoesNotThrow(() -> {demoUtils.throwException(9); }, "Should not throw exception");
    }

    @Test
    @DisplayName("Timeout")
    @Order(1)
    void testTimeout() {
        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> {demoUtils.checkTimeout();}, "Method should execute in 3 seconds");
    }
}