package study.chap4.booking;

import static org.junit.Assert.assertEquals;
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
	@Parameters(source = BookingIntervalParamsProvider.class, method = "validHours")
	public void constructorSetValuesProperly(int begin, int end)
			throws Exception {
		BookingInterval bi = new BookingInterval(begin, end);
		assertEquals(begin, bi.getBeginHour());
		assertEquals(end, bi.getEndHour());
	}

	@Test
	@Parameters(source = BookingIntervalParamsProvider.class, method = "invalidHours")
	public void throwsIllegalArgumentExcepOnInvalidIntervals(int begin, int end) {
		expectIllegalArgExcWithMessage(BookingInterval.INVALID_INTERVAL_MESSAGE);
		new BookingInterval(begin, end);
	}

	private void expectIllegalArgExcWithMessage(String message) {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage(message);
	}

	@Test
	@Parameters(source = BookingIntervalParamsProvider.class, method = "validHours")
	public void intervalWithEqualBeginAndEndHoursAreActuallyEqual(int begin, int end)
			throws Exception {
		BookingInterval bi = new BookingInterval(begin, end);
		BookingInterval equal = new BookingInterval(begin,end);
		assertEquals(bi, equal);
	}

}
