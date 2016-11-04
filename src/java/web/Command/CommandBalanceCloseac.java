/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.Command;

import java.io.Serializable;


public class CommandBalanceCloseac implements Serializable {

    private String accountnumber;

    private String password;

    public CommandBalanceCloseac() {
        this.accountnumber = "the account number";

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
