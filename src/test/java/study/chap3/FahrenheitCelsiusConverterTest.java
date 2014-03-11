package study.chap3;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.*;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class FahrenheitCelsiusConverterTest {

	@Test
	public void shouldConvertCelsiusToFahrenheit() throws Exception {
		assertEquals(32, FahrenheitCelsiusConverter.toFahrenheit(0));
		assertEquals(98, FahrenheitCelsiusConverter.toFahrenheit(37));
		assertEquals(212, FahrenheitCelsiusConverter.toFahrenheit(100));
	}

	@Test
	public void shouldConvertFahrenheitToCelsius() throws Exception {
		assertEquals(0, FahrenheitCelsiusConverter.toCelsius(32));
		assertEquals(37, FahrenheitCelsiusConverter.toCelsius(98));
		assertEquals(100, FahrenheitCelsiusConverter.toCelsius(212));
	}

}
