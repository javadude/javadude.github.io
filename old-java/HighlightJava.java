package com.javadude.javamage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.Token;

public class HighlightJava extends BodyTagSupport {
	private static final long serialVersionUID = 1L;
	private String caption;
	private String file;
	private int start = -1;
	private int end = Integer.MAX_VALUE;
	private String section;
	private boolean error;
	private String image;
	private int tabSize = 4;
	public void setImage(String image) { this.image = image; }
	public void setTabSize(int tabSize) { this.tabSize = tabSize; }
	public void setError(boolean error) { this.error = error; }
	public void setSection(String section) { this.section = section; }
	public void setStart(int start) { this.start = start; }
	public void setEnd(int end) { this.end = end; }
	public void setFile(String file) { this.file = file; }
	public void setCaption(String caption) { this.caption = caption; }

	private static final String divStartCaption = 
		"<div class='zsnazzy'>\r\n" + 
		"<b class='xtop'><b class='xb1'></b><b class='xb2 color_b'></b><b class='xb3 color_b'></b><b class='xb4 color_b'></b></b>\r\n" + 
		"<div class='xboxcontent'>\r\n" + 
		"<p class='header'>";
	private static final String divStartCaptionError = 
		"<div class='zsnazzy'>\r\n" + 
		"<b class='xtop'><b class='xb1'></b><b class='xb2 color_error'></b><b class='xb3 color_error'></b><b class='xb4 color_error'></b></b>\r\n" + 
		"<div class='xboxcontent'>\r\n" + 
		"<p class='header_error'>";
	private static final String divStartNoCaption = 
		"<div class='zsnazzy'>\r\n" + 
		"<b class='xtop'><b class='xb1'></b><b class='xb2'></b><b class='xb3'></b><b class='xb4'></b></b>\r\n" + 
		"<div class='xboxcontent'>\r\n";
	private static final String divStartEndCaption = 
		"</p>";
	
	private static final String divEnd = 
		"</div>\r\n" + 
		"<b class='xbottom'><b class='xb4'></b><b class='xb3'></b><b class='xb2'></b><b class='xb1'></b></b>\r\n" + 
		"</div>\r\n";
	
	// read specified lines from file
	private String getLines() throws JspException {
		if (image != null)
			return "";
		
		if (start != -1) {
			if (end == Integer.MAX_VALUE) {
				throw new JspException("If start is specified, end must be specified as well");
			}
		} else if (end != Integer.MAX_VALUE) {
			throw new JspException("If end is specified, start must be specified as well");
		}
		if (start != -1 && section != null)
			throw new JspException("cannot specify both section and start/end");
		if ((start != -1 || section != null) && file == null)
			throw new JspException("If section or start/end are specified, file must be specified as well");
		if (file != null) {
			if (getBodyContent() != null) {
				if (getBodyContent().getString() != null) {
					if (!"".equals(getBodyContent().getString().trim())) {
						throw new JspException("Cannot have non-empty body content when file is specified for java highlight tag");
					}
				}
			}
			
			StringBuilder content = new StringBuilder();
			File f = new File(file);
			if (!f.exists()) {
				throw new JspException("File " + file + " not found for java highlight tag");
			}
			FileReader fr = null;
			BufferedReader br = null;
			try {
				fr = new FileReader(f);
				br = new BufferedReader(fr);
				String line = null;
				int n = 0;
				boolean seenStart = section == null;
				Pattern startPattern = Pattern.compile("###\\W*start\\W+" + section + "\\W*###");
				Pattern endPattern = Pattern.compile("###\\W*end\\W+" + section + "\\W*###");
				while ((line = br.readLine()) != null) {
					n++;
					if (n < start)
						continue;
					if (n > end)
						break;
					if (section != null) {
						if (!seenStart) {
							if (startPattern.matcher(line).matches()) {
								seenStart = true;
								start = n + 1;
							}
							continue;
						}
						if (endPattern.matcher(line).matches()) {
							end = n - 1;
							break;
						}
					}
					content.append(line);
					content.append('\n');
				}
				if (section != null) {
					if (start == -1)
						throw new JspException("Did not find ###start " + section + "### in file " + file);
					if (end == Integer.MAX_VALUE)
						throw new JspException("Did not find ###end " + section + "### in file " + file);
				}
				return content.toString();
			} catch (IOException e) {
				throw new JspException(e);
			} finally {
				if (br != null)
					try {
						br.close();
					} catch (IOException e) {
						throw new JspException(e);
					}
				if (fr != null)
					try {
						fr.close();
					} catch (IOException e) {
						throw new JspException(e);
					}
			}
		}
		return getBodyContent().getString();
	}
	@Override
	public int doEndTag() throws JspException {
		try {
			pageContext.getOut().println(highlight(getLines()));
		} catch (IOException e) {
			throw new JspException(e);
		} finally {
			start = -1;
			end = Integer.MAX_VALUE;
			caption = null;
			file = null;
		}
		return super.doEndTag();
	}

