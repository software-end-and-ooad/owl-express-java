/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Actor;
import Model.User;
import Model.Admin;
/**
 *
 * @author Utt
 */
public class ActorFactory {
    public Actor getActor(String actor){
        if(actor.equals("USER"))
            return new User();
        else if(actor.equals("ADMIN"))
            return new Admin();
        else
            return null;
    }
}
