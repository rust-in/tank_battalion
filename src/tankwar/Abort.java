package tankwar;

import javax.swing.BorderFactory;

public class Abort extends Help {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5211352451752924696L;
	public Abort() {
		this.setTitle("���ڱ���Ϸ");
		this.getText().setBorder(BorderFactory.createTitledBorder("����"));
	}
	@Override
	public String str() {
		return "\t\tTank War 2.0\r\n" +
				"\t��Ϸ���ߣ����Ŀ�\r\n" +
				"\tQQ:33916545\r\n" +
				"\t���ԣ����   ����\r\n" +
				"\t�ر���л��½������ʦ   ������ʦ\r\n" +
				"����ϷͼƬ�����������磬������Ȩ������ϵ���ߡ�\r\n" +
				"    ��Ҫʹ�ñ��������ҵ��;������ϵ����\r\n" +
				"    \t��Ȩ����  ��Ȩ�ؾ�����";
		
	}
}
