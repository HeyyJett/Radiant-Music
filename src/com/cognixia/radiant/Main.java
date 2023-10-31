package com.cognixia.radiant;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
       
    	Scanner sc = new Scanner(System.in);
 
    	
    	
    	
    	System.out.println("Welcome to The Radiant Music Network, please choose an option!");
        System.out.println("--------------------------------------------------------------");
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
        	System.out.println("Sorry please choose option 1 or 2.");
        }
        sc.close();
        
        
    }
    
    
    
    
    static void exploreMusicList() {
    	System.out.println("\nSong List:");
    	System.out.println("-----------------------");
    	//displayAllSongs();
    	
    }
    
    
    static void login() {
    	
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.println("Please enter your username:");
    	String username = sc.nextLine();
    	
    	
    	System.out.println("Please enter your password:");
    	String password = sc.nextLine();
    	
    	//
    	if (username.equals("Jason") && password.equals("123")) {
    		userMenu();
    	}
    	else {
    		System.out.println("Login Error");
    	}
    	
    	sc.close();
    }
    
    
 static void userMenu() {
  
	 	boolean userLoggedIn = true;
    	Scanner sc = new Scanner(System.in);
    	
    	while (userLoggedIn) {
    		System.out.println("\nWelcome please choose an option:" );
        	System.out.println("-----------------------------------------");
        	System.out.println("1: Display all songs");
            System.out.println("2: Display incomplete songs");
            System.out.println("3: Display in progress songs");
            System.out.println("4: Display complete songs");
            System.out.println("5: Add a song");
            System.out.println("6: Exit");
        	
        	int userOption2 = sc.nextInt();
        	
        	switch (userOption2) {
            case 1:
            	//displayAllSongs();
            	break;
            case 2:
            	//displayAllIncomplete();
            	break;
            case 3:
            	//displayAllInprogress();
            	break;
            case 4:
            	//displayAllComplete();
            	break;
            case 5:
            	addSongMenu();
            	//break;
            case 6:
            	userLoggedIn = false;
            	break;
        	default:
        		System.out.println("Sorry please choose option on the list.");
        	}
        	
    	}
    	
    	sc.close();
    }
 
 
 static void addSongMenu() {
	 Scanner sc = new Scanner(System.in);
	 
	 System.out.println("\nAdding Song:");
	 System.out.println("------------");
	 System.out.println("which category would you like to add to?: ");
	 System.out.println("-----------------------------------------");
 	 System.out.println("1: Incomplete");
     System.out.println("2: In Progress");
     System.out.println("3: Complete");
     
	 int userOption3 = sc.nextInt();
 	
 	switch (userOption3) {
     case 1:
     	addToIncompleteMenu();
     	break;
     case 2:
     	addToInProgressMenu();
     	break;
     case 3:
     	addToCompleteMenu();
     	break;
     default:
    	 System.out.println("Sorry please choose option on the list.");
 	}
     
     
     sc.close();


 }
 	
 
 static void addToIncompleteMenu() {
	 Scanner sc = new Scanner(System.in);
	 
	 System.out.println("Please enter the title of the song: ");
     String addTitle = sc.nextLine();
     System.out.println("Please enter the artist of the song: ");
     String addArtist = sc.nextLine();
     System.out.println("Please enter the length of the song in sec: ");
     int addLength = sc.nextInt();
     
     System.out.println("\nThe song '" + addTitle + "' was added to 'incomplete'");
     sc.close();
 }
    
 static void addToInProgressMenu() {
	 Scanner sc = new Scanner(System.in);
	 
	 System.out.println("Please enter the title of the song: ");
     String addTitle = sc.nextLine();
     System.out.println("Please enter the artist of the song: ");
     String addArtist = sc.nextLine();
     System.out.println("Please enter the length of the song in sec: ");
     int addLength = sc.nextInt();
     
     System.out.println("\nThe song '" + addTitle + "' was added to 'in progress'");
 }
 
 static void addToCompleteMenu() {
	 Scanner sc = new Scanner(System.in);
	 
	 System.out.println("Please enter the title of the song: ");
     String addTitle = sc.nextLine();
     System.out.println("Please enter the artist of the song: ");
     String addArtist = sc.nextLine();
     System.out.println("Please enter the length of the song in sec: ");
     int addLength = sc.nextInt();
     
     System.out.println("\nThe song '" + addTitle + "' was added to 'complete'");
 }
    
}


