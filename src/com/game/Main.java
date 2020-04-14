package com.game;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main // Main Class
{
    public static int comp(String s1, String s2) // a function that is used to compare between choices and choose accoridng to their superiority over each other
    											// like stone can beat scissor, scissor can beat paper and paper can beat stone according to traditional rule of game	
    {
        int ans = 0; // a variable if its 1 then string s1 beat s2 else viceversa
        if(s1=="paper")
        {
            if(s2=="paper")
            {
                ans=0;
            }
            else if(s2=="stone")
            {
                ans=1;
            }
            else if(s2=="scissor")
            {
                ans=0;
            }
        }
        else if(s1=="stone")
        {
            if(s2=="paper")
            {
                ans=0;
            }
            else if(s2=="stone")
            {
                ans=0;
            }
            else if(s2=="scissor")
            {
                ans=1;
            }
        }
        else if(s1=="scissor")
        {
            if(s2=="paper")
            {
                ans=1;
            }
            else if(s2=="stone")
            {
                ans=0;
            }
            else if(s2=="scissor")
            {
                ans=0;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
    	
    	
    	ApplicationContext ac = new AnnotationConfigApplicationContext(ConfigClass.class); // to establish applicationContext
		
    	// to give instance to variable
    	GenerateChoice player1 = ac.getBean("generateChoice",GenerateChoice.class); 
		GenerateChoice player2 = ac.getBean("generateChoice",GenerateChoice.class);
    	GenerateChoice player3 = ac.getBean("generateChoice",GenerateChoice.class);
    	GenerateChoice player4 = ac.getBean("generateChoice",GenerateChoice.class);
    	int i=0;
        int[][] array = new int[4][4]; // declare a array to store values
        while(i<50)
        {
        	// to assign random values generated using rand function  
            String c1= player1.generate_choice(); 
            String c2= player2.generate_choice();
            String c3= player3.generate_choice();
            String c4= player4.generate_choice();
            
            
            System.out.println("Iteration no."+ (i+1));
            // for player 1
            array[0][1]=array[0][1]+comp(c1,c2);
            array[0][2]=array[0][2]+comp(c1,c3);
            array[0][3]=array[0][3]+comp(c1,c4);
            
            // for player 2
            array[1][0]=array[1][0]+comp(c2,c1);
            array[1][2]=array[1][2]+comp(c2,c3);
            array[1][3]=array[1][3]+comp(c2,c4);
            
            // for player 3
            array[2][0]=array[2][0]+comp(c3,c1);
            array[2][1]=array[2][1]+comp(c3,c2);
            array[2][3]=array[2][3]+comp(c3,c4);
            
            // for player 4
            array[3][0]=array[3][0]+comp(c4,c1);
            array[3][1]=array[3][1]+comp(c4,c2);
            array[3][2]=array[3][2]+comp(c4,c3);
            
            for(int j=0;j<4;j++)
            {
                for(int l=0;l<4;l++)
                {
                    if(j==l)
                    {
                        System.out.print("- ");
                    }
                    else
                    {
                        System.out.print(array[j][l]+" ");
                    }
                }
                System.out.println();
            }
            i++;
        }
    }
}

