package examples100;

import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
import javax.swing.event.*;  
/** 
 * Title: �б�� 
 * Description: ͨ����������Ԫ�غ͵����ɾ������ťɾ���б�Ԫ�� 
 * Filename: ListDemo.java 
 */  
public class ListDemo extends JPanel  
                      implements ListSelectionListener {  
    private static final long serialVersionUID = 1L;  
    private JList list;  
    private DefaultListModel listModel;  
  
    private static final String hireString = "���";  
    private static final String fireString = "ɾ��";  
    private JButton fireButton;  
    private JTextField employeeName;  
  
    public ListDemo() {  
        super(new BorderLayout());  
        //����List���б�Ԫ��  
        listModel = new DefaultListModel();  
        listModel.addElement("Alan Sommerer");  
        listModel.addElement("Alison Huml");  
        listModel.addElement("Kathy Walrath");  
        listModel.addElement("Lisa Friendly");  
        listModel.addElement("Mary Campione");  
        listModel.addElement("Sharon Zakhour");  
  
        //����һ��List����,�����б�Ԫ����ӵ��б���  
        list = new JList(listModel);  
        //����ѡ��ģʽΪ��ѡ  
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  
        //��ʼ��ѡ��������0��λ�ã�����һ��Ԫ��  
        list.setSelectedIndex(0);  
        list.addListSelectionListener(this);  
        //�����б����ͬʱ��5��Ԫ��  
        list.setVisibleRowCount(5);  
        //���б����һ��������  
        JScrollPane listScrollPane = new JScrollPane(list);  
  
        JButton hireButton = new JButton(hireString);  
        HireListener hireListener = new HireListener(hireButton);  
        hireButton.setActionCommand(hireString);  
        hireButton.addActionListener(hireListener);  
        hireButton.setEnabled(false);  
  
        fireButton = new JButton(fireString);  
        fireButton.setActionCommand(fireString);  
        fireButton.addActionListener(new FireListener());  
  
        employeeName = new JTextField(10);  
        employeeName.addActionListener(hireListener);  
        employeeName.getDocument().addDocumentListener(hireListener);  
        @SuppressWarnings("unused")  
        String name = listModel.getElementAt(  
                              list.getSelectedIndex()).toString();  
  
        //����һ�����  
        JPanel buttonPane = new JPanel();  
        buttonPane.setLayout(new BoxLayout(buttonPane,  
                                           BoxLayout.LINE_AXIS));  
        buttonPane.add(fireButton);  
        buttonPane.add(Box.createHorizontalStrut(5));  
        buttonPane.add(new JSeparator(SwingConstants.VERTICAL));  
        buttonPane.add(Box.createHorizontalStrut(5));  
        buttonPane.add(employeeName);  
        buttonPane.add(hireButton);  
        buttonPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));  
  
        add(listScrollPane, BorderLayout.CENTER);  
        add(buttonPane, BorderLayout.PAGE_END);  
    }  
/** 
 *��˵��������ӡ���ť���� 
 *�����������������ӡ���ť��ʵ�ֽ�Ԫ����ӵ��б���� 
 */  
    class FireListener implements ActionListener {  
        public void actionPerformed(ActionEvent e) {  
             
            int index = list.getSelectedIndex();  
            listModel.remove(index);  
  
            int size = listModel.getSize();  
  
            if (size == 0) { //���û����ѡ������ǡ�ɾ������ťʵЧ  
                fireButton.setEnabled(false);  
  
            } else { //ѡ����һ��  
                if (index == listModel.getSize()) {  
                    //�Ƴ�ѡ��  
                    index--;  
                }  
  
                list.setSelectedIndex(index);  
                list.ensureIndexIsVisible(index);  
            }  
        }  
    }  
  
/** 
 *��˵������ɾ������ť�����¼� 
 *��������ʵ��ɾ���б�Ԫ�� 
 */  
    class HireListener implements ActionListener, DocumentListener {  
        private boolean alreadyEnabled = false;  
        private JButton button;  
  
        public HireListener(JButton button) {  
            this.button = button;  
        }  
  
        //����ʵ�� ActionListener.  
        public void actionPerformed(ActionEvent e) {  
            String name = employeeName.getText();  
  
            //�������ջ���ͬ��  
            if (name.equals("") || alreadyInList(name)) {  
                Toolkit.getDefaultToolkit().beep();  
                employeeName.requestFocusInWindow();  
                employeeName.selectAll();  
                return;  
            }  
  
            int index = list.getSelectedIndex(); //��ȡѡ����  
            if (index == -1) { //���û��ѡ�񣬾Ͳ��뵽��һ��  
                index = 0;  
            } else {           //�����ѡ����ô���뵽ѡ����ĺ���  
                index++;  
            }  
  
            listModel.insertElementAt(employeeName.getText(), index);  
   
            //���������ı�  
            employeeName.requestFocusInWindow();  
            employeeName.setText("");  
  
            //ѡ���µ�Ԫ�أ�����ʾ����  
            list.setSelectedIndex(index);  
            list.ensureIndexIsVisible(index);  
        }  
/** 
 *����˵��������Ƿ���LIST��������Ԫ�� 
 *���������String name �������� 
 *�������ͣ�boolean ����ֵ��������ڷ���true 
 */  
  
        protected boolean alreadyInList(String name) {  
            return listModel.contains(name);  
        }  
  
/** 
 *����˵����ʵ��DocumentListener�ӿڣ�����ʵ�ֵķ����� 
 */  
        public void insertUpdate(DocumentEvent e) {  
            enableButton();  
        }  
  
/** 
 *����˵����ʵ��DocumentListener�ӿڣ�����ʵ�ֵķ��� 
 */  
        public void removeUpdate(DocumentEvent e) {  
            handleEmptyTextField(e);  
        }  
  
/** 
 *����˵����ʵ��DocumentListener�ӿڣ�����ʵ�ֵķ��� 
 */  
        public void changedUpdate(DocumentEvent e) {  
            if (!handleEmptyTextField(e)) {  
                enableButton();  
            }  
        }  
/** 
 *����˵������ťʹ�� 
 */  
        private void enableButton() {  
            if (!alreadyEnabled) {  
                button.setEnabled(true);  
            }  
        }  
/** 
 *����˵����ʵ��DocumentListener�ӿڣ�����ʵ�ֵķ������޸İ�ť��״̬ 
 */  
        private boolean handleEmptyTextField(DocumentEvent e) {  
            if (e.getDocument().getLength() <= 0) {  
                button.setEnabled(false);  
                alreadyEnabled = false;  
                return true;  
            }  
            return false;  
        }  
    }  
/** 
 *����˵����ʵ��ListSelectionListener�ӿڣ�����ʵ�ֵķ����� 
 */  
    public void valueChanged(ListSelectionEvent e) {  
        if (e.getValueIsAdjusting() == false) {  
  
            if (list.getSelectedIndex() == -1) {  
                fireButton.setEnabled(false);  
  
            } else {  
                fireButton.setEnabled(true);  
            }  
        }  
    }  
/** 
 *����˵���������� 
 */  
    public static void main(String[] args) {  
  
        JFrame.setDefaultLookAndFeelDecorated(true);  
  
        //����һ������  
        JFrame frame = new JFrame("ListDemo");  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
  
        //����һ�����  
        JComponent newContentPane = new ListDemo();  
        newContentPane.setOpaque(true);  
        frame.setContentPane(newContentPane);  
  
        //��ʾ����  
        frame.pack();  
        frame.setVisible(true);  
    }  
}  