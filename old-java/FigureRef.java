package com.javadude.javamage;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class FigureRef extends TagSupport {
	private static final long serialVersionUID = 1L;
	private boolean next;

	public FigureRef(boolean next) { this.next = next;}
	@Override
	public int doStartTag() throws JspException {
		Integer figureNumber = (Integer) pageContext.getAttribute("figure.number");
		int num = 1;
		if (figureNumber != null)
			num = figureNumber.intValue();
		if (!next)
			num--;
		try {
			pageContext.getOut().println("<a href='#figure." + num + "'>Figure " + num + "</a>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.doStartTag();
	}

}
