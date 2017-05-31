package fr.ca.sa.aims.web.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


/**
 * Validateur de saisie de champs
 * 
 * @author LEGRATH - PISUEMI
 *
 */

@FacesValidator("champsValidator")
public class ChampsValidator implements Validator {
	/**
	 * Méthode testant le contenu du champs grâce à une regexp
	 * 
	 */
	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ValidatorException {
		
		boolean valide = true;
		String chaine = String.valueOf(arg2);
		if (chaine.isEmpty()) {
			valide = true;
		} else {
			Pattern pattern = Pattern.compile("[-a-zA-ZÀ-ÿ ]*+");
			Matcher matcher = pattern.matcher(chaine);
			valide = matcher.matches();
		}
		if (!valide) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"le champs contient des chiffres","");
			throw new ValidatorException(message);
		}

	}

}
