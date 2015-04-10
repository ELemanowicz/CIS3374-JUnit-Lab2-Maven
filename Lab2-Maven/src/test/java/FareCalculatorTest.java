import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.lab2.transit.FareCalculator;

@RunWith(Parameterized.class)
public class FareCalculatorTest {
	
private static final double DELTA = 1e-15;

private double expected;
private int age;
private String time;
private boolean isHoliday;

	public FareCalculatorTest(double expected, int age, String time, boolean isHoliday)
	{
		this.expected = expected;
		this.age = age;
		this.time = time;
		this.isHoliday = isHoliday;
	}
	@Parameters
	public static Collection<Object[]> testParams() 
	{
		return Arrays.asList(new Object[][] {
				{0.0, 5, "4:45", false},
				{2.5, 6, "9:50", false},
				{0.0, 65, "12:45", false},
				{2.5, 64, "14:10", false},
				{0.0, 70, "6:59", false},
				{2.5, 75, "7:00", false},
				{0.0, 80, "9:01", false},
				{2.5, 85, "9:00", false},
				{0.0, 90, "8:30", true},
				{2.5, 60, "7:30", true}
		});
	}
	@Test
	public void calculateFareTest() {
		assertEquals(expected, FareCalculator.calculateFare(age, time, isHoliday), DELTA);
	}

}
