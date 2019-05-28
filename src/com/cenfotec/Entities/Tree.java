package com.cenfotec.Entities;

public class Tree {
    public TreeNode root;

    public void push(int value){
        TreeNode v_treeNode = new TreeNode(value);
        if(root == null){
            root = v_treeNode;
        } else {
            TreeNode tempTreeNode = root;
            TreeNode tempRoot;
            while (true){
                tempRoot = tempTreeNode;
                if(v_treeNode.value < tempTreeNode.value){
                    tempTreeNode = tempTreeNode.leftNode;
                    if(tempTreeNode == null){
                        tempRoot.setLeftNode(v_treeNode);
                        return;
                    }
                }
                else{
                    tempTreeNode = tempTreeNode.rightNode;
                    if(tempTreeNode == null){
                        tempRoot.setRightNode(v_treeNode);
                        return;
                    }
                }
            }
        }
    }

    public String inOrden(TreeNode v_node){
        String content = "";
        if(v_node != null){
            content += inOrden(v_node.leftNode);
            content += "[" +v_node.value+"],";
            content += inOrden(v_node.rightNode);
        }
        return content;
    }

    public String preOrden(TreeNode v_node){
        String content = "";
        if(v_node != null){
            content += "[" +v_node.value+"],";
            content += preOrden(v_node.leftNode);
            content += preOrden(v_node.rightNode);
        }
        return content;
    }

    public String postOrden(TreeNode v_node){
        String content = "";
        if(v_node != null){
            content += postOrden(v_node.leftNode);
            content += postOrden(v_node.rightNode);
            content += "[" +v_node.value+"],";
            return content;
        }
        return content;
    }

}
