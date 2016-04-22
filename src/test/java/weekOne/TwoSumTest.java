package weekOne;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TwoSumTest {
	private TwoSum origin = new TwoSum();
	/**
	 * Need Confirm: 
	 * 	integer? include negative and positive
	 * 	size? null, 0, big size
	 *  in the result, should the index be ordered?
	 * 
	 * test case 1:
	 * 	null; 0
	 *  one element array; i
	 *  several element array; i
	 *  big size; i
	 */

	@Test
	public void twoSumTest_1() {
		int[] givenArr = { 3,2,4 };
		int targetSum = 6;
		int[] resultIndex = origin.twoSumPuzzle(givenArr, targetSum);
		Assert.assertEquals(resultIndex[0], 1);
		Assert.assertEquals(resultIndex[1], 2);
	}
	
	@Test
	public void twoSumTest_2() {
		int[] givenArr = {0,4,3,0};
		int targetSum = 0;
		int[] resultIndex = origin.twoSumPuzzle(givenArr, targetSum);
		Assert.assertEquals(resultIndex[0], 0);
		Assert.assertEquals(resultIndex[1], 3);
	}
	
	@Test
	public void twoSumTest_3() {
		int[] givenArr = {-1,-2,-3,-4};
		int targetSum = -8;
		int[] resultIndex = origin.twoSumPuzzle(givenArr, targetSum);
		Assert.assertEquals(resultIndex[0], 0);
		Assert.assertEquals(resultIndex[1], 0);
	}
}
