package com.sda.tdd;

import java.util.List;

public class Calculator {

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

    public int add(String numbers) {
        if ("".equals(numbers)) {
            return 0;
        }
        String[] split = numbers.split(",|\n");
        int sum = 0;
        for (String temp : split) {
            int value = Integer.parseInt(temp);
            if (value < 0) {
                throw new IllegalArgumentException("negatives not allowed");
            }
            sum += Integer.valueOf(temp);
        }
        return sum;
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

    public long product(List<String> numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        long product = 1;
        for (String temp : numbers) {
            long value = Long.parseLong(temp);
            if (value > 19) {
                System.out.println("numarul " + temp + " nu este suportat");
                //varianta 1:
                continue;
            }
            product *= value;
        }

        //varianta 2:
//        for (String temp : numbers) {
//            if (Long.parseLong(temp) > 20) {
//                System.out.println("numarul " + temp + " nu este suportat");
//            } else {
//                product *= Long.parseLong(temp);
//            }
//        }

        return product;
    }
}
