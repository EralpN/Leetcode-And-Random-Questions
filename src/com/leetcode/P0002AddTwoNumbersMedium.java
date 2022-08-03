package com.leetcode;

/*

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 1:


Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
 

Constraints:
The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.

 */

public class P0002AddTwoNumbersMedium
{
	public static void main(String[] args)
	{
		P0002AddTwoNumbersMedium addnum = new P0002AddTwoNumbersMedium();
		ListNode res = addnum.new ListNode();
		
		res = addnum.addTwoNumbers(addnum.new ListNode(9, addnum.new ListNode(9, addnum.new ListNode(9, addnum.new ListNode(9, addnum.new ListNode(9, addnum.new ListNode(9, addnum.new ListNode(9))))))), addnum.new ListNode(9, addnum.new ListNode(9, addnum.new ListNode(9, addnum.new ListNode(9)))));
		
		System.out.println(res.val);
		while (res.next != null)
		{
			System.out.println(res.next.val);
			res = res.next;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2)
	{
		ListNode result = new ListNode();
		ListNode temp;
		int[] nums1 = new int[100];
		int[] nums2 = new int[100];
		
		int l1LastIndex = 0;
		temp = l1;
		nums1[0] = temp.val;
		int count = 1;
		while (temp.next != null)
		{
			temp = temp.next;
			nums1[count] = temp.val;
			l1LastIndex = count;
			count++;
		}
		
		int l2LastIndex = 0;
		temp = l2;
		nums2[0] = temp.val;
		count = 1;
		while (temp.next != null)
		{
			temp = temp.next;
			nums2[count] = temp.val;
			l2LastIndex = count;
			count++;
		}
		
		if (l2LastIndex > l1LastIndex)
		{
			int over9 = 0;
			int val = nums1[0] + nums2[0];
			if (val > 9)
			{
				over9 = val / 10;
				val = val % 10;
			}
			
			result.val = val;
			result.next = new ListNode();
			temp = result.next;
			
			for (int i = 1; i <= l1LastIndex; i++)
			{
				if (over9 != 0)
				{
					val = nums1[i] + nums2[i] + over9;
					over9 = 0;
				}
				else
				{
					val = nums1[i] + nums2[i];
				}
				
				if (val > 9)
				{
					over9 = val / 10;
					val = val % 10;
				}
				
				temp.val = val;
				temp.next = new ListNode();
				temp = temp.next;
			}
			
			for (int i = l1LastIndex + 1; i <= l2LastIndex; i++)
			{
				if (over9 != 0)
				{
					val = nums2[i] + over9;
					over9 = 0;
				}
				else
				{
					val = nums2[i];
				}
				
				if (val > 9)
				{
					over9 = val / 10;
					val = val % 10;
				}
				
				temp.val = val;
				
				if (i == l2LastIndex && over9 == 0)
				{
					
				} 
				else if (i == l2LastIndex && over9 != 0)
				{
					temp.next = new ListNode(over9);
				}
				else
				{
					temp.next = new ListNode();
					temp = temp.next;
				}
			}
		}
		else
		{
			int over9 = 0;
			int val = nums1[0] + nums2[0];
			if (val > 9)
			{
				over9 = val / 10;
				val = val % 10;
			}
			
			result.val = val;
			
			if (l2LastIndex == 0 && l1LastIndex == 0)
			{
				if (over9 != 0)
				{
					result.next = new ListNode(over9);
				}
			}
			else
			{
				result.next = new ListNode();
				temp = result.next;
			}
			
			for (int i = 1; i <= l2LastIndex; i++)
			{
				if (over9 != 0)
				{
					val = nums1[i] + nums2[i] + over9;
					over9 = 0;
				}
				else
				{
					val = nums1[i] + nums2[i];
				}
				
				if (val > 9)
				{
					over9 = val / 10;
					val = val % 10;
				}
				
				temp.val = val;
				
				if (l1LastIndex == l2LastIndex && i == l2LastIndex)
				{
					if (over9 != 0)
					{
						temp.next = new ListNode(over9);
					}
				}
				else
				{
					temp.next = new ListNode();
					temp = temp.next;
				}
				
			}
			
			for (int i = l2LastIndex + 1; i <= l1LastIndex; i++)
			{
				if (over9 != 0)
				{
					val = nums1[i] + over9;
					over9 = 0;
				}
				else
				{
					val = nums1[i];
				}
				
				if (val > 9)
				{
					over9 = val / 10;
					val = val % 10;
				}
				
				temp.val = val;
				
				if (i == l1LastIndex && over9 == 0)
				{
					
				} 
				else if (i == l1LastIndex && over9 != 0)
				{
					temp.next = new ListNode(over9);
				}
				else
				{
					temp.next = new ListNode();
					temp = temp.next;
				}
			}
		}
		return result;
	}

	// Definition for singly-linked list.
	public class ListNode
	{
		int val;
		ListNode next;

		ListNode()
		{
		}

		ListNode(int val)
		{
			this.val = val;
		}

		ListNode(int val, ListNode next)
		{
			this.val = val;
			this.next = next;
		}
	}

}