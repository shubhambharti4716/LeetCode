class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        LinkedList<String> ans =new LinkedList<>(); 
        HashMap<String,PriorityQueue<String>> adj=new HashMap<>();
        for(List<String> ticket:tickets){
            String u=ticket.get(0);
            String v=ticket.get(1);

            adj.putIfAbsent(u,new PriorityQueue<String>());
            adj.get(u).add(v);
        }
        dfs("JFK",adj,ans);
        return ans;
    }
    public void dfs(String src,HashMap<String,PriorityQueue<String>> adj,LinkedList<String> ans){
        PriorityQueue<String> temp=adj.get(src);

        while(temp!=null && temp.size()>0){
            String s=temp.poll();
            dfs(s,adj,ans);
        }
        ans.addFirst(src);
        return;
    }
}