	public String highlight(String code) {
		Integer figureNumber = (Integer) pageContext.getAttribute("figure.number");
		if (figureNumber == null)
			figureNumber = new Integer(1);
		pageContext.setAttribute("figure.number", new Integer(figureNumber+1));

		JavaHighlight highlight = new JavaHighlight(new ANTLRStringStream(code));
		String lineNumbers = "";
		if (start != -1) {
			if (caption == null)
				lineNumbers = " (lines " + start + "-" + end + ")";
			else
				lineNumbers = ", lines " + start + "-" + end;
		}
		String plainCaption = caption;
		if (file != null) {
			if (caption == null) {
				caption = "<a href='" + file + "'>" + file + "</a>" + lineNumbers;
				plainCaption = file + lineNumbers;
			} else {
				caption += " (<a href='" + file + "'>" + file + "</a>" + lineNumbers + ")";
				plainCaption += " (" + file + lineNumbers + ")";
			}
		}
		if (caption != null) {
			caption = "Figure " + figureNumber + ": " + caption;
			plainCaption = "Figure " + figureNumber + ": " + plainCaption;
		} else {
			caption = "Figure " + figureNumber;
			plainCaption = "Figure " + figureNumber;
		}
		
		@SuppressWarnings("unchecked")
		List<String> figureCaptions = (List<String>) pageContext.getAttribute("figure.captions");
		if (figureCaptions == null) {
			figureCaptions = new ArrayList<String>();
			pageContext.setAttribute("figure.captions", figureCaptions);
		}
		figureCaptions.add(plainCaption);
		
		StringBuilder builder = new StringBuilder("<a name='figure.");
		builder.append(figureNumber);
		builder.append("'/>");
		if (caption != null)
			builder.append(error ? divStartCaptionError : divStartCaption).append(caption).append(divStartEndCaption);
		else
			builder.append(divStartNoCaption);
		StringBuilder b = new StringBuilder();
		
		if (image != null) {
			builder.append("<div class='content'><img src='" + image + "'/></div>");
			
		} else {
		
			loop: while(true) {
				Token t = highlight.nextToken();
				switch (t.getType()) {
					case JavaHighlight.EOF:
						break loop;
					case JavaHighlight.JavaIdentifier:
						b.append("<span class='ident'>").append(t.getText()).append("</span>");
						break;
					case JavaHighlight.SpecialIdentifier:
						b.append("<span class='specialIdent'>").append(t.getText()).append("</span>");
						break;
					case JavaHighlight.Operator:
						b.append("<span class='operator'>").append(t.getText()).append("</span>");
						break;
					case JavaHighlight.Keyword:
						b.append("<span class='keyword'>").append(t.getText()).append("</span>");
						break;
					case JavaHighlight.CalloutNum:
						if (t.getText().length() > 0)
							b.append("<span class='callout'>/* ").append(t.getText()).append(" */</span>");
						else
							b.append("      ");
						break;
					case JavaHighlight.MultiLineComment:
					case JavaHighlight.SingleLineComment:
						b.append("<span class='comment'>").append(t.getText()).append("</span>");
						break;
					case JavaHighlight.Other:
						b.append(t.getText());
						break;
					case JavaHighlight.StringLiteral:
						b.append("<span class='string'>").append(t.getText()).append("</span>");
						break;
					default:
						b.append("<span class='error'>Bad type: ").append(t.getType()).append(" text: ").append(t.getText()).append("</span>");
				}
			}
			builder.append("<pre class='content'>");
			builder.append(fixTabs(b.toString()));
			builder.append("</pre>");
		}
		
		builder.append(divEnd);
		return fixTabs(builder.toString());
	}
	// grrrr... I hate that I have to explicitly replace tabs with spaces to get anything other than 8-space tabs...
	private String fixTabs(String string) {
		// TODO move pad setup to setTab method
		// for each line in the string
		String[] pads = new String[tabSize+1];
		for (int i = 0; i <= tabSize; i++) {
			pads[i] = "";
			for (int j = 0; j < i; j++)
				pads[i] += ' ';
		}
		
		int len = string.length();
		int column = 1; // position in line
		StringBuilder b = new StringBuilder();
		boolean inTag = false;
		for (int n = 0; n < len; n++) {
			char c = string.charAt(n);
			if (inTag) {
				if (c == '>')
					inTag = false;
				b.append(c);
				continue;
			}
			switch (c) {
				case '<':
					inTag = true;
					b.append(c);
					break;
				case '\t':
					int pad = tabSize - (column % tabSize);
					b.append(pads[pad]);
					column += pad;
					break;
				case '\n':
				case '\r':
					column = 0;
					b.append(c);
					break;
				default:
					column++;
					b.append(c);
					break;
			}
		}
		return b.toString();
	}
}
