package com.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

public class CreateContactAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ContactForm cf =(ContactForm)form;
		
		ActionMessages errors = new ActionMessages();
		
		if(cf.getName().equalsIgnoreCase("steven")){
			errors.add("action_error",new ActionMessage("error.contact.alreadyexists"));
			saveErrors(request,errors);
			
			return mapping.getInputForward();
		}
		
		return mapping.findForward("success");
	}

}
