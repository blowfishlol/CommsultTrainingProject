package ac.sgu.commsult.smarthome.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import ac.id.sgu.commsult.smarthome.controller.AirConditionerController;

@RunWith(Parameterized.class)
public class AirConditionerTest {

	@Parameters(name = "temp {0} wind speed {1} time {2} expected {3}")
	public static Collection<Object[]> data(){
		
		return Arrays.asList(new Object[][] {
			{50, 200 , 1700, true},
			{14, 200 , 1700, false}
			
		});
		
	}

	private double temp;
	private double windSpeed;
	private int time;
	private boolean expected;
	private AirConditionerController acc;
	
	public AirConditionerTest(double temp, double windSpeed, int time, boolean expected){
		this.temp = temp;
		this.windSpeed = windSpeed;
		this.time = time;
		this.expected = expected;
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Setting up before class");
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Tearing Down after Class");
	}

	@Before
	public void setUp() throws Exception {
		acc = new AirConditionerController();
		System.out.println("Setting Up...");
		
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Tearing Down...");
	}

	@Test
	public void test() {
		acc.giveUpdate(temp, windSpeed, time);
	}

}
