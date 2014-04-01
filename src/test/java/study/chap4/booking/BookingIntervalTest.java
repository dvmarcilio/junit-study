package study.chap4.booking;

import static org.junit.Assert.*;
import static junitparams.JUnitParamsRunner.$;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class BookingIntervalTest {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Test
	@Parameters(method = "validBookingIntervals")
	public void constructorSetValuesProperly(int begin, int end)
			throws Exception {
		BookingInterval bi = new BookingInterval(begin, end);
		assertEquals(begin, bi.getBeginHour());
		assertEquals(end, bi.getEndHour());
	}

	static final Object[] validBookingIntervals() {
		return $($(0, 1), $(2, 3), $(10, 12), $(16, 18), $(10, 22), $(20, 24));
	}

	@Test
	@Parameters(method = "invalidBookingIntervals")
	public void throwsIllegalArgumentExcepOnInvalidIntervals(int begin, int end) {
		expectIllegalArgExcWithMessage(BookingInterval.INVALID_INTERVAL_MESSAGE);
		new BookingInterval(begin, end);
	}

	private void expectIllegalArgExcWithMessage(String message) {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage(message);
	}

	static final Object[] invalidBookingIntervals() {
		return $($(0, 0), $(12, 12), $(-1, 0), $(0, -1), $(-5, -3), $(23, 25),
				$(10, 5), $(20, 14));
	}

	@Test
	@Parameters(method = "validBookingIntervals")
	public void intervalWithEqualBeginAndEndHoursAreActuallyEqual(int begin, int end)
			throws Exception {
		BookingInterval bi = new BookingInterval(begin, end);
		BookingInterval equal = new BookingInterval(begin,end);
		assertEquals(bi, equal);
	}

}
