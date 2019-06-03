class Solution {
    // https://leetcode.com/problems/pascals-triangle/
    // 1
    // 1 1
    // 1 2 1
    // 1 3 3 1
    // 1 4 6 4 1
    // In this we can see it is always 1 when j==0 or j==i
    // when j>i then we compute the next row 
    
    public List<List<Integer>> generatePascalsTrangle(int numRows) {
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int [][]result = new int[numRows][numRows];
        for(int i=0;i<numRows;i++){
            List<Integer> oneRow = new ArrayList<Integer>();
            for(int j=0; j<=i;j++){
                if(j==0 || j==i)
                    result[i][j] = 1;
                else
                    result[i][j] = result[i-1][j-1] + result[i-1][j];
                oneRow.add(result[i][j]);
            }
            ans.add(oneRow);
        }
        return ans;
    }

// https://leetcode.com/problems/pascals-triangle-ii/
// Input: 3
// Output: [1,3,3,1]  index start at 0  and only constant K space 

    public List<Integer> getRow(int rowIndex) {
        List<Integer> oneRow = new ArrayList<Integer>();
        if(rowIndex<0)
            return oneRow;
        int []result = new int[rowIndex+1];
        int []prevResult = new int[rowIndex+1];
        int []temp;
        for(int i=0;i<rowIndex+1;i++){
            for(int j=0; j<=i;j++){
                if(j==0 || j==i)
                    result[j] = 1;
                else{
                    result[j] = prevResult[j-1] + prevResult[j];
                }
            }
            temp = result;
            result = prevResult;
            prevResult = temp;
        }
        for(int j=0;j<prevResult.length;j++)
            oneRow.add(prevResult[j]);
        return oneRow; 
    }
}