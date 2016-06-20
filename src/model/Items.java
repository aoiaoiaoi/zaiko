/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;



import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import java.net.URL;
import java.util.Date;

import javax.jdo.annotations.*;
/**
 *
 * @author HikariHasegawa
 */
/*@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Items implements Serializable{
    private String itemId;
    private String itemName;
    private int price;
    private int num;
    

    public Items(String itemId,String itemName,int price,int num){
        this.itemId=itemId;
        this.itemName=itemName;
        this.price=price;
        this.num=num;
    }
    public String getItemId(){
        return itemId;
    }
    public String getItemName(){
        return itemName;
    }
    public int getPrice(){
        return price;
    }
    public int getNum(){
        return num;
    }
}

import java.net.URL;
import java.util.Date;
 
import javax.jdo.annotations.*;
 */

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Items {
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long itemId;
     
    @Persistent
    private String itemName;
     
    @Persistent
    private int price;
     
    @Persistent
    private int num;
    
    @Persistent
    private Date datetime;
 
 
    public Items(String itemName,int price,int num,Date datetime) {
    	//super();       

        this.itemName=itemName;
        this.price=price;
        this.num=num;
        this.datetime = datetime;
    }
    
    
    public Long getItemId(){
        return itemId;
    }
    
    public void setId(Long itemId) {
        this.itemId = itemId;
    }
    
    public String getItemName(){
        return itemName;
    }
    
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
 
    public int getPrice(){
        return price;
    }
    
    public void setPrice(int price) {
        this.price=price;
    }
 
    public int getNum(){
        return num;
    }
    
    public void setNum(int num) {
        this.num = num;
    }
 
    
    public Date getDatetime() {
        return datetime;
    }
 
    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
}
