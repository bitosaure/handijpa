/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.m1.miage.sorbonne.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author thibault
 */
@FacesValidator("numberValidator")
public class NumberValidator implements Validator{

    public void validate(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ValidatorException {
		
		boolean valide = true;
		String chaine = String.valueOf(arg2);
		if (chaine.isEmpty()) {
			valide = true;
		} else {
			Pattern pattern = Pattern.compile("[0-9]+");
			Matcher matcher = pattern.matcher(chaine);
			valide = matcher.matches();
		}
		if (!valide) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Le champs contient des caractères alphanumériques","");
			throw new ValidatorException(message);
		}

	}
    
}
