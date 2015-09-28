package com.etisalat.esdp.admin.controller.motcy.csmigReconsileSubscriber;

import ae.etisalat.motcy.model.CsmigReconsileSubscriber;

import eg.java.net.web.jspx.engine.annotation.JspxBean;
import eg.java.net.web.jspx.engine.util.StringUtility;
import eg.java.net.web.jspx.ui.controls.WebControl;
import eg.java.net.web.jspx.ui.pages.ContentPage;

public class CsmigReconsileSubscriberEditController extends ContentPage
{
	
	boolean isEdit;
	
	@Override
	protected void pagePreLoad()
	{
		isEdit = !StringUtility.isNullOrEmpty(request.getParameter("id"));
	}
	
	protected void pageLoaded()
	{
	}

	public boolean isEdit() {
		return isEdit;
	}
	
	@JspxBean(name="csmigReconsileSubscriber" , dateformat="dd/MM/yyyy HH:mm:ss", scope = JspxBean.CONVERSATION)
CsmigReconsileSubscriber csmigReconsileSubscriber = new CsmigReconsileSubscriber();
public void saveBean(WebControl invoker, String args)
{
}


}
