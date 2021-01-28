package com.keshav.mobius.model;

import java.util.*;

public class HelloWorld{



    public static void main(String []args){


        Scanner sc = new Scanner(System.in);
        Float[] R = new Float[100];
        for(int i=0;i<100;i++){
            if(sc.nextFloat()=='q'){
                break;
            }
            else{

                R[i] = sc.nextFloat();
            }
        }

        for(int i=0;i<R.length;i++){
            if(R[i]<0||R[i]>42.195){
                System.out.println("Invalid input ");
                break;
            }
            else{
                System.out.println(R[i]);
            }

        }
    }

}