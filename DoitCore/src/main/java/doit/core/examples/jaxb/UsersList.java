/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doit.core.examples.jaxb;

import doit.core.entites.DoitUser;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author dev
 */
@XmlRootElement(name = "users")
@XmlType(name = "", propOrder = {"userList"})
public class UsersList {
    private List<DoitUser> userList;
    
    public UsersList(){
        this.userList = new ArrayList<DoitUser>();
    }
    
    public void setUserList(List<DoitUser> userList){
        this.userList = userList;
    }
    
    @XmlElementWrapper(name = "users")
    @XmlElement(name = "user")
    public List<DoitUser> getUserList(){
        return this.userList;
    }
    
}
