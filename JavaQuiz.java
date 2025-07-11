public class JavaQuiz extends BaseQuiz {
    public JavaQuiz() {
        super("Java");
    }

    public void loadQuestions() {
        questionBank.add(new String[]{"What is Java?", "Language", "Coffee", "Planet", "None", "A"});
        questionBank.add(new String[]{"Which is not OOP concept?", "Inheritance", "Encapsulation", "Compilation", "Polymorphism", "C"});
        questionBank.add(new String[]{"Java file extension?", ".java", ".js", ".class", ".py", "A"});
        questionBank.add(new String[]{"Java keyword?", "static", "define", "fun", "main", "A"});
        questionBank.add(new String[]{"Which is JVM component?", "ClassLoader", "Compiler", "Interpreter", "All", "D"});
        questionBank.add(new String[]{"Java uses?", "Curly Braces", "Colons", "Spaces", "Tabs", "A"});
        questionBank.add(new String[]{"Java logical operator?", "&&", "<>", "==", "=>", "A"});
        questionBank.add(new String[]{"Java control flow?", "for", "loop", "repeat", "foreach", "A"});
        questionBank.add(new String[]{"Java inheritance?", "extends", "implements", "inherits", "uses", "A"});
        questionBank.add(new String[]{"Java main method?", "public static void main", "static public main", "public main", "main void public", "A"});
    }
}
