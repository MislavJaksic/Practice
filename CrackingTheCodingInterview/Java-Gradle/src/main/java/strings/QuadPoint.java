package strings;

public class QuadPoint {
	public Point up;
	public Point right;
	public Point down;
	public Point left;
	
	
	
	public QuadPoint(Point up, Point right, Point down, Point left) {
		this.up = up;
		this.right = right;
		this.down = down;
		this.left = left;
	}
	
	public void ShiftClockwise() {
		this.up.y++;
		this.right.x++;
		this.down.y--;
		this.left.x--;
	}
}
