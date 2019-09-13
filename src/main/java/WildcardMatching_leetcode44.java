public class WildcardMatching_leetcode44 {

//    https://leetcode.com/problems/wildcard-matching/discuss/17859/Evolve-from-brute-force-to-optimal
    /* https://leetcode.com/problems/wildcard-matching/discuss/17812/My-java-DP-solution-using-2D-table
         bool isMatch(string s, string p) {
        vector<vector<char>> mem(s.size()+1,vector<char>(p.size(),-1));
        return isMatch(0,0,s,p,mem);
    }
    bool isMatch(int i, int j, string& s, string& p,vector<vector<char>> &mem) {
        int sn = s.size();
        if(j==p.size()) return i==sn;
        if(mem[i][j]!=-1) return mem[i][j];
        if(p[j]=='*') return mem[i][j]= isMatch(i,j+1,s,p,mem) || (i<sn && isMatch(i+1,j,s,p,mem));
        if(i<sn && (p[j]=='?'|| s[i]==p[j])) return mem[i][j]=isMatch(i+1,j+1,s,p,mem);
        return mem[i][j]=0;
    }
     */

    public static void main(String[] args) {
        String str = "asds.asds.asds";
        int i = str.indexOf(".");
        System.out.println(i);
        i = str.indexOf(".", i+1);
        System.out.println(i);
        i = str.indexOf(".", i+1);
        System.out.println(i);
        StringBuilder sb = new StringBuilder(str);
        sb.insert(sb.length(), 'z');
        System.out.println(sb.toString());
    }

}
