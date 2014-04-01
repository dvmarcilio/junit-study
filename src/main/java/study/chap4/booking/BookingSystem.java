package study.chap4.booking;

import java.util.ArrayList;
import java.util.List;

public class BookingSystem {

	public static final String HOUR_DOUBLE_BOOKED_MESSAGE = "Double booked. Lazy to give nice message";
	private List<BookingInterval> hoursBooked = new ArrayList<BookingInterval>();

	public void book(int begin, int end) {
		book(new BookingInterval(begin, end));
	}

	public void book(BookingInterval bookingInterval) {
		if (isIntervalAvailable(bookingInterval))
			hoursBooked.add(bookingInterval);
		else
			throw new IllegalArgumentException(HOUR_DOUBLE_BOOKED_MESSAGE);
	}

	// Should this be public ? Hard to guess when not in a real world usage
	private boolean isIntervalAvailable(BookingInterval bookingInterval) {
		return isHourAvailable(bookingInterval.getBeginHour())
				&& isHourAvailable(bookingInterval.getEndHour());
	}

	public boolean isIntervalBooked(int begin, int end) {
		try {
			return hoursBooked.contains(new BookingInterval(begin, end));
		} catch (IllegalArgumentException e) {
			return false;
		}
	}

	public boolean isIntervalBooked(BookingInterval bookingInterval) {
		return hoursBooked.contains(bookingInterval);
	}

	public List<BookingInterval> getBookedHours() {
		return hoursBooked;
	}

	public boolean isHourAvailable(int hour) {
		for (BookingInterval bi : hoursBooked) {
			if (isHourInBetweenBookingInterval(hour, bi))
				return false;
		}
		return true;
	}

	private boolean isHourInBetweenBookingInterval(int hour, BookingInterval bi) {
		return hour >= bi.getBeginHour() && hour <= bi.getEndHour();
	}
}
