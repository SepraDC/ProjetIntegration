package ovh.sepradc;

import junit.framework.TestCase;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class COVIDLibTest extends TestCase {
    private NormalDistribution n;
    private COVIDLib covidLib;

    @BeforeEach
    public void setUp() {
        this.n = new NormalDistribution();
        this.covidLib = new COVIDLib();
    }

    @Test
    public void testCovidChanceEnMoyenne() {
        double response = this.covidLib.covidChanceEnMoyenne(this.n, 5);

        assertEquals(0.99, response,0.1);
    }

    @Test
    public void testCovidChanceDurree() {
        double response =  this.covidLib.covidChanceDurree(this.n, -6, 29);

        assertEquals(0.99, response, 0.1);
    }
}
