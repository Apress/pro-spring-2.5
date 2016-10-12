grammar EdiReader;
options { output=AST; }

tokens {
    SCRIPT_DEF;
    READER_DEF;
    EVENT_DEF;
    LINE_DEF;
}

@header {
package com.apress.prospring2.ch08.dsl;
}

@lexer::header {
package com.apress.prospring2.ch08.dsl;
}

script	
	: reader+ -> ^(SCRIPT_DEF reader+)
	;
	
reader	
	: 'reader for' Ident (eventHandler+) 'end reader' -> ^(READER_DEF Ident eventHandler+) 
	;
	
eventHandler
	: 'event' Ident (line+) 'end event' -> ^(EVENT_DEF Ident line+)
	; 	

line	
	: StringLiteral Semi -> ^(LINE_DEF StringLiteral)
	;

StringLiteral
    :  '"' ( EscapeSequence | ~('\\'|'"') )* '"'
    ;

fragment
EscapeSequence
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    ;
		
Ident	:	('a'..'z'|'A'..'Z')+ ;
Semi	:	';';

WS  :  (' '|'\r'|'\t'|'\u000C'|'\n') {channel=99;}
    ;
