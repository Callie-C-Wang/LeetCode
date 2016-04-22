package weekOne;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AddTwoNumbersTest {
	private AddTwoNumbers origin = new AddTwoNumbers();

	private ListNode createList(int[] arr) {
		ListNode head = new ListNode(0);
		ListNode travel = head;
		for(int i = 0; i < arr.length; i++) {
			travel.next = new ListNode(arr[i]);
			travel = travel.next;
		}
		
		return head.next;
	}
	
  @Test
  public void testAddTwoNumbers_1() {
	  int[] firstArr = {1};
	  int[] secondArr = {2};
	  ListNode first = this.createList(firstArr);
	  ListNode second = this.createList(secondArr);
	  
	  ListNode result = origin.addTwoNumber(first, second);
	  Assert.assertEquals(result.val, 3);
  }
  
  @Test
  public void testAddTwoNumbers_2() {
	  int[] firstArr = {4};
	  int[] secondArr = {6};
	  ListNode first = this.createList(firstArr);
	  ListNode second = this.createList(secondArr);
	  
	  ListNode result = origin.addTwoNumber(first, second);
	  Assert.assertEquals(result.val, 0);
	  result = result.next;
	  Assert.assertEquals(result.val, 1);
  }
  
  @Test
  public void testAddTwoNumbers_3() {
	  int[] firstArr = {3,8};
	  int[] secondArr = {9,7};
	  ListNode first = this.createList(firstArr);
	  ListNode second = this.createList(secondArr);
	  
	  ListNode result = origin.addTwoNumber(first, second);
	  Assert.assertEquals(result.val, 2);
	  result = result.next;
	  Assert.assertEquals(result.val, 6);
	  result = result.next;
	  Assert.assertEquals(result.val, 1);
  }
}
