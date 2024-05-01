
import java.util.*;

public class Assignment_1 {
   
    static class Node{
        int data;
        Node right;
        Node left;
        Node(int data){
            this.data = data;
            right = null;
            left = null;
        }
    }

    public static Node insert(Node root, int val){
            if(root == null){
                root = new Node(val);
                return root;
            }
            
            if(val > root.data){
               root.right = insert(root.right, val);
            }
            else if(val < root.data){
               root.left = insert(root.left, val);
            }
          
            return root;
    }

    public static void inorder(Node root){
        if(root == null){
            return;
        }  

        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }

    public static boolean search(Node root, int val){
        if(root == null){
            return false;
        }

        if(root.data > val){
            return search(root.right, val);
        }
        else if(root.data < val){
            return search(root.left, val);
        }

        if(root.data == val){
            return true;
        }

        return false;
    }


    public static Node delete(Node root, int val){
        if(root == null){
            return null;
        }

        if(root.data == val){
            if(root.left == null && root.right == null){
                return null;
            }
            else if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            else{
                Node temp = root.right;
                while(temp.left!= null){
                    temp = temp.left;
                }
                root.data = temp.data;
                root.right = delete(root.right, temp.data);
                return root;
            }
        }

        if(root.data > val){
            root.left = delete(root.left, val);
            return root;
        }
        else{
            root.right = delete(root.right, val);
            return root;
        }
    }


    static int minValue(Node root){
        
        int minval = root.data;

        while(root.left != null){
            minval = root.left.data;
            root = root.left;
        }

        return minval;
    }

    static void levelorder(Node root){
        

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node temp = q.poll();
            System.out.println(temp.data+" ");
            if(temp.left!= null){
                q.add(temp.left);
            }
            if(temp.right!= null){
                q.add(temp.right);
            }
        }
    }
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int n;
        Node root = null;
        int a[] = new int[100];
        int ch;

        do {
            System.out.println("Enter your Choice\n1.Insert \n2.Delete \n3.search \n4.Display \n5.BFS");
            ch = sc.nextInt();
            switch (ch) {
            case 1:
            System.out.println("enter no. of elements");
            n = sc.nextInt();
            for (int i = 0; i<n; i++) {
            a[i] = sc.nextInt();
            root = insert(root, a[i]);
            }
            break;
            case 2:
            System.out.println("enter the value that you have to delete:");
            int val = sc.nextInt();
            delete(root, val);
            break;
            case 3:
            System.out.println("enter the value that you have to search:");
            int ser = sc.nextInt();
            
            if (search(root, ser)) {
            System.out.println(ser + "is Found");
            } else {
            System.out.println("Value not found");
            }
            break;
            case 4:
            System.out.println("Display inorder Traversal: ");
            inorder(root);
            break;
            case 5:
            System.out.println("Level order Traversal-Breadth First Search");
            levelorder(root);
            break;
            default:
            System.out.println("Something went wrong!");
            }
            }
            while (ch != 6);
            }
    }
