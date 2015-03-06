package OCJP;

class Line {
	public class Point {
		public int x, y;
	}

	public Point getPoint() {
		return new Point();
	}
}

class Triangle {
	public Triangle() {
		// insert code here
		Line.Point p = (new Line()).getPoint();
	}

}