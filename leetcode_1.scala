//Brute Force appraoch
object Solution {
    def twoSum(nums: Array[Int], target: Int): Array[Int] = {
        var i=0
        var j=0
        var result = Array.empty[Int]
        for(i <- 0 to nums.length-2){
            for(j <- i+1 to nums.length-1){
                if(nums(i) + nums(j) == target){
                    result = Array(i,j)
                }
            }
        }
        result
    }
}

//Better
object Solution {
    def twoSum(nums: Array[Int], target: Int): Array[Int] = {
        var map = Map.empty[Int, Int]
        var result = Array.empty[Int]
        for(i <- 0 to nums.length-1){
            val complement = target - nums(i)
            if(map.contains(complement)){
                result = Array(map.get(complement).get, i)
            }
            map += (nums(i) -> i)
        }
        result
    }
}

//Better representation of above
object Solution {
    def twoSum(nums: Array[Int], target: Int): Array[Int] = {
        var map = Map.empty[Int, Int]
        var result = Array.empty[Int]
        (0 until nums.length) foreach { i =>
            val v = nums(i)
            map.get(target - v) match {
                case Some(x)  =>
                    if (x != i){
                    result = Array(x, i)
                    }
                case _ => map += v -> i
            }
        }
        result
    }
}
