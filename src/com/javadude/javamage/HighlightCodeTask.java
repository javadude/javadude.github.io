package com.javadude.javamage;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.Token;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

public class HighlightCodeTask extends Task {
	private int tabSize = 4;
	private File file;
	private File out;
	public void setOut(File out) { this.out = out; }
	public void setTabSize(int tabSize) { this.tabSize = tabSize; }
	public void setFile(File file) { this.file = file; }

	private static final String divStartTemplate = 
		"<div class=''zsnazzy''>" + 
		"<b class=''xtop''><b class=''xb1''></b><b class=''xb2 {0}''></b><b class=''xb3 {0}''></b><b class=''xb4 {0}''></b></b>" + 
		"<div class=''xboxcontent''>" + 
		"<p class=''{1}''>";
	private static final String divStartNormalCaption = MessageFormat.format(divStartTemplate, "color_b", "header");
	private static final String divStartEvilCaption = MessageFormat.format(divStartTemplate, "color_evil", "header_evil");
	private static final String divStartEndCaption = "</p>";
	private static final String divEnd = 
		"</div><b class='xbottom'><b class='xb4'></b><b class='xb3'></b><b class='xb2'></b><b class='xbb'></b></b></div>";
	
	@Override public void execute() throws BuildException {
		if (file == null)
			throw new BuildException("Must specify file");
		if (!file.exists())
			throw new BuildException("File " + file + " does not exist");
		if (!file.isFile())
			throw new BuildException("File " + file + " is not a file");

		// fully read text to process
		final StringBuilder content = new StringBuilder();
		new AutoFileCloser() {
			@Override protected void doWork() throws Throwable {
				FileReader fr = watch(new FileReader(file));
				char[] buf = new char[8192];
				int n;
				while ((n = fr.read(buf)) != -1)
					content.append(buf, 0, n);
			}};

		List<String> figures = new ArrayList<String>();
		Map<String, Integer> figuresById = new HashMap<String, Integer>();
		
		final StringBuilder pass1 = new StringBuilder();
		int n = 0;
		int len = content.length();
		
		// assumes lowercase...
		Pattern pattern = Pattern.compile("<p\\s+class=['\"]figcap['\"]>(id:.*?\\|)?(evil\\|)?(.*?)</p>\\s*<pre>(.*?)</pre>", Pattern.DOTALL);
		Matcher matcher = pattern.matcher(content);
		
		while (n <= len) {
			// find start of next code figure
			if (!matcher.find(n)) {
				// no more matches - write the last chunk
				pass1.append(content.subSequence(n, len));
				break;
			}

			// write the chunk between the last match and this one
			pass1.append(content.subSequence(n, matcher.start()));
			n = matcher.end() + 1;

			String id = matcher.group(1);
			String evil = matcher.group(2);
			String caption = matcher.group(3);
			String code = matcher.group(4);
			highlight(figures, figuresById, pass1, id, evil, caption, code);
		}

		// resolve figure references
		
		// write output
		new AutoFileCloser() {
			@Override protected void doWork() throws Throwable {
				FileWriter fw = watch(new FileWriter(out));
				fw.write(pass1.toString());
			}
		};
	}
	
	public void highlight(List<String> figures, Map<String, Integer> figuresById, StringBuilder builder, String id, String evil, String caption, String code) {
		int figureNumber = figures.size() + 1;
		boolean isEvil = evil!=null&&evil.length()>0;
		
		if (isEvil)
			code = "``// THIS IS EVIL CODE -- DO NOT DO THIS!!!``\r\n" + code;
		if (id == null)
			id = caption;
		
		JavaHighlight highlight = new JavaHighlight(new ANTLRStringStream(code));
//		String lineNumbers = "";
// line number and file references TBD
//		if (start != -1) {
//			if (caption == null)
//				lineNumbers = " (lines " + start + "-" + end + ")";
//			else
//				lineNumbers = ", lines " + start + "-" + end;
//		}
		String plainCaption = caption;
// file references TBD
//		if (file != null) {
//			if (caption == null) {
//				caption = "<a href='" + file + "'>" + file + "</a>" + lineNumbers;
//				plainCaption = file + lineNumbers;
//			} else {
//				caption += " (<a href='" + file + "'>" + file + "</a>" + lineNumbers + ")";
//				plainCaption += " (" + file + lineNumbers + ")";
//			}
//		}
		if (caption != null) {
			caption = "Figure " + figureNumber + ": " + caption;
			plainCaption = "Figure " + figureNumber + ": " + plainCaption;
		} else {
			caption = "Figure " + figureNumber;
			plainCaption = "Figure " + figureNumber;
		}
		
		figures.add(plainCaption);
		if (figuresById.containsKey(id))
			throw new BuildException("Duplicate figure id '" + id + "'");
		figuresById.put(id, figureNumber);
		
		builder.append("<a name='figure.");
		builder.append(figureNumber);
		builder.append("'/>");
		builder.append(isEvil ? divStartEvilCaption : divStartNormalCaption).append(caption).append(divStartEndCaption);
		StringBuilder b = new StringBuilder();

// images TBD
//		if (image != null) {
//			builder.append("<div class='content'><img src='" + image + "'/></div>");
//			
//		} else {
		boolean inHighlight = false;
		
			loop: while(true) {
				Token t = highlight.nextToken();
				switch (t.getType()) {
					case JavaHighlight.EOF:
						break loop;
					case JavaHighlight.ToggleHighlight:
						if (inHighlight)
							b.append("</span>");
						else
							b.append("<span class='highlight'>");
						inHighlight = !inHighlight;
						break;
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
//		}
		
		builder.append(divEnd);
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
