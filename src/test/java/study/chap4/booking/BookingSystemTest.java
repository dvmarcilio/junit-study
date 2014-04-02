package study.chap4.booking;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.List;

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
	@Parameters(source = BookingIntervalParamsProvider.class, method = "validHours")
	public void shouldBookValidHoursIntervals(int begin, int end)
			throws Exception {
		bookingSystem.book(begin, end);
		assertEquals(true, bookingSystem.isIntervalBooked(begin, end));
	}

	@Test
	@Parameters(source = BookingIntervalParamsProvider.class, method = "invalidHours")
	public void shouldNotBookInvalidHoursIntervals(int begin, int end) {
		expectedException.expect(IllegalArgumentException.class);
		bookingSystem.book(begin, end);
		assertEquals(false, bookingSystem.isIntervalBooked(begin, end));
	}

	@Test
	@Parameters(source = BookingIntervalParamsProvider.class, method = "validHours")
	public void addsBookingInterval(int begin, int end) throws Exception {
		BookingInterval validBookingInterval = new BookingInterval(begin, end);
		bookingSystem.book(validBookingInterval);
		assertThat(bookingSystem.isIntervalBooked(validBookingInterval),
				is(true));
	}

	@Test
	public void returnsAListOfBookedHours() throws Exception {
		List<BookingInterval> validIntervals = BookingIntervalParamsProvider
				.getValidIntervals();
		addBookingIntervals(validIntervals);
		assertEquals(bookingSystem.getBookedHours(), validIntervals);
	}

	private void addBookingIntervals(List<BookingInterval> intervals) {
		for (BookingInterval bi : intervals)
			bookingSystem.book(bi);
	}

	@Test
	@Parameters(source = BookingIntervalParamsProvider.class, method = "doubleBookedIntervals")
	public void shouldNotDoubleBookHours(BookingInterval doubleBookInterval)
			throws Exception {
		expectIllegalArgExcWithMessage(BookingSystem.HOUR_DOUBLE_BOOKED_MESSAGE);
		bookingSystem.book(BookingIntervalParamsProvider.VALID_INTERVAL);
		bookingSystem.book(doubleBookInterval);
	}

	private void expectIllegalArgExcWithMessage(String message) {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage(message);
	}

	@Test
	@Parameters(source = BookingIntervalParamsProvider.class, method = "doubleBookedHours")
	public void knowsIfAnHourIsAvaliable(int hour, boolean valid)
			throws Exception {
		bookingSystem.book(BookingIntervalParamsProvider.VALID_INTERVAL);
		assertThat(bookingSystem.isHourAvailable(hour), is(valid));
	}

}
