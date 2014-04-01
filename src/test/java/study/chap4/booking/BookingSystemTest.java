package study.chap4.booking;

import static org.junit.Assert.*;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class BookingSystemTest {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	private BookingSystem bookingSystem;

	@Before
	public void setUp() {
		bookingSystem = new BookingSystem();
	}

	@Test
	@Parameters(method = "validBookingIntervals")
	public void shouldBookValidHoursIntervals(int begin, int end)
			throws Exception {
		bookingSystem.book(begin, end);
		assertEquals(true, bookingSystem.isIntervalBooked(begin, end));
	}

	static final Object[] validBookingIntervals() {
		return BookingIntervalTest.validBookingIntervals();
	}

	@Test
	@Parameters(method = "invalidBookingIntervals")
	public void shouldNotBookInvalidHoursIntervals(int begin, int end) {
		expectedException.expect(IllegalArgumentException.class);
		bookingSystem.book(begin, end);
		assertEquals(false, bookingSystem.isIntervalBooked(begin, end));
	}

	static final Object[] invalidBookingIntervals() {
		return BookingIntervalTest.invalidBookingIntervals();
	}

}
