package com.etisalat.esdp.admin.controller.motcy.motcyProduct;

import ae.etisalat.motcy.model.MotcyProduct;

import eg.java.net.web.jspx.engine.annotation.JspxBean;
import eg.java.net.web.jspx.engine.util.StringUtility;
import eg.java.net.web.jspx.ui.controls.WebControl;
import eg.java.net.web.jspx.ui.pages.ContentPage;

public class MotcyProductViewController extends ContentPage
{
	@JspxBean(name="motcyProduct" , dateformat="dd/MM/yyyy HH:mm:ss", scope = JspxBean.CONVERSATION)
MotcyProduct motcyProduct = new MotcyProduct();
public void deleteBean(WebControl invoker, String args)
{
}


	int id = 0;
	
	@Override
	protected void pageLoaded()
	{
		if (StringUtility.isNullOrEmpty(request.getParameter("id")))
		{
			motcyProduct = null;
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
