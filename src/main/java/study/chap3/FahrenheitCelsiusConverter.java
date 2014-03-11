package study.chap3;

public class FahrenheitCelsiusConverter {

	public static int toFahrenheit(int celsiusTemp) {
		return (celsiusTemp * 9 / 5) + 32;
	}

	public static int toCelsius(int fahrenheitTemp) {
		return (int) (Math.ceil((fahrenheitTemp - 32) / (1.8000)));
	}

}
