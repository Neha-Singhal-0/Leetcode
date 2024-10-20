//Problem Link :https://leetcode.com/problems/parsing-a-boolean-expression/?envType=daily-question&envId=2024-10-20
//Solution Link :https://leetcode.com/problems/parsing-a-boolean-expression/solutions/5941385/simple-to-follow/
class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> st=new Stack<>(); //O(n)->Space
        for(int i=0;i<expression.length();i++){//O(n)->Time
            char ch=expression.charAt(i);
            if(ch==','){
                continue;
            }else if(ch==')'){
                 int yes=0;
                 int no=0;
                 while(st.peek()!='('){
                    char top=st.pop();
                    if(top=='t')yes++;
                    else no++;
                 }
                 st.pop();//remove '('
                 char operator=st.pop();
                 if(operator=='!'){
                    if(yes>0)st.push('f');
                    else st.push('t');
                 }
                 else if(operator=='|'){
                    if(yes>0)st.push('t');
                    else st.push('f');
                 }else{
                    if(no>0)st.push('f');
                    else st.push('t');
                 }
                 yes=0;
                 no=0;
            }else{
                st.push(ch);
            }
        }
        return st.peek()=='t'?true:false;
    }
}
