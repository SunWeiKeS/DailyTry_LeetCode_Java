package backup.graduated.P03_Array;


import java.util.ArrayList;
import java.util.List;

public class P118_generate {
    public List<Integer> getRow(int numRows) {
        List<List<Integer>> res=new ArrayList<>();
        for (int i = 0; i <= numRows; i++) {
            List<Integer> part= new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if(j==0||j==i){
                    part.add(1);
                }else {
                    part.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
                }

            }
            res.add(part);
        }
        return res.get(numRows);
    }

}
