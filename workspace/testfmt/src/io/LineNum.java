package io;

import java.awt.*;  
import java.awt.event.*;  
import java.io.*;  
import java.text.*;  
import javax.swing.*;  
  
public class LineNum extends JFrame  
{  
    private JPanel topPanel = new JPanel();  
    private JPanel bottomPanel = new JPanel();  
    private JButton fileChoose = new JButton("ѡ��Ŀ¼");  
    private JTextField fileField = new JTextField(20);  
    private JFileChooser fc = new JFileChooser("ѡ��Ŀ¼");   
    private JTextArea filePathArea = new JTextArea(5 , 20);   
    //�ж��Ƿ�����"/* */ע��"  
    private boolean isExplainStatus = false;  
      
    //�洢����������ֵ  
    private int totalCount = 0;  
    //�洢ע��������ֵ  
    private int explainCount = 0;  
    //�洢����������ֵ  
    private int spaceCount = 0;  
    //�洢�����ļ�����ֵ  
    private int count = 0;  
    private InputStream input = null;  
    private BufferedReader br = null;  
      
    private String totalPath = "";  
    private DecimalFormat myFormat = null;  
      
    public LineNum(String title)  
    {  
        super(title);     
        //�������  
        Container container = getContentPane();  
        container.setLayout(new BorderLayout());  
        topPanel.setLayout(new GridLayout(1 , 2));  
        bottomPanel.setLayout(new BorderLayout());  
        topPanel.add(fileChoose);  
        topPanel.add(fileField);   
        bottomPanel.add(new JScrollPane(filePathArea));   
        filePathArea.setText("java�ļ���");  
        container.add(topPanel , BorderLayout.NORTH);  
        container.add(bottomPanel , BorderLayout.CENTER);    
          
        //���ѡ��Ŀ¼������Ĭ�ϻ�ȡ����ѡ���ļ����ڵĸ�Ŀ¼������ͳ�ƶ����Ǵ˸�Ŀ¼������Ŀ¼�µ�����java�ļ�  
        fileChoose.addActionListener(new ActionListener()  
        {  
            public void actionPerformed(ActionEvent e)   
            {                 
                int result = fc.showOpenDialog(LineNum.this);  
                if(result == JFileChooser.APPROVE_OPTION)  
                {                     
                    String path = fc.getSelectedFile().getAbsolutePath();  
                    path = path.substring(0 , path.lastIndexOf("\\"));  
                    fileField.setText(path);   
                    File file = new File(path);  
                    CalculateLineNum(file);  
                }  
            }  
        });  
    }     
  
    /* 
     * ���㲢��ʾͳ����Ϣ 
     */  
    private void CalculateLineNum(File file)  
    {  
        if(file.exists())  
        {  
            displayLineNum(file);  
            myFormat = (DecimalFormat)NumberFormat.getPercentInstance();  
            myFormat.applyPattern("0.00%");  
            if(totalCount != 0)  
            {  
                double programPercent = (double)(totalCount - explainCount - spaceCount)/(double)totalCount;  
                double explainPercent = (double)explainCount/(double)totalCount;  
                double spacePercent = (double)spaceCount/(double)totalCount;  
                filePathArea.setText(filePathArea.getText() + "\n" + " ��������" + totalCount + "��");  
                filePathArea.setText(filePathArea.getText() + "\n" + " ����������" + (totalCount - explainCount - spaceCount) + "��,�ٷֱȣ�"+myFormat.format(programPercent));  
                filePathArea.setText(filePathArea.getText() + "\n" + " ע��������" + explainCount + "��,�ٷֱȣ�"+myFormat.format(explainPercent));  
                filePathArea.setText(filePathArea.getText() + "\n" + " ����������" + spaceCount + "��,�ٷֱȣ�"+myFormat.format(spacePercent));  
            }  
            else  
            {  
                filePathArea.setText(filePathArea.getText() + "\n" + " ��������" + totalCount + "��");  
            }  
        }  
    }  
      
    //ѭ������Ŀ¼����Ŀ¼��ͳ�ƴ�����������ע����������������  
    public void displayLineNum(File file)  
    {  
        totalPath+= "   ||   " + file.getName();  
        String[] subPaths = file.list();  
        if(subPaths.length == 0)  
        {  
            totalPath = totalPath.substring(0 , totalPath.lastIndexOf("   ||   "));  
            return;  
        }             
        //ѭ������Ŀ¼���з��ʼ�����������  
        for(int i = 0 ; i < subPaths.length ; i++)  
        {  
            count = 0;  
            File subFile = new File(file.getAbsolutePath() + "\\" + subPaths[i]);  
            if(subFile.isFile())  
            {  
                String subFilePath = subFile.getAbsolutePath();  
                String extendName = subFilePath.substring(subFilePath.lastIndexOf(".") + 1 , subFilePath.length());  
                if(!extendName.equals("java"))  
                {  
                    continue;  
                }  
                try   
                {  
                    input = new FileInputStream(subFile);  
                    BufferedReader br = new BufferedReader(new InputStreamReader(input));  
                    String lineValue = br.readLine();  
                    while(lineValue != null)  
                    {  
                        count++;  
                        //�����ֲ�ͬ����ע�ͷֱ����Կ����ÿ��ַ������ж�  
                        if(isExplainStatus == false)  
                        {  
                            if(lineValue.trim().startsWith("//"))  
                            {  
                                explainCount++;  
                            }  
                            if(lineValue.trim().equals(""))  
                            {  
                                spaceCount++;  
                            }  
                            if(lineValue.trim().startsWith("/*"))  
                            {  
                                explainCount++;  
                                isExplainStatus = true;  
                            }  
                        }  
                        else  
                        {  
                            explainCount++;  
                            if(lineValue.trim().startsWith("*/"))  
                            {  
                                isExplainStatus = false;  
                            }  
                        }  
                        lineValue = br.readLine();  
                    }  
                    totalCount+= count;                       
                    String totalPath1 = totalPath + "   ||   " + subFile.getName();  
                      
                    //��ʾ�����ļ�������  
                    filePathArea.setText(filePathArea.getText() + "\n" + totalPath1 + "   ������" + count + "��--------totalCount:"+ totalCount);  
                    br.close();  
                    input.close();    
                }   
                catch (Exception e)   
                {                 
                    e.printStackTrace();  
                }  
            }     
            else  
            {                     
                //ѭ������displayLineNum������ʵ��ͳ����Ŀ¼��������  
                displayLineNum(subFile);  
            }  
        }  
        totalPath = totalPath.substring(0 , totalPath.lastIndexOf("   ||   "));  
    }  
      
    public static void main(String args[])  
    {  
        LineNum lineFrame=new LineNum("java��������ͳ��");  
        lineFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        lineFrame.setBounds(212,159,600,420);  
        lineFrame.setVisible(true);   
        lineFrame.setResizable(false);    
    }  
}  