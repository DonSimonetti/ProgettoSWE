package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExampleTest
{
    @Test
    void bTest()
    {
        boolean iTest=true;
        Assertions.assertTrue(iTest);
    }

    @Test
    void iTest()
    {
        int iTest=5;
        Assertions.assertEquals(iTest,5);
    }
}
