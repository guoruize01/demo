package everyday;
import java.util.*;

public class test8 {
    public static void main(String[] args) {
        char[][] board = new char[][]{{'a','a'}};
        String[] words = new String[]{"aa"};
        List<String> res= findWords(board,words);
        System.out.println(res);
    }
    static List<String> res = new LinkedList<>();
    static Set<String> set = new HashSet<>();
    public static List<String> findWords(char[][] board, String[] words) {
        int m =board.length;
        int n = board[0].length;
        for(String word:words){
            boolean[][] visited = new boolean[board.length][board[0].length];
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(board[i][j]==word.charAt(0)){
                        dfs(board,visited,word,i,j,0);
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }
    public static void dfs(char[][] board,boolean[][] visited,String word,int i,int j,int k){
        int n = word.length();
        if(k==n){
            set.add(word);
            return;
        }
        char c = word.charAt(k);
        
        if(i<0||i>=board.length||j<0||j>=board[0].length||board[i][j]!=c||visited[i][j]){
            return;
        }
        visited[i][j] =true;
        dfs(board,visited,word,i-1,j,k+1);
        dfs(board,visited,word,i+1,j,k+1);
        dfs(board,visited,word,i,j-1,k+1);
        dfs(board,visited,word,i,j+1,k+1);
        visited[i][j] = false;
    }
}