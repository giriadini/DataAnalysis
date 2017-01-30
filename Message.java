package com.application.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path( "/message" )
public class Message {

  @GET
  @Produces( MediaType.TEXT_PLAIN )
  public String getMessage() {
    return "Just a Message";
  }
}