import static junit.framework.TestCase.assertEquals;

import org.junit.Before;
import org.junit.Test;

/** Yingqi Zhang
 * CS 5004
 * 22 Spring
 * A Junit test class for the paycheck class. */
public class PaycheckTest {
  Paycheck paycheck1;
  Paycheck paycheck2;
  Paycheck paycheck3;
  Paycheck paycheck4;

  /**
   * set up four paycheck objects.
   */
  @Before
  public void setUp() {
    paycheck1 = new Paycheck(5.60, 30);
    paycheck2 = new Paycheck(5.60, 100);
    paycheck3 = new Paycheck(80.00, 30);
    paycheck4 = new Paycheck(80.00, 100);
  }

  /**
   * test the getTotalPay method.
   * first, test the worked hour <= 40.
   * second, test work hour > 40.
   * third, test the worked hour <= 40 with different payrate
   * fourth, test the worked hour > 40 with different payrate
   */
  @Test
  public void testGetTotalPay() {
    assertEquals(168.00, paycheck1.getTotalPay(), 0.01);
    assertEquals(728.00, paycheck2.getTotalPay(), 0.01);
    assertEquals(2400.00, paycheck3.getTotalPay(), 0.01);
    assertEquals(10400.00, paycheck4.getTotalPay(), 0.01);
  }

  /**
   * test thr getPayAfterTexas method.
   * first, test the worked hour <= 40.
   * second, test work hour > 40.
   * third, test the worked hour <= 40 with different payrate
   * fourth, test the worked hour > 40 with different payrate
   */
  @Test
  public void testGetPayAfterTaxes() {
    assertEquals(151.20, paycheck1.getPayAfterTaxes(), 0.01);
    assertEquals(618.80, paycheck2.getPayAfterTaxes(), 0.01);
    assertEquals(2040.00, paycheck3.getPayAfterTaxes(), 0.01);
    assertEquals(8840.00, paycheck4.getPayAfterTaxes(), 0.01);
  }

  /**
   * test thr toString method.
   * first, test the worked hour <= 40.
   * second, test work hour > 40.
   * third, test the worked hour <= 40 with different payrate
   * fourth, test the worked hour > 40 with different payrate
   */
  @Test
  public void testToString() {
    assertEquals("Payment after taxes: $ 151.20", paycheck1.toString());
    assertEquals("Payment after taxes: $ 618.80", paycheck2.toString());
    assertEquals("Payment after taxes: $ 2040.00", paycheck3.toString());
    assertEquals("Payment after taxes: $ 8840.00", paycheck4.toString());
  }
}