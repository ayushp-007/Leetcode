class Solution {
    public int[] minOperations(String boxes) {
        List<Integer> l = new ArrayList<>();
        char[] b = boxes.toCharArray();
        int m = 0;
        for(int i=0;i<b.length;i++){
            m = 0;
            for(int j =0;j<b.length;j++){
                //System.out.println(i+" "+j);
                //System.out.println(b[j]);
                if(b[j] == '1' && j != i){
                    m +=(int)Math.abs((j-i));
                    //System.out.println(i+" "+j);
                }
                //System.out.println(m);
            }
            l.add(m);
        }
        //System.out.println(l);
        int[] ans = new int[l.size()];
        for(int i=0;i<ans.length;i++){
            ans[i] = l.get(i);
        }
        return ans;
    }
}