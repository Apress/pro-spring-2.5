// $ANTLR 3.0 EdiReader.g 2007-10-03 21:18:05

package com.apress.prospring2.ch08.dsl;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class EdiReaderParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "SCRIPT_DEF", "READER_DEF", "EVENT_DEF", "LINE_DEF", "Ident", "StringLiteral", "Semi", "EscapeSequence", "WS", "'reader for'", "'end reader'", "'event'", "'end event'"
    };
    public static final int Ident=8;
    public static final int EVENT_DEF=6;
    public static final int SCRIPT_DEF=4;
    public static final int EscapeSequence=11;
    public static final int WS=12;
    public static final int EOF=-1;
    public static final int LINE_DEF=7;
    public static final int StringLiteral=9;
    public static final int Semi=10;
    public static final int READER_DEF=5;

        public EdiReaderParser(TokenStream input) {
            super(input);
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "EdiReader.g"; }


    public static class script_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start script
    // EdiReader.g:19:1: script : ( reader )+ -> ^( SCRIPT_DEF ( reader )+ ) ;
    public final script_return script() throws RecognitionException {
        script_return retval = new script_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        reader_return reader1 = null;


        RewriteRuleSubtreeStream stream_reader=new RewriteRuleSubtreeStream(adaptor,"rule reader");
        try {
            // EdiReader.g:20:4: ( ( reader )+ -> ^( SCRIPT_DEF ( reader )+ ) )
            // EdiReader.g:20:4: ( reader )+
            {
            // EdiReader.g:20:4: ( reader )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==13) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // EdiReader.g:20:4: reader
            	    {
            	    pushFollow(FOLLOW_reader_in_script69);
            	    reader1=reader();
            	    _fsp--;

            	    stream_reader.add(reader1.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            // AST REWRITE
            // elements: reader
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 20:12: -> ^( SCRIPT_DEF ( reader )+ )
            {
                // EdiReader.g:20:15: ^( SCRIPT_DEF ( reader )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(SCRIPT_DEF, "SCRIPT_DEF"), root_1);

                if ( !(stream_reader.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_reader.hasNext() ) {
                    adaptor.addChild(root_1, stream_reader.next());

                }
                stream_reader.reset();

                adaptor.addChild(root_0, root_1);
                }

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end script

    public static class reader_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start reader
    // EdiReader.g:23:1: reader : 'reader for' Ident ( ( eventHandler )+ ) 'end reader' -> ^( READER_DEF Ident ( eventHandler )+ ) ;
    public final reader_return reader() throws RecognitionException {
        reader_return retval = new reader_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal2=null;
        Token Ident3=null;
        Token string_literal5=null;
        eventHandler_return eventHandler4 = null;


        Object string_literal2_tree=null;
        Object Ident3_tree=null;
        Object string_literal5_tree=null;
        RewriteRuleTokenStream stream_Ident=new RewriteRuleTokenStream(adaptor,"token Ident");
        RewriteRuleTokenStream stream_13=new RewriteRuleTokenStream(adaptor,"token 13");
        RewriteRuleTokenStream stream_14=new RewriteRuleTokenStream(adaptor,"token 14");
        RewriteRuleSubtreeStream stream_eventHandler=new RewriteRuleSubtreeStream(adaptor,"rule eventHandler");
        try {
            // EdiReader.g:24:4: ( 'reader for' Ident ( ( eventHandler )+ ) 'end reader' -> ^( READER_DEF Ident ( eventHandler )+ ) )
            // EdiReader.g:24:4: 'reader for' Ident ( ( eventHandler )+ ) 'end reader'
            {
            string_literal2=(Token)input.LT(1);
            match(input,13,FOLLOW_13_in_reader92); 
            stream_13.add(string_literal2);

            Ident3=(Token)input.LT(1);
            match(input,Ident,FOLLOW_Ident_in_reader94); 
            stream_Ident.add(Ident3);

            // EdiReader.g:24:23: ( ( eventHandler )+ )
            // EdiReader.g:24:24: ( eventHandler )+
            {
            // EdiReader.g:24:24: ( eventHandler )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==15) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // EdiReader.g:24:24: eventHandler
            	    {
            	    pushFollow(FOLLOW_eventHandler_in_reader97);
            	    eventHandler4=eventHandler();
            	    _fsp--;

            	    stream_eventHandler.add(eventHandler4.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

            string_literal5=(Token)input.LT(1);
            match(input,14,FOLLOW_14_in_reader101); 
            stream_14.add(string_literal5);


            // AST REWRITE
            // elements: eventHandler, Ident
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 24:52: -> ^( READER_DEF Ident ( eventHandler )+ )
            {
                // EdiReader.g:24:55: ^( READER_DEF Ident ( eventHandler )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(READER_DEF, "READER_DEF"), root_1);

                adaptor.addChild(root_1, stream_Ident.next());
                if ( !(stream_eventHandler.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_eventHandler.hasNext() ) {
                    adaptor.addChild(root_1, stream_eventHandler.next());

                }
                stream_eventHandler.reset();

                adaptor.addChild(root_0, root_1);
                }

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end reader

    public static class eventHandler_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start eventHandler
    // EdiReader.g:27:1: eventHandler : 'event' Ident ( ( line )+ ) 'end event' -> ^( EVENT_DEF Ident ( line )+ ) ;
    public final eventHandler_return eventHandler() throws RecognitionException {
        eventHandler_return retval = new eventHandler_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal6=null;
        Token Ident7=null;
        Token string_literal9=null;
        line_return line8 = null;


        Object string_literal6_tree=null;
        Object Ident7_tree=null;
        Object string_literal9_tree=null;
        RewriteRuleTokenStream stream_Ident=new RewriteRuleTokenStream(adaptor,"token Ident");
        RewriteRuleTokenStream stream_16=new RewriteRuleTokenStream(adaptor,"token 16");
        RewriteRuleTokenStream stream_15=new RewriteRuleTokenStream(adaptor,"token 15");
        RewriteRuleSubtreeStream stream_line=new RewriteRuleSubtreeStream(adaptor,"rule line");
        try {
            // EdiReader.g:28:4: ( 'event' Ident ( ( line )+ ) 'end event' -> ^( EVENT_DEF Ident ( line )+ ) )
            // EdiReader.g:28:4: 'event' Ident ( ( line )+ ) 'end event'
            {
            string_literal6=(Token)input.LT(1);
            match(input,15,FOLLOW_15_in_eventHandler125); 
            stream_15.add(string_literal6);

            Ident7=(Token)input.LT(1);
            match(input,Ident,FOLLOW_Ident_in_eventHandler127); 
            stream_Ident.add(Ident7);

            // EdiReader.g:28:18: ( ( line )+ )
            // EdiReader.g:28:19: ( line )+
            {
            // EdiReader.g:28:19: ( line )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==StringLiteral) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // EdiReader.g:28:19: line
            	    {
            	    pushFollow(FOLLOW_line_in_eventHandler130);
            	    line8=line();
            	    _fsp--;

            	    stream_line.add(line8.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

            string_literal9=(Token)input.LT(1);
            match(input,16,FOLLOW_16_in_eventHandler134); 
            stream_16.add(string_literal9);


            // AST REWRITE
            // elements: Ident, line
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 28:38: -> ^( EVENT_DEF Ident ( line )+ )
            {
                // EdiReader.g:28:41: ^( EVENT_DEF Ident ( line )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(EVENT_DEF, "EVENT_DEF"), root_1);

                adaptor.addChild(root_1, stream_Ident.next());
                if ( !(stream_line.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_line.hasNext() ) {
                    adaptor.addChild(root_1, stream_line.next());

                }
                stream_line.reset();

                adaptor.addChild(root_0, root_1);
                }

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end eventHandler

    public static class line_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start line
    // EdiReader.g:31:1: line : StringLiteral Semi -> ^( LINE_DEF StringLiteral ) ;
    public final line_return line() throws RecognitionException {
        line_return retval = new line_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token StringLiteral10=null;
        Token Semi11=null;

        Object StringLiteral10_tree=null;
        Object Semi11_tree=null;
        RewriteRuleTokenStream stream_StringLiteral=new RewriteRuleTokenStream(adaptor,"token StringLiteral");
        RewriteRuleTokenStream stream_Semi=new RewriteRuleTokenStream(adaptor,"token Semi");

        try {
            // EdiReader.g:32:4: ( StringLiteral Semi -> ^( LINE_DEF StringLiteral ) )
            // EdiReader.g:32:4: StringLiteral Semi
            {
            StringLiteral10=(Token)input.LT(1);
            match(input,StringLiteral,FOLLOW_StringLiteral_in_line159); 
            stream_StringLiteral.add(StringLiteral10);

            Semi11=(Token)input.LT(1);
            match(input,Semi,FOLLOW_Semi_in_line161); 
            stream_Semi.add(Semi11);


            // AST REWRITE
            // elements: StringLiteral
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 32:23: -> ^( LINE_DEF StringLiteral )
            {
                // EdiReader.g:32:26: ^( LINE_DEF StringLiteral )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(LINE_DEF, "LINE_DEF"), root_1);

                adaptor.addChild(root_1, stream_StringLiteral.next());

                adaptor.addChild(root_0, root_1);
                }

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end line


 

    public static final BitSet FOLLOW_reader_in_script69 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_reader92 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_Ident_in_reader94 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_eventHandler_in_reader97 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_14_in_reader101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_eventHandler125 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_Ident_in_eventHandler127 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_line_in_eventHandler130 = new BitSet(new long[]{0x0000000000010200L});
    public static final BitSet FOLLOW_16_in_eventHandler134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLiteral_in_line159 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_Semi_in_line161 = new BitSet(new long[]{0x0000000000000002L});

}