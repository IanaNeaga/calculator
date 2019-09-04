package com.sda.calculator;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorTest {

    @Mock
    private Calculator target;

    //alternativa
    private Calculator calculator=new Calculator();
    private Calculator spyCalculator=spy(calculator);

    @Before
    public void setUP(){
        when(target.divide(anyInt(), eq(0))).thenReturn(0);
        when(target.divide(2,2)).thenReturn(1);

        //initializez 'spion'
        doReturn(0)
                .when(spyCalculator)
                .divide(anyInt(),eq(0));
    }

    @Test
    public void divide() {
        assertEquals(1,target.divide(2,2));
//        assertEquals(10,target.divide(100,10));
        verify(target, times(0))
                .getDivisionResult(anyInt(),anyInt());
    }

    @Ignore
    @Test
    public void testZeroDivision(){
        assertEquals(0,target.divide(2,0));
    }

    @Test
    public void testSpy(){
        assertEquals(0,spyCalculator.divide(10,0));
        assertEquals(1,spyCalculator.divide(100,100));

        verify(spyCalculator, times(1))
                .getDivisionResult(anyInt(),anyInt());
        /*
        verify(mock, times(x))
        cazul exact o data: verify(mock,times(1)) sau verify(mock)
        cazul minim o data: verify(mock, atLeastOnce()) sau atLeast(1)
        cazul maxim: verify(mock, atMost())
        cazul niciodata: verify(mock, never())
         */
    }
}