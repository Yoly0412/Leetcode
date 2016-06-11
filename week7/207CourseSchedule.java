public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> pre = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; i++){
            pre.add(new ArrayList<Integer>());
        }
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            pre.get(prerequisites[i][0]).add(prerequisites[i][1]);
            inDegree[prerequisites[i][1]]++;
        }
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }
        int count = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            count++;
            for (int i: pre.get(cur)) {
                if (--inDegree[i] == 0) {
                    q.offer(i);
                }
                
            }
        }
        return count == numCourses;
    }
}