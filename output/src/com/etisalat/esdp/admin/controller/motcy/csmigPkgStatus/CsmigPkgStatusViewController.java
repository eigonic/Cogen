package com.etisalat.esdp.admin.controller.motcy.csmigPkgStatus;

import ae.etisalat.motcy.model.CsmigPkgStatus;

import eg.java.net.web.jspx.engine.annotation.JspxBean;
import eg.java.net.web.jspx.engine.util.StringUtility;
import eg.java.net.web.jspx.ui.controls.WebControl;
import eg.java.net.web.jspx.ui.pages.ContentPage;

public class CsmigPkgStatusViewController extends ContentPage
{
	@JspxBean(name="csmigPkgStatus" , dateformat="dd/MM/yyyy HH:mm:ss", scope = JspxBean.CONVERSATION)
CsmigPkgStatus csmigPkgStatus = new CsmigPkgStatus();
public void deleteBean(WebControl invoker, String args)
{
}


	int id = 0;
	
	@Override
	protected void pageLoaded()
	{
		if (StringUtility.isNullOrEmpty(request.getParameter("id")))
		{
			csmigPkgStatus = null;
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
