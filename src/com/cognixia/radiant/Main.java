package com.cognixia.radiant;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
       
    	Scanner sc = new Scanner(System.in);
 
    	
    	
    	
    	System.out.println("Welcome to The Radiant Music Network!");
        System.out.println("-------------------------------------");
        
        System.out.println("1: Explore song list");
        System.out.println("2: Login");
        int userOption = sc.nextInt();
        
        switch (userOption) {
        case 1:
        	exploreMusicList();
        	break;
        case 2:
        	login();
        	break;
        default:
        	//exception maybe?
        }
        sc.close();
        
        
    }
    
    
    
    
    static void exploreMusicList() {
    	//getall method
    }
    
    
    static void login() {
    	
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.println("Please enter your username:");
    	String username = sc.nextLine();
    	
    	
    	System.out.println("Please enter your password:");
    	String password = sc.nextLine();
    	
    	sc.close();
    }
    
    
    
    
    
    
    
    
    
}


