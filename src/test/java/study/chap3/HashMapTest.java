package study.chap3;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class HashMapTest {

	private Map<Integer, String> map;

	private static final String FIRST_VALUE = "FIRST";
	private static final String SECOND_VALUE = "SECOND";
	private static final String THIRD_VALUE = "THIRD";
	private static final String DIFFERENT_VALUE = "DIFFERENT";

	@Before
	public void setUp() {
		map = new HashMap<Integer, String>();
	}

	static final Object[] getInputs() {
		return $($(1, FIRST_VALUE), $(2, SECOND_VALUE), $(3, THIRD_VALUE));
	}

	@Test
	@Parameters(method = "getInputs")
	public void objectPutCanBeRetrievedUsingGet(Integer key, String value)
			throws Exception {
		map.put(key, value);
		assertEquals(value, map.get(key));
	}

	@Test
	@Parameters(method = "getInputs")
	public void addObjectWithExistentKeyUpdatesValue(Integer key, String value)
			throws Exception {
		map.put(key, value);
		map.put(key, DIFFERENT_VALUE);
		assertEquals(DIFFERENT_VALUE, map.get(key));
	}

	@Test
	public void clearRemovesAllContent() throws Exception {
		fillMap();
		map.clear();
		assertTrue(map.isEmpty());
	}

	private void fillMap() {
		map.put(1, FIRST_VALUE);
		map.put(2, SECOND_VALUE);
		map.put(3, THIRD_VALUE);
	}
	
	@Test
	public void nullCanBeAKey() throws Exception {
		map.put(null, FIRST_VALUE);
		assertEquals(FIRST_VALUE, map.get(null));
	}

}
