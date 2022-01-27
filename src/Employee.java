import java.math.RoundingMode;
import java.text.DecimalFormat;

/** Yingqi Zhang
 * Class CS5004
 * 22 Spring。
 * This class represents an Employee. A employee has a name, ID,hours and a payRate.
 */

public class Employee {
  private String name;
  private String ID;
  private double hours;
  private double payRate;

  /**
   * Construct a employee class that has provided with name, ID, hours,payrate.
   * @param name the name to be given to this employee.
   * @param ID the ID to be given to the Employee.
   * @param payRate the payrate to be given to the employee.
   */

  public Employee(String name, String ID, double payRate) {
    this.name = name;
    this.ID = ID;
    this.payRate = payRate;
    this.hours = 0;
  }

  /**
   * return the total hour worked of the employee.
   *
   * @param addHours the hour will be added to the employee.
   */
  public void addHoursWorked(double addHours) {
    double totalHour = this.hours + addHours;
    if (totalHour >= 0) {
      this.hours = totalHour;
    }
  }

  /**
   * reset the total hour to 0.
   */
  public void resetHoursWorked() {
    this.hours = 0;
  }

  /**
   * return the hours worker has worked.
   *
   * @return return the hours the worker has worked.
   */
  public double getHoursWorked() {
    return this.hours;
  }

  /**
   * return the paycheck object.
   *
   * @return the paycheck object.
   */
  public Paycheck getWeeklyCheck() {
    Paycheck paycheck = new Paycheck(this.payRate, this.hours);
    return paycheck;
  }

  /**
   * return the String that describe the employee object.
   *
   * @return return the String that describe the employee object
   */
  public String toString() {
    DecimalFormat df = new DecimalFormat("0.00");
    Paycheck paycheck = this.getWeeklyCheck();
    double payAfterTaxes = paycheck.getPayAfterTaxes();
    String afterTaxesPayment = df.format(payAfterTaxes);

    String result = "Name: " + this.name + "\n"
                    + "ID: " + this.ID + "\n"
                    + "Payment after taxes: $ " + afterTaxesPayment;
    return result;
  }
}
