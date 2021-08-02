/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingservicessystem.helper;

import bankingservicessystem.entity.Customer;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anura
 */
public class CustomerHelper {
    
     String fileName = "D:\\customer.txt";

    public boolean isDataExists() {
        boolean isExists = false;
        try {
            Path path = Paths.get(fileName);
            byte[] bytes = Files.readAllBytes(path);
            List<String> allLines = Files.readAllLines(path, StandardCharsets.UTF_8);
            if (allLines.size() > 0 && !allLines.get(0).equals("")) {
                isExists = true;
            }
        } catch (IOException ex) {
            Logger.getLogger(CustomerHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isExists;
    }

     public List<Customer> GetAllCustomers() {
        List<Customer> lstCustomers = new ArrayList<>();
        try {
            if (isDataExists()) {
                Path path = Paths.get(fileName);
                byte[] bytes = Files.readAllBytes(path);
                List<String> allLines = Files.readAllLines(path, StandardCharsets.UTF_8);
                for (String data : allLines) {
                    Customer cust = new Customer();
                    String[] arrOfStr = data.split("::");
                    cust.setCustomerID(arrOfStr[0]);
                    cust.setaccountType(arrOfStr[1]);
                    cust.setaddress(arrOfStr[2]);
                    cust.setbalance(Double.parseDouble(arrOfStr[3]));
                    cust.setcity(arrOfStr[4]);
                    cust.setcountry(arrOfStr[5]);
                    cust.setemail(arrOfStr[6]);
                    cust.setname(arrOfStr[7]);
                    cust.setphoneno(arrOfStr[8]);
                    cust.setstate(arrOfStr[9]);
                    lstCustomers.add(cust);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(CustomerHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstCustomers;
    }
     
      public Customer GetCustomerByID(String customerID) {
        Customer cust = new Customer();
        try {
            if (isDataExists()) {
                Path path = Paths.get(fileName);
                byte[] bytes = Files.readAllBytes(path);
                List<String> allLines = Files.readAllLines(path, StandardCharsets.UTF_8);
                for (String data : allLines) {
                    String[] arrOfStr = data.split("::");
                    if(arrOfStr[0].equals(customerID)){
                    cust.setCustomerID(arrOfStr[0]);
                    cust.setaccountType(arrOfStr[1]);
                    cust.setaddress(arrOfStr[2]);
                    cust.setbalance(Double.parseDouble(arrOfStr[3]));
                    cust.setcity(arrOfStr[4]);
                    cust.setcountry(arrOfStr[5]);
                    cust.setemail(arrOfStr[6]);
                    cust.setname(arrOfStr[7]);
                    cust.setphoneno(arrOfStr[8]);
                    cust.setstate(arrOfStr[9]);
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(CustomerHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cust;
    }
     
     public Boolean AddCustomers(Customer customer) {
        Boolean isCustomerAdded = false;
        try {
            String fileContent = customer.getCustomerID()+ "::" + customer.getaccountType()+ "::" + customer.getaddress()+ "::" + customer.getbalance()+ "::" + customer.getcity()+ "::" + customer.getcountry()+ "::" + customer.getemail()+ "::" + customer.getname()+ "::" + customer.getphoneno()+ "::" + customer.getstate();
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.write(fileContent);
            writer.write(System.getProperty("line.separator"));
            writer.close();
            isCustomerAdded = true;
        } catch (IOException ex) {
            Logger.getLogger(CustomerHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isCustomerAdded;
    }

    public Boolean UpdateCustomers(Customer customer) {
        Boolean isCustomerUpdated = false;
        try {
            FileReader reader = new FileReader(fileName);
            List<Customer> lstCustomers = GetAllCustomers();
            PrintWriter writer1 = new PrintWriter(fileName);
            writer1.print("");
            writer1.close();
            String fileContent = "";
            for (Customer cust : lstCustomers) {
                if (!cust.getCustomerID().equalsIgnoreCase(customer.getCustomerID())) {
                    fileContent = fileContent + cust.getCustomerID()+ "::" + cust.getaccountType()+ "::" + cust.getaddress() + "::" + cust.getbalance() + "::" + cust.getcity() + "::" + cust.getcountry() + "::" + cust.getemail() +"::" + cust.getname() +"::" + cust.getphoneno() +"::" + cust.getstate() + "/n";
                }
            }
            fileContent = fileContent + customer.getCustomerID() + "::" + customer.getaccountType() + "::" + customer.getaddress() + "::" + customer.getbalance() + "::" + customer.getcity() + "::" + customer.getcountry() + "::" + customer.getemail() +"::" + customer.getname() +"::" + customer.getphoneno() +"::" + customer.getstate() + "/n";
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(fileContent);
            writer.close();
            isCustomerUpdated = true;
        } catch (IOException ex) {
            Logger.getLogger(CustomerHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isCustomerUpdated;
    }
}
