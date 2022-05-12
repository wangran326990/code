import data.Node;

/**
 * Contiguous Subarrays
 * You are given an array arr of N integers. For each index i, you are required to determine the number of contiguous subarrays that fulfill the following conditions:
 * The value at index i must be the maximum element in the contiguous subarrays, and
 * These contiguous subarrays must either start from or end on index i.
 * Signature
 * int[] countSubarrays(int[] arr)
 * Input
 * Array arr is a non-empty list of unique integers that range between 1 to 1,000,000,000
 * Size N is between 1 and 1,000,000
 * Output
 * An array where each index i contains an integer denoting the maximum number of contiguous subarrays of arr[i]
 * Example:
 * arr = [3, 4, 1, 6, 2]
 * output = [1, 3, 1, 5, 1]
 * Explanation:
 * For index 0 - [3] is the only contiguous subarray that starts (or ends) with 3, and the maximum value in this subarray is 3.
 * For index 1 - [4], [3, 4], [4, 1]
 * For index 2 - [1]
 * For index 3 - [6], [6, 2], [1, 6], [4, 1, 6], [3, 4, 1, 6]
 * For index 4 - [2]
 * So, the answer for the above input is [1, 3, 1, 5, 1]
 *
 */


public class Test2 {
    public static void main(String[] args) {
//        ValidateBinarySearchTree vbt = new ValidateBinarySearchTree();
//        TreeNode root = new TreeNode(5);
//        TreeNode head = root;
//        TreeNode left = new TreeNode(4);
//        TreeNode right = new TreeNode(6);
//        TreeNode left1 = new TreeNode(3);
//        TreeNode right1 = new TreeNode(7);
//        root.left = left;
//        root.right = right;
//        right.right = right1;
//        right.left = left1;
//        vbt.isValidBST(root);
//        SearchA2DMatrixII searchA2DMatrixII = new SearchA2DMatrixII();
//        int[][] matrix = {{-1,3}};
        //int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
//        searchA2DMatrixII.searchMatrix(matrix, 3);
//        QuickSort quickSort = new QuickSort();
//        int[] nums = {1,8,3,2,5,7,6};
//        quickSort.quickSort(nums);
        //CountPrimes cp = new CountPrimes();
        //cp.countPrimes(499979);
//        NQueen nQueen = new NQueen();
//       System.out.println(nQueen.totalNQueens(4));
//        Solution solution = new Solution();
//            System.out.println(solution.minCount(28));
        //SudokuSolver sudokuSolver = new SudokuSolver();
        //char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        //sudokuSolver.solveSudoku(board);
//        SumofSubarrayMinimums sumofSubarrayMinimums = new SumofSubarrayMinimums();
//        int[] arr = {3,1,2};
//        sumofSubarrayMinimums.sumSubarrayMins1(arr);
//        int[] inputs = {3, 4, 1, 6, 2};
//        ContiguousSubArray contiguousSubArray = new ContiguousSubArray();
//        contiguousSubArray.contiguousSubArray(inputs);

//        Node root = new Node(4);
//        Node rootLeft = new Node(2);
//        Node rootRight = new Node(5);
//        Node left = new Node(1);
//        Node right = new Node(3);
//        root.left = rootLeft;
//        root.right = rootRight;
//        rootLeft.left = left;
//        rootLeft.right = right;
//        ConvertBinarySearchTreeToSortedDoublyLinkedList convertBinarySearchTreeToSortedDoublyLinkedList = new ConvertBinarySearchTreeToSortedDoublyLinkedList();
//        convertBinarySearchTreeToSortedDoublyLinkedList.treeToDoublyList(root);
        AlphabetBoardPath alphabetBoardPath = new AlphabetBoardPath();
        //lphabetBoardPath.alphabetBoardPath("leet");
    }
}
