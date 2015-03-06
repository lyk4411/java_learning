package examples100;
import java.io.BufferedReader;  
import java.io.File;  
import java.io.FileReader;  
import java.io.FileWriter;  
import java.io.IOException;  
import java.util.HashSet;  
import java.util.SortedMap;  
import java.util.Map;  
import java.util.Set;  
import java.util.SortedSet;  
import java.util.TreeMap;  
import java.util.Iterator;  
import java.util.TreeSet;  
  
/**�����ĵ��������������������ĵ������� 
 * @author yangliu 
 * @qq 772330184  
 * @mail yang.liu@pku.edu.cn 
 * 
 */  
public class ComputeWordsVector {  
      
    /**�����ĵ���TF-IDF��������,����Map<�ļ�����Map<�����ʣ�TF-IDFֵ>> 
     * @param testSampleDir ����õľ������������������� 
     * @return Map<String,Map<String,Double>> ���в��������������������ɵ�map 
     * @throws IOException  
     */  
    public Map<String,Map<String,Double>> computeTFMultiIDF(String testSampleDir) throws IOException{  
        String word;  
        Map<String,Map<String,Double>> allTestSampleMap = new TreeMap<String,Map<String,Double>>();  
        Map<String, Double> idfPerWordMap = computeIDF(testSampleDir);  
        Map<String,Double> TFPerDocMap = new TreeMap<String,Double>();//����ÿƪ�ĵ��к��и�����������  
        File[] samples = new File(testSampleDir).listFiles();  
        System.out.println("the total number of test files is" + samples.length);  
        for(int i = 0; i < samples.length; i++){  
            TFPerDocMap.clear();  
            FileReader samReader = new FileReader(samples[i]);  
            BufferedReader samBR = new BufferedReader(samReader);  
            Double wordSumPerDoc = 0.0;//����ÿƪ�ĵ����ܴ���  
            while((word = samBR.readLine()) != null){  
                if(!word.isEmpty()){  
                    wordSumPerDoc++;  
                    if(TFPerDocMap.containsKey(word)){  
                        Double count =  TFPerDocMap.get(word);  
                        TFPerDocMap.put(word, count + 1.0);  
                    }  
                    else {  
                        TFPerDocMap.put(word, 1.0);  
                    }  
                }  
            }  
  
            Double maxCount = 0.0, wordWeight;//��¼���ִ������Ĵʳ��ֵĴ�����������һ��  
            Set<Map.Entry<String, Double>> tempTF = TFPerDocMap.entrySet();  
            for(Iterator<Map.Entry<String, Double>> mt = tempTF.iterator(); mt.hasNext();){  
                Map.Entry<String, Double> me = mt.next();  
                if(me.getValue() > maxCount) maxCount = me.getValue();  
            }  
            for(Iterator<Map.Entry<String, Double>> mt = tempTF.iterator(); mt.hasNext();){  
                Map.Entry<String, Double> me = mt.next();  
                Double IDF = Math.log(samples.length / idfPerWordMap.get(me.getKey())) / Math.log(10);  
                wordWeight =  (me.getValue() / maxCount) * IDF;  
                TFPerDocMap.put(me.getKey(), wordWeight);  
            }  
            TreeMap<String,Double> tempMap = new TreeMap<String,Double>();  
            tempMap.putAll(TFPerDocMap);  
            allTestSampleMap.put(samples[i].getName(), tempMap);  
        }  
        //printTestSampleMap(allTestSampleMap);  
        return allTestSampleMap;  
    }  
      
    /**�����������map���ݣ����ڲ��� 
     * @param SortedMap<String,Double> ���Դʵ� 
     * @throws IOException  
     */  
    void printTestSampleMap(Map<String,Map<String,Double>> allTestSampleMap) throws IOException {  
        // TODO Auto-generated method stub  
        File outPutFile = new File("F:/DataMiningSample/KmeansClusterResult/allTestSampleMap.txt");  
        FileWriter outPutFileWriter = new FileWriter(outPutFile);  
        Set<Map.Entry<String,Map<String,Double>>> allWords = allTestSampleMap.entrySet();  
        for(Iterator<Map.Entry<String,Map<String,Double>>> it = allWords.iterator(); it.hasNext();){  
            Map.Entry<String,Map<String,Double>> me = it.next();  
            outPutFileWriter.append(me.getKey() + " ");  
            Set<Map.Entry<String,Double>> vecSet = me.getValue().entrySet();  
            for(Iterator<Map.Entry<String, Double>> jt = vecSet.iterator(); jt.hasNext();){  
                Map.Entry<String, Double> ne = jt.next();  
                outPutFileWriter.append(ne.getKey() + " "+ ne.getValue() + " ");  
            }  
            outPutFileWriter.append("\n");  
            outPutFileWriter.flush();  
        }  
        outPutFileWriter.close();  
    }  
      
