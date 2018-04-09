/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.paystack.helper;

/**
 *
 * @author i
 */
public class PaystackFee {

    public static final double DEFAULT_PERCENTAGE = 0.015;
    public static final double DEFAULT_ADDITIONAL_CHARGE = 10000;
    public static final double DEFAULT_THRESHOLD = 250000;
    public static final double DEFAULT_CAP = 200000;

    private double percentage;
    private double additional_charge;
    private double threshold;
    private double cap;

    private double chargeDivider;
    private double crossover;
    private double flatlinePlusCharge;
    private double flatline;

    private void loadDefaults() {
        this.cap = PaystackFee.DEFAULT_CAP;
        this.threshold = PaystackFee.DEFAULT_THRESHOLD;
        this.additional_charge = PaystackFee.DEFAULT_ADDITIONAL_CHARGE;
        this.percentage = PaystackFee.DEFAULT_PERCENTAGE;

    }

    public PaystackFee() {
        this.loadDefaults();
        this.__setup();
    }

    public PaystackFee(double percentage, double cap, double threshold, double additional_charge) throws Exception {
        this.loadDefaults();
        this.setPercentage(percentage);
        this.setCap(cap);
        this.setAdditionalCharge(additional_charge);
        this.setThreshold(threshold);
        this.__setup();
    }

    public final PaystackFee setPercentage(double percentage) throws Exception {
        if (percentage <= 0) {
            throw new Exception("Percentage must be a positive number");
        }
        if (percentage >= 1) {
            throw new Exception("Percentage must be less than 1");
        }
        this.percentage = percentage;
        this.__setup();
        return this;
    }

    public final PaystackFee setAdditionalCharge(double additional_charge) throws Exception {
        if (additional_charge < 0) {
            throw new Exception("Additional Charge must be a positive number");
        }
        this.additional_charge = additional_charge;
        this.__setup();
        return this;
    }

    public final PaystackFee setThreshold(double threshold) throws Exception {
        if (threshold < 0) {
            throw new Exception("Threshold must be a positive number");
        }
        this.threshold = threshold;
        this.__setup();
        return this;
    }

    public final PaystackFee setCap(double cap) throws Exception {
        if (threshold <= 0) {
            throw new Exception("Cap must be a positive number");
        }
        this.cap = cap;
        this.__setup();
        return this;
    }

    public double getThreshold() {
        return this.threshold;
    }

    public double getAdditionalCharge() {
        return this.additional_charge;
    }

    public double getPercentage() {
        return this.percentage;
    }

    public double getCap() {
        return this.cap;
    }

    private void __setup() {
        this.chargeDivider = this.__chargeDivider();
        this.crossover = this.__crossover();
        this.flatlinePlusCharge = this.__flatlinePlusCharge();
        this.flatline = this.__flatline();
    }

    private double __chargeDivider() {
        return 1 - this.percentage;
    }

    private double __crossover() {
        return (this.threshold * this.chargeDivider) - this.additional_charge;
    }

    private double __flatlinePlusCharge() {
        return (this.cap - this.additional_charge) / this.percentage;
    }

    private double __flatline() {
        return this.flatlinePlusCharge - this.cap;
    }

    public long addFeesTo(int amountinkobo) {
        if (amountinkobo > this.flatline) {
            return (long) Math.ceil(amountinkobo + this.cap);
        } else if (amountinkobo > this.crossover) {
            return (long) Math.ceil((amountinkobo + this.additional_charge) / this.chargeDivider);
        } else {
            return (long) Math.ceil(amountinkobo / this.chargeDivider);
        }
    }
}
