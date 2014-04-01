package study.chap4.booking;

import java.util.ArrayList;
import java.util.List;

public class BookingSystem {

	private List<BookingInterval> hoursBooked = new ArrayList<BookingInterval>();

	public void book(int begin, int end) {
		hoursBooked.add(new BookingInterval(begin, end));
	}

	public boolean isIntervalBooked(int begin, int end) {
		try {
			return hoursBooked.contains(new BookingInterval(begin, end));
		} catch (IllegalArgumentException e) {
			return false;
		}
	}

}
