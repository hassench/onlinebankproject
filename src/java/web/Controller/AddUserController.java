/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.Controller;


import BusinessLayer.model.CustomSecurityUser;
import BusinessLayer.model.Utilisateur;
import BusinessLayer.service.AddUserService;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import web.Command.CommandAddUser;

public class AddUserController extends SimpleFormController {

    AddUserService adduserservice;

    public AddUserService getAdduserservice() {
        return adduserservice;
    }

    public void setAdduserservice(AddUserService adduserservice) {
        this.adduserservice = adduserservice;
    }

    protected Object formBackingObject(HttpServletRequest request) {
        CustomSecurityUser currentUser = (CustomSecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(currentUser.getId());
        return new CommandAddUser();
    }

    protected ModelAndView onSubmit(HttpServletRequest request,
            HttpServletResponse response, Object commandAddUser,
            BindException errors) throws Exception {

        try{
        CommandAddUser command = (CommandAddUser) commandAddUser;
        Utilisateur u = new Utilisateur();
        u.setNom(command.getNom().isEmpty() ? null : command.getNom());
        u.setPernom(command.getPernom().isEmpty() ? null : command.getPernom());
        u.setCin(command.getCin().isEmpty() ? null : command.getCin());
        SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
            try {
                u.setDateNaissance((command.getDateNaissance() == null & command.getDateNaissance().isEmpty()) ? null : myFormatter.parse(command.getDateNaissance()));
            } catch (Exception e) {
                u.setDateNaissance(null);
            }
        u.setAdresse(command.getAdresse().isEmpty() ? null : command.getAdresse());
        u.setProfession(command.getProfession().isEmpty() ? null : command.getProfession());
        u.setTelephone(command.getTelephone().isEmpty() ? null : Double.parseDouble(command.getTelephone()));
        u.setLogin(command.getLogin());
        u.setPass(command.getPass());
        u.setRole(command.getRole());
        u.setEnabled(Boolean.TRUE);

        adduserservice.addUser(u);
        return new ModelAndView("usercreationsuccess", "user", u);
    }catch(Exception e){
    errors.reject("errors", "invalid");
			return showForm(request, response, errors);}
    }
    

}
