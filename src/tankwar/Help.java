package tankwar;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.ScrollPane;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Help extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5567643909843911042L;
	private JPanel p;
	private JTextArea text;
	private ScrollPane sp;
	public Help() {
		this.setBounds(200, 200, 400, 400);
		this.setTitle("�����ĵ�");

		p=new JPanel(new BorderLayout());
		sp=new ScrollPane();
		setText(new JTextArea());
		sp.add(getText());
		getText().setFont(new Font("����", 1, 15));
		getText().setBorder(BorderFactory.createTitledBorder("�����ĵ�"));
		getText().setText(str());
		getText().setEditable(false);
		p.add(sp,BorderLayout.CENTER);
		this.add(p);
	}
	public String str() {
		return "1.���ƣ�\r\n" +
				"һ�����: \r\n" +
				"\t W̹������\r\n" +
				"\t S̹������\r\n" +
				"\t A̹������\r\n" +
				"\t D̹������\r\n" +
				"\t�ո� ����\r\n" +
				"������ң�\r\n" +
				"\t��̹������\r\n" +
				"\t��̹������\r\n" +
				"\t��̹������\r\n" +
				"\t��̹������\r\n" +
				"\t�س� ����\r\n" +
				"2.���ڵ�ͼ��\r\n" +
				"\t��ͼ����ɫ�ϰ�����ɫ�ϰ��ǿ��Դݻٵ��ϰ�\r\n" +
				"\t��ɫΪ���ܴݻٵ��ϰ�\r\n" +
				"\t��ɫ��̺Ϊ�ҷ�̹�˳�����\r\n" +
				"\t��ɫ��̺Ϊ�з�̹�˳�����\r\n" +
				"\tƻ��Ϊ�ҷ�����\r\n" +
				"\t��ͼ��ʹ�õ�ͼ�༭�������µ�ͼ���޸ĵ�ͼ\r\n" +
				"3.��Ϸ����:\r\n" +
				"\t�ҷ�̹��ʣ������Ϊ0ʱ��Ϸ�������и�\r\n" +
				"\t�ҷ������´ݻ�ʱ��Ϸ�������и�\r\n" +
				"\t�з�̹��ʣ������Ϊ0ʱ��Ϸ��������ʤ\r\n" +
				"\t����3.0�汾�м������ϵͳ˫����Ϸϵͳ�������ڴ���" +
				"\r\n\r\n\t\tף��Ϸ���";
		
	}
	public void setText(JTextArea text) {
		this.text = text;
	}
	public JTextArea getText() {
		return text;
	}
}
