package com.etisalat.esdp.admin.controller.motcy.csmigReconsileSubscriber;

import ae.etisalat.motcy.model.CsmigReconsileSubscriber;

import eg.java.net.web.jspx.engine.annotation.JspxBean;
import eg.java.net.web.jspx.engine.util.StringUtility;
import eg.java.net.web.jspx.ui.controls.WebControl;
import eg.java.net.web.jspx.ui.pages.ContentPage;

public class CsmigReconsileSubscriberViewController extends ContentPage
{
	@JspxBean(name="csmigReconsileSubscriber" , dateformat="dd/MM/yyyy HH:mm:ss", scope = JspxBean.CONVERSATION)
CsmigReconsileSubscriber csmigReconsileSubscriber = new CsmigReconsileSubscriber();
public void deleteBean(WebControl invoker, String args)
{
}


	int id = 0;
	
	@Override
	protected void pageLoaded()
	{
		if (StringUtility.isNullOrEmpty(request.getParameter("id")))
		{
			csmigReconsileSubscriber = null;
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
