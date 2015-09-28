package com.etisalat.esdp.admin.controller.motcy.motcyBucketItemBucket;

import ae.etisalat.motcy.model.MotcyBucketItemBucket;

import eg.java.net.web.jspx.engine.annotation.JspxBean;
import eg.java.net.web.jspx.engine.util.StringUtility;
import eg.java.net.web.jspx.ui.controls.WebControl;
import eg.java.net.web.jspx.ui.pages.ContentPage;

public class MotcyBucketItemBucketSearchController extends ContentPage
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
	
	@JspxBean(name="motcyBucketItemBucket" , dateformat="dd/MM/yyyy HH:mm:ss", scope = JspxBean.CONVERSATION)
MotcyBucketItemBucket motcyBucketItemBucket = new MotcyBucketItemBucket();

}
