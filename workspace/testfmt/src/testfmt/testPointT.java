package testfmt;

public class testPointT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point<Integer> point1 = new Point<Integer>(4, 2);
		point1.setX(7);
		Point<Double> point2 = new Point<Double>(1.3, 2.6);
		point2.setX(109.91);
		
		Integer point1x = point1.getX();
		Integer point1y = point1.getY();

		Double point2x = point2.getX();
		Double point2y = point2.getY();
		
		System.out.println(point1x);
		System.out.println(point1y);
		System.out.println(point2x);
		System.out.println(point2y);
	}

}
