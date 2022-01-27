import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/** Yingqi Zhang
 * CS 5004
 * 22 Spring
 * A JUnit test class for the employee class. */
public class EmployeeTest {
  private Employee May;
  private Employee Ricky;

  /**
   * set up the employee test objects.
   */
  @Before
  public void setUp() {
    May = new Employee("May", "9623", 80);
    Ricky = new Employee("Ricky", "9521", 5.60);
  }

  /**
   * test the addHourWorked method.
   * first, test a very small negative integer.
   * second, test a very big positive integer.
   * third, test the special integer 0
   */
  @Test
  public void testAddHoursWorked() {
    May.addHoursWorked(-1000);
    assertEquals(0, May.getHoursWorked(), 0.01);
    Ricky.addHoursWorked(1000);
    assertEquals(1000, Ricky.getHoursWorked(), 0.01);
    May.addHoursWorked(0);
    assertEquals(0, May.getHoursWorked(), 0.01);
  }

  /**
   * test the resetHourWorked method.
   */
  @Test
  public void testResetHoursWorked() {
    May.resetHoursWorked();
    assertEquals(0, May.getHoursWorked(), 0.001);
  }

  /**
   * test the getWeeklyCheck method.
   * first, test the special hour = 0.
   * second, test the work hour <=  40.
   * third, test the work hour > 40.
   * fourth, test the different payrate with hour 1000.
   */
  @Test
  public void testGetWeeklyCheck() {
    Paycheck paycheckMay = new Paycheck(80, May.getHoursWorked());
    assertEquals(0.00, paycheckMay.getTotalPay(), 0.001);
    assertEquals(0.00, paycheckMay.getPayAfterTaxes(), 0.001);

    May.addHoursWorked(30);
    Paycheck paycheck2 = new Paycheck(80, May.getHoursWorked());
    assertEquals(2400.00, paycheck2.getTotalPay(), 0.001);
    assertEquals(2040.00, paycheck2.getPayAfterTaxes(), 0.001);

    May.resetHoursWorked();
    May.addHoursWorked(1000);
    Paycheck paycheck3 = new Paycheck(80, May.getHoursWorked());
    assertEquals(118400.00, paycheck3.getTotalPay(), 0.01);
    assertEquals(100640.00, paycheck3.getPayAfterTaxes(), 0.01);

    Ricky.addHoursWorked(1000);
    Paycheck paycheck4 = new Paycheck(5.60, Ricky.getHoursWorked());
    assertEquals(8288.00, paycheck4.getTotalPay(), 0.01);
    assertEquals(7044.80, paycheck4.getPayAfterTaxes(), 0.01);
  }

  /**
   * test the toString method.
   * first test the hour = 0.
   * second, test the work hour <= 40.
   * third, test the work hour > 40.
   */
  @Test
  public void testToString() {
    May.addHoursWorked(-6);
    Paycheck paycheckMay = new Paycheck(80, May.getHoursWorked());
    assertEquals("Name: May" + "\n"
        + "ID: 9623" + "\n"
        + "Payment after taxes: $ 0.00", May.toString());

    May.resetHoursWorked();
    May.addHoursWorked(30);
    assertEquals("Name: May" + "\n"
        + "ID: 9623" + "\n"
        + "Payment after taxes: $ 2040.00", May.toString());

    Ricky.addHoursWorked(100);
    Paycheck paycheckRicky = new Paycheck(5.60, Ricky.getHoursWorked());
    assertEquals("Name: Ricky" + "\n"
        + "ID: 9521" + "\n"
        + "Payment after taxes: $ 618.80", Ricky.toString());
  }
}