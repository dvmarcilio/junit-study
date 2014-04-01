package study.chap4.booking;

public class BookingInterval {

	public static final String INVALID_INTERVAL_MESSAGE = "Invalid interval. Too lazy to explain";

	private final int beginHour;

	private final int endHour;

	public BookingInterval(int begin, int end) {
		if(!validInterval(begin, end))
			throw new IllegalArgumentException(INVALID_INTERVAL_MESSAGE);
		this.beginHour = begin;
		this.endHour = end;
	}

	private boolean validInterval(int begin, int end) {
		boolean valid = true;
		if (begin < 0 || end < 0)
			valid = false;
		else if (begin > end)
			valid = false;
		else if (begin == end)
			valid = false;
		else if (begin > 24 || end > 24)
			valid = false;
		return valid;
	}

	public int getBeginHour() {
		return beginHour;
	}

	public int getEndHour() {
		return endHour;
	}

	@Override
	public boolean equals(Object obj) {
		// AUTO-GENERATED
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookingInterval other = (BookingInterval) obj;
		if (beginHour != other.beginHour)
			return false;
		if (endHour != other.endHour)
			return false;
		return true;
	}
	
	

}
