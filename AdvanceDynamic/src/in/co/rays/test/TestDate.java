package in.co.rays.test;

	import java.util.Date;

	public class TestDate {

		public static void main(String[] args) {

			Date today = new Date();

			System.out.println("date = " + today);

			System.out.println("long = " + today.getTime());

			System.out.println("SQL Date = " + new java.sql.Date(today.getTime()));

}
	}
