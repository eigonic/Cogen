package com.etisalat.esdp.admin.controller.motcy.csOfferBac1Apr;

import ae.etisalat.motcy.model.CsOfferBac1Apr;

import eg.java.net.web.jspx.engine.annotation.JspxBean;
import eg.java.net.web.jspx.engine.util.StringUtility;
import eg.java.net.web.jspx.ui.controls.WebControl;
import eg.java.net.web.jspx.ui.pages.ContentPage;

public class CsOfferBac1AprEditController extends ContentPage
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
	
	@JspxBean(name="csOfferBac1Apr" , dateformat="dd/MM/yyyy HH:mm:ss", scope = JspxBean.CONVERSATION)
CsOfferBac1Apr csOfferBac1Apr = new CsOfferBac1Apr();
public void saveBean(WebControl invoker, String args)
{
}


}
