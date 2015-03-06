package examples100;

/**
 * 
 * 定义了一种接口，要进行编码的最小单元类必需实现些接口
 * 
 * @author boss
 * 
 * 
 * 
 *         create on : 下午10:56:59 2009-5-19
 */

public interface Combinable<T> extends Comparable<T> {

	T combinate(T a, T b);

}