package com.etisalat.esdp.admin.controller.motcy.motcyBucketItemRes;

import ae.etisalat.motcy.model.MotcyBucketItemRes;

import eg.java.net.web.jspx.engine.annotation.JspxBean;
import eg.java.net.web.jspx.engine.util.StringUtility;
import eg.java.net.web.jspx.ui.controls.WebControl;
import eg.java.net.web.jspx.ui.pages.ContentPage;

public class MotcyBucketItemResEditController extends ContentPage
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
	
	@JspxBean(name="motcyBucketItemRes" , dateformat="dd/MM/yyyy HH:mm:ss", scope = JspxBean.CONVERSATION)
MotcyBucketItemRes motcyBucketItemRes = new MotcyBucketItemRes();
public void saveBean(WebControl invoker, String args)
{
}


}
