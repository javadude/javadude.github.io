package com.javadude.javamage;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class FigureTable extends TagSupport {
	private static final long serialVersionUID = 1L;

	@Override
	public int doStartTag() throws JspException {
		@SuppressWarnings("unchecked")
		List<String> figureCaptions = (List<String>) pageContext.getAttribute("figure.captions");
		if (figureCaptions != null) {
			try {
				pageContext.getOut().println("<h1><a name='figure.table'>Figures</a></h1></ul>");
				int n = 1;
				for (String caption : figureCaptions) {
					pageContext.getOut().println("<li><a href='#figure.");
					pageContext.getOut().println(n++);
					pageContext.getOut().println("'>");
					pageContext.getOut().println(caption);
					pageContext.getOut().println("</a></li>");
				}
				pageContext.getOut().println("</ul>");
			} catch (IOException e) {
				throw new JspException(e);
			}
		}
		return super.doStartTag();
	}

}
