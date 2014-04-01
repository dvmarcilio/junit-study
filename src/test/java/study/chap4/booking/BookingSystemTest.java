package study.chap4.booking;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
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
	@Parameters(method = "validIntervalValues")
	public void shouldBookValidHoursIntervals(int begin, int end)
			throws Exception {
		bookingSystem.book(begin, end);
		assertEquals(true, bookingSystem.isIntervalBooked(begin, end));
	}

	static final Object[] validIntervalValues() {
		return BookingIntervalTest.validBookingIntervals();
	}

	@Test
	@Parameters(method = "invalidIntervalValues")
	public void shouldNotBookInvalidHoursIntervals(int begin, int end) {
		expectedException.expect(IllegalArgumentException.class);
		bookingSystem.book(begin, end);
		assertEquals(false, bookingSystem.isIntervalBooked(begin, end));
	}

	static final Object[] invalidIntervalValues() {
		return BookingIntervalTest.invalidBookingIntervals();
	}

	@Test
	@Parameters(method = "validIntervalValues")
	public void addsBookingInterval(int begin, int end) throws Exception {
		BookingInterval validBookingInterval = new BookingInterval(begin, end);
		bookingSystem.book(validBookingInterval);
		assertEquals(true, bookingSystem.isIntervalBooked(validBookingInterval));
	}

	@Test
	public void returnsAListOfBookedHours() throws Exception {
		List<BookingInterval> validIntervals = getValidIntervals();
		addBookingIntervals(validIntervals);
		assertEquals(bookingSystem.getBookedHours(), validIntervals);
	}

	private List<BookingInterval> getValidIntervals() {
		ArrayList<BookingInterval> list = new ArrayList<BookingInterval>();
		list.add(new BookingInterval(9,12));
		list.add(new BookingInterval(13,14));
		list.add(new BookingInterval(20,24));
		list.add(new BookingInterval(15,17));
		list.add(new BookingInterval(18, 19));
		return list;
	}

	private void addBookingIntervals(List<BookingInterval> intervals) {
		for (BookingInterval bi : intervals)
			bookingSystem.book(bi);
	}

	private static final int BEGIN = 10;
	private static final int END = 12;
	private static final int VALID_BEGIN = 9;
	private static final int VALID_END = 13;
	private static final int INVALID_BEGIN = BEGIN + 1;
	private static final int INVALID_END = END - 1;

	@Test
	@Parameters(method = "doubleBookedIntervals")
	public void shouldNotDoubleBookHours(BookingInterval doubleBookInterval)
			throws Exception {
		expectIllegalArgExcWithMessage(BookingSystem.HOUR_DOUBLE_BOOKED_MESSAGE);
		bookingSystem.book(new BookingInterval(BEGIN, END));
		bookingSystem.book(doubleBookInterval);
	}

	static final Object[] doubleBookedIntervals() {
		return $(getIntervalAfterBeginOfOneBooked(),
				getIntervalBeforeEndOfOneBooked(),
				getIntervalEqualBeginOfOneBooked(),
				getIntervalEqualEndOfOneBooked());
	}

	private static BookingInterval getIntervalAfterBeginOfOneBooked() {
		return new BookingInterval(INVALID_BEGIN, VALID_END);
	}

	private static BookingInterval getIntervalBeforeEndOfOneBooked() {
		return new BookingInterval(VALID_BEGIN, INVALID_END);
	}

	private static BookingInterval getIntervalEqualBeginOfOneBooked() {
		return new BookingInterval(BEGIN, VALID_END);
	}

	private static BookingInterval getIntervalEqualEndOfOneBooked() {
		return new BookingInterval(VALID_BEGIN, END);
	}

	private void expectIllegalArgExcWithMessage(String message) {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage(message);
	}
	
	@Test
	public void knowsIfAnHourIsAvaliable() throws Exception {
		bookingSystem.book(new BookingInterval(BEGIN, END));
		assertEquals(false, bookingSystem.isHourAvailable(BEGIN));
		assertEquals(false, bookingSystem.isHourAvailable(END));
		assertEquals(false, bookingSystem.isHourAvailable(INVALID_BEGIN));
		assertEquals(false, bookingSystem.isHourAvailable(INVALID_END));
		assertEquals(true, bookingSystem.isHourAvailable(VALID_BEGIN));
		assertEquals(true, bookingSystem.isHourAvailable(VALID_END));
	}

}
