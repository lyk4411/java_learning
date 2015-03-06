package com.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

public class HelloAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		HelloForm hf = (HelloForm)form;
		
		ActionMessages errors = new ActionMessages();
		if(hf.getName().equals("god")){
			errors.add("action error",new ActionMessage("error.hello.nameinvalidate"));
			this.saveErrors(request, errors);
			
			return mapping.getInputForward();
		}
		
		return mapping.findForward("success");
	}
	
}
