package examples100;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;

/**
 * Kmeans�����㷨��ʵ���࣬��newsgroups�ĵ����۳�10�ࡢ20�ࡢ30��
 * �㷨��������:��ÿ��������ľ������ĵ�����������ľ������ĵ�ʱ���㷨����
 * 
 * @author yangliu
 * @qq 772330184
 * @mail yang.liu@pku.edu.cn
 * 
 */

public class KmeansCluster {

	/**
	 * Kmeans�㷨������
	 * 
	 * @param Map
	 *            <String, Map<String, Double>> allTestSampleMap �����㷨��������map
	 * @param int K ���������
	 * @return Map<String,Integer> ����Ľ�� ��<�ļ�����������ɺ������������>
	 * @throws IOException
	 */
	private Map<String, Integer> doProcess(
			Map<String, Map<String, Double>> allTestSampleMap, int K) {
		// TODO Auto-generated method stub
		// 0�����Ȼ�ȡallTestSampleMap�����ļ���˳����ɵ�����
		String[] testSampleNames = new String[allTestSampleMap.size()];
		int count = 0, tsLength = allTestSampleMap.size();
		Set<Map.Entry<String, Map<String, Double>>> allTestSampeleMapSet = allTestSampleMap
				.entrySet();
		for (Iterator<Map.Entry<String, Map<String, Double>>> it = allTestSampeleMapSet
				.iterator(); it.hasNext();) {
			Map.Entry<String, Map<String, Double>> me = it.next();
			testSampleNames[count++] = me.getKey();
		}
		// 1����ʼ���ѡ���㷨�����ѡ������Ǿ��ȷֿ�ѡ��������ú���
		Map<Integer, Map<String, Double>> meansMap = getInitPoint(
				allTestSampleMap, K);// ����K�����ĵ�
		double[][] distance = new double[tsLength][K];// distance[i][j]��¼��i����������j�ľ���
		// 2����ʼ��K������
		int[] assignMeans = new int[tsLength];// ��¼���е����ڵľ�����ţ���ʼ��ȫ��Ϊ0
		Map<Integer, Vector<Integer>> clusterMember = new TreeMap<Integer, Vector<Integer>>();// ��¼ÿ������ĳ�Ա�����
		Vector<Integer> mem = new Vector<Integer>();
		int iterNum = 0;// ��������
		while (true) {
			System.out.println("Iteration No." + (iterNum++)
					+ "----------------------");
			// 3������ÿ�����ÿ���������ĵľ���
			for (int i = 0; i < tsLength; i++) {
				for (int j = 0; j < K; j++) {
					distance[i][j] = getDistance(
							allTestSampleMap.get(testSampleNames[i]),
							meansMap.get(j));
				}
			}
			// 4���ҳ�ÿ��������ľ�������
			int[] nearestMeans = new int[tsLength];
			for (int i = 0; i < tsLength; i++) {
				nearestMeans[i] = findNearestMeans(distance, i);
			}
			// 5���жϵ�ǰ���е����ڵľ�������Ƿ��Ѿ�ȫ�������������ľ��࣬����ǻ��ߴﵽ���ĵ�����������ô�����㷨
			int okCount = 0;
			for (int i = 0; i < tsLength; i++) {
				if (nearestMeans[i] == assignMeans[i])
					okCount++;
			}
			System.out.println("okCount = " + okCount);
			if (okCount == tsLength || iterNum >= 10)
				break;
			// 6�����ǰ�����������㣬��ô��Ҫ���¾����ٽ���һ�ε�������Ҫ�޸�ÿ������ĳ�Ա��ÿ�������ڵľ�����Ϣ
			clusterMember.clear();
			for (int i = 0; i < tsLength; i++) {
				assignMeans[i] = nearestMeans[i];
				if (clusterMember.containsKey(nearestMeans[i])) {
					clusterMember.get(nearestMeans[i]).add(i);
				} else {
					mem.clear();
					mem.add(i);
					Vector<Integer> tempMem = new Vector<Integer>();
					tempMem.addAll(mem);
					clusterMember.put(nearestMeans[i], tempMem);
				}
			}
			// 7�����¼���ÿ����������ĵ�!
			for (int i = 0; i < K; i++) {
				if (!clusterMember.containsKey(i)) {// ע��kmeans���ܲ����վ���
					continue;
				}
				Map<String, Double> newMean = computeNewMean(
						clusterMember.get(i), allTestSampleMap, testSampleNames);
				Map<String, Double> tempMean = new TreeMap<String, Double>();
				tempMean.putAll(newMean);
				meansMap.put(i, tempMean);
			}
		}
		// 8���γɾ��������ҷ���
		Map<String, Integer> resMap = new TreeMap<String, Integer>();
		for (int i = 0; i < tsLength; i++) {
			resMap.put(testSampleNames[i], assignMeans[i]);
		}
		return resMap;
	}

