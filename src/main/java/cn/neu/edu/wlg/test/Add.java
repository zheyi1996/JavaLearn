//class Solution {
//    public static int [] f  = new int[1010];
//    public static void changeFather(int a,int b){
//        int a_ = find(a);
//        int b_ = find(b);
//        if(a_==b_)
//            return;
//        //赋值的时候也是把旧的赋值给新的
//        f[b_]= a_;
//
//    }
//    public static int find(int x){
//        while(x!=f[x]){
//            x = f[x];
//        }
//        return x;
//    }
//    public List<List<String>> accountsMerge(List<List<String>> accounts) {
//        int len = accounts.size();
//        for (int i = 0; i < 1010; i++) {
//            f[i]=i;
//        }
//        HashMap<String ,Integer> m = new HashMap<>();
//        for (int i = 0; i <len; i++) {
//            List<String> list = accounts.get(i);
//            for (int j = 1; j < accounts.get(i).size(); j++) {
//                if(m.containsKey(list.get(j))){
//                    //查找(左面是旧的右面是新的)
//                    changeFather(m.get(list.get(j)),i);
//                }
//                else{
//                    //没有就给他当前的
//                    m.put(list.get(j),f[i]);
//                }
//            }
//        }
//        //在循环一遍，找到所有的父级
//        //key是邮箱，value是他的父级
//        for(Map.Entry<String ,Integer> s:m.entrySet()){
//            s.setValue(find(s.getValue()));
//        }
//        Map<Integer,List<String>> mm = new HashMap<>();
//        for (Map.Entry<String,Integer> e:m.entrySet()) {
//            if(!mm.containsKey(e.getValue())){
//                List<String> lll = new ArrayList<>();
//                //把他父级的对应的名称拿过来
//                lll.add(accounts.get(e.getValue()).get(0));
//                mm.put(e.getValue(),lll);
//            }
//            //如果有名字了，直接添加
//            mm.get(e.getValue()).add(e.getKey());
//        }
//        //把最后的结果加起来
//        List<List<String>> ans = new LinkedList<>();
//        for (Map.Entry<Integer,List<String>> e:mm.entrySet()) {
//            List<String> lt = e.getValue();
//            Collections.sort(lt);
//            ans.add(lt);
//        }
//        return ans;
//    }
//}