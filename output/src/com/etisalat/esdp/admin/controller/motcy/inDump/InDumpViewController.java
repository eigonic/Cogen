package com.etisalat.esdp.admin.controller.motcy.inDump;

import ae.etisalat.motcy.model.InDump;

import eg.java.net.web.jspx.engine.annotation.JspxBean;
import eg.java.net.web.jspx.engine.util.StringUtility;
import eg.java.net.web.jspx.ui.controls.WebControl;
import eg.java.net.web.jspx.ui.pages.ContentPage;

public class InDumpViewController extends ContentPage
{
	@JspxBean(name="inDump" , dateformat="dd/MM/yyyy HH:mm:ss", scope = JspxBean.CONVERSATION)
InDump inDump = new InDump();
public void deleteBean(WebControl invoker, String args)
{
}


	int id = 0;
	
	@Override
	protected void pageLoaded()
	{
		if (StringUtility.isNullOrEmpty(request.getParameter("id")))
		{
			inDump = null;
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
