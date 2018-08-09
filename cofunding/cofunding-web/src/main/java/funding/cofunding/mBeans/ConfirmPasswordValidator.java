package funding.cofunding.mBeans;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("confirmPasswordValidator")
public class ConfirmPasswordValidator implements Validator{


	  @Override
    public void validate (FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String password = (String) value;
        UIInput confirmPasswordComponent = (UIInput) component.getAttributes().get("confirm");
        String confirm = (String) confirmPasswordComponent.getSubmittedValue();

        if (password == null || confirm == null) {
            return; // Just ignore and let required="true" do its job.
        }

        if (!password.equals(confirm)) {
        	context.addMessage(null, new FacesMessage("Passwords are not equal."));
        	context.validationFailed();
        	((UIInput) component).setValid(false);
        	confirmPasswordComponent.setValid(false);
        	return;
        }
    }
}

	