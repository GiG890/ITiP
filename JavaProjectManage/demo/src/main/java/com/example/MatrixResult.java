package com.example;

public class MatrixResult {
    private int[][] matrix;
    private int[] rowMaxs;
    private int globalMax;

    public MatrixResult(int[][] matrix, int[] rowMaxs, int globalMax) {
        this.matrix = matrix.clone();
        this.rowMaxs = rowMaxs.clone();
        this.globalMax = globalMax;
    }

    public int[][] getMatrix() {
    return matrix.clone();
}

public int[] getRowMaxs() {
    return rowMaxs.clone();
}

    public int getGlobalMax() {
        return globalMax;
    }
}
