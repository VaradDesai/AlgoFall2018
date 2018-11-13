package assignment;

import java.util.ArrayList;
import java.util.Random;
import java.lang.Math;
//import edu.neu.coe.info6205.symbolTable;
public class mainFunction{

    public static Double[] Operations(int N, BSTSimple bst){
        Random random = new Random();
        System.out.println();
        //System.out.println("******************** Tree After "+N+" Randon Ins/Del Operations ********************");
        long startTime = System.currentTimeMillis();
        for (int i=0; i<N; i++){
            //int operationChoice = 0;
            int operationChoice = random.nextInt(3);
            Integer key1 = (Integer)random.nextInt(200);

            //int key = 15;
            int value = random.nextInt();

            if(operationChoice == 0){
                bst.put(key1,value);
            }
            else if (operationChoice == 1){
                bst.delete(key1);
            }
            else if (operationChoice == 2){
                bst.get(bst.getRoot(),key1);
            }
        }
        long endTime = System.currentTimeMillis();
        long elaspedTime = endTime - startTime;
        //System.out.println("Time required to insert "+N+" nodes is "+elaspedTime+" milliseconds");

        int sizeAfterOperations = bst.size();
        //System.out.println("Size of Tree after "+N+" Operations : "+sizeAfterOperations);

        int heightAfterOperations = bst.depth(bst.getRoot());
        //System.out.println("Height of Tree after "+N+" Operations : "+heightAfterOperations);
        //System.out.println("So, When N = "+sizeAfterOperations+" O(ln N) = "+(Math.log(sizeAfterOperations)/Math.log(2)));
        //System.out.println("and When N = "+sizeAfterOperations+" O(SquareRoot(N)) = "+Math.sqrt(sizeAfterOperations));

        Double[] values = new Double[5];
        values[0]=(double) N;
        values[1]=(double) sizeAfterOperations;
        values[2]=(double) heightAfterOperations;
        values[3]=(Math.log(sizeAfterOperations)/Math.log(2));
        values[4]=Math.sqrt(sizeAfterOperations);

        System.out.print(values[0]+"|"+values[1]+"|"+values[2]+"|"+values[3]+"|"+values[4]);

        return values;

    }

    public static void main(String[] args){

    System.out.println();
    System.out.println("******************** Initializing tree with 100 nodes ********************");
    int initialSeed = 0;
    BSTSimple<Integer, Integer> bst = new BSTSimple<Integer, Integer>();
    Random random = new Random();

    long startTime = System.currentTimeMillis();
    for(int i=0; i<initialSeed; i++){
        int key = random.nextInt();
        int value = random.nextInt();
        bst.put(key,value);
    }
    long endTime = System.currentTimeMillis();
    long elaspedTime = endTime - startTime;
        System.out.println("Time required to insert 100 nodes is "+elaspedTime+" milliseconds");
    int size = bst.size();
        System.out.println("Size of Tree after Initial seed : "+size);
    int depthOfTree = bst.depth(bst.getRoot());
        System.out.println("Height of Tree after Initial seed : "+depthOfTree);
    System.out.println("So, When N = "+size+" O(ln N) = "+Math.log(size));
    System.out.println("and When N = "+size+" O(SquareRoot(N)) = "+Math.sqrt(size));

    Double[] TotalValues = {0.0,0.0,0.0,0.0,0.0};
    int N = initialSeed;
    int numberOfExperiments=100;
    System.out.println();
    System.out.print("No Of Nodes|Size|Height|O(log N)|O(Sqrt(N))");
    for (int i=0;i<numberOfExperiments;i++){
        Double[] individualValues = new Double[5];
        N = N+1;
        individualValues = Operations(N,bst);
        TotalValues[0] = TotalValues[0]+individualValues[0];
        TotalValues[1] = TotalValues[1]+individualValues[1];
        TotalValues[2] = TotalValues[2]+individualValues[2];
        TotalValues[3] = TotalValues[3]+individualValues[3];
        TotalValues[4] = TotalValues[4]+individualValues[4];
        //System.out.println((i+1)+" Experiment Completed.");

    }

    Double[] avgValues = new Double[5];
    for (int i=0; i<5; i++){
        avgValues[i]=TotalValues[i]/numberOfExperiments;
    }
    System.out.println();
    System.out.println("Number Of Experiments : "+numberOfExperiments);
    System.out.println("Average Size of the Tree after is "+avgValues[1]);
    System.out.println("Average Height of Tree : "+avgValues[2]);
    System.out.println("So average O(ln N) = "+avgValues[3]);
    System.out.println("and average O(SquareRoot(N)) = "+avgValues[4]);

//    int N= 0;
//        for (int i=0;i<30;i++){
//            N = N+10;
//            Operations(N,bst);
//        }
    }
}