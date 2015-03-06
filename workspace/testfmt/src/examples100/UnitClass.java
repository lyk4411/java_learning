package examples100;

import java.io.Serializable;

/**
 * 
 * �Զ���һ�����ڲ��Եĵ�Ԫ��
 * 
 * @author boss
 * 
 * 
 * 
 *         create on : ����09:53:07 2009-5-19
 */

public class UnitClass implements Serializable, Combinable<UnitClass> {

	/**
	 * 
	 * serialVersionUID
	 */

	private static final long serialVersionUID = -4109190579335512743L;

	/** ���ָ������� */

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
	 * ��д�˷������ڹ���������ʱ���Ժϲ�������֧����Ϣ
	 */

	@Override
	public UnitClass combinate(UnitClass a, UnitClass b) {

		if (a == null || b == null)

			return null;

		return new UnitClass(a.getRate() + b.getRate());

	}

}