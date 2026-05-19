package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PriceCalculatorTest {
    private PriceCalculator calculator = new PriceCalculator();

    @Test
    public void testCalculateTotalPrice_Nominal() {
        assertEquals(30.0, calculator.calculateTotalPrice(10.0, 3));
    }

    @Test
    public void testApplyDiscount_Nominal() {
        assertEquals(80.0, calculator.applyDiscount(100.0, 0.20));
    }

    @Test
    public void testCalculateVat_Nominal() {
        assertEquals(20.0, calculator.calculateVat(100.0, 0.20));
    }

    @Test
    public void testCalculatePriceWithVat_Nominal() {
        assertEquals(120.0, calculator.calculatePriceWithVat(100.0, 0.20));
    }

    @Test
    public void testCalculateTotalPrice_PrixNegatif_LeveException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> calculator.calculateTotalPrice(-10.0, 3));
        assertEquals("Le prix unitaire ne doit pas être négatif.", exception.getMessage());
    }

    @Test
    public void testCalculateTotalPrice_QuantiteNegative_LeveException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> calculator.calculateTotalPrice(10.0, -3));
        assertEquals("La quantité ne doit pas être négative.", exception.getMessage());
    }

    @Test
    public void testApplyDiscount_TauxNegatif_LeveException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> calculator.applyDiscount(100.0, -0.20));
        assertEquals("Le taux de remise ne doit pas être négatif.", exception.getMessage());
    }

    @Test
    public void testCalculateVat_TauxNegatif_LeveException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> calculator.calculateVat(100.0, -0.20));
        assertEquals("Le taux de TVA ne doit pas être négatif.", exception.getMessage());
    }

    @Test
    public void testCalculatePriceWithVat_TauxNegatif_LeveException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> calculator.calculatePriceWithVat(100.0, -0.20));
        assertEquals("Le taux de TVA ne doit pas être négatif.", exception.getMessage());
    }
}