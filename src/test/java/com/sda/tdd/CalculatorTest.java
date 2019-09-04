package com.sda.tdd;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/*
 * Create a simple String calculator containing a method 'add'
 * Contract should look like: int add(String numbers)
 *
 * Method rules (TDD steps):
 * Input should be numbers separated by ','
 * For an empty string it will return 0
 * The method can take 0, 1 or 2 numbers as parameters (limited)
 * The method should return the numbers' sum
 * Allow the Add method to handle an unknown amount of numbers
 * Allow the Add method to handle new lines between numbers
 * instead of only commas)
 * The following input is ok: “1\n2,3” (will equal 6)
 * Calling add(numbers) with a negative number will throw an
 * exception with the message “negatives not allowed”
 */

public class CalculatorTest {

    private Calculator target=new Calculator();

    @Test
    public void test1(){
        assertEquals(0,target.add(""));
    }

    @Test
    public void test2(){
        assertEquals(0+1+2+3, target.add("0,1,2,3"));
    }

    @Test
    public void test3(){
        assertEquals(100,target.add("100"));
        assertEquals(100,target.add("20,80"));
    }

    @Test
    public void test4(){
        assertEquals(0+1+2+3, target.add("0,1\n2,3"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test5(){
        target.add("-1,0");
    }


    /*
     * Create a method 'product'
     * Contract should look like: long product(List<String> numbers)
     *
     * Method rules (TDD steps):
     * For an empty input return 0
     * The method can take 0, 1 or 2 numbers as parameters (limited)
     * The method should return the numbers' product
     * Allow the product method to handle an unknown amount of numbers
     * product should only receive numbers smaller than 20
     */

    //tests for product
    List<String> numbers=new LinkedList<>();

    @Test
    public void testProduct1(){
        assertEquals(0,target.product(numbers));
    }

    @Test
    public void testProduct2(){
        numbers.add("1");
        numbers.add("2");
        numbers.add("3");
        target.product(numbers);
    }

    @Test
    public void testProduct3(){
        numbers.add("2");
        numbers.add("3");
        assertEquals(6,target.product(numbers));
    }

    @Test
    public void testProduct4(){
        numbers.add("1");
        numbers.add("2");
        numbers.add("20");
        numbers.add("21");
        numbers.add("5");
        assertEquals(10,target.product(numbers));
    }
}