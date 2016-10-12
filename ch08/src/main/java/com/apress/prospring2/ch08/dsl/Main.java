package com.apress.prospring2.ch08.dsl;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.tree.Tree;

import java.io.IOException;

/**
 * @author janm
 */
public class Main {
    public static void main(String[] args) throws IOException {
        try {
            CharStream cs = new ANTLRInputStream(Main.class.getResourceAsStream("EdiReaderScript.txt"));
            EdiReaderLexer lexer = new EdiReaderLexer(cs);
            CommonTokenStream tokens = new CommonTokenStream();
            tokens.setTokenSource(lexer);
            EdiReaderParser parser = new EdiReaderParser(tokens);
            parser.setTreeAdaptor(new CommonTreeAdaptor());
            EdiReaderParser.script_return script_return = parser.script();
            CommonTree t = (CommonTree)script_return.getTree();
            printTree(t, 0);
        } catch(Exception e) {
            System.err.println("exception: "+e);
        }
    }

    private static void printTree(CommonTree t, int indent) {
        if ( t != null ) {
            StringBuffer sb = new StringBuffer(indent);
            for ( int i = 0; i < indent; i++ )
                sb = sb.append("   ");
            for ( int i = 0; i < t.getChildCount(); i++ ) {
                Tree child = t.getChild(i);
                System.out.println(sb.toString() + child.toString());
                printTree((CommonTree)t.getChild(i), indent+1);
            }
        }
    }

}
