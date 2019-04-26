package string;

public class SquareMatrix {
	private int[][] matrix;
	int N;
	
	
	
	public SquareMatrix(int[][] matrix) {
		this.matrix = matrix;
		this.N = matrix.length;
	}
	
	public void RotateMatrixClockwise() {
		Point corner;
		for (int i = 0; i < this.N / 2; i++) {
			corner = new Point(i, i);
			this.RotateRingClockwise(corner, this.N - 2 * i);
		}
	}
	
	public void RotateRingClockwise(Point corner, int ring_width) {
		int offset = ring_width - 1;
		Point up = new Point(corner.x, corner.y);
		Point right = new Point(corner.x, corner.y + offset);
		Point down = new Point(corner.x + offset, corner.y + offset);
		Point left = new Point(corner.x + offset, corner.y);
		
		QuadPoint quad = new QuadPoint(up, right, down, left);
		for (int i = 0; i < ring_width - 1; i++) {
			this.SwapClockwise(quad.up, quad.right, quad.down, quad.left);
			quad.ShiftClockwise();
		}
	}
	
	public void SwapClockwise(Point up, Point right, Point down, Point left) {
		int sentinel = this.matrix[up.x][up.y];
		this.matrix[up.x][up.y] = this.matrix[left.x][left.y];
		this.matrix[left.x][left.y] = this.matrix[down.x][down.y];
		this.matrix[down.x][down.y] = this.matrix[right.x][right.y];
		this.matrix[right.x][right.y] = sentinel;
	}
	
	public int[][] toArray() {
		return this.matrix;
	}
}
