class Solution {
    public boolean search(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] > nums[e]) { //mid is greater than the end
                if (target >= nums[s] && target < nums[mid]) { //if target is in the first half
                    e = mid - 1; // find the target in the first half
                } else {
                    s = mid + 1; // find the target in the second half
                }
            } else if (nums[mid] < nums[e]) { //mid is less than the end
                if (target > nums[mid] && target <= nums[e]) {
                    s = mid + 1;     //search in the second half
                } else {
                    e = mid - 1; //search in the first half
                }
            } else { //mid is equal to the end
                e = e - 1;
            }
        }
        return false;

    }
}
