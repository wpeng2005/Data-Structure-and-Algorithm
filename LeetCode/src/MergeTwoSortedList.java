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
//合并两个有序链表：将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
public class MergeTwoSortedList {
    //通过递归解决该问题，每次递归都会让其中一个列表的头节点放置到正确的位置
    public ListNode mergeTwoListsByRecursion(ListNode list1, ListNode list2) {
        if(list1==null){
            return list2;
        }else if(list2==null){
            return list1;
        }else if(list1.val<list2.val){
            list1.next=mergeTwoLists(list1.next,list2);
            return list1;
        }else{
            list2.next=mergeTwoLists(list1,list2.next);
            return list2;
        }
    }
    //使用迭代解决该问题
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode prehead=new ListNode(-1);
        ListNode prev=prehead;
        while(list1!=null&&list2!=null){
            if(list1.val<=list2.val){
                prev.next=list1;
                list1=list1.next;
            }else{
                prev.next=list2;
                list2=list2.next;
            }
            prev=prev.next;
        }
        prev.next=list1==null?list2:list1;
        return prehead.next;
    }
}
