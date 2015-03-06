package examples100;

/**
 * Title: 树参数 Description: 使用继承类，柳树就是树 Filename: osier.java
 */
class tree {
	/**
	 * <br>
	 * 方法说明：树的树根
	 */
	public void root() {
		String sSite = "土壤中";
		String sFunction = "吸收养份";
		print("位置：" + sSite);
		print("功能：" + sFunction);
	}

	/**
	 * 方法说明：树的树干
	 */
	public void bolo() {
		String sSite = "地面";
		String sFunction = "传递养份";
		print("位置：" + sSite);
		print("功能：" + sFunction);
	}

	/**
	 * 方法说明：树的树枝
	 */
	public void branch() {
		String sSite = "树干上";
		String sFunction = "传递养份";
		print("位置：" + sSite);
		print("功能：" + sFunction);
	}

	/**
	 * 方法说明：树的叶子
	 */
	public void leaf() {
		String sSite = "树梢";
		String sFunction = "光合作用";
		String sColor = "绿色";
		print("位置：" + sSite);
		print("功能：" + sFunction);
		print("颜色：" + sColor);
	}

	/**
	 * 方法说明：显示信息 输入参数：Object oPara 显示的信息
	 */
	public void print(Object oPara) {
		System.out.println(oPara);
	}

	/**
	 * 方法说明：主方法：
	 */
	public static void main(String[] arges) {
		tree t = new tree();
		t.print("描述一棵树：");
		t.print("树根：");
		t.root();
		t.print("树干：");
		t.bolo();
		t.print("树枝：");
		t.branch();
		t.print("树叶：");
		t.leaf();
	}
}

/**
 * Title: 柳树参数 Description: 描述柳树的参数
 */
class osier extends tree {
	/**
	 * 方法说明：过载树的树叶
	 */
	public void leaf() {
		super.leaf();
		String sShape = "长形";
		super.print("形状：" + sShape);
	}

	/**
	 * 方法说明：扩展树的花
	 */
	public void flower() {
		print("哈哈，柳树没有花！！");
	}

	/**
	 * 方法说明：主方法
	 */
	public static void main(String[] args) {
		osier o = new osier();
		o.print("柳树树根：");
		o.root();
		o.print("柳树树干：");
		o.bolo();
		o.print("柳树树枝：");
		o.branch();
		o.print("柳树树叶：");
		o.leaf();
		o.print("柳树花：");
		o.flower();
	}
}