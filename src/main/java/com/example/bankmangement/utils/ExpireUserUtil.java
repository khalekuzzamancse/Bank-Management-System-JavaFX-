package com.example.bankmangement.utils;

import com.example.bankmangement.constants.TableName;
import com.example.bankmangement.entity.Customer;
import com.example.bankmangement.entity.ExpireUser;
import com.example.bankmangement.entity.Lease;
import com.example.bankmangement.utils.DateTimeUtils;
import com.example.bankmangement.utils.Fao;

import java.util.*;

public class ExpireUserUtil {
    //the Problem statement:
//    In java,I have a List<Customer>customerList where the Customer class a field called
//    customerID,email,name,and I have a another List<Lease>leaseList where also have
//    the same field called customerID  and a field called expireDate as String ,boxNumberas as Interger.
//    now given a expire date,find the list of all Lease that have the expireDate as same as the given expire date.
//    now i want to create a separate list of List<ExpireUser>,where
//    the ExpireUser class have the field the customerID,name,email,boxNumber, and the expireDate,give  the code using javastream

    public static List<ExpireUser> getExpireUsers() {

        List<Customer> customerList = Fao.read(TableName.CUSTOMER_TABLE);
        List<Lease> leaseList = Fao.read(TableName.LEASE_TABLE);
        String expireDate="2023-08-31";
      //  String expireDate = DateTimeUtils.geDateFromToday(1);
        // Filter leases with given expire date and map to ExpireUser
        List<ExpireUser> expireUserList = leaseList.stream()
                .filter(l -> l.getExpireDate().equals(expireDate))
                .map(l -> {
                    Customer customer = customerList.stream()
                            .filter(c -> c.getUserID() == l.getCustomerID())
                            .findFirst().orElse(null);
                    return new ExpireUser(
                            l.getCustomerID(),
                            customer.getName(),
                            customer.getEmail(),
                            l.getBoxNumber(),
                            l.getExpireDate()
                    );
                })
                .toList();
        //System.out.println(expireUserList);
        return expireUserList;
    }
}
