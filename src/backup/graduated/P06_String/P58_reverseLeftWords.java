package backup.graduated.P06_String;


public class P58_reverseLeftWords {
    public String reverseLeftWords(String s, int n) {
        System.out.println(s);
        return s.substring(n,s.length())+s.substring(0,n);
    }

    public String reverseLeftWords2(String s, int n) {

        StringBuilder builder= new StringBuilder();

        for (int i = n; i < s.length(); i++) {
            builder.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            builder.append(s.charAt(i));
        }
        return builder.toString();
    }

    public String reverseLeftWords3(String s, int n) {

        StringBuilder builder= new StringBuilder();

        for (int i = n; i < s.length()+n; i++) {
            builder.append(s.charAt(i%s.length()));
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        P58_reverseLeftWords demo =new P58_reverseLeftWords();
        System.out.println(demo.reverseLeftWords("lrloseumgh",6));
        System.out.println(demo.reverseLeftWords2("lrloseumgh",6));
        System.out.println(demo.reverseLeftWords3("lrloseumgh",6));

    }
}
