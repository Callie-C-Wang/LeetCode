package weekOne;

/**
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain
 * a single digit. Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * @author Callie
 *
 */

/**
 * Consider:
 *   carry: 8->3 + 2->7
 *   different length of two lists. 
 *   either is null;
 *   both are null;
 *   
 *  Need confirm:
 *    Can the input be changed? if Yes, use the longer one as the result.
 *    if No, create new list for result
 *    
 *  Failed history:
 *  First time, try to mudulize the duplicate part of adding carry, created
 *  new node in function. When function ends, object is released. So the 
 *  result is always 0
 *  
 *  Second time, forget to check carry value before result.next = 
 *  new ListNode(carry)
 *  
 *  todo:
 *   how to reduce duplicate code?
 * @author Callie
 *
 */
public class AddTwoNumbers {
	
	private int carry = 0;
    public ListNode addTwoNumber(ListNode first, ListNode second) {
        
		ListNode result = new ListNode(0);
		
		//can border judgement be simplified? 
		if (null == first && null == second) {
			return first;
		}
		
		if (null == first && null != second) {
			return second;
		}
		
		if (null != first && null == second) {
			return first;
		}
		
		ListNode firstTravel = first;
		ListNode secondTravel = second;
		ListNode fakeHeader = result;
		
		while(null != firstTravel && null != secondTravel) {
			int tmpSum = firstTravel.val + secondTravel.val + carry;
			if (tmpSum >= 10) {
				carry = 1;
				tmpSum -= 10;
			} else {
				carry = 0;
			}

			ListNode newNode = new ListNode(tmpSum);
			result.next = newNode;
			result = result.next;
			firstTravel = firstTravel.next;
			secondTravel = secondTravel.next;			
		}
		
		if (null == firstTravel && null == secondTravel) {
		    if (carry != 0) {//forget to check carry value, failed at the second try
			    result.next = new ListNode(carry);
		    }
			return fakeHeader.next;
			
		} else if (null == firstTravel && null != secondTravel) {
			if (carry == 0) {
				result.next = secondTravel;
				return fakeHeader.next;
			} else {
				while(null != secondTravel) {
					int tmpSum = secondTravel.val + carry;
					if (tmpSum >= 10) {
						carry = 1;
						tmpSum -= 10;
					} else {
						carry = 0;
					}

					ListNode newNode = new ListNode(tmpSum);
					result.next = newNode;
					result = result.next;
					secondTravel = secondTravel.next;
				}
			}
		} else {//if (null != firstTravel && null == secondTravel) {
			if(carry == 0) {
				result.next = firstTravel;
				return fakeHeader.next;
			} else {
				while(null != firstTravel) {
					int tmpSum = firstTravel.val + carry;
					if (tmpSum >= 10) {
						carry = 1;
						tmpSum -= 10;
					} else {
						carry = 0;
					}

					ListNode newNode = new ListNode(tmpSum);
					result.next = newNode;
					result = result.next;
					firstTravel = firstTravel.next;
				}
			}
		}
		
		if (carry != 0) {
			result.next = new ListNode(carry);
			
		}
		
		return fakeHeader.next;
	}
}
