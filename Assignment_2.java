
import java.util.*;

public class Assignment_2 {

    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int d){
            this.data = d;
            this.left = null;
            this.right = null;
        }
    }

    public static class Node1{
        char d;
        Node1 left;
        Node1 right;

        Node1(char ch){
            this.d = ch;
            this.left = null;
            this.right = null;
        }
    }

    public static Node1 insert(Node1 root, char val){
        if(root == null){
            root = new Node1(val);
            return root;
        }
        
        if(val > root.d){
           root.right = insert(root.right, val);
        }
        else if(val < root.d){
           root.left = insert(root.left, val);
        }
      
        return root;
    }

    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        Node1 root = null;
        System.out.println("Enter the number of elements:");
        int n = in.nextInt();

        for(int i=0; i<n; i++){
            char temp = in.next().charAt(0);
            root = insert(root, temp);
            
        }

        int continues=1;
        while(continues==1) {
        System.out.println("Menu:");
        System.out.println("nter expression");
        System.out.println("2:Recursive Inorder");
        System.out.println("3:Non-Recursive Inorder");
        System.out.println("4:Recursive Preorder");
        System.out.println("5:Non-Recursive Preorde");
        System.out.println("6:Recursive Postorder");
        System.out.println("7:Non-Recursive Postorder");
        System.out.println("8:BFS");
        System.out.println("Other Keys:Exit");
        System.out.print("Enter choice: ");
        int choice;
   try {
      choice=in.nextInt();
      }
      catch (Exception e) {
      choice=9;
      }
      System.out.println("\n");
      switch(choice) {
      case 1:
      System.out.print("Enter expression: ");
      String str=in.next();
      convert(str);
      break;
      case 2:
      System.out.println("Recursive Inorder: ");

      recurinorder(root);
      break;
      case 3:
      System.out.println("Non-Recursive Inorder: ");
      nonrecurinorder(root);
      break;
      case 4:
      System.out.println("Recursive Preorder: ");
      recurpreorder(root);
      break;
      case 5:
      System.out.println("Non-recursive Preorder: ");
      nonrecurpreorder(root);
      break;
      case 6:
      System.out.println("Recursive Postorder: ");
      recurpostorder(root);
      break;
      case 7:
      System.out.println("Non-Recursive Postorder: ");
      nonrecurpostorder(root);
      break;
      case 8:
      System.out.println("BFS:");
      bfs(root);
      break;
      default:
      continues=0;
      break;
}
System.out.println("\n\n");
}
in.close();
    
}

    

    static boolean isOperator(char ch) {
        return (ch == '+' || ch == '-' || ch == '*' || ch == '/');
    }

    public static void convert(String postfix) {
        Stack<Node1> stack = new Stack<Node1>();

        for(char ch:postfix.toCharArray()){
            if(!isOperator(ch)){
                Node1 temp = new Node1(ch);
                stack.push(temp);
            }
            else{
                Node1 op1, op2, temp;
                temp = new Node1(ch);
                op1 = stack.pop();
                op2 = stack.pop();
                temp.left=op2;
                temp.right=op1;
                stack.push(temp);
            }
        }

        // root = stack.pop();
    }

    public static void recurpreorder(Node1 root){
        if(root == null){
            return;
        }

        System.out.println(root.d);
        recurpreorder(root.left);
        recurpreorder(root.right);
    }

    public static void nonrecurpreorder(Node1 root){
        Stack<Node1> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            Node1 current = stack.pop();
            System.out.print(current.d+" ");
            if(current.right!=null){
                stack.push(current.right);
            }

            if(current.left!=null){
                stack.push(current.left);
            }
        }
    }

    public static void nonrecurinorder(Node1 root){
        Stack<Node1> stack = new Stack<>();
        Node1 current = root;
        
        while(current!=null || !stack.isEmpty()){
            while(current!=null){
                stack.push(current);// traverse the leftmost element
                current = current.left;
            }
            current = stack.pop();
            System.out.print(current.d+" ");
            current = current.right;// then go for right element
        }
    }

    public static void recurinorder(Node1 root){
        if(root == null){
            return;
        }

        recurinorder(root.left);
        System.out.println(root.d);
        recurinorder(root.right);
    }

    public static void recurpostorder(Node1 root){
        if(root==null){
            return;
        }

        recurpostorder(root.left);
        recurpostorder(root.right);
        System.out.println(root.d);
    }

    public static void nonrecurpostorder(Node1 root){
         Stack<Node1> stack1 = new Stack<>();
         Stack<Node1> stack2 = new Stack<>();
         stack1.push(root);

         while(!stack1.isEmpty()){
            Node1 current = stack1.pop();
            stack2.push(current);

            if(current.left != null){
                stack1.push(current.left);
            }
            if(current.right!=null){
                stack1.push(current.right);
            }
         }


         while(!stack2.isEmpty()){
            System.out.print(stack2.pop().d+" ");
         }
    }

    public static void bfs(Node1 root){
        if(root==null){
            System.out.println("The tree is empty.");
            return;
        }

        Queue<Node1> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            Node1 current = queue.poll();
            System.out.print(current.d+" ");

            if(current.left!=null){
                queue.add(current.left);
            }
            if(current.right!=null){
                queue.add(current.right);
            }
        }
    }


}
