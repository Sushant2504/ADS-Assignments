
import java.util.*;

class Heap{
    private int l,r,largest;
    void maxHeapify(int marks[], int i, int n){
        
        l = 2*i;
        r = (2*i+1);

        largest = ((l<=n) && marks[l]>marks[i]) ? l:i;

        if((r<=n) && (marks[r]>marks[largest])){
            largest = r;
        }

        if(largest!=i){
            int temp = marks[largest];
            marks[largest] = marks[i];
            marks[i] = temp;

            maxHeapify(marks, largest, n);
        }
    }

    void buildMaxHeap(int marks[], int n){

        for(int k=n/2; k>=1; k--){
            maxHeapify(marks, k, n);
        }
    }

    void heapsort(int marks[], int n){
        buildMaxHeap(marks, n);
        for(int i=n; i>=2; i--){
            int temp = marks[i];
            marks[i] = marks[l];
            marks[l] = temp;
            maxHeapify(marks, l, i-1);

        }
    }

    void accept(){
        Scanner sc = new Scanner(System.in);

        int n;

        System.out.println("Enter the number of students:");
        n = sc.nextInt();

        int[] marks = new int[n+1];

        for(int i=1; i<=n; i++){
            marks[i] = sc.nextInt();
        }

        System.out.println("\nEnter the marks of the students: ");

        for(int i=1; i<=n; i++){
            System.out.println(marks[i]);
        }

        heapsort(marks, n);

    }

    void display(int marks[], int n){
        System.out.println("\n::::::::::SORTED MARKS::::::\n\n");

        for(int i=l; i<=n; i++){
            System.out.println(marks[i]+"\n");

            System.out.println("\nMinimum marks obtained: "+marks[l]);
            System.out.println("\nMaximum marks obtained: "+marks[n]);

        }
    }
}


public class Assignment_4 {
    
   
    

    public static void main(String[] args) {
        Heap h = new Heap();

        h.accept();
    }
}
