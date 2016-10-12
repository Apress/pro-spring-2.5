// $ANTLR 3.0 EdiReader.g 2007-10-03 21:18:06

package com.apress.prospring2.ch08.dsl;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class EdiReaderLexer extends Lexer {
    public static final int Ident=8;
    public static final int T14=14;
    public static final int EVENT_DEF=6;
    public static final int SCRIPT_DEF=4;
    public static final int EscapeSequence=11;
    public static final int T15=15;
    public static final int WS=12;
    public static final int EOF=-1;
    public static final int LINE_DEF=7;
    public static final int Tokens=17;
    public static final int StringLiteral=9;
    public static final int T16=16;
    public static final int T13=13;
    public static final int Semi=10;
    public static final int READER_DEF=5;
    public EdiReaderLexer() {;} 
    public EdiReaderLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "EdiReader.g"; }

    // $ANTLR start T13
    public final void mT13() throws RecognitionException {
        try {
            int _type = T13;
            // EdiReader.g:6:7: ( 'reader for' )
            // EdiReader.g:6:7: 'reader for'
            {
            match("reader for"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T13

    // $ANTLR start T14
    public final void mT14() throws RecognitionException {
        try {
            int _type = T14;
            // EdiReader.g:7:7: ( 'end reader' )
            // EdiReader.g:7:7: 'end reader'
            {
            match("end reader"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T14

    // $ANTLR start T15
    public final void mT15() throws RecognitionException {
        try {
            int _type = T15;
            // EdiReader.g:8:7: ( 'event' )
            // EdiReader.g:8:7: 'event'
            {
            match("event"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T15

    // $ANTLR start T16
    public final void mT16() throws RecognitionException {
        try {
            int _type = T16;
            // EdiReader.g:9:7: ( 'end event' )
            // EdiReader.g:9:7: 'end event'
            {
            match("end event"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T16

    // $ANTLR start StringLiteral
    public final void mStringLiteral() throws RecognitionException {
        try {
            int _type = StringLiteral;
            // EdiReader.g:36:8: ( '\"' ( EscapeSequence | ~ ( '\\\\' | '\"' ) )* '\"' )
            // EdiReader.g:36:8: '\"' ( EscapeSequence | ~ ( '\\\\' | '\"' ) )* '\"'
            {
            match('\"'); 
            // EdiReader.g:36:12: ( EscapeSequence | ~ ( '\\\\' | '\"' ) )*
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='\\') ) {
                    alt1=1;
                }
                else if ( ((LA1_0>='\u0000' && LA1_0<='!')||(LA1_0>='#' && LA1_0<='[')||(LA1_0>=']' && LA1_0<='\uFFFE')) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // EdiReader.g:36:14: EscapeSequence
            	    {
            	    mEscapeSequence(); 

            	    }
            	    break;
            	case 2 :
            	    // EdiReader.g:36:31: ~ ( '\\\\' | '\"' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            match('\"'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end StringLiteral

    // $ANTLR start EscapeSequence
    public final void mEscapeSequence() throws RecognitionException {
        try {
            // EdiReader.g:41:9: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) )
            // EdiReader.g:41:9: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
            {
            match('\\'); 
            if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end EscapeSequence

    // $ANTLR start Ident
    public final void mIdent() throws RecognitionException {
        try {
            int _type = Ident;
            // EdiReader.g:44:9: ( ( 'a' .. 'z' | 'A' .. 'Z' )+ )
            // EdiReader.g:44:9: ( 'a' .. 'z' | 'A' .. 'Z' )+
            {
            // EdiReader.g:44:9: ( 'a' .. 'z' | 'A' .. 'Z' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='A' && LA2_0<='Z')||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // EdiReader.g:
            	    {
            	    if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


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

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end Ident

    // $ANTLR start Semi
    public final void mSemi() throws RecognitionException {
        try {
            int _type = Semi;
            // EdiReader.g:45:8: ( ';' )
            // EdiReader.g:45:8: ';'
            {
            match(';'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end Semi

    // $ANTLR start WS
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            // EdiReader.g:47:8: ( ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' ) )
            // EdiReader.g:47:8: ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' )
            {
            if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||(input.LA(1)>='\f' && input.LA(1)<='\r')||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            channel=99;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end WS

    public void mTokens() throws RecognitionException {
        // EdiReader.g:1:10: ( T13 | T14 | T15 | T16 | StringLiteral | Ident | Semi | WS )
        int alt3=8;
        switch ( input.LA(1) ) {
        case 'r':
            {
            int LA3_1 = input.LA(2);

            if ( (LA3_1=='e') ) {
                int LA3_7 = input.LA(3);

                if ( (LA3_7=='a') ) {
                    int LA3_10 = input.LA(4);

                    if ( (LA3_10=='d') ) {
                        int LA3_13 = input.LA(5);

                        if ( (LA3_13=='e') ) {
                            int LA3_16 = input.LA(6);

                            if ( (LA3_16=='r') ) {
                                int LA3_20 = input.LA(7);

                                if ( (LA3_20==' ') ) {
                                    alt3=1;
                                }
                                else {
                                    alt3=6;}
                            }
                            else {
                                alt3=6;}
                        }
                        else {
                            alt3=6;}
                    }
                    else {
                        alt3=6;}
                }
                else {
                    alt3=6;}
            }
            else {
                alt3=6;}
            }
            break;
        case 'e':
            {
            switch ( input.LA(2) ) {
            case 'v':
                {
                int LA3_8 = input.LA(3);

                if ( (LA3_8=='e') ) {
                    int LA3_11 = input.LA(4);

                    if ( (LA3_11=='n') ) {
                        int LA3_14 = input.LA(5);

                        if ( (LA3_14=='t') ) {
                            int LA3_17 = input.LA(6);

                            if ( ((LA3_17>='A' && LA3_17<='Z')||(LA3_17>='a' && LA3_17<='z')) ) {
                                alt3=6;
                            }
                            else {
                                alt3=3;}
                        }
                        else {
                            alt3=6;}
                    }
                    else {
                        alt3=6;}
                }
                else {
                    alt3=6;}
                }
                break;
            case 'n':
                {
                int LA3_9 = input.LA(3);

                if ( (LA3_9=='d') ) {
                    int LA3_12 = input.LA(4);

                    if ( (LA3_12==' ') ) {
                        int LA3_15 = input.LA(5);

                        if ( (LA3_15=='e') ) {
                            alt3=4;
                        }
                        else if ( (LA3_15=='r') ) {
                            alt3=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("1:1: Tokens : ( T13 | T14 | T15 | T16 | StringLiteral | Ident | Semi | WS );", 3, 15, input);

                            throw nvae;
                        }
                    }
                    else {
                        alt3=6;}
                }
                else {
                    alt3=6;}
                }
                break;
            default:
                alt3=6;}

            }
            break;
        case '\"':
            {
            alt3=5;
            }
            break;
        case 'A':
        case 'B':
        case 'C':
        case 'D':
        case 'E':
        case 'F':
        case 'G':
        case 'H':
        case 'I':
        case 'J':
        case 'K':
        case 'L':
        case 'M':
        case 'N':
        case 'O':
        case 'P':
        case 'Q':
        case 'R':
        case 'S':
        case 'T':
        case 'U':
        case 'V':
        case 'W':
        case 'X':
        case 'Y':
        case 'Z':
        case 'a':
        case 'b':
        case 'c':
        case 'd':
        case 'f':
        case 'g':
        case 'h':
        case 'i':
        case 'j':
        case 'k':
        case 'l':
        case 'm':
        case 'n':
        case 'o':
        case 'p':
        case 'q':
        case 's':
        case 't':
        case 'u':
        case 'v':
        case 'w':
        case 'x':
        case 'y':
        case 'z':
            {
            alt3=6;
            }
            break;
        case ';':
            {
            alt3=7;
            }
            break;
        case '\t':
        case '\n':
        case '\f':
        case '\r':
        case ' ':
            {
            alt3=8;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("1:1: Tokens : ( T13 | T14 | T15 | T16 | StringLiteral | Ident | Semi | WS );", 3, 0, input);

            throw nvae;
        }

        switch (alt3) {
            case 1 :
                // EdiReader.g:1:10: T13
                {
                mT13(); 

                }
                break;
            case 2 :
                // EdiReader.g:1:14: T14
                {
                mT14(); 

                }
                break;
            case 3 :
                // EdiReader.g:1:18: T15
                {
                mT15(); 

                }
                break;
            case 4 :
                // EdiReader.g:1:22: T16
                {
                mT16(); 

                }
                break;
            case 5 :
                // EdiReader.g:1:26: StringLiteral
                {
                mStringLiteral(); 

                }
                break;
            case 6 :
                // EdiReader.g:1:40: Ident
                {
                mIdent(); 

                }
                break;
            case 7 :
                // EdiReader.g:1:46: Semi
                {
                mSemi(); 

                }
                break;
            case 8 :
                // EdiReader.g:1:51: WS
                {
                mWS(); 

                }
                break;

        }

    }


 

}