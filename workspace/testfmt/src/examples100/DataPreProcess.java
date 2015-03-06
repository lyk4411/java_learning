package examples100;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Newsgroups�ĵ���Ԥ������
 * 
 * @author yangliu
 * @qq 772330184
 * @mail yang.liu@pku.edu.cn
 */
public class DataPreProcess {

	/**
	 * �����ļ����ô������ݺ���
	 * 
	 * @param strDir
	 *            newsgroup�ļ�Ŀ¼�ľ���·��
	 * @throws IOException
	 */
	public void doProcess(String strDir) throws IOException {
		File fileDir = new File(strDir);
		if (!fileDir.exists()) {
			System.out.println("File not exist:" + strDir);
			return;
		}
		String subStrDir = strDir.substring(strDir.lastIndexOf('/'));
		String dirTarget = strDir + "/../../processedSample_includeNotSpecial"
				+ subStrDir;
		File fileTarget = new File(dirTarget);
		if (!fileTarget.exists()) {// ע��processedSample��Ҫ�Ƚ���Ŀ¼������������ᱨ����ΪĸĿ¼������
			fileTarget.mkdir();
		}
		File[] srcFiles = fileDir.listFiles();
		String[] stemFileNames = new String[srcFiles.length];
		for (int i = 0; i < srcFiles.length; i++) {
			String fileFullName = srcFiles[i].getCanonicalPath();
			String fileShortName = srcFiles[i].getName();
			if (!new File(fileFullName).isDirectory()) {// ȷ�����ļ�������Ŀ¼����ǿ����ٴεݹ����
				System.out.println("Begin preprocess:" + fileFullName);
				StringBuilder stringBuilder = new StringBuilder();
				stringBuilder.append(dirTarget + "/" + fileShortName);
				createProcessFile(fileFullName, stringBuilder.toString());
				stemFileNames[i] = stringBuilder.toString();
			} else {
				fileFullName = fileFullName.replace("\\", "/");
				doProcess(fileFullName);
			}
		}
		// �������stem�㷨
		if (stemFileNames.length > 0 && stemFileNames[0] != null) {
			Stemmer.porterMain(stemFileNames);
		}
	}

	/**
	 * �����ı�Ԥ��������Ŀ���ļ�
	 * 
	 * @param srcDir
	 *            Դ�ļ��ļ�Ŀ¼�ľ���·��
	 * @param targetDir
	 *            ���ɵ�Ŀ���ļ��ľ���·��
	 * @throws IOException
	 */
	private static void createProcessFile(String srcDir, String targetDir)
			throws IOException {
		// TODO Auto-generated method stub
		FileReader srcFileReader = new FileReader(srcDir);
		FileReader stopWordsReader = new FileReader(
				"F:/DataMiningSample/stopwords.txt");
		FileWriter targetFileWriter = new FileWriter(targetDir);
		BufferedReader srcFileBR = new BufferedReader(srcFileReader);// װ��ģʽ
		BufferedReader stopWordsBR = new BufferedReader(stopWordsReader);
		String line, resLine, stopWordsLine;
		// ��stopWordsBR����ͣ�ôʵ�ArrayList����
		ArrayList<String> stopWordsArray = new ArrayList<String>();
		while ((stopWordsLine = stopWordsBR.readLine()) != null) {
			if (!stopWordsLine.isEmpty()) {
				stopWordsArray.add(stopWordsLine);
			}
		}
		while ((line = srcFileBR.readLine()) != null) {
			resLine = lineProcess(line, stopWordsArray);
			if (!resLine.isEmpty()) {
				// ����д��һ��дһ������
				String[] tempStr = resLine.split(" ");// \s
				for (int i = 0; i < tempStr.length; i++) {
					if (!tempStr[i].isEmpty()) {
						targetFileWriter.append(tempStr[i] + "\n");
					}
				}
			}
		}
		targetFileWriter.flush();
		targetFileWriter.close();
		srcFileReader.close();
		stopWordsReader.close();
		srcFileBR.close();
		stopWordsBR.close();
	}

	/**
	 * ��ÿ���ַ������д�����Ҫ�Ǵʷ�������ȥͣ�ôʺ�stemming
	 * 
	 * @param line
	 *            �������һ���ַ���
	 * @param ArrayList
	 *            <String> ͣ�ô�����
	 * @return String ����õ�һ���ַ��������ɴ���õĵ����������ɣ��Կո�Ϊ�ָ���
	 * @throws IOException
	 */
	private static String lineProcess(String line,
			ArrayList<String> stopWordsArray) throws IOException {
		// TODO Auto-generated method stub
		// step1 Ӣ�Ĵʷ�������ȥ�����֡����ַ��������š������ַ������д�д��ĸת����Сд�����Կ�����������ʽ
		String res[] = line.split("[^a-zA-Z]");
		// ����ҪС�ģ���ֹ���е����м������ֺ����ַ��ĵ��� �ض��ˣ����ǽض�Ҳû��
		String resString = new String();
		// step2ȥͣ�ô�
		// step3stemming,���غ�һ����
		for (int i = 0; i < res.length; i++) {
			if (!res[i].isEmpty()
					&& !stopWordsArray.contains(res[i].toLowerCase())) {
				resString += " " + res[i].toLowerCase() + " ";
			}
		}
		return resString;
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public void BPPMain(String[] args) throws IOException {
		// TODO Auto-generated method stub
		DataPreProcess dataPrePro = new DataPreProcess();
		dataPrePro.doProcess("F:/DataMiningSample/orginSample");

	}

}