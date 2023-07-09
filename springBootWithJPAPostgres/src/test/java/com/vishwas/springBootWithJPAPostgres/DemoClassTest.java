package com.vishwas.springBootWithJPAPostgres;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class DemoClassTest {

    DemoClass demoClass;

    @Test
    public void testMultiply(){
        demoClass = new DemoClass();
        assertEquals(28, demoClass.multiply(7,4));
        assertEquals(14, demoClass.multiply(7,2));
    }

    @Test
    public void testDivide(){
        demoClass = new DemoClass();
        assertEquals(2, demoClass.divide(10,5));
    }

    //USING ASSERTJ METHODS
    @Test
    public void testMultiplyDifferently (){
        demoClass = new DemoClass();
        int multiplyVal = demoClass.multiply(2,5);
        int expectedVal = 10;
        assertThat(multiplyVal).isEqualTo(expectedVal);
    }
}
