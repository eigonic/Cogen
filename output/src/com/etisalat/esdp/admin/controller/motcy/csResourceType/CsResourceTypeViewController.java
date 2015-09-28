package com.etisalat.esdp.admin.controller.motcy.csResourceType;

import ae.etisalat.motcy.model.CsResourceType;

import eg.java.net.web.jspx.engine.annotation.JspxBean;
import eg.java.net.web.jspx.engine.util.StringUtility;
import eg.java.net.web.jspx.ui.controls.WebControl;
import eg.java.net.web.jspx.ui.pages.ContentPage;

public class CsResourceTypeViewController extends ContentPage
{
	@JspxBean(name="csResourceType" , dateformat="dd/MM/yyyy HH:mm:ss", scope = JspxBean.CONVERSATION)
CsResourceType csResourceType = new CsResourceType();
public void deleteBean(WebControl invoker, String args)
{
}


	int id = 0;
	
	@Override
	protected void pageLoaded()
	{
		if (StringUtility.isNullOrEmpty(request.getParameter("id")))
		{
			csResourceType = null;
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
