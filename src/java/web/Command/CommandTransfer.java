/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.Command;

import java.io.Serializable;


public class CommandTransfer implements Serializable {

    private String accountnumber;

    private String password;
    private String amount;
    private String targetaccountnumber;

    public CommandTransfer() {
        this.accountnumber = "the account number";
        this.targetaccountnumber = "the target account number";
        this.amount = "write the amount";

    }

    public void setTargetaccountnumber(String targetaccountnumber) {
        this.targetaccountnumber = targetaccountnumber;
    }

    public String getTargetaccountnumber() {
        return targetaccountnumber;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAmount() {
        return amount;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
    }

    public String getAccountnumber() {
        return accountnumber;
    }

}
