package examples100;

import java.util.*;

/**
 * Title: 矢量操作< Description: 演示一个矢量（Vector）的基本操作 Filename: operateVector.java
 */
public class operateVector {
	/*
	 * <br>方法说明：生成一个4*4的二维Vector，供使用。<br>输入参数：<br>输出变量：Vector<br>其它说明：
	 */
	public Vector<Object> buildVector() {
		Vector<Object> vTemps = new Vector<Object>();
		for (int i = 0; i < 4; i++) {
			Vector<Object> vTemp = new Vector<Object>();
			for (int j = 0; j < 4; j++) {
				vTemp.addElement("Vector(" + i + ")(" + j + ")");
			}
			vTemps.addElement(vTemp);
		}
		return vTemps;
	}

	/*
	 * <br>方法说明：插入数据<br>输入参数：Vector vTemp 待插入的数据对象<br>输入参数：int iTemp 插入数据的位置
	 * <br>输入参数：Object oTemp 插入数据值<br>输出变量：Vector 结果
	 * <br>其它说明：如果插入位置超出实例实际的位置将返回null
	 */
	public Vector<Object> insert(Vector<Object> vTemp, int iTemp, Object oTemp) {
		if (iTemp > vTemp.size()) {
			print("数据超界!");
			return null;
		} else {
			vTemp.insertElementAt(oTemp, iTemp);
		}
		return vTemp;
	}

	/*
	 * <br>方法说明：移除数据<br>输入参数：Vector vTemp 待删除矢量对象<br>输入参数：int iTemp 删除数据的位置
	 * <br>输出变量：Vector<br>其它说明：如果删除超界的数据，将返回null
	 */
	public Vector<Object> delete(Vector<Object> vTemp, int iTemp) {
		if (iTemp > vTemp.size()) {
			print("数据超界!");
			return null;
		} else {
			vTemp.removeElementAt(iTemp);
		}
		return vTemp;
	}

	/*
	 * <br>方法说明：修改数据<br>输入参数：Vector vTemp 待修改矢量对象<br>输入参数：int iTemp 修改数据的位置
	 * <br>输入参数：Object oTemp 修改数据值<br>输出变量：Vector<br>其它说明：如果修改位置超界的数据，将返回null
	 */
	public Vector<Object> updata(Vector<Object> vTemp, int iTemp, Object oTemp) {
		if (iTemp > vTemp.size()) {
			print("数据超界!");
			return null;
		} else {
			vTemp.setElementAt(oTemp, iTemp);
		}
		return vTemp;
	}

	/*
	 * <br>方法说明：输出信息<br>输入参数：String sTemp 输出信息名称<br>输入参数：Object oTemp 输出信息值
	 * <br>返回变量：无
	 */
	public void print(String sTemp, Vector<Object> oTemp) {
		System.out.println(sTemp + "数据：");
		this.print(oTemp);
	}

	/**
	 * <br>
	 * 方法说明：打印输出（过载） <br>
	 * 输入参数：Object oPara 输出的对象 <br>
	 * 返回类型：无
	 */
	public void print(Object oPara) {
		System.out.println(oPara);
	}

	/**
	 * <br>
	 * 方法说明：打印输出（过载） <br>
	 * 输入参数：Vector vPara 显示输出矢量对象 <br>
	 * 返回类型：无
	 */
	public void print(Vector<Object> vPara) {
		for (int i = 0; i < vPara.size(); i++) {
			System.out.println(vPara.elementAt(i));
		}
	}

	/**
	 * <br>
	 * 方法说明：主方法，程序入口 <br>
	 * 输入参数：String[] args <br>
	 * 返回类型：无
	 */
	public static void main(String[] args) {
		operateVector ov = new operateVector();
		Vector<Object> vTemp = ov.buildVector();
		ov.print("vTemp0", vTemp);
		System.out.println("====================================");
		Vector<Object> vResult = ov.insert(vTemp, 2, "添加的数据");
		ov.print("vResult", vResult);
		System.out.println("====================================");
		Vector<Object> vResultup = ov.updata(vResult, 3, "修改的数据");
		ov.print("vResultmp", vResultup);
		System.out.println("====================================");
		Vector<Object> vResultnow = ov.delete(vResultup, 4);
		ov.print("vResultnow", vResultnow);
	}
}