package jdk5newfeature;

public class EnumText {
	public static void main(String[] args) {
	}

	// 定义交通灯
	public enum TrafficLamp {
		// 定义3个元素，即此类的子类，覆写抽象方法
		RED(30) {
			@Override
			public TrafficLamp nextLamp() {
				return GREEN;
			}
		},
		GREEN(45) {
			@Override
			public TrafficLamp nextLamp() {
				return YELLOW;
			}
		},
		YELLOW(5) {
			@Override
			public TrafficLamp nextLamp() {
				return RED;
			}
		};
		private int time;

		// 构造方法
		private TrafficLamp(int time) {
			this.time = time;
		}

		// 抽象方法，转为下个灯
		public abstract TrafficLamp nextLamp();
	}
}
