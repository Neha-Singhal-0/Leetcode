//Problem Link : https://leetcode.com/problems/flip-equivalent-binary-trees/?envType=daily-question&envId=2024-10-24



class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null)return true;
        if(root1==null||root2==null)return false;
        if(root1.val==root2.val){
            boolean withFlip=flipEquiv(root1.left,root2.right)&&flipEquiv(root1.right,root2.left);
            if(!withFlip) return flipEquiv(root1.left,root2.left)&&flipEquiv(root1.right,root2.right);
            else  return withFlip;
        }
        return false;
    }
}
