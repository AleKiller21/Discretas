package sample.controllers.Utilities;

public class Node {
    public int value;
    public int sum;
    public String path;
    public boolean included;
    public Node left, right;

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
