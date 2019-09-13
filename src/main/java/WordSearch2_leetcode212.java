import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.LinkedList;

public class WordSearch2_leetcode212 {

    public static void main(String[] args) {
        char[][] board = {{'b','b','a','a','b','a'},{'b','b','a','b','a','a'},{'b','b','b','b','b','b'},
                {'a','a','a','b','a','a'},{'a','b','a','a','b','b'}};
        String[] words = {"abbbababaa"};
        WordSearch2_leetcode212 obj = new WordSearch2_leetcode212();
        System.out.println(obj.findWords(board, words).toString());
    }

    public class TrieNode{
        public boolean isWord = false;
        public TrieNode[] child = new TrieNode[26];
                    public TrieNode(){

                    }
    }

    TrieNode root = new TrieNode();
    boolean[][] flag;
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> result = new HashSet<>();
        flag = new boolean[board.length][board[0].length];

        addToTrie(words);

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(root.child[board[i][j] - 'a'] != null){
                    search(board, i, j, root, "", result);
                }
            }
        }

        return new LinkedList<>(result);
    }

    private void addToTrie(String[] words){
        for(String word: words){
            TrieNode node = root;
            for(int i = 0; i < word.length(); i++){
                char ch = word.charAt(i);
                if(node.child[ch - 'a'] == null){
                    node.child[ch - 'a'] = new TrieNode();
                }
                node = node.child[ch - 'a'];
            }
            node.isWord = true;
        }
    }

    private void search(char[][] board, int i, int j, TrieNode node, String word, Set<String> result){
        if(i >= board.length || i < 0 || j >= board[i].length || j < 0 || flag[i][j]){
            return;
        }

        if(node.child[board[i][j] - 'a'] == null){
            return;
        }

        flag[i][j] = true;
        node = node.child[board[i][j] - 'a'];
        if(node.isWord){
            result.add(word + board[i][j]);
        }

        search(board, i-1, j, node, word + board[i][j], result);
        search(board, i+1, j, node, word + board[i][j], result);
        search(board, i, j-1, node, word + board[i][j], result);
        search(board, i, j+1, node, word + board[i][j], result);

        flag[i][j] = false;
    }

//    public static List<String> findWords(char[][] board, String[] words) {
//
//        if(board == null || words == null || words.length==0 || (board.length==0 && board[0].length==0))
//            return new ArrayList<>();
//
//        Set<String> result = new HashSet<>();
//        List<String> wordList = Arrays.asList(words);
//        boolean[][] visited = new boolean[board.length][board[0].length];
//
//        for(int i=0;i<board.length;i++) {
//            for(int j=0;j<board[0].length;j++) {
//                findWordsDfs(board, wordList, visited, result, i, j, "");
//            }
//        }
//        return new ArrayList<>(result);
//    }
//
//    public static void findWordsDfs(char[][] board, List<String> words, boolean[][] visited, Set<String> result, int i, int j, String word) {
//
//        if(i<0 || j<0 || i>=board.length || j>=board[0].length || visited[i][j])
//            return;
//
//        String currWord = word + board[i][j];
//        if(words.contains(currWord)) {
//            result.add(currWord);
//        }
//        visited[i][j] = true;
//        findWordsDfs(board, words, visited, result, i+1, j, currWord);
//        findWordsDfs(board, words, visited, result, i-1, j, currWord);
//        findWordsDfs(board, words, visited, result, i, j+1, currWord);
//        findWordsDfs(board, words, visited, result, i, j-1, currWord);
//        visited[i][j] = false;
//
//    }

}
