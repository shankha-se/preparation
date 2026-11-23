/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int length = mountainArr.length();
        int peak = 1;

        //Find Peak;
        int lo = 1, hi = length - 2;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            int left = mountainArr.get(mid - 1);
            int middle = mountainArr.get(mid);
            int right = mountainArr.get(mid + 1);
            if (left < middle && middle < right){
                lo = mid + 1;
            }
            else if (left > middle && middle > right){
                hi = mid - 1;
            }
            else {
                peak = mid;
                break;
            }
        }

        //Search Left
        lo = 0;
        hi = peak - 1;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            int value = mountainArr.get(mid);
            if (value == target){
                return mid;
            }
            else if(value < target){
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }

        //Search Right
        lo = peak;
        hi = length - 1;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            int value = mountainArr.get(mid);
            if (value == target){
                return mid;
            }
            else if(value > target){
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }

        //Not found
        return -1;
    }
}