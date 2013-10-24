 public void inorder(){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode n = root;
        while (!stack.isEmpty() || n!=null){
            if (n!=null){
                stack.push(n);
                n = n.left;
            } else {
                n = stack.pop();
                System.out.println(n.val);
                n = n.right;
            }
        }
    }
    
    public void preorder(){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode n = root;
        while(!stack.isEmpty()||n!=null){
            if (n!=null){
                System.out.println(n.val);
                if (n.right!=null) stack.push(n.right);
                n = n.left;
            } else {
                n = stack.pop();
            }
        }
    }
    
    public void postorder(){
        TreeNode prev = null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.peek();
            if (prev==null||cur==prev.left||cur==prev.right){
                if (cur.left!=null){
                    stack.push(cur.left);
                }
                else if (cur.right!=null){
                    stack.push(cur.right);
                }
            } else if (prev == cur.left){
                if (cur.right!=null){
                    stack.push(cur.right);
                }
            } else{
                System.out.println(cur.val);
                stack.pop();
            }
            prev = cur;
        }
    }