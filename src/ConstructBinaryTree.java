import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by SHIQUN on 2017/11/1 0001.
 */

//首先建立一个二叉树类
class TreeNode
{
    String val;
    TreeNode left;
    TreeNode right;
    TreeNode(String x)
    {
        val = x;
    }
}

public class ConstructBinaryTree
{
    //主功能函数
    public static TreeNode Construct(String [] pre,String [] in)
    {
        if(pre == null || in == null)
        {
            return null;
        }

        TreeNode mm = Construct(pre, in, 0,
                pre.length-1, 0, in.length-1);

        return mm;
    }

    //核心递归
    public static TreeNode Construct(String[] pre, String[] in, int preStart, int preEnd, int inStart, int inEnd)
    {
        TreeNode tree = new TreeNode(pre[preStart]);
        tree.left = null;
        tree.right = null;

        if (preStart == preEnd && inStart == inEnd)
        {
            return tree;
        }

        int root = 0;
        for(root= inStart; root < inEnd; root++)
        {
            if (pre[preStart] == in[root])
            {
                break;
            }
        }
        int leifLength = root - inStart;
        int rightLength = inEnd - root;

        if (leifLength > 0)
        {
            tree.left = Construct(pre, in, preStart+1, preStart+leifLength, inStart, root-1);
        }

        if (rightLength > 0)
        {
            tree.right = Construct(pre, in, preStart+1+leifLength, preEnd, root+1, inEnd);
        }
        return tree;
    }

    //核心递归
    public static String print(TreeNode tree)
    {
        ArrayList<TreeNode> stack = new ArrayList();
        stack.add(tree);

        String temp = "";
        TreeNode node;
        while(stack.size()>0)
        {
            node = stack.get(0);
            temp+=node.val+" ";

            if(node.left!=null)
                stack.add(node.left);

            if(node.right!=null)
                stack.add(node.right);

            stack.remove(0);
        }

        return temp;
    }

    //主函数，用于测试结果
    public static String invoke(String dlr,String ldr)
    {
        //System.out.println("ConstructBinaryTree");
        String pre[] = dlr.split(",");
        String in[]  = ldr.split(",");

        TreeNode tree = Construct(pre, in);
        String temp = print(tree);
        System.out.println(temp);
        return print(tree);
    }
}
