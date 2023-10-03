package other.test;

/**
 * Java program for implementation of QuickSort
 */
class QuickSort
{
    /* This function takes last element as pivot,
    places the pivot element at its correct
    position in sorted array, and places all
    smaller (smaller than pivot) to left of
    pivot and all greater elements to right
    of pivot */
    int partition(int arr[], int begin, int end)
    {
        int pivot = arr[end];
        int i = (begin-1); // index of smaller element
        for (int j = begin; j < end; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[end] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = temp;

        return i+1;
    }


    /* The main function that implements QuickSort()
    arr[] --> Array to be sorted,
    begin --> Starting index,
    end --> Ending index */
    void sort(int arr[], int begin, int end)
    {
        if (begin < end)
        {
			/* pi is partitioning index, arr[pi] is
			now at right place */
            int pi = partition(arr, begin, end);

            // Recursively sort elements before
            // partition and after partition
            sort(arr, begin, pi-1);
            sort(arr, pi+1, end);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    // Driver program
    public static void main(String args[])
    {
        int arr[] = {10, 7, 8, 9, 1, 5};
        int n = arr.length;

        QuickSort ob = new QuickSort();
        ob.sort(arr, 0, n-1);

        System.out.println("sorted array");
        printArray(arr);
    }
}

