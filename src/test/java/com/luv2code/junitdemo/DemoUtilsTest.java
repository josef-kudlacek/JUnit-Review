package com.luv2code.junitdemo;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class DemoUtilsTest {

    private DemoUtils demoUtils;

//    @BeforeAll
//    static void beforeAll() {
//        System.out.println("@BeforeAll executes only once before the execution of all test methods in class");
//    }
//
    @BeforeEach
    void beforeEach() {
        demoUtils = new DemoUtils();
        System.out.println("@BeforeEach executes before the execution of each test method");
    }
//
//    @AfterEach
//    void afterEach() {
//        System.out.println("Running @AfterEach");
//        System.out.println();
//    }
//
//    @AfterAll
//    static void afterAll() {
//        System.out.println("@AfterAll executes after the execution of all test methods in class");
//    }

    @Test
//    @DisplayName("Equals and Not Equals")
    void test_Equals_AndNotEquals() {
        int expected = 6;
        int unexpected = 8;

        // execute
        int actual = demoUtils.add(2, 4);

        // assert
        Assertions.assertEquals(expected, actual, "2+4 must be 6");
        Assertions.assertNotEquals(unexpected, actual, "2+4 must not be 8");
    }

    @Test
//    @DisplayName("Null and Not Null")
    void test_CheckIsNull_OrNotNull() {
        String str1 = null;
        String str2 = "luv2code";

        // assert
        assertNull(demoUtils.checkNull(str1), "Object should be null");
        assertNotNull(demoUtils.checkNull(str2), "Object should not be null");
    }
}