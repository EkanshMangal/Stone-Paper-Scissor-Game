package com.game;

import java.util.Random;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("generateChoice")
public class GenerateChoice { 
    
	// function is used to generate a choice randomly with help of rand function
    public String generate_choice()
    {
        Random rand = new Random();
        int val = rand.nextInt(3); // it will generate integer random value from 0 to 2 
        String choice=""; // initializing variable named choice 
        if(val==0)
        {
            choice="stone";
        }
        else if(val==1)
        {
            choice="paper";
        }
        else if(val==2)
        {
            choice="scissor";
        }
        return choice; // return variable
    }
 }
