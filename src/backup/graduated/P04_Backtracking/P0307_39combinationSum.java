package backup.graduated.P04_Backtracking;

import java.util.ArrayList;
import java.util.List;

public class P0307_39combinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        dfs(res, list, candidates,target,0);
        return res;

    }

    public void dfs(List<List<Integer>> res, List<Integer> list, int[] candidates,int target,int index) {
        //终止过程
        if(target<0)
            return;

        if(target==0){
            //这时候说明刚好满足条件了
            res.add(new ArrayList<>(list));
            return;
        }

        //遍历过程
        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            dfs(res,list, candidates, target-candidates[i],index);
            list.remove(list.size()-1);
            index++;//这一步的意思是下次就不能再用这个元素了 他对当前的i并没有什么影响，影响的是下一步的index
        }

    }
}