    /**ͳ��ÿ���ʵ��ܵĳ��ִ��������س��ִ�������n�εĴʻ㹹�����յ����Դʵ� 
     * @param strDir ����õ�newsgroup�ļ�Ŀ¼�ľ���·�� 
     * @throws IOException  
     */  
    public SortedMap<String,Double> countWords(String strDir,Map<String, Double> wordMap) throws IOException{  
        File sampleFile = new File(strDir);  
        File [] sampleDir = sampleFile.listFiles();  
        String word;  
        for(int j = 0; j < sampleDir.length; j++){  
            File[] sample = sampleDir[j].listFiles();  
            for(int i = 0; i < sample.length; i++){  
                if(sample[i].getName().contains("stemed")){  
                    FileReader samReader = new FileReader(sample[i]);  
                    BufferedReader samBR = new BufferedReader(samReader);  
                    while((word = samBR.readLine()) != null){  
                        if(!word.isEmpty() && wordMap.containsKey(word)){  
                            double count = wordMap.get(word) + 1;  
                            wordMap.put(word, count);  
                        }  
                        else {  
                            wordMap.put(word, 1.0);  
                        }  
                    }  
                }     
            }  
        }  
      
        //ȥ��ͣ�ôʺ�����DF��ѡȡ�����ʣ������ټ��������ʵ�ѡȡ�㷨  
        SortedMap<String,Double> newWordMap = new TreeMap<String,Double>();  
        Set<Map.Entry<String,Double>> allWords = wordMap.entrySet();  
        for(Iterator<Map.Entry<String,Double>> it = allWords.iterator(); it.hasNext();){  
            Map.Entry<String, Double> me = it.next();  
            if(me.getValue() > 100){//DF����ά  
                newWordMap.put(me.getKey(),me.getValue());  
            }  
        }  
        return newWordMap;    
    }  
  
    /**����IDF�������Դʵ���ÿ�����ڶ��ٸ��ĵ��г��ֹ� 
     * @param testSampleDir �����㷨������������Ŀ¼ 
     * @return ���ʵ�IDFmap ��ʽΪSortedMap<String,Double> ��<���ʣ������õ��ʵ��ĵ���> 
     * @throws IOException  
     */  
    Map<String,Double> computeIDF(String testSampleDir) throws IOException {  
        // TODO Auto-generated method stub  
        Map<String,Double> IDFPerWordMap = new TreeMap<String,Double>();  
        Set<String> alreadyCountWord = new HashSet<String>();//���µ�ǰ�Ѿ��������ĸ��ĵ��еĴ�  
        String word;  
        File[] samples = new File(testSampleDir).listFiles();  
        for(int i = 0; i < samples.length; i++){  
            alreadyCountWord.clear();  
            FileReader tsReader = new FileReader(samples[i]);  
            BufferedReader tsBR = new BufferedReader(tsReader);  
            while((word = tsBR.readLine()) != null){  
                if(!alreadyCountWord.contains(word)){  
                    if(IDFPerWordMap.containsKey(word)){  
                        IDFPerWordMap.put(word, IDFPerWordMap.get(word) + 1.0);  
                    }  
                    else IDFPerWordMap.put(word, 1.0);  
                    alreadyCountWord.add(word);                   
                }  
            }  
        }  
        return IDFPerWordMap;  
    }  
      
    /**���������㷨�Ĳ�������������Ҫ�ǹ��˳�ֻ���������ʵ��ĵ�д��һ��Ŀ¼�� 
     * @param String srcDir ԴĿ¼���Ѿ�����Ԥ������û�й��˷������ʵ��ĵ�Ŀ¼ 
     * @param String destDir Ŀ��Ŀ¼�������㷨�Ĳ�������Ŀ¼ 
     * @return String[] �������������������������� 
     * @throws IOException  
     */  
    String[] createTestSamples( String srcDir, String destDir) throws IOException {  
        // TODO Auto-generated method stub  
        SortedMap<String,Double> wordMap = new TreeMap<String,Double>();  
        wordMap = countWords(srcDir, wordMap);  
        System.out.println("special words map sizes:" + wordMap.size());  
        String word, testSampleFile;  
        File[] sampleDir = new File(srcDir).listFiles();  
        for(int i = 0; i < sampleDir.length; i++){  
            File[] sample = sampleDir[i].listFiles();  
            for(int j = 0;j < sample.length; j++){     
                if(sample[j].getName().contains("stemed")){  
                    testSampleFile = destDir + sampleDir[i].getName()+"_"+sample[j].getName();  
                    FileReader samReader = new FileReader(sample[j]);  
                    BufferedReader samBR = new BufferedReader(samReader);  
                    FileWriter tsWriter = new FileWriter(new File(testSampleFile));  
                    while((word = samBR.readLine()) != null){  
                        if(wordMap.containsKey(word)){  
                            tsWriter.append(word + "\n");  
                        }  
                    }  
                    tsWriter.flush();  
                    tsWriter.close();     
                }  
            }  
        }  
        //�������Դʵ�  
        String [] terms = new String[wordMap.size()];  
        int i = 0;  
        Set<Map.Entry<String,Double>> allWords = wordMap.entrySet();  
        for(Iterator<Map.Entry<String,Double>> it = allWords.iterator(); it.hasNext();){  
            Map.Entry<String, Double> me = it.next();  
            terms[i] = me.getKey();  
            i++;  
        }  
        return terms;  
    }  
      
