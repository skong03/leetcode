import java.util.*;

class Test{
    public static void main(String[] args){	
		String s1 = "cdeababcfgcabcz";
		String s2 = "abc";
		KmpString ks = new KmpString();
		
		//求第一个s2在s1中出现的位置
		System.out.println(ks.norStr(s1, s2));
		System.out.println(ks.kmpStr(s1, s2));
	}	
}

class KmpString{
	//简单算法
	public int norStr(String s1, String s2){
		int res = -1;
		if(s1.length() < s2.length()) return -1;
		for(int i=0; i<s1.length()+1-s2.length(); i++){
			if(s1.charAt(i) == s2.charAt(0)){
				res = check(s1, s2, i);
				if(res == -1) continue;
				else return res;
			}
		}
		return res;
	}
	private int check(String s1, String s2, int index){
		for(int i=0; i<s2.length(); i++)
			if(s1.charAt(index+i) != s2.charAt(i))
				return -1;
		return index;
	}
	
	//KMP算法
	public int kmpStr(String target, String pattern){
		int[] overLay = iniOverLay(pattern);
		int t = 0, p = 0;
		while(t<target.length() && p<pattern.length()){
			if(target.charAt(t) == pattern.charAt(p)){
				t++;
				p++;
			}
			else if(p == 0) t++;
			else p = overLay[p-1]+1;
		}
		if(p == pattern.length()) return t-p;
		else return -1;
	}
	private int[] iniOverLay(String pattern){
		char[] pat = pattern.toCharArray();
		int[] overLay = new int[pat.length];
		int index = -1;
		overLay[0] = -1;
		for(int i=1; i<pat.length; i++){
			index = overLay[i-1];
			while(index>=0 && pat[index+1]!=pat[i])
				index = overLay[index];
			if(pat[index+1] == pat[i])
				overLay[i] = index + 1;
			else
				overLay[i] = -1;
		}
		return overLay;
	}
}























