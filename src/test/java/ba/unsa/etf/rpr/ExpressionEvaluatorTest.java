package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionEvaluatorTest {
    @Test
    void evaluate1() {
        double x = ExpressionEvaluator.evaluate("( 3723 + 1 )");
        assertEquals(3724,x);
    }

    @Test
    void evaluate2() {
        double x = ExpressionEvaluator.evaluate("( 43.21 + 0.79 )");
        assertEquals(44,x);
    }

    @Test
    void evaluate3() {
        double x = ExpressionEvaluator.evaluate("( 36 / ( 2 + 4 ) )");
        assertEquals(6,x);
    }

    @Test
    void evaluate4() {
        assertThrows(RuntimeException.class, () -> {
            double x = ExpressionEvaluator.evaluate("( 1 + 2)");
        });
    }

    @Test
    void evaluate5() {
        assertThrows(RuntimeException.class, () -> {
            double x = ExpressionEvaluator.evaluate("( x + y )");
        });
    }

    @Test
    void evaluate6() {
        assertThrows(RuntimeException.class, () -> {
            double x = ExpressionEvaluator.evaluate("( 23 * 5 ? )");
        });
    }

    @Test
    void evaluate7() {
        assertThrows(RuntimeException.class, () -> {
            double x = ExpressionEvaluator.evaluate("(  2 + 2 )");
        });
    }

    @Test
    void evaluate8() {
        assertThrows(RuntimeException.class, () -> {
            double x = ExpressionEvaluator.evaluate("( 10 + 20 + 30 )");
        });
    }

    @Test
    void evaluate9() {
        double x = ExpressionEvaluator.evaluate("sqrt ( 25 )");
        assertEquals(5,x);
    }

    @Test
    void evaluate10() {
        assertThrows(RuntimeException.class, () -> {
            double x = ExpressionEvaluator.evaluate("( sqrt ( 25 ) )");
        });
    }

    @Test
    void evaluate11() {
        assertThrows(RuntimeException.class, () -> {
            double x = ExpressionEvaluator.evaluate("( ( 3 + 4 ) * 5 ) )");
        });
    }

    @Test
    void evaluate12() {
        assertThrows(RuntimeException.class, () -> {
            double x = ExpressionEvaluator.evaluate("( 10 / 10 ( ) )");
        });
    }

    @Test
    void evaluate13() {
        assertThrows(RuntimeException.class, () -> {
            double x = ExpressionEvaluator.evaluate("( 12 + + 34 )");
        });
    }

    @Test
    void evaluate14() {
        assertThrows(RuntimeException.class, () -> {
            double x = ExpressionEvaluator.evaluate("( 7 7 )");
        });
    }

    @Test
    void evaluate15(){
        assertEquals(6.15,ExpressionEvaluator.evaluate("( 9.4 - ( 2 * ( 52 / 32 ) ) )"));
    }
}