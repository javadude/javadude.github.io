package com.javadude.javamage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("<p\\s+class=['\"]figcap['\"]>(.*)</p>\\s*<pre>(.*)</pre>", Pattern.DOTALL);
		Matcher matcher = pattern.matcher(content);
		System.out.println(matcher.find());
	}

	
	private static final String content = "<html>\r\n" + 
			"\r\n" + 
			"<head>\r\n" + 
			"<title>File Closing in Java Really Should be Simpler...</title>\r\n" + 
			"		<link href=\"style/style1.css\" media=\"screen\" rel=\"stylesheet\" title=\"CSS\" type=\"text/css\" />\r\n" + 
			"</head>\r\n" + 
			"\r\n" + 
			"<body style='padding:10px'>\r\n" + 
			"<h1>File Closing in Java Really Should be Simpler ...</h1>\r\n" + 
			"\r\n" + 
			"<h2>How to properly close files in Java</h2>\r\n" + 
			"\r\n" + 
			"<p>It amazes me that one of the hardest things to do properly\r\n" + 
			"in Java is close a file or a database connection. Seriously, it's much harder\r\n" + 
			"than you might think.</p>\r\n" + 
			"\r\n" + 
			"<p>You write a little app that does some I/O with code like the\r\n" + 
			"following:</p>\r\n" + 
			"<p class=\"figcap\">evil:Bad I/O example</p>\r\n" + 
			"\r\n" + 
			"<pre>try {\r\n" + 
			"    FileReader r = new FileReader(\"somefile.txt\");\r\n" + 
			"    // read from r\r\n" + 
			"    r.close();\r\n" + 
			"} catch (IOException e) {\r\n" + 
			"    // report and/or log error\r\n" + 
			"}</pre>\r\n" + 
			"\r\n" + 
			"<p>Sure, it looks reasonable at first\r\n" + 
			"glance, but then so did COBOL.</p>\r\n" + 
			"\r\n" + 
			"<p>The first, and possibly most obvious\r\n" + 
			"problem is the position of the r.close() call. If <i>anything</i>\r\n" + 
			"goes wrong (throwing an exception) between the open and close of the file, the\r\n" + 
			"close will be skipped! This has the potential of leaving file handles allocated\r\n" + 
			"in the OS; a resource \"leak\" in the application.</p>\r\n" + 
			"\r\n" + 
			"<p>The first, and most important change,\r\n" + 
			"is to move the r.close() into a finally block. Java's finally block is <i>always</i> executed:</p>\r\n" + 
			"\r\n" + 
			"<ul>\r\n" + 
			" <li>If the\r\n" + 
			"     try completes successfully, finally is run after it.</li>\r\n" + 
			" <li>If an\r\n" + 
			"     exception is thrown in the try and caught by a catch block, the finally\r\n" + 
			"     runs after the catch block.</li>\r\n" + 
			" <li>If an\r\n" + 
			"     exception is thrown in the try and <i>not</i>\r\n" + 
			"     caught by a catch block, the finally runs immediately before passing the\r\n" + 
			"     exception on to the containing block or calling method.</li>\r\n" + 
			"</ul>\r\n" + 
			"\r\n" + 
			"<p>This leads to the following code:</p>\r\n" + 
			"\r\n" + 
			"<pre>FileReader r = null;\r\n" + 
			"try {\r\n" + 
			"    r = new FileReader(\"somefile.txt\");\r\n" + 
			"    // read from r\r\n" + 
			"} catch (IOException e) {\r\n" + 
			"    // report and/or log error\r\n" + 
			"} finally {\r\n" + 
			"    if (r != null)\r\n" + 
			"        try {\r\n" + 
			"            r.close();\r\n" + 
			"        } catch (IOException e) {\r\n" + 
			"            // report and/or log error\r\n" + 
			"        }\r\n" + 
			"}</pre>\r\n" + 
			"\r\n" + 
			"<p>Isn't that pretty? We've now set it\r\n" + 
			"up so that no matter what happens in the outer try block, we'll attempt to\r\n" + 
			"close the file (if it was opened successfully   that's what the null check is\r\n" + 
			"for).</p>\r\n" + 
			"\r\n" + 
			"<p>But unfortunately, this still isn't\r\n" + 
			"quite right.</p>\r\n" + 
			"\r\n" + 
			"<p>Java only keeps track of a single\r\n" + 
			"exception being thrown. What happens if an exception is thrown during the file\r\n" + 
			"read <i>and</i> during the file close?\r\n" + 
			"Simply put, <i>the last exception wins</i>.</p>\r\n" + 
			"\r\n" + 
			"<p>This is not a good situation; we're\r\n" + 
			"probably more interested in the exception that was thrown in the try block than\r\n" + 
			"we are of the one thrown during the close. So let's modify things a bit more </p>\r\n" + 
			"\r\n" + 
			"<pre>`  FileReader r = null;\r\n" + 
			"`1 Throwable pending = null;\r\n" + 
			"`  try {\r\n" + 
			"`      r = new FileReader(\"somefile.txt\");\r\n" + 
			"`      // read from r\r\n" + 
			"`3 } catch (ThreadDeath t) {\r\n" + 
			"`3     throw t;\r\n" + 
			"`2 } catch (Throwable t) {\r\n" + 
			"`2     pending = t;\r\n" + 
			"`  } finally {\r\n" + 
			"`      if (r != null)\r\n" + 
			"`          try {\r\n" + 
			"`              r.close();\r\n" + 
			"`          } catch (IOException e) {\r\n" + 
			"`              // report and/or log error\r\n" + 
			"`4             if (pending == null)\r\n" + 
			"`4                 pending = e;\r\n" + 
			"`          }\r\n" + 
			"`5     if (pending != null)\r\n" + 
			"`5         if (pending instanceof SomeWrapperException)\r\n" + 
			"`5             throw (SomeWrapperException) pending;\r\n" + 
			"`5         else \r\n" + 
			"`5             throw new SomeWrapperException(pending);\r\n" + 
			"`  }</pre>\r\n" + 
			"\r\n" + 
			"<p>Wow. That's some fun code to noodle\r\n" + 
			"through. What's happening? (The numbers below map to the numbers in the\r\n" + 
			"comments in the above code)</p>\r\n" + 
			"\r\n" + 
			"<ol>\r\n" + 
			" <li>We\r\n" + 
			"     need to keep track of the exception we care about. I call that the \"pending\"\r\n" + 
			"     exception.</li>\r\n" + 
			" <li>Because\r\n" + 
			"     that pending exception could be any exception, we need to catch Throwable</li>\r\n" + 
			" <li>Catching\r\n" + 
			"     Throwable is normally a bad idea; it includes ThreadDeath, which needs to be re-thrown. We set up a\r\n" + 
			"     catch block just for it.</li>\r\n" + 
			" <li>If we\r\n" + 
			"     get an exception during the close call, we check to see if we already are\r\n" + 
			"     tracking a pending exception. If not (and <i>only</i> if not), we can track the close. If we're already\r\n" + 
			"     tracking an exception, we should log the close error so we still know it\r\n" + 
			"     happened.</li>\r\n" + 
			" <li>Last\r\n" + 
			"     but not least, if we have a pending exception, we need to throw it. To do\r\n" + 
			"     this, we need to wrap it. We can create a custom exception for this\r\n" + 
			"     (checked or unchecked; depends on your preference), or if you prefer,\r\n" + 
			"     simply wrap it in RuntimeException. Of course if\r\n" + 
			"     the pending exception is already the wrapper type, we can just re-throw\r\n" + 
			"     it.</li>\r\n" + 
			"</ol>\r\n" + 
			"\r\n" + 
			"<p>Isn't that fun? Before we look into\r\n" + 
			"how to simplify it, let's make it a little worse </p>\r\n" + 
			"\r\n" + 
			"<p>Suppose you have nested streams. For\r\n" + 
			"example, you want to wrap an output in a buffer for better performance.</p>\r\n" + 
			"\r\n" + 
			"<pre>`  FileReader r = null;\r\n" + 
			"`1 BufferedReader br = null;\r\n" + 
			"`  Throwable pending = null;\r\n" + 
			"`  try {\r\n" + 
			"`      r = new FileReader(\"somefile.txt\");\r\n" + 
			"`1     br = new BufferedReader(r);\r\n" + 
			"`      // read from br\r\n" + 
			"`  } catch (ThreadDeath t) {\r\n" + 
			"`      throw t;\r\n" + 
			"`  } catch (Throwable t) {\r\n" + 
			"`      pending = t;\r\n" + 
			"`  } finally {\r\n" + 
			"`2     if (br != null)\r\n" + 
			"`          try {\r\n" + 
			"`              br.close();\r\n" + 
			"`3             r = null;\r\n" + 
			"`          } catch (IOException e) {\r\n" + 
			"`              // report and/or log error\r\n" + 
			"`              if (pending == null)\r\n" + 
			"`                  pending = e;\r\n" + 
			"`          }\r\n" + 
			"`4     if (r != null)\r\n" + 
			"`          try {\r\n" + 
			"`              r.close();\r\n" + 
			"`          } catch (IOException e) {\r\n" + 
			"`              // report and/or log error\r\n" + 
			"`              if (pending == null)\r\n" + 
			"`                  pending = e;\r\n" + 
			"`          }\r\n" + 
			"`      if (pending != null)\r\n" + 
			"`          if (pending instanceof SomeWrapperException)\r\n" + 
			"`              throw (SomeWrapperException) pending;\r\n" + 
			"`          else\r\n" + 
			"`              throw new SomeWrapperException(pending);\r\n" + 
			"`  }</pre>\r\n" + 
			"\r\n" + 
			"<p>Crikey! That's\r\n" + 
			"a lot of code just to do a simple read from a file. Let's look at a few details\r\n" + 
			"in there:</p>\r\n" + 
			"\r\n" + 
			"<ol>\r\n" + 
			" <li>We\r\n" + 
			"     declare and open the stream wrapper as we normally would (aside from\r\n" + 
			"     declaring it outside the try so we have access to it in the finally )</li>\r\n" + 
			" <li>We\r\n" + 
			"     start the close by trying to close the outermost wrapper first.</li>\r\n" + 
			" <li>If the\r\n" + 
			"     outermost close succeeds, we need to null out the nested streams so we\r\n" + 
			"     don't try to close them again.</li>\r\n" + 
			" <li>If we\r\n" + 
			"     see a nested stream is still open, we try to close it. <i>This is incredibly important!</i> If\r\n" + 
			"     for some reason a wrapper fails to close, we want to try as hard as we can\r\n" + 
			"     to close the actual underlying resource (file, socket, etc).</li>\r\n" + 
			"</ol>\r\n" + 
			"\r\n" + 
			"<p>We now have proper file closing!</p>\r\n" + 
			"\r\n" + 
			"<p>But let's get real. How many folks\r\n" + 
			"are going to go this far, and even if they do, how many will get it right <i>every</i> time they write it?</p>\r\n" + 
			"\r\n" + 
			"<p>Let's find a way to factor out the\r\n" + 
			"boilerplate that's necessary so we can concentrate on writing the code that our\r\n" + 
			"design cares about   the actual IO.</p>\r\n" + 
			"\r\n" + 
			"<p>First, we need to figure out what\r\n" + 
			"parts of this structure stay the same, and what parts differ. If we look at the\r\n" + 
			"above code, we can fix it up a bit (going a little pseudo-cody\r\n" + 
			"here, but stick with me for the payoff )</p>\r\n" + 
			"\r\n" + 
			"<pre>// VARIANT: DECLARE THE STREAMS AND WRAPPERS\r\n" + 
			"Throwable pending = null;\r\n" + 
			"try {\r\n" + 
			"    // VARIANT: OPEN AND DO STUFF WITH THE STREAMS\r\n" + 
			"} catch (ThreadDeath t) {\r\n" + 
			"    throw t;\r\n" + 
			"} catch (Throwable t) {\r\n" + 
			"    pending = t;\r\n" + 
			"} finally {\r\n" + 
			"    // VARIANT: FOR EACH STREAM (OR WRAPPER)\r\n" + 
			"    if (STREAM != null)\r\n" + 
			"        try {\r\n" + 
			"            STREAM.close();\r\n" + 
			"            // VARIANT: FOR EACH NESTEDSTREAM IN WRAPPER\r\n" + 
			"            STREAM = null;\r\n" + 
			"            // END VARIANT: FOR EACH NESTEDSTREAM\r\n" + 
			"        } catch (IOException e) {\r\n" + 
			"            // report and/or log error\r\n" + 
			"            if (pending == null)\r\n" + 
			"                pending = e;\r\n" + 
			"        }\r\n" + 
			"    // END VARIANT: FOR EACH STEAM WRAPPER\r\n" + 
			"    if (pending != null)\r\n" + 
			"        if (pending instanceof SomeWrapperException)\r\n" + 
			"            throw (SomeWrapperException) pending;\r\n" + 
			"        else\r\n" + 
			"            throw new SomeWrapperException(pending);\r\n" + 
			"}</pre>\r\n" + 
			"\r\n" + 
			"<p>Hmm  looks like a good bit of that\r\n" + 
			"code stays pretty stable. What if we went a little farther and instead of\r\n" + 
			"having explicit variables for each stream, use a List of streams? The common\r\n" + 
			"thing we care about for all of these is that they have a close()\r\n" + 
			"call. That happens to be defined in the Closeable interface, so we can get rid\r\n" + 
			"of some of the variants as follows:</p>\r\n" + 
			"\r\n" + 
			"<pre>List&lt;Closeable&gt; streams = new ArrayList&lt;Closeable&gt;();\r\n" + 
			"Throwable pending = null;\r\n" + 
			"try {\r\n" + 
			"    // VARIANT: OPEN AND DO STUFF WITH THE STREAMS   STORE EACH STREAM IN streams LIST\r\n" + 
			"} catch (ThreadDeath t) {\r\n" + 
			"    throw t;\r\n" + 
			"} catch (Throwable t) {\r\n" + 
			"    pending = t;\r\n" + 
			"} finally {\r\n" + 
			"    for (Closeable c : streams) {\r\n" + 
			"        try {\r\n" + 
			"            c.close();\r\n" + 
			"            break;\r\n" + 
			"        } catch (IOException e) {\r\n" + 
			"            // report and/or log error\r\n" + 
			"            if (pending == null)\r\n" + 
			"                pending = e;\r\n" + 
			"        }\r\n" + 
			"    }\r\n" + 
			"    if (pending != null)\r\n" + 
			"        if (pending instanceof SomeWrapperException)\r\n" + 
			"            throw (SomeWrapperException) pending;\r\n" + 
			"        else\r\n" + 
			"            throw new SomeWrapperException(pending);\r\n" + 
			"}</pre>\r\n" + 
			"\r\n" + 
			"<p>When closing, as soon as we\r\n" + 
			"successfully close a stream, we simply skip the rest of the nested streams.</p>\r\n" + 
			"\r\n" + 
			"<p>Wow! We're now down to a single spot\r\n" + 
			"that varies! Everything else is <i>exactly</i>\r\n" + 
			"the same for all uses (assuming you use the same exception type for all uses  \r\n" + 
			"if not, we'll see how we can fix that later).</p>\r\n" + 
			"\r\n" + 
			"<p>What we have above is really a\r\n" + 
			"template for what we'd like to do when we're dealing with files. Hmmm  I think there's a design pattern out there that might\r\n" + 
			"fit; in fact, it's named \"Template Method\". (I know this because I teach Design\r\n" + 
			"Patterns at Johns Hopkins. Call it cheating if you like, but you have just as\r\n" + 
			"much opportunity to know about patterns as I do, so you can stop your whining\r\n" + 
			"right now.)</p>\r\n" + 
			"\r\n" + 
			"<p>The template method pattern is useful\r\n" + 
			"when you have <i>an algorithm with\r\n" + 
			"replaceable steps</i>. You have some common stuff that you want to always stay\r\n" + 
			"the same (and usually want to enforce that it stays the same), but some\r\n" + 
			"portions of the algorithm might need to be changed.</p>\r\n" + 
			"\r\n" + 
			"<p>There are two main ways to implement\r\n" + 
			"Template Method; the \"standard\" implementation defines \"hook\" methods for each\r\n" + 
			"variant area, and the Template Method calls these hooks. Subclasses can\r\n" + 
			"override the hooks to change the behavior of the algorithm. An alternate\r\n" + 
			"approach involves passing in an object that contains the hook methods (or\r\n" + 
			"function pointers in a language that supports them).</p>\r\n" + 
			"\r\n" + 
			"<p>Let's approach this from a subclassing point of view. Suppose we define the following:</p>\r\n" + 
			"<pre>public abstract class AutoFileCloser {\r\n" + 
			"    protected abstract void doWork() throws Throwable;\r\n" + 
			"    private List&lt;Closeable&gt; streams = new ArrayList&lt;Closeable&gt;();\r\n" + 
			"    protected final void watch(Closeable closeable) {\r\n" + 
			"        streams.add(closeable);\r\n" + 
			"    }\r\n" + 
			"    public final void go() throws SomeWrapperException {\r\n" + 
			"        Throwable pending = null;\r\n" + 
			"        try {\r\n" + 
			"            doWork();\r\n" + 
			"        } catch (ThreadDeath t) {\r\n" + 
			"            throw t;\r\n" + 
			"        } catch (Throwable t) {\r\n" + 
			"            pending = t;\r\n" + 
			"        } finally {\r\n" + 
			"            for (Closeable c : streams) {\r\n" + 
			"                try {\r\n" + 
			"                    c.close();\r\n" + 
			"                    break;\r\n" + 
			"                } catch (IOException e) {\r\n" + 
			"                    // report and/or log error\r\n" + 
			"                    if (pending == null)\r\n" + 
			"                        pending = e;\r\n" + 
			"                }\r\n" + 
			"            }\r\n" + 
			"            if (pending != null)\r\n" + 
			"                if (pending instanceof SomeWrapperException)\r\n" + 
			"                    throw (SomeWrapperException) pending;\r\n" + 
			"                else\r\n" + 
			"                    throw new SomeWrapperException(pending);\r\n" + 
			"        }\r\n" + 
			"    }\r\n" + 
			"}</pre>\r\n" + 
			"\r\n" + 
			"<p>Note that go()\r\n" + 
			"and watch() are final; these are constant parts of the template method that we\r\n" + 
			"do not want subclasses to be able to change.</p>\r\n" + 
			"\r\n" + 
			"<p>With this definition in place, we can\r\n" + 
			"do the following:</p>\r\n" + 
			"\r\n" + 
			"<pre>private static class MyWork extends AutoFileCloser {\r\n" + 
			"    @Override protected void doWork() throws Throwable {\r\n" + 
			"        FileReader r = new FileReader(\"someFile.txt\");\r\n" + 
			"        BufferedReader br = new BufferedReader(r);\r\n" + 
			"        watch(br);\r\n" + 
			"        watch(r);\r\n" + 
			"        // do stuff with br\r\n" + 
			"    }\r\n" + 
			"}\r\n" + 
			"new MyWork().go();</pre>\r\n" + 
			"\r\n" + 
			"<p>Now that's much better, but we still\r\n" + 
			"can make some improvements. If we make watch a generic method, we can collapse\r\n" + 
			"the \"new\"s and the watch calls:</p>\r\n" + 
			"\r\n" + 
			"<pre>protected final &lt;T extends Closeable&gt; T\r\n" + 
			"watch(T closeable) {\r\n" + 
			"    streams.add(closeable);\r\n" + 
			"    return closeable;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			"// and then in the doWork\r\n" + 
			"\r\n" + 
			"FileReader r = watch(new FileReader(\"someFile.txt\"));\r\n" + 
			"BufferedReader br = watch(new BufferedReader(r));</pre>\r\n" + 
			"\r\n" + 
			"<p>But this has reversed the order of\r\n" + 
			"the adds to the stream list! Egads!\r\n" + 
			"This is simple enough to fix by either adding to the beginning of the streams\r\n" + 
			"list, or walking it in reverse during the finally (we'll see this in the final\r\n" + 
			"implementation at the end of this article).</p>\r\n" + 
			"\r\n" + 
			"<p>When calling the AutoFileCloser,\r\n" + 
			"I like to use an anonymous inner class as follows:</p>\r\n" + 
			"\r\n" + 
			"<pre>new AutoFileCloser() {\r\n" + 
			"    @Override protected void doWork() throws Throwable {\r\n" + 
			"        FileReader r = watch(new FileReader(\"someFile.txt\"));\r\n" + 
			"        BufferedReader br = watch(new BufferedReader(r));\r\n" + 
			"        // do stuff with br\r\n" + 
			"    }\r\n" + 
			"}.go();</pre>\r\n" + 
			"\r\n" + 
			"<p>But I'm not really keen on the\r\n" + 
			"dangling go() call, so I simply move the go() contents\r\n" + 
			"to the AutoFileCloser constructor. The usage then\r\n" + 
			"looks like:</p>\r\n" + 
			"\r\n" + 
			"<pre>new AutoFileCloser() {\r\n" + 
			"    @Override protected void doWork() throws Throwable {\r\n" + 
			"        FileReader r = watch(new FileReader(\"someFile.txt\"));\r\n" + 
			"        BufferedReader br = watch(new BufferedReader(r));\r\n" + 
			"        // do stuff with br\r\n" + 
			"    }\r\n" + 
			"};</pre>\r\n" + 
			"\r\n" + 
			"<p>And tada!\r\n" + 
			"We now have something that's correct and about as complex as what we started\r\n" + 
			"out with at the beginning of this article!</p>\r\n" + 
			"\r\n" + 
			"<p>Now this is all well and good until\r\n" + 
			"you realize that we may need to have more than one set of nested streams! For\r\n" + 
			"example, how can we read from one stream and write to another? If we do the\r\n" + 
			"following</p>\r\n" + 
			"\r\n" + 
			"<pre>new AutoFileCloser() {\r\n" + 
			"    @Override\r\n" + 
			"      protected void doWork() throws Throwable {\r\n" + 
			"        FileReader r = watch(new FileReader(\"someFile.txt\"));\r\n" + 
			"        BufferedReader br = watch(new BufferedReader(r));\r\n" + 
			"        FileWriter w = watch(new FileWriter(\"someOtherFile.txt\"));\r\n" + 
			"        BufferedWriter bw = watch(new BufferedWriter(w));\r\n" + 
			"        // read from br and write to bw\r\n" + 
			"    }\r\n" + 
			"};</pre>\r\n" + 
			"\r\n" + 
			"<p>the closing\r\n" + 
			"logic won't work correctly. As soon as one of the streams closes successfully, we\r\n" + 
			"won't try to close the other (the break will stop the close processing loop!)</p>\r\n" + 
			"\r\n" + 
			"<p>The answer here is to think about\r\n" + 
			"what happens if you try to close something that is already closed. Looking at\r\n" + 
			"the documentation for close() in the Closeable\r\n" + 
			"interface:</p>\r\n" + 
			"\r\n" + 
			"<p>If the stream is already closed then invoking this method has no effect.</p>\r\n" + 
			"\r\n" + 
			"<p>Aha! We don't need to actually stop!\r\n" + 
			"We can simply remove the break and just let it try to close everything! (It\r\n" + 
			"turns out we didn't need to have the nestedStream=null\r\n" + 
			"calls in the original close logic either).</p>\r\n" + 
			"\r\n" + 
			"<p>Now we have an easy-to-use solution\r\n" + 
			"that lets us focus on the actual I/O code we care, while properly performing\r\n" + 
			"exception handling and not having to see or write that exception handling\r\n" + 
			"billions of times.</p>\r\n" + 
			"\r\n" + 
			"<p>Now about that SomeWrapperException </p>\r\n" + 
			"\r\n" + 
			"<p>We can approach this in several ways:</p>\r\n" + 
			"\r\n" + 
			"<ul>\r\n" + 
			" <li>Use an unchecked exception</li>\r\n" + 
			"\r\n" + 
			"<li>Use\r\n" + 
			"RuntimeException   many folks don't like this idea\r\n" + 
			"because it's normally used to represent what I call \"programmer stupidity\r\n" + 
			"errors\". (Whoops! I forgot to check for null!)</li>\r\n" + 
			"\r\n" + 
			"<li>Use\r\n" + 
			"a custom unchecked exception (extend RuntimeException)\r\n" + 
			"  this allows you to catch a specific exception for your project(s) but not\r\n" + 
			"need to have throws clauses throughout your call chains.</li>\r\n" + 
			"\r\n" + 
			" <li>Use a\r\n" + 
			"     custom checked exception wrapper   this allows you to catch a custom\r\n" + 
			"     exception, but you'll need to either have a try/catch block handle it or a\r\n" + 
			"     throws clause in every method in your call chain</li>\r\n" + 
			"</ul>\r\n" + 
			"\r\n" + 
			"<p>In addition, you may decide that you\r\n" + 
			"want to capture <i>all</i> exceptions, not\r\n" + 
			"just the last pending exception. I find this very useful, and you can implement\r\n" + 
			"this using</p>\r\n" + 
			"\r\n" + 
			"<pre>public class MultiException extends RuntimeException {\r\n" + 
			"    private static final long serialVersionUID = 1L;\r\n" + 
			"    private List&lt;Throwable&gt; causes;\r\n" + 
			"    public MultiException(List&lt;Throwable&gt; causes) {\r\n" + 
			"        super(causes.get(0));\r\n" + 
			"        this.causes = causes;\r\n" + 
			"    }\r\n" + 
			"    public MultiException(String message, List&lt;Throwable&gt; causes) {\r\n" + 
			"        super(message, causes.get(0));\r\n" + 
			"        this.causes = causes;\r\n" + 
			"    }\r\n" + 
			"    public List&lt;Throwable&gt; getCauses() {\r\n" + 
			"        return Collections.unmodifiableList(causes);\r\n" + 
			"    }\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			"public abstract class AutoFileCloser {\r\n" + 
			"    protected abstract void doWork() throws Throwable;\r\n" + 
			"    private List&lt;Closeable&gt; streams = new ArrayList&lt;Closeable&gt;();\r\n" + 
			"    public AutoFileCloser() {\r\n" + 
			"        List&lt;Throwable&gt; causes = null;\r\n" + 
			"        try {\r\n" + 
			"            doWork();\r\n" + 
			"        } catch (ThreadDeath t) {\r\n" + 
			"            throw t;\r\n" + 
			"        } catch (Throwable t) {\r\n" + 
			"            causes = new ArrayList&lt;Throwable&gt;(1);\r\n" + 
			"            causes.add(t);\r\n" + 
			"        } finally {\r\n" + 
			"            for (Closeable closeable : streams) {\r\n" + 
			"                try {\r\n" + 
			"                    closeable.close();\r\n" + 
			"                } catch (ThreadDeath t) {\r\n" + 
			"                    throw t;\r\n" + 
			"                } catch (Throwable t) {\r\n" + 
			"                    if (causes == null)\r\n" + 
			"                        causes = new ArrayList&lt;Throwable&gt;(1);\r\n" + 
			"                    causes.add(t);\r\n" + 
			"                }\r\n" + 
			"            }\r\n" + 
			"            if (causes != null) {\r\n" + 
			"                if (causes.size() == 1 &amp;&amp; causes.get(0) instanceof MultiException)\r\n" + 
			"                    throw (MultiException) causes.get(0);\r\n" + 
			"                throw new MultiException(causes);\r\n" + 
			"            }\r\n" + 
			"        }\r\n" + 
			"    }\r\n" + 
			"    protected final &lt;T extends Closeable&gt; T watch(T closeable) {\r\n" + 
			"      streams.add(closeable);\r\n" + 
			"      return closeable;\r\n" + 
			"    }\r\n" + 
			"}</pre>\r\n" + 
			"\r\n" + 
			"<p>But what if you want to use different\r\n" + 
			"exceptions in different instances of AutoFileCloser?\r\n" + 
			"Pattern time again!</p>\r\n" + 
			"\r\n" + 
			"<p>We'll need to add some more hooks.\r\n" + 
			"There are four places we need to deal with the exception. I'll use the non-MultiException approach here; doing this for different types\r\n" + 
			"of MultiExceptions would be similar.</p>\r\n" + 
			"\r\n" + 
			"<pre>public abstract class AutoFileCloser {\r\n" + 
			"    protected abstract void doWork() throws Throwable;\r\n" + 
			"    private List&lt;Closeable&gt; streams = new ArrayList&lt;Closeable&gt;();\r\n" + 
			"    protected final &lt;T extends Closeable&gt; T watch(T closeable) {\r\n" + 
			"        streams.add(closeable);\r\n" + 
			"        return closeable;\r\n" + 
			"    }\r\n" + 
			"    public AutoFileCloser() <u>throws</u><u> SomeWrapperException</u> {\r\n" + 
			"        Throwable pending = null;\r\n" + 
			"        try {\r\n" + 
			"            doWork();\r\n" + 
			"        } catch (ThreadDeath t) {\r\n" + 
			"            throw t;\r\n" + 
			"        } catch (Throwable t) {\r\n" + 
			"            pending = t;\r\n" + 
			"        } finally {\r\n" + 
			"            for (Closeable c : streams) {\r\n" + 
			"                try {\r\n" + 
			"                    c.close();\r\n" + 
			"                } catch (IOException e) {\r\n" + 
			"                    // report and/or log error\r\n" + 
			"                    if (pending == null)\r\n" + 
			"                        pending = e;\r\n" + 
			"                }\r\n" + 
			"            }\r\n" + 
			"            if (pending != null)\r\n" + 
			"                if (pending <u>instanceof</u><u> SomeWrapperException</u>)\r\n" + 
			"                    throw <u>(SomeWrapperException)</u> pending;\r\n" + 
			"                else\r\n" + 
			"                    throw <u>new</u><u> SomeWrapperException</u>(pending);\r\n" + 
			"        }\r\n" + 
			"    }\r\n" + 
			"}</pre>\r\n" + 
			"\r\n" + 
			"<p>To deal with that throws clause, we'd\r\n" + 
			"definitely going to need generics. So we start by making the class generic:</p>\r\n" + 
			"\r\n" + 
			"<pre>public abstract class AutoFileCloser&lt;WrapperExceptionType extends Throwable&gt; {\r\n" + 
			"    protected abstract void doWork() throws WrapperExceptionType;\r\n" + 
			"    ...\r\n" + 
			"}</pre>\r\n" + 
			"\r\n" + 
			"<p>That takes care of the throws clause.\r\n" + 
			"Now we need to deal with the pending exception wrapping. It would be nice if we\r\n" + 
			"could just say</p>\r\n" + 
			"\r\n" + 
			"<pre>if (pending != null)\r\n" + 
			"    if (pending instanceof WrapperExceptionType)\r\n" + 
			"        throw (WrapperExceptionType) pending;\r\n" + 
			"    else\r\n" + 
			"        throw <u>new</u><u> SomeWrapperException</u>(pending);</pre>\r\n" + 
			"\r\n" + 
			"<p>But this will not work in Java. The\r\n" + 
			"problem is that Java erases the real passed-in type value of WrapperExceptionType at runtime. All Java knows is that\r\n" + 
			"it's a Throwable.</p>\r\n" + 
			"\r\n" + 
			"<p>What we need is an object that we can\r\n" + 
			"use to tell us the type of the exception. We can do this by passing a Class\r\n" + 
			"object into the AutoFileCloser constructor:</p>\r\n" + 
			"\r\n" + 
			"<pre>public AutoFileCloser(Class&lt;WrapperExceptionType&gt; wrapperExceptionType)\r\n" + 
			"           throws WrapperExceptionType {\r\n" + 
			"    ...\r\n" + 
			"}</pre>\r\n" + 
			"\r\n" + 
			"<p>And now we can fixup\r\n" + 
			"that pending block a bit more</p>\r\n" + 
			"\r\n" + 
			"<pre>if (pending != null)\r\n" + 
			"    if (wrapperExceptionType.isAssignableFrom(pending.getClass()))\r\n" + 
			"        throw wrapperExceptionType.cast(pending);\r\n" + 
			"    else\r\n" + 
			"    throw <u>new</u><u> SomeWrapperException</u>(pending);</pre>\r\n" + 
			"\r\n" + 
			"<p>Now we're down to one more location\r\n" + 
			"to fix. We can add another hook method that's responsible for wrapping a throwable:</p>\r\n" + 
			"\r\n" + 
			"<pre>protected abstract WrapperExceptionType wrap(Throwable t);</pre>\r\n" + 
			"\r\n" + 
			"<p>and finish\r\n" + 
			"the pending block as</p>\r\n" + 
			"\r\n" + 
			"<pre>if (pending != null)\r\n" + 
			"    if (wrapperExceptionType.isAssignableFrom(pending.getClass()))\r\n" + 
			"        throw wrapperExceptionType.cast(pending);\r\n" + 
			"    else\r\n" + 
			"        throw wrap(pending);</pre>\r\n" + 
			"\r\n" + 
			"<p>As an example, if we have a custom\r\n" + 
			"exception called OopsException, we can now use it as\r\n" + 
			"follows:</p>\r\n" + 
			"\r\n" + 
			"<pre>new AutoFileCloser&lt;OopsException&gt;(OopsException.class) {\r\n" + 
			"      @Override protected void doWork() throws OopsException {\r\n" + 
			"            // do stuff\r\n" + 
			"      }\r\n" + 
			"      @Override protected OopsException wrap(Throwable t) {\r\n" + 
			"            return new OopsException(t);\r\n" + 
			"      }\r\n" + 
			"};</pre>\r\n" + 
			"\r\n" + 
			"<p>If you need to use the OopsException version more than once, you can create a\r\n" + 
			"class for it:</p>\r\n" + 
			"\r\n" + 
			"<pre>public abstract class AutoFileCloserThrowsOops extends AutoFileCloser&lt;OopsException&gt; {\r\n" + 
			"    public AutoFileCloserThrowsOops() {\r\n" + 
			"        super(OopsException.class);\r\n" + 
			"    }\r\n" + 
			"    @Override protected OopsException wrap(Throwable t) {\r\n" + 
			"        return new OopsException(t);\r\n" + 
			"    }\r\n" + 
			"}</pre>\r\n" + 
			"\r\n" + 
			"<p>and then use\r\n" + 
			"it as follows:</p>\r\n" + 
			"\r\n" + 
			"<pre>new AutoFileCloserThrowsOops() {\r\n" + 
			"    @Override protected void doWork() throws OopsException {\r\n" + 
			"        // do stuff\r\n" + 
			"    }\r\n" + 
			"};</pre>\r\n" + 
			"\r\n" + 
			"<p>Much nicer, eh?</p>\r\n" + 
			"\r\n" + 
			"<h2>Final Implementations</h2>\r\n" + 
			"\r\n" + 
			"<h3>AutoFileCloser throwing hardwired SomeWrapperException</h3>\r\n" + 
			"<pre caption=\"AutoFileCloser throwing hardwired SomeWrapperException\">\r\n" + 
			"</pre>\r\n" + 
			"\r\n" + 
			"<h3>AutoFileCloser with Generic Exception</h3>\r\n" + 
			"<pre caption=\"AutoFileCloser with Generic Exception\">\r\n" + 
			"package somepkg;\r\n" + 
			"\r\n" + 
			"import java.io.Closeable;\r\n" + 
			"import java.io.IOException;\r\n" + 
			"import java.util.ArrayList;\r\n" + 
			"import java.util.List;\r\n" + 
			"\r\n" + 
			"public abstract class AutoFileCloser<WrapperExceptionType extends Throwable> {\r\n" + 
			"    protected abstract void doWork() throws WrapperExceptionType;\r\n" + 
			"    private List<Closeable> streams = new ArrayList<Closeable>();\r\n" + 
			"    protected final <T extends Closeable> T watch(T closeable) {\r\n" + 
			"        streams.add(closeable);\r\n" + 
			"        return closeable;\r\n" + 
			"    }\r\n" + 
			"    protected abstract WrapperExceptionType wrap(Throwable t);\r\n" + 
			"    public AutoFileCloser(Class<WrapperExceptionType> wrapperExceptionType) throws WrapperExceptionType {\r\n" + 
			"		Throwable pending = null;\r\n" + 
			"        try {\r\n" + 
			"            doWork();\r\n" + 
			"        } catch (ThreadDeath t) {\r\n" + 
			"            throw t;\r\n" + 
			"        } catch (Throwable t) {\r\n" + 
			"            pending = t;\r\n" + 
			"        } finally {\r\n" + 
			"            for (Closeable c : streams) {\r\n" + 
			"                try {\r\n" + 
			"                    c.close();\r\n" + 
			"                } catch (IOException e) {\r\n" + 
			"                    // report and/or log error\r\n" + 
			"                    if (pending == null)\r\n" + 
			"                        pending = e;\r\n" + 
			"                }\r\n" + 
			"            }\r\n" + 
			"            if (pending != null)\r\n" + 
			"                if (wrapperExceptionType.isAssignableFrom(pending.getClass()))\r\n" + 
			"                    throw wrapperExceptionType.cast(pending);\r\n" + 
			"                else\r\n" + 
			"                    throw wrap(pending);\r\n" + 
			"        }\r\n" + 
			"\r\n" + 
			"    }\r\n" + 
			"	public static abstract class AutoFileCloserThrowsOops extends AutoFileCloser<OopsException> {\r\n" + 
			"	    public AutoFileCloserThrowsOops() {\r\n" + 
			"	        super(OopsException.class);\r\n" + 
			"	    }\r\n" + 
			"	    @Override protected OopsException wrap(Throwable t) {\r\n" + 
			"	        return new OopsException(t);\r\n" + 
			"	    }\r\n" + 
			"	}\r\n" + 
			"}\r\n" + 
			"</pre>\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"<h2>AutoFileCloser with MultiException (and MultiException implementation)</h2>\r\n" + 
			"<pre caption=\"AutoFileCloser with MultiException (and MultiException implementation)\">\r\n" + 
			"</pre>\r\n" + 
			"\r\n" + 
			"<p>TBD: talk about options to return\r\n" + 
			"value from the doWork method</p>\r\n" + 
			"\r\n" + 
			"<h3>Now about database connections...</h3>\r\n" + 
			"TBD TBD TBD\r\n" + 
			"\r\n" + 
			"</body>\r\n" + 
			"\r\n" + 
			"</html>\r\n" + 
			"";
}
