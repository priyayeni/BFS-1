//Time Complexity : O(E+V)
//Space Complexity : O(E+V)
/* Description : We will be taking indegrees array where wer store count of dependencies on courses.
then we will map independent to dependent is mapped. Now based on every independent we will decrease
the dependency and increase the count, and in the end if count is equal to numCourses taken then we 
return true else false.
*/
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int [] indegrees = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int[] i : prerequisites){
            int out = i[1]; //Independent
            int in = i[0]; // Dependent
            indegrees[in]++; // we are storing count of dependent courses for every independent course.
            if(!map.containsKey(out)){
                map.put(out, new ArrayList<>()); // Independent to List of dependent mapping
            }
            map.get(out).add(in);
        }

        for(int i=0; i<numCourses; i++){
            if(indegrees[i] == 0){
                q.add(i); // here the we are adding the course which has no dependency
                count++; // and we increase count by 1;
            }
        }

        while(!q.isEmpty()){
            int curr = q.poll(); // we get independent course which is at top of queue.
            List<Integer> subList = map.get(curr); // we get related dependency of the independent course
            if(subList != null){
                for(int sub : subList){
                    indegrees[sub]--; // we remove the dependent course by 1 from the independent course until it become independent that is 0
                    if(indegrees[sub] == 0 ){ // One the dependency of course becomes 0 we add it to queue.
                        q.add(sub);
                        count++; // we increase count by 1 whenever course becomes independent
                    }                
                }
            }
            
        }
        if(count == numCourses)return true; 
        return false;
    }
}