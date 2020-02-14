import java.util.*;
import java.io.*;
import java_cup.runtime.*;  // defines Symbol

/**
 * This program is to be used to test the Wumbo scanner.
 * This version is set up to test all tokens, but you are required to test 
 * other aspects of the scanner (e.g., input that causes errors, character 
 * numbers, values associated with tokens)
 */
public class P2 {

    public static void main(String[] args) throws IOException {
                                           // exception may be thrown by yylex
        // test all tokens
        testAllTokens();
        CharNum.num = 1;
    
        // ADD CALLS TO OTHER TEST METHODS HERE
    }
    
    
    
    /*
     * test string lit
     * test int lit
     * test id
     * test charnum and yyline
     * EOF

     */
    
    private static void testID(String inFile, String outFile) throws IOException {
        // open input and output files

        FileReader inputFile = null;
        PrintWriter outputFile = null;
        try {

        	    inputFile = new FileReader(inFile);
            outputFile = new PrintWriter(new FileWriter(outFile));
        } catch (FileNotFoundException ex) {
            System.err.println(inFile +" not found.");
            System.exit(-1);
        } catch (IOException ex) {
            System.err.println(outFile + " cannot be opened.");
            System.exit(-1);
        }

        // create and call the scanner
        Yylex scanner = new Yylex(inputFile);
        Symbol token = scanner.next_token();
        while (token.sym != sym.EOF) {
        		if(token.sym == sym.ID){
        			String currID = ((IdTokenVal)token.value).idVal;
        			outFile.println(currID);
        		}
            token = scanner.next_token();
        }
        outputFile.close();
    }

    private static void testIntLit(String inFile, String outFile) throws IOException {
        // open input and output files

        FileReader inputFile = null;
        PrintWriter outputFile = null;
        try {
        		inputFile = new FileReader(inFile);
            outputFile = new PrintWriter(new FileWriter(outFile));
        } catch (FileNotFoundException ex) {
            System.err.println(inFile + " not found.");
            System.exit(-1);
        } catch (IOException ex) {
            System.err.println(outFile + " cannot be opened.");
            System.exit(-1);
        }

        // create and call the scanner
        Yylex scanner = new Yylex(inputFile);
        Symbol token = scanner.next_token();
        while (token.sym != sym.EOF) {
	    if(token.sym == sym.INTLITERAL){
		int currIntLit = ((IntLitTokenVal)token.value).intVal;
                outputFile.println(currIntLit);
	    }
            token = scanner.next_token();
	}
        outputFile.close();
    }

    private static void testStringLit(String inFile, String outFile) throws IOException {
        // open input and output files
    	
        FileReader inputFile = null;
        PrintWriter outputFile = null;
        try {

        		inputFile = new FileReader(inFile);
            outputFile = new PrintWriter(new FileWriter(outFile));
        } catch (FileNotFoundException ex) {
            System.err.println(inFile + " not found.");
            System.exit(-1);
        } catch (IOException ex) {
            System.err.println(outFile + " cannot be opened.");
            System.exit(-1);
        }

        // create and call the scanner
        Yylex scanner = new Yylex(inputFile);
        Symbol token = scanner.next_token();
        while (token.sym != sym.EOF) {

	    if(token.sym == sym.STRINGLITERAL) {
		String currStringLit = ((StrLitTokenVal)token.value).strVal;
                outputFile.println(currStringLit);
	    }
            token = scanner.next_token();
	}
        outputFile.close();
    }
    
    

    /**
     * testAllTokens
     *
     * Open and read from file allTokens.txt
     * For each token read, write the corresponding string to allTokens.out
     * If the input file contains all tokens, one per line, we can verify
     * correctness of the scanner by comparing the input and output files
     * (e.g., using a 'diff' command).
     */
    private static void testAllTokens() throws IOException {
        // open input and output files
        FileReader inputFile = null;
        PrintWriter outputFile = null;
        try {
            inputFile = new FileReader("allTokens.in");
            outputFile = new PrintWriter(new FileWriter("allTokens.out"));
        } catch (FileNotFoundException ex) {
            System.err.println("File allTokens.in not found.");
            System.exit(-1);
        } catch (IOException ex) {
            System.err.println("allTokens.out cannot be opened.");
            System.exit(-1);
        }

        // create and call the scanner
        Yylex scanner = new Yylex(inputFile);
        Symbol token = scanner.next_token();
        while (token.sym != sym.EOF) {
            switch (token.sym) {
            case sym.BOOL:
                outputFile.println("bool"); 
                break;
            case sym.INT:
                outputFile.println("int");
                break;
            case sym.VOID:
                outputFile.println("void");
                break;
            case sym.TRUE:
                outputFile.println("true"); 
                break;
            case sym.FALSE:
                outputFile.println("false"); 
                break;
            case sym.STRUCT:
                outputFile.println("struct"); 
                break;
            case sym.CIN:
                outputFile.println("cin"); 
                break;
            case sym.COUT:
                outputFile.println("cout");
                break;				
            case sym.IF:
                outputFile.println("if");
                break;
            case sym.ELSE:
                outputFile.println("else");
                break;
            case sym.WHILE:
                outputFile.println("while");
                break;
            case sym.RETURN:
                outputFile.println("return");
                break;
            case sym.ID:
                outputFile.println(((IdTokenVal)token.value).idVal);
                break;
            case sym.INTLITERAL:  
                outputFile.println(((IntLitTokenVal)token.value).intVal);
                break;
            case sym.STRINGLITERAL: 
                outputFile.println(((StrLitTokenVal)token.value).strVal);
                break;    
            case sym.LCURLY:
                outputFile.println("{");
                break;
            case sym.RCURLY:
                outputFile.println("}");
                break;
            case sym.LPAREN:
                outputFile.println("(");
                break;
            case sym.RPAREN:
                outputFile.println(")");
                break;
            case sym.SEMICOLON:
                outputFile.println(";");
                break;
            case sym.COMMA:
                outputFile.println(",");
                break;
            case sym.DOT:
                outputFile.println(".");
                break;
            case sym.WRITE:
                outputFile.println("<<");
                break;
            case sym.READ:
                outputFile.println(">>");
                break;				
            case sym.PLUSPLUS:
                outputFile.println("++");
                break;
            case sym.MINUSMINUS:
                outputFile.println("--");
                break;	
            case sym.PLUS:
                outputFile.println("+");
                break;
            case sym.MINUS:
                outputFile.println("-");
                break;
            case sym.TIMES:
                outputFile.println("*");
                break;
            case sym.DIVIDE:
                outputFile.println("/");
                break;
            case sym.NOT:
                outputFile.println("!");
                break;
            case sym.AND:
                outputFile.println("&&");
                break;
            case sym.OR:
                outputFile.println("||");
                break;
            case sym.EQUALS:
                outputFile.println("==");
                break;
            case sym.NOTEQUALS:
                outputFile.println("!=");
                break;
            case sym.LESS:
                outputFile.println("<");
                break;
            case sym.GREATER:
                outputFile.println(">");
                break;
            case sym.LESSEQ:
                outputFile.println("<=");
                break;
            case sym.GREATEREQ:
                outputFile.println(">=");
                break;
			case sym.ASSIGN:
                outputFile.println("=");
                break;
			default:
				outputFile.println("UNKNOWN TOKEN");
            } // end switch

            token = scanner.next_token();
        } // end while
        outputFile.close();
    }
}
