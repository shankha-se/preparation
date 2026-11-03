class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int lo = 0;
        int hi = arr.length - 1;
        int mid = 0;
        List<Integer> result = new ArrayList<>();

        while(lo <= hi){
            mid = (lo + hi) / 2;
            if (arr[mid] == x) {
                break;
            }
            else if (arr[mid] < x) {
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }

        if (arr[mid] != x) {
            if (hi < 0) {
                mid = 0;
            }
            else if (lo >= arr.length) {
                mid = arr.length - 1;
            }
            else {
                mid = (Math.abs(arr[lo] - x) < Math.abs(arr[hi] - x)) ? lo : hi;
            }
        }

        int l = mid - 1, r = mid;
        while(l >= 0 && r < arr.length && k > 0) {
            if(Math.abs(x - arr[l]) <= Math.abs(arr[r] - x)){
                result.add(arr[l]);
                l--;
            }
            else {
                result.add(arr[r]);
                r++;
            }
            k--;
        }
        while(l >= 0 && k > 0) {
            result.add(arr[l]);
            l--;
            k--;
        }
        while(r < arr.length && k > 0) {
            result.add(arr[r]);
            r++;
            k--;
        }
        Collections.sort(result);
        return result;
    }
}