package study.chap3;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class HashMapTest {

	@Test
	public void objectPutCanBeRetrievedUsingGet() throws Exception {
		Map<Integer, String> map = new HashMap<Integer, String>();
		Integer key = 1;
		String value = "first";
		map.put(key, value);
		assertEquals(value, map.get(1));
	}

}
