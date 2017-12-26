 package tankwar;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import lightButton.LightButton;
import mapediter.MapEdit;


public class Main implements ActionListener{
		private JFrame f;
		private PanelX p;
		private LightButton butSingle;
		private LightButton butDouble;
		private LightButton butEdit;
		private LightButton butHelp;
		private LightButton butAbort;
		private int width;
		private int height;
		private LightButton butExit;
		private JDialog set;
		private Help help=new Help();
		private Abort about=new Abort(); 
		private String map;
		private int max;
		protected int style;
        protected int styleTwo;

		public Main() {
			setF(new JFrame("TankWar 3.0"));
			p = new PanelX();
			p.setLayout(null);

			//设置按钮
			butSingle = new LightButton(20, 210, 140, 50, "Single Player");
			butDouble = new LightButton(20, 263, 140, 50, "Double Player");
			butEdit=new LightButton(20, 316, 140, 50, "Map Editer");
			butHelp=new LightButton(20, 369, 140, 50, "Help Doc");
			butAbort=new LightButton(20, 422, 140, 50, "About");
			butExit=new LightButton(20, 475, 140, 50, "Exit");

			//响应事件
			butSingle.addActionListener(this);
			butDouble.addActionListener(this);
			butEdit.addActionListener(this);
			butHelp.addActionListener(this);
			butAbort.addActionListener(this);
			butAbort.addActionListener(this);
			butExit.addActionListener(this);
			p.add(butSingle);
			p.add(butDouble);
			p.add(butEdit);
			p.add(butHelp);
			p.add(butAbort);
			p.add(butExit);
			getF().add(p);
			getF().setSize(0, 0);
			width = 800;
			height = 830;
			getF().setDefaultCloseOperation(3); //System exit 方法退出应用程序
			getF().setResizable(false); //窗体大小固定
			getF().setVisible(true); //控件显示在窗口最前方
			for (int i = 0; i < width; i += 20) { //界面渐变显示
					getF().setSize(i,i * ( height / width));
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {}
				
			}
		}

	    public static void main(String[] args) {
            new Main();
        }

        /**
        * 中间布局
        */
	    private class PanelX extends JPanel {
		    private static final long serialVersionUID = 5954299196924652990L;
		    private ImageIcon background;

		    /**
		    * 游戏初始界面动画
		    */
		    @Override
		    protected void paintComponent(Graphics g) {
			    super.paintComponent(g);
			    background = new ImageIcon(Main.class.getResource("/pic/start2.jpg"));
			    g.drawImage(background.getImage(), 0, 0, 800, 830, 0, 0, background.getIconWidth(), background.getIconHeight(), null);
		    }
	    }

