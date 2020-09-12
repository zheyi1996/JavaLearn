//public int findTheLongestSubstring(String s) {
//        int res = 0;
//        int n = s.length();
//        Map<Integer, Integer> map = new HashMap<>();
//        int mask = 0;
//        for (int i = 0; i < n; i++) {
//        char c = s.charAt(i);
//        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
//        mask = mask ^ (1 << (c - 'a'));
//        }
//        if (mask == 0) res = Math.max(res, i + 1);
//        else if (map.containsKey(mask)) res = Math.max(res, i - map.get(mask));
//        else map.put(mask, i);
//        }
//        return res;
//        }