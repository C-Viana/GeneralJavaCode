package lib;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.CONCURRENT)
class ArrayHandlerTest {
	
	private final Integer[] unorderedIntegerArray = new Integer[] {5, 1, 9, 7, 0, 4, 2, 8, 3, 6};
	private final Integer[] orderedIntegerArray = new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
	
	private final Double[] unorderedDoubleArray = new Double[] {5.500001d, 5.100001d, 5.900001d, 5.700001d, 5.400001d, 5.200001d, 5.000001d, 5.800001d, 5.300001d, 5.600001d};
	private final Double[] orderedDoubleArray = new Double[] {5.000001d, 5.100001d, 5.200001d, 5.300001d, 5.400001d, 5.500001d, 5.600001d, 5.700001d, 5.800001d, 5.900001d};
	
	private final Float[] unorderedFloatArray = new Float[] {5.500001f, 5.100001f, 5.900001f, 5.700001f, 5.000001f, 5.400001f, 5.200001f, 5.800001f, 5.300001f, 5.600001f};
	private final Float[] orderedFloatArray = new Float[] {5.000001f, 5.100001f, 5.200001f, 5.300001f, 5.400001f, 5.500001f, 5.600001f, 5.700001f, 5.800001f, 5.900001f};
	
	private final String[] unorderedStringArray = new String[] {"Gama", "Delta", "Epsilon", "Zeta", "Eta", "Theta", "Iota", "Alfa", "Beta", "Kapa"};
//	private final String[] orderedStringArray = new String[] {"Alfa", "Beta", "Delta", "Epsilon", "Eta", "Iota", "Kapa", "Gama", "Theta", "Zeta"};
	private final Object[] unorderedObjectArray = new Object[] {"Alfa", 99, 105.556f, new Random(), 3.1415987566d, "Zeta", true};
	
	@Test
	void convertIntegerListToArrayTest() {
		Integer[] arrayInteger = new ArrayHandler().convertListToArray(Integer.class, Arrays.asList(unorderedIntegerArray));
		Assertions.assertEquals(Integer[].class, arrayInteger.getClass());
		Assertions.assertArrayEquals(unorderedIntegerArray, arrayInteger);
	}
	
	@Test
	void convertDoubleListToArrayTest() {
		Double[] arrayDouble = new ArrayHandler().convertListToArray(Double.class, Arrays.asList(unorderedDoubleArray));
		Assertions.assertEquals(Double[].class, arrayDouble.getClass());
		Assertions.assertArrayEquals(unorderedDoubleArray, arrayDouble);
	}
	
	@Test
	void convertFloatListToArrayTest() {
		Float[] arrayFloat = new ArrayHandler().convertListToArray(Float.class, Arrays.asList(unorderedFloatArray));
		Assertions.assertEquals(Float[].class, arrayFloat.getClass());
		Assertions.assertArrayEquals(unorderedFloatArray, arrayFloat);
	}
	
	@Test
	void convertStringListToArrayTest() {
		String[] arrayString = new ArrayHandler().convertListToArray(String.class, Arrays.asList(unorderedStringArray));
		Assertions.assertEquals(String[].class, arrayString.getClass());
		Assertions.assertArrayEquals(unorderedStringArray, arrayString);
	}
	
	@Test
	void convertObjectListToArrayTest() {
		Object[] arrayObject = new ArrayHandler().convertListToArray(Object.class, Arrays.asList(unorderedObjectArray));
		Assertions.assertEquals(Object[].class, arrayObject.getClass());
		Assertions.assertArrayEquals(unorderedObjectArray, arrayObject);
	}
	
	@Test
	void convertNullTypeListToArrayTest() {
		ArrayHandler ah = new ArrayHandler();
		List<Object> list = null;
		String message = Assertions.assertThrows(NullPointerException.class, () -> {
			ah.convertListToArray(null, list);
		}).getMessage();
		Assertions.assertTrue( message.equals("Argument \"list\" is null and cannot be converted!") || message.equals("type is marked non-null but is null") );
	}
	
	@Test
	void convertNullArrayListToArrayTest() {
		List<Object> list = null;
		ArrayHandler ah = new ArrayHandler();
		Assertions.assertThrows(NullPointerException.class, () -> ah.convertListToArray(Object.class, list));
	}
	
	@Test
	void bubbleSortNumbersAscTest() {
		Integer[] arrayInteger = unorderedIntegerArray;
		new ArrayHandler().bubbleSortNumbersAsc(arrayInteger);
		Assertions.assertArrayEquals(orderedIntegerArray, arrayInteger);
	}
	
	@Test
	void selectionSortNumbersAscTest() {
		Double[] arrayInteger = unorderedDoubleArray;
		new ArrayHandler().selectionSortNumbersAsc(arrayInteger);
		Assertions.assertArrayEquals(orderedDoubleArray, arrayInteger);
	}
	
	@Test
	void quickSortNumbersAscTest() {
		Float[] arrayInteger = unorderedFloatArray;
		new ArrayHandler().quickSortNumbersAsc(arrayInteger, 0, arrayInteger.length);
		Assertions.assertArrayEquals(orderedFloatArray, arrayInteger);
	}
	
	@Test
	void mergeSortNumbersAscTest() {
		Integer[] arrayInteger = unorderedIntegerArray;
		new ArrayHandler().mergeSortNumbersAsc(arrayInteger, 0, arrayInteger.length);
		Assertions.assertArrayEquals(orderedIntegerArray, arrayInteger);
	}
	
	@Test
	void insertionSortNumbersAscTest() {
		Integer[] arrayInteger = unorderedIntegerArray;
		new ArrayHandler().insertionSortNumbersAsc(arrayInteger);
		Assertions.assertArrayEquals(orderedIntegerArray, arrayInteger);
	}
	
}
