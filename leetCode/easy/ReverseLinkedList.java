/*

Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?

*/


//RECURSIVE SOLUTION

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    ListNode new_head;
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }
        head = helper(head);
        head.next = null;
        return new_head;
    }
    
    
    
    
    public ListNode helper(ListNode head){
        if(head.next == null){
            new_head = head;
            return head;
        }
        else{
            ListNode temp = helper(head.next);
            temp.next = head;
            return head;
        }
    }
}




/*

Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List.
Memory Usage: 36.5 MB, less than 99.92% of Java online submissions for Reverse Linked List.

*/










//ITERATION SOLUTION

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        
        
        ListNode prev = null; 
        ListNode current = head; 
        ListNode next = null; 
        
        while (current != null) { 
            next = current.next; 
            current.next = prev; 
            prev = current; 
            current = next; 
        } 
        head = prev; 
        return head; 
    }
}


/*

Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List.
Memory Usage: 36.4 MB, less than 99.92% of Java online submissions for Reverse Linked List.

*/

