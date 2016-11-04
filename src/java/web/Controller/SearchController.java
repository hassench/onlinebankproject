/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.Controller;


import BusinessLayer.model.Utilisateur;
import BusinessLayer.exception.NoUsersFoundException;
import BusinessLayer.service.SearchService;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import web.Command.CommandSearch;

/**
 *
 * @author Hassen
 */
public class SearchController extends SimpleFormController {

    SearchService service;

    public SearchService getService() {
        return service;
    }

    public void setService(SearchService service) {
        this.service = service;
    }

    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {
        return new CommandSearch();
    }

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request,
            HttpServletResponse response,
            Object CommandSearch,
            BindException errors) throws Exception {

        CommandSearch command = (CommandSearch) CommandSearch;
        SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
//        if(command.getDateNaissance().equals("")){
//            command.setDateNaissance1(myFormatter.format(new Date()));
//        }
//        command.setDateNaissance1(myFormatter.parse(command.getDateNaissance()));
        List<Utilisateur> utilisateurs;
        try {
            utilisateurs = service.getUtilisateurByCriterias(command);
            if(utilisateurs.size()==0){throw new NoUsersFoundException();}
            return new ModelAndView("searchresult", "utilisateurs", utilisateurs);
        } catch (NoUsersFoundException e) {
            errors.reject("nousers", "No users found");
			return showForm(request, response, errors);
//            e.printStackTrace();
//            return null;
        }

    }

}