	/**
	 * ���㵱ǰ�����µ����ģ���������ƽ��
	 * 
	 * @param clusterM
	 *            �õ㵽���о������ĵľ���
	 * @param allTestSampleMap
	 *            ���в���������<�ļ���������>���ɵ�map
	 * @param testSampleNames
	 *            ���в��������ļ������ɵ�����
	 * @return Map<String, Double> �µľ������ĵ�����
	 * @throws IOException
	 */
	private Map<String, Double> computeNewMean(Vector<Integer> clusterM,
			Map<String, Map<String, Double>> allTestSampleMap,
			String[] testSampleNames) {
		// TODO Auto-generated method stub
		double memberNum = (double) clusterM.size();
		Map<String, Double> newMeanMap = new TreeMap<String, Double>();
		Map<String, Double> currentMemMap = new TreeMap<String, Double>();
		for (Iterator<Integer> it = clusterM.iterator(); it.hasNext();) {
			int me = it.next();
			currentMemMap = allTestSampleMap.get(testSampleNames[me]);
			Set<Map.Entry<String, Double>> currentMemMapSet = currentMemMap
					.entrySet();
			for (Iterator<Map.Entry<String, Double>> jt = currentMemMapSet
					.iterator(); jt.hasNext();) {
				Map.Entry<String, Double> ne = jt.next();
				if (newMeanMap.containsKey(ne.getKey())) {
					newMeanMap.put(ne.getKey(), newMeanMap.get(ne.getKey())
							+ ne.getValue());
				} else {
					newMeanMap.put(ne.getKey(), ne.getValue());
				}
			}
		}

		Set<Map.Entry<String, Double>> newMeanMapSet = newMeanMap.entrySet();
		for (Iterator<Map.Entry<String, Double>> jt = newMeanMapSet.iterator(); jt
				.hasNext();) {
			Map.Entry<String, Double> ne = jt.next();
			newMeanMap
					.put(ne.getKey(), newMeanMap.get(ne.getKey()) / memberNum);
		}
		return newMeanMap;
	}

	/**
	 * �ҳ����뵱ǰ������ľ�������
	 * 
	 * @param double[][] �㵽���о������ĵľ���
	 * @return i ����ľ������ĵ��� ��
	 * @throws IOException
	 */
	private int findNearestMeans(double[][] distance, int m) {
		// TODO Auto-generated method stub
		double minDist = 10;
		int j = 0;
		for (int i = 0; i < distance[m].length; i++) {
			if (distance[m][i] < minDist) {
				minDist = distance[m][i];
				j = i;
			}
		}
		return j;
	}

	/**
	 * ����������ľ���
	 * 
	 * @param map1
	 *            ��1������map
	 * @param map2
	 *            ��2������map
	 * @return double �������ŷʽ����
	 */
	private double getDistance(Map<String, Double> map1,
			Map<String, Double> map2) {
		// TODO Auto-generated method stub
		return 1 - computeSim(map1, map2);
	}

	/**
	 * ���������ı������ƶ�
	 * 
	 * @param testWordTFMap
	 *            �ı�1��<����,��Ƶ>����
	 * @param trainWordTFMap
	 *            �ı�2<����,��Ƶ>����
	 * @return Double ����֮������ƶ� �������н����Ҽ�����������ڻ����㣨Ч���൱���ٶȸ��죩
	 * @throws IOException
	 */
	private double computeSim(Map<String, Double> testWordTFMap,
			Map<String, Double> trainWordTFMap) {
		// TODO Auto-generated method stub
		double mul = 0;// , testAbs = 0, trainAbs = 0;
		Set<Map.Entry<String, Double>> testWordTFMapSet = testWordTFMap
				.entrySet();
		for (Iterator<Map.Entry<String, Double>> it = testWordTFMapSet
				.iterator(); it.hasNext();) {
			Map.Entry<String, Double> me = it.next();
			if (trainWordTFMap.containsKey(me.getKey())) {
				mul += me.getValue() * trainWordTFMap.get(me.getKey());
			}
			// testAbs += me.getValue() * me.getValue();
		}
		// testAbs = Math.sqrt(testAbs);

		/*
		 * Set<Map.Entry<String, Double>> trainWordTFMapSet =
		 * trainWordTFMap.entrySet(); for(Iterator<Map.Entry<String, Double>> it
		 * = trainWordTFMapSet.iterator(); it.hasNext();){ Map.Entry<String,
		 * Double> me = it.next(); trainAbs += me.getValue()*me.getValue(); }
		 * trainAbs = Math.sqrt(trainAbs);
		 */
		return mul;// / (testAbs * trainAbs);
	}

