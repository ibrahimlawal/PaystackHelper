/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.paystack.helper;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author i
 */
public class PaystackFeeTest {

    public PaystackFeeTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setPercentage method, of class PaystackFee.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testSetPercentage() throws Exception {
        System.out.println("setPercentage");
        double percentage = 0.01;
        PaystackFee instance = new PaystackFee();
        PaystackFee result = instance.setPercentage(percentage);
        assertEquals(percentage, result.getPercentage(), 0.0);
    }

    /**
     * Test of setAdditionalCharge method, of class PaystackFee.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testSetAdditionalCharge() throws Exception {
        System.out.println("setAdditionalCharge");
        double additional_charge = 0.0;
        PaystackFee instance = new PaystackFee();
        PaystackFee result = instance.setAdditionalCharge(additional_charge);
        assertEquals(additional_charge, result.getAdditionalCharge(), 0.0);
    }

    /**
     * Test of setThreshold method, of class PaystackFee.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testSetThreshold() throws Exception {
        System.out.println("setThreshold");
        double threshold = 0.0;
        PaystackFee instance = new PaystackFee();
        PaystackFee result = instance.setThreshold(threshold);
        assertEquals(threshold, result.getThreshold(), 0.0);
    }

    /**
     * Test of setCap method, of class PaystackFee.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testSetCap() throws Exception {
        System.out.println("setCap");
        double cap = 0.0;
        PaystackFee instance = new PaystackFee();
        PaystackFee result = instance.setCap(cap);
        assertEquals(cap, result.getCap(), 0.0);
    }

    /**
     * Test of getThreshold method, of class PaystackFee.
     */
    @Test
    public void testGetThreshold() {
        System.out.println("getThreshold");
        PaystackFee instance = new PaystackFee();
        double expResult = PaystackFee.DEFAULT_THRESHOLD;
        double result = instance.getThreshold();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getAdditionalCharge method, of class PaystackFee.
     */
    @Test
    public void testGetAdditionalCharge() {
        System.out.println("getAdditionalCharge");
        PaystackFee instance = new PaystackFee();
        double expResult = PaystackFee.DEFAULT_ADDITIONAL_CHARGE;
        double result = instance.getAdditionalCharge();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getPercentage method, of class PaystackFee.
     */
    @Test
    public void testGetPercentage() {
        System.out.println("getPercentage");
        PaystackFee instance = new PaystackFee();
        double expResult = PaystackFee.DEFAULT_PERCENTAGE;
        double result = instance.getPercentage();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getCap method, of class PaystackFee.
     */
    @Test
    public void testGetCap() {
        System.out.println("getCap");
        PaystackFee instance = new PaystackFee();
        double expResult = PaystackFee.DEFAULT_CAP;
        double result = instance.getCap();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of addFeesTo method, of class PaystackFee.
     */
    @Test
    public void testAddFeesTo() {
        System.out.println("addFeesTo");
        int amountinkobo = 1;
        PaystackFee instance = new PaystackFee();
        long expResult = 2L;
        long result = instance.addFeesTo(amountinkobo);
        assertEquals(expResult, result);
        amountinkobo = 10000;
        expResult = 10153L;
        result = instance.addFeesTo(amountinkobo);
        assertEquals(expResult, result);
        amountinkobo = 1000000;
        expResult = 1025381L;
        result = instance.addFeesTo(amountinkobo);
        assertEquals(expResult, result);
        amountinkobo = 30000000;
        expResult = 30200000L;
        result = instance.addFeesTo(amountinkobo);
        assertEquals(expResult, result);
    }

}
