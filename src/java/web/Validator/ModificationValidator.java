/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.Validator;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import web.Command.CommandModification;

/**
 *
 * @author Hassen
 */
public class ModificationValidator implements Validator {

    @Override
    public boolean supports(Class arg0) {
        return CommandModification.class.equals(arg0);
    }

    @Override
    public void validate(Object o, Errors errors) {
        CommandModification command = (CommandModification) o;
        SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
        if (command.getDateNaissance()!=null){
            if(!command.getDateNaissance().isEmpty()) {
            try {
                Date parse = myFormatter.parse(command.getDateNaissance());
            } catch (Exception e) {
                errors.rejectValue("dateNaissance", "Erreur forme date", "Date format must be yyyy-mm-dd");
            }
        }}
        if (command.getTelephone()!=null) {
            try {
                Double d= Double.parseDouble(command.getTelephone());
                if(command.getTelephone().length()!=8)
                    errors.rejectValue("telephone", "Erreur log tel", "Tel must be 8 digits long");
            } catch (Exception e) {
                errors.rejectValue("telephone", "Erreur format tel", "Tel must contain only numbers AND 8 digits long");
            }
        }
        if (command.getCin()!=null) {
            try {
                int i= Integer.parseInt(command.getCin());
                if(command.getCin().length()!=8)
                    errors.rejectValue("cin", "Erreur format cin", "CIN must contain 8 digits");
            } catch (Exception e) {
                errors.rejectValue("cin", "Erreur format cin", "CIN must contain only digits");
            }
        }
        if (command.getLogin().isEmpty()) {
            errors.rejectValue("login", "Erreur login", "Must be filled");
        }
        if (command.getPass().isEmpty()) {
            errors.rejectValue("pass", "Erreur login", "Must be filled");
        }
    }

}
