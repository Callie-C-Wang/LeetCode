package weekOne;

import java.util.HashMap;

/**
 * Given an array of integers, return indices of the two numbers such that 
 * they add up to a specific target. You may assume that each input would
 * have exactly one solution.The return format had been changed to 
 * zero-based indices. Please read the above updated description carefully.
 * Subscribe to see which companies asked this question
 * @author Callie
 *
 */
public class TwoSum {
	
	/**
	 * Need Confirm: 
	 * 	integer? include negative and positive
	 * 	size? null, 0, big size
	 *  in the result, should the index be ordered?
	 * 
	 * test case 1:
	 * 	null; 0 ---- null
	 *  one element array; i --- null
	 *  several element array; i
	 *  big size; i
	 */
	
	/**
	 * Failed history:
	 * 
	 * failed at [3,2,4],6. Reason: should delete the picked element.
	 * Also, before writing code, should confirm the result of 
	 * [2],4 in advance!
	 * Never return Null. image there is a test assertion after return!
	 * 
	 * failed at [-1,-2,-3,-4,-5], -8. Null pointer exception.
	 * Reason: HashMap get() could fetch null if the key does not exist
	 * when do (hm.get(tmpSum) == i), turns out to be (null == i)
	 * 
	 * failed at [0,4,3,0], 0. Null pointer exception.
	 * Reason: HashMap get() could fetch null if the key does not exist
	 * @param givenArr
	 * @param targetSum
	 * @return
	 */
	
	/**
	 * Time complexity: O(n)
	 * space complexity: O(n)
	 * @param givenArr
	 * @param targetSum
	 * @return
	 */
	public int[] twoSumPuzzle(int[] givenArr, int targetSum){

		int[] result = new int[2];
		
		if (null == givenArr ||
				givenArr.length < 2)
		return result;
		
		//value-index
		HashMap<Integer, Integer> hm =
				new HashMap<Integer, Integer>();
		
		for(int i = 0; i < givenArr.length; i++) {
			hm.put(givenArr[i], i);
		}
		
		
		for(int i = 0; i < givenArr.length; i++) {
			int tmpSum = targetSum - givenArr[i];
			if (hm.containsKey(tmpSum)){//solution for second failure
				//solution for first failure
				if (hm.get(tmpSum) == i) {
					continue;
				}
				//end solution
				
				result[0] = i;
				result[1] = hm.get(tmpSum);
				return result;
			}
		}
		
		return result;
	}
}
