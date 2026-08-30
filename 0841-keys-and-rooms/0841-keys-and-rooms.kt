class Solution {
    fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
        val visited = BooleanArray(rooms.size) { false }
        visited[0] = true
        dfs(rooms, 0, visited)
        return visited.all { it }
    }
    
    fun dfs(rooms: List<List<Int>>, roomNumber: Int, visited: BooleanArray) {
        for (key: Int in rooms[roomNumber]) {
            if (!visited[key]) {
                visited[key] = true
                dfs(rooms, key, visited)
            }
        }
    }
}