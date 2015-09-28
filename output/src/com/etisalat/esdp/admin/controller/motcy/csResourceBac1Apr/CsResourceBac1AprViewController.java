package com.etisalat.esdp.admin.controller.motcy.csResourceBac1Apr;

import ae.etisalat.motcy.model.CsResourceBac1Apr;

import eg.java.net.web.jspx.engine.annotation.JspxBean;
import eg.java.net.web.jspx.engine.util.StringUtility;
import eg.java.net.web.jspx.ui.controls.WebControl;
import eg.java.net.web.jspx.ui.pages.ContentPage;

public class CsResourceBac1AprViewController extends ContentPage
{
	@JspxBean(name="csResourceBac1Apr" , dateformat="dd/MM/yyyy HH:mm:ss", scope = JspxBean.CONVERSATION)
CsResourceBac1Apr csResourceBac1Apr = new CsResourceBac1Apr();
public void deleteBean(WebControl invoker, String args)
{
}


	int id = 0;
	
	@Override
	protected void pageLoaded()
	{
		if (StringUtility.isNullOrEmpty(request.getParameter("id")))
		{
			csResourceBac1Apr = null;
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
