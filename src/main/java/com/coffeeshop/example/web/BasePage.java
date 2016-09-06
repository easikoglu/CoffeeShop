package com.coffeeshop.example.web;

import com.coffeeshop.example.web.user.SessionUser;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

/**
 * @author erhanasikoglu
 */
public abstract  class BasePage {
   @Context
   HttpServletRequest servletRequest;


   protected SessionUser getCurrentUser() {
      return (SessionUser) this.servletRequest.getSession().getAttribute("sessionUser");
   }


   protected void setCurrentUser(SessionUser sessionUser) {
       this.servletRequest.getSession().setAttribute("sessionUser", sessionUser);
   }



}
