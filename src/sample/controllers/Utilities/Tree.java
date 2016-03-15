package sample.controllers.Utilities;

import java.util.PriorityQueue;

public class Tree {
        public Node root;
        public int sum;
        public String data;

        public Tree(int sum)
        {
            this.sum = sum;
            root = new Node(0,0,"",false);
            data="";
        }

//        public void setSum(int sum)
//        {
//
//        }

        private void add(Node node, int val)
        {
            if(node.sum==sum)return;

            //Incluir
            if(node.left==null)
            {
                if(node.sum+val<=sum)
                {
                    node.left = new Node(val,node.sum,node.path,true);
                }
            }else{
                add(node.left,val);
            }

            //No incluir
            if(node.right==null)
            {
                node.right = new Node(val,node.sum,node.path,false);
            }else{
                add(node.right,val);
            }
        }

        private void add(int val)
        {
            add(root,val);
        }

        private void inOrder(Node node){
            if(node.left!=null)
                inOrder(node.left);
            if(node.sum==sum){
//	        	System.out.println(node.path+node.sum);
                data+= "\n"+node.path+" = "+node.sum;
            }
            if(node.right!=null)
                inOrder(node.right);
        }

        public String inOrder(Node node,String data){
            if(node.left!=null)
                inOrder(node.left,data);
            if(node.sum==sum)
                data+= "\n"+node.path+" = "+node.sum;
            if(node.right!=null)
                inOrder(node.right,data);
            return data;
        }

        public void inOrder()
        {
            inOrder(root);
        }

        public String getData()
        {
            data="";
            inOrder(root);
            return data;
        }

        public void insert(PriorityQueue<Integer> data)
        {
            while(!data.isEmpty()){
                add(data.remove());
            }
        }
    }
