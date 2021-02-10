package edu.eci.cvds.tdd.aerodescuentos;
import org.junit.Assert;
import org.junit.Test;

public class TarifasTest{
    @Test
    public void validarTarifaBase(){
        Assert.assertEquals(17000,CalculadorDescuentos.calculoTarifa(20000, 21, 50),1);
    }
    @Test
    public void validarTarifaNegativa(){
        try {
            CalculadorDescuentos.calculoTarifa(-20000,21,50);
            Assert.assertFalse(true);
        } catch (Exception e) {
            Assert.assertTrue(true);
        }
    }
    @Test
    public void validarDiasAntelacion(){
        try{
            CalculadorDescuentos.calculoTarifa(50000,52,27);
            Assert.assertEquals(42500,CalculadorDescuentos.calculoTarifa(50000, 52, 27),1);
        } catch (Exception e){
            Assert.assertFalse(false);
        }
    }
    @Test
    public void validarDiasAntelacionNegativos(){
        try {
            CalculadorDescuentos.calculoTarifa(30000,-5,36);
            Assert.assertFalse(true);
        } catch (Exception e) {
            Assert.assertTrue(true);
        }    
    }
    @Test
    public void validarDiasAntelacionSuperior(){
        try {
            CalculadorDescuentos.calculoTarifa(30000,367,36);
            Assert.assertFalse(true);
        } catch (Exception e) {
            Assert.assertTrue(true);
        }
    }
    @Test
    public void validarSinDescuentoDiasAntelacion(){
        Assert.assertEquals(CalculadorDescuentos.calculoTarifa(5000, 2, 67), 4600,1);
    }
    @Test
    public void validarMenorDeEdad(){
        Assert.assertEquals(CalculadorDescuentos.calculoTarifa(36000, 10, 14), 34200,1);
    }
    @Test
    public void validarMayorDeEdad(){
        Assert.assertEquals(CalculadorDescuentos.calculoTarifa(56000, 18, 35), 56000,1);
    }
    @Test 
    public void validarEdadNegativa(){
        try {
            CalculadorDescuentos.calculoTarifa(7800, 25, -5);
            Assert.assertFalse(true);
        }
        catch (Exception e) {
            Assert.assertTrue(true);
        }
    }
    @Test
    public void validarAdultoMayor(){
        Assert.assertEquals(CalculadorDescuentos.calculoTarifa(8900, 5, 120), 8188,1);
    }
    @Test
    public void validarEdadImposible(){
        try {
            CalculadorDescuentos.calculoTarifa(2500, 11, 178);
            Assert.assertFalse(true);
        }
        catch (Exception e) {
            Assert.assertTrue(true);
        }
    }
}
