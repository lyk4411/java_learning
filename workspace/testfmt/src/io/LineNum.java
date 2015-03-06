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
    private JButton fileChoose = new JButton("选择目录");  
    private JTextField fileField = new JTextField(20);  
    private JFileChooser fc = new JFileChooser("选择目录");   
    private JTextArea filePathArea = new JTextArea(5 , 20);   
    //判断是否属于"/* */注释"  
    private boolean isExplainStatus = false;  
      
    //存储代码总行数值  
    private int totalCount = 0;  
    //存储注释总行数值  
    private int explainCount = 0;  
    //存储空行总行数值  
    private int spaceCount = 0;  
    //存储单个文件行数值  
    private int count = 0;  
    private InputStream input = null;  
    private BufferedReader br = null;  
      
    private String totalPath = "";  
    private DecimalFormat myFormat = null;  
      
    public LineNum(String title)  
    {  
        super(title);     
        //设置面板  
        Container container = getContentPane();  
        container.setLayout(new BorderLayout());  
        topPanel.setLayout(new GridLayout(1 , 2));  
        bottomPanel.setLayout(new BorderLayout());  
        topPanel.add(fileChoose);  
        topPanel.add(fileField);   
        bottomPanel.add(new JScrollPane(filePathArea));   
        filePathArea.setText("java文件：");  
        container.add(topPanel , BorderLayout.NORTH);  
        container.add(bottomPanel , BorderLayout.CENTER);    
          
        //添加选择目录监听，默认获取的是选择文件所在的父目录，程序统计对象是此父目录及其子目录下的所有java文件  
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
     * 计算并显示统计信息 
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
                filePathArea.setText(filePathArea.getText() + "\n" + " 总行数：" + totalCount + "行");  
                filePathArea.setText(filePathArea.getText() + "\n" + " 程序行数：" + (totalCount - explainCount - spaceCount) + "行,百分比："+myFormat.format(programPercent));  
                filePathArea.setText(filePathArea.getText() + "\n" + " 注释行数：" + explainCount + "行,百分比："+myFormat.format(explainPercent));  
                filePathArea.setText(filePathArea.getText() + "\n" + " 空行行数：" + spaceCount + "行,百分比："+myFormat.format(spacePercent));  
            }  
            else  
            {  
                filePathArea.setText(filePathArea.getText() + "\n" + " 总行数：" + totalCount + "行");  
            }  
        }  
    }  
      
    //循环访问目录及子目录，统计代码总行数，注释行数及空行行数  
    public void displayLineNum(File file)  
    {  
        totalPath+= "   ||   " + file.getName();  
        String[] subPaths = file.list();  
        if(subPaths.length == 0)  
        {  
            totalPath = totalPath.substring(0 , totalPath.lastIndexOf("   ||   "));  
            return;  
        }             
        //循环对子目录进行访问计算行数处理  
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
                        //对两种不同类型注释分别处理，对空行用空字符串来判断  
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
                      
                    //显示单个文件的行数  
                    filePathArea.setText(filePathArea.getText() + "\n" + totalPath1 + "   行数：" + count + "行--------totalCount:"+ totalCount);  
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
                //循环调用displayLineNum函数，实现统计子目录行数数据  
                displayLineNum(subFile);  
            }  
        }  
        totalPath = totalPath.substring(0 , totalPath.lastIndexOf("   ||   "));  
    }  
      
    public static void main(String args[])  
    {  
        LineNum lineFrame=new LineNum("java程序行数统计");  
        lineFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        lineFrame.setBounds(212,159,600,420);  
        lineFrame.setVisible(true);   
        lineFrame.setResizable(false);    
    }  
}  