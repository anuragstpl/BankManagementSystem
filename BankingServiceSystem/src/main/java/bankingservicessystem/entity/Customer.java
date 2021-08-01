/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingservicessystem.entity;

/**
 *
 * @author anura
 */
public class Customer {
     private String customerID;

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }
    
   private String name;

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }
    
    private String email;

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }
    
    private String phoneno;

    public String getphoneno() {
        return phoneno;
    }

    public void setphoneno(String phoneno) {
        this.phoneno = phoneno;
    }
    
    private String accountType;

    public String getaccountType() {
        return accountType;
    }

    public void setaccountType(String accountType) {
        this.accountType = accountType;
    }
    
    private String address;

    public String getaddress() {
        return address;
    }

    public void setaddress(String address) {
        this.address = address;
    }
    
    private String city;

    public String getcity() {
        return city;
    }

    public void setcity(String city) {
        this.city = city;
    }
    
    private String state;

    public String getstate() {
        return state;
    }

    public void setstate(String state) {
        this.state = state;
    }
    
    private String country;

    public String getcountry() {
        return country;
    }

    public void setcountry(String country) {
        this.country = country;
    }
    
    private double balance;

    public double getbalance() {
        return balance;
    }

    public void setbalance(double balance) {
        this.balance = balance;
    }
}
