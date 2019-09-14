package laba_1;

import org.junit.Assert;
import org.junit.Test;

public class RotationTest {

    @Test
    public void multiplicationMatriz() {
        double[][] mA =
                {{33,34,12},
                        {33,19,10},
                        {12,14,17},
                        {84,24,51},
                        {43,71,21}};

        double[][] mB =
                {{10,11,34,55},
                        {33,45,17,81},
                        {45,63,12,16}};

        double res[][] = {
                {1992,   2649,   1844,   4761},
                {1407,   1848 ,  1565   ,3514},
                        {1347,   1833 ,   850 , 2066},
                                {3927  , 5217 ,  3876  , 7380},
                                        {3718  , 4991   ,2921  , 8452}
        };

        Assert.assertEquals(res, Matriz.multiplicationMatriz(mA, mB));
    }
}
