package uber;

/**
 * Medium:
 *
 * Beauty of a matrix.
 * Given an n x n matrix M and an int k where n % k == 0, divide the M into blocks of size k x k starting with the top left corner. i.e. a 9x9 matrix turns into 9 3x3s.
 * The beauty of a block is the smallest positive number missing from a block.
 * Rearrange M so that the blocks with the lowest beauty come before those with higher beauty (top left to bottom right).
 * In a tie, you should place the block that came first in M before the other block.
 * Just do what the problem says. Make an array A = [(int beauty, int[][] block)...] and a stable sorting algorithm will handle things. Then glue the blocks back into the matrix.
 *
 * Rotate matrix around diagonals.
 * Given an n x n matrix M, where n is odd and n > 1, and an integer k, rotate M counterclockwise k times which are not on the main diagonal or on the diagonal from the top right to the bottom left.
 * Return the new matrix.
 * Ex. I put *s to show which elements are fixed on the diagonals.
 */
public class UberMedium1 {
    static class UberMedium1Solution {

    }
}
