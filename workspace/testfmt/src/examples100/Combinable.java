package examples100;

/**
 * 
 * ������һ�ֽӿڣ�Ҫ���б������С��Ԫ�����ʵ��Щ�ӿ�
 * 
 * @author boss
 * 
 * 
 * 
 *         create on : ����10:56:59 2009-5-19
 */

public interface Combinable<T> extends Comparable<T> {

	T combinate(T a, T b);

}