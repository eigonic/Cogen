package com.etisalat.esdp.admin.controller.motcy.csmigReconsileSubs20141111;

import ae.etisalat.motcy.model.CsmigReconsileSubs20141111;

import eg.java.net.web.jspx.engine.annotation.JspxBean;
import eg.java.net.web.jspx.engine.util.StringUtility;
import eg.java.net.web.jspx.ui.controls.WebControl;
import eg.java.net.web.jspx.ui.pages.ContentPage;

public class CsmigReconsileSubs20141111ViewController extends ContentPage
{
	@JspxBean(name="csmigReconsileSubs20141111" , dateformat="dd/MM/yyyy HH:mm:ss", scope = JspxBean.CONVERSATION)
CsmigReconsileSubs20141111 csmigReconsileSubs20141111 = new CsmigReconsileSubs20141111();
public void deleteBean(WebControl invoker, String args)
{
}


	int id = 0;
	
	@Override
	protected void pageLoaded()
	{
		if (StringUtility.isNullOrEmpty(request.getParameter("id")))
		{
			csmigReconsileSubs20141111 = null;
			redirect("/");
		}
		else
			try
			{
				id = Integer.parseInt(request.getParameter("id"));
			}
			catch (Exception e)
			{
				redirect("/");
			}
	}
}
