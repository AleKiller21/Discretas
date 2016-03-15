import java.util.PriorityQueue;


public class sumaSubConjunto {
	static class Node{
		int value;
	    int sum;
	    String path;
	    boolean included;
	    Node left, right;

	    public Node(int val, int sumBefore, String pathBefore, boolean included)
	    {
	        this.included=included;
	        value=val;
	        sum=sumBefore;
	        path=pathBefore;
	        if(included)
	        {
	            sum+=val;
	            if(path=="")path= val + " = " + path;
	            else path= val + " + " + path;
	        }
	        left=null;
	        right=null;
	    }
	}
	static class Tree{
		Node root;
	    int sum;
	    String data;

	    public Tree(int sum)
	    {
	        this.sum=sum;
	        root = new Node(0,0,"",false);
	        data="";
	    }

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

	    void insert(PriorityQueue<Integer> data)
	    {
	    	while(!data.isEmpty()){
	    		add(data.remove());
	    	}
	    }
	}
	
	public static void main(String[] args) {
		Tree tree = new Tree(500);
	    PriorityQueue<Integer> v = new PriorityQueue<Integer>();
	    v.add(44);//30
	    v.add(54);
	    v.add(66);
	    v.add(84);
	    v.add(126);
	    v.add(138);
	    v.add(144);
	    v.add(162);
	    v.add(182);//288
	    v.add(318);
	    v.add(336);
	    v.add(456);

	    tree.insert(v);
//	    tree.inOrder();
	    System.out.println(tree.getData());
	}
}
