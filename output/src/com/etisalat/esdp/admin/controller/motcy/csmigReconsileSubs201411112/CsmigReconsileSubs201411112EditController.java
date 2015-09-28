package com.etisalat.esdp.admin.controller.motcy.csmigReconsileSubs201411112;

import ae.etisalat.motcy.model.CsmigReconsileSubs201411112;

import eg.java.net.web.jspx.engine.annotation.JspxBean;
import eg.java.net.web.jspx.engine.util.StringUtility;
import eg.java.net.web.jspx.ui.controls.WebControl;
import eg.java.net.web.jspx.ui.pages.ContentPage;

public class CsmigReconsileSubs201411112EditController extends ContentPage
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
	
	@JspxBean(name="csmigReconsileSubs201411112" , dateformat="dd/MM/yyyy HH:mm:ss", scope = JspxBean.CONVERSATION)
CsmigReconsileSubs201411112 csmigReconsileSubs201411112 = new CsmigReconsileSubs201411112();
public void saveBean(WebControl invoker, String args)
{
}


}