    /**�����������ݾ������ļ�ͳ���غͻ������� 
     * @param clusterResultFile �������ļ� 
     * @param K ������Ŀ 
     * @return double ����������ֵ 
     * @throws IOException  
     */  
    double evaluateClusterRes(String clusterResultFile, int K) throws IOException {  
        // TODO Auto-generated method stub  
        Map<String,String> rightCate = new TreeMap<String,String>();  
        Map<String,String> resultCate = new TreeMap<String,String>();  
        FileReader crReader = new FileReader(clusterResultFile);  
        BufferedReader crBR = new BufferedReader(crReader);  
        String[] s;  
        String line;  
        while((line = crBR.readLine()) != null){  
            s = line.split(" ");  
            resultCate.put(s[0], s[1]);   
            //�ٰ�s[0]��_��Ƭ  
            rightCate.put(s[0], s[0].split("_")[0]);  
        }  
        return computeEntropyAndConfuMatrix(rightCate,resultCate,K);//������  
    }  
      
    /**������������������������ 
     * @param rightCate ��ȷ��Ŀ��Ӧmap 
     * @param resultCate ��������Ӧmap 
     * @return double ���ؾ������ 
     * @throws IOException  
     */  
    private double computeEntropyAndConfuMatrix(Map<String, String> rightCate,  
            Map<String, String> resultCate, int K) {  
        // TODO Auto-generated method stub    
        int[][] confusionMatrix = new int[K][20];//K��20�У�[i,j]��ʾ����i��������Ŀj���ļ���  
        //���������Ŀ��Ӧ����������  
        SortedSet<String> cateNames = new TreeSet<String>();  
        Set<Map.Entry<String, String>> rightCateSet = rightCate.entrySet();  
        for(Iterator<Map.Entry<String, String>> it = rightCateSet.iterator(); it.hasNext();){  
            Map.Entry<String, String> me = it.next();  
            cateNames.add(me.getValue());  
        }  
        String[] cateNamesArray = cateNames.toArray(new String[0]);  
        Map<String,Integer> cateNamesToIndex = new TreeMap<String,Integer>();  
        for(int i = 0; i < cateNamesArray.length; i++){  
            cateNamesToIndex.put(cateNamesArray[i],i);  
        }  
        for(Iterator<Map.Entry<String, String>> it = rightCateSet.iterator(); it.hasNext();){  
            Map.Entry<String, String> me = it.next();  
            confusionMatrix[Integer.parseInt(resultCate.get(me.getKey()))][cateNamesToIndex.get(me.getValue())]++;  
        }  
        //�����������  
        double [] clusterSum = new double[K];//��¼ÿ��������ļ���  
        double[] everyClusterEntropy = new double[K];//��¼ÿ���������  
        double clusterEntropy = 0;  
        System.out.print("    ");  
        for(int i = 0; i < 20; i++){  
            System.out.print(i + "    ");  
        }  
        System.out.println();  
        for(int i = 0; i < K; i++){  
            System.out.print(i + "    ");  
            for(int j = 0; j < 20; j++){  
                clusterSum[i] += confusionMatrix[i][j];  
                System.out.print(confusionMatrix[i][j]+"    ");  
            }  
            System.out.println();  
        }  
        System.out.println();  
        for(int i = 0; i < K; i++){  
            if(clusterSum[i] != 0){  
                for(int j = 0; j < 20; j++){  
                     double p = (double)confusionMatrix[i][j]/clusterSum[i];  
                     if(p != 0){  
                         everyClusterEntropy[i] += -p * Math.log(p);  
                     }  
                }  
                clusterEntropy += clusterSum[i]/(double)rightCate.size() * everyClusterEntropy[i];  
            }  
        }  
        return clusterEntropy;  
    }  
  
}  