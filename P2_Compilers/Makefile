###
# This Makefile can be used to make a scanner for the Wumbo language
# (Yylex.class) and to make a program that tests the scanner (P2.class).
#
# The default makes both the scanner and the test program.
#
# make clean removes all generated files.
#
# Note: P2.java will not compile unless Yylex.class exists.
#
###

# define the java compiler to be used and the flags
JC = javac
FLAGS = -g -cp $(CP) 
CP = ./deps:.

P2.class: P2.java Yylex.class sym.class
	$(JC) $(FLAGS) P2.java

Yylex.class: wumbo.jlex.java ErrMsg.class sym.class
	$(JC) $(FLAGS) wumbo.jlex.java

wumbo.jlex.java: wumbo.jlex sym.class
	java -cp $(CP) JLex.Main wumbo.jlex

sym.class: sym.java
	$(JC) $(FLAGS) sym.java

ErrMsg.class: ErrMsg.java
	$(JC) $(FLAGS) ErrMsg.java

	
###
# testing - add more here to run your tester and compare its results
# to expected results
###
test:
	java -cp $(CP) P2.java
	diff  allTokens.in allTokens.out
	diff  testID.out testID_ExpectedOutput.out 
	diff  testIntLit.out testIntLit_ExpectedOutput.out
	diff  testStringLit.out testStringLit_ExpectedOutput.out
	diff  EndOfFile.out EndOfFile_ExpectedOutput.out
	diff  inputCharLine.out inputCharLine_Expected.out
###
# clean up
###

clean:
	rm -f *~ *.class wumbo.jlex.java

cleantest:
	rm -f allTokens.out
