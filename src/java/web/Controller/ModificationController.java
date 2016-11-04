/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.Controller;


import BusinessLayer.model.Utilisateur;
import BusinessLayer.service.SearchService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import web.Command.CommandModification;

/**
 *
 * @author Hassen
 */
public class ModificationController extends SimpleFormController {

    SearchService service;

    public SearchService getService() {
        return service;
    }

    public void setService(SearchService service) {
        this.service = service;
    }

    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {
        int id;
        try{id = Integer.parseInt(request.getParameter("id"));}catch(Exception e){id=1;}
        System.out.println("iiiiiiiiiiiiiiddddddd controlleur" + id);
        Utilisateur u = service.getUtilisateur(id);
        System.out.println(u.toString());
        return new CommandModification(u);
    }

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request,
            HttpServletResponse response,
            Object commandModif,
            BindException errors) throws Exception {

        CommandModification command = (CommandModification) commandModif;

        try {
            Utilisateur u = service.getUtilisateur(Integer.parseInt(request.getParameter("id")));
            //Utilisateur u=service.getUtilisateur(1);
            
            SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
            try {
                u.setDateNaissance((command.getDateNaissance() == null & command.getDateNaissance().isEmpty()) ? null : myFormatter.parse(command.getDateNaissance()));
            } catch (ParseException e) {
                u.setDateNaissance(null);
            }
            u.setAdresse(command.getAdresse() == null ? null : command.getAdresse());
            u.setCin(command.getCin() == null ? null : command.getCin());
            u.setEnabled(command.getEnabled() == null ? !command.getEnabled().equals("true") : command.getEnabled().equals("true"));
            u.setLogin(command.getLogin());
            u.setNom(command.getNom() == null ? null : command.getNom());
            u.setPass(command.getPass());
            u.setPernom(command.getPernom() == null ? null : command.getPernom());
            u.setProfession(command.getProfession() == null ? null : command.getProfession());
            u.setRole(command.getRole() == null ? null : command.getRole());
            u.setTelephone(command.getTelephone() == null ? null : Double.parseDouble(command.getTelephone()));
            System.out.println("before");
            System.out.println(u.toString());
            service.updateUtilisateur(u);
            System.out.println("********" + u.toString());
            HashMap<String, Object> map = new HashMap<>(2);
            map.put("id", 1);
            map.put("commandModification", command);
            System.out.println(command.getProfession());
            System.out.println("on submit controller");
            return new ModelAndView("modification", "commandModification", command);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            errors.reject("Inexistant User", "No users found");
            return showForm(request, response, errors);

        }

    }
}
