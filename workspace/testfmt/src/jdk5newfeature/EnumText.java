package jdk5newfeature;

public class EnumText {
	public static void main(String[] args) {
	}

	// ���彻ͨ��
	public enum TrafficLamp {
		// ����3��Ԫ�أ�����������࣬��д���󷽷�
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

		// ���췽��
		private TrafficLamp(int time) {
			this.time = time;
		}

		// ���󷽷���תΪ�¸���
		public abstract TrafficLamp nextLamp();
	}
}
