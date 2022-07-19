/*
Abbreviation Using Backtracking
1. You are given a word.
2. You have to generate all abbrevations of that word.

Input Format
A string representing a word
Constraints
1 <= length of string <= 32
Sample Input
pep
Sample Output
pep
pe1
p1p
p2
1ep
1e1
2p
*/
import java.io.*;
import java.util.*;

public class Main {

    public static void solution(String str, String asf,int count, int pos){
        //write your code here
        if(pos==str.length())
        {
        if(count==0)
        System.out.println(asf);
        else
          System.out.println(asf+count); 
          return;
        }
           //character will be included(yes)
        if(count>0)
        solution(str,asf+count+str.charAt(pos),0,pos+1);//means that last time character was not added
        else
        solution(str,asf+str.charAt(pos),0,pos+1);//means that last time character was added
        
        solution(str,asf,count+1,pos+1);//character will not be included(no)
    }
	public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        solution(str,"",0,0);
    }
    
    
}