        /*关闭主窗体*/
	    public void over() {
		    for (int i = width; i >= 0; i -= 20) {
			    getF().setSize(i,i * ( height / width));
			    try {
				    Thread.sleep(10);
			    } catch (InterruptedException e) {}
            }
		    getF().setVisible(false);
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {

		    if(e.getSource() == butExit) { over(); }

		    else if(e.getSource() == butEdit) { new MapEdit(this); }

		    else if(e.getSource() == butSingle) {
			    dialog(1);
			    try {
				    new TankWar(map, max, f, style, styleTwo); //游戏开始
			    } catch (Exception e1) {
                }
            }

		    else if(e.getSource() == butDouble) {
			    dialog(2);
			    try {
				    new TankWar(map, max + 1, f, style, styleTwo);
			    } catch (Exception e1){ }
		    }

		    else if(e.getSource() == butHelp) {
		    	help.setVisible(true);
		    }

		    else if(e.getSource() == butAbort) {
		    	about.setVisible(true);
		    }
		
        }

	    private void dialog(int flag) {
		    set = new JDialog(f, true);
		    set.setVisible(false);
		    set.setTitle("游戏设置");

		    if(flag == 1){
			    set.setBounds(200, 100, 400, 600);
		    }
		    else if(flag == 2){
			    set.setBounds(200, 100, 550, 600);
		    }

		    JLabel tankShow = new JLabel(new ImageIcon(Main.class.getResource("/pic/tanks.jpg")));

		    tankShow.setBounds(150, 0, 243, 400);

		    ButtonGroup tankGroup = new ButtonGroup();

		    final JRadioButton tank1 = new JRadioButton("重型坦克：");

		    final JRadioButton tank2 = new JRadioButton("主战坦克：");

		    final JRadioButton tank3 = new JRadioButton("轻型坦克：");

            final JRadioButton tank4 = new JRadioButton("重型坦克：");

            final JRadioButton tank5 = new JRadioButton("主战坦克：");

            final JRadioButton tank6 = new JRadioButton("轻型坦克：");

		    tank1.setSelected(true);
		    tankGroup.add(tank1);
		    tankGroup.add(tank2);
		    tankGroup.add(tank3);

		    Font tankFont = new Font("黑体",3,22);
		    tank1.setFont(tankFont);
		    tank2.setFont(tankFont);
		    tank3.setFont(tankFont);
		    tank1.setBounds(0, 0, 150, 120);
		    tank2.setBounds(0, 140, 150, 120);
		    tank3.setBounds(0, 280, 150, 120);

		    if(flag == 2){
			    ButtonGroup tankGroupTwo = new ButtonGroup();
			    tank4.setSelected(true);
			    tankGroupTwo.add(tank4);
			    tankGroupTwo.add(tank5);
			    tankGroupTwo.add(tank6);
			    tank4.setFont(tankFont);
			    tank5.setFont(tankFont);
			    tank6.setFont(tankFont);
			    tank4.setBounds(400, 0, 150, 120);
			    tank5.setBounds(400, 140, 150, 120);
			    tank6.setBounds(400, 280, 150, 120);
		    }

		    JPanel dp = new JPanel(null);
		    File dir = new File("map");
		    String mapNames[] = dir.list();
		    final JComboBox list = new JComboBox();

		    for (int i = 0; i < mapNames.length; i++) {
			    list.addItem(mapNames[i]);
		    }

            list.setBounds(100, 410, 250, 30);
		    JLabel labMap = new JLabel("地图：");
		    labMap.setFont(new Font("宋体", 1, 20));
		    labMap.setBounds(20, 410, 80, 30);
		    JLabel labMax=new JLabel("敌军数量：");
		    labMax.setFont(new Font("宋体", 1, 16));
		    labMax.setBounds(20, 470, 120, 30);

		    final JSlider slider = new JSlider(10, 50);
		    slider.setBounds(150, 470, 230, 50);
		    slider.setPaintTicks(true);
		    slider.setPaintLabels(true);
		    slider.setMajorTickSpacing(10);
		    slider.setMinorTickSpacing(2);

		    final TextField showMax = new TextField(String.valueOf(slider.getValue()));
		    showMax.setFont(new Font("", 0, 20));
		    showMax.setBackground(Color.WHITE);
		    showMax.setEditable(false);
		    showMax.setBounds(100, 470, 30, 30);

		    slider.addChangeListener(new ChangeListener() {
			    public void stateChanged(ChangeEvent e) {
				showMax.setText(String.valueOf(slider.getValue()));
			}
		    });

		    JButton butOk = new JButton("开始游戏");
		    butOk.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
				    max=slider.getValue();
				    map=(String)list.getSelectedItem();
				    set.setVisible(false);
				    if(tank1.isSelected())	style = 1;
				    else if(tank2.isSelected()) style = 2;
				    else if (tank3.isSelected()) style = 3;
				    styleTwo = 0;
				    if(flag==2){
					    if(tank4.isSelected()) styleTwo = 1;
					    else if (tank5.isSelected()) styleTwo = 2;
					    else if (tank6.isSelected()) styleTwo = 3;
				    }
				    over();
			    }
		    });
		    butOk.setBounds(120, 530, 140, 30);
		    dp.add(tank1);
		    dp.add(tank2);
		    dp.add(tank3);

		    if(flag == 2){
                dp.add(tank4);
                dp.add(tank5);
                dp.add(tank6);
		    }

		    dp.add(tankShow);
		    dp.add(butOk);
		    dp.add(showMax);
		    dp.add(labMap);
		    dp.add(list);
		    dp.add(labMax);
		    dp.add(slider);

		    set.add(dp);
		    set.setVisible(true);
	    }

	    public void setF(JFrame f) {
            this.f = f;
        }

	    public JFrame getF() {
            return f;
        }
}
