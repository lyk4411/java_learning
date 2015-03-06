package examples100;

import java.io.Serializable;

/**
 * 
 * 自定义一个用于测试的单元类
 * 
 * @author boss
 * 
 * 
 * 
 *         create on : 下午09:53:07 2009-5-19
 */

public class UnitClass implements Serializable, Combinable<UnitClass> {

	/**
	 * 
	 * serialVersionUID
	 */

	private static final long serialVersionUID = -4109190579335512743L;

	/** 出现概率数据 */

	private int rate;

	public UnitClass(int rate) {

		this.rate = rate;

	}

	public int getRate() {

		return rate;

	}

	public void setRate(int rate) {

		this.rate = rate;

	}

	/**
	 * 
	 * implements thid compartTo() in order to sort the collection stored from
	 * unitclass
	 */

	@Override
	public int compareTo(UnitClass o) {

		return o.getRate() > this.rate ? 1 : o.getRate() < this.rate ? -1 : 0;

	}

	@Override
	public String toString() {

		return "the rate is:" + rate;

	}

	/**
	 * 
	 * 重写此方法用于哈夫曼编码时可以合并两个分支点信息
	 */

	@Override
	public UnitClass combinate(UnitClass a, UnitClass b) {

		if (a == null || b == null)

			return null;

		return new UnitClass(a.getRate() + b.getRate());

	}

}