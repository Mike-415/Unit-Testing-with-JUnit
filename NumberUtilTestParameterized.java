import static org.junit.Assert.*;
import java.util.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.*;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class NumberUtilTestParameterized {
	private static final double TRESHOLD = 0.0001;
	private NumberUtil numberUtility;
	private List<Integer> numberList;
	private int sumExpected, maxExpected;
	public NumberUtilTestParameterized(List<Integer> numberList, int sumExpected, int maxExpected){
		this.numberList = numberList;
		this.sumExpected = sumExpected;
		this.maxExpected = maxExpected;
	}
	@Before
	public void setup(){
		numberUtility = new NumberUtil(numberList);
	}
	@Parameters
	public static Collection<Object[]> getInputs(){
		return Arrays.asList(new Object[][]{
			{ Arrays.asList(1,2,3,4,5), 15, 5},         //Test case 0: a normal sequence of positive numbers
			{ Arrays.asList(0,0,0,0,0), 0, 0},          //Test case 1: all elements have the same number
			{ Arrays.asList(-1,-2,-3,-4,-5), -15, -1 }, //Test case 2: negative numbers
			{ Arrays.asList(-1,-1,-2,-3,7,7), 7, 7 },   //Test case 3: negative and positive numbers
			{ Arrays.asList(7), 7, 7}                   //Test case 4: a single element in the list
		});
	}
	
	@Test
	public void testSumParameterized() {
		int results = numberUtility.sum();
		assertNotNull(numberList);
		assertEquals(results, sumExpected, TRESHOLD);
	}
	
	@Test
	public void testMaxParameterized() {
		int results = numberUtility.max();
		assertNotNull(numberList);
		assertEquals(results, maxExpected, TRESHOLD);
	}
}
