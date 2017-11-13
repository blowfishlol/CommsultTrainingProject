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

import id.ac.sgu.commsult.smarthome.controller.AirConditionerController;

@RunWith(Parameterized.class)
public class AirConditionerTest {

	@Parameters(name = "temp inside {0} temp outisde {2} wind speed {1} time {2} expected {3}")
	public static Collection<Object[]> data(){
		
		return Arrays.asList(new Object[][] {
			{50, 60, 200 , 1700, true},
			{14, 30, 200 , 1700, false}
			
		});
		
	}

	private double tempInside;
	private double tempOutside;
	private double windSpeed;
	private int time;
	private boolean expected;
	private AirConditionerController acc;
	
	public AirConditionerTest(double tempInside, double tempOutside,  double windSpeed, int time, boolean expected){
		this.tempInside = tempInside;
		this.tempOutside = tempOutside;
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
		acc.giveUpdate(tempInside, tempOutside, windSpeed, time);
	}

}
