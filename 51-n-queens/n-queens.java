class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>>result=new ArrayList<>();
        char board[][]=new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        backtrack(0,board,result,n);
        return result;
    }

    public void backtrack(int row,char board[][],List<List<String>>result,int n){
        if(row==n){
            result.add(construct(board));
            return;
        }

        for(int col=0;col<n;col++){
            if(isSafe(row,col,board,n)){
                board[row][col]='Q';
                backtrack(row+1,board,result,n);
                board[row][col]='.';
            }
        }
    }

    public boolean isSafe(int row,int col,char board[][],int n){
        for(int i=0;i<row;i++){
            if(board[i][col]=='Q')return false;
        }
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if(board[i][j]=='Q')return false;
        }

         for(int i=row-1,j=col+1;i>=0&&j<n;i--,j++){
            if(board[i][j]=='Q')return false;
        }

        return true;
    }

    public List<String> construct(char board[][]){
        List<String>result=new ArrayList<>();
        for(char row[]:board){
            result.add(new String(row));
        }
        return result;
    }
}