package medium;

public class PushDominoes {

    public String pushDominoesOptimised(String dominoes) {

        dominoes = "L"+dominoes+"R";

        char[] c = dominoes.toCharArray();
        int n = c.length;

        StringBuilder sb = new StringBuilder();

        for(int i=0,j = 1; j<n; j++){

            if(c[j]=='.')
                continue;

            if(i>0)
                sb.append(c[i]);

            int middleElements = j-i-1;

            if(c[i]==c[j]){
                while(middleElements-->0){
                    sb.append(c[i]);
                }
            }else if(c[i]=='L' && c[j]=='R'){
                while(middleElements-->0){
                    sb.append('.');
                }
            }else{

                for(int k=1;k<=middleElements/2;k++){
                    sb.append('R');
                }
                if(middleElements%2==1)
                    sb.append('.');

                for(int k=1;k<=middleElements/2;k++){
                    sb.append('L');
                }
            }

            i=j;
        }

        return sb.toString();
    }


    public String pushDominoes(String dominoes) {

        int n = dominoes.length();
        char[] c = dominoes.toCharArray();

        int[] right = new int[n];
        int[] left = new int[n];


        for(int i=0 ;i<n;){

            if(c[i]=='L' || c[i]=='.'){
                i++;
            }else if(c[i]=='R'){
                i++;
                int prev = 1;
                while(i<n && c[i]=='.'){
                    right[i++] = prev++;
                }
            }
        }

        for(int i=n-1 ;i>=0;){

            if(c[i]=='R' || c[i]=='.'){
                i--;
            }else if(c[i]=='L'){
                i--;
                int prev = 1;
                while(i>=0 && c[i]=='.'){
                    left[i--] = prev++;
                }
            }
        }


        char[] ans = new char[n];

        for(int i=0;i<n;i++){

            if(left[i]==right[i]){
                ans[i] = c[i];
            }else if(right[i]==0 || (left[i]!=0 && left[i]<right[i])){
                ans[i] = 'L';
            }else{
                ans[i] = 'R';
            }
        }

        return new String(ans);
    }


    public String pushDominoesClean(String dominoes) {

        char[] c = dominoes.toCharArray();
        int n = c.length;
        int[] forces = new int[n];

        // Populate forces going from left to right
        int force = 0;
        for(int i=0; i<n;i++){
            if(c[i]=='R')
                force = n;
            else if(c[i]=='L')
                force = 0;
            else if(i>0)
                force = Math.max(force-1,0);

            forces[i] = force;
        }

        // Populate forces going from right to left
        force = 0;
        for(int i=n-1;i>=0;i--){
            if(c[i]=='L')
                force = n;
            else if(c[i]=='R')
                force = 0;
            else if(i<n-1)
                force = Math.max(force-1,0);

            forces[i] -=force;
        }

        StringBuilder ans = new StringBuilder();
        for (int f: forces)
            ans.append(f > 0 ? 'R' : f < 0 ? 'L' : '.');
        return ans.toString();
    }
}
