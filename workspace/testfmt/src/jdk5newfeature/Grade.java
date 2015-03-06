package jdk5newfeature;

enum Grade { // class A 100-90优 B 89-80良 C 79-70一般 D 69-60差 E 59-0不及格
	A("100-90") {
		public String localValue() {
			return "优";
		}
	},
	B("89-80") {
		public String localValue() {
			return "良";
		}
	},
	C("79-70") {
		public String localValue() {
			return "一般";
		}
	},
	D("69-60") {
		public String localValue() {
			return "差";
		}
	},
	E("59-0") {
		public String localValue() {
			return "不及格";
		}
	};// Object

	private String value;// 封装每个对象对应的分数。

	private Grade(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public abstract String localValue();// 带抽象的枚举，每个枚举对象都要重写该方法
}