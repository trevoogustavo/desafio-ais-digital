package com.desafio.ais.exceptions;

public class ErroNegocioalException extends Exception{
    private String message;
    private String cause;
    private String classe;
    private String nextActions;
    private String support;

  protected  ErroNegocioalException() {}
  
    public ErroNegocioalException(String message, String cause) {
        this.message = message;
        this.cause = cause;
        //this.classe = classe;
      //  this.nextActions = nextActions;
       // this.support = support;
    }
    
    public ErroNegocioalException(String message) {
    	super(message) ;
    }
}
