package codingQuestions;

public class vmWareStringCompressor {

    public static void main(String[] args) {
        System.out.println(betterCompression("a12b56c1"));
    }

    public static String betterCompression(String s){

        char c=' ';
        int[] ArrCnt = new int[26];
        char ch;
        for(int i=0;i<s.length();i++){

            ch=s.charAt(i);

            if(isChar(ch)){
                System.out.println("Ch- "+ ch);
                c = ch;
            }
            else{
                int j=i;
                while (j<s.length() && !isChar(s.charAt(j))){
                    j++;
                }
                ArrCnt[c-'a']+=Integer.parseInt(s.substring(i,j));
                i=j-1;
            }
        }
        StringBuilder res= new StringBuilder();
        for(int i=0;i<26;i++){
            if(ArrCnt[i]>0)
            res.append((char)('a'+i)+"").append(ArrCnt[i]+"");
        }
        return res.toString();
    }

    static boolean isChar(char ch){
        if(ch<='z' && ch>='a'){
            return true;
        }
        return false;
    }
}
