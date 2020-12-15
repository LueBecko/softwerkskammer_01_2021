package java15.jep378;

/**
 * <h1>JEP 378: Text Blocks</h1>
 * 
 * <h2>Summary</h2>
 * Add text blocks to the Java language.
 * A text block is a multi-line string literal that avoids the need for most escape sequences,
 * automatically formats the string in a predictable way, and gives the developer control over the format when desired.
 */
public class JEP378 {
    
    public static void main(String[] args) {
        JEP378 textBlocks = new JEP378();

        System.out.println("Vintage style");
        System.out.println(textBlocks.buildMultilineStringVintage());
        System.out.println();
        System.out.println("Fancy new world");
        System.out.println(textBlocks.buildMultilineStringFancy());
        System.out.println();
        System.out.println("Details");
        textBlocks.someFancyDetails();
    }

    public String buildMultilineStringVintage() {
        // note: escape sequences (/n) at the end of each line
        return "<html>\n" +
               "    <body>\n" +
               "        <p>Hello, world</p>\n" +
               "    </body>\n" +
               "</html>\n";
    }

    public String buildMultilineStringFancy() {
        // note: no escape sequences, just reads like the final produced text (no technical details).
        // Also note, that identation whitespaces and trailing whitespaces are croped automatically.
        return """
                <html>
                    <body>
                        <p>Hello, world</p>
                    </body>
                </html>
                """;
    }

    public void someFancyDetails() {
        // illegal sequence: """""" (a line break /n after the first """ and some letters are needed in there)
        String empty = """
        """;
        System.out.println(empty);

        // escape sequences are allowed, but not neccessary.
        String withEscape1 = """
        aaa\nbbb\nccc
        """;
        String withEscape2 = """
        aaa
        bbb
        ccc
        """;
        System.out.println(withEscape1);
        System.out.println(withEscape2);
        System.out.println(withEscape1.equals(withEscape2));

        // \ can not appear outside of a escape sequence (if you want \ in your text use \\)
        String withBackslash = """
        ay \\ oy
        """;
        System.out.println(withBackslash);

        // wrap without actual line breaks
        String vintageWrapping = "Lorem ipsum dolor sit amet, consectetur adipiscing " +
                 "elit, sed do eiusmod tempor incididunt ut labore " +
                 "et dolore magna aliqua.";

        String fancyWrapping = """
                        Lorem ipsum dolor sit amet, consectetur adipiscing \
                        elit, sed do eiusmod tempor incididunt ut labore \
                        et dolore magna aliqua.\
                        """;
        System.out.println(vintageWrapping);
        System.out.println(fancyWrapping);

        // concatenation works like you expect from Strings (but readability might suffer when you mix it too much)
        String greeting = "Hi ;-)";
        String withConcatenation = "public void print(Object o) \n{" +
              """
              System.out.println(\"""" + greeting + """
              \");
              System.out.println(Objects.toString(o));
              }
              """;

        System.out.println();
        System.out.println(withConcatenation);

        // quotes
        String withQuotes = """
        "When I use a word," Humpty Dumpty said,
        in rather a scornful tone, "it means just what I
        choose it to mean - neither more nor less."
        "The question is," said Alice, "whether you
        can make words mean so many different things."
        "The question is," said Humpty Dumpty,
        "which is to be master - that's all."
        """;
        System.out.println(withQuotes);

        String withTrippleQuotes = """
        String text = \"""
            A text block inside a text block
        \""";
        """;
        System.out.println(withTrippleQuotes);


        // Line terminators in the content are normalized from CR (\\u000D) 
        // and CRLF (\\u000D\\u000A) to LF (\\u000A) by the Java compiler.

        // automatic croping of identation whitespaces
        String withAutomaticCroping =   """
                                        <html>
                                            <body>
                                                <p>Hello, world</p>
                                            </body>
                                        </html>
                                        """;
        String suppressAutomaticCroping =   """
                                        <html>
                                            <body>
                                                <p>Hello, world</p>
                                            </body>
                                        </html>
""";
        System.out.println(withAutomaticCroping);
        System.out.println(suppressAutomaticCroping);
    }
}
