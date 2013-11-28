// $ANTLR 3.1.2 C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g 2009-07-09 20:33:21

  package com.javadude.javamage;
  import java.util.Set;
  import java.util.HashSet;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class JavaHighlight extends Lexer {
    public static final int StringLiteral=7;
    public static final int SpecialIdentifier=12;
    public static final int JavaIdentifier=11;
    public static final int Keyword=4;
    public static final int Operator=10;
    public static final int Other=15;
    public static final int JavaIdentifierPart=14;
    public static final int SingleLineComment=5;
    public static final int JavaIdentifierStart=13;
    public static final int EOF=-1;
    public static final int ToggleHighlight=9;
    public static final int MultiLineComment=6;
    public static final int CalloutNum=8;

    	private static final Set<String> create(String... strings) {
    		Set<String> set = new HashSet<String>();
    		for (String string : strings) {
    			set.add(string);
    		}
    		return set;
    	}
      private static final Set<String> keywords = create(
    	"abstract", "continue", "for", "new", "switch",
    	"assert", "default", "goto", "package", "synchronized",
    	"boolean", "do", "if", "private", "this",
    	"break", "double", "implements", "protected", "throw",
    	"byte", "else", "import", "public", "throws",
    	"case", "enum", "instanceof", "return", "transient",
    	"catch", "extends", "int", "short", "try",
    	"char", "final", "interface", "static", "void",
    	"class", "finally", "long", "strictfp", "volatile",
    	"const", "float", "native", "super", "while");


    // delegates
    // delegators

    public JavaHighlight() {;} 
    public JavaHighlight(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public JavaHighlight(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g"; }

    // $ANTLR start "SingleLineComment"
    public final void mSingleLineComment() throws RecognitionException {
        try {
            int _type = SingleLineComment;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:35:19: ( '//' (~ ( '\\n' | '\\r' | '`' ) )* )
            // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:36:3: '//' (~ ( '\\n' | '\\r' | '`' ) )*
            {
            match("//"); 

            // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:36:8: (~ ( '\\n' | '\\r' | '`' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='_')||(LA1_0>='a' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:36:9: ~ ( '\\n' | '\\r' | '`' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='_')||(input.LA(1)>='a' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SingleLineComment"

    // $ANTLR start "MultiLineComment"
    public final void mMultiLineComment() throws RecognitionException {
        try {
            int _type = MultiLineComment;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:38:18: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:39:3: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:39:8: ( options {greedy=false; } : . )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0=='*') ) {
                    int LA2_1 = input.LA(2);

                    if ( (LA2_1=='/') ) {
                        alt2=2;
                    }
                    else if ( ((LA2_1>='\u0000' && LA2_1<='.')||(LA2_1>='0' && LA2_1<='\uFFFF')) ) {
                        alt2=1;
                    }


                }
                else if ( ((LA2_0>='\u0000' && LA2_0<=')')||(LA2_0>='+' && LA2_0<='\uFFFF')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:39:36: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MultiLineComment"

    // $ANTLR start "StringLiteral"
    public final void mStringLiteral() throws RecognitionException {
        try {
            int _type = StringLiteral;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:41:15: ( '\"' (~ ( '\"' | '\\n' | '\\r' ) )* '\"' )
            // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:42:3: '\"' (~ ( '\"' | '\\n' | '\\r' ) )* '\"'
            {
            match('\"'); 
            // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:42:7: (~ ( '\"' | '\\n' | '\\r' ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='\u0000' && LA3_0<='\t')||(LA3_0>='\u000B' && LA3_0<='\f')||(LA3_0>='\u000E' && LA3_0<='!')||(LA3_0>='#' && LA3_0<='\uFFFF')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:42:8: ~ ( '\"' | '\\n' | '\\r' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "StringLiteral"

    // $ANTLR start "CalloutNum"
    public final void mCalloutNum() throws RecognitionException {
        try {
            int _type = CalloutNum;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:44:12: ( '`' ( '0' .. '9' )* )
            // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:45:2: '`' ( '0' .. '9' )*
            {
            match('`'); 
            // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:45:6: ( '0' .. '9' )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:45:7: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            setText(getText().substring(1));

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CalloutNum"

    // $ANTLR start "ToggleHighlight"
    public final void mToggleHighlight() throws RecognitionException {
        try {
            int _type = ToggleHighlight;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:48:2: ( '``' )
            // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:48:4: '``'
            {
            match("``"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ToggleHighlight"

    // $ANTLR start "Operator"
    public final void mOperator() throws RecognitionException {
        try {
            int _type = Operator;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:51:2: ( ( '&lt;' | '&apos;' | '&quot;' | '&gt;' | '&amp;' | '+' | '-' | '~' | '!' | '*' | '/' | '%' | '<' | '>' | '=' | '.' | ';' | '&' | '^' | '|' | '?' | ':' | '(' | ')' | '[' | ']' | '{' | '}' )+ )
            // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:51:4: ( '&lt;' | '&apos;' | '&quot;' | '&gt;' | '&amp;' | '+' | '-' | '~' | '!' | '*' | '/' | '%' | '<' | '>' | '=' | '.' | ';' | '&' | '^' | '|' | '?' | ':' | '(' | ')' | '[' | ']' | '{' | '}' )+
            {
            // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:51:4: ( '&lt;' | '&apos;' | '&quot;' | '&gt;' | '&amp;' | '+' | '-' | '~' | '!' | '*' | '/' | '%' | '<' | '>' | '=' | '.' | ';' | '&' | '^' | '|' | '?' | ':' | '(' | ')' | '[' | ']' | '{' | '}' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=29;
                alt5 = dfa5.predict(input);
                switch (alt5) {
            	case 1 :
            	    // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:51:6: '&lt;'
            	    {
            	    match("&lt;"); 


            	    }
            	    break;
            	case 2 :
            	    // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:52:5: '&apos;'
            	    {
            	    match("&apos;"); 


            	    }
            	    break;
            	case 3 :
            	    // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:53:5: '&quot;'
            	    {
            	    match("&quot;"); 


            	    }
            	    break;
            	case 4 :
            	    // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:54:5: '&gt;'
            	    {
            	    match("&gt;"); 


            	    }
            	    break;
            	case 5 :
            	    // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:55:5: '&amp;'
            	    {
            	    match("&amp;"); 


            	    }
            	    break;
            	case 6 :
            	    // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:56:5: '+'
            	    {
            	    match('+'); 

            	    }
            	    break;
            	case 7 :
            	    // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:56:11: '-'
            	    {
            	    match('-'); 

            	    }
            	    break;
            	case 8 :
            	    // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:56:17: '~'
            	    {
            	    match('~'); 

            	    }
            	    break;
            	case 9 :
            	    // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:56:23: '!'
            	    {
            	    match('!'); 

            	    }
            	    break;
            	case 10 :
            	    // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:56:29: '*'
            	    {
            	    match('*'); 

            	    }
            	    break;
            	case 11 :
            	    // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:56:35: '/'
            	    {
            	    match('/'); 

            	    }
            	    break;
            	case 12 :
            	    // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:56:41: '%'
            	    {
            	    match('%'); 

            	    }
            	    break;
            	case 13 :
            	    // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:56:47: '<'
            	    {
            	    match('<'); 

            	    }
            	    break;
            	case 14 :
            	    // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:56:53: '>'
            	    {
            	    match('>'); 

            	    }
            	    break;
            	case 15 :
            	    // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:56:59: '='
            	    {
            	    match('='); 

            	    }
            	    break;
            	case 16 :
            	    // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:56:65: '.'
            	    {
            	    match('.'); 

            	    }
            	    break;
            	case 17 :
            	    // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:56:71: ';'
            	    {
            	    match(';'); 

            	    }
            	    break;
            	case 18 :
            	    // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:57:5: '&'
            	    {
            	    match('&'); 

            	    }
            	    break;
            	case 19 :
            	    // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:57:11: '^'
            	    {
            	    match('^'); 

            	    }
            	    break;
            	case 20 :
            	    // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:57:17: '|'
            	    {
            	    match('|'); 

            	    }
            	    break;
            	case 21 :
            	    // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:57:23: '?'
            	    {
            	    match('?'); 

            	    }
            	    break;
            	case 22 :
            	    // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:57:29: ':'
            	    {
            	    match(':'); 

            	    }
            	    break;
            	case 23 :
            	    // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:57:35: '('
            	    {
            	    match('('); 

            	    }
            	    break;
            	case 24 :
            	    // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:57:41: ')'
            	    {
            	    match(')'); 

            	    }
            	    break;
            	case 25 :
            	    // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:57:47: '['
            	    {
            	    match('['); 

            	    }
            	    break;
            	case 26 :
            	    // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:57:53: ']'
            	    {
            	    match(']'); 

            	    }
            	    break;
            	case 27 :
            	    // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:57:59: '{'
            	    {
            	    match('{'); 

            	    }
            	    break;
            	case 28 :
            	    // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:57:65: '}'
            	    {
            	    match('}'); 

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Operator"

    // $ANTLR start "SpecialIdentifier"
    public final void mSpecialIdentifier() throws RecognitionException {
        try {
            int _type = SpecialIdentifier;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:62:2: ( ( '$' | '@' ) JavaIdentifier )
            // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:62:4: ( '$' | '@' ) JavaIdentifier
            {
            if ( input.LA(1)=='$'||input.LA(1)=='@' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            mJavaIdentifier(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SpecialIdentifier"

    // $ANTLR start "JavaIdentifier"
    public final void mJavaIdentifier() throws RecognitionException {
        try {
            int _type = JavaIdentifier;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:65:15: ( JavaIdentifierStart ( JavaIdentifierPart )* )
            // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:66:3: JavaIdentifierStart ( JavaIdentifierPart )*
            {
            mJavaIdentifierStart(); 
            // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:67:3: ( JavaIdentifierPart )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='\u0000' && LA6_0<='\b')||(LA6_0>='\u000E' && LA6_0<='\u001B')||(LA6_0>='0' && LA6_0<='9')||(LA6_0>='A' && LA6_0<='Z')||LA6_0=='_'||(LA6_0>='a' && LA6_0<='z')||(LA6_0>='\u007F' && LA6_0<='\u009F')||LA6_0=='\u00AA'||LA6_0=='\u00AD'||LA6_0=='\u00B5'||LA6_0=='\u00BA'||(LA6_0>='\u00C0' && LA6_0<='\u00D6')||(LA6_0>='\u00D8' && LA6_0<='\u00F6')||(LA6_0>='\u00F8' && LA6_0<='\u02C1')||(LA6_0>='\u02C6' && LA6_0<='\u02D1')||(LA6_0>='\u02E0' && LA6_0<='\u02E4')||LA6_0=='\u02EE'||(LA6_0>='\u0300' && LA6_0<='\u036F')||(LA6_0>='\u037A' && LA6_0<='\u037D')||LA6_0=='\u0386'||(LA6_0>='\u0388' && LA6_0<='\u038A')||LA6_0=='\u038C'||(LA6_0>='\u038E' && LA6_0<='\u03A1')||(LA6_0>='\u03A3' && LA6_0<='\u03CE')||(LA6_0>='\u03D0' && LA6_0<='\u03F5')||(LA6_0>='\u03F7' && LA6_0<='\u0481')||(LA6_0>='\u0483' && LA6_0<='\u0486')||(LA6_0>='\u048A' && LA6_0<='\u0513')||(LA6_0>='\u0531' && LA6_0<='\u0556')||LA6_0=='\u0559'||(LA6_0>='\u0561' && LA6_0<='\u0587')||(LA6_0>='\u0591' && LA6_0<='\u05BD')||LA6_0=='\u05BF'||(LA6_0>='\u05C1' && LA6_0<='\u05C2')||(LA6_0>='\u05C4' && LA6_0<='\u05C5')||LA6_0=='\u05C7'||(LA6_0>='\u05D0' && LA6_0<='\u05EA')||(LA6_0>='\u05F0' && LA6_0<='\u05F2')||(LA6_0>='\u0600' && LA6_0<='\u0603')||(LA6_0>='\u0610' && LA6_0<='\u0615')||(LA6_0>='\u0621' && LA6_0<='\u063A')||(LA6_0>='\u0640' && LA6_0<='\u065E')||(LA6_0>='\u0660' && LA6_0<='\u0669')||(LA6_0>='\u066E' && LA6_0<='\u06D3')||(LA6_0>='\u06D5' && LA6_0<='\u06DD')||(LA6_0>='\u06DF' && LA6_0<='\u06E8')||(LA6_0>='\u06EA' && LA6_0<='\u06FC')||LA6_0=='\u06FF'||(LA6_0>='\u070F' && LA6_0<='\u074A')||(LA6_0>='\u074D' && LA6_0<='\u076D')||(LA6_0>='\u0780' && LA6_0<='\u07B1')||(LA6_0>='\u07C0' && LA6_0<='\u07F5')||LA6_0=='\u07FA'||(LA6_0>='\u0901' && LA6_0<='\u0939')||(LA6_0>='\u093C' && LA6_0<='\u094D')||(LA6_0>='\u0950' && LA6_0<='\u0954')||(LA6_0>='\u0958' && LA6_0<='\u0963')||(LA6_0>='\u0966' && LA6_0<='\u096F')||(LA6_0>='\u097B' && LA6_0<='\u097F')||(LA6_0>='\u0981' && LA6_0<='\u0983')||(LA6_0>='\u0985' && LA6_0<='\u098C')||(LA6_0>='\u098F' && LA6_0<='\u0990')||(LA6_0>='\u0993' && LA6_0<='\u09A8')||(LA6_0>='\u09AA' && LA6_0<='\u09B0')||LA6_0=='\u09B2'||(LA6_0>='\u09B6' && LA6_0<='\u09B9')||(LA6_0>='\u09BC' && LA6_0<='\u09C4')||(LA6_0>='\u09C7' && LA6_0<='\u09C8')||(LA6_0>='\u09CB' && LA6_0<='\u09CE')||LA6_0=='\u09D7'||(LA6_0>='\u09DC' && LA6_0<='\u09DD')||(LA6_0>='\u09DF' && LA6_0<='\u09E3')||(LA6_0>='\u09E6' && LA6_0<='\u09F1')||(LA6_0>='\u0A01' && LA6_0<='\u0A03')||(LA6_0>='\u0A05' && LA6_0<='\u0A0A')||(LA6_0>='\u0A0F' && LA6_0<='\u0A10')||(LA6_0>='\u0A13' && LA6_0<='\u0A28')||(LA6_0>='\u0A2A' && LA6_0<='\u0A30')||(LA6_0>='\u0A32' && LA6_0<='\u0A33')||(LA6_0>='\u0A35' && LA6_0<='\u0A36')||(LA6_0>='\u0A38' && LA6_0<='\u0A39')||LA6_0=='\u0A3C'||(LA6_0>='\u0A3E' && LA6_0<='\u0A42')||(LA6_0>='\u0A47' && LA6_0<='\u0A48')||(LA6_0>='\u0A4B' && LA6_0<='\u0A4D')||(LA6_0>='\u0A59' && LA6_0<='\u0A5C')||LA6_0=='\u0A5E'||(LA6_0>='\u0A66' && LA6_0<='\u0A74')||(LA6_0>='\u0A81' && LA6_0<='\u0A83')||(LA6_0>='\u0A85' && LA6_0<='\u0A8D')||(LA6_0>='\u0A8F' && LA6_0<='\u0A91')||(LA6_0>='\u0A93' && LA6_0<='\u0AA8')||(LA6_0>='\u0AAA' && LA6_0<='\u0AB0')||(LA6_0>='\u0AB2' && LA6_0<='\u0AB3')||(LA6_0>='\u0AB5' && LA6_0<='\u0AB9')||(LA6_0>='\u0ABC' && LA6_0<='\u0AC5')||(LA6_0>='\u0AC7' && LA6_0<='\u0AC9')||(LA6_0>='\u0ACB' && LA6_0<='\u0ACD')||LA6_0=='\u0AD0'||(LA6_0>='\u0AE0' && LA6_0<='\u0AE3')||(LA6_0>='\u0AE6' && LA6_0<='\u0AEF')||(LA6_0>='\u0B01' && LA6_0<='\u0B03')||(LA6_0>='\u0B05' && LA6_0<='\u0B0C')||(LA6_0>='\u0B0F' && LA6_0<='\u0B10')||(LA6_0>='\u0B13' && LA6_0<='\u0B28')||(LA6_0>='\u0B2A' && LA6_0<='\u0B30')||(LA6_0>='\u0B32' && LA6_0<='\u0B33')||(LA6_0>='\u0B35' && LA6_0<='\u0B39')||(LA6_0>='\u0B3C' && LA6_0<='\u0B43')||(LA6_0>='\u0B47' && LA6_0<='\u0B48')||(LA6_0>='\u0B4B' && LA6_0<='\u0B4D')||(LA6_0>='\u0B56' && LA6_0<='\u0B57')||(LA6_0>='\u0B5C' && LA6_0<='\u0B5D')||(LA6_0>='\u0B5F' && LA6_0<='\u0B61')||(LA6_0>='\u0B66' && LA6_0<='\u0B6F')||LA6_0=='\u0B71'||(LA6_0>='\u0B82' && LA6_0<='\u0B83')||(LA6_0>='\u0B85' && LA6_0<='\u0B8A')||(LA6_0>='\u0B8E' && LA6_0<='\u0B90')||(LA6_0>='\u0B92' && LA6_0<='\u0B95')||(LA6_0>='\u0B99' && LA6_0<='\u0B9A')||LA6_0=='\u0B9C'||(LA6_0>='\u0B9E' && LA6_0<='\u0B9F')||(LA6_0>='\u0BA3' && LA6_0<='\u0BA4')||(LA6_0>='\u0BA8' && LA6_0<='\u0BAA')||(LA6_0>='\u0BAE' && LA6_0<='\u0BB9')||(LA6_0>='\u0BBE' && LA6_0<='\u0BC2')||(LA6_0>='\u0BC6' && LA6_0<='\u0BC8')||(LA6_0>='\u0BCA' && LA6_0<='\u0BCD')||LA6_0=='\u0BD7'||(LA6_0>='\u0BE6' && LA6_0<='\u0BEF')||(LA6_0>='\u0C01' && LA6_0<='\u0C03')||(LA6_0>='\u0C05' && LA6_0<='\u0C0C')||(LA6_0>='\u0C0E' && LA6_0<='\u0C10')||(LA6_0>='\u0C12' && LA6_0<='\u0C28')||(LA6_0>='\u0C2A' && LA6_0<='\u0C33')||(LA6_0>='\u0C35' && LA6_0<='\u0C39')||(LA6_0>='\u0C3E' && LA6_0<='\u0C44')||(LA6_0>='\u0C46' && LA6_0<='\u0C48')||(LA6_0>='\u0C4A' && LA6_0<='\u0C4D')||(LA6_0>='\u0C55' && LA6_0<='\u0C56')||(LA6_0>='\u0C60' && LA6_0<='\u0C61')||(LA6_0>='\u0C66' && LA6_0<='\u0C6F')||(LA6_0>='\u0C82' && LA6_0<='\u0C83')||(LA6_0>='\u0C85' && LA6_0<='\u0C8C')||(LA6_0>='\u0C8E' && LA6_0<='\u0C90')||(LA6_0>='\u0C92' && LA6_0<='\u0CA8')||(LA6_0>='\u0CAA' && LA6_0<='\u0CB3')||(LA6_0>='\u0CB5' && LA6_0<='\u0CB9')||(LA6_0>='\u0CBC' && LA6_0<='\u0CC4')||(LA6_0>='\u0CC6' && LA6_0<='\u0CC8')||(LA6_0>='\u0CCA' && LA6_0<='\u0CCD')||(LA6_0>='\u0CD5' && LA6_0<='\u0CD6')||LA6_0=='\u0CDE'||(LA6_0>='\u0CE0' && LA6_0<='\u0CE3')||(LA6_0>='\u0CE6' && LA6_0<='\u0CEF')||(LA6_0>='\u0D02' && LA6_0<='\u0D03')||(LA6_0>='\u0D05' && LA6_0<='\u0D0C')||(LA6_0>='\u0D0E' && LA6_0<='\u0D10')||(LA6_0>='\u0D12' && LA6_0<='\u0D28')||(LA6_0>='\u0D2A' && LA6_0<='\u0D39')||(LA6_0>='\u0D3E' && LA6_0<='\u0D43')||(LA6_0>='\u0D46' && LA6_0<='\u0D48')||(LA6_0>='\u0D4A' && LA6_0<='\u0D4D')||LA6_0=='\u0D57'||(LA6_0>='\u0D60' && LA6_0<='\u0D61')||(LA6_0>='\u0D66' && LA6_0<='\u0D6F')||(LA6_0>='\u0D82' && LA6_0<='\u0D83')||(LA6_0>='\u0D85' && LA6_0<='\u0D96')||(LA6_0>='\u0D9A' && LA6_0<='\u0DB1')||(LA6_0>='\u0DB3' && LA6_0<='\u0DBB')||LA6_0=='\u0DBD'||(LA6_0>='\u0DC0' && LA6_0<='\u0DC6')||LA6_0=='\u0DCA'||(LA6_0>='\u0DCF' && LA6_0<='\u0DD4')||LA6_0=='\u0DD6'||(LA6_0>='\u0DD8' && LA6_0<='\u0DDF')||(LA6_0>='\u0DF2' && LA6_0<='\u0DF3')||(LA6_0>='\u0E01' && LA6_0<='\u0E3A')||(LA6_0>='\u0E40' && LA6_0<='\u0E4E')||(LA6_0>='\u0E50' && LA6_0<='\u0E59')||(LA6_0>='\u0E81' && LA6_0<='\u0E82')||LA6_0=='\u0E84'||(LA6_0>='\u0E87' && LA6_0<='\u0E88')||LA6_0=='\u0E8A'||LA6_0=='\u0E8D'||(LA6_0>='\u0E94' && LA6_0<='\u0E97')||(LA6_0>='\u0E99' && LA6_0<='\u0E9F')||(LA6_0>='\u0EA1' && LA6_0<='\u0EA3')||LA6_0=='\u0EA5'||LA6_0=='\u0EA7'||(LA6_0>='\u0EAA' && LA6_0<='\u0EAB')||(LA6_0>='\u0EAD' && LA6_0<='\u0EB9')||(LA6_0>='\u0EBB' && LA6_0<='\u0EBD')||(LA6_0>='\u0EC0' && LA6_0<='\u0EC4')||LA6_0=='\u0EC6'||(LA6_0>='\u0EC8' && LA6_0<='\u0ECD')||(LA6_0>='\u0ED0' && LA6_0<='\u0ED9')||(LA6_0>='\u0EDC' && LA6_0<='\u0EDD')||LA6_0=='\u0F00'||(LA6_0>='\u0F18' && LA6_0<='\u0F19')||(LA6_0>='\u0F20' && LA6_0<='\u0F29')||LA6_0=='\u0F35'||LA6_0=='\u0F37'||LA6_0=='\u0F39'||(LA6_0>='\u0F3E' && LA6_0<='\u0F47')||(LA6_0>='\u0F49' && LA6_0<='\u0F6A')||(LA6_0>='\u0F71' && LA6_0<='\u0F84')||(LA6_0>='\u0F86' && LA6_0<='\u0F8B')||(LA6_0>='\u0F90' && LA6_0<='\u0F97')||(LA6_0>='\u0F99' && LA6_0<='\u0FBC')||LA6_0=='\u0FC6'||(LA6_0>='\u1000' && LA6_0<='\u1021')||(LA6_0>='\u1023' && LA6_0<='\u1027')||(LA6_0>='\u1029' && LA6_0<='\u102A')||(LA6_0>='\u102C' && LA6_0<='\u1032')||(LA6_0>='\u1036' && LA6_0<='\u1039')||(LA6_0>='\u1040' && LA6_0<='\u1049')||(LA6_0>='\u1050' && LA6_0<='\u1059')||(LA6_0>='\u10A0' && LA6_0<='\u10C5')||(LA6_0>='\u10D0' && LA6_0<='\u10FA')||LA6_0=='\u10FC'||(LA6_0>='\u1100' && LA6_0<='\u1159')||(LA6_0>='\u115F' && LA6_0<='\u11A2')||(LA6_0>='\u11A8' && LA6_0<='\u11F9')||(LA6_0>='\u1200' && LA6_0<='\u1248')||(LA6_0>='\u124A' && LA6_0<='\u124D')||(LA6_0>='\u1250' && LA6_0<='\u1256')||LA6_0=='\u1258'||(LA6_0>='\u125A' && LA6_0<='\u125D')||(LA6_0>='\u1260' && LA6_0<='\u1288')||(LA6_0>='\u128A' && LA6_0<='\u128D')||(LA6_0>='\u1290' && LA6_0<='\u12B0')||(LA6_0>='\u12B2' && LA6_0<='\u12B5')||(LA6_0>='\u12B8' && LA6_0<='\u12BE')||LA6_0=='\u12C0'||(LA6_0>='\u12C2' && LA6_0<='\u12C5')||(LA6_0>='\u12C8' && LA6_0<='\u12D6')||(LA6_0>='\u12D8' && LA6_0<='\u1310')||(LA6_0>='\u1312' && LA6_0<='\u1315')||(LA6_0>='\u1318' && LA6_0<='\u135A')||LA6_0=='\u135F'||(LA6_0>='\u1380' && LA6_0<='\u138F')||(LA6_0>='\u13A0' && LA6_0<='\u13F4')||(LA6_0>='\u1401' && LA6_0<='\u166C')||(LA6_0>='\u166F' && LA6_0<='\u1676')||(LA6_0>='\u1681' && LA6_0<='\u169A')||(LA6_0>='\u16A0' && LA6_0<='\u16EA')||(LA6_0>='\u16EE' && LA6_0<='\u16F0')||(LA6_0>='\u1700' && LA6_0<='\u170C')||(LA6_0>='\u170E' && LA6_0<='\u1714')||(LA6_0>='\u1720' && LA6_0<='\u1734')||(LA6_0>='\u1740' && LA6_0<='\u1753')||(LA6_0>='\u1760' && LA6_0<='\u176C')||(LA6_0>='\u176E' && LA6_0<='\u1770')||(LA6_0>='\u1772' && LA6_0<='\u1773')||(LA6_0>='\u1780' && LA6_0<='\u17D3')||LA6_0=='\u17D7'||(LA6_0>='\u17DC' && LA6_0<='\u17DD')||(LA6_0>='\u17E0' && LA6_0<='\u17E9')||(LA6_0>='\u180B' && LA6_0<='\u180D')||(LA6_0>='\u1810' && LA6_0<='\u1819')||(LA6_0>='\u1820' && LA6_0<='\u1877')||(LA6_0>='\u1880' && LA6_0<='\u18A9')||(LA6_0>='\u1900' && LA6_0<='\u191C')||(LA6_0>='\u1920' && LA6_0<='\u192B')||(LA6_0>='\u1930' && LA6_0<='\u193B')||(LA6_0>='\u1946' && LA6_0<='\u196D')||(LA6_0>='\u1970' && LA6_0<='\u1974')||(LA6_0>='\u1980' && LA6_0<='\u19A9')||(LA6_0>='\u19B0' && LA6_0<='\u19C9')||(LA6_0>='\u19D0' && LA6_0<='\u19D9')||(LA6_0>='\u1A00' && LA6_0<='\u1A1B')||(LA6_0>='\u1B00' && LA6_0<='\u1B4B')||(LA6_0>='\u1B50' && LA6_0<='\u1B59')||(LA6_0>='\u1B6B' && LA6_0<='\u1B73')||(LA6_0>='\u1D00' && LA6_0<='\u1DCA')||(LA6_0>='\u1DFE' && LA6_0<='\u1E9B')||(LA6_0>='\u1EA0' && LA6_0<='\u1EF9')||(LA6_0>='\u1F00' && LA6_0<='\u1F15')||(LA6_0>='\u1F18' && LA6_0<='\u1F1D')||(LA6_0>='\u1F20' && LA6_0<='\u1F45')||(LA6_0>='\u1F48' && LA6_0<='\u1F4D')||(LA6_0>='\u1F50' && LA6_0<='\u1F57')||LA6_0=='\u1F59'||LA6_0=='\u1F5B'||LA6_0=='\u1F5D'||(LA6_0>='\u1F5F' && LA6_0<='\u1F7D')||(LA6_0>='\u1F80' && LA6_0<='\u1FB4')||(LA6_0>='\u1FB6' && LA6_0<='\u1FBC')||LA6_0=='\u1FBE'||(LA6_0>='\u1FC2' && LA6_0<='\u1FC4')||(LA6_0>='\u1FC6' && LA6_0<='\u1FCC')||(LA6_0>='\u1FD0' && LA6_0<='\u1FD3')||(LA6_0>='\u1FD6' && LA6_0<='\u1FDB')||(LA6_0>='\u1FE0' && LA6_0<='\u1FEC')||(LA6_0>='\u1FF2' && LA6_0<='\u1FF4')||(LA6_0>='\u1FF6' && LA6_0<='\u1FFC')||(LA6_0>='\u200B' && LA6_0<='\u200F')||(LA6_0>='\u202A' && LA6_0<='\u202E')||(LA6_0>='\u203F' && LA6_0<='\u2040')||LA6_0=='\u2054'||(LA6_0>='\u2060' && LA6_0<='\u2063')||(LA6_0>='\u206A' && LA6_0<='\u206F')||LA6_0=='\u2071'||LA6_0=='\u207F'||(LA6_0>='\u2090' && LA6_0<='\u2094')||(LA6_0>='\u20D0' && LA6_0<='\u20DC')||LA6_0=='\u20E1'||(LA6_0>='\u20E5' && LA6_0<='\u20EF')||LA6_0=='\u2102'||LA6_0=='\u2107'||(LA6_0>='\u210A' && LA6_0<='\u2113')||LA6_0=='\u2115'||(LA6_0>='\u2119' && LA6_0<='\u211D')||LA6_0=='\u2124'||LA6_0=='\u2126'||LA6_0=='\u2128'||(LA6_0>='\u212A' && LA6_0<='\u212D')||(LA6_0>='\u212F' && LA6_0<='\u2139')||(LA6_0>='\u213C' && LA6_0<='\u213F')||(LA6_0>='\u2145' && LA6_0<='\u2149')||LA6_0=='\u214E'||(LA6_0>='\u2160' && LA6_0<='\u2184')||(LA6_0>='\u2C00' && LA6_0<='\u2C2E')||(LA6_0>='\u2C30' && LA6_0<='\u2C5E')||(LA6_0>='\u2C60' && LA6_0<='\u2C6C')||(LA6_0>='\u2C74' && LA6_0<='\u2C77')||(LA6_0>='\u2C80' && LA6_0<='\u2CE4')||(LA6_0>='\u2D00' && LA6_0<='\u2D25')||(LA6_0>='\u2D30' && LA6_0<='\u2D65')||LA6_0=='\u2D6F'||(LA6_0>='\u2D80' && LA6_0<='\u2D96')||(LA6_0>='\u2DA0' && LA6_0<='\u2DA6')||(LA6_0>='\u2DA8' && LA6_0<='\u2DAE')||(LA6_0>='\u2DB0' && LA6_0<='\u2DB6')||(LA6_0>='\u2DB8' && LA6_0<='\u2DBE')||(LA6_0>='\u2DC0' && LA6_0<='\u2DC6')||(LA6_0>='\u2DC8' && LA6_0<='\u2DCE')||(LA6_0>='\u2DD0' && LA6_0<='\u2DD6')||(LA6_0>='\u2DD8' && LA6_0<='\u2DDE')||(LA6_0>='\u3005' && LA6_0<='\u3007')||(LA6_0>='\u3021' && LA6_0<='\u302F')||(LA6_0>='\u3031' && LA6_0<='\u3035')||(LA6_0>='\u3038' && LA6_0<='\u303C')||(LA6_0>='\u3041' && LA6_0<='\u3096')||(LA6_0>='\u3099' && LA6_0<='\u309A')||(LA6_0>='\u309D' && LA6_0<='\u309F')||(LA6_0>='\u30A1' && LA6_0<='\u30FA')||(LA6_0>='\u30FC' && LA6_0<='\u30FF')||(LA6_0>='\u3105' && LA6_0<='\u312C')||(LA6_0>='\u3131' && LA6_0<='\u318E')||(LA6_0>='\u31A0' && LA6_0<='\u31B7')||(LA6_0>='\u31F0' && LA6_0<='\u31FF')||(LA6_0>='\u3400' && LA6_0<='\u4DB5')||(LA6_0>='\u4E00' && LA6_0<='\u9FBB')||(LA6_0>='\uA000' && LA6_0<='\uA48C')||(LA6_0>='\uA717' && LA6_0<='\uA71A')||(LA6_0>='\uA800' && LA6_0<='\uA827')||(LA6_0>='\uA840' && LA6_0<='\uA873')||(LA6_0>='\uAC00' && LA6_0<='\uD7A3')||(LA6_0>='\uF900' && LA6_0<='\uFA2D')||(LA6_0>='\uFA30' && LA6_0<='\uFA6A')||(LA6_0>='\uFA70' && LA6_0<='\uFAD9')||(LA6_0>='\uFB00' && LA6_0<='\uFB06')||(LA6_0>='\uFB13' && LA6_0<='\uFB17')||(LA6_0>='\uFB1D' && LA6_0<='\uFB28')||(LA6_0>='\uFB2A' && LA6_0<='\uFB36')||(LA6_0>='\uFB38' && LA6_0<='\uFB3C')||LA6_0=='\uFB3E'||(LA6_0>='\uFB40' && LA6_0<='\uFB41')||(LA6_0>='\uFB43' && LA6_0<='\uFB44')||(LA6_0>='\uFB46' && LA6_0<='\uFBB1')||(LA6_0>='\uFBD3' && LA6_0<='\uFD3D')||(LA6_0>='\uFD50' && LA6_0<='\uFD8F')||(LA6_0>='\uFD92' && LA6_0<='\uFDC7')||(LA6_0>='\uFDF0' && LA6_0<='\uFDFB')||(LA6_0>='\uFE00' && LA6_0<='\uFE0F')||(LA6_0>='\uFE20' && LA6_0<='\uFE23')||(LA6_0>='\uFE33' && LA6_0<='\uFE34')||(LA6_0>='\uFE4D' && LA6_0<='\uFE4F')||(LA6_0>='\uFE70' && LA6_0<='\uFE74')||(LA6_0>='\uFE76' && LA6_0<='\uFEFC')||LA6_0=='\uFEFF'||(LA6_0>='\uFF10' && LA6_0<='\uFF19')||(LA6_0>='\uFF21' && LA6_0<='\uFF3A')||LA6_0=='\uFF3F'||(LA6_0>='\uFF41' && LA6_0<='\uFF5A')||(LA6_0>='\uFF66' && LA6_0<='\uFFBE')||(LA6_0>='\uFFC2' && LA6_0<='\uFFC7')||(LA6_0>='\uFFCA' && LA6_0<='\uFFCF')||(LA6_0>='\uFFD2' && LA6_0<='\uFFD7')||(LA6_0>='\uFFDA' && LA6_0<='\uFFDC')||(LA6_0>='\uFFF9' && LA6_0<='\uFFFB')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:67:3: JavaIdentifierPart
            	    {
            	    mJavaIdentifierPart(); 

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            		if (keywords.contains(getText()))
            			_type=Keyword;
            	

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "JavaIdentifier"

    // $ANTLR start "JavaIdentifierStart"
    public final void mJavaIdentifierStart() throws RecognitionException {
        try {
            // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:74:29: ( '\\u0041' .. '\\u005a' | '\\u005f' | '\\u0061' .. '\\u007a' | '\\u00aa' | '\\u00b5' | '\\u00ba' | '\\u00c0' .. '\\u00d6' | '\\u00d8' .. '\\u00f6' | '\\u00f8' .. '\\u02c1' | '\\u02c6' .. '\\u02d1' | '\\u02e0' .. '\\u02e4' | '\\u02ee' | '\\u037a' .. '\\u037d' | '\\u0386' | '\\u0388' .. '\\u038a' | '\\u038c' | '\\u038e' .. '\\u03a1' | '\\u03a3' .. '\\u03ce' | '\\u03d0' .. '\\u03f5' | '\\u03f7' .. '\\u0481' | '\\u048a' .. '\\u0513' | '\\u0531' .. '\\u0556' | '\\u0559' | '\\u0561' .. '\\u0587' | '\\u05d0' .. '\\u05ea' | '\\u05f0' .. '\\u05f2' | '\\u0621' .. '\\u063a' | '\\u0640' .. '\\u064a' | '\\u066e' .. '\\u066f' | '\\u0671' .. '\\u06d3' | '\\u06d5' | '\\u06e5' .. '\\u06e6' | '\\u06ee' .. '\\u06ef' | '\\u06fa' .. '\\u06fc' | '\\u06ff' | '\\u0710' | '\\u0712' .. '\\u072f' | '\\u074d' .. '\\u076d' | '\\u0780' .. '\\u07a5' | '\\u07b1' | '\\u07ca' .. '\\u07ea' | '\\u07f4' .. '\\u07f5' | '\\u07fa' | '\\u0904' .. '\\u0939' | '\\u093d' | '\\u0950' | '\\u0958' .. '\\u0961' | '\\u097b' .. '\\u097f' | '\\u0985' .. '\\u098c' | '\\u098f' .. '\\u0990' | '\\u0993' .. '\\u09a8' | '\\u09aa' .. '\\u09b0' | '\\u09b2' | '\\u09b6' .. '\\u09b9' | '\\u09bd' | '\\u09ce' | '\\u09dc' .. '\\u09dd' | '\\u09df' .. '\\u09e1' | '\\u09f0' .. '\\u09f1' | '\\u0a05' .. '\\u0a0a' | '\\u0a0f' .. '\\u0a10' | '\\u0a13' .. '\\u0a28' | '\\u0a2a' .. '\\u0a30' | '\\u0a32' .. '\\u0a33' | '\\u0a35' .. '\\u0a36' | '\\u0a38' .. '\\u0a39' | '\\u0a59' .. '\\u0a5c' | '\\u0a5e' | '\\u0a72' .. '\\u0a74' | '\\u0a85' .. '\\u0a8d' | '\\u0a8f' .. '\\u0a91' | '\\u0a93' .. '\\u0aa8' | '\\u0aaa' .. '\\u0ab0' | '\\u0ab2' .. '\\u0ab3' | '\\u0ab5' .. '\\u0ab9' | '\\u0abd' | '\\u0ad0' | '\\u0ae0' .. '\\u0ae1' | '\\u0b05' .. '\\u0b0c' | '\\u0b0f' .. '\\u0b10' | '\\u0b13' .. '\\u0b28' | '\\u0b2a' .. '\\u0b30' | '\\u0b32' .. '\\u0b33' | '\\u0b35' .. '\\u0b39' | '\\u0b3d' | '\\u0b5c' .. '\\u0b5d' | '\\u0b5f' .. '\\u0b61' | '\\u0b71' | '\\u0b83' | '\\u0b85' .. '\\u0b8a' | '\\u0b8e' .. '\\u0b90' | '\\u0b92' .. '\\u0b95' | '\\u0b99' .. '\\u0b9a' | '\\u0b9c' | '\\u0b9e' .. '\\u0b9f' | '\\u0ba3' .. '\\u0ba4' | '\\u0ba8' .. '\\u0baa' | '\\u0bae' .. '\\u0bb9' | '\\u0c05' .. '\\u0c0c' | '\\u0c0e' .. '\\u0c10' | '\\u0c12' .. '\\u0c28' | '\\u0c2a' .. '\\u0c33' | '\\u0c35' .. '\\u0c39' | '\\u0c60' .. '\\u0c61' | '\\u0c85' .. '\\u0c8c' | '\\u0c8e' .. '\\u0c90' | '\\u0c92' .. '\\u0ca8' | '\\u0caa' .. '\\u0cb3' | '\\u0cb5' .. '\\u0cb9' | '\\u0cbd' | '\\u0cde' | '\\u0ce0' .. '\\u0ce1' | '\\u0d05' .. '\\u0d0c' | '\\u0d0e' .. '\\u0d10' | '\\u0d12' .. '\\u0d28' | '\\u0d2a' .. '\\u0d39' | '\\u0d60' .. '\\u0d61' | '\\u0d85' .. '\\u0d96' | '\\u0d9a' .. '\\u0db1' | '\\u0db3' .. '\\u0dbb' | '\\u0dbd' | '\\u0dc0' .. '\\u0dc6' | '\\u0e01' .. '\\u0e30' | '\\u0e32' .. '\\u0e33' | '\\u0e40' .. '\\u0e46' | '\\u0e81' .. '\\u0e82' | '\\u0e84' | '\\u0e87' .. '\\u0e88' | '\\u0e8a' | '\\u0e8d' | '\\u0e94' .. '\\u0e97' | '\\u0e99' .. '\\u0e9f' | '\\u0ea1' .. '\\u0ea3' | '\\u0ea5' | '\\u0ea7' | '\\u0eaa' .. '\\u0eab' | '\\u0ead' .. '\\u0eb0' | '\\u0eb2' .. '\\u0eb3' | '\\u0ebd' | '\\u0ec0' .. '\\u0ec4' | '\\u0ec6' | '\\u0edc' .. '\\u0edd' | '\\u0f00' | '\\u0f40' .. '\\u0f47' | '\\u0f49' .. '\\u0f6a' | '\\u0f88' .. '\\u0f8b' | '\\u1000' .. '\\u1021' | '\\u1023' .. '\\u1027' | '\\u1029' .. '\\u102a' | '\\u1050' .. '\\u1055' | '\\u10a0' .. '\\u10c5' | '\\u10d0' .. '\\u10fa' | '\\u10fc' | '\\u1100' .. '\\u1159' | '\\u115f' .. '\\u11a2' | '\\u11a8' .. '\\u11f9' | '\\u1200' .. '\\u1248' | '\\u124a' .. '\\u124d' | '\\u1250' .. '\\u1256' | '\\u1258' | '\\u125a' .. '\\u125d' | '\\u1260' .. '\\u1288' | '\\u128a' .. '\\u128d' | '\\u1290' .. '\\u12b0' | '\\u12b2' .. '\\u12b5' | '\\u12b8' .. '\\u12be' | '\\u12c0' | '\\u12c2' .. '\\u12c5' | '\\u12c8' .. '\\u12d6' | '\\u12d8' .. '\\u1310' | '\\u1312' .. '\\u1315' | '\\u1318' .. '\\u135a' | '\\u1380' .. '\\u138f' | '\\u13a0' .. '\\u13f4' | '\\u1401' .. '\\u166c' | '\\u166f' .. '\\u1676' | '\\u1681' .. '\\u169a' | '\\u16a0' .. '\\u16ea' | '\\u16ee' .. '\\u16f0' | '\\u1700' .. '\\u170c' | '\\u170e' .. '\\u1711' | '\\u1720' .. '\\u1731' | '\\u1740' .. '\\u1751' | '\\u1760' .. '\\u176c' | '\\u176e' .. '\\u1770' | '\\u1780' .. '\\u17b3' | '\\u17d7' | '\\u17dc' | '\\u1820' .. '\\u1877' | '\\u1880' .. '\\u18a8' | '\\u1900' .. '\\u191c' | '\\u1950' .. '\\u196d' | '\\u1970' .. '\\u1974' | '\\u1980' .. '\\u19a9' | '\\u19c1' .. '\\u19c7' | '\\u1a00' .. '\\u1a16' | '\\u1b05' .. '\\u1b33' | '\\u1b45' .. '\\u1b4b' | '\\u1d00' .. '\\u1dbf' | '\\u1e00' .. '\\u1e9b' | '\\u1ea0' .. '\\u1ef9' | '\\u1f00' .. '\\u1f15' | '\\u1f18' .. '\\u1f1d' | '\\u1f20' .. '\\u1f45' | '\\u1f48' .. '\\u1f4d' | '\\u1f50' .. '\\u1f57' | '\\u1f59' | '\\u1f5b' | '\\u1f5d' | '\\u1f5f' .. '\\u1f7d' | '\\u1f80' .. '\\u1fb4' | '\\u1fb6' .. '\\u1fbc' | '\\u1fbe' | '\\u1fc2' .. '\\u1fc4' | '\\u1fc6' .. '\\u1fcc' | '\\u1fd0' .. '\\u1fd3' | '\\u1fd6' .. '\\u1fdb' | '\\u1fe0' .. '\\u1fec' | '\\u1ff2' .. '\\u1ff4' | '\\u1ff6' .. '\\u1ffc' | '\\u2071' | '\\u207f' | '\\u2090' .. '\\u2094' | '\\u2102' | '\\u2107' | '\\u210a' .. '\\u2113' | '\\u2115' | '\\u2119' .. '\\u211d' | '\\u2124' | '\\u2126' | '\\u2128' | '\\u212a' .. '\\u212d' | '\\u212f' .. '\\u2139' | '\\u213c' .. '\\u213f' | '\\u2145' .. '\\u2149' | '\\u214e' | '\\u2160' .. '\\u2184' | '\\u2c00' .. '\\u2c2e' | '\\u2c30' .. '\\u2c5e' | '\\u2c60' .. '\\u2c6c' | '\\u2c74' .. '\\u2c77' | '\\u2c80' .. '\\u2ce4' | '\\u2d00' .. '\\u2d25' | '\\u2d30' .. '\\u2d65' | '\\u2d6f' | '\\u2d80' .. '\\u2d96' | '\\u2da0' .. '\\u2da6' | '\\u2da8' .. '\\u2dae' | '\\u2db0' .. '\\u2db6' | '\\u2db8' .. '\\u2dbe' | '\\u2dc0' .. '\\u2dc6' | '\\u2dc8' .. '\\u2dce' | '\\u2dd0' .. '\\u2dd6' | '\\u2dd8' .. '\\u2dde' | '\\u3005' .. '\\u3007' | '\\u3021' .. '\\u3029' | '\\u3031' .. '\\u3035' | '\\u3038' .. '\\u303c' | '\\u3041' .. '\\u3096' | '\\u309d' .. '\\u309f' | '\\u30a1' .. '\\u30fa' | '\\u30fc' .. '\\u30ff' | '\\u3105' .. '\\u312c' | '\\u3131' .. '\\u318e' | '\\u31a0' .. '\\u31b7' | '\\u31f0' .. '\\u31ff' | '\\u3400' .. '\\u4db5' | '\\u4e00' .. '\\u9fbb' | '\\ua000' .. '\\ua48c' | '\\ua717' .. '\\ua71a' | '\\ua800' .. '\\ua801' | '\\ua803' .. '\\ua805' | '\\ua807' .. '\\ua80a' | '\\ua80c' .. '\\ua822' | '\\ua840' .. '\\ua873' | '\\uac00' .. '\\ud7a3' | '\\uf900' .. '\\ufa2d' | '\\ufa30' .. '\\ufa6a' | '\\ufa70' .. '\\ufad9' | '\\ufb00' .. '\\ufb06' | '\\ufb13' .. '\\ufb17' | '\\ufb1d' | '\\ufb1f' .. '\\ufb28' | '\\ufb2a' .. '\\ufb36' | '\\ufb38' .. '\\ufb3c' | '\\ufb3e' | '\\ufb40' .. '\\ufb41' | '\\ufb43' .. '\\ufb44' | '\\ufb46' .. '\\ufbb1' | '\\ufbd3' .. '\\ufd3d' | '\\ufd50' .. '\\ufd8f' | '\\ufd92' .. '\\ufdc7' | '\\ufdf0' .. '\\ufdfb' | '\\ufe70' .. '\\ufe74' | '\\ufe76' .. '\\ufefc' | '\\uff21' .. '\\uff3a' | '\\uff41' .. '\\uff5a' | '\\uff66' .. '\\uffbe' | '\\uffc2' .. '\\uffc7' | '\\uffca' .. '\\uffcf' | '\\uffd2' .. '\\uffd7' | '\\uffda' .. '\\uffdc' )
            // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z')||input.LA(1)=='\u00AA'||input.LA(1)=='\u00B5'||input.LA(1)=='\u00BA'||(input.LA(1)>='\u00C0' && input.LA(1)<='\u00D6')||(input.LA(1)>='\u00D8' && input.LA(1)<='\u00F6')||(input.LA(1)>='\u00F8' && input.LA(1)<='\u02C1')||(input.LA(1)>='\u02C6' && input.LA(1)<='\u02D1')||(input.LA(1)>='\u02E0' && input.LA(1)<='\u02E4')||input.LA(1)=='\u02EE'||(input.LA(1)>='\u037A' && input.LA(1)<='\u037D')||input.LA(1)=='\u0386'||(input.LA(1)>='\u0388' && input.LA(1)<='\u038A')||input.LA(1)=='\u038C'||(input.LA(1)>='\u038E' && input.LA(1)<='\u03A1')||(input.LA(1)>='\u03A3' && input.LA(1)<='\u03CE')||(input.LA(1)>='\u03D0' && input.LA(1)<='\u03F5')||(input.LA(1)>='\u03F7' && input.LA(1)<='\u0481')||(input.LA(1)>='\u048A' && input.LA(1)<='\u0513')||(input.LA(1)>='\u0531' && input.LA(1)<='\u0556')||input.LA(1)=='\u0559'||(input.LA(1)>='\u0561' && input.LA(1)<='\u0587')||(input.LA(1)>='\u05D0' && input.LA(1)<='\u05EA')||(input.LA(1)>='\u05F0' && input.LA(1)<='\u05F2')||(input.LA(1)>='\u0621' && input.LA(1)<='\u063A')||(input.LA(1)>='\u0640' && input.LA(1)<='\u064A')||(input.LA(1)>='\u066E' && input.LA(1)<='\u066F')||(input.LA(1)>='\u0671' && input.LA(1)<='\u06D3')||input.LA(1)=='\u06D5'||(input.LA(1)>='\u06E5' && input.LA(1)<='\u06E6')||(input.LA(1)>='\u06EE' && input.LA(1)<='\u06EF')||(input.LA(1)>='\u06FA' && input.LA(1)<='\u06FC')||input.LA(1)=='\u06FF'||input.LA(1)=='\u0710'||(input.LA(1)>='\u0712' && input.LA(1)<='\u072F')||(input.LA(1)>='\u074D' && input.LA(1)<='\u076D')||(input.LA(1)>='\u0780' && input.LA(1)<='\u07A5')||input.LA(1)=='\u07B1'||(input.LA(1)>='\u07CA' && input.LA(1)<='\u07EA')||(input.LA(1)>='\u07F4' && input.LA(1)<='\u07F5')||input.LA(1)=='\u07FA'||(input.LA(1)>='\u0904' && input.LA(1)<='\u0939')||input.LA(1)=='\u093D'||input.LA(1)=='\u0950'||(input.LA(1)>='\u0958' && input.LA(1)<='\u0961')||(input.LA(1)>='\u097B' && input.LA(1)<='\u097F')||(input.LA(1)>='\u0985' && input.LA(1)<='\u098C')||(input.LA(1)>='\u098F' && input.LA(1)<='\u0990')||(input.LA(1)>='\u0993' && input.LA(1)<='\u09A8')||(input.LA(1)>='\u09AA' && input.LA(1)<='\u09B0')||input.LA(1)=='\u09B2'||(input.LA(1)>='\u09B6' && input.LA(1)<='\u09B9')||input.LA(1)=='\u09BD'||input.LA(1)=='\u09CE'||(input.LA(1)>='\u09DC' && input.LA(1)<='\u09DD')||(input.LA(1)>='\u09DF' && input.LA(1)<='\u09E1')||(input.LA(1)>='\u09F0' && input.LA(1)<='\u09F1')||(input.LA(1)>='\u0A05' && input.LA(1)<='\u0A0A')||(input.LA(1)>='\u0A0F' && input.LA(1)<='\u0A10')||(input.LA(1)>='\u0A13' && input.LA(1)<='\u0A28')||(input.LA(1)>='\u0A2A' && input.LA(1)<='\u0A30')||(input.LA(1)>='\u0A32' && input.LA(1)<='\u0A33')||(input.LA(1)>='\u0A35' && input.LA(1)<='\u0A36')||(input.LA(1)>='\u0A38' && input.LA(1)<='\u0A39')||(input.LA(1)>='\u0A59' && input.LA(1)<='\u0A5C')||input.LA(1)=='\u0A5E'||(input.LA(1)>='\u0A72' && input.LA(1)<='\u0A74')||(input.LA(1)>='\u0A85' && input.LA(1)<='\u0A8D')||(input.LA(1)>='\u0A8F' && input.LA(1)<='\u0A91')||(input.LA(1)>='\u0A93' && input.LA(1)<='\u0AA8')||(input.LA(1)>='\u0AAA' && input.LA(1)<='\u0AB0')||(input.LA(1)>='\u0AB2' && input.LA(1)<='\u0AB3')||(input.LA(1)>='\u0AB5' && input.LA(1)<='\u0AB9')||input.LA(1)=='\u0ABD'||input.LA(1)=='\u0AD0'||(input.LA(1)>='\u0AE0' && input.LA(1)<='\u0AE1')||(input.LA(1)>='\u0B05' && input.LA(1)<='\u0B0C')||(input.LA(1)>='\u0B0F' && input.LA(1)<='\u0B10')||(input.LA(1)>='\u0B13' && input.LA(1)<='\u0B28')||(input.LA(1)>='\u0B2A' && input.LA(1)<='\u0B30')||(input.LA(1)>='\u0B32' && input.LA(1)<='\u0B33')||(input.LA(1)>='\u0B35' && input.LA(1)<='\u0B39')||input.LA(1)=='\u0B3D'||(input.LA(1)>='\u0B5C' && input.LA(1)<='\u0B5D')||(input.LA(1)>='\u0B5F' && input.LA(1)<='\u0B61')||input.LA(1)=='\u0B71'||input.LA(1)=='\u0B83'||(input.LA(1)>='\u0B85' && input.LA(1)<='\u0B8A')||(input.LA(1)>='\u0B8E' && input.LA(1)<='\u0B90')||(input.LA(1)>='\u0B92' && input.LA(1)<='\u0B95')||(input.LA(1)>='\u0B99' && input.LA(1)<='\u0B9A')||input.LA(1)=='\u0B9C'||(input.LA(1)>='\u0B9E' && input.LA(1)<='\u0B9F')||(input.LA(1)>='\u0BA3' && input.LA(1)<='\u0BA4')||(input.LA(1)>='\u0BA8' && input.LA(1)<='\u0BAA')||(input.LA(1)>='\u0BAE' && input.LA(1)<='\u0BB9')||(input.LA(1)>='\u0C05' && input.LA(1)<='\u0C0C')||(input.LA(1)>='\u0C0E' && input.LA(1)<='\u0C10')||(input.LA(1)>='\u0C12' && input.LA(1)<='\u0C28')||(input.LA(1)>='\u0C2A' && input.LA(1)<='\u0C33')||(input.LA(1)>='\u0C35' && input.LA(1)<='\u0C39')||(input.LA(1)>='\u0C60' && input.LA(1)<='\u0C61')||(input.LA(1)>='\u0C85' && input.LA(1)<='\u0C8C')||(input.LA(1)>='\u0C8E' && input.LA(1)<='\u0C90')||(input.LA(1)>='\u0C92' && input.LA(1)<='\u0CA8')||(input.LA(1)>='\u0CAA' && input.LA(1)<='\u0CB3')||(input.LA(1)>='\u0CB5' && input.LA(1)<='\u0CB9')||input.LA(1)=='\u0CBD'||input.LA(1)=='\u0CDE'||(input.LA(1)>='\u0CE0' && input.LA(1)<='\u0CE1')||(input.LA(1)>='\u0D05' && input.LA(1)<='\u0D0C')||(input.LA(1)>='\u0D0E' && input.LA(1)<='\u0D10')||(input.LA(1)>='\u0D12' && input.LA(1)<='\u0D28')||(input.LA(1)>='\u0D2A' && input.LA(1)<='\u0D39')||(input.LA(1)>='\u0D60' && input.LA(1)<='\u0D61')||(input.LA(1)>='\u0D85' && input.LA(1)<='\u0D96')||(input.LA(1)>='\u0D9A' && input.LA(1)<='\u0DB1')||(input.LA(1)>='\u0DB3' && input.LA(1)<='\u0DBB')||input.LA(1)=='\u0DBD'||(input.LA(1)>='\u0DC0' && input.LA(1)<='\u0DC6')||(input.LA(1)>='\u0E01' && input.LA(1)<='\u0E30')||(input.LA(1)>='\u0E32' && input.LA(1)<='\u0E33')||(input.LA(1)>='\u0E40' && input.LA(1)<='\u0E46')||(input.LA(1)>='\u0E81' && input.LA(1)<='\u0E82')||input.LA(1)=='\u0E84'||(input.LA(1)>='\u0E87' && input.LA(1)<='\u0E88')||input.LA(1)=='\u0E8A'||input.LA(1)=='\u0E8D'||(input.LA(1)>='\u0E94' && input.LA(1)<='\u0E97')||(input.LA(1)>='\u0E99' && input.LA(1)<='\u0E9F')||(input.LA(1)>='\u0EA1' && input.LA(1)<='\u0EA3')||input.LA(1)=='\u0EA5'||input.LA(1)=='\u0EA7'||(input.LA(1)>='\u0EAA' && input.LA(1)<='\u0EAB')||(input.LA(1)>='\u0EAD' && input.LA(1)<='\u0EB0')||(input.LA(1)>='\u0EB2' && input.LA(1)<='\u0EB3')||input.LA(1)=='\u0EBD'||(input.LA(1)>='\u0EC0' && input.LA(1)<='\u0EC4')||input.LA(1)=='\u0EC6'||(input.LA(1)>='\u0EDC' && input.LA(1)<='\u0EDD')||input.LA(1)=='\u0F00'||(input.LA(1)>='\u0F40' && input.LA(1)<='\u0F47')||(input.LA(1)>='\u0F49' && input.LA(1)<='\u0F6A')||(input.LA(1)>='\u0F88' && input.LA(1)<='\u0F8B')||(input.LA(1)>='\u1000' && input.LA(1)<='\u1021')||(input.LA(1)>='\u1023' && input.LA(1)<='\u1027')||(input.LA(1)>='\u1029' && input.LA(1)<='\u102A')||(input.LA(1)>='\u1050' && input.LA(1)<='\u1055')||(input.LA(1)>='\u10A0' && input.LA(1)<='\u10C5')||(input.LA(1)>='\u10D0' && input.LA(1)<='\u10FA')||input.LA(1)=='\u10FC'||(input.LA(1)>='\u1100' && input.LA(1)<='\u1159')||(input.LA(1)>='\u115F' && input.LA(1)<='\u11A2')||(input.LA(1)>='\u11A8' && input.LA(1)<='\u11F9')||(input.LA(1)>='\u1200' && input.LA(1)<='\u1248')||(input.LA(1)>='\u124A' && input.LA(1)<='\u124D')||(input.LA(1)>='\u1250' && input.LA(1)<='\u1256')||input.LA(1)=='\u1258'||(input.LA(1)>='\u125A' && input.LA(1)<='\u125D')||(input.LA(1)>='\u1260' && input.LA(1)<='\u1288')||(input.LA(1)>='\u128A' && input.LA(1)<='\u128D')||(input.LA(1)>='\u1290' && input.LA(1)<='\u12B0')||(input.LA(1)>='\u12B2' && input.LA(1)<='\u12B5')||(input.LA(1)>='\u12B8' && input.LA(1)<='\u12BE')||input.LA(1)=='\u12C0'||(input.LA(1)>='\u12C2' && input.LA(1)<='\u12C5')||(input.LA(1)>='\u12C8' && input.LA(1)<='\u12D6')||(input.LA(1)>='\u12D8' && input.LA(1)<='\u1310')||(input.LA(1)>='\u1312' && input.LA(1)<='\u1315')||(input.LA(1)>='\u1318' && input.LA(1)<='\u135A')||(input.LA(1)>='\u1380' && input.LA(1)<='\u138F')||(input.LA(1)>='\u13A0' && input.LA(1)<='\u13F4')||(input.LA(1)>='\u1401' && input.LA(1)<='\u166C')||(input.LA(1)>='\u166F' && input.LA(1)<='\u1676')||(input.LA(1)>='\u1681' && input.LA(1)<='\u169A')||(input.LA(1)>='\u16A0' && input.LA(1)<='\u16EA')||(input.LA(1)>='\u16EE' && input.LA(1)<='\u16F0')||(input.LA(1)>='\u1700' && input.LA(1)<='\u170C')||(input.LA(1)>='\u170E' && input.LA(1)<='\u1711')||(input.LA(1)>='\u1720' && input.LA(1)<='\u1731')||(input.LA(1)>='\u1740' && input.LA(1)<='\u1751')||(input.LA(1)>='\u1760' && input.LA(1)<='\u176C')||(input.LA(1)>='\u176E' && input.LA(1)<='\u1770')||(input.LA(1)>='\u1780' && input.LA(1)<='\u17B3')||input.LA(1)=='\u17D7'||input.LA(1)=='\u17DC'||(input.LA(1)>='\u1820' && input.LA(1)<='\u1877')||(input.LA(1)>='\u1880' && input.LA(1)<='\u18A8')||(input.LA(1)>='\u1900' && input.LA(1)<='\u191C')||(input.LA(1)>='\u1950' && input.LA(1)<='\u196D')||(input.LA(1)>='\u1970' && input.LA(1)<='\u1974')||(input.LA(1)>='\u1980' && input.LA(1)<='\u19A9')||(input.LA(1)>='\u19C1' && input.LA(1)<='\u19C7')||(input.LA(1)>='\u1A00' && input.LA(1)<='\u1A16')||(input.LA(1)>='\u1B05' && input.LA(1)<='\u1B33')||(input.LA(1)>='\u1B45' && input.LA(1)<='\u1B4B')||(input.LA(1)>='\u1D00' && input.LA(1)<='\u1DBF')||(input.LA(1)>='\u1E00' && input.LA(1)<='\u1E9B')||(input.LA(1)>='\u1EA0' && input.LA(1)<='\u1EF9')||(input.LA(1)>='\u1F00' && input.LA(1)<='\u1F15')||(input.LA(1)>='\u1F18' && input.LA(1)<='\u1F1D')||(input.LA(1)>='\u1F20' && input.LA(1)<='\u1F45')||(input.LA(1)>='\u1F48' && input.LA(1)<='\u1F4D')||(input.LA(1)>='\u1F50' && input.LA(1)<='\u1F57')||input.LA(1)=='\u1F59'||input.LA(1)=='\u1F5B'||input.LA(1)=='\u1F5D'||(input.LA(1)>='\u1F5F' && input.LA(1)<='\u1F7D')||(input.LA(1)>='\u1F80' && input.LA(1)<='\u1FB4')||(input.LA(1)>='\u1FB6' && input.LA(1)<='\u1FBC')||input.LA(1)=='\u1FBE'||(input.LA(1)>='\u1FC2' && input.LA(1)<='\u1FC4')||(input.LA(1)>='\u1FC6' && input.LA(1)<='\u1FCC')||(input.LA(1)>='\u1FD0' && input.LA(1)<='\u1FD3')||(input.LA(1)>='\u1FD6' && input.LA(1)<='\u1FDB')||(input.LA(1)>='\u1FE0' && input.LA(1)<='\u1FEC')||(input.LA(1)>='\u1FF2' && input.LA(1)<='\u1FF4')||(input.LA(1)>='\u1FF6' && input.LA(1)<='\u1FFC')||input.LA(1)=='\u2071'||input.LA(1)=='\u207F'||(input.LA(1)>='\u2090' && input.LA(1)<='\u2094')||input.LA(1)=='\u2102'||input.LA(1)=='\u2107'||(input.LA(1)>='\u210A' && input.LA(1)<='\u2113')||input.LA(1)=='\u2115'||(input.LA(1)>='\u2119' && input.LA(1)<='\u211D')||input.LA(1)=='\u2124'||input.LA(1)=='\u2126'||input.LA(1)=='\u2128'||(input.LA(1)>='\u212A' && input.LA(1)<='\u212D')||(input.LA(1)>='\u212F' && input.LA(1)<='\u2139')||(input.LA(1)>='\u213C' && input.LA(1)<='\u213F')||(input.LA(1)>='\u2145' && input.LA(1)<='\u2149')||input.LA(1)=='\u214E'||(input.LA(1)>='\u2160' && input.LA(1)<='\u2184')||(input.LA(1)>='\u2C00' && input.LA(1)<='\u2C2E')||(input.LA(1)>='\u2C30' && input.LA(1)<='\u2C5E')||(input.LA(1)>='\u2C60' && input.LA(1)<='\u2C6C')||(input.LA(1)>='\u2C74' && input.LA(1)<='\u2C77')||(input.LA(1)>='\u2C80' && input.LA(1)<='\u2CE4')||(input.LA(1)>='\u2D00' && input.LA(1)<='\u2D25')||(input.LA(1)>='\u2D30' && input.LA(1)<='\u2D65')||input.LA(1)=='\u2D6F'||(input.LA(1)>='\u2D80' && input.LA(1)<='\u2D96')||(input.LA(1)>='\u2DA0' && input.LA(1)<='\u2DA6')||(input.LA(1)>='\u2DA8' && input.LA(1)<='\u2DAE')||(input.LA(1)>='\u2DB0' && input.LA(1)<='\u2DB6')||(input.LA(1)>='\u2DB8' && input.LA(1)<='\u2DBE')||(input.LA(1)>='\u2DC0' && input.LA(1)<='\u2DC6')||(input.LA(1)>='\u2DC8' && input.LA(1)<='\u2DCE')||(input.LA(1)>='\u2DD0' && input.LA(1)<='\u2DD6')||(input.LA(1)>='\u2DD8' && input.LA(1)<='\u2DDE')||(input.LA(1)>='\u3005' && input.LA(1)<='\u3007')||(input.LA(1)>='\u3021' && input.LA(1)<='\u3029')||(input.LA(1)>='\u3031' && input.LA(1)<='\u3035')||(input.LA(1)>='\u3038' && input.LA(1)<='\u303C')||(input.LA(1)>='\u3041' && input.LA(1)<='\u3096')||(input.LA(1)>='\u309D' && input.LA(1)<='\u309F')||(input.LA(1)>='\u30A1' && input.LA(1)<='\u30FA')||(input.LA(1)>='\u30FC' && input.LA(1)<='\u30FF')||(input.LA(1)>='\u3105' && input.LA(1)<='\u312C')||(input.LA(1)>='\u3131' && input.LA(1)<='\u318E')||(input.LA(1)>='\u31A0' && input.LA(1)<='\u31B7')||(input.LA(1)>='\u31F0' && input.LA(1)<='\u31FF')||(input.LA(1)>='\u3400' && input.LA(1)<='\u4DB5')||(input.LA(1)>='\u4E00' && input.LA(1)<='\u9FBB')||(input.LA(1)>='\uA000' && input.LA(1)<='\uA48C')||(input.LA(1)>='\uA717' && input.LA(1)<='\uA71A')||(input.LA(1)>='\uA800' && input.LA(1)<='\uA801')||(input.LA(1)>='\uA803' && input.LA(1)<='\uA805')||(input.LA(1)>='\uA807' && input.LA(1)<='\uA80A')||(input.LA(1)>='\uA80C' && input.LA(1)<='\uA822')||(input.LA(1)>='\uA840' && input.LA(1)<='\uA873')||(input.LA(1)>='\uAC00' && input.LA(1)<='\uD7A3')||(input.LA(1)>='\uF900' && input.LA(1)<='\uFA2D')||(input.LA(1)>='\uFA30' && input.LA(1)<='\uFA6A')||(input.LA(1)>='\uFA70' && input.LA(1)<='\uFAD9')||(input.LA(1)>='\uFB00' && input.LA(1)<='\uFB06')||(input.LA(1)>='\uFB13' && input.LA(1)<='\uFB17')||input.LA(1)=='\uFB1D'||(input.LA(1)>='\uFB1F' && input.LA(1)<='\uFB28')||(input.LA(1)>='\uFB2A' && input.LA(1)<='\uFB36')||(input.LA(1)>='\uFB38' && input.LA(1)<='\uFB3C')||input.LA(1)=='\uFB3E'||(input.LA(1)>='\uFB40' && input.LA(1)<='\uFB41')||(input.LA(1)>='\uFB43' && input.LA(1)<='\uFB44')||(input.LA(1)>='\uFB46' && input.LA(1)<='\uFBB1')||(input.LA(1)>='\uFBD3' && input.LA(1)<='\uFD3D')||(input.LA(1)>='\uFD50' && input.LA(1)<='\uFD8F')||(input.LA(1)>='\uFD92' && input.LA(1)<='\uFDC7')||(input.LA(1)>='\uFDF0' && input.LA(1)<='\uFDFB')||(input.LA(1)>='\uFE70' && input.LA(1)<='\uFE74')||(input.LA(1)>='\uFE76' && input.LA(1)<='\uFEFC')||(input.LA(1)>='\uFF21' && input.LA(1)<='\uFF3A')||(input.LA(1)>='\uFF41' && input.LA(1)<='\uFF5A')||(input.LA(1)>='\uFF66' && input.LA(1)<='\uFFBE')||(input.LA(1)>='\uFFC2' && input.LA(1)<='\uFFC7')||(input.LA(1)>='\uFFCA' && input.LA(1)<='\uFFCF')||(input.LA(1)>='\uFFD2' && input.LA(1)<='\uFFD7')||(input.LA(1)>='\uFFDA' && input.LA(1)<='\uFFDC') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "JavaIdentifierStart"

    // $ANTLR start "JavaIdentifierPart"
    public final void mJavaIdentifierPart() throws RecognitionException {
        try {
            // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:170:29: ( '\\u0000' .. '\\u0008' | '\\u000e' .. '\\u001b' | '\\u0030' .. '\\u0039' | '\\u0041' .. '\\u005a' | '\\u005f' | '\\u0061' .. '\\u007a' | '\\u007f' .. '\\u009f' | '\\u00aa' | '\\u00ad' | '\\u00b5' | '\\u00ba' | '\\u00c0' .. '\\u00d6' | '\\u00d8' .. '\\u00f6' | '\\u00f8' .. '\\u02c1' | '\\u02c6' .. '\\u02d1' | '\\u02e0' .. '\\u02e4' | '\\u02ee' | '\\u0300' .. '\\u036f' | '\\u037a' .. '\\u037d' | '\\u0386' | '\\u0388' .. '\\u038a' | '\\u038c' | '\\u038e' .. '\\u03a1' | '\\u03a3' .. '\\u03ce' | '\\u03d0' .. '\\u03f5' | '\\u03f7' .. '\\u0481' | '\\u0483' .. '\\u0486' | '\\u048a' .. '\\u0513' | '\\u0531' .. '\\u0556' | '\\u0559' | '\\u0561' .. '\\u0587' | '\\u0591' .. '\\u05bd' | '\\u05bf' | '\\u05c1' .. '\\u05c2' | '\\u05c4' .. '\\u05c5' | '\\u05c7' | '\\u05d0' .. '\\u05ea' | '\\u05f0' .. '\\u05f2' | '\\u0600' .. '\\u0603' | '\\u0610' .. '\\u0615' | '\\u0621' .. '\\u063a' | '\\u0640' .. '\\u065e' | '\\u0660' .. '\\u0669' | '\\u066e' .. '\\u06d3' | '\\u06d5' .. '\\u06dd' | '\\u06df' .. '\\u06e8' | '\\u06ea' .. '\\u06fc' | '\\u06ff' | '\\u070f' .. '\\u074a' | '\\u074d' .. '\\u076d' | '\\u0780' .. '\\u07b1' | '\\u07c0' .. '\\u07f5' | '\\u07fa' | '\\u0901' .. '\\u0939' | '\\u093c' .. '\\u094d' | '\\u0950' .. '\\u0954' | '\\u0958' .. '\\u0963' | '\\u0966' .. '\\u096f' | '\\u097b' .. '\\u097f' | '\\u0981' .. '\\u0983' | '\\u0985' .. '\\u098c' | '\\u098f' .. '\\u0990' | '\\u0993' .. '\\u09a8' | '\\u09aa' .. '\\u09b0' | '\\u09b2' | '\\u09b6' .. '\\u09b9' | '\\u09bc' .. '\\u09c4' | '\\u09c7' .. '\\u09c8' | '\\u09cb' .. '\\u09ce' | '\\u09d7' | '\\u09dc' .. '\\u09dd' | '\\u09df' .. '\\u09e3' | '\\u09e6' .. '\\u09f1' | '\\u0a01' .. '\\u0a03' | '\\u0a05' .. '\\u0a0a' | '\\u0a0f' .. '\\u0a10' | '\\u0a13' .. '\\u0a28' | '\\u0a2a' .. '\\u0a30' | '\\u0a32' .. '\\u0a33' | '\\u0a35' .. '\\u0a36' | '\\u0a38' .. '\\u0a39' | '\\u0a3c' | '\\u0a3e' .. '\\u0a42' | '\\u0a47' .. '\\u0a48' | '\\u0a4b' .. '\\u0a4d' | '\\u0a59' .. '\\u0a5c' | '\\u0a5e' | '\\u0a66' .. '\\u0a74' | '\\u0a81' .. '\\u0a83' | '\\u0a85' .. '\\u0a8d' | '\\u0a8f' .. '\\u0a91' | '\\u0a93' .. '\\u0aa8' | '\\u0aaa' .. '\\u0ab0' | '\\u0ab2' .. '\\u0ab3' | '\\u0ab5' .. '\\u0ab9' | '\\u0abc' .. '\\u0ac5' | '\\u0ac7' .. '\\u0ac9' | '\\u0acb' .. '\\u0acd' | '\\u0ad0' | '\\u0ae0' .. '\\u0ae3' | '\\u0ae6' .. '\\u0aef' | '\\u0b01' .. '\\u0b03' | '\\u0b05' .. '\\u0b0c' | '\\u0b0f' .. '\\u0b10' | '\\u0b13' .. '\\u0b28' | '\\u0b2a' .. '\\u0b30' | '\\u0b32' .. '\\u0b33' | '\\u0b35' .. '\\u0b39' | '\\u0b3c' .. '\\u0b43' | '\\u0b47' .. '\\u0b48' | '\\u0b4b' .. '\\u0b4d' | '\\u0b56' .. '\\u0b57' | '\\u0b5c' .. '\\u0b5d' | '\\u0b5f' .. '\\u0b61' | '\\u0b66' .. '\\u0b6f' | '\\u0b71' | '\\u0b82' .. '\\u0b83' | '\\u0b85' .. '\\u0b8a' | '\\u0b8e' .. '\\u0b90' | '\\u0b92' .. '\\u0b95' | '\\u0b99' .. '\\u0b9a' | '\\u0b9c' | '\\u0b9e' .. '\\u0b9f' | '\\u0ba3' .. '\\u0ba4' | '\\u0ba8' .. '\\u0baa' | '\\u0bae' .. '\\u0bb9' | '\\u0bbe' .. '\\u0bc2' | '\\u0bc6' .. '\\u0bc8' | '\\u0bca' .. '\\u0bcd' | '\\u0bd7' | '\\u0be6' .. '\\u0bef' | '\\u0c01' .. '\\u0c03' | '\\u0c05' .. '\\u0c0c' | '\\u0c0e' .. '\\u0c10' | '\\u0c12' .. '\\u0c28' | '\\u0c2a' .. '\\u0c33' | '\\u0c35' .. '\\u0c39' | '\\u0c3e' .. '\\u0c44' | '\\u0c46' .. '\\u0c48' | '\\u0c4a' .. '\\u0c4d' | '\\u0c55' .. '\\u0c56' | '\\u0c60' .. '\\u0c61' | '\\u0c66' .. '\\u0c6f' | '\\u0c82' .. '\\u0c83' | '\\u0c85' .. '\\u0c8c' | '\\u0c8e' .. '\\u0c90' | '\\u0c92' .. '\\u0ca8' | '\\u0caa' .. '\\u0cb3' | '\\u0cb5' .. '\\u0cb9' | '\\u0cbc' .. '\\u0cc4' | '\\u0cc6' .. '\\u0cc8' | '\\u0cca' .. '\\u0ccd' | '\\u0cd5' .. '\\u0cd6' | '\\u0cde' | '\\u0ce0' .. '\\u0ce3' | '\\u0ce6' .. '\\u0cef' | '\\u0d02' .. '\\u0d03' | '\\u0d05' .. '\\u0d0c' | '\\u0d0e' .. '\\u0d10' | '\\u0d12' .. '\\u0d28' | '\\u0d2a' .. '\\u0d39' | '\\u0d3e' .. '\\u0d43' | '\\u0d46' .. '\\u0d48' | '\\u0d4a' .. '\\u0d4d' | '\\u0d57' | '\\u0d60' .. '\\u0d61' | '\\u0d66' .. '\\u0d6f' | '\\u0d82' .. '\\u0d83' | '\\u0d85' .. '\\u0d96' | '\\u0d9a' .. '\\u0db1' | '\\u0db3' .. '\\u0dbb' | '\\u0dbd' | '\\u0dc0' .. '\\u0dc6' | '\\u0dca' | '\\u0dcf' .. '\\u0dd4' | '\\u0dd6' | '\\u0dd8' .. '\\u0ddf' | '\\u0df2' .. '\\u0df3' | '\\u0e01' .. '\\u0e3a' | '\\u0e40' .. '\\u0e4e' | '\\u0e50' .. '\\u0e59' | '\\u0e81' .. '\\u0e82' | '\\u0e84' | '\\u0e87' .. '\\u0e88' | '\\u0e8a' | '\\u0e8d' | '\\u0e94' .. '\\u0e97' | '\\u0e99' .. '\\u0e9f' | '\\u0ea1' .. '\\u0ea3' | '\\u0ea5' | '\\u0ea7' | '\\u0eaa' .. '\\u0eab' | '\\u0ead' .. '\\u0eb9' | '\\u0ebb' .. '\\u0ebd' | '\\u0ec0' .. '\\u0ec4' | '\\u0ec6' | '\\u0ec8' .. '\\u0ecd' | '\\u0ed0' .. '\\u0ed9' | '\\u0edc' .. '\\u0edd' | '\\u0f00' | '\\u0f18' .. '\\u0f19' | '\\u0f20' .. '\\u0f29' | '\\u0f35' | '\\u0f37' | '\\u0f39' | '\\u0f3e' .. '\\u0f47' | '\\u0f49' .. '\\u0f6a' | '\\u0f71' .. '\\u0f84' | '\\u0f86' .. '\\u0f8b' | '\\u0f90' .. '\\u0f97' | '\\u0f99' .. '\\u0fbc' | '\\u0fc6' | '\\u1000' .. '\\u1021' | '\\u1023' .. '\\u1027' | '\\u1029' .. '\\u102a' | '\\u102c' .. '\\u1032' | '\\u1036' .. '\\u1039' | '\\u1040' .. '\\u1049' | '\\u1050' .. '\\u1059' | '\\u10a0' .. '\\u10c5' | '\\u10d0' .. '\\u10fa' | '\\u10fc' | '\\u1100' .. '\\u1159' | '\\u115f' .. '\\u11a2' | '\\u11a8' .. '\\u11f9' | '\\u1200' .. '\\u1248' | '\\u124a' .. '\\u124d' | '\\u1250' .. '\\u1256' | '\\u1258' | '\\u125a' .. '\\u125d' | '\\u1260' .. '\\u1288' | '\\u128a' .. '\\u128d' | '\\u1290' .. '\\u12b0' | '\\u12b2' .. '\\u12b5' | '\\u12b8' .. '\\u12be' | '\\u12c0' | '\\u12c2' .. '\\u12c5' | '\\u12c8' .. '\\u12d6' | '\\u12d8' .. '\\u1310' | '\\u1312' .. '\\u1315' | '\\u1318' .. '\\u135a' | '\\u135f' | '\\u1380' .. '\\u138f' | '\\u13a0' .. '\\u13f4' | '\\u1401' .. '\\u166c' | '\\u166f' .. '\\u1676' | '\\u1681' .. '\\u169a' | '\\u16a0' .. '\\u16ea' | '\\u16ee' .. '\\u16f0' | '\\u1700' .. '\\u170c' | '\\u170e' .. '\\u1714' | '\\u1720' .. '\\u1734' | '\\u1740' .. '\\u1753' | '\\u1760' .. '\\u176c' | '\\u176e' .. '\\u1770' | '\\u1772' .. '\\u1773' | '\\u1780' .. '\\u17d3' | '\\u17d7' | '\\u17dc' .. '\\u17dd' | '\\u17e0' .. '\\u17e9' | '\\u180b' .. '\\u180d' | '\\u1810' .. '\\u1819' | '\\u1820' .. '\\u1877' | '\\u1880' .. '\\u18a9' | '\\u1900' .. '\\u191c' | '\\u1920' .. '\\u192b' | '\\u1930' .. '\\u193b' | '\\u1946' .. '\\u196d' | '\\u1970' .. '\\u1974' | '\\u1980' .. '\\u19a9' | '\\u19b0' .. '\\u19c9' | '\\u19d0' .. '\\u19d9' | '\\u1a00' .. '\\u1a1b' | '\\u1b00' .. '\\u1b4b' | '\\u1b50' .. '\\u1b59' | '\\u1b6b' .. '\\u1b73' | '\\u1d00' .. '\\u1dca' | '\\u1dfe' .. '\\u1e9b' | '\\u1ea0' .. '\\u1ef9' | '\\u1f00' .. '\\u1f15' | '\\u1f18' .. '\\u1f1d' | '\\u1f20' .. '\\u1f45' | '\\u1f48' .. '\\u1f4d' | '\\u1f50' .. '\\u1f57' | '\\u1f59' | '\\u1f5b' | '\\u1f5d' | '\\u1f5f' .. '\\u1f7d' | '\\u1f80' .. '\\u1fb4' | '\\u1fb6' .. '\\u1fbc' | '\\u1fbe' | '\\u1fc2' .. '\\u1fc4' | '\\u1fc6' .. '\\u1fcc' | '\\u1fd0' .. '\\u1fd3' | '\\u1fd6' .. '\\u1fdb' | '\\u1fe0' .. '\\u1fec' | '\\u1ff2' .. '\\u1ff4' | '\\u1ff6' .. '\\u1ffc' | '\\u200b' .. '\\u200f' | '\\u202a' .. '\\u202e' | '\\u203f' .. '\\u2040' | '\\u2054' | '\\u2060' .. '\\u2063' | '\\u206a' .. '\\u206f' | '\\u2071' | '\\u207f' | '\\u2090' .. '\\u2094' | '\\u20d0' .. '\\u20dc' | '\\u20e1' | '\\u20e5' .. '\\u20ef' | '\\u2102' | '\\u2107' | '\\u210a' .. '\\u2113' | '\\u2115' | '\\u2119' .. '\\u211d' | '\\u2124' | '\\u2126' | '\\u2128' | '\\u212a' .. '\\u212d' | '\\u212f' .. '\\u2139' | '\\u213c' .. '\\u213f' | '\\u2145' .. '\\u2149' | '\\u214e' | '\\u2160' .. '\\u2184' | '\\u2c00' .. '\\u2c2e' | '\\u2c30' .. '\\u2c5e' | '\\u2c60' .. '\\u2c6c' | '\\u2c74' .. '\\u2c77' | '\\u2c80' .. '\\u2ce4' | '\\u2d00' .. '\\u2d25' | '\\u2d30' .. '\\u2d65' | '\\u2d6f' | '\\u2d80' .. '\\u2d96' | '\\u2da0' .. '\\u2da6' | '\\u2da8' .. '\\u2dae' | '\\u2db0' .. '\\u2db6' | '\\u2db8' .. '\\u2dbe' | '\\u2dc0' .. '\\u2dc6' | '\\u2dc8' .. '\\u2dce' | '\\u2dd0' .. '\\u2dd6' | '\\u2dd8' .. '\\u2dde' | '\\u3005' .. '\\u3007' | '\\u3021' .. '\\u302f' | '\\u3031' .. '\\u3035' | '\\u3038' .. '\\u303c' | '\\u3041' .. '\\u3096' | '\\u3099' .. '\\u309a' | '\\u309d' .. '\\u309f' | '\\u30a1' .. '\\u30fa' | '\\u30fc' .. '\\u30ff' | '\\u3105' .. '\\u312c' | '\\u3131' .. '\\u318e' | '\\u31a0' .. '\\u31b7' | '\\u31f0' .. '\\u31ff' | '\\u3400' .. '\\u4db5' | '\\u4e00' .. '\\u9fbb' | '\\ua000' .. '\\ua48c' | '\\ua717' .. '\\ua71a' | '\\ua800' .. '\\ua827' | '\\ua840' .. '\\ua873' | '\\uac00' .. '\\ud7a3' | '\\uf900' .. '\\ufa2d' | '\\ufa30' .. '\\ufa6a' | '\\ufa70' .. '\\ufad9' | '\\ufb00' .. '\\ufb06' | '\\ufb13' .. '\\ufb17' | '\\ufb1d' .. '\\ufb28' | '\\ufb2a' .. '\\ufb36' | '\\ufb38' .. '\\ufb3c' | '\\ufb3e' | '\\ufb40' .. '\\ufb41' | '\\ufb43' .. '\\ufb44' | '\\ufb46' .. '\\ufbb1' | '\\ufbd3' .. '\\ufd3d' | '\\ufd50' .. '\\ufd8f' | '\\ufd92' .. '\\ufdc7' | '\\ufdf0' .. '\\ufdfb' | '\\ufe00' .. '\\ufe0f' | '\\ufe20' .. '\\ufe23' | '\\ufe33' .. '\\ufe34' | '\\ufe4d' .. '\\ufe4f' | '\\ufe70' .. '\\ufe74' | '\\ufe76' .. '\\ufefc' | '\\ufeff' | '\\uff10' .. '\\uff19' | '\\uff21' .. '\\uff3a' | '\\uff3f' | '\\uff41' .. '\\uff5a' | '\\uff66' .. '\\uffbe' | '\\uffc2' .. '\\uffc7' | '\\uffca' .. '\\uffcf' | '\\uffd2' .. '\\uffd7' | '\\uffda' .. '\\uffdc' | '\\ufff9' .. '\\ufffb' )
            // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:
            {
            if ( (input.LA(1)>='\u0000' && input.LA(1)<='\b')||(input.LA(1)>='\u000E' && input.LA(1)<='\u001B')||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z')||(input.LA(1)>='\u007F' && input.LA(1)<='\u009F')||input.LA(1)=='\u00AA'||input.LA(1)=='\u00AD'||input.LA(1)=='\u00B5'||input.LA(1)=='\u00BA'||(input.LA(1)>='\u00C0' && input.LA(1)<='\u00D6')||(input.LA(1)>='\u00D8' && input.LA(1)<='\u00F6')||(input.LA(1)>='\u00F8' && input.LA(1)<='\u02C1')||(input.LA(1)>='\u02C6' && input.LA(1)<='\u02D1')||(input.LA(1)>='\u02E0' && input.LA(1)<='\u02E4')||input.LA(1)=='\u02EE'||(input.LA(1)>='\u0300' && input.LA(1)<='\u036F')||(input.LA(1)>='\u037A' && input.LA(1)<='\u037D')||input.LA(1)=='\u0386'||(input.LA(1)>='\u0388' && input.LA(1)<='\u038A')||input.LA(1)=='\u038C'||(input.LA(1)>='\u038E' && input.LA(1)<='\u03A1')||(input.LA(1)>='\u03A3' && input.LA(1)<='\u03CE')||(input.LA(1)>='\u03D0' && input.LA(1)<='\u03F5')||(input.LA(1)>='\u03F7' && input.LA(1)<='\u0481')||(input.LA(1)>='\u0483' && input.LA(1)<='\u0486')||(input.LA(1)>='\u048A' && input.LA(1)<='\u0513')||(input.LA(1)>='\u0531' && input.LA(1)<='\u0556')||input.LA(1)=='\u0559'||(input.LA(1)>='\u0561' && input.LA(1)<='\u0587')||(input.LA(1)>='\u0591' && input.LA(1)<='\u05BD')||input.LA(1)=='\u05BF'||(input.LA(1)>='\u05C1' && input.LA(1)<='\u05C2')||(input.LA(1)>='\u05C4' && input.LA(1)<='\u05C5')||input.LA(1)=='\u05C7'||(input.LA(1)>='\u05D0' && input.LA(1)<='\u05EA')||(input.LA(1)>='\u05F0' && input.LA(1)<='\u05F2')||(input.LA(1)>='\u0600' && input.LA(1)<='\u0603')||(input.LA(1)>='\u0610' && input.LA(1)<='\u0615')||(input.LA(1)>='\u0621' && input.LA(1)<='\u063A')||(input.LA(1)>='\u0640' && input.LA(1)<='\u065E')||(input.LA(1)>='\u0660' && input.LA(1)<='\u0669')||(input.LA(1)>='\u066E' && input.LA(1)<='\u06D3')||(input.LA(1)>='\u06D5' && input.LA(1)<='\u06DD')||(input.LA(1)>='\u06DF' && input.LA(1)<='\u06E8')||(input.LA(1)>='\u06EA' && input.LA(1)<='\u06FC')||input.LA(1)=='\u06FF'||(input.LA(1)>='\u070F' && input.LA(1)<='\u074A')||(input.LA(1)>='\u074D' && input.LA(1)<='\u076D')||(input.LA(1)>='\u0780' && input.LA(1)<='\u07B1')||(input.LA(1)>='\u07C0' && input.LA(1)<='\u07F5')||input.LA(1)=='\u07FA'||(input.LA(1)>='\u0901' && input.LA(1)<='\u0939')||(input.LA(1)>='\u093C' && input.LA(1)<='\u094D')||(input.LA(1)>='\u0950' && input.LA(1)<='\u0954')||(input.LA(1)>='\u0958' && input.LA(1)<='\u0963')||(input.LA(1)>='\u0966' && input.LA(1)<='\u096F')||(input.LA(1)>='\u097B' && input.LA(1)<='\u097F')||(input.LA(1)>='\u0981' && input.LA(1)<='\u0983')||(input.LA(1)>='\u0985' && input.LA(1)<='\u098C')||(input.LA(1)>='\u098F' && input.LA(1)<='\u0990')||(input.LA(1)>='\u0993' && input.LA(1)<='\u09A8')||(input.LA(1)>='\u09AA' && input.LA(1)<='\u09B0')||input.LA(1)=='\u09B2'||(input.LA(1)>='\u09B6' && input.LA(1)<='\u09B9')||(input.LA(1)>='\u09BC' && input.LA(1)<='\u09C4')||(input.LA(1)>='\u09C7' && input.LA(1)<='\u09C8')||(input.LA(1)>='\u09CB' && input.LA(1)<='\u09CE')||input.LA(1)=='\u09D7'||(input.LA(1)>='\u09DC' && input.LA(1)<='\u09DD')||(input.LA(1)>='\u09DF' && input.LA(1)<='\u09E3')||(input.LA(1)>='\u09E6' && input.LA(1)<='\u09F1')||(input.LA(1)>='\u0A01' && input.LA(1)<='\u0A03')||(input.LA(1)>='\u0A05' && input.LA(1)<='\u0A0A')||(input.LA(1)>='\u0A0F' && input.LA(1)<='\u0A10')||(input.LA(1)>='\u0A13' && input.LA(1)<='\u0A28')||(input.LA(1)>='\u0A2A' && input.LA(1)<='\u0A30')||(input.LA(1)>='\u0A32' && input.LA(1)<='\u0A33')||(input.LA(1)>='\u0A35' && input.LA(1)<='\u0A36')||(input.LA(1)>='\u0A38' && input.LA(1)<='\u0A39')||input.LA(1)=='\u0A3C'||(input.LA(1)>='\u0A3E' && input.LA(1)<='\u0A42')||(input.LA(1)>='\u0A47' && input.LA(1)<='\u0A48')||(input.LA(1)>='\u0A4B' && input.LA(1)<='\u0A4D')||(input.LA(1)>='\u0A59' && input.LA(1)<='\u0A5C')||input.LA(1)=='\u0A5E'||(input.LA(1)>='\u0A66' && input.LA(1)<='\u0A74')||(input.LA(1)>='\u0A81' && input.LA(1)<='\u0A83')||(input.LA(1)>='\u0A85' && input.LA(1)<='\u0A8D')||(input.LA(1)>='\u0A8F' && input.LA(1)<='\u0A91')||(input.LA(1)>='\u0A93' && input.LA(1)<='\u0AA8')||(input.LA(1)>='\u0AAA' && input.LA(1)<='\u0AB0')||(input.LA(1)>='\u0AB2' && input.LA(1)<='\u0AB3')||(input.LA(1)>='\u0AB5' && input.LA(1)<='\u0AB9')||(input.LA(1)>='\u0ABC' && input.LA(1)<='\u0AC5')||(input.LA(1)>='\u0AC7' && input.LA(1)<='\u0AC9')||(input.LA(1)>='\u0ACB' && input.LA(1)<='\u0ACD')||input.LA(1)=='\u0AD0'||(input.LA(1)>='\u0AE0' && input.LA(1)<='\u0AE3')||(input.LA(1)>='\u0AE6' && input.LA(1)<='\u0AEF')||(input.LA(1)>='\u0B01' && input.LA(1)<='\u0B03')||(input.LA(1)>='\u0B05' && input.LA(1)<='\u0B0C')||(input.LA(1)>='\u0B0F' && input.LA(1)<='\u0B10')||(input.LA(1)>='\u0B13' && input.LA(1)<='\u0B28')||(input.LA(1)>='\u0B2A' && input.LA(1)<='\u0B30')||(input.LA(1)>='\u0B32' && input.LA(1)<='\u0B33')||(input.LA(1)>='\u0B35' && input.LA(1)<='\u0B39')||(input.LA(1)>='\u0B3C' && input.LA(1)<='\u0B43')||(input.LA(1)>='\u0B47' && input.LA(1)<='\u0B48')||(input.LA(1)>='\u0B4B' && input.LA(1)<='\u0B4D')||(input.LA(1)>='\u0B56' && input.LA(1)<='\u0B57')||(input.LA(1)>='\u0B5C' && input.LA(1)<='\u0B5D')||(input.LA(1)>='\u0B5F' && input.LA(1)<='\u0B61')||(input.LA(1)>='\u0B66' && input.LA(1)<='\u0B6F')||input.LA(1)=='\u0B71'||(input.LA(1)>='\u0B82' && input.LA(1)<='\u0B83')||(input.LA(1)>='\u0B85' && input.LA(1)<='\u0B8A')||(input.LA(1)>='\u0B8E' && input.LA(1)<='\u0B90')||(input.LA(1)>='\u0B92' && input.LA(1)<='\u0B95')||(input.LA(1)>='\u0B99' && input.LA(1)<='\u0B9A')||input.LA(1)=='\u0B9C'||(input.LA(1)>='\u0B9E' && input.LA(1)<='\u0B9F')||(input.LA(1)>='\u0BA3' && input.LA(1)<='\u0BA4')||(input.LA(1)>='\u0BA8' && input.LA(1)<='\u0BAA')||(input.LA(1)>='\u0BAE' && input.LA(1)<='\u0BB9')||(input.LA(1)>='\u0BBE' && input.LA(1)<='\u0BC2')||(input.LA(1)>='\u0BC6' && input.LA(1)<='\u0BC8')||(input.LA(1)>='\u0BCA' && input.LA(1)<='\u0BCD')||input.LA(1)=='\u0BD7'||(input.LA(1)>='\u0BE6' && input.LA(1)<='\u0BEF')||(input.LA(1)>='\u0C01' && input.LA(1)<='\u0C03')||(input.LA(1)>='\u0C05' && input.LA(1)<='\u0C0C')||(input.LA(1)>='\u0C0E' && input.LA(1)<='\u0C10')||(input.LA(1)>='\u0C12' && input.LA(1)<='\u0C28')||(input.LA(1)>='\u0C2A' && input.LA(1)<='\u0C33')||(input.LA(1)>='\u0C35' && input.LA(1)<='\u0C39')||(input.LA(1)>='\u0C3E' && input.LA(1)<='\u0C44')||(input.LA(1)>='\u0C46' && input.LA(1)<='\u0C48')||(input.LA(1)>='\u0C4A' && input.LA(1)<='\u0C4D')||(input.LA(1)>='\u0C55' && input.LA(1)<='\u0C56')||(input.LA(1)>='\u0C60' && input.LA(1)<='\u0C61')||(input.LA(1)>='\u0C66' && input.LA(1)<='\u0C6F')||(input.LA(1)>='\u0C82' && input.LA(1)<='\u0C83')||(input.LA(1)>='\u0C85' && input.LA(1)<='\u0C8C')||(input.LA(1)>='\u0C8E' && input.LA(1)<='\u0C90')||(input.LA(1)>='\u0C92' && input.LA(1)<='\u0CA8')||(input.LA(1)>='\u0CAA' && input.LA(1)<='\u0CB3')||(input.LA(1)>='\u0CB5' && input.LA(1)<='\u0CB9')||(input.LA(1)>='\u0CBC' && input.LA(1)<='\u0CC4')||(input.LA(1)>='\u0CC6' && input.LA(1)<='\u0CC8')||(input.LA(1)>='\u0CCA' && input.LA(1)<='\u0CCD')||(input.LA(1)>='\u0CD5' && input.LA(1)<='\u0CD6')||input.LA(1)=='\u0CDE'||(input.LA(1)>='\u0CE0' && input.LA(1)<='\u0CE3')||(input.LA(1)>='\u0CE6' && input.LA(1)<='\u0CEF')||(input.LA(1)>='\u0D02' && input.LA(1)<='\u0D03')||(input.LA(1)>='\u0D05' && input.LA(1)<='\u0D0C')||(input.LA(1)>='\u0D0E' && input.LA(1)<='\u0D10')||(input.LA(1)>='\u0D12' && input.LA(1)<='\u0D28')||(input.LA(1)>='\u0D2A' && input.LA(1)<='\u0D39')||(input.LA(1)>='\u0D3E' && input.LA(1)<='\u0D43')||(input.LA(1)>='\u0D46' && input.LA(1)<='\u0D48')||(input.LA(1)>='\u0D4A' && input.LA(1)<='\u0D4D')||input.LA(1)=='\u0D57'||(input.LA(1)>='\u0D60' && input.LA(1)<='\u0D61')||(input.LA(1)>='\u0D66' && input.LA(1)<='\u0D6F')||(input.LA(1)>='\u0D82' && input.LA(1)<='\u0D83')||(input.LA(1)>='\u0D85' && input.LA(1)<='\u0D96')||(input.LA(1)>='\u0D9A' && input.LA(1)<='\u0DB1')||(input.LA(1)>='\u0DB3' && input.LA(1)<='\u0DBB')||input.LA(1)=='\u0DBD'||(input.LA(1)>='\u0DC0' && input.LA(1)<='\u0DC6')||input.LA(1)=='\u0DCA'||(input.LA(1)>='\u0DCF' && input.LA(1)<='\u0DD4')||input.LA(1)=='\u0DD6'||(input.LA(1)>='\u0DD8' && input.LA(1)<='\u0DDF')||(input.LA(1)>='\u0DF2' && input.LA(1)<='\u0DF3')||(input.LA(1)>='\u0E01' && input.LA(1)<='\u0E3A')||(input.LA(1)>='\u0E40' && input.LA(1)<='\u0E4E')||(input.LA(1)>='\u0E50' && input.LA(1)<='\u0E59')||(input.LA(1)>='\u0E81' && input.LA(1)<='\u0E82')||input.LA(1)=='\u0E84'||(input.LA(1)>='\u0E87' && input.LA(1)<='\u0E88')||input.LA(1)=='\u0E8A'||input.LA(1)=='\u0E8D'||(input.LA(1)>='\u0E94' && input.LA(1)<='\u0E97')||(input.LA(1)>='\u0E99' && input.LA(1)<='\u0E9F')||(input.LA(1)>='\u0EA1' && input.LA(1)<='\u0EA3')||input.LA(1)=='\u0EA5'||input.LA(1)=='\u0EA7'||(input.LA(1)>='\u0EAA' && input.LA(1)<='\u0EAB')||(input.LA(1)>='\u0EAD' && input.LA(1)<='\u0EB9')||(input.LA(1)>='\u0EBB' && input.LA(1)<='\u0EBD')||(input.LA(1)>='\u0EC0' && input.LA(1)<='\u0EC4')||input.LA(1)=='\u0EC6'||(input.LA(1)>='\u0EC8' && input.LA(1)<='\u0ECD')||(input.LA(1)>='\u0ED0' && input.LA(1)<='\u0ED9')||(input.LA(1)>='\u0EDC' && input.LA(1)<='\u0EDD')||input.LA(1)=='\u0F00'||(input.LA(1)>='\u0F18' && input.LA(1)<='\u0F19')||(input.LA(1)>='\u0F20' && input.LA(1)<='\u0F29')||input.LA(1)=='\u0F35'||input.LA(1)=='\u0F37'||input.LA(1)=='\u0F39'||(input.LA(1)>='\u0F3E' && input.LA(1)<='\u0F47')||(input.LA(1)>='\u0F49' && input.LA(1)<='\u0F6A')||(input.LA(1)>='\u0F71' && input.LA(1)<='\u0F84')||(input.LA(1)>='\u0F86' && input.LA(1)<='\u0F8B')||(input.LA(1)>='\u0F90' && input.LA(1)<='\u0F97')||(input.LA(1)>='\u0F99' && input.LA(1)<='\u0FBC')||input.LA(1)=='\u0FC6'||(input.LA(1)>='\u1000' && input.LA(1)<='\u1021')||(input.LA(1)>='\u1023' && input.LA(1)<='\u1027')||(input.LA(1)>='\u1029' && input.LA(1)<='\u102A')||(input.LA(1)>='\u102C' && input.LA(1)<='\u1032')||(input.LA(1)>='\u1036' && input.LA(1)<='\u1039')||(input.LA(1)>='\u1040' && input.LA(1)<='\u1049')||(input.LA(1)>='\u1050' && input.LA(1)<='\u1059')||(input.LA(1)>='\u10A0' && input.LA(1)<='\u10C5')||(input.LA(1)>='\u10D0' && input.LA(1)<='\u10FA')||input.LA(1)=='\u10FC'||(input.LA(1)>='\u1100' && input.LA(1)<='\u1159')||(input.LA(1)>='\u115F' && input.LA(1)<='\u11A2')||(input.LA(1)>='\u11A8' && input.LA(1)<='\u11F9')||(input.LA(1)>='\u1200' && input.LA(1)<='\u1248')||(input.LA(1)>='\u124A' && input.LA(1)<='\u124D')||(input.LA(1)>='\u1250' && input.LA(1)<='\u1256')||input.LA(1)=='\u1258'||(input.LA(1)>='\u125A' && input.LA(1)<='\u125D')||(input.LA(1)>='\u1260' && input.LA(1)<='\u1288')||(input.LA(1)>='\u128A' && input.LA(1)<='\u128D')||(input.LA(1)>='\u1290' && input.LA(1)<='\u12B0')||(input.LA(1)>='\u12B2' && input.LA(1)<='\u12B5')||(input.LA(1)>='\u12B8' && input.LA(1)<='\u12BE')||input.LA(1)=='\u12C0'||(input.LA(1)>='\u12C2' && input.LA(1)<='\u12C5')||(input.LA(1)>='\u12C8' && input.LA(1)<='\u12D6')||(input.LA(1)>='\u12D8' && input.LA(1)<='\u1310')||(input.LA(1)>='\u1312' && input.LA(1)<='\u1315')||(input.LA(1)>='\u1318' && input.LA(1)<='\u135A')||input.LA(1)=='\u135F'||(input.LA(1)>='\u1380' && input.LA(1)<='\u138F')||(input.LA(1)>='\u13A0' && input.LA(1)<='\u13F4')||(input.LA(1)>='\u1401' && input.LA(1)<='\u166C')||(input.LA(1)>='\u166F' && input.LA(1)<='\u1676')||(input.LA(1)>='\u1681' && input.LA(1)<='\u169A')||(input.LA(1)>='\u16A0' && input.LA(1)<='\u16EA')||(input.LA(1)>='\u16EE' && input.LA(1)<='\u16F0')||(input.LA(1)>='\u1700' && input.LA(1)<='\u170C')||(input.LA(1)>='\u170E' && input.LA(1)<='\u1714')||(input.LA(1)>='\u1720' && input.LA(1)<='\u1734')||(input.LA(1)>='\u1740' && input.LA(1)<='\u1753')||(input.LA(1)>='\u1760' && input.LA(1)<='\u176C')||(input.LA(1)>='\u176E' && input.LA(1)<='\u1770')||(input.LA(1)>='\u1772' && input.LA(1)<='\u1773')||(input.LA(1)>='\u1780' && input.LA(1)<='\u17D3')||input.LA(1)=='\u17D7'||(input.LA(1)>='\u17DC' && input.LA(1)<='\u17DD')||(input.LA(1)>='\u17E0' && input.LA(1)<='\u17E9')||(input.LA(1)>='\u180B' && input.LA(1)<='\u180D')||(input.LA(1)>='\u1810' && input.LA(1)<='\u1819')||(input.LA(1)>='\u1820' && input.LA(1)<='\u1877')||(input.LA(1)>='\u1880' && input.LA(1)<='\u18A9')||(input.LA(1)>='\u1900' && input.LA(1)<='\u191C')||(input.LA(1)>='\u1920' && input.LA(1)<='\u192B')||(input.LA(1)>='\u1930' && input.LA(1)<='\u193B')||(input.LA(1)>='\u1946' && input.LA(1)<='\u196D')||(input.LA(1)>='\u1970' && input.LA(1)<='\u1974')||(input.LA(1)>='\u1980' && input.LA(1)<='\u19A9')||(input.LA(1)>='\u19B0' && input.LA(1)<='\u19C9')||(input.LA(1)>='\u19D0' && input.LA(1)<='\u19D9')||(input.LA(1)>='\u1A00' && input.LA(1)<='\u1A1B')||(input.LA(1)>='\u1B00' && input.LA(1)<='\u1B4B')||(input.LA(1)>='\u1B50' && input.LA(1)<='\u1B59')||(input.LA(1)>='\u1B6B' && input.LA(1)<='\u1B73')||(input.LA(1)>='\u1D00' && input.LA(1)<='\u1DCA')||(input.LA(1)>='\u1DFE' && input.LA(1)<='\u1E9B')||(input.LA(1)>='\u1EA0' && input.LA(1)<='\u1EF9')||(input.LA(1)>='\u1F00' && input.LA(1)<='\u1F15')||(input.LA(1)>='\u1F18' && input.LA(1)<='\u1F1D')||(input.LA(1)>='\u1F20' && input.LA(1)<='\u1F45')||(input.LA(1)>='\u1F48' && input.LA(1)<='\u1F4D')||(input.LA(1)>='\u1F50' && input.LA(1)<='\u1F57')||input.LA(1)=='\u1F59'||input.LA(1)=='\u1F5B'||input.LA(1)=='\u1F5D'||(input.LA(1)>='\u1F5F' && input.LA(1)<='\u1F7D')||(input.LA(1)>='\u1F80' && input.LA(1)<='\u1FB4')||(input.LA(1)>='\u1FB6' && input.LA(1)<='\u1FBC')||input.LA(1)=='\u1FBE'||(input.LA(1)>='\u1FC2' && input.LA(1)<='\u1FC4')||(input.LA(1)>='\u1FC6' && input.LA(1)<='\u1FCC')||(input.LA(1)>='\u1FD0' && input.LA(1)<='\u1FD3')||(input.LA(1)>='\u1FD6' && input.LA(1)<='\u1FDB')||(input.LA(1)>='\u1FE0' && input.LA(1)<='\u1FEC')||(input.LA(1)>='\u1FF2' && input.LA(1)<='\u1FF4')||(input.LA(1)>='\u1FF6' && input.LA(1)<='\u1FFC')||(input.LA(1)>='\u200B' && input.LA(1)<='\u200F')||(input.LA(1)>='\u202A' && input.LA(1)<='\u202E')||(input.LA(1)>='\u203F' && input.LA(1)<='\u2040')||input.LA(1)=='\u2054'||(input.LA(1)>='\u2060' && input.LA(1)<='\u2063')||(input.LA(1)>='\u206A' && input.LA(1)<='\u206F')||input.LA(1)=='\u2071'||input.LA(1)=='\u207F'||(input.LA(1)>='\u2090' && input.LA(1)<='\u2094')||(input.LA(1)>='\u20D0' && input.LA(1)<='\u20DC')||input.LA(1)=='\u20E1'||(input.LA(1)>='\u20E5' && input.LA(1)<='\u20EF')||input.LA(1)=='\u2102'||input.LA(1)=='\u2107'||(input.LA(1)>='\u210A' && input.LA(1)<='\u2113')||input.LA(1)=='\u2115'||(input.LA(1)>='\u2119' && input.LA(1)<='\u211D')||input.LA(1)=='\u2124'||input.LA(1)=='\u2126'||input.LA(1)=='\u2128'||(input.LA(1)>='\u212A' && input.LA(1)<='\u212D')||(input.LA(1)>='\u212F' && input.LA(1)<='\u2139')||(input.LA(1)>='\u213C' && input.LA(1)<='\u213F')||(input.LA(1)>='\u2145' && input.LA(1)<='\u2149')||input.LA(1)=='\u214E'||(input.LA(1)>='\u2160' && input.LA(1)<='\u2184')||(input.LA(1)>='\u2C00' && input.LA(1)<='\u2C2E')||(input.LA(1)>='\u2C30' && input.LA(1)<='\u2C5E')||(input.LA(1)>='\u2C60' && input.LA(1)<='\u2C6C')||(input.LA(1)>='\u2C74' && input.LA(1)<='\u2C77')||(input.LA(1)>='\u2C80' && input.LA(1)<='\u2CE4')||(input.LA(1)>='\u2D00' && input.LA(1)<='\u2D25')||(input.LA(1)>='\u2D30' && input.LA(1)<='\u2D65')||input.LA(1)=='\u2D6F'||(input.LA(1)>='\u2D80' && input.LA(1)<='\u2D96')||(input.LA(1)>='\u2DA0' && input.LA(1)<='\u2DA6')||(input.LA(1)>='\u2DA8' && input.LA(1)<='\u2DAE')||(input.LA(1)>='\u2DB0' && input.LA(1)<='\u2DB6')||(input.LA(1)>='\u2DB8' && input.LA(1)<='\u2DBE')||(input.LA(1)>='\u2DC0' && input.LA(1)<='\u2DC6')||(input.LA(1)>='\u2DC8' && input.LA(1)<='\u2DCE')||(input.LA(1)>='\u2DD0' && input.LA(1)<='\u2DD6')||(input.LA(1)>='\u2DD8' && input.LA(1)<='\u2DDE')||(input.LA(1)>='\u3005' && input.LA(1)<='\u3007')||(input.LA(1)>='\u3021' && input.LA(1)<='\u302F')||(input.LA(1)>='\u3031' && input.LA(1)<='\u3035')||(input.LA(1)>='\u3038' && input.LA(1)<='\u303C')||(input.LA(1)>='\u3041' && input.LA(1)<='\u3096')||(input.LA(1)>='\u3099' && input.LA(1)<='\u309A')||(input.LA(1)>='\u309D' && input.LA(1)<='\u309F')||(input.LA(1)>='\u30A1' && input.LA(1)<='\u30FA')||(input.LA(1)>='\u30FC' && input.LA(1)<='\u30FF')||(input.LA(1)>='\u3105' && input.LA(1)<='\u312C')||(input.LA(1)>='\u3131' && input.LA(1)<='\u318E')||(input.LA(1)>='\u31A0' && input.LA(1)<='\u31B7')||(input.LA(1)>='\u31F0' && input.LA(1)<='\u31FF')||(input.LA(1)>='\u3400' && input.LA(1)<='\u4DB5')||(input.LA(1)>='\u4E00' && input.LA(1)<='\u9FBB')||(input.LA(1)>='\uA000' && input.LA(1)<='\uA48C')||(input.LA(1)>='\uA717' && input.LA(1)<='\uA71A')||(input.LA(1)>='\uA800' && input.LA(1)<='\uA827')||(input.LA(1)>='\uA840' && input.LA(1)<='\uA873')||(input.LA(1)>='\uAC00' && input.LA(1)<='\uD7A3')||(input.LA(1)>='\uF900' && input.LA(1)<='\uFA2D')||(input.LA(1)>='\uFA30' && input.LA(1)<='\uFA6A')||(input.LA(1)>='\uFA70' && input.LA(1)<='\uFAD9')||(input.LA(1)>='\uFB00' && input.LA(1)<='\uFB06')||(input.LA(1)>='\uFB13' && input.LA(1)<='\uFB17')||(input.LA(1)>='\uFB1D' && input.LA(1)<='\uFB28')||(input.LA(1)>='\uFB2A' && input.LA(1)<='\uFB36')||(input.LA(1)>='\uFB38' && input.LA(1)<='\uFB3C')||input.LA(1)=='\uFB3E'||(input.LA(1)>='\uFB40' && input.LA(1)<='\uFB41')||(input.LA(1)>='\uFB43' && input.LA(1)<='\uFB44')||(input.LA(1)>='\uFB46' && input.LA(1)<='\uFBB1')||(input.LA(1)>='\uFBD3' && input.LA(1)<='\uFD3D')||(input.LA(1)>='\uFD50' && input.LA(1)<='\uFD8F')||(input.LA(1)>='\uFD92' && input.LA(1)<='\uFDC7')||(input.LA(1)>='\uFDF0' && input.LA(1)<='\uFDFB')||(input.LA(1)>='\uFE00' && input.LA(1)<='\uFE0F')||(input.LA(1)>='\uFE20' && input.LA(1)<='\uFE23')||(input.LA(1)>='\uFE33' && input.LA(1)<='\uFE34')||(input.LA(1)>='\uFE4D' && input.LA(1)<='\uFE4F')||(input.LA(1)>='\uFE70' && input.LA(1)<='\uFE74')||(input.LA(1)>='\uFE76' && input.LA(1)<='\uFEFC')||input.LA(1)=='\uFEFF'||(input.LA(1)>='\uFF10' && input.LA(1)<='\uFF19')||(input.LA(1)>='\uFF21' && input.LA(1)<='\uFF3A')||input.LA(1)=='\uFF3F'||(input.LA(1)>='\uFF41' && input.LA(1)<='\uFF5A')||(input.LA(1)>='\uFF66' && input.LA(1)<='\uFFBE')||(input.LA(1)>='\uFFC2' && input.LA(1)<='\uFFC7')||(input.LA(1)>='\uFFCA' && input.LA(1)<='\uFFCF')||(input.LA(1)>='\uFFD2' && input.LA(1)<='\uFFD7')||(input.LA(1)>='\uFFDA' && input.LA(1)<='\uFFDC')||(input.LA(1)>='\uFFF9' && input.LA(1)<='\uFFFB') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "JavaIdentifierPart"

    // $ANTLR start "Other"
    public final void mOther() throws RecognitionException {
        try {
            int _type = Other;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:301:2: ( . )
            // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:301:4: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Other"

    public void mTokens() throws RecognitionException {
        // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:1:8: ( SingleLineComment | MultiLineComment | StringLiteral | CalloutNum | ToggleHighlight | Operator | SpecialIdentifier | JavaIdentifier | Other )
        int alt7=9;
        alt7 = dfa7.predict(input);
        switch (alt7) {
            case 1 :
                // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:1:10: SingleLineComment
                {
                mSingleLineComment(); 

                }
                break;
            case 2 :
                // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:1:28: MultiLineComment
                {
                mMultiLineComment(); 

                }
                break;
            case 3 :
                // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:1:45: StringLiteral
                {
                mStringLiteral(); 

                }
                break;
            case 4 :
                // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:1:59: CalloutNum
                {
                mCalloutNum(); 

                }
                break;
            case 5 :
                // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:1:70: ToggleHighlight
                {
                mToggleHighlight(); 

                }
                break;
            case 6 :
                // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:1:86: Operator
                {
                mOperator(); 

                }
                break;
            case 7 :
                // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:1:95: SpecialIdentifier
                {
                mSpecialIdentifier(); 

                }
                break;
            case 8 :
                // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:1:113: JavaIdentifier
                {
                mJavaIdentifier(); 

                }
                break;
            case 9 :
                // C:\\javadude.com\\src\\com\\javadude\\javamage\\javahighlight\\JavaHighlight.g:1:128: Other
                {
                mOther(); 

                }
                break;

        }

    }


    protected DFA5 dfa5 = new DFA5(this);
    protected DFA7 dfa7 = new DFA7(this);
    static final String DFA5_eotS =
        "\1\1\1\uffff\1\35\35\uffff";
    static final String DFA5_eofS =
        "\40\uffff";
    static final String DFA5_minS =
        "\1\41\1\uffff\1\141\27\uffff\1\155\5\uffff";
    static final String DFA5_maxS =
        "\1\176\1\uffff\1\161\27\uffff\1\160\5\uffff";
    static final String DFA5_acceptS =
        "\1\uffff\1\35\1\uffff\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16"+
        "\1\17\1\20\1\21\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34"+
        "\1\1\1\uffff\1\3\1\4\1\22\1\2\1\5";
    static final String DFA5_specialS =
        "\40\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\6\3\uffff\1\11\1\2\1\uffff\1\23\1\24\1\7\1\3\1\uffff\1\4"+
            "\1\15\1\10\12\uffff\1\22\1\16\1\12\1\14\1\13\1\21\33\uffff\1"+
            "\25\1\uffff\1\26\1\17\34\uffff\1\27\1\20\1\30\1\5",
            "",
            "\1\32\5\uffff\1\34\4\uffff\1\31\4\uffff\1\33",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\37\2\uffff\1\36",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "()+ loopback of 51:4: ( '&lt;' | '&apos;' | '&quot;' | '&gt;' | '&amp;' | '+' | '-' | '~' | '!' | '*' | '/' | '%' | '<' | '>' | '=' | '.' | ';' | '&' | '^' | '|' | '?' | ':' | '(' | ')' | '[' | ']' | '{' | '}' )+";
        }
    }
    static final String DFA7_eotS =
        "\1\uffff\1\37\1\34\1\42\26\uffff\1\34\2\uffff\1\46\1\37\6\uffff"+
        "\1\46\1\uffff\26\46\27\37\1\uffff\4\46\4\uffff\1\124\5\46\5\uffff"+
        "\5\46\1\37\3\uffff\1\37\3\46\1\uffff\1\37\1\uffff\2\46\2\37";
    static final String DFA7_eofS =
        "\174\uffff";
    static final String DFA7_minS =
        "\1\0\1\52\1\0\1\140\26\uffff\1\101\2\uffff\1\41\1\0\6\uffff\1\41"+
        "\1\uffff\26\41\27\0\1\uffff\1\164\1\155\1\165\1\164\4\0\1\41\1\73"+
        "\1\157\1\160\1\157\1\73\5\0\1\41\1\163\1\73\1\164\1\41\5\0\1\73"+
        "\1\41\1\73\3\0\2\41\2\0";
    static final String DFA7_maxS =
        "\1\uffff\1\57\1\uffff\1\140\26\uffff\1\uffdc\2\uffff\1\176\1\uffff"+
        "\6\uffff\1\176\1\uffff\26\176\27\uffff\1\uffff\1\164\1\160\1\165"+
        "\1\164\4\uffff\1\176\1\73\1\157\1\160\1\157\1\73\5\uffff\1\176\1"+
        "\163\1\73\1\164\1\176\5\uffff\1\73\1\176\1\73\3\uffff\2\176\2\uffff";
    static final String DFA7_acceptS =
        "\4\uffff\26\6\1\uffff\1\10\1\11\2\uffff\1\6\1\3\1\5\1\4\1\7\1\10"+
        "\1\uffff\1\1\55\uffff\1\2\47\uffff";
    static final String DFA7_specialS =
        "\1\16\1\uffff\1\2\33\uffff\1\54\36\uffff\1\22\1\35\1\34\1\33\1"+
        "\32\1\53\1\31\1\30\1\26\1\25\1\24\1\23\1\44\1\45\1\46\1\47\1\50"+
        "\1\51\1\52\1\40\1\41\1\42\1\43\5\uffff\1\7\1\27\1\15\1\3\6\uffff"+
        "\1\6\1\10\1\5\1\13\1\1\5\uffff\1\21\1\11\1\4\1\14\1\37\3\uffff\1"+
        "\12\1\36\1\0\2\uffff\1\20\1\17}>";
    static final String[] DFA7_transitionS = {
            "\41\34\1\10\1\2\1\34\1\32\1\12\1\4\1\34\1\24\1\25\1\11\1\5"+
            "\1\34\1\6\1\16\1\1\12\34\1\23\1\17\1\13\1\15\1\14\1\22\1\32"+
            "\32\33\1\26\1\34\1\27\1\20\1\33\1\3\32\33\1\30\1\21\1\31\1\7"+
            "\53\34\1\33\12\34\1\33\4\34\1\33\5\34\27\33\1\34\37\33\1\34"+
            "\u01ca\33\4\34\14\33\16\34\5\33\11\34\1\33\u008b\34\4\33\10"+
            "\34\1\33\1\34\3\33\1\34\1\33\1\34\24\33\1\34\54\33\1\34\46\33"+
            "\1\34\u008b\33\10\34\u008a\33\35\34\46\33\2\34\1\33\7\34\47"+
            "\33\110\34\33\33\5\34\3\33\56\34\32\33\5\34\13\33\43\34\2\33"+
            "\1\34\143\33\1\34\1\33\17\34\2\33\7\34\2\33\12\34\3\33\2\34"+
            "\1\33\20\34\1\33\1\34\36\33\35\34\41\33\22\34\46\33\13\34\1"+
            "\33\30\34\41\33\11\34\2\33\4\34\1\33\u0109\34\66\33\3\34\1\33"+
            "\22\34\1\33\7\34\12\33\31\34\5\33\5\34\10\33\2\34\2\33\2\34"+
            "\26\33\1\34\7\33\1\34\1\33\3\34\4\33\3\34\1\33\20\34\1\33\15"+
            "\34\2\33\1\34\3\33\16\34\2\33\23\34\6\33\4\34\2\33\2\34\26\33"+
            "\1\34\7\33\1\34\2\33\1\34\2\33\1\34\2\33\37\34\4\33\1\34\1\33"+
            "\23\34\3\33\20\34\11\33\1\34\3\33\1\34\26\33\1\34\7\33\1\34"+
            "\2\33\1\34\5\33\3\34\1\33\22\34\1\33\17\34\2\33\43\34\10\33"+
            "\2\34\2\33\2\34\26\33\1\34\7\33\1\34\2\33\1\34\5\33\3\34\1\33"+
            "\36\34\2\33\1\34\3\33\17\34\1\33\21\34\1\33\1\34\6\33\3\34\3"+
            "\33\1\34\4\33\3\34\2\33\1\34\1\33\1\34\2\33\3\34\2\33\3\34\3"+
            "\33\3\34\14\33\113\34\10\33\1\34\3\33\1\34\27\33\1\34\12\33"+
            "\1\34\5\33\46\34\2\33\43\34\10\33\1\34\3\33\1\34\27\33\1\34"+
            "\12\33\1\34\5\33\3\34\1\33\40\34\1\33\1\34\2\33\43\34\10\33"+
            "\1\34\3\33\1\34\27\33\1\34\20\33\46\34\2\33\43\34\22\33\3\34"+
            "\30\33\1\34\11\33\1\34\1\33\2\34\7\33\72\34\60\33\1\34\2\33"+
            "\14\34\7\33\72\34\2\33\1\34\1\33\2\34\2\33\1\34\1\33\2\34\1"+
            "\33\6\34\4\33\1\34\7\33\1\34\3\33\1\34\1\33\1\34\1\33\2\34\2"+
            "\33\1\34\4\33\1\34\2\33\11\34\1\33\2\34\5\33\1\34\1\33\25\34"+
            "\2\33\42\34\1\33\77\34\10\33\1\34\42\33\35\34\4\33\164\34\42"+
            "\33\1\34\5\33\1\34\2\33\45\34\6\33\112\34\46\33\12\34\53\33"+
            "\1\34\1\33\3\34\132\33\5\34\104\33\5\34\122\33\6\34\111\33\1"+
            "\34\4\33\2\34\7\33\1\34\1\33\1\34\4\33\2\34\51\33\1\34\4\33"+
            "\2\34\41\33\1\34\4\33\2\34\7\33\1\34\1\33\1\34\4\33\2\34\17"+
            "\33\1\34\71\33\1\34\4\33\2\34\103\33\45\34\20\33\20\34\125\33"+
            "\14\34\u026c\33\2\34\10\33\12\34\32\33\5\34\113\33\3\34\3\33"+
            "\17\34\15\33\1\34\4\33\16\34\22\33\16\34\22\33\16\34\15\33\1"+
            "\34\3\33\17\34\64\33\43\34\1\33\4\34\1\33\103\34\130\33\10\34"+
            "\51\33\127\34\35\33\63\34\36\33\2\34\5\33\13\34\52\33\27\34"+
            "\7\33\70\34\27\33\u00ee\34\57\33\21\34\7\33\u01b4\34\u00c0\33"+
            "\100\34\u009c\33\4\34\132\33\6\34\26\33\2\34\6\33\2\34\46\33"+
            "\2\34\6\33\2\34\10\33\1\34\1\33\1\34\1\33\1\34\1\33\1\34\37"+
            "\33\2\34\65\33\1\34\7\33\1\34\1\33\3\34\3\33\1\34\7\33\3\34"+
            "\4\33\2\34\6\33\4\34\15\33\5\34\3\33\1\34\7\33\164\34\1\33\15"+
            "\34\1\33\20\34\5\33\155\34\1\33\4\34\1\33\2\34\12\33\1\34\1"+
            "\33\3\34\5\33\6\34\1\33\1\34\1\33\1\34\1\33\1\34\4\33\1\34\13"+
            "\33\2\34\4\33\5\34\5\33\4\34\1\33\21\34\45\33\u0a7b\34\57\33"+
            "\1\34\57\33\1\34\15\33\7\34\4\33\10\34\145\33\33\34\46\33\12"+
            "\34\66\33\11\34\1\33\20\34\27\33\11\34\7\33\1\34\7\33\1\34\7"+
            "\33\1\34\7\33\1\34\7\33\1\34\7\33\1\34\7\33\1\34\7\33\u0226"+
            "\34\3\33\31\34\11\33\7\34\5\33\2\34\5\33\4\34\126\33\6\34\3"+
            "\33\1\34\132\33\1\34\4\33\5\34\50\33\4\34\136\33\21\34\30\33"+
            "\70\34\20\33\u0200\34\u19b6\33\112\34\u51bc\33\104\34\u048d"+
            "\33\u028a\34\4\33\u00e5\34\2\33\1\34\3\33\1\34\4\33\1\34\27"+
            "\33\35\34\64\33\u038c\34\u2ba4\33\u215c\34\u012e\33\2\34\73"+
            "\33\5\34\152\33\46\34\7\33\14\34\5\33\5\34\1\33\1\34\12\33\1"+
            "\34\15\33\1\34\5\33\1\34\1\33\1\34\2\33\1\34\2\33\1\34\154\33"+
            "\41\34\u016b\33\22\34\100\33\2\34\66\33\50\34\14\33\164\34\5"+
            "\33\1\34\u0087\33\44\34\32\33\6\34\32\33\13\34\131\33\3\34\6"+
            "\33\2\34\6\33\2\34\6\33\2\34\3\33\43\34",
            "\1\36\4\uffff\1\35",
            "\12\40\1\uffff\2\40\1\uffff\ufff2\40",
            "\1\41",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\32\43\4\uffff\1\43\1\uffff\32\43\57\uffff\1\43\12\uffff\1"+
            "\43\4\uffff\1\43\5\uffff\27\43\1\uffff\37\43\1\uffff\u01ca\43"+
            "\4\uffff\14\43\16\uffff\5\43\11\uffff\1\43\u008b\uffff\4\43"+
            "\10\uffff\1\43\1\uffff\3\43\1\uffff\1\43\1\uffff\24\43\1\uffff"+
            "\54\43\1\uffff\46\43\1\uffff\u008b\43\10\uffff\u008a\43\35\uffff"+
            "\46\43\2\uffff\1\43\7\uffff\47\43\110\uffff\33\43\5\uffff\3"+
            "\43\56\uffff\32\43\5\uffff\13\43\43\uffff\2\43\1\uffff\143\43"+
            "\1\uffff\1\43\17\uffff\2\43\7\uffff\2\43\12\uffff\3\43\2\uffff"+
            "\1\43\20\uffff\1\43\1\uffff\36\43\35\uffff\41\43\22\uffff\46"+
            "\43\13\uffff\1\43\30\uffff\41\43\11\uffff\2\43\4\uffff\1\43"+
            "\u0109\uffff\66\43\3\uffff\1\43\22\uffff\1\43\7\uffff\12\43"+
            "\31\uffff\5\43\5\uffff\10\43\2\uffff\2\43\2\uffff\26\43\1\uffff"+
            "\7\43\1\uffff\1\43\3\uffff\4\43\3\uffff\1\43\20\uffff\1\43\15"+
            "\uffff\2\43\1\uffff\3\43\16\uffff\2\43\23\uffff\6\43\4\uffff"+
            "\2\43\2\uffff\26\43\1\uffff\7\43\1\uffff\2\43\1\uffff\2\43\1"+
            "\uffff\2\43\37\uffff\4\43\1\uffff\1\43\23\uffff\3\43\20\uffff"+
            "\11\43\1\uffff\3\43\1\uffff\26\43\1\uffff\7\43\1\uffff\2\43"+
            "\1\uffff\5\43\3\uffff\1\43\22\uffff\1\43\17\uffff\2\43\43\uffff"+
            "\10\43\2\uffff\2\43\2\uffff\26\43\1\uffff\7\43\1\uffff\2\43"+
            "\1\uffff\5\43\3\uffff\1\43\36\uffff\2\43\1\uffff\3\43\17\uffff"+
            "\1\43\21\uffff\1\43\1\uffff\6\43\3\uffff\3\43\1\uffff\4\43\3"+
            "\uffff\2\43\1\uffff\1\43\1\uffff\2\43\3\uffff\2\43\3\uffff\3"+
            "\43\3\uffff\14\43\113\uffff\10\43\1\uffff\3\43\1\uffff\27\43"+
            "\1\uffff\12\43\1\uffff\5\43\46\uffff\2\43\43\uffff\10\43\1\uffff"+
            "\3\43\1\uffff\27\43\1\uffff\12\43\1\uffff\5\43\3\uffff\1\43"+
            "\40\uffff\1\43\1\uffff\2\43\43\uffff\10\43\1\uffff\3\43\1\uffff"+
            "\27\43\1\uffff\20\43\46\uffff\2\43\43\uffff\22\43\3\uffff\30"+
            "\43\1\uffff\11\43\1\uffff\1\43\2\uffff\7\43\72\uffff\60\43\1"+
            "\uffff\2\43\14\uffff\7\43\72\uffff\2\43\1\uffff\1\43\2\uffff"+
            "\2\43\1\uffff\1\43\2\uffff\1\43\6\uffff\4\43\1\uffff\7\43\1"+
            "\uffff\3\43\1\uffff\1\43\1\uffff\1\43\2\uffff\2\43\1\uffff\4"+
            "\43\1\uffff\2\43\11\uffff\1\43\2\uffff\5\43\1\uffff\1\43\25"+
            "\uffff\2\43\42\uffff\1\43\77\uffff\10\43\1\uffff\42\43\35\uffff"+
            "\4\43\164\uffff\42\43\1\uffff\5\43\1\uffff\2\43\45\uffff\6\43"+
            "\112\uffff\46\43\12\uffff\53\43\1\uffff\1\43\3\uffff\132\43"+
            "\5\uffff\104\43\5\uffff\122\43\6\uffff\111\43\1\uffff\4\43\2"+
            "\uffff\7\43\1\uffff\1\43\1\uffff\4\43\2\uffff\51\43\1\uffff"+
            "\4\43\2\uffff\41\43\1\uffff\4\43\2\uffff\7\43\1\uffff\1\43\1"+
            "\uffff\4\43\2\uffff\17\43\1\uffff\71\43\1\uffff\4\43\2\uffff"+
            "\103\43\45\uffff\20\43\20\uffff\125\43\14\uffff\u026c\43\2\uffff"+
            "\10\43\12\uffff\32\43\5\uffff\113\43\3\uffff\3\43\17\uffff\15"+
            "\43\1\uffff\4\43\16\uffff\22\43\16\uffff\22\43\16\uffff\15\43"+
            "\1\uffff\3\43\17\uffff\64\43\43\uffff\1\43\4\uffff\1\43\103"+
            "\uffff\130\43\10\uffff\51\43\127\uffff\35\43\63\uffff\36\43"+
            "\2\uffff\5\43\13\uffff\52\43\27\uffff\7\43\70\uffff\27\43\u00ee"+
            "\uffff\57\43\21\uffff\7\43\u01b4\uffff\u00c0\43\100\uffff\u009c"+
            "\43\4\uffff\132\43\6\uffff\26\43\2\uffff\6\43\2\uffff\46\43"+
            "\2\uffff\6\43\2\uffff\10\43\1\uffff\1\43\1\uffff\1\43\1\uffff"+
            "\1\43\1\uffff\37\43\2\uffff\65\43\1\uffff\7\43\1\uffff\1\43"+
            "\3\uffff\3\43\1\uffff\7\43\3\uffff\4\43\2\uffff\6\43\4\uffff"+
            "\15\43\5\uffff\3\43\1\uffff\7\43\164\uffff\1\43\15\uffff\1\43"+
            "\20\uffff\5\43\155\uffff\1\43\4\uffff\1\43\2\uffff\12\43\1\uffff"+
            "\1\43\3\uffff\5\43\6\uffff\1\43\1\uffff\1\43\1\uffff\1\43\1"+
            "\uffff\4\43\1\uffff\13\43\2\uffff\4\43\5\uffff\5\43\4\uffff"+
            "\1\43\21\uffff\45\43\u0a7b\uffff\57\43\1\uffff\57\43\1\uffff"+
            "\15\43\7\uffff\4\43\10\uffff\145\43\33\uffff\46\43\12\uffff"+
            "\66\43\11\uffff\1\43\20\uffff\27\43\11\uffff\7\43\1\uffff\7"+
            "\43\1\uffff\7\43\1\uffff\7\43\1\uffff\7\43\1\uffff\7\43\1\uffff"+
            "\7\43\1\uffff\7\43\u0226\uffff\3\43\31\uffff\11\43\7\uffff\5"+
            "\43\2\uffff\5\43\4\uffff\126\43\6\uffff\3\43\1\uffff\132\43"+
            "\1\uffff\4\43\5\uffff\50\43\4\uffff\136\43\21\uffff\30\43\70"+
            "\uffff\20\43\u0200\uffff\u19b6\43\112\uffff\u51bc\43\104\uffff"+
            "\u048d\43\u028a\uffff\4\43\u00e5\uffff\2\43\1\uffff\3\43\1\uffff"+
            "\4\43\1\uffff\27\43\35\uffff\64\43\u038c\uffff\u2ba4\43\u215c"+
            "\uffff\u012e\43\2\uffff\73\43\5\uffff\152\43\46\uffff\7\43\14"+
            "\uffff\5\43\5\uffff\1\43\1\uffff\12\43\1\uffff\15\43\1\uffff"+
            "\5\43\1\uffff\1\43\1\uffff\2\43\1\uffff\2\43\1\uffff\154\43"+
            "\41\uffff\u016b\43\22\uffff\100\43\2\uffff\66\43\50\uffff\14"+
            "\43\164\uffff\5\43\1\uffff\u0087\43\44\uffff\32\43\6\uffff\32"+
            "\43\13\uffff\131\43\3\uffff\6\43\2\uffff\6\43\2\uffff\6\43\2"+
            "\uffff\3\43",
            "",
            "",
            "\1\52\3\uffff\1\55\1\45\1\uffff\1\67\1\70\1\53\1\47\1\uffff"+
            "\1\50\1\61\1\54\12\uffff\1\66\1\62\1\56\1\60\1\57\1\65\33\uffff"+
            "\1\71\1\uffff\1\72\1\63\34\uffff\1\73\1\64\1\74\1\51",
            "\41\124\1\101\3\124\1\104\1\75\1\124\1\116\1\117\1\102\1\76"+
            "\1\124\1\77\1\110\1\103\12\124\1\115\1\111\1\105\1\107\1\106"+
            "\1\114\33\124\1\120\1\124\1\121\1\112\34\124\1\122\1\113\1\123"+
            "\1\100\uff81\124",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\52\3\uffff\1\55\1\45\1\uffff\1\67\1\70\1\53\1\47\1\uffff"+
            "\1\50\1\61\1\54\12\uffff\1\66\1\62\1\56\1\60\1\57\1\65\33\uffff"+
            "\1\71\1\uffff\1\72\1\63\2\uffff\1\126\5\uffff\1\130\4\uffff"+
            "\1\125\4\uffff\1\127\11\uffff\1\73\1\64\1\74\1\51",
            "",
            "\1\52\3\uffff\1\55\1\45\1\uffff\1\67\1\70\1\53\1\47\1\uffff"+
            "\1\50\1\61\1\54\12\uffff\1\66\1\62\1\56\1\60\1\57\1\65\33\uffff"+
            "\1\71\1\uffff\1\72\1\63\34\uffff\1\73\1\64\1\74\1\51",
            "\1\52\3\uffff\1\55\1\45\1\uffff\1\67\1\70\1\53\1\47\1\uffff"+
            "\1\50\1\61\1\54\12\uffff\1\66\1\62\1\56\1\60\1\57\1\65\33\uffff"+
            "\1\71\1\uffff\1\72\1\63\34\uffff\1\73\1\64\1\74\1\51",
            "\1\52\3\uffff\1\55\1\45\1\uffff\1\67\1\70\1\53\1\47\1\uffff"+
            "\1\50\1\61\1\54\12\uffff\1\66\1\62\1\56\1\60\1\57\1\65\33\uffff"+
            "\1\71\1\uffff\1\72\1\63\34\uffff\1\73\1\64\1\74\1\51",
            "\1\52\3\uffff\1\55\1\45\1\uffff\1\67\1\70\1\53\1\47\1\uffff"+
            "\1\50\1\61\1\54\12\uffff\1\66\1\62\1\56\1\60\1\57\1\65\33\uffff"+
            "\1\71\1\uffff\1\72\1\63\34\uffff\1\73\1\64\1\74\1\51",
            "\1\52\3\uffff\1\55\1\45\1\uffff\1\67\1\70\1\53\1\47\1\uffff"+
            "\1\50\1\61\1\54\12\uffff\1\66\1\62\1\56\1\60\1\57\1\65\33\uffff"+
            "\1\71\1\uffff\1\72\1\63\34\uffff\1\73\1\64\1\74\1\51",
            "\1\52\3\uffff\1\55\1\45\1\uffff\1\67\1\70\1\53\1\47\1\uffff"+
            "\1\50\1\61\1\54\12\uffff\1\66\1\62\1\56\1\60\1\57\1\65\33\uffff"+
            "\1\71\1\uffff\1\72\1\63\34\uffff\1\73\1\64\1\74\1\51",
            "\1\52\3\uffff\1\55\1\45\1\uffff\1\67\1\70\1\53\1\47\1\uffff"+
            "\1\50\1\61\1\54\12\uffff\1\66\1\62\1\56\1\60\1\57\1\65\33\uffff"+
            "\1\71\1\uffff\1\72\1\63\34\uffff\1\73\1\64\1\74\1\51",
            "\1\52\3\uffff\1\55\1\45\1\uffff\1\67\1\70\1\53\1\47\1\uffff"+
            "\1\50\1\61\1\54\12\uffff\1\66\1\62\1\56\1\60\1\57\1\65\33\uffff"+
            "\1\71\1\uffff\1\72\1\63\34\uffff\1\73\1\64\1\74\1\51",
            "\1\52\3\uffff\1\55\1\45\1\uffff\1\67\1\70\1\53\1\47\1\uffff"+
            "\1\50\1\61\1\54\12\uffff\1\66\1\62\1\56\1\60\1\57\1\65\33\uffff"+
            "\1\71\1\uffff\1\72\1\63\34\uffff\1\73\1\64\1\74\1\51",
            "\1\52\3\uffff\1\55\1\45\1\uffff\1\67\1\70\1\53\1\47\1\uffff"+
            "\1\50\1\61\1\54\12\uffff\1\66\1\62\1\56\1\60\1\57\1\65\33\uffff"+
            "\1\71\1\uffff\1\72\1\63\34\uffff\1\73\1\64\1\74\1\51",
            "\1\52\3\uffff\1\55\1\45\1\uffff\1\67\1\70\1\53\1\47\1\uffff"+
            "\1\50\1\61\1\54\12\uffff\1\66\1\62\1\56\1\60\1\57\1\65\33\uffff"+
            "\1\71\1\uffff\1\72\1\63\34\uffff\1\73\1\64\1\74\1\51",
            "\1\52\3\uffff\1\55\1\45\1\uffff\1\67\1\70\1\53\1\47\1\uffff"+
            "\1\50\1\61\1\54\12\uffff\1\66\1\62\1\56\1\60\1\57\1\65\33\uffff"+
            "\1\71\1\uffff\1\72\1\63\34\uffff\1\73\1\64\1\74\1\51",
            "\1\52\3\uffff\1\55\1\45\1\uffff\1\67\1\70\1\53\1\47\1\uffff"+
            "\1\50\1\61\1\54\12\uffff\1\66\1\62\1\56\1\60\1\57\1\65\33\uffff"+
            "\1\71\1\uffff\1\72\1\63\34\uffff\1\73\1\64\1\74\1\51",
            "\1\52\3\uffff\1\55\1\45\1\uffff\1\67\1\70\1\53\1\47\1\uffff"+
            "\1\50\1\61\1\54\12\uffff\1\66\1\62\1\56\1\60\1\57\1\65\33\uffff"+
            "\1\71\1\uffff\1\72\1\63\34\uffff\1\73\1\64\1\74\1\51",
            "\1\52\3\uffff\1\55\1\45\1\uffff\1\67\1\70\1\53\1\47\1\uffff"+
            "\1\50\1\61\1\54\12\uffff\1\66\1\62\1\56\1\60\1\57\1\65\33\uffff"+
            "\1\71\1\uffff\1\72\1\63\34\uffff\1\73\1\64\1\74\1\51",
            "\1\52\3\uffff\1\55\1\45\1\uffff\1\67\1\70\1\53\1\47\1\uffff"+
            "\1\50\1\61\1\54\12\uffff\1\66\1\62\1\56\1\60\1\57\1\65\33\uffff"+
            "\1\71\1\uffff\1\72\1\63\34\uffff\1\73\1\64\1\74\1\51",
            "\1\52\3\uffff\1\55\1\45\1\uffff\1\67\1\70\1\53\1\47\1\uffff"+
            "\1\50\1\61\1\54\12\uffff\1\66\1\62\1\56\1\60\1\57\1\65\33\uffff"+
            "\1\71\1\uffff\1\72\1\63\34\uffff\1\73\1\64\1\74\1\51",
            "\1\52\3\uffff\1\55\1\45\1\uffff\1\67\1\70\1\53\1\47\1\uffff"+
            "\1\50\1\61\1\54\12\uffff\1\66\1\62\1\56\1\60\1\57\1\65\33\uffff"+
            "\1\71\1\uffff\1\72\1\63\34\uffff\1\73\1\64\1\74\1\51",
            "\1\52\3\uffff\1\55\1\45\1\uffff\1\67\1\70\1\53\1\47\1\uffff"+
            "\1\50\1\61\1\54\12\uffff\1\66\1\62\1\56\1\60\1\57\1\65\33\uffff"+
            "\1\71\1\uffff\1\72\1\63\34\uffff\1\73\1\64\1\74\1\51",
            "\1\52\3\uffff\1\55\1\45\1\uffff\1\67\1\70\1\53\1\47\1\uffff"+
            "\1\50\1\61\1\54\12\uffff\1\66\1\62\1\56\1\60\1\57\1\65\33\uffff"+
            "\1\71\1\uffff\1\72\1\63\34\uffff\1\73\1\64\1\74\1\51",
            "\1\52\3\uffff\1\55\1\45\1\uffff\1\67\1\70\1\53\1\47\1\uffff"+
            "\1\50\1\61\1\54\12\uffff\1\66\1\62\1\56\1\60\1\57\1\65\33\uffff"+
            "\1\71\1\uffff\1\72\1\63\34\uffff\1\73\1\64\1\74\1\51",
            "\1\52\3\uffff\1\55\1\45\1\uffff\1\67\1\70\1\53\1\47\1\uffff"+
            "\1\50\1\61\1\54\12\uffff\1\66\1\62\1\56\1\60\1\57\1\65\33\uffff"+
            "\1\71\1\uffff\1\72\1\63\34\uffff\1\73\1\64\1\74\1\51",
            "\41\124\1\101\3\124\1\104\1\75\1\124\1\116\1\117\1\102\1\76"+
            "\1\124\1\77\1\110\1\103\12\124\1\115\1\111\1\105\1\107\1\106"+
            "\1\114\33\124\1\120\1\124\1\121\1\112\2\124\1\132\5\124\1\134"+
            "\4\124\1\131\4\124\1\133\11\124\1\122\1\113\1\123\1\100\uff81"+
            "\124",
            "\41\124\1\101\3\124\1\104\1\75\1\124\1\116\1\117\1\102\1\76"+
            "\1\124\1\77\1\110\1\103\12\124\1\115\1\111\1\105\1\107\1\106"+
            "\1\114\33\124\1\120\1\124\1\121\1\112\34\124\1\122\1\113\1\123"+
            "\1\100\uff81\124",
            "\41\124\1\101\3\124\1\104\1\75\1\124\1\116\1\117\1\102\1\76"+
            "\1\124\1\77\1\110\1\103\12\124\1\115\1\111\1\105\1\107\1\106"+
            "\1\114\33\124\1\120\1\124\1\121\1\112\34\124\1\122\1\113\1\123"+
            "\1\100\uff81\124",
            "\41\124\1\101\3\124\1\104\1\75\1\124\1\116\1\117\1\102\1\76"+
            "\1\124\1\77\1\110\1\103\12\124\1\115\1\111\1\105\1\107\1\106"+
            "\1\114\33\124\1\120\1\124\1\121\1\112\34\124\1\122\1\113\1\123"+
            "\1\100\uff81\124",
            "\41\124\1\101\3\124\1\104\1\75\1\124\1\116\1\117\1\102\1\76"+
            "\1\124\1\77\1\110\1\103\12\124\1\115\1\111\1\105\1\107\1\106"+
            "\1\114\33\124\1\120\1\124\1\121\1\112\34\124\1\122\1\113\1\123"+
            "\1\100\uff81\124",
            "\41\124\1\101\3\124\1\104\1\75\1\124\1\116\1\117\1\102\1\76"+
            "\1\124\1\77\1\110\1\135\12\124\1\115\1\111\1\105\1\107\1\106"+
            "\1\114\33\124\1\120\1\124\1\121\1\112\34\124\1\122\1\113\1\123"+
            "\1\100\uff81\124",
            "\41\124\1\101\3\124\1\104\1\75\1\124\1\116\1\117\1\102\1\76"+
            "\1\124\1\77\1\110\1\103\12\124\1\115\1\111\1\105\1\107\1\106"+
            "\1\114\33\124\1\120\1\124\1\121\1\112\34\124\1\122\1\113\1\123"+
            "\1\100\uff81\124",
            "\41\124\1\101\3\124\1\104\1\75\1\124\1\116\1\117\1\102\1\76"+
            "\1\124\1\77\1\110\1\103\12\124\1\115\1\111\1\105\1\107\1\106"+
            "\1\114\33\124\1\120\1\124\1\121\1\112\34\124\1\122\1\113\1\123"+
            "\1\100\uff81\124",
            "\41\124\1\101\3\124\1\104\1\75\1\124\1\116\1\117\1\102\1\76"+
            "\1\124\1\77\1\110\1\103\12\124\1\115\1\111\1\105\1\107\1\106"+
            "\1\114\33\124\1\120\1\124\1\121\1\112\34\124\1\122\1\113\1\123"+
            "\1\100\uff81\124",
            "\41\124\1\101\3\124\1\104\1\75\1\124\1\116\1\117\1\102\1\76"+
            "\1\124\1\77\1\110\1\103\12\124\1\115\1\111\1\105\1\107\1\106"+
            "\1\114\33\124\1\120\1\124\1\121\1\112\34\124\1\122\1\113\1\123"+
            "\1\100\uff81\124",
            "\41\124\1\101\3\124\1\104\1\75\1\124\1\116\1\117\1\102\1\76"+
            "\1\124\1\77\1\110\1\103\12\124\1\115\1\111\1\105\1\107\1\106"+
            "\1\114\33\124\1\120\1\124\1\121\1\112\34\124\1\122\1\113\1\123"+
            "\1\100\uff81\124",
            "\41\124\1\101\3\124\1\104\1\75\1\124\1\116\1\117\1\102\1\76"+
            "\1\124\1\77\1\110\1\103\12\124\1\115\1\111\1\105\1\107\1\106"+
            "\1\114\33\124\1\120\1\124\1\121\1\112\34\124\1\122\1\113\1\123"+
            "\1\100\uff81\124",
            "\41\124\1\101\3\124\1\104\1\75\1\124\1\116\1\117\1\102\1\76"+
            "\1\124\1\77\1\110\1\103\12\124\1\115\1\111\1\105\1\107\1\106"+
            "\1\114\33\124\1\120\1\124\1\121\1\112\34\124\1\122\1\113\1\123"+
            "\1\100\uff81\124",
            "\41\124\1\101\3\124\1\104\1\75\1\124\1\116\1\117\1\102\1\76"+
            "\1\124\1\77\1\110\1\103\12\124\1\115\1\111\1\105\1\107\1\106"+
            "\1\114\33\124\1\120\1\124\1\121\1\112\34\124\1\122\1\113\1\123"+
            "\1\100\uff81\124",
            "\41\124\1\101\3\124\1\104\1\75\1\124\1\116\1\117\1\102\1\76"+
            "\1\124\1\77\1\110\1\103\12\124\1\115\1\111\1\105\1\107\1\106"+
            "\1\114\33\124\1\120\1\124\1\121\1\112\34\124\1\122\1\113\1\123"+
            "\1\100\uff81\124",
            "\41\124\1\101\3\124\1\104\1\75\1\124\1\116\1\117\1\102\1\76"+
            "\1\124\1\77\1\110\1\103\12\124\1\115\1\111\1\105\1\107\1\106"+
            "\1\114\33\124\1\120\1\124\1\121\1\112\34\124\1\122\1\113\1\123"+
            "\1\100\uff81\124",
            "\41\124\1\101\3\124\1\104\1\75\1\124\1\116\1\117\1\102\1\76"+
            "\1\124\1\77\1\110\1\103\12\124\1\115\1\111\1\105\1\107\1\106"+
            "\1\114\33\124\1\120\1\124\1\121\1\112\34\124\1\122\1\113\1\123"+
            "\1\100\uff81\124",
            "\41\124\1\101\3\124\1\104\1\75\1\124\1\116\1\117\1\102\1\76"+
            "\1\124\1\77\1\110\1\103\12\124\1\115\1\111\1\105\1\107\1\106"+
            "\1\114\33\124\1\120\1\124\1\121\1\112\34\124\1\122\1\113\1\123"+
            "\1\100\uff81\124",
            "\41\124\1\101\3\124\1\104\1\75\1\124\1\116\1\117\1\102\1\76"+
            "\1\124\1\77\1\110\1\103\12\124\1\115\1\111\1\105\1\107\1\106"+
            "\1\114\33\124\1\120\1\124\1\121\1\112\34\124\1\122\1\113\1\123"+
            "\1\100\uff81\124",
            "\41\124\1\101\3\124\1\104\1\75\1\124\1\116\1\117\1\102\1\76"+
            "\1\124\1\77\1\110\1\103\12\124\1\115\1\111\1\105\1\107\1\106"+
            "\1\114\33\124\1\120\1\124\1\121\1\112\34\124\1\122\1\113\1\123"+
            "\1\100\uff81\124",
            "\41\124\1\101\3\124\1\104\1\75\1\124\1\116\1\117\1\102\1\76"+
            "\1\124\1\77\1\110\1\103\12\124\1\115\1\111\1\105\1\107\1\106"+
            "\1\114\33\124\1\120\1\124\1\121\1\112\34\124\1\122\1\113\1\123"+
            "\1\100\uff81\124",
            "\41\124\1\101\3\124\1\104\1\75\1\124\1\116\1\117\1\102\1\76"+
            "\1\124\1\77\1\110\1\103\12\124\1\115\1\111\1\105\1\107\1\106"+
            "\1\114\33\124\1\120\1\124\1\121\1\112\34\124\1\122\1\113\1\123"+
            "\1\100\uff81\124",
            "\41\124\1\101\3\124\1\104\1\75\1\124\1\116\1\117\1\102\1\76"+
            "\1\124\1\77\1\110\1\103\12\124\1\115\1\111\1\105\1\107\1\106"+
            "\1\114\33\124\1\120\1\124\1\121\1\112\34\124\1\122\1\113\1\123"+
            "\1\100\uff81\124",
            "",
            "\1\136",
            "\1\140\2\uffff\1\137",
            "\1\141",
            "\1\142",
            "\164\124\1\143\uff8b\124",
            "\155\124\1\145\2\124\1\144\uff8f\124",
            "\165\124\1\146\uff8a\124",
            "\164\124\1\147\uff8b\124",
            "\1\101\3\uffff\1\104\1\75\1\uffff\1\116\1\117\1\102\1\76\1"+
            "\uffff\1\77\1\110\1\103\12\uffff\1\115\1\111\1\105\1\107\1\106"+
            "\1\114\33\uffff\1\120\1\uffff\1\121\1\112\34\uffff\1\122\1\113"+
            "\1\123\1\100",
            "\1\150",
            "\1\151",
            "\1\152",
            "\1\153",
            "\1\154",
            "\73\124\1\155\uffc4\124",
            "\157\124\1\156\uff90\124",
            "\160\124\1\157\uff8f\124",
            "\157\124\1\160\uff90\124",
            "\73\124\1\161\uffc4\124",
            "\1\52\3\uffff\1\55\1\45\1\uffff\1\67\1\70\1\53\1\47\1\uffff"+
            "\1\50\1\61\1\54\12\uffff\1\66\1\62\1\56\1\60\1\57\1\65\33\uffff"+
            "\1\71\1\uffff\1\72\1\63\34\uffff\1\73\1\64\1\74\1\51",
            "\1\162",
            "\1\163",
            "\1\164",
            "\1\52\3\uffff\1\55\1\45\1\uffff\1\67\1\70\1\53\1\47\1\uffff"+
            "\1\50\1\61\1\54\12\uffff\1\66\1\62\1\56\1\60\1\57\1\65\33\uffff"+
            "\1\71\1\uffff\1\72\1\63\34\uffff\1\73\1\64\1\74\1\51",
            "\41\124\1\101\3\124\1\104\1\75\1\124\1\116\1\117\1\102\1\76"+
            "\1\124\1\77\1\110\1\103\12\124\1\115\1\111\1\105\1\107\1\106"+
            "\1\114\33\124\1\120\1\124\1\121\1\112\34\124\1\122\1\113\1\123"+
            "\1\100\uff81\124",
            "\163\124\1\165\uff8c\124",
            "\73\124\1\166\uffc4\124",
            "\164\124\1\167\uff8b\124",
            "\41\124\1\101\3\124\1\104\1\75\1\124\1\116\1\117\1\102\1\76"+
            "\1\124\1\77\1\110\1\103\12\124\1\115\1\111\1\105\1\107\1\106"+
            "\1\114\33\124\1\120\1\124\1\121\1\112\34\124\1\122\1\113\1\123"+
            "\1\100\uff81\124",
            "\1\170",
            "\1\52\3\uffff\1\55\1\45\1\uffff\1\67\1\70\1\53\1\47\1\uffff"+
            "\1\50\1\61\1\54\12\uffff\1\66\1\62\1\56\1\60\1\57\1\65\33\uffff"+
            "\1\71\1\uffff\1\72\1\63\34\uffff\1\73\1\64\1\74\1\51",
            "\1\171",
            "\73\124\1\172\uffc4\124",
            "\41\124\1\101\3\124\1\104\1\75\1\124\1\116\1\117\1\102\1\76"+
            "\1\124\1\77\1\110\1\103\12\124\1\115\1\111\1\105\1\107\1\106"+
            "\1\114\33\124\1\120\1\124\1\121\1\112\34\124\1\122\1\113\1\123"+
            "\1\100\uff81\124",
            "\73\124\1\173\uffc4\124",
            "\1\52\3\uffff\1\55\1\45\1\uffff\1\67\1\70\1\53\1\47\1\uffff"+
            "\1\50\1\61\1\54\12\uffff\1\66\1\62\1\56\1\60\1\57\1\65\33\uffff"+
            "\1\71\1\uffff\1\72\1\63\34\uffff\1\73\1\64\1\74\1\51",
            "\1\52\3\uffff\1\55\1\45\1\uffff\1\67\1\70\1\53\1\47\1\uffff"+
            "\1\50\1\61\1\54\12\uffff\1\66\1\62\1\56\1\60\1\57\1\65\33\uffff"+
            "\1\71\1\uffff\1\72\1\63\34\uffff\1\73\1\64\1\74\1\51",
            "\41\124\1\101\3\124\1\104\1\75\1\124\1\116\1\117\1\102\1\76"+
            "\1\124\1\77\1\110\1\103\12\124\1\115\1\111\1\105\1\107\1\106"+
            "\1\114\33\124\1\120\1\124\1\121\1\112\34\124\1\122\1\113\1\123"+
            "\1\100\uff81\124",
            "\41\124\1\101\3\124\1\104\1\75\1\124\1\116\1\117\1\102\1\76"+
            "\1\124\1\77\1\110\1\103\12\124\1\115\1\111\1\105\1\107\1\106"+
            "\1\114\33\124\1\120\1\124\1\121\1\112\34\124\1\122\1\113\1\123"+
            "\1\100\uff81\124"
    };

    static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
    static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
    static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
    static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
    static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
    static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
    static final short[][] DFA7_transition;

    static {
        int numStates = DFA7_transitionS.length;
        DFA7_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
        }
    }

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = DFA7_eot;
            this.eof = DFA7_eof;
            this.min = DFA7_min;
            this.max = DFA7_max;
            this.accept = DFA7_accept;
            this.special = DFA7_special;
            this.transition = DFA7_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( SingleLineComment | MultiLineComment | StringLiteral | CalloutNum | ToggleHighlight | Operator | SpecialIdentifier | JavaIdentifier | Other );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA7_119 = input.LA(1);

                        s = -1;
                        if ( (LA7_119==';') ) {s = 123;}

                        else if ( ((LA7_119>='\u0000' && LA7_119<=':')||(LA7_119>='<' && LA7_119<='\uFFFF')) ) {s = 84;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA7_103 = input.LA(1);

                        s = -1;
                        if ( (LA7_103==';') ) {s = 113;}

                        else if ( ((LA7_103>='\u0000' && LA7_103<=':')||(LA7_103>='<' && LA7_103<='\uFFFF')) ) {s = 84;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA7_2 = input.LA(1);

                        s = -1;
                        if ( ((LA7_2>='\u0000' && LA7_2<='\t')||(LA7_2>='\u000B' && LA7_2<='\f')||(LA7_2>='\u000E' && LA7_2<='\uFFFF')) ) {s = 32;}

                        else s = 28;

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA7_92 = input.LA(1);

                        s = -1;
                        if ( (LA7_92=='t') ) {s = 103;}

                        else if ( ((LA7_92>='\u0000' && LA7_92<='s')||(LA7_92>='u' && LA7_92<='\uFFFF')) ) {s = 84;}

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA7_111 = input.LA(1);

                        s = -1;
                        if ( (LA7_111==';') ) {s = 118;}

                        else if ( ((LA7_111>='\u0000' && LA7_111<=':')||(LA7_111>='<' && LA7_111<='\uFFFF')) ) {s = 84;}

                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA7_101 = input.LA(1);

                        s = -1;
                        if ( (LA7_101=='p') ) {s = 111;}

                        else if ( ((LA7_101>='\u0000' && LA7_101<='o')||(LA7_101>='q' && LA7_101<='\uFFFF')) ) {s = 84;}

                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA7_99 = input.LA(1);

                        s = -1;
                        if ( (LA7_99==';') ) {s = 109;}

                        else if ( ((LA7_99>='\u0000' && LA7_99<=':')||(LA7_99>='<' && LA7_99<='\uFFFF')) ) {s = 84;}

                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA7_89 = input.LA(1);

                        s = -1;
                        if ( (LA7_89=='t') ) {s = 99;}

                        else if ( ((LA7_89>='\u0000' && LA7_89<='s')||(LA7_89>='u' && LA7_89<='\uFFFF')) ) {s = 84;}

                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA7_100 = input.LA(1);

                        s = -1;
                        if ( (LA7_100=='o') ) {s = 110;}

                        else if ( ((LA7_100>='\u0000' && LA7_100<='n')||(LA7_100>='p' && LA7_100<='\uFFFF')) ) {s = 84;}

                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA7_110 = input.LA(1);

                        s = -1;
                        if ( (LA7_110=='s') ) {s = 117;}

                        else if ( ((LA7_110>='\u0000' && LA7_110<='r')||(LA7_110>='t' && LA7_110<='\uFFFF')) ) {s = 84;}

                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA7_117 = input.LA(1);

                        s = -1;
                        if ( (LA7_117==';') ) {s = 122;}

                        else if ( ((LA7_117>='\u0000' && LA7_117<=':')||(LA7_117>='<' && LA7_117<='\uFFFF')) ) {s = 84;}

                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA7_102 = input.LA(1);

                        s = -1;
                        if ( (LA7_102=='o') ) {s = 112;}

                        else if ( ((LA7_102>='\u0000' && LA7_102<='n')||(LA7_102>='p' && LA7_102<='\uFFFF')) ) {s = 84;}

                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA7_112 = input.LA(1);

                        s = -1;
                        if ( (LA7_112=='t') ) {s = 119;}

                        else if ( ((LA7_112>='\u0000' && LA7_112<='s')||(LA7_112>='u' && LA7_112<='\uFFFF')) ) {s = 84;}

                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA7_91 = input.LA(1);

                        s = -1;
                        if ( (LA7_91=='u') ) {s = 102;}

                        else if ( ((LA7_91>='\u0000' && LA7_91<='t')||(LA7_91>='v' && LA7_91<='\uFFFF')) ) {s = 84;}

                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA7_0 = input.LA(1);

                        s = -1;
                        if ( (LA7_0=='/') ) {s = 1;}

                        else if ( (LA7_0=='\"') ) {s = 2;}

                        else if ( (LA7_0=='`') ) {s = 3;}

                        else if ( (LA7_0=='&') ) {s = 4;}

                        else if ( (LA7_0=='+') ) {s = 5;}

                        else if ( (LA7_0=='-') ) {s = 6;}

                        else if ( (LA7_0=='~') ) {s = 7;}

                        else if ( (LA7_0=='!') ) {s = 8;}

                        else if ( (LA7_0=='*') ) {s = 9;}

                        else if ( (LA7_0=='%') ) {s = 10;}

                        else if ( (LA7_0=='<') ) {s = 11;}

                        else if ( (LA7_0=='>') ) {s = 12;}

                        else if ( (LA7_0=='=') ) {s = 13;}

                        else if ( (LA7_0=='.') ) {s = 14;}

                        else if ( (LA7_0==';') ) {s = 15;}

                        else if ( (LA7_0=='^') ) {s = 16;}

                        else if ( (LA7_0=='|') ) {s = 17;}

                        else if ( (LA7_0=='?') ) {s = 18;}

                        else if ( (LA7_0==':') ) {s = 19;}

                        else if ( (LA7_0=='(') ) {s = 20;}

                        else if ( (LA7_0==')') ) {s = 21;}

                        else if ( (LA7_0=='[') ) {s = 22;}

                        else if ( (LA7_0==']') ) {s = 23;}

                        else if ( (LA7_0=='{') ) {s = 24;}

                        else if ( (LA7_0=='}') ) {s = 25;}

                        else if ( (LA7_0=='$'||LA7_0=='@') ) {s = 26;}

                        else if ( ((LA7_0>='A' && LA7_0<='Z')||LA7_0=='_'||(LA7_0>='a' && LA7_0<='z')||LA7_0=='\u00AA'||LA7_0=='\u00B5'||LA7_0=='\u00BA'||(LA7_0>='\u00C0' && LA7_0<='\u00D6')||(LA7_0>='\u00D8' && LA7_0<='\u00F6')||(LA7_0>='\u00F8' && LA7_0<='\u02C1')||(LA7_0>='\u02C6' && LA7_0<='\u02D1')||(LA7_0>='\u02E0' && LA7_0<='\u02E4')||LA7_0=='\u02EE'||(LA7_0>='\u037A' && LA7_0<='\u037D')||LA7_0=='\u0386'||(LA7_0>='\u0388' && LA7_0<='\u038A')||LA7_0=='\u038C'||(LA7_0>='\u038E' && LA7_0<='\u03A1')||(LA7_0>='\u03A3' && LA7_0<='\u03CE')||(LA7_0>='\u03D0' && LA7_0<='\u03F5')||(LA7_0>='\u03F7' && LA7_0<='\u0481')||(LA7_0>='\u048A' && LA7_0<='\u0513')||(LA7_0>='\u0531' && LA7_0<='\u0556')||LA7_0=='\u0559'||(LA7_0>='\u0561' && LA7_0<='\u0587')||(LA7_0>='\u05D0' && LA7_0<='\u05EA')||(LA7_0>='\u05F0' && LA7_0<='\u05F2')||(LA7_0>='\u0621' && LA7_0<='\u063A')||(LA7_0>='\u0640' && LA7_0<='\u064A')||(LA7_0>='\u066E' && LA7_0<='\u066F')||(LA7_0>='\u0671' && LA7_0<='\u06D3')||LA7_0=='\u06D5'||(LA7_0>='\u06E5' && LA7_0<='\u06E6')||(LA7_0>='\u06EE' && LA7_0<='\u06EF')||(LA7_0>='\u06FA' && LA7_0<='\u06FC')||LA7_0=='\u06FF'||LA7_0=='\u0710'||(LA7_0>='\u0712' && LA7_0<='\u072F')||(LA7_0>='\u074D' && LA7_0<='\u076D')||(LA7_0>='\u0780' && LA7_0<='\u07A5')||LA7_0=='\u07B1'||(LA7_0>='\u07CA' && LA7_0<='\u07EA')||(LA7_0>='\u07F4' && LA7_0<='\u07F5')||LA7_0=='\u07FA'||(LA7_0>='\u0904' && LA7_0<='\u0939')||LA7_0=='\u093D'||LA7_0=='\u0950'||(LA7_0>='\u0958' && LA7_0<='\u0961')||(LA7_0>='\u097B' && LA7_0<='\u097F')||(LA7_0>='\u0985' && LA7_0<='\u098C')||(LA7_0>='\u098F' && LA7_0<='\u0990')||(LA7_0>='\u0993' && LA7_0<='\u09A8')||(LA7_0>='\u09AA' && LA7_0<='\u09B0')||LA7_0=='\u09B2'||(LA7_0>='\u09B6' && LA7_0<='\u09B9')||LA7_0=='\u09BD'||LA7_0=='\u09CE'||(LA7_0>='\u09DC' && LA7_0<='\u09DD')||(LA7_0>='\u09DF' && LA7_0<='\u09E1')||(LA7_0>='\u09F0' && LA7_0<='\u09F1')||(LA7_0>='\u0A05' && LA7_0<='\u0A0A')||(LA7_0>='\u0A0F' && LA7_0<='\u0A10')||(LA7_0>='\u0A13' && LA7_0<='\u0A28')||(LA7_0>='\u0A2A' && LA7_0<='\u0A30')||(LA7_0>='\u0A32' && LA7_0<='\u0A33')||(LA7_0>='\u0A35' && LA7_0<='\u0A36')||(LA7_0>='\u0A38' && LA7_0<='\u0A39')||(LA7_0>='\u0A59' && LA7_0<='\u0A5C')||LA7_0=='\u0A5E'||(LA7_0>='\u0A72' && LA7_0<='\u0A74')||(LA7_0>='\u0A85' && LA7_0<='\u0A8D')||(LA7_0>='\u0A8F' && LA7_0<='\u0A91')||(LA7_0>='\u0A93' && LA7_0<='\u0AA8')||(LA7_0>='\u0AAA' && LA7_0<='\u0AB0')||(LA7_0>='\u0AB2' && LA7_0<='\u0AB3')||(LA7_0>='\u0AB5' && LA7_0<='\u0AB9')||LA7_0=='\u0ABD'||LA7_0=='\u0AD0'||(LA7_0>='\u0AE0' && LA7_0<='\u0AE1')||(LA7_0>='\u0B05' && LA7_0<='\u0B0C')||(LA7_0>='\u0B0F' && LA7_0<='\u0B10')||(LA7_0>='\u0B13' && LA7_0<='\u0B28')||(LA7_0>='\u0B2A' && LA7_0<='\u0B30')||(LA7_0>='\u0B32' && LA7_0<='\u0B33')||(LA7_0>='\u0B35' && LA7_0<='\u0B39')||LA7_0=='\u0B3D'||(LA7_0>='\u0B5C' && LA7_0<='\u0B5D')||(LA7_0>='\u0B5F' && LA7_0<='\u0B61')||LA7_0=='\u0B71'||LA7_0=='\u0B83'||(LA7_0>='\u0B85' && LA7_0<='\u0B8A')||(LA7_0>='\u0B8E' && LA7_0<='\u0B90')||(LA7_0>='\u0B92' && LA7_0<='\u0B95')||(LA7_0>='\u0B99' && LA7_0<='\u0B9A')||LA7_0=='\u0B9C'||(LA7_0>='\u0B9E' && LA7_0<='\u0B9F')||(LA7_0>='\u0BA3' && LA7_0<='\u0BA4')||(LA7_0>='\u0BA8' && LA7_0<='\u0BAA')||(LA7_0>='\u0BAE' && LA7_0<='\u0BB9')||(LA7_0>='\u0C05' && LA7_0<='\u0C0C')||(LA7_0>='\u0C0E' && LA7_0<='\u0C10')||(LA7_0>='\u0C12' && LA7_0<='\u0C28')||(LA7_0>='\u0C2A' && LA7_0<='\u0C33')||(LA7_0>='\u0C35' && LA7_0<='\u0C39')||(LA7_0>='\u0C60' && LA7_0<='\u0C61')||(LA7_0>='\u0C85' && LA7_0<='\u0C8C')||(LA7_0>='\u0C8E' && LA7_0<='\u0C90')||(LA7_0>='\u0C92' && LA7_0<='\u0CA8')||(LA7_0>='\u0CAA' && LA7_0<='\u0CB3')||(LA7_0>='\u0CB5' && LA7_0<='\u0CB9')||LA7_0=='\u0CBD'||LA7_0=='\u0CDE'||(LA7_0>='\u0CE0' && LA7_0<='\u0CE1')||(LA7_0>='\u0D05' && LA7_0<='\u0D0C')||(LA7_0>='\u0D0E' && LA7_0<='\u0D10')||(LA7_0>='\u0D12' && LA7_0<='\u0D28')||(LA7_0>='\u0D2A' && LA7_0<='\u0D39')||(LA7_0>='\u0D60' && LA7_0<='\u0D61')||(LA7_0>='\u0D85' && LA7_0<='\u0D96')||(LA7_0>='\u0D9A' && LA7_0<='\u0DB1')||(LA7_0>='\u0DB3' && LA7_0<='\u0DBB')||LA7_0=='\u0DBD'||(LA7_0>='\u0DC0' && LA7_0<='\u0DC6')||(LA7_0>='\u0E01' && LA7_0<='\u0E30')||(LA7_0>='\u0E32' && LA7_0<='\u0E33')||(LA7_0>='\u0E40' && LA7_0<='\u0E46')||(LA7_0>='\u0E81' && LA7_0<='\u0E82')||LA7_0=='\u0E84'||(LA7_0>='\u0E87' && LA7_0<='\u0E88')||LA7_0=='\u0E8A'||LA7_0=='\u0E8D'||(LA7_0>='\u0E94' && LA7_0<='\u0E97')||(LA7_0>='\u0E99' && LA7_0<='\u0E9F')||(LA7_0>='\u0EA1' && LA7_0<='\u0EA3')||LA7_0=='\u0EA5'||LA7_0=='\u0EA7'||(LA7_0>='\u0EAA' && LA7_0<='\u0EAB')||(LA7_0>='\u0EAD' && LA7_0<='\u0EB0')||(LA7_0>='\u0EB2' && LA7_0<='\u0EB3')||LA7_0=='\u0EBD'||(LA7_0>='\u0EC0' && LA7_0<='\u0EC4')||LA7_0=='\u0EC6'||(LA7_0>='\u0EDC' && LA7_0<='\u0EDD')||LA7_0=='\u0F00'||(LA7_0>='\u0F40' && LA7_0<='\u0F47')||(LA7_0>='\u0F49' && LA7_0<='\u0F6A')||(LA7_0>='\u0F88' && LA7_0<='\u0F8B')||(LA7_0>='\u1000' && LA7_0<='\u1021')||(LA7_0>='\u1023' && LA7_0<='\u1027')||(LA7_0>='\u1029' && LA7_0<='\u102A')||(LA7_0>='\u1050' && LA7_0<='\u1055')||(LA7_0>='\u10A0' && LA7_0<='\u10C5')||(LA7_0>='\u10D0' && LA7_0<='\u10FA')||LA7_0=='\u10FC'||(LA7_0>='\u1100' && LA7_0<='\u1159')||(LA7_0>='\u115F' && LA7_0<='\u11A2')||(LA7_0>='\u11A8' && LA7_0<='\u11F9')||(LA7_0>='\u1200' && LA7_0<='\u1248')||(LA7_0>='\u124A' && LA7_0<='\u124D')||(LA7_0>='\u1250' && LA7_0<='\u1256')||LA7_0=='\u1258'||(LA7_0>='\u125A' && LA7_0<='\u125D')||(LA7_0>='\u1260' && LA7_0<='\u1288')||(LA7_0>='\u128A' && LA7_0<='\u128D')||(LA7_0>='\u1290' && LA7_0<='\u12B0')||(LA7_0>='\u12B2' && LA7_0<='\u12B5')||(LA7_0>='\u12B8' && LA7_0<='\u12BE')||LA7_0=='\u12C0'||(LA7_0>='\u12C2' && LA7_0<='\u12C5')||(LA7_0>='\u12C8' && LA7_0<='\u12D6')||(LA7_0>='\u12D8' && LA7_0<='\u1310')||(LA7_0>='\u1312' && LA7_0<='\u1315')||(LA7_0>='\u1318' && LA7_0<='\u135A')||(LA7_0>='\u1380' && LA7_0<='\u138F')||(LA7_0>='\u13A0' && LA7_0<='\u13F4')||(LA7_0>='\u1401' && LA7_0<='\u166C')||(LA7_0>='\u166F' && LA7_0<='\u1676')||(LA7_0>='\u1681' && LA7_0<='\u169A')||(LA7_0>='\u16A0' && LA7_0<='\u16EA')||(LA7_0>='\u16EE' && LA7_0<='\u16F0')||(LA7_0>='\u1700' && LA7_0<='\u170C')||(LA7_0>='\u170E' && LA7_0<='\u1711')||(LA7_0>='\u1720' && LA7_0<='\u1731')||(LA7_0>='\u1740' && LA7_0<='\u1751')||(LA7_0>='\u1760' && LA7_0<='\u176C')||(LA7_0>='\u176E' && LA7_0<='\u1770')||(LA7_0>='\u1780' && LA7_0<='\u17B3')||LA7_0=='\u17D7'||LA7_0=='\u17DC'||(LA7_0>='\u1820' && LA7_0<='\u1877')||(LA7_0>='\u1880' && LA7_0<='\u18A8')||(LA7_0>='\u1900' && LA7_0<='\u191C')||(LA7_0>='\u1950' && LA7_0<='\u196D')||(LA7_0>='\u1970' && LA7_0<='\u1974')||(LA7_0>='\u1980' && LA7_0<='\u19A9')||(LA7_0>='\u19C1' && LA7_0<='\u19C7')||(LA7_0>='\u1A00' && LA7_0<='\u1A16')||(LA7_0>='\u1B05' && LA7_0<='\u1B33')||(LA7_0>='\u1B45' && LA7_0<='\u1B4B')||(LA7_0>='\u1D00' && LA7_0<='\u1DBF')||(LA7_0>='\u1E00' && LA7_0<='\u1E9B')||(LA7_0>='\u1EA0' && LA7_0<='\u1EF9')||(LA7_0>='\u1F00' && LA7_0<='\u1F15')||(LA7_0>='\u1F18' && LA7_0<='\u1F1D')||(LA7_0>='\u1F20' && LA7_0<='\u1F45')||(LA7_0>='\u1F48' && LA7_0<='\u1F4D')||(LA7_0>='\u1F50' && LA7_0<='\u1F57')||LA7_0=='\u1F59'||LA7_0=='\u1F5B'||LA7_0=='\u1F5D'||(LA7_0>='\u1F5F' && LA7_0<='\u1F7D')||(LA7_0>='\u1F80' && LA7_0<='\u1FB4')||(LA7_0>='\u1FB6' && LA7_0<='\u1FBC')||LA7_0=='\u1FBE'||(LA7_0>='\u1FC2' && LA7_0<='\u1FC4')||(LA7_0>='\u1FC6' && LA7_0<='\u1FCC')||(LA7_0>='\u1FD0' && LA7_0<='\u1FD3')||(LA7_0>='\u1FD6' && LA7_0<='\u1FDB')||(LA7_0>='\u1FE0' && LA7_0<='\u1FEC')||(LA7_0>='\u1FF2' && LA7_0<='\u1FF4')||(LA7_0>='\u1FF6' && LA7_0<='\u1FFC')||LA7_0=='\u2071'||LA7_0=='\u207F'||(LA7_0>='\u2090' && LA7_0<='\u2094')||LA7_0=='\u2102'||LA7_0=='\u2107'||(LA7_0>='\u210A' && LA7_0<='\u2113')||LA7_0=='\u2115'||(LA7_0>='\u2119' && LA7_0<='\u211D')||LA7_0=='\u2124'||LA7_0=='\u2126'||LA7_0=='\u2128'||(LA7_0>='\u212A' && LA7_0<='\u212D')||(LA7_0>='\u212F' && LA7_0<='\u2139')||(LA7_0>='\u213C' && LA7_0<='\u213F')||(LA7_0>='\u2145' && LA7_0<='\u2149')||LA7_0=='\u214E'||(LA7_0>='\u2160' && LA7_0<='\u2184')||(LA7_0>='\u2C00' && LA7_0<='\u2C2E')||(LA7_0>='\u2C30' && LA7_0<='\u2C5E')||(LA7_0>='\u2C60' && LA7_0<='\u2C6C')||(LA7_0>='\u2C74' && LA7_0<='\u2C77')||(LA7_0>='\u2C80' && LA7_0<='\u2CE4')||(LA7_0>='\u2D00' && LA7_0<='\u2D25')||(LA7_0>='\u2D30' && LA7_0<='\u2D65')||LA7_0=='\u2D6F'||(LA7_0>='\u2D80' && LA7_0<='\u2D96')||(LA7_0>='\u2DA0' && LA7_0<='\u2DA6')||(LA7_0>='\u2DA8' && LA7_0<='\u2DAE')||(LA7_0>='\u2DB0' && LA7_0<='\u2DB6')||(LA7_0>='\u2DB8' && LA7_0<='\u2DBE')||(LA7_0>='\u2DC0' && LA7_0<='\u2DC6')||(LA7_0>='\u2DC8' && LA7_0<='\u2DCE')||(LA7_0>='\u2DD0' && LA7_0<='\u2DD6')||(LA7_0>='\u2DD8' && LA7_0<='\u2DDE')||(LA7_0>='\u3005' && LA7_0<='\u3007')||(LA7_0>='\u3021' && LA7_0<='\u3029')||(LA7_0>='\u3031' && LA7_0<='\u3035')||(LA7_0>='\u3038' && LA7_0<='\u303C')||(LA7_0>='\u3041' && LA7_0<='\u3096')||(LA7_0>='\u309D' && LA7_0<='\u309F')||(LA7_0>='\u30A1' && LA7_0<='\u30FA')||(LA7_0>='\u30FC' && LA7_0<='\u30FF')||(LA7_0>='\u3105' && LA7_0<='\u312C')||(LA7_0>='\u3131' && LA7_0<='\u318E')||(LA7_0>='\u31A0' && LA7_0<='\u31B7')||(LA7_0>='\u31F0' && LA7_0<='\u31FF')||(LA7_0>='\u3400' && LA7_0<='\u4DB5')||(LA7_0>='\u4E00' && LA7_0<='\u9FBB')||(LA7_0>='\uA000' && LA7_0<='\uA48C')||(LA7_0>='\uA717' && LA7_0<='\uA71A')||(LA7_0>='\uA800' && LA7_0<='\uA801')||(LA7_0>='\uA803' && LA7_0<='\uA805')||(LA7_0>='\uA807' && LA7_0<='\uA80A')||(LA7_0>='\uA80C' && LA7_0<='\uA822')||(LA7_0>='\uA840' && LA7_0<='\uA873')||(LA7_0>='\uAC00' && LA7_0<='\uD7A3')||(LA7_0>='\uF900' && LA7_0<='\uFA2D')||(LA7_0>='\uFA30' && LA7_0<='\uFA6A')||(LA7_0>='\uFA70' && LA7_0<='\uFAD9')||(LA7_0>='\uFB00' && LA7_0<='\uFB06')||(LA7_0>='\uFB13' && LA7_0<='\uFB17')||LA7_0=='\uFB1D'||(LA7_0>='\uFB1F' && LA7_0<='\uFB28')||(LA7_0>='\uFB2A' && LA7_0<='\uFB36')||(LA7_0>='\uFB38' && LA7_0<='\uFB3C')||LA7_0=='\uFB3E'||(LA7_0>='\uFB40' && LA7_0<='\uFB41')||(LA7_0>='\uFB43' && LA7_0<='\uFB44')||(LA7_0>='\uFB46' && LA7_0<='\uFBB1')||(LA7_0>='\uFBD3' && LA7_0<='\uFD3D')||(LA7_0>='\uFD50' && LA7_0<='\uFD8F')||(LA7_0>='\uFD92' && LA7_0<='\uFDC7')||(LA7_0>='\uFDF0' && LA7_0<='\uFDFB')||(LA7_0>='\uFE70' && LA7_0<='\uFE74')||(LA7_0>='\uFE76' && LA7_0<='\uFEFC')||(LA7_0>='\uFF21' && LA7_0<='\uFF3A')||(LA7_0>='\uFF41' && LA7_0<='\uFF5A')||(LA7_0>='\uFF66' && LA7_0<='\uFFBE')||(LA7_0>='\uFFC2' && LA7_0<='\uFFC7')||(LA7_0>='\uFFCA' && LA7_0<='\uFFCF')||(LA7_0>='\uFFD2' && LA7_0<='\uFFD7')||(LA7_0>='\uFFDA' && LA7_0<='\uFFDC')) ) {s = 27;}

                        else if ( ((LA7_0>='\u0000' && LA7_0<=' ')||LA7_0=='#'||LA7_0=='\''||LA7_0==','||(LA7_0>='0' && LA7_0<='9')||LA7_0=='\\'||(LA7_0>='\u007F' && LA7_0<='\u00A9')||(LA7_0>='\u00AB' && LA7_0<='\u00B4')||(LA7_0>='\u00B6' && LA7_0<='\u00B9')||(LA7_0>='\u00BB' && LA7_0<='\u00BF')||LA7_0=='\u00D7'||LA7_0=='\u00F7'||(LA7_0>='\u02C2' && LA7_0<='\u02C5')||(LA7_0>='\u02D2' && LA7_0<='\u02DF')||(LA7_0>='\u02E5' && LA7_0<='\u02ED')||(LA7_0>='\u02EF' && LA7_0<='\u0379')||(LA7_0>='\u037E' && LA7_0<='\u0385')||LA7_0=='\u0387'||LA7_0=='\u038B'||LA7_0=='\u038D'||LA7_0=='\u03A2'||LA7_0=='\u03CF'||LA7_0=='\u03F6'||(LA7_0>='\u0482' && LA7_0<='\u0489')||(LA7_0>='\u0514' && LA7_0<='\u0530')||(LA7_0>='\u0557' && LA7_0<='\u0558')||(LA7_0>='\u055A' && LA7_0<='\u0560')||(LA7_0>='\u0588' && LA7_0<='\u05CF')||(LA7_0>='\u05EB' && LA7_0<='\u05EF')||(LA7_0>='\u05F3' && LA7_0<='\u0620')||(LA7_0>='\u063B' && LA7_0<='\u063F')||(LA7_0>='\u064B' && LA7_0<='\u066D')||LA7_0=='\u0670'||LA7_0=='\u06D4'||(LA7_0>='\u06D6' && LA7_0<='\u06E4')||(LA7_0>='\u06E7' && LA7_0<='\u06ED')||(LA7_0>='\u06F0' && LA7_0<='\u06F9')||(LA7_0>='\u06FD' && LA7_0<='\u06FE')||(LA7_0>='\u0700' && LA7_0<='\u070F')||LA7_0=='\u0711'||(LA7_0>='\u0730' && LA7_0<='\u074C')||(LA7_0>='\u076E' && LA7_0<='\u077F')||(LA7_0>='\u07A6' && LA7_0<='\u07B0')||(LA7_0>='\u07B2' && LA7_0<='\u07C9')||(LA7_0>='\u07EB' && LA7_0<='\u07F3')||(LA7_0>='\u07F6' && LA7_0<='\u07F9')||(LA7_0>='\u07FB' && LA7_0<='\u0903')||(LA7_0>='\u093A' && LA7_0<='\u093C')||(LA7_0>='\u093E' && LA7_0<='\u094F')||(LA7_0>='\u0951' && LA7_0<='\u0957')||(LA7_0>='\u0962' && LA7_0<='\u097A')||(LA7_0>='\u0980' && LA7_0<='\u0984')||(LA7_0>='\u098D' && LA7_0<='\u098E')||(LA7_0>='\u0991' && LA7_0<='\u0992')||LA7_0=='\u09A9'||LA7_0=='\u09B1'||(LA7_0>='\u09B3' && LA7_0<='\u09B5')||(LA7_0>='\u09BA' && LA7_0<='\u09BC')||(LA7_0>='\u09BE' && LA7_0<='\u09CD')||(LA7_0>='\u09CF' && LA7_0<='\u09DB')||LA7_0=='\u09DE'||(LA7_0>='\u09E2' && LA7_0<='\u09EF')||(LA7_0>='\u09F2' && LA7_0<='\u0A04')||(LA7_0>='\u0A0B' && LA7_0<='\u0A0E')||(LA7_0>='\u0A11' && LA7_0<='\u0A12')||LA7_0=='\u0A29'||LA7_0=='\u0A31'||LA7_0=='\u0A34'||LA7_0=='\u0A37'||(LA7_0>='\u0A3A' && LA7_0<='\u0A58')||LA7_0=='\u0A5D'||(LA7_0>='\u0A5F' && LA7_0<='\u0A71')||(LA7_0>='\u0A75' && LA7_0<='\u0A84')||LA7_0=='\u0A8E'||LA7_0=='\u0A92'||LA7_0=='\u0AA9'||LA7_0=='\u0AB1'||LA7_0=='\u0AB4'||(LA7_0>='\u0ABA' && LA7_0<='\u0ABC')||(LA7_0>='\u0ABE' && LA7_0<='\u0ACF')||(LA7_0>='\u0AD1' && LA7_0<='\u0ADF')||(LA7_0>='\u0AE2' && LA7_0<='\u0B04')||(LA7_0>='\u0B0D' && LA7_0<='\u0B0E')||(LA7_0>='\u0B11' && LA7_0<='\u0B12')||LA7_0=='\u0B29'||LA7_0=='\u0B31'||LA7_0=='\u0B34'||(LA7_0>='\u0B3A' && LA7_0<='\u0B3C')||(LA7_0>='\u0B3E' && LA7_0<='\u0B5B')||LA7_0=='\u0B5E'||(LA7_0>='\u0B62' && LA7_0<='\u0B70')||(LA7_0>='\u0B72' && LA7_0<='\u0B82')||LA7_0=='\u0B84'||(LA7_0>='\u0B8B' && LA7_0<='\u0B8D')||LA7_0=='\u0B91'||(LA7_0>='\u0B96' && LA7_0<='\u0B98')||LA7_0=='\u0B9B'||LA7_0=='\u0B9D'||(LA7_0>='\u0BA0' && LA7_0<='\u0BA2')||(LA7_0>='\u0BA5' && LA7_0<='\u0BA7')||(LA7_0>='\u0BAB' && LA7_0<='\u0BAD')||(LA7_0>='\u0BBA' && LA7_0<='\u0C04')||LA7_0=='\u0C0D'||LA7_0=='\u0C11'||LA7_0=='\u0C29'||LA7_0=='\u0C34'||(LA7_0>='\u0C3A' && LA7_0<='\u0C5F')||(LA7_0>='\u0C62' && LA7_0<='\u0C84')||LA7_0=='\u0C8D'||LA7_0=='\u0C91'||LA7_0=='\u0CA9'||LA7_0=='\u0CB4'||(LA7_0>='\u0CBA' && LA7_0<='\u0CBC')||(LA7_0>='\u0CBE' && LA7_0<='\u0CDD')||LA7_0=='\u0CDF'||(LA7_0>='\u0CE2' && LA7_0<='\u0D04')||LA7_0=='\u0D0D'||LA7_0=='\u0D11'||LA7_0=='\u0D29'||(LA7_0>='\u0D3A' && LA7_0<='\u0D5F')||(LA7_0>='\u0D62' && LA7_0<='\u0D84')||(LA7_0>='\u0D97' && LA7_0<='\u0D99')||LA7_0=='\u0DB2'||LA7_0=='\u0DBC'||(LA7_0>='\u0DBE' && LA7_0<='\u0DBF')||(LA7_0>='\u0DC7' && LA7_0<='\u0E00')||LA7_0=='\u0E31'||(LA7_0>='\u0E34' && LA7_0<='\u0E3F')||(LA7_0>='\u0E47' && LA7_0<='\u0E80')||LA7_0=='\u0E83'||(LA7_0>='\u0E85' && LA7_0<='\u0E86')||LA7_0=='\u0E89'||(LA7_0>='\u0E8B' && LA7_0<='\u0E8C')||(LA7_0>='\u0E8E' && LA7_0<='\u0E93')||LA7_0=='\u0E98'||LA7_0=='\u0EA0'||LA7_0=='\u0EA4'||LA7_0=='\u0EA6'||(LA7_0>='\u0EA8' && LA7_0<='\u0EA9')||LA7_0=='\u0EAC'||LA7_0=='\u0EB1'||(LA7_0>='\u0EB4' && LA7_0<='\u0EBC')||(LA7_0>='\u0EBE' && LA7_0<='\u0EBF')||LA7_0=='\u0EC5'||(LA7_0>='\u0EC7' && LA7_0<='\u0EDB')||(LA7_0>='\u0EDE' && LA7_0<='\u0EFF')||(LA7_0>='\u0F01' && LA7_0<='\u0F3F')||LA7_0=='\u0F48'||(LA7_0>='\u0F6B' && LA7_0<='\u0F87')||(LA7_0>='\u0F8C' && LA7_0<='\u0FFF')||LA7_0=='\u1022'||LA7_0=='\u1028'||(LA7_0>='\u102B' && LA7_0<='\u104F')||(LA7_0>='\u1056' && LA7_0<='\u109F')||(LA7_0>='\u10C6' && LA7_0<='\u10CF')||LA7_0=='\u10FB'||(LA7_0>='\u10FD' && LA7_0<='\u10FF')||(LA7_0>='\u115A' && LA7_0<='\u115E')||(LA7_0>='\u11A3' && LA7_0<='\u11A7')||(LA7_0>='\u11FA' && LA7_0<='\u11FF')||LA7_0=='\u1249'||(LA7_0>='\u124E' && LA7_0<='\u124F')||LA7_0=='\u1257'||LA7_0=='\u1259'||(LA7_0>='\u125E' && LA7_0<='\u125F')||LA7_0=='\u1289'||(LA7_0>='\u128E' && LA7_0<='\u128F')||LA7_0=='\u12B1'||(LA7_0>='\u12B6' && LA7_0<='\u12B7')||LA7_0=='\u12BF'||LA7_0=='\u12C1'||(LA7_0>='\u12C6' && LA7_0<='\u12C7')||LA7_0=='\u12D7'||LA7_0=='\u1311'||(LA7_0>='\u1316' && LA7_0<='\u1317')||(LA7_0>='\u135B' && LA7_0<='\u137F')||(LA7_0>='\u1390' && LA7_0<='\u139F')||(LA7_0>='\u13F5' && LA7_0<='\u1400')||(LA7_0>='\u166D' && LA7_0<='\u166E')||(LA7_0>='\u1677' && LA7_0<='\u1680')||(LA7_0>='\u169B' && LA7_0<='\u169F')||(LA7_0>='\u16EB' && LA7_0<='\u16ED')||(LA7_0>='\u16F1' && LA7_0<='\u16FF')||LA7_0=='\u170D'||(LA7_0>='\u1712' && LA7_0<='\u171F')||(LA7_0>='\u1732' && LA7_0<='\u173F')||(LA7_0>='\u1752' && LA7_0<='\u175F')||LA7_0=='\u176D'||(LA7_0>='\u1771' && LA7_0<='\u177F')||(LA7_0>='\u17B4' && LA7_0<='\u17D6')||(LA7_0>='\u17D8' && LA7_0<='\u17DB')||(LA7_0>='\u17DD' && LA7_0<='\u181F')||(LA7_0>='\u1878' && LA7_0<='\u187F')||(LA7_0>='\u18A9' && LA7_0<='\u18FF')||(LA7_0>='\u191D' && LA7_0<='\u194F')||(LA7_0>='\u196E' && LA7_0<='\u196F')||(LA7_0>='\u1975' && LA7_0<='\u197F')||(LA7_0>='\u19AA' && LA7_0<='\u19C0')||(LA7_0>='\u19C8' && LA7_0<='\u19FF')||(LA7_0>='\u1A17' && LA7_0<='\u1B04')||(LA7_0>='\u1B34' && LA7_0<='\u1B44')||(LA7_0>='\u1B4C' && LA7_0<='\u1CFF')||(LA7_0>='\u1DC0' && LA7_0<='\u1DFF')||(LA7_0>='\u1E9C' && LA7_0<='\u1E9F')||(LA7_0>='\u1EFA' && LA7_0<='\u1EFF')||(LA7_0>='\u1F16' && LA7_0<='\u1F17')||(LA7_0>='\u1F1E' && LA7_0<='\u1F1F')||(LA7_0>='\u1F46' && LA7_0<='\u1F47')||(LA7_0>='\u1F4E' && LA7_0<='\u1F4F')||LA7_0=='\u1F58'||LA7_0=='\u1F5A'||LA7_0=='\u1F5C'||LA7_0=='\u1F5E'||(LA7_0>='\u1F7E' && LA7_0<='\u1F7F')||LA7_0=='\u1FB5'||LA7_0=='\u1FBD'||(LA7_0>='\u1FBF' && LA7_0<='\u1FC1')||LA7_0=='\u1FC5'||(LA7_0>='\u1FCD' && LA7_0<='\u1FCF')||(LA7_0>='\u1FD4' && LA7_0<='\u1FD5')||(LA7_0>='\u1FDC' && LA7_0<='\u1FDF')||(LA7_0>='\u1FED' && LA7_0<='\u1FF1')||LA7_0=='\u1FF5'||(LA7_0>='\u1FFD' && LA7_0<='\u2070')||(LA7_0>='\u2072' && LA7_0<='\u207E')||(LA7_0>='\u2080' && LA7_0<='\u208F')||(LA7_0>='\u2095' && LA7_0<='\u2101')||(LA7_0>='\u2103' && LA7_0<='\u2106')||(LA7_0>='\u2108' && LA7_0<='\u2109')||LA7_0=='\u2114'||(LA7_0>='\u2116' && LA7_0<='\u2118')||(LA7_0>='\u211E' && LA7_0<='\u2123')||LA7_0=='\u2125'||LA7_0=='\u2127'||LA7_0=='\u2129'||LA7_0=='\u212E'||(LA7_0>='\u213A' && LA7_0<='\u213B')||(LA7_0>='\u2140' && LA7_0<='\u2144')||(LA7_0>='\u214A' && LA7_0<='\u214D')||(LA7_0>='\u214F' && LA7_0<='\u215F')||(LA7_0>='\u2185' && LA7_0<='\u2BFF')||LA7_0=='\u2C2F'||LA7_0=='\u2C5F'||(LA7_0>='\u2C6D' && LA7_0<='\u2C73')||(LA7_0>='\u2C78' && LA7_0<='\u2C7F')||(LA7_0>='\u2CE5' && LA7_0<='\u2CFF')||(LA7_0>='\u2D26' && LA7_0<='\u2D2F')||(LA7_0>='\u2D66' && LA7_0<='\u2D6E')||(LA7_0>='\u2D70' && LA7_0<='\u2D7F')||(LA7_0>='\u2D97' && LA7_0<='\u2D9F')||LA7_0=='\u2DA7'||LA7_0=='\u2DAF'||LA7_0=='\u2DB7'||LA7_0=='\u2DBF'||LA7_0=='\u2DC7'||LA7_0=='\u2DCF'||LA7_0=='\u2DD7'||(LA7_0>='\u2DDF' && LA7_0<='\u3004')||(LA7_0>='\u3008' && LA7_0<='\u3020')||(LA7_0>='\u302A' && LA7_0<='\u3030')||(LA7_0>='\u3036' && LA7_0<='\u3037')||(LA7_0>='\u303D' && LA7_0<='\u3040')||(LA7_0>='\u3097' && LA7_0<='\u309C')||LA7_0=='\u30A0'||LA7_0=='\u30FB'||(LA7_0>='\u3100' && LA7_0<='\u3104')||(LA7_0>='\u312D' && LA7_0<='\u3130')||(LA7_0>='\u318F' && LA7_0<='\u319F')||(LA7_0>='\u31B8' && LA7_0<='\u31EF')||(LA7_0>='\u3200' && LA7_0<='\u33FF')||(LA7_0>='\u4DB6' && LA7_0<='\u4DFF')||(LA7_0>='\u9FBC' && LA7_0<='\u9FFF')||(LA7_0>='\uA48D' && LA7_0<='\uA716')||(LA7_0>='\uA71B' && LA7_0<='\uA7FF')||LA7_0=='\uA802'||LA7_0=='\uA806'||LA7_0=='\uA80B'||(LA7_0>='\uA823' && LA7_0<='\uA83F')||(LA7_0>='\uA874' && LA7_0<='\uABFF')||(LA7_0>='\uD7A4' && LA7_0<='\uF8FF')||(LA7_0>='\uFA2E' && LA7_0<='\uFA2F')||(LA7_0>='\uFA6B' && LA7_0<='\uFA6F')||(LA7_0>='\uFADA' && LA7_0<='\uFAFF')||(LA7_0>='\uFB07' && LA7_0<='\uFB12')||(LA7_0>='\uFB18' && LA7_0<='\uFB1C')||LA7_0=='\uFB1E'||LA7_0=='\uFB29'||LA7_0=='\uFB37'||LA7_0=='\uFB3D'||LA7_0=='\uFB3F'||LA7_0=='\uFB42'||LA7_0=='\uFB45'||(LA7_0>='\uFBB2' && LA7_0<='\uFBD2')||(LA7_0>='\uFD3E' && LA7_0<='\uFD4F')||(LA7_0>='\uFD90' && LA7_0<='\uFD91')||(LA7_0>='\uFDC8' && LA7_0<='\uFDEF')||(LA7_0>='\uFDFC' && LA7_0<='\uFE6F')||LA7_0=='\uFE75'||(LA7_0>='\uFEFD' && LA7_0<='\uFF20')||(LA7_0>='\uFF3B' && LA7_0<='\uFF40')||(LA7_0>='\uFF5B' && LA7_0<='\uFF65')||(LA7_0>='\uFFBF' && LA7_0<='\uFFC1')||(LA7_0>='\uFFC8' && LA7_0<='\uFFC9')||(LA7_0>='\uFFD0' && LA7_0<='\uFFD1')||(LA7_0>='\uFFD8' && LA7_0<='\uFFD9')||(LA7_0>='\uFFDD' && LA7_0<='\uFFFF')) ) {s = 28;}

                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA7_123 = input.LA(1);

                        s = -1;
                        if ( (LA7_123=='*') ) {s = 66;}

                        else if ( (LA7_123=='&') ) {s = 61;}

                        else if ( (LA7_123=='+') ) {s = 62;}

                        else if ( (LA7_123=='-') ) {s = 63;}

                        else if ( (LA7_123=='~') ) {s = 64;}

                        else if ( (LA7_123=='!') ) {s = 65;}

                        else if ( (LA7_123=='/') ) {s = 67;}

                        else if ( (LA7_123=='%') ) {s = 68;}

                        else if ( (LA7_123=='<') ) {s = 69;}

                        else if ( (LA7_123=='>') ) {s = 70;}

                        else if ( (LA7_123=='=') ) {s = 71;}

                        else if ( (LA7_123=='.') ) {s = 72;}

                        else if ( (LA7_123==';') ) {s = 73;}

                        else if ( (LA7_123=='^') ) {s = 74;}

                        else if ( (LA7_123=='|') ) {s = 75;}

                        else if ( (LA7_123=='?') ) {s = 76;}

                        else if ( (LA7_123==':') ) {s = 77;}

                        else if ( (LA7_123=='(') ) {s = 78;}

                        else if ( (LA7_123==')') ) {s = 79;}

                        else if ( (LA7_123=='[') ) {s = 80;}

                        else if ( (LA7_123==']') ) {s = 81;}

                        else if ( (LA7_123=='{') ) {s = 82;}

                        else if ( (LA7_123=='}') ) {s = 83;}

                        else if ( ((LA7_123>='\u0000' && LA7_123<=' ')||(LA7_123>='\"' && LA7_123<='$')||LA7_123=='\''||LA7_123==','||(LA7_123>='0' && LA7_123<='9')||(LA7_123>='@' && LA7_123<='Z')||LA7_123=='\\'||(LA7_123>='_' && LA7_123<='z')||(LA7_123>='\u007F' && LA7_123<='\uFFFF')) ) {s = 84;}

                        else s = 31;

                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA7_122 = input.LA(1);

                        s = -1;
                        if ( (LA7_122=='*') ) {s = 66;}

                        else if ( (LA7_122=='&') ) {s = 61;}

                        else if ( (LA7_122=='+') ) {s = 62;}

                        else if ( (LA7_122=='-') ) {s = 63;}

                        else if ( (LA7_122=='~') ) {s = 64;}

                        else if ( (LA7_122=='!') ) {s = 65;}

                        else if ( (LA7_122=='/') ) {s = 67;}

                        else if ( (LA7_122=='%') ) {s = 68;}

                        else if ( (LA7_122=='<') ) {s = 69;}

                        else if ( (LA7_122=='>') ) {s = 70;}

                        else if ( (LA7_122=='=') ) {s = 71;}

                        else if ( (LA7_122=='.') ) {s = 72;}

                        else if ( (LA7_122==';') ) {s = 73;}

                        else if ( (LA7_122=='^') ) {s = 74;}

                        else if ( (LA7_122=='|') ) {s = 75;}

                        else if ( (LA7_122=='?') ) {s = 76;}

                        else if ( (LA7_122==':') ) {s = 77;}

                        else if ( (LA7_122=='(') ) {s = 78;}

                        else if ( (LA7_122==')') ) {s = 79;}

                        else if ( (LA7_122=='[') ) {s = 80;}

                        else if ( (LA7_122==']') ) {s = 81;}

                        else if ( (LA7_122=='{') ) {s = 82;}

                        else if ( (LA7_122=='}') ) {s = 83;}

                        else if ( ((LA7_122>='\u0000' && LA7_122<=' ')||(LA7_122>='\"' && LA7_122<='$')||LA7_122=='\''||LA7_122==','||(LA7_122>='0' && LA7_122<='9')||(LA7_122>='@' && LA7_122<='Z')||LA7_122=='\\'||(LA7_122>='_' && LA7_122<='z')||(LA7_122>='\u007F' && LA7_122<='\uFFFF')) ) {s = 84;}

                        else s = 31;

                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA7_109 = input.LA(1);

                        s = -1;
                        if ( (LA7_109=='*') ) {s = 66;}

                        else if ( (LA7_109=='&') ) {s = 61;}

                        else if ( (LA7_109=='+') ) {s = 62;}

                        else if ( (LA7_109=='-') ) {s = 63;}

                        else if ( (LA7_109=='~') ) {s = 64;}

                        else if ( (LA7_109=='!') ) {s = 65;}

                        else if ( (LA7_109=='/') ) {s = 67;}

                        else if ( (LA7_109=='%') ) {s = 68;}

                        else if ( (LA7_109=='<') ) {s = 69;}

                        else if ( (LA7_109=='>') ) {s = 70;}

                        else if ( (LA7_109=='=') ) {s = 71;}

                        else if ( (LA7_109=='.') ) {s = 72;}

                        else if ( (LA7_109==';') ) {s = 73;}

                        else if ( (LA7_109=='^') ) {s = 74;}

                        else if ( (LA7_109=='|') ) {s = 75;}

                        else if ( (LA7_109=='?') ) {s = 76;}

                        else if ( (LA7_109==':') ) {s = 77;}

                        else if ( (LA7_109=='(') ) {s = 78;}

                        else if ( (LA7_109==')') ) {s = 79;}

                        else if ( (LA7_109=='[') ) {s = 80;}

                        else if ( (LA7_109==']') ) {s = 81;}

                        else if ( (LA7_109=='{') ) {s = 82;}

                        else if ( (LA7_109=='}') ) {s = 83;}

                        else if ( ((LA7_109>='\u0000' && LA7_109<=' ')||(LA7_109>='\"' && LA7_109<='$')||LA7_109=='\''||LA7_109==','||(LA7_109>='0' && LA7_109<='9')||(LA7_109>='@' && LA7_109<='Z')||LA7_109=='\\'||(LA7_109>='_' && LA7_109<='z')||(LA7_109>='\u007F' && LA7_109<='\uFFFF')) ) {s = 84;}

                        else s = 31;

                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA7_61 = input.LA(1);

                        s = -1;
                        if ( (LA7_61=='l') ) {s = 89;}

                        else if ( (LA7_61=='a') ) {s = 90;}

                        else if ( (LA7_61=='q') ) {s = 91;}

                        else if ( (LA7_61=='g') ) {s = 92;}

                        else if ( (LA7_61=='*') ) {s = 66;}

                        else if ( (LA7_61=='&') ) {s = 61;}

                        else if ( (LA7_61=='+') ) {s = 62;}

                        else if ( (LA7_61=='-') ) {s = 63;}

                        else if ( (LA7_61=='~') ) {s = 64;}

                        else if ( (LA7_61=='!') ) {s = 65;}

                        else if ( (LA7_61=='/') ) {s = 67;}

                        else if ( (LA7_61=='%') ) {s = 68;}

                        else if ( (LA7_61=='<') ) {s = 69;}

                        else if ( (LA7_61=='>') ) {s = 70;}

                        else if ( (LA7_61=='=') ) {s = 71;}

                        else if ( (LA7_61=='.') ) {s = 72;}

                        else if ( (LA7_61==';') ) {s = 73;}

                        else if ( (LA7_61=='^') ) {s = 74;}

                        else if ( (LA7_61=='|') ) {s = 75;}

                        else if ( (LA7_61=='?') ) {s = 76;}

                        else if ( (LA7_61==':') ) {s = 77;}

                        else if ( (LA7_61=='(') ) {s = 78;}

                        else if ( (LA7_61==')') ) {s = 79;}

                        else if ( (LA7_61=='[') ) {s = 80;}

                        else if ( (LA7_61==']') ) {s = 81;}

                        else if ( (LA7_61=='{') ) {s = 82;}

                        else if ( (LA7_61=='}') ) {s = 83;}

                        else if ( ((LA7_61>='\u0000' && LA7_61<=' ')||(LA7_61>='\"' && LA7_61<='$')||LA7_61=='\''||LA7_61==','||(LA7_61>='0' && LA7_61<='9')||(LA7_61>='@' && LA7_61<='Z')||LA7_61=='\\'||(LA7_61>='_' && LA7_61<='`')||(LA7_61>='b' && LA7_61<='f')||(LA7_61>='h' && LA7_61<='k')||(LA7_61>='m' && LA7_61<='p')||(LA7_61>='r' && LA7_61<='z')||(LA7_61>='\u007F' && LA7_61<='\uFFFF')) ) {s = 84;}

                        else s = 31;

                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA7_72 = input.LA(1);

                        s = -1;
                        if ( (LA7_72=='*') ) {s = 66;}

                        else if ( (LA7_72=='&') ) {s = 61;}

                        else if ( (LA7_72=='+') ) {s = 62;}

                        else if ( (LA7_72=='-') ) {s = 63;}

                        else if ( (LA7_72=='~') ) {s = 64;}

                        else if ( (LA7_72=='!') ) {s = 65;}

                        else if ( (LA7_72=='/') ) {s = 67;}

                        else if ( (LA7_72=='%') ) {s = 68;}

                        else if ( (LA7_72=='<') ) {s = 69;}

                        else if ( (LA7_72=='>') ) {s = 70;}

                        else if ( (LA7_72=='=') ) {s = 71;}

                        else if ( (LA7_72=='.') ) {s = 72;}

                        else if ( (LA7_72==';') ) {s = 73;}

                        else if ( (LA7_72=='^') ) {s = 74;}

                        else if ( (LA7_72=='|') ) {s = 75;}

                        else if ( (LA7_72=='?') ) {s = 76;}

                        else if ( (LA7_72==':') ) {s = 77;}

                        else if ( (LA7_72=='(') ) {s = 78;}

                        else if ( (LA7_72==')') ) {s = 79;}

                        else if ( (LA7_72=='[') ) {s = 80;}

                        else if ( (LA7_72==']') ) {s = 81;}

                        else if ( (LA7_72=='{') ) {s = 82;}

                        else if ( (LA7_72=='}') ) {s = 83;}

                        else if ( ((LA7_72>='\u0000' && LA7_72<=' ')||(LA7_72>='\"' && LA7_72<='$')||LA7_72=='\''||LA7_72==','||(LA7_72>='0' && LA7_72<='9')||(LA7_72>='@' && LA7_72<='Z')||LA7_72=='\\'||(LA7_72>='_' && LA7_72<='z')||(LA7_72>='\u007F' && LA7_72<='\uFFFF')) ) {s = 84;}

                        else s = 31;

                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA7_71 = input.LA(1);

                        s = -1;
                        if ( (LA7_71=='*') ) {s = 66;}

                        else if ( (LA7_71=='&') ) {s = 61;}

                        else if ( (LA7_71=='+') ) {s = 62;}

                        else if ( (LA7_71=='-') ) {s = 63;}

                        else if ( (LA7_71=='~') ) {s = 64;}

                        else if ( (LA7_71=='!') ) {s = 65;}

                        else if ( (LA7_71=='/') ) {s = 67;}

                        else if ( (LA7_71=='%') ) {s = 68;}

                        else if ( (LA7_71=='<') ) {s = 69;}

                        else if ( (LA7_71=='>') ) {s = 70;}

                        else if ( (LA7_71=='=') ) {s = 71;}

                        else if ( (LA7_71=='.') ) {s = 72;}

                        else if ( (LA7_71==';') ) {s = 73;}

                        else if ( (LA7_71=='^') ) {s = 74;}

                        else if ( (LA7_71=='|') ) {s = 75;}

                        else if ( (LA7_71=='?') ) {s = 76;}

                        else if ( (LA7_71==':') ) {s = 77;}

                        else if ( (LA7_71=='(') ) {s = 78;}

                        else if ( (LA7_71==')') ) {s = 79;}

                        else if ( (LA7_71=='[') ) {s = 80;}

                        else if ( (LA7_71==']') ) {s = 81;}

                        else if ( (LA7_71=='{') ) {s = 82;}

                        else if ( (LA7_71=='}') ) {s = 83;}

                        else if ( ((LA7_71>='\u0000' && LA7_71<=' ')||(LA7_71>='\"' && LA7_71<='$')||LA7_71=='\''||LA7_71==','||(LA7_71>='0' && LA7_71<='9')||(LA7_71>='@' && LA7_71<='Z')||LA7_71=='\\'||(LA7_71>='_' && LA7_71<='z')||(LA7_71>='\u007F' && LA7_71<='\uFFFF')) ) {s = 84;}

                        else s = 31;

                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA7_70 = input.LA(1);

                        s = -1;
                        if ( (LA7_70=='*') ) {s = 66;}

                        else if ( (LA7_70=='&') ) {s = 61;}

                        else if ( (LA7_70=='+') ) {s = 62;}

                        else if ( (LA7_70=='-') ) {s = 63;}

                        else if ( (LA7_70=='~') ) {s = 64;}

                        else if ( (LA7_70=='!') ) {s = 65;}

                        else if ( (LA7_70=='/') ) {s = 67;}

                        else if ( (LA7_70=='%') ) {s = 68;}

                        else if ( (LA7_70=='<') ) {s = 69;}

                        else if ( (LA7_70=='>') ) {s = 70;}

                        else if ( (LA7_70=='=') ) {s = 71;}

                        else if ( (LA7_70=='.') ) {s = 72;}

                        else if ( (LA7_70==';') ) {s = 73;}

                        else if ( (LA7_70=='^') ) {s = 74;}

                        else if ( (LA7_70=='|') ) {s = 75;}

                        else if ( (LA7_70=='?') ) {s = 76;}

                        else if ( (LA7_70==':') ) {s = 77;}

                        else if ( (LA7_70=='(') ) {s = 78;}

                        else if ( (LA7_70==')') ) {s = 79;}

                        else if ( (LA7_70=='[') ) {s = 80;}

                        else if ( (LA7_70==']') ) {s = 81;}

                        else if ( (LA7_70=='{') ) {s = 82;}

                        else if ( (LA7_70=='}') ) {s = 83;}

                        else if ( ((LA7_70>='\u0000' && LA7_70<=' ')||(LA7_70>='\"' && LA7_70<='$')||LA7_70=='\''||LA7_70==','||(LA7_70>='0' && LA7_70<='9')||(LA7_70>='@' && LA7_70<='Z')||LA7_70=='\\'||(LA7_70>='_' && LA7_70<='z')||(LA7_70>='\u007F' && LA7_70<='\uFFFF')) ) {s = 84;}

                        else s = 31;

                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA7_69 = input.LA(1);

                        s = -1;
                        if ( (LA7_69=='*') ) {s = 66;}

                        else if ( (LA7_69=='&') ) {s = 61;}

                        else if ( (LA7_69=='+') ) {s = 62;}

                        else if ( (LA7_69=='-') ) {s = 63;}

                        else if ( (LA7_69=='~') ) {s = 64;}

                        else if ( (LA7_69=='!') ) {s = 65;}

                        else if ( (LA7_69=='/') ) {s = 67;}

                        else if ( (LA7_69=='%') ) {s = 68;}

                        else if ( (LA7_69=='<') ) {s = 69;}

                        else if ( (LA7_69=='>') ) {s = 70;}

                        else if ( (LA7_69=='=') ) {s = 71;}

                        else if ( (LA7_69=='.') ) {s = 72;}

                        else if ( (LA7_69==';') ) {s = 73;}

                        else if ( (LA7_69=='^') ) {s = 74;}

                        else if ( (LA7_69=='|') ) {s = 75;}

                        else if ( (LA7_69=='?') ) {s = 76;}

                        else if ( (LA7_69==':') ) {s = 77;}

                        else if ( (LA7_69=='(') ) {s = 78;}

                        else if ( (LA7_69==')') ) {s = 79;}

                        else if ( (LA7_69=='[') ) {s = 80;}

                        else if ( (LA7_69==']') ) {s = 81;}

                        else if ( (LA7_69=='{') ) {s = 82;}

                        else if ( (LA7_69=='}') ) {s = 83;}

                        else if ( ((LA7_69>='\u0000' && LA7_69<=' ')||(LA7_69>='\"' && LA7_69<='$')||LA7_69=='\''||LA7_69==','||(LA7_69>='0' && LA7_69<='9')||(LA7_69>='@' && LA7_69<='Z')||LA7_69=='\\'||(LA7_69>='_' && LA7_69<='z')||(LA7_69>='\u007F' && LA7_69<='\uFFFF')) ) {s = 84;}

                        else s = 31;

                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA7_90 = input.LA(1);

                        s = -1;
                        if ( (LA7_90=='p') ) {s = 100;}

                        else if ( (LA7_90=='m') ) {s = 101;}

                        else if ( ((LA7_90>='\u0000' && LA7_90<='l')||(LA7_90>='n' && LA7_90<='o')||(LA7_90>='q' && LA7_90<='\uFFFF')) ) {s = 84;}

                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA7_68 = input.LA(1);

                        s = -1;
                        if ( (LA7_68=='*') ) {s = 66;}

                        else if ( (LA7_68=='&') ) {s = 61;}

                        else if ( (LA7_68=='+') ) {s = 62;}

                        else if ( (LA7_68=='-') ) {s = 63;}

                        else if ( (LA7_68=='~') ) {s = 64;}

                        else if ( (LA7_68=='!') ) {s = 65;}

                        else if ( (LA7_68=='/') ) {s = 67;}

                        else if ( (LA7_68=='%') ) {s = 68;}

                        else if ( (LA7_68=='<') ) {s = 69;}

                        else if ( (LA7_68=='>') ) {s = 70;}

                        else if ( (LA7_68=='=') ) {s = 71;}

                        else if ( (LA7_68=='.') ) {s = 72;}

                        else if ( (LA7_68==';') ) {s = 73;}

                        else if ( (LA7_68=='^') ) {s = 74;}

                        else if ( (LA7_68=='|') ) {s = 75;}

                        else if ( (LA7_68=='?') ) {s = 76;}

                        else if ( (LA7_68==':') ) {s = 77;}

                        else if ( (LA7_68=='(') ) {s = 78;}

                        else if ( (LA7_68==')') ) {s = 79;}

                        else if ( (LA7_68=='[') ) {s = 80;}

                        else if ( (LA7_68==']') ) {s = 81;}

                        else if ( (LA7_68=='{') ) {s = 82;}

                        else if ( (LA7_68=='}') ) {s = 83;}

                        else if ( ((LA7_68>='\u0000' && LA7_68<=' ')||(LA7_68>='\"' && LA7_68<='$')||LA7_68=='\''||LA7_68==','||(LA7_68>='0' && LA7_68<='9')||(LA7_68>='@' && LA7_68<='Z')||LA7_68=='\\'||(LA7_68>='_' && LA7_68<='z')||(LA7_68>='\u007F' && LA7_68<='\uFFFF')) ) {s = 84;}

                        else s = 31;

                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA7_67 = input.LA(1);

                        s = -1;
                        if ( (LA7_67=='*') ) {s = 66;}

                        else if ( (LA7_67=='&') ) {s = 61;}

                        else if ( (LA7_67=='+') ) {s = 62;}

                        else if ( (LA7_67=='-') ) {s = 63;}

                        else if ( (LA7_67=='~') ) {s = 64;}

                        else if ( (LA7_67=='!') ) {s = 65;}

                        else if ( (LA7_67=='/') ) {s = 67;}

                        else if ( (LA7_67=='%') ) {s = 68;}

                        else if ( (LA7_67=='<') ) {s = 69;}

                        else if ( (LA7_67=='>') ) {s = 70;}

                        else if ( (LA7_67=='=') ) {s = 71;}

                        else if ( (LA7_67=='.') ) {s = 72;}

                        else if ( (LA7_67==';') ) {s = 73;}

                        else if ( (LA7_67=='^') ) {s = 74;}

                        else if ( (LA7_67=='|') ) {s = 75;}

                        else if ( (LA7_67=='?') ) {s = 76;}

                        else if ( (LA7_67==':') ) {s = 77;}

                        else if ( (LA7_67=='(') ) {s = 78;}

                        else if ( (LA7_67==')') ) {s = 79;}

                        else if ( (LA7_67=='[') ) {s = 80;}

                        else if ( (LA7_67==']') ) {s = 81;}

                        else if ( (LA7_67=='{') ) {s = 82;}

                        else if ( (LA7_67=='}') ) {s = 83;}

                        else if ( ((LA7_67>='\u0000' && LA7_67<=' ')||(LA7_67>='\"' && LA7_67<='$')||LA7_67=='\''||LA7_67==','||(LA7_67>='0' && LA7_67<='9')||(LA7_67>='@' && LA7_67<='Z')||LA7_67=='\\'||(LA7_67>='_' && LA7_67<='z')||(LA7_67>='\u007F' && LA7_67<='\uFFFF')) ) {s = 84;}

                        else s = 31;

                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA7_65 = input.LA(1);

                        s = -1;
                        if ( (LA7_65=='*') ) {s = 66;}

                        else if ( (LA7_65=='&') ) {s = 61;}

                        else if ( (LA7_65=='+') ) {s = 62;}

                        else if ( (LA7_65=='-') ) {s = 63;}

                        else if ( (LA7_65=='~') ) {s = 64;}

                        else if ( (LA7_65=='!') ) {s = 65;}

                        else if ( (LA7_65=='/') ) {s = 67;}

                        else if ( (LA7_65=='%') ) {s = 68;}

                        else if ( (LA7_65=='<') ) {s = 69;}

                        else if ( (LA7_65=='>') ) {s = 70;}

                        else if ( (LA7_65=='=') ) {s = 71;}

                        else if ( (LA7_65=='.') ) {s = 72;}

                        else if ( (LA7_65==';') ) {s = 73;}

                        else if ( (LA7_65=='^') ) {s = 74;}

                        else if ( (LA7_65=='|') ) {s = 75;}

                        else if ( (LA7_65=='?') ) {s = 76;}

                        else if ( (LA7_65==':') ) {s = 77;}

                        else if ( (LA7_65=='(') ) {s = 78;}

                        else if ( (LA7_65==')') ) {s = 79;}

                        else if ( (LA7_65=='[') ) {s = 80;}

                        else if ( (LA7_65==']') ) {s = 81;}

                        else if ( (LA7_65=='{') ) {s = 82;}

                        else if ( (LA7_65=='}') ) {s = 83;}

                        else if ( ((LA7_65>='\u0000' && LA7_65<=' ')||(LA7_65>='\"' && LA7_65<='$')||LA7_65=='\''||LA7_65==','||(LA7_65>='0' && LA7_65<='9')||(LA7_65>='@' && LA7_65<='Z')||LA7_65=='\\'||(LA7_65>='_' && LA7_65<='z')||(LA7_65>='\u007F' && LA7_65<='\uFFFF')) ) {s = 84;}

                        else s = 31;

                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA7_64 = input.LA(1);

                        s = -1;
                        if ( (LA7_64=='*') ) {s = 66;}

                        else if ( (LA7_64=='&') ) {s = 61;}

                        else if ( (LA7_64=='+') ) {s = 62;}

                        else if ( (LA7_64=='-') ) {s = 63;}

                        else if ( (LA7_64=='~') ) {s = 64;}

                        else if ( (LA7_64=='!') ) {s = 65;}

                        else if ( (LA7_64=='/') ) {s = 67;}

                        else if ( (LA7_64=='%') ) {s = 68;}

                        else if ( (LA7_64=='<') ) {s = 69;}

                        else if ( (LA7_64=='>') ) {s = 70;}

                        else if ( (LA7_64=='=') ) {s = 71;}

                        else if ( (LA7_64=='.') ) {s = 72;}

                        else if ( (LA7_64==';') ) {s = 73;}

                        else if ( (LA7_64=='^') ) {s = 74;}

                        else if ( (LA7_64=='|') ) {s = 75;}

                        else if ( (LA7_64=='?') ) {s = 76;}

                        else if ( (LA7_64==':') ) {s = 77;}

                        else if ( (LA7_64=='(') ) {s = 78;}

                        else if ( (LA7_64==')') ) {s = 79;}

                        else if ( (LA7_64=='[') ) {s = 80;}

                        else if ( (LA7_64==']') ) {s = 81;}

                        else if ( (LA7_64=='{') ) {s = 82;}

                        else if ( (LA7_64=='}') ) {s = 83;}

                        else if ( ((LA7_64>='\u0000' && LA7_64<=' ')||(LA7_64>='\"' && LA7_64<='$')||LA7_64=='\''||LA7_64==','||(LA7_64>='0' && LA7_64<='9')||(LA7_64>='@' && LA7_64<='Z')||LA7_64=='\\'||(LA7_64>='_' && LA7_64<='z')||(LA7_64>='\u007F' && LA7_64<='\uFFFF')) ) {s = 84;}

                        else s = 31;

                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA7_63 = input.LA(1);

                        s = -1;
                        if ( (LA7_63=='*') ) {s = 66;}

                        else if ( (LA7_63=='&') ) {s = 61;}

                        else if ( (LA7_63=='+') ) {s = 62;}

                        else if ( (LA7_63=='-') ) {s = 63;}

                        else if ( (LA7_63=='~') ) {s = 64;}

                        else if ( (LA7_63=='!') ) {s = 65;}

                        else if ( (LA7_63=='/') ) {s = 67;}

                        else if ( (LA7_63=='%') ) {s = 68;}

                        else if ( (LA7_63=='<') ) {s = 69;}

                        else if ( (LA7_63=='>') ) {s = 70;}

                        else if ( (LA7_63=='=') ) {s = 71;}

                        else if ( (LA7_63=='.') ) {s = 72;}

                        else if ( (LA7_63==';') ) {s = 73;}

                        else if ( (LA7_63=='^') ) {s = 74;}

                        else if ( (LA7_63=='|') ) {s = 75;}

                        else if ( (LA7_63=='?') ) {s = 76;}

                        else if ( (LA7_63==':') ) {s = 77;}

                        else if ( (LA7_63=='(') ) {s = 78;}

                        else if ( (LA7_63==')') ) {s = 79;}

                        else if ( (LA7_63=='[') ) {s = 80;}

                        else if ( (LA7_63==']') ) {s = 81;}

                        else if ( (LA7_63=='{') ) {s = 82;}

                        else if ( (LA7_63=='}') ) {s = 83;}

                        else if ( ((LA7_63>='\u0000' && LA7_63<=' ')||(LA7_63>='\"' && LA7_63<='$')||LA7_63=='\''||LA7_63==','||(LA7_63>='0' && LA7_63<='9')||(LA7_63>='@' && LA7_63<='Z')||LA7_63=='\\'||(LA7_63>='_' && LA7_63<='z')||(LA7_63>='\u007F' && LA7_63<='\uFFFF')) ) {s = 84;}

                        else s = 31;

                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA7_62 = input.LA(1);

                        s = -1;
                        if ( (LA7_62=='*') ) {s = 66;}

                        else if ( (LA7_62=='&') ) {s = 61;}

                        else if ( (LA7_62=='+') ) {s = 62;}

                        else if ( (LA7_62=='-') ) {s = 63;}

                        else if ( (LA7_62=='~') ) {s = 64;}

                        else if ( (LA7_62=='!') ) {s = 65;}

                        else if ( (LA7_62=='/') ) {s = 67;}

                        else if ( (LA7_62=='%') ) {s = 68;}

                        else if ( (LA7_62=='<') ) {s = 69;}

                        else if ( (LA7_62=='>') ) {s = 70;}

                        else if ( (LA7_62=='=') ) {s = 71;}

                        else if ( (LA7_62=='.') ) {s = 72;}

                        else if ( (LA7_62==';') ) {s = 73;}

                        else if ( (LA7_62=='^') ) {s = 74;}

                        else if ( (LA7_62=='|') ) {s = 75;}

                        else if ( (LA7_62=='?') ) {s = 76;}

                        else if ( (LA7_62==':') ) {s = 77;}

                        else if ( (LA7_62=='(') ) {s = 78;}

                        else if ( (LA7_62==')') ) {s = 79;}

                        else if ( (LA7_62=='[') ) {s = 80;}

                        else if ( (LA7_62==']') ) {s = 81;}

                        else if ( (LA7_62=='{') ) {s = 82;}

                        else if ( (LA7_62=='}') ) {s = 83;}

                        else if ( ((LA7_62>='\u0000' && LA7_62<=' ')||(LA7_62>='\"' && LA7_62<='$')||LA7_62=='\''||LA7_62==','||(LA7_62>='0' && LA7_62<='9')||(LA7_62>='@' && LA7_62<='Z')||LA7_62=='\\'||(LA7_62>='_' && LA7_62<='z')||(LA7_62>='\u007F' && LA7_62<='\uFFFF')) ) {s = 84;}

                        else s = 31;

                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA7_118 = input.LA(1);

                        s = -1;
                        if ( (LA7_118=='*') ) {s = 66;}

                        else if ( (LA7_118=='&') ) {s = 61;}

                        else if ( (LA7_118=='+') ) {s = 62;}

                        else if ( (LA7_118=='-') ) {s = 63;}

                        else if ( (LA7_118=='~') ) {s = 64;}

                        else if ( (LA7_118=='!') ) {s = 65;}

                        else if ( (LA7_118=='/') ) {s = 67;}

                        else if ( (LA7_118=='%') ) {s = 68;}

                        else if ( (LA7_118=='<') ) {s = 69;}

                        else if ( (LA7_118=='>') ) {s = 70;}

                        else if ( (LA7_118=='=') ) {s = 71;}

                        else if ( (LA7_118=='.') ) {s = 72;}

                        else if ( (LA7_118==';') ) {s = 73;}

                        else if ( (LA7_118=='^') ) {s = 74;}

                        else if ( (LA7_118=='|') ) {s = 75;}

                        else if ( (LA7_118=='?') ) {s = 76;}

                        else if ( (LA7_118==':') ) {s = 77;}

                        else if ( (LA7_118=='(') ) {s = 78;}

                        else if ( (LA7_118==')') ) {s = 79;}

                        else if ( (LA7_118=='[') ) {s = 80;}

                        else if ( (LA7_118==']') ) {s = 81;}

                        else if ( (LA7_118=='{') ) {s = 82;}

                        else if ( (LA7_118=='}') ) {s = 83;}

                        else if ( ((LA7_118>='\u0000' && LA7_118<=' ')||(LA7_118>='\"' && LA7_118<='$')||LA7_118=='\''||LA7_118==','||(LA7_118>='0' && LA7_118<='9')||(LA7_118>='@' && LA7_118<='Z')||LA7_118=='\\'||(LA7_118>='_' && LA7_118<='z')||(LA7_118>='\u007F' && LA7_118<='\uFFFF')) ) {s = 84;}

                        else s = 31;

                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA7_113 = input.LA(1);

                        s = -1;
                        if ( (LA7_113=='*') ) {s = 66;}

                        else if ( (LA7_113=='&') ) {s = 61;}

                        else if ( (LA7_113=='+') ) {s = 62;}

                        else if ( (LA7_113=='-') ) {s = 63;}

                        else if ( (LA7_113=='~') ) {s = 64;}

                        else if ( (LA7_113=='!') ) {s = 65;}

                        else if ( (LA7_113=='/') ) {s = 67;}

                        else if ( (LA7_113=='%') ) {s = 68;}

                        else if ( (LA7_113=='<') ) {s = 69;}

                        else if ( (LA7_113=='>') ) {s = 70;}

                        else if ( (LA7_113=='=') ) {s = 71;}

                        else if ( (LA7_113=='.') ) {s = 72;}

                        else if ( (LA7_113==';') ) {s = 73;}

                        else if ( (LA7_113=='^') ) {s = 74;}

                        else if ( (LA7_113=='|') ) {s = 75;}

                        else if ( (LA7_113=='?') ) {s = 76;}

                        else if ( (LA7_113==':') ) {s = 77;}

                        else if ( (LA7_113=='(') ) {s = 78;}

                        else if ( (LA7_113==')') ) {s = 79;}

                        else if ( (LA7_113=='[') ) {s = 80;}

                        else if ( (LA7_113==']') ) {s = 81;}

                        else if ( (LA7_113=='{') ) {s = 82;}

                        else if ( (LA7_113=='}') ) {s = 83;}

                        else if ( ((LA7_113>='\u0000' && LA7_113<=' ')||(LA7_113>='\"' && LA7_113<='$')||LA7_113=='\''||LA7_113==','||(LA7_113>='0' && LA7_113<='9')||(LA7_113>='@' && LA7_113<='Z')||LA7_113=='\\'||(LA7_113>='_' && LA7_113<='z')||(LA7_113>='\u007F' && LA7_113<='\uFFFF')) ) {s = 84;}

                        else s = 31;

                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA7_80 = input.LA(1);

                        s = -1;
                        if ( (LA7_80=='*') ) {s = 66;}

                        else if ( (LA7_80=='&') ) {s = 61;}

                        else if ( (LA7_80=='+') ) {s = 62;}

                        else if ( (LA7_80=='-') ) {s = 63;}

                        else if ( (LA7_80=='~') ) {s = 64;}

                        else if ( (LA7_80=='!') ) {s = 65;}

                        else if ( (LA7_80=='/') ) {s = 67;}

                        else if ( (LA7_80=='%') ) {s = 68;}

                        else if ( (LA7_80=='<') ) {s = 69;}

                        else if ( (LA7_80=='>') ) {s = 70;}

                        else if ( (LA7_80=='=') ) {s = 71;}

                        else if ( (LA7_80=='.') ) {s = 72;}

                        else if ( (LA7_80==';') ) {s = 73;}

                        else if ( (LA7_80=='^') ) {s = 74;}

                        else if ( (LA7_80=='|') ) {s = 75;}

                        else if ( (LA7_80=='?') ) {s = 76;}

                        else if ( (LA7_80==':') ) {s = 77;}

                        else if ( (LA7_80=='(') ) {s = 78;}

                        else if ( (LA7_80==')') ) {s = 79;}

                        else if ( (LA7_80=='[') ) {s = 80;}

                        else if ( (LA7_80==']') ) {s = 81;}

                        else if ( (LA7_80=='{') ) {s = 82;}

                        else if ( (LA7_80=='}') ) {s = 83;}

                        else if ( ((LA7_80>='\u0000' && LA7_80<=' ')||(LA7_80>='\"' && LA7_80<='$')||LA7_80=='\''||LA7_80==','||(LA7_80>='0' && LA7_80<='9')||(LA7_80>='@' && LA7_80<='Z')||LA7_80=='\\'||(LA7_80>='_' && LA7_80<='z')||(LA7_80>='\u007F' && LA7_80<='\uFFFF')) ) {s = 84;}

                        else s = 31;

                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA7_81 = input.LA(1);

                        s = -1;
                        if ( (LA7_81=='*') ) {s = 66;}

                        else if ( (LA7_81=='&') ) {s = 61;}

                        else if ( (LA7_81=='+') ) {s = 62;}

                        else if ( (LA7_81=='-') ) {s = 63;}

                        else if ( (LA7_81=='~') ) {s = 64;}

                        else if ( (LA7_81=='!') ) {s = 65;}

                        else if ( (LA7_81=='/') ) {s = 67;}

                        else if ( (LA7_81=='%') ) {s = 68;}

                        else if ( (LA7_81=='<') ) {s = 69;}

                        else if ( (LA7_81=='>') ) {s = 70;}

                        else if ( (LA7_81=='=') ) {s = 71;}

                        else if ( (LA7_81=='.') ) {s = 72;}

                        else if ( (LA7_81==';') ) {s = 73;}

                        else if ( (LA7_81=='^') ) {s = 74;}

                        else if ( (LA7_81=='|') ) {s = 75;}

                        else if ( (LA7_81=='?') ) {s = 76;}

                        else if ( (LA7_81==':') ) {s = 77;}

                        else if ( (LA7_81=='(') ) {s = 78;}

                        else if ( (LA7_81==')') ) {s = 79;}

                        else if ( (LA7_81=='[') ) {s = 80;}

                        else if ( (LA7_81==']') ) {s = 81;}

                        else if ( (LA7_81=='{') ) {s = 82;}

                        else if ( (LA7_81=='}') ) {s = 83;}

                        else if ( ((LA7_81>='\u0000' && LA7_81<=' ')||(LA7_81>='\"' && LA7_81<='$')||LA7_81=='\''||LA7_81==','||(LA7_81>='0' && LA7_81<='9')||(LA7_81>='@' && LA7_81<='Z')||LA7_81=='\\'||(LA7_81>='_' && LA7_81<='z')||(LA7_81>='\u007F' && LA7_81<='\uFFFF')) ) {s = 84;}

                        else s = 31;

                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA7_82 = input.LA(1);

                        s = -1;
                        if ( (LA7_82=='*') ) {s = 66;}

                        else if ( (LA7_82=='&') ) {s = 61;}

                        else if ( (LA7_82=='+') ) {s = 62;}

                        else if ( (LA7_82=='-') ) {s = 63;}

                        else if ( (LA7_82=='~') ) {s = 64;}

                        else if ( (LA7_82=='!') ) {s = 65;}

                        else if ( (LA7_82=='/') ) {s = 67;}

                        else if ( (LA7_82=='%') ) {s = 68;}

                        else if ( (LA7_82=='<') ) {s = 69;}

                        else if ( (LA7_82=='>') ) {s = 70;}

                        else if ( (LA7_82=='=') ) {s = 71;}

                        else if ( (LA7_82=='.') ) {s = 72;}

                        else if ( (LA7_82==';') ) {s = 73;}

                        else if ( (LA7_82=='^') ) {s = 74;}

                        else if ( (LA7_82=='|') ) {s = 75;}

                        else if ( (LA7_82=='?') ) {s = 76;}

                        else if ( (LA7_82==':') ) {s = 77;}

                        else if ( (LA7_82=='(') ) {s = 78;}

                        else if ( (LA7_82==')') ) {s = 79;}

                        else if ( (LA7_82=='[') ) {s = 80;}

                        else if ( (LA7_82==']') ) {s = 81;}

                        else if ( (LA7_82=='{') ) {s = 82;}

                        else if ( (LA7_82=='}') ) {s = 83;}

                        else if ( ((LA7_82>='\u0000' && LA7_82<=' ')||(LA7_82>='\"' && LA7_82<='$')||LA7_82=='\''||LA7_82==','||(LA7_82>='0' && LA7_82<='9')||(LA7_82>='@' && LA7_82<='Z')||LA7_82=='\\'||(LA7_82>='_' && LA7_82<='z')||(LA7_82>='\u007F' && LA7_82<='\uFFFF')) ) {s = 84;}

                        else s = 31;

                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA7_83 = input.LA(1);

                        s = -1;
                        if ( (LA7_83=='*') ) {s = 66;}

                        else if ( (LA7_83=='&') ) {s = 61;}

                        else if ( (LA7_83=='+') ) {s = 62;}

                        else if ( (LA7_83=='-') ) {s = 63;}

                        else if ( (LA7_83=='~') ) {s = 64;}

                        else if ( (LA7_83=='!') ) {s = 65;}

                        else if ( (LA7_83=='/') ) {s = 67;}

                        else if ( (LA7_83=='%') ) {s = 68;}

                        else if ( (LA7_83=='<') ) {s = 69;}

                        else if ( (LA7_83=='>') ) {s = 70;}

                        else if ( (LA7_83=='=') ) {s = 71;}

                        else if ( (LA7_83=='.') ) {s = 72;}

                        else if ( (LA7_83==';') ) {s = 73;}

                        else if ( (LA7_83=='^') ) {s = 74;}

                        else if ( (LA7_83=='|') ) {s = 75;}

                        else if ( (LA7_83=='?') ) {s = 76;}

                        else if ( (LA7_83==':') ) {s = 77;}

                        else if ( (LA7_83=='(') ) {s = 78;}

                        else if ( (LA7_83==')') ) {s = 79;}

                        else if ( (LA7_83=='[') ) {s = 80;}

                        else if ( (LA7_83==']') ) {s = 81;}

                        else if ( (LA7_83=='{') ) {s = 82;}

                        else if ( (LA7_83=='}') ) {s = 83;}

                        else if ( ((LA7_83>='\u0000' && LA7_83<=' ')||(LA7_83>='\"' && LA7_83<='$')||LA7_83=='\''||LA7_83==','||(LA7_83>='0' && LA7_83<='9')||(LA7_83>='@' && LA7_83<='Z')||LA7_83=='\\'||(LA7_83>='_' && LA7_83<='z')||(LA7_83>='\u007F' && LA7_83<='\uFFFF')) ) {s = 84;}

                        else s = 31;

                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA7_73 = input.LA(1);

                        s = -1;
                        if ( (LA7_73=='*') ) {s = 66;}

                        else if ( (LA7_73=='&') ) {s = 61;}

                        else if ( (LA7_73=='+') ) {s = 62;}

                        else if ( (LA7_73=='-') ) {s = 63;}

                        else if ( (LA7_73=='~') ) {s = 64;}

                        else if ( (LA7_73=='!') ) {s = 65;}

                        else if ( (LA7_73=='/') ) {s = 67;}

                        else if ( (LA7_73=='%') ) {s = 68;}

                        else if ( (LA7_73=='<') ) {s = 69;}

                        else if ( (LA7_73=='>') ) {s = 70;}

                        else if ( (LA7_73=='=') ) {s = 71;}

                        else if ( (LA7_73=='.') ) {s = 72;}

                        else if ( (LA7_73==';') ) {s = 73;}

                        else if ( (LA7_73=='^') ) {s = 74;}

                        else if ( (LA7_73=='|') ) {s = 75;}

                        else if ( (LA7_73=='?') ) {s = 76;}

                        else if ( (LA7_73==':') ) {s = 77;}

                        else if ( (LA7_73=='(') ) {s = 78;}

                        else if ( (LA7_73==')') ) {s = 79;}

                        else if ( (LA7_73=='[') ) {s = 80;}

                        else if ( (LA7_73==']') ) {s = 81;}

                        else if ( (LA7_73=='{') ) {s = 82;}

                        else if ( (LA7_73=='}') ) {s = 83;}

                        else if ( ((LA7_73>='\u0000' && LA7_73<=' ')||(LA7_73>='\"' && LA7_73<='$')||LA7_73=='\''||LA7_73==','||(LA7_73>='0' && LA7_73<='9')||(LA7_73>='@' && LA7_73<='Z')||LA7_73=='\\'||(LA7_73>='_' && LA7_73<='z')||(LA7_73>='\u007F' && LA7_73<='\uFFFF')) ) {s = 84;}

                        else s = 31;

                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA7_74 = input.LA(1);

                        s = -1;
                        if ( (LA7_74=='*') ) {s = 66;}

                        else if ( (LA7_74=='&') ) {s = 61;}

                        else if ( (LA7_74=='+') ) {s = 62;}

                        else if ( (LA7_74=='-') ) {s = 63;}

                        else if ( (LA7_74=='~') ) {s = 64;}

                        else if ( (LA7_74=='!') ) {s = 65;}

                        else if ( (LA7_74=='/') ) {s = 67;}

                        else if ( (LA7_74=='%') ) {s = 68;}

                        else if ( (LA7_74=='<') ) {s = 69;}

                        else if ( (LA7_74=='>') ) {s = 70;}

                        else if ( (LA7_74=='=') ) {s = 71;}

                        else if ( (LA7_74=='.') ) {s = 72;}

                        else if ( (LA7_74==';') ) {s = 73;}

                        else if ( (LA7_74=='^') ) {s = 74;}

                        else if ( (LA7_74=='|') ) {s = 75;}

                        else if ( (LA7_74=='?') ) {s = 76;}

                        else if ( (LA7_74==':') ) {s = 77;}

                        else if ( (LA7_74=='(') ) {s = 78;}

                        else if ( (LA7_74==')') ) {s = 79;}

                        else if ( (LA7_74=='[') ) {s = 80;}

                        else if ( (LA7_74==']') ) {s = 81;}

                        else if ( (LA7_74=='{') ) {s = 82;}

                        else if ( (LA7_74=='}') ) {s = 83;}

                        else if ( ((LA7_74>='\u0000' && LA7_74<=' ')||(LA7_74>='\"' && LA7_74<='$')||LA7_74=='\''||LA7_74==','||(LA7_74>='0' && LA7_74<='9')||(LA7_74>='@' && LA7_74<='Z')||LA7_74=='\\'||(LA7_74>='_' && LA7_74<='z')||(LA7_74>='\u007F' && LA7_74<='\uFFFF')) ) {s = 84;}

                        else s = 31;

                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA7_75 = input.LA(1);

                        s = -1;
                        if ( (LA7_75=='*') ) {s = 66;}

                        else if ( (LA7_75=='&') ) {s = 61;}

                        else if ( (LA7_75=='+') ) {s = 62;}

                        else if ( (LA7_75=='-') ) {s = 63;}

                        else if ( (LA7_75=='~') ) {s = 64;}

                        else if ( (LA7_75=='!') ) {s = 65;}

                        else if ( (LA7_75=='/') ) {s = 67;}

                        else if ( (LA7_75=='%') ) {s = 68;}

                        else if ( (LA7_75=='<') ) {s = 69;}

                        else if ( (LA7_75=='>') ) {s = 70;}

                        else if ( (LA7_75=='=') ) {s = 71;}

                        else if ( (LA7_75=='.') ) {s = 72;}

                        else if ( (LA7_75==';') ) {s = 73;}

                        else if ( (LA7_75=='^') ) {s = 74;}

                        else if ( (LA7_75=='|') ) {s = 75;}

                        else if ( (LA7_75=='?') ) {s = 76;}

                        else if ( (LA7_75==':') ) {s = 77;}

                        else if ( (LA7_75=='(') ) {s = 78;}

                        else if ( (LA7_75==')') ) {s = 79;}

                        else if ( (LA7_75=='[') ) {s = 80;}

                        else if ( (LA7_75==']') ) {s = 81;}

                        else if ( (LA7_75=='{') ) {s = 82;}

                        else if ( (LA7_75=='}') ) {s = 83;}

                        else if ( ((LA7_75>='\u0000' && LA7_75<=' ')||(LA7_75>='\"' && LA7_75<='$')||LA7_75=='\''||LA7_75==','||(LA7_75>='0' && LA7_75<='9')||(LA7_75>='@' && LA7_75<='Z')||LA7_75=='\\'||(LA7_75>='_' && LA7_75<='z')||(LA7_75>='\u007F' && LA7_75<='\uFFFF')) ) {s = 84;}

                        else s = 31;

                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA7_76 = input.LA(1);

                        s = -1;
                        if ( (LA7_76=='*') ) {s = 66;}

                        else if ( (LA7_76=='&') ) {s = 61;}

                        else if ( (LA7_76=='+') ) {s = 62;}

                        else if ( (LA7_76=='-') ) {s = 63;}

                        else if ( (LA7_76=='~') ) {s = 64;}

                        else if ( (LA7_76=='!') ) {s = 65;}

                        else if ( (LA7_76=='/') ) {s = 67;}

                        else if ( (LA7_76=='%') ) {s = 68;}

                        else if ( (LA7_76=='<') ) {s = 69;}

                        else if ( (LA7_76=='>') ) {s = 70;}

                        else if ( (LA7_76=='=') ) {s = 71;}

                        else if ( (LA7_76=='.') ) {s = 72;}

                        else if ( (LA7_76==';') ) {s = 73;}

                        else if ( (LA7_76=='^') ) {s = 74;}

                        else if ( (LA7_76=='|') ) {s = 75;}

                        else if ( (LA7_76=='?') ) {s = 76;}

                        else if ( (LA7_76==':') ) {s = 77;}

                        else if ( (LA7_76=='(') ) {s = 78;}

                        else if ( (LA7_76==')') ) {s = 79;}

                        else if ( (LA7_76=='[') ) {s = 80;}

                        else if ( (LA7_76==']') ) {s = 81;}

                        else if ( (LA7_76=='{') ) {s = 82;}

                        else if ( (LA7_76=='}') ) {s = 83;}

                        else if ( ((LA7_76>='\u0000' && LA7_76<=' ')||(LA7_76>='\"' && LA7_76<='$')||LA7_76=='\''||LA7_76==','||(LA7_76>='0' && LA7_76<='9')||(LA7_76>='@' && LA7_76<='Z')||LA7_76=='\\'||(LA7_76>='_' && LA7_76<='z')||(LA7_76>='\u007F' && LA7_76<='\uFFFF')) ) {s = 84;}

                        else s = 31;

                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA7_77 = input.LA(1);

                        s = -1;
                        if ( (LA7_77=='*') ) {s = 66;}

                        else if ( (LA7_77=='&') ) {s = 61;}

                        else if ( (LA7_77=='+') ) {s = 62;}

                        else if ( (LA7_77=='-') ) {s = 63;}

                        else if ( (LA7_77=='~') ) {s = 64;}

                        else if ( (LA7_77=='!') ) {s = 65;}

                        else if ( (LA7_77=='/') ) {s = 67;}

                        else if ( (LA7_77=='%') ) {s = 68;}

                        else if ( (LA7_77=='<') ) {s = 69;}

                        else if ( (LA7_77=='>') ) {s = 70;}

                        else if ( (LA7_77=='=') ) {s = 71;}

                        else if ( (LA7_77=='.') ) {s = 72;}

                        else if ( (LA7_77==';') ) {s = 73;}

                        else if ( (LA7_77=='^') ) {s = 74;}

                        else if ( (LA7_77=='|') ) {s = 75;}

                        else if ( (LA7_77=='?') ) {s = 76;}

                        else if ( (LA7_77==':') ) {s = 77;}

                        else if ( (LA7_77=='(') ) {s = 78;}

                        else if ( (LA7_77==')') ) {s = 79;}

                        else if ( (LA7_77=='[') ) {s = 80;}

                        else if ( (LA7_77==']') ) {s = 81;}

                        else if ( (LA7_77=='{') ) {s = 82;}

                        else if ( (LA7_77=='}') ) {s = 83;}

                        else if ( ((LA7_77>='\u0000' && LA7_77<=' ')||(LA7_77>='\"' && LA7_77<='$')||LA7_77=='\''||LA7_77==','||(LA7_77>='0' && LA7_77<='9')||(LA7_77>='@' && LA7_77<='Z')||LA7_77=='\\'||(LA7_77>='_' && LA7_77<='z')||(LA7_77>='\u007F' && LA7_77<='\uFFFF')) ) {s = 84;}

                        else s = 31;

                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA7_78 = input.LA(1);

                        s = -1;
                        if ( (LA7_78=='*') ) {s = 66;}

                        else if ( (LA7_78=='&') ) {s = 61;}

                        else if ( (LA7_78=='+') ) {s = 62;}

                        else if ( (LA7_78=='-') ) {s = 63;}

                        else if ( (LA7_78=='~') ) {s = 64;}

                        else if ( (LA7_78=='!') ) {s = 65;}

                        else if ( (LA7_78=='/') ) {s = 67;}

                        else if ( (LA7_78=='%') ) {s = 68;}

                        else if ( (LA7_78=='<') ) {s = 69;}

                        else if ( (LA7_78=='>') ) {s = 70;}

                        else if ( (LA7_78=='=') ) {s = 71;}

                        else if ( (LA7_78=='.') ) {s = 72;}

                        else if ( (LA7_78==';') ) {s = 73;}

                        else if ( (LA7_78=='^') ) {s = 74;}

                        else if ( (LA7_78=='|') ) {s = 75;}

                        else if ( (LA7_78=='?') ) {s = 76;}

                        else if ( (LA7_78==':') ) {s = 77;}

                        else if ( (LA7_78=='(') ) {s = 78;}

                        else if ( (LA7_78==')') ) {s = 79;}

                        else if ( (LA7_78=='[') ) {s = 80;}

                        else if ( (LA7_78==']') ) {s = 81;}

                        else if ( (LA7_78=='{') ) {s = 82;}

                        else if ( (LA7_78=='}') ) {s = 83;}

                        else if ( ((LA7_78>='\u0000' && LA7_78<=' ')||(LA7_78>='\"' && LA7_78<='$')||LA7_78=='\''||LA7_78==','||(LA7_78>='0' && LA7_78<='9')||(LA7_78>='@' && LA7_78<='Z')||LA7_78=='\\'||(LA7_78>='_' && LA7_78<='z')||(LA7_78>='\u007F' && LA7_78<='\uFFFF')) ) {s = 84;}

                        else s = 31;

                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA7_79 = input.LA(1);

                        s = -1;
                        if ( (LA7_79=='*') ) {s = 66;}

                        else if ( (LA7_79=='&') ) {s = 61;}

                        else if ( (LA7_79=='+') ) {s = 62;}

                        else if ( (LA7_79=='-') ) {s = 63;}

                        else if ( (LA7_79=='~') ) {s = 64;}

                        else if ( (LA7_79=='!') ) {s = 65;}

                        else if ( (LA7_79=='/') ) {s = 67;}

                        else if ( (LA7_79=='%') ) {s = 68;}

                        else if ( (LA7_79=='<') ) {s = 69;}

                        else if ( (LA7_79=='>') ) {s = 70;}

                        else if ( (LA7_79=='=') ) {s = 71;}

                        else if ( (LA7_79=='.') ) {s = 72;}

                        else if ( (LA7_79==';') ) {s = 73;}

                        else if ( (LA7_79=='^') ) {s = 74;}

                        else if ( (LA7_79=='|') ) {s = 75;}

                        else if ( (LA7_79=='?') ) {s = 76;}

                        else if ( (LA7_79==':') ) {s = 77;}

                        else if ( (LA7_79=='(') ) {s = 78;}

                        else if ( (LA7_79==')') ) {s = 79;}

                        else if ( (LA7_79=='[') ) {s = 80;}

                        else if ( (LA7_79==']') ) {s = 81;}

                        else if ( (LA7_79=='{') ) {s = 82;}

                        else if ( (LA7_79=='}') ) {s = 83;}

                        else if ( ((LA7_79>='\u0000' && LA7_79<=' ')||(LA7_79>='\"' && LA7_79<='$')||LA7_79=='\''||LA7_79==','||(LA7_79>='0' && LA7_79<='9')||(LA7_79>='@' && LA7_79<='Z')||LA7_79=='\\'||(LA7_79>='_' && LA7_79<='z')||(LA7_79>='\u007F' && LA7_79<='\uFFFF')) ) {s = 84;}

                        else s = 31;

                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA7_66 = input.LA(1);

                        s = -1;
                        if ( (LA7_66=='/') ) {s = 93;}

                        else if ( (LA7_66=='*') ) {s = 66;}

                        else if ( (LA7_66=='&') ) {s = 61;}

                        else if ( (LA7_66=='+') ) {s = 62;}

                        else if ( (LA7_66=='-') ) {s = 63;}

                        else if ( (LA7_66=='~') ) {s = 64;}

                        else if ( (LA7_66=='!') ) {s = 65;}

                        else if ( (LA7_66=='%') ) {s = 68;}

                        else if ( (LA7_66=='<') ) {s = 69;}

                        else if ( (LA7_66=='>') ) {s = 70;}

                        else if ( (LA7_66=='=') ) {s = 71;}

                        else if ( (LA7_66=='.') ) {s = 72;}

                        else if ( (LA7_66==';') ) {s = 73;}

                        else if ( (LA7_66=='^') ) {s = 74;}

                        else if ( (LA7_66=='|') ) {s = 75;}

                        else if ( (LA7_66=='?') ) {s = 76;}

                        else if ( (LA7_66==':') ) {s = 77;}

                        else if ( (LA7_66=='(') ) {s = 78;}

                        else if ( (LA7_66==')') ) {s = 79;}

                        else if ( (LA7_66=='[') ) {s = 80;}

                        else if ( (LA7_66==']') ) {s = 81;}

                        else if ( (LA7_66=='{') ) {s = 82;}

                        else if ( (LA7_66=='}') ) {s = 83;}

                        else if ( ((LA7_66>='\u0000' && LA7_66<=' ')||(LA7_66>='\"' && LA7_66<='$')||LA7_66=='\''||LA7_66==','||(LA7_66>='0' && LA7_66<='9')||(LA7_66>='@' && LA7_66<='Z')||LA7_66=='\\'||(LA7_66>='_' && LA7_66<='z')||(LA7_66>='\u007F' && LA7_66<='\uFFFF')) ) {s = 84;}

                        else s = 31;

                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA7_30 = input.LA(1);

                        s = -1;
                        if ( (LA7_30=='&') ) {s = 61;}

                        else if ( (LA7_30=='+') ) {s = 62;}

                        else if ( (LA7_30=='-') ) {s = 63;}

                        else if ( (LA7_30=='~') ) {s = 64;}

                        else if ( (LA7_30=='!') ) {s = 65;}

                        else if ( (LA7_30=='*') ) {s = 66;}

                        else if ( (LA7_30=='/') ) {s = 67;}

                        else if ( (LA7_30=='%') ) {s = 68;}

                        else if ( (LA7_30=='<') ) {s = 69;}

                        else if ( (LA7_30=='>') ) {s = 70;}

                        else if ( (LA7_30=='=') ) {s = 71;}

                        else if ( (LA7_30=='.') ) {s = 72;}

                        else if ( (LA7_30==';') ) {s = 73;}

                        else if ( (LA7_30=='^') ) {s = 74;}

                        else if ( (LA7_30=='|') ) {s = 75;}

                        else if ( (LA7_30=='?') ) {s = 76;}

                        else if ( (LA7_30==':') ) {s = 77;}

                        else if ( (LA7_30=='(') ) {s = 78;}

                        else if ( (LA7_30==')') ) {s = 79;}

                        else if ( (LA7_30=='[') ) {s = 80;}

                        else if ( (LA7_30==']') ) {s = 81;}

                        else if ( (LA7_30=='{') ) {s = 82;}

                        else if ( (LA7_30=='}') ) {s = 83;}

                        else if ( ((LA7_30>='\u0000' && LA7_30<=' ')||(LA7_30>='\"' && LA7_30<='$')||LA7_30=='\''||LA7_30==','||(LA7_30>='0' && LA7_30<='9')||(LA7_30>='@' && LA7_30<='Z')||LA7_30=='\\'||(LA7_30>='_' && LA7_30<='z')||(LA7_30>='\u007F' && LA7_30<='\uFFFF')) ) {s = 84;}

                        else s = 31;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 7, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}