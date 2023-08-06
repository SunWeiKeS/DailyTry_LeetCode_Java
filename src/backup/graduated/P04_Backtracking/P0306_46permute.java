package backup.graduated.P04_Backtracking;

import java.util.ArrayList;
import java.util.List;

public class P0306_46permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        dfs(res, list, nums);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }//如果到达末尾了，就添加进去

        for (int i = 0; i <nums.length; i++) {
            if(list.contains(nums[i]))
                continue;//如果包含了这个元素则跳出进入下一轮

            //如果没有包含这个元素则进行以下步骤
            list.add(nums[i]);
            dfs(res, list, nums);
            list.remove(list.size()-1);//这一步是一个逐层删除的过程！！！所以表现出来最后的使用完了list也清空了

        }

    }

}
