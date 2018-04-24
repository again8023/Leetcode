class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] neighbors = new List[numCourses];
        int[] degree = new int[numCourses];
        int[] takeCourse = new int[numCourses]; //record the order of taking course
        int l = 0;

        for (int i = 0; i < numCourses; i++) {
            neighbors[i] = new ArrayList<>();
        }
        for (int[] path: prerequisites) {
            neighbors[path[1]].add(path[0]);
            ++degree[path[0]];
        }
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                    q.offer(i);
            }
        }

        int count = 0;

        while (!q.isEmpty()) {
            int take = q.poll();
            takeCourse[l++] = take;
            for (int node: neighbors[take]) {
                if (--degree[node] == 0) {
                    q.offer(node);
                }
            }
            ++count; //Polling course from queue means taking that course
        }
        return (count == numCourses)? takeCourse: new int[0];

    }
}
  
