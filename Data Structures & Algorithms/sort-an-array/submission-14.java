class Solution {
    public int[] sortArray(int[] nums) {
        return mergeSort(nums);
    }

    public int[] mergeSort(int[] nums) {
        if (nums == null) {
            return null;
        }
        int lo = 0;
        int hi = nums.length - 1;
        return mSort(nums, lo, hi);
    }

    public int[] mSort(int[] nums, int lo, int hi) {
        if (lo == hi){
            int[] base = new int[1];
            base[0] = nums[lo];
            return base;
        }
        int mid = (lo + hi) / 2;
        int [] a = mSort(nums, lo, mid);
        int [] b = mSort(nums, mid + 1, hi);
        int [] res = merge2SortedArrays(a,b);

        return res;
    }
    
    public int[] merge2SortedArrays(int[] a, int[] b) {
        int[] res = new int[a.length + b.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i <= a.length - 1 && j <= b.length - 1) {
            if(a[i] <= b[j]) {
                res[k] = a[i];
                i++;
                k++;
            }
            else {
                res[k] = b[j];
                j++;
                k++;
            }
        }

        while (i <= a.length - 1) {
            res[k] = a[i];
            i++;
            k++;
        }

        while (j <= b.length - 1) {
            res[k] = b[j];
            j++;
            k++;
        }

        return res;
    }
}