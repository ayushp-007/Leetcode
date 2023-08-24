class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();
        int idx = 0, len = 0, n = words.length;
        for(int i = 0; i<n; i++) {
            if(len + words[i].length() + i - idx > maxWidth) {
                list.add(add(idx, i, words, maxWidth, maxWidth - len));
                idx = i;
                len = 0;
            }
            len += words[i].length();
        }
        list.add(add(idx, n, words, maxWidth, maxWidth - len));
        return list;
    }
    public String add(int begin, int end, String[] words, int d, int space) {
        StringBuilder sb = new StringBuilder();
        int gaps = end - begin - 1;
        if(end == words.length) {
            int t = 0, i = begin;
            for(; i<end - 1; i++) {
                sb.append(words[i] + " ");
                t++;
            }
            sb.append(words[i]);
            space -= t;
            while(space-->0) sb.append(' ');
        }
        else if(gaps == 0) {
            for(int i = begin; i < end; i++) {
                sb.append(words[i]);
            }
            for(int i = 0; i<space; i++) sb.append(' ');
        }
        else {
            int x = space / gaps, y = space % gaps;
            int i = begin;
            for(; i<end - 1; i++) {
                sb.append(words[i]);
                for(int j = 0; j<x; j++) sb.append(' ');
                if(y > 0) {
                    y--;
                    sb.append(' ');
                }
            }
            sb.append(words[i]);
        }
        return sb.toString();
    }
}