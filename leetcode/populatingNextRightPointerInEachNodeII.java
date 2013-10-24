/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        TreeLinkNode botLevel = root;
        while(botLevel != null){
            TreeLinkNode tmp = botLevel;
            while(tmp != null){
                if(tmp.left != null){
                    tmp.left.next = getLeft(tmp);
                }
                
                if(tmp.right != null){
                    tmp.right.next = getRight(tmp);
                }
                
                tmp = tmp.next;
            }
            botLevel = getBot(botLevel);
            //(botLevel.left != null) ? botLevel.left : botLevel.right;
        }
    }
    
    private TreeLinkNode getBot(TreeLinkNode botLevel){
        if(botLevel.left != null)
            return botLevel.left;
        if(botLevel.right != null)
            return botLevel.right;
        if(botLevel.next != null)
            return getBot(botLevel.next);
        else
            return null;
    }
    
    private TreeLinkNode getRight(TreeLinkNode tmp){
        while(tmp.next != null){
            tmp = tmp.next;
            if(tmp.left != null){
                return tmp.left;
            }
            if(tmp.right != null){
                return tmp.right;
            }
        }
        
        return null;
    }
    
    private TreeLinkNode getLeft(TreeLinkNode tmp){
        if(tmp.right != null)
            return tmp.right;
        while(tmp.next != null){
            tmp = tmp.next;
            if(tmp.left != null){
                return tmp.left;
            }
            if(tmp.right != null){
                return tmp.right;
            }
        }
        
        return null;
    }
}