	/**
	 * ��ȡkmeans�㷨�����ĳ�ʼ��
	 * 
	 * @param k
	 *            ���������
	 * @param Map
	 *            <String, Map<String, Double>> allTestSampleMap
	 *            ���в���������<�ļ���������>���ɵ�map
	 * @return Map<Integer, Map<String, Double>> ��ʼ���ĵ��Map
	 * @throws IOException
	 */
	private Map<Integer, Map<String, Double>> getInitPoint(
			Map<String, Map<String, Double>> allTestSampleMap, int K) {
		// TODO Auto-generated method stub
		int count = 0, i = 0;
		Map<Integer, Map<String, Double>> meansMap = new TreeMap<Integer, Map<String, Double>>();// ����K���������ĵ�����
		System.out.println("���ξ���ĳ�ʼ���Ӧ���ļ�Ϊ��");
		Set<Map.Entry<String, Map<String, Double>>> allTestSampleMapSet = allTestSampleMap
				.entrySet();
		for (Iterator<Map.Entry<String, Map<String, Double>>> it = allTestSampleMapSet
				.iterator(); it.hasNext();) {
			Map.Entry<String, Map<String, Double>> me = it.next();
			if (count == i * allTestSampleMapSet.size() / K) {
				meansMap.put(i, me.getValue());
				System.out.println(me.getKey() + " map size is "
						+ me.getValue().size());
				i++;
			}
			count++;
		}
		return meansMap;
	}

	/**
	 * ������������ļ���
	 * 
	 * @param kmeansClusterResultFile
	 *            ����ļ�Ŀ¼
	 * @param kmeansClusterResult
	 *            ������
	 * @throws IOException
	 */
	private void printClusterResult(Map<String, Integer> kmeansClusterResult,
			String kmeansClusterResultFile) throws IOException {
		// TODO Auto-generated method stub
		FileWriter resWriter = new FileWriter(kmeansClusterResultFile);
		Set<Map.Entry<String, Integer>> kmeansClusterResultSet = kmeansClusterResult
				.entrySet();
		for (Iterator<Map.Entry<String, Integer>> it = kmeansClusterResultSet
				.iterator(); it.hasNext();) {
			Map.Entry<String, Integer> me = it.next();
			resWriter.append(me.getKey() + " " + me.getValue() + "\n");
		}
		resWriter.flush();
		resWriter.close();
	}

	public void KmeansClusterMain(String testSampleDir) throws IOException {
		// ���ȼ����ĵ�TF-IDF����������ΪMap<String,Map<String,Double>>
		// ��ΪMap<�ļ�����Map<�����ʣ�TF-IDFֵ>>
		ComputeWordsVector computeV = new ComputeWordsVector();
		int[] K = { 10, 20, 30 };
		Map<String, Map<String, Double>> allTestSampleMap = computeV
				.computeTFMultiIDF(testSampleDir);
		for (int i = 0; i < K.length; i++) {
			System.out.println("��ʼ���࣬�۳�" + K[i] + "��");
			String KmeansClusterResultFile = "F:/DataMiningSample/KmeansClusterResult/";
			Map<String, Integer> KmeansClusterResult = new TreeMap<String, Integer>();
			KmeansClusterResult = doProcess(allTestSampleMap, K[i]);
			KmeansClusterResultFile += K[i];
			printClusterResult(KmeansClusterResult, KmeansClusterResultFile);
			System.out.println("The Entropy for this Cluster is "
					+ computeV
							.evaluateClusterRes(KmeansClusterResultFile, K[i]));
		}
	}
}