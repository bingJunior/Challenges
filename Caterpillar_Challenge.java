/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author YASIR RAZA
 */
 class store {
     char body[] = new char [10];
     
     int i =0;
     void add(char top){
         body[i]=top;
         i++;
     }
      void go(){
               for(char j=0;j<body.length;j++){       
                   System.out.print(body[j]);
 
}}}
public class Caterpillar_Challenge {
    public static void main (String args[]){
    store cat = new store();
    cat.add('H');
    cat.add('I');
    cat.add('H');
    cat.add('E');
    cat.add('L');
    cat.add('L');
    cat.add('O');
    cat.go();
    
    }
}