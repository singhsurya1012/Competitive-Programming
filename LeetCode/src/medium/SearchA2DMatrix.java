package medium;

public class SearchA2DMatrix {

    public boolean searchMatrix(int[][] m, int target) {
        int x = m.length;
        int y = m[0].length;

        int left = 0;
        int right = x*y-1;

        while(left<=right){

            int mid = left + (right-left)/2;

            int i = mid/y;
            int j = mid%y;
            int val = m[i][j];


            if(target==val){
                return true;
            }else if(target<val){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }

        return false;
    }

    public boolean searchMatrixBInaary(int[][] m, int target) {
        int x = m.length;
        int y = m[0].length;

        int top = 0;
        int down = x-1;

        while(top<=down){

            int mid = top + (down-top)/2;

            if(target>=m[mid][0] && target<=m[mid][y-1]){
                return searchArr(m[mid],target);
            }else if(target<m[mid][0]){
                down = mid-1;
            }else{
                top = mid+1;
            }
        }

        return false;
    }

    public boolean searchArr(int[] arr, int target){

        int l = 0;
        int r = arr.length-1;

        while(l<=r){
            int m = l  +(r-l)/2;

            if(arr[m]==target){
                return true;
            }else if(target< arr[m]){
                r= m-1;
            }else{
                l = m+1;
            }
        }

        return false;
    }
}
