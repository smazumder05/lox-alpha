package com.sm.lox.tools;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class AstGenerator {

    /**
     * @param args
     */
    public static void main(String[] args)
            throws IOException {
        if (args.length != 1) {
            System.err.println ("Usage:generate ast <output directory must be provided.");
            System.exit (1);
        } else {
            String outputDir = args[0];
            defineAST (outputDir, "Expr", Arrays.asList (
                    "Binary: Expr left, Token operator, Expr right",
                    "Grouping: Expr expression",
                    "literal: Object value",
                    "Unary: Token operator, Expr right"
            ));
        }

    }

    /**
     * @param outputDir
     * @param types
     */
    private static void defineAST(String outputDir, String baseName, List<String> types) throws IOException {

        String path = outputDir + "/" + baseName + ".java";
        PrintWriter writer = new PrintWriter (path, "UTF-8");

        writer.println ("package com.sm.lox;");
        writer.println ();
        writer.println ("import java.util.List;");
        writer.println ();
        writer.println ("abstract class " + baseName + "{");
        // The AST classes
        for (String type : types) {
            String className = type.split (":")[0].trim ();
            String fields = type.split (":")[1].trim ();
            defineType (writer, baseName, className, fields);
        }

        writer.println ();
        writer.println ("}");
        writer.close ();
    }

    /**
     * Generates all the fields needed for the expression class
     */
    private static void defineType(PrintWriter pw, String baseName, String clazzName, String fieldsList) {
        pw.println (" static class " + clazzName + " extends " + baseName + " {");

        //Generate constructor
        pw.println ("   " + clazzName + " (" + fieldsList + ") {");
        //Store the parameters in the fields
        String[] fields = fieldsList.split (", ");
        for (String field : fields) {
            String name = field.split (" ")[1];
            pw.println ("      this." + name + " = " + name + ";");
        }
        pw.println ("    }");


        //fields
        pw.println ();
        for (String field : fields) {
            pw.println ("    final " + field + ";");
        }
        pw.println ("  }");
    }

}
