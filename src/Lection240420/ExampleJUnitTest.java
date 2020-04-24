package Lection240420;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ExampleJUnitTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/qwe.csv", numLinesToSkip = 1)
    @Order(3)
    void testConvert(int ball,int expResult) {
        // perform assertions against null values
        ExampleJUnit  ex=new ExampleJUnit();
        assertEquals(expResult,ex.convert(ball));
    }

    @Test
    @Order(2)
    void emptyValues() {
        // perform assertions against empty values
    }

    @Test
    @Order(1)
    void validValues() {
        // perform assertions against valid values
    }

}