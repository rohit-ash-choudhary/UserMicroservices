package com.ashhh.user.service.Exception;

public class ResourceNotFoundException extends RuntimeException{
    
    public ResourceNotFoundException(){
        super("User don't found resource not on server");
    }

    public ResourceNotFoundException(String messsage){
        super(messsage);
    }
    

}
