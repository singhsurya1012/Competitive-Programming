package medium;

public class KthSymbolInGrammar {

    public int kthGrammarAsTree(int n, int k) {
        //if k is even means its a right child -- parent (k/2)
        //if k is odd means its a left child --- parent (k+1/2)

        //now if its a right child its value will be inverse of parent
        //if its a left child its value will be same as parent

        if(n==1)
            return 0;

        if(k%2==0){
            //right child
            //inverse of parent
            return kthGrammarAsTree(n-1,k/2)==0?1:0;
        }else{
            //left child
            //same as parent
            return kthGrammarAsTree(n-1,(k+1)/2);
        }

    }

    public int kthGrammar(int n, int k) {

        if(n==1)
            return 0;

        int len = (int)Math.pow(2,n-1);


        //same as previous row
        if(k<=len/2)
            return kthGrammar(n-1,k);
        else
            //compliment of its previous row
            return kthGrammar(n-1, k-len/2)==0?1:0;

    }
}
