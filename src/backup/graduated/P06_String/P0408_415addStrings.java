package backup.graduated.P06_String;

public class P0408_415addStrings {
    public String addStrings(String num1, String num2) {
        int i=num1.length()-1;
        int j=num2.length()-1;
        int carry=0;
        StringBuilder res= new StringBuilder("");
        while (i>=0||j>=0){
            int n1=i>=0?num1.charAt(i)-'0':0;
            int n2=j>=0?num2.charAt(j)-'0':0;

            int count=n1+n2+carry;
            carry=count/10;
            res.append(count%10);
            i--;
            j--;

        }
        if (carry==1) res.append(carry);
        return res.reverse().toString();
    }


}