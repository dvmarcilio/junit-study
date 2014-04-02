package study.chap4.booking;

import static junitparams.JUnitParamsRunner.$;

import java.util.ArrayList;
import java.util.List;

public class BookingIntervalParamsProvider {

	static final int BEGIN = 10;
	static final int END = 12;
	static final int VALID_BEGIN = 9;
	static final int VALID_END = 13;
	static final int INVALID_BEGIN = BEGIN + 1;
	static final int INVALID_END = END - 1;

	static final BookingInterval VALID_INTERVAL = new BookingInterval(BEGIN,
			END);
	
	static final Object[] validHours() {
		return $($(0, 1), $(2, 3), $(10, 12), $(16, 18), $(10, 22), $(20, 24));
	}
	
	static final Object[] invalidHours() {
		return $($(0, 0), $(12, 12), $(-1, 0), $(0, -1), $(-5, -3), $(23, 25),
				$(10, 5), $(20, 14));
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

	static final Object[] doubleBookedHours() {
		return $($(BEGIN, false), $(END, false), $(INVALID_BEGIN, false),
				$(INVALID_END, false), $(VALID_BEGIN, true), $(VALID_END, true));
	}

	static final List<BookingInterval> getValidIntervals() {
		ArrayList<BookingInterval> list = new ArrayList<BookingInterval>();
		list.add(new BookingInterval(9, 12));
		list.add(new BookingInterval(13, 14));
		list.add(new BookingInterval(20, 24));
		list.add(new BookingInterval(15, 17));
		list.add(new BookingInterval(18, 19));
		return list;
	}

}
