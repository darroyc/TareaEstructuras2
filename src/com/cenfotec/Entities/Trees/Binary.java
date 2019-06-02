package com.cenfotec.Entities.Trees;

import com.cenfotec.Entities.Trees.Nodes.AVLNode;
import com.cenfotec.Entities.Trees.Nodes.BinaryNode;

public class Binary{
    private BinaryNode root;

    public void insert(int value){
        BinaryNode v_treeNode = new BinaryNode(value);
        if(root == null){
            root = v_treeNode;
        } else {
            BinaryNode tempTreeNode = root;
            BinaryNode tempRoot;
            while (true){
                tempRoot = tempTreeNode;
                if(v_treeNode.getValue() < tempTreeNode.getValue()){
                    tempTreeNode = tempTreeNode.getLeftNode();
                    if(tempTreeNode == null){
                        tempRoot.setLeftNode(v_treeNode);
                        return;
                    }
                }
                else{
                    tempTreeNode = tempTreeNode.getRightNode();
                    if(tempTreeNode == null){
                        tempRoot.setRightNode(v_treeNode);
                        return;
                    }
                }
            }
        }
    }

    public String inOrder(){
        return inOrder(root);
    }

    public String preOrder(){
        return preOrder(root);
    }

    public String postOrder(){
        return postOrder(root);
    }

    private String inOrder(BinaryNode v_node){
        String content = "";
        if(v_node != null){
            content += inOrder(v_node.getLeftNode());
            content += "[" +v_node.getValue()+"],";
            content += inOrder(v_node.getRightNode());
        }
        return deleteLastComma(content);
    }

    private String preOrder(BinaryNode v_node){
        String content = "";
        if(v_node != null){
            content += "[" +v_node.getValue()+"],";
            content += preOrder(v_node.getLeftNode());
            content += preOrder(v_node.getRightNode());
        }
        return deleteLastComma(content);
    }

    private String postOrder(BinaryNode v_node){
        String content = "";
        if(v_node != null){
            content += postOrder(v_node.getLeftNode());
            content += postOrder(v_node.getRightNode());
            content += "[" +v_node.getValue()+"],";
            return content;
        }
        return deleteLastComma(content);
    }

    private String deleteLastComma(String content){
        if(content.contains(",")){
            return content.substring(0, content.length()-1);
        }
        return content;
    }

}
