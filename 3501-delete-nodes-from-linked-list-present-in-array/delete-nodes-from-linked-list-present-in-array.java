/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
       /* ListNode dummy=new ListNode(-1);
        ListNode current=dummy;
        int n=nums.length;
        int i=0;
        while(head!=null){
            if(i<n&& nums[i]!=head.val){
                i++;
            }else{
                current.next=new ListNode(head.val);
                current=current.next;
            }
            head=head.next;
        }
        return dummy.next;*/


         /*ListNode dummy = new ListNode(-1); // Dummy node
        ListNode current = dummy;

        // Create an array to keep track of which values to remove
        boolean[] toRemove = new boolean[100]; // Assuming values are in a specific range, e.g., [1, 100]

        // Mark the values to remove
        for (int num : nums) {
            toRemove[num] = true; // Mark as true for removal
        }

        // Traverse the linked list
        while (head != null) {
            // If the current node's value is not marked for removal
            if (!toRemove[head.val]) {
                current.next = head; // Add it to the modified list
                current = current.next; // Move current forward
            }
            head = head.next; // Move to the next node in the original list
        }

        // Disconnect the last node from any remaining nodes
        current.next = null;

        return dummy.next;  */


        HashSet<Integer>valuesRemove=new HashSet<>();
        for(int num:nums){
            valuesRemove.add(num);
        }
        ListNode dummy=new ListNode(-1);
        ListNode current=dummy;
        while(head!=null){
            if(!valuesRemove.contains(head.val)){
                current.next=head;
                current=current.next;
            }
            head=head.next;
        }
        current.next=null;
        return dummy.next;
        
    }
}