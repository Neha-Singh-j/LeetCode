
class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length()) return "";
        int len=Integer.MAX_VALUE;
        String res="";
        int[] f1=new int[128];
        int[] f2=new int[128];
        for(char c: t.toCharArray()){
            f2[c-'0']++;
        }
        int st=0;
        int end=0;
        while(end<s.length()){
            char ch=s.charAt(end);
            end++;
            f1[ch-'0']++;
            while(valid(f1,f2)){
                if(len>end-st){
                    len=end-st;
                    res=s.substring(st,end);
                }
                char left=s.charAt(st);
                f1[left-'0']--;
                st++;
            }
        }
        return res;
    }
    public boolean valid(int[] a, int b[]){
        for(int i=0;i<128;i++){
            if(a[i]<b[i]) return false;
        }
        return true;
    }
}