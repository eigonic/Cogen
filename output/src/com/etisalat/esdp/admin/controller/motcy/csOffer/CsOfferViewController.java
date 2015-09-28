package com.etisalat.esdp.admin.controller.motcy.csOffer;

import ae.etisalat.motcy.model.CsOffer;

import eg.java.net.web.jspx.engine.annotation.JspxBean;
import eg.java.net.web.jspx.engine.util.StringUtility;
import eg.java.net.web.jspx.ui.controls.WebControl;
import eg.java.net.web.jspx.ui.pages.ContentPage;

public class CsOfferViewController extends ContentPage
{
	@JspxBean(name="csOffer" , dateformat="dd/MM/yyyy HH:mm:ss", scope = JspxBean.CONVERSATION)
CsOffer csOffer = new CsOffer();
public void deleteBean(WebControl invoker, String args)
{
}


	int id = 0;
	
	@Override
	protected void pageLoaded()
	{
		if (StringUtility.isNullOrEmpty(request.getParameter("id")))
		{
			csOffer = null;
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
