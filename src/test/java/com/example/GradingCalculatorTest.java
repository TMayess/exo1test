package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GradingCalculatorTest {

    @Test
    public void testGetGrade_ScoreElevéPrésnceElevée_RetourneA() {
        GradingCalculator calculator = new GradingCalculator(95, 90);
        assertEquals('A', calculator.getGrade());
    }

    @Test
    public void testGetGrade_ScoreMoyenHautPrésnceElevée_RetourneB() {
        GradingCalculator calculator = new GradingCalculator(85, 90);
        assertEquals('B', calculator.getGrade());
    }

    @Test
    public void testGetGrade_ScoreMoyenPrésnceElevée_RetourneC() {
        GradingCalculator calculator = new GradingCalculator(65, 90);
        assertEquals('C', calculator.getGrade());
    }

    @Test
    public void testGetGrade_ScoreElevéPrésnceLimit_RetourneB() {
        GradingCalculator calculator = new GradingCalculator(95, 65);
        assertEquals('B', calculator.getGrade());
    }

    @Test
    public void testGetGrade_ScoreElevéPrésneceFaible_RetourneF() {
        GradingCalculator calculator = new GradingCalculator(95, 55);
        assertEquals('F', calculator.getGrade());
    }

    @Test
    public void testGetGrade_ScoreMoyenPrésneceFaible_RetourneF() {
        GradingCalculator calculator = new GradingCalculator(65, 55);
        assertEquals('F', calculator.getGrade());
    }

    @Test
    public void testGetGrade_ScoreFaiblePrésnceElevée_RetourneF() {
        GradingCalculator calculator = new GradingCalculator(50, 90);
        assertEquals('F', calculator.getGrade());
    }
}