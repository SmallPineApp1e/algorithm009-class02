class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int notRepeatIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[notRepeatIndex] != nums[i]) {
                notRepeatIndex++;
                swap(nums, notRepeatIndex, i);
            }
        }
        return notRepeatIndex + 1;
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}