package jdk5newfeature;

enum Grade { // class A 100-90�� B 89-80�� C 79-70һ�� D 69-60�� E 59-0������
	A("100-90") {
		public String localValue() {
			return "��";
		}
	},
	B("89-80") {
		public String localValue() {
			return "��";
		}
	},
	C("79-70") {
		public String localValue() {
			return "һ��";
		}
	},
	D("69-60") {
		public String localValue() {
			return "��";
		}
	},
	E("59-0") {
		public String localValue() {
			return "������";
		}
	};// Object

	private String value;// ��װÿ�������Ӧ�ķ�����

	private Grade(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public abstract String localValue();// �������ö�٣�ÿ��ö�ٶ���Ҫ��д�÷���
}