package BackUp.graduated.P06_String;

public class P05_replaceSpace {
    public String replaceSpace(String s) {
        /**
         * 每次替换，一个字符变成三个字符
         */
        int length=s.length();

        int size=0;
        char[]arrays= new char[length*3];

        for (char char_s:s.toCharArray()){
            if(char_s==' '){
                arrays[size++]='%';
                arrays[size++]='2';
                arrays[size++]='0';
            }else {
                arrays[size++]=char_s;
            }
        }

        return new String(arrays,0,size);
    }

    public String replaceSpace2(String s) {
        /**
         * 直接调用api
         */

        return s.replace(" ","%20");
    }
    public String replaceSpace3(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char char_s:s.toCharArray()){
            if(char_s==' '){
                stringBuilder.append("%20");
            }else {
                stringBuilder.append(char_s);
            }
        }

        return stringBuilder.toString();
    }
    public static void main(String[] args) {
        String s = "We are happy.";

        System.out.println(new P05_replaceSpace().replaceSpace3(s));
    }
}
