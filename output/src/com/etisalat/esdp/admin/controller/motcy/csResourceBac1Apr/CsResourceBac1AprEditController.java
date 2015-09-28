package com.etisalat.esdp.admin.controller.motcy.csResourceBac1Apr;

import ae.etisalat.motcy.model.CsResourceBac1Apr;

import eg.java.net.web.jspx.engine.annotation.JspxBean;
import eg.java.net.web.jspx.engine.util.StringUtility;
import eg.java.net.web.jspx.ui.controls.WebControl;
import eg.java.net.web.jspx.ui.pages.ContentPage;

public class CsResourceBac1AprEditController extends ContentPage
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
	
	@JspxBean(name="csResourceBac1Apr" , dateformat="dd/MM/yyyy HH:mm:ss", scope = JspxBean.CONVERSATION)
CsResourceBac1Apr csResourceBac1Apr = new CsResourceBac1Apr();
public void saveBean(WebControl invoker, String args)
{
}


}
