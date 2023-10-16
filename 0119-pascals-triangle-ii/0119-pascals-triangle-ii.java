class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> row, prevr =null;
        
        for(int i = 0;i<=rowIndex ; i++ ){
            row =  new ArrayList<>();
            for(int j=0;j<=i ; j++ ){
                if(j==0 || j==i ){
                    row.add(1);
                }
                else{
                    row.add(prevr.get(j-1)+prevr.get(j) );
                }
                
            }
            prevr=row;
            ans.add(row);

        }
        return ans.get(rowIndex);
    }
}
    