package jdk5newfeature;

public abstract class WeekDay {
	private WeekDay() {
	}

	public final static WeekDay SUN = new WeekDay() {
		public WeekDay nextDay() {
			return MON;
		}
	};

	public final static WeekDay MON = new WeekDay() {
		public WeekDay nextDay() {
			return SUN;
		}
	};

	public abstract WeekDay nextDay();

	public String toString() {
		return this == SUN ? "SUM" : "MON";
	}
}