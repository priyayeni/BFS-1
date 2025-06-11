//Time Complexity : O(n)
//Space Complexity : O(n)
/*Description : we will traverse through the tree where at each node we will increment level/depth
and based on level/depth we will add the nodes to the list.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, 0, result);
        return result;
    }
    public void helper(TreeNode root, int level,List<List<Integer>> result){
        //base
        if(root == null) return;
        //logic
        if(result.size() == level){ // when the size of list is same as level we create a new list in list of lists.
            result.add(new ArrayList<>());
        }
        List<Integer> re = result.get(level); // once the new list is created at the level from the above we get that instance here
        re.add(root.val);// add the current root value
        result.set(level,re);// finally add the newly created list to result.

        // left side traversal
        helper(root.left, level+1, result);
        //right side traversal
        helper(root.right, level+1, result);


    }
}