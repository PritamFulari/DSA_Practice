
class Solution
{
   public static ArrayList<Integer> repeatedRows(int matrix[][], int m, int n)
    {
        //code here
        
        ArrayList<Integer> res= new ArrayList<>();
        HashMap<Integer, Integer> map= new HashMap<>();
        
        for(int i=0; i<m; i++){
            int sum=0;
            for(int j=0; j<n; j++){
                
              sum=    sum ^ (matrix[i][j]<<(n-j-1));
            }
            
            if(map.containsKey(sum)){
                res.add(i);
            }
            
            map.put(sum,i);
           
        }
        
        return res;
    }
}
