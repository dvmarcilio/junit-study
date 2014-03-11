package study.chap3;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.*;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class FahrenheitCelsiusConverterTest {

	static final Object[] getValues() {
		return $($(32, 0), $(98, 37), $(212, 100));
	}

	@Test
	@Parameters(method = "getValues")
	public void shouldConvertCelsiusToFahrenheit(int fahrenheitTemp,
			int celsiusTemp) throws Exception {
		assertEquals(fahrenheitTemp,
				FahrenheitCelsiusConverter.toFahrenheit(celsiusTemp));
	}

	@Test
	@Parameters(method = "getValues")
	public void shouldConvertFahrenheitToCelsius(int fahrenheitTemp,
			int celsiusTemp) throws Exception {
		assertEquals(celsiusTemp,
				FahrenheitCelsiusConverter.toCelsius(fahrenheitTemp));
	}

}
