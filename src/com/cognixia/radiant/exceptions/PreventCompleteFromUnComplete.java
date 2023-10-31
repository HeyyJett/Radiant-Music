package com.cognixia.radiant.exceptions;

public class PreventCompleteFromUnComplete extends Exception {

    public PreventCompleteFromUnComplete(){
        super("You cannot move this music from 'Uncompleted' to 'Completed'. You must move music to 'In-Progress' first.");
    }

}
