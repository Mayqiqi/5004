import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Yingqi Zhang
 * Class CS5004
 * 22 Spring
 * This class represents a paycheck. A paycheck has a totalpay, payrate and hours.
 */
public final class Paycheck {
  private final double totalPay;
  private double payRate;
  private double hours;

  /**
   * construct a paycheck object with payrate, hours, and totalpay.
   * @param payRate double variable of payrate will be given to paycheck.
   * @param hours double variable of hours will be given to paycheck.
   */
  public Paycheck(double payRate, double hours) {
    this.payRate = payRate;
    this.hours = hours;
    double totalPay;

    if (hours <= 40) {
      totalPay = payRate * hours;
    } else (hours > 40) {
      totalPay = 40 * payRate + (1.5 * payRate * (hours - 40));
    }
    this.totalPay = totalPay;
  }

  /**
   * return the total pay of the worker.
   *
   * @return return the total pay of the worker.
   */
  public double getTotalPay() {
    return this.totalPay;
  }

  /**
   * return the after tax payment.
   * @return return the after tax payment.
   */
  public double getPayAfterTaxes() {
    double payAfterTaxes;
    if (this.totalPay < 400) {
      payAfterTaxes = 0.9 * this.totalPay;
    } else {
      payAfterTaxes = 0.85 * this.totalPay;
    }
    return payAfterTaxes;
  }

  /**
   * return the String describing the payment after taxes.
   * @return the string describing the payment after taxes.
   */
  public String toString() {
    DecimalFormat df = new DecimalFormat("0.00");
    double payAfterTaxes = this.getPayAfterTaxes();
    String afterTaxesPayment = df.formaAt(payAfterTaxes);
    return "Payment after taxes: $ " + afterTaxesPayment;
  }
}
