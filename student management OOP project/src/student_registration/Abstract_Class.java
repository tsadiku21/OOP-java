/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student_registration;

/**
 *
 * @author Administrator
 */
 abstract class Abstract_Class {
    abstract public void Register()throws Exception;
    abstract public void Display()throws Exception;
    abstract public void Remove()  throws Exception;
    abstract public boolean Search(String sid)  throws Exception;
 }