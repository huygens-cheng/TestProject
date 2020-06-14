
//package com.learn.gui;

import java.awt.Button;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.*;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.Color;

public class MainDlg extends JPanel {

	private static final long serialVersionUID = 1L;

	private JPanel headPanel = new JPanel();
	private JTabbedPane jTabbedpane = new JTabbedPane();// 存放选项卡的组件
	private JPanel tailButtons = new JPanel();
	private String[] tabNames = { "输出","图像", "版面","纸张", "页码" ,"设备选件","其他"};
/**/
	public MainDlg() {

		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints s = new GridBagConstraints();

		this.setLayout(gridbag);

		initHead();
		initTail();
		initTab();

		this.add(headPanel);
		this.add(jTabbedpane);
		this.add(tailButtons);

		s.fill = GridBagConstraints.BOTH;
		s.gridwidth = GridBagConstraints.REMAINDER;
		s.weightx = 1;
		s.weighty = 0;
		s.insets = new Insets(5, 0, 0, 0);
		gridbag.setConstraints(headPanel, s);
		s.gridwidth = GridBagConstraints.REMAINDER;
		s.weighty = 1;
		gridbag.setConstraints(jTabbedpane, s);
		s.gridwidth = GridBagConstraints.REMAINDER;
		s.weighty = 0;
		gridbag.setConstraints(tailButtons, s);

		// JButton testB = new JButton("bujuceshi");
		// this.add(testB);
		//// s.gridwidth =0;
		//// s.gridheight=0;
		// //s.weightx =1;
		//// s.weighty =0;
		// //s.gridx = 3;
		// //s.gridy = 0;
		// s.gridy = GridBagConstraints.REMAINDER;
		// gridbag.setConstraints(testB, s);

	}

	private void initHead() {
		headPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
		JLabel modelName = new JLabel("模板名称：");
		JTextField modelEdit = new JTextField(15);
		JLabel deviceName = new JLabel("设备名称：");
		JTextField deviceEdit = new JTextField(15);

		headPanel.add(modelName);
		headPanel.add(modelEdit);
		headPanel.add(deviceName);
		headPanel.add(deviceEdit);

	}

	private void initTail() {
		tailButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
		Button buttonPassword = new Button("密码");
		buttonPassword.setBackground(new Color(0, 0, 255));
		Button buttonConfine = new Button("确定");
		buttonConfine.setBackground(new Color(0, 0, 255));
		Button buttonCancel = new Button("取消");
		// buttonCancel.setBackground(new Color(50, 50, 50,100));

		tailButtons.add(buttonPassword);
		tailButtons.add(buttonConfine);
		tailButtons.add(buttonCancel);

	}

	private void initTab() {
		int i = 0;
		// 输出标签下的JPanel
		JPanel paneloutput = new OutputTab();
		jTabbedpane.addTab(tabNames[i++], null, paneloutput, "输出");// 加入第一个页面
		jTabbedpane.setMnemonicAt(0, KeyEvent.VK_0);// 设置第一个位置的快捷键为0

		// 图像标签下的JPanel
		JPanel panelimage = new ImageTab();
		jTabbedpane.addTab(tabNames[i++], null, panelimage, "图像");// 加入第一个页面
		jTabbedpane.setMnemonicAt(0, KeyEvent.VK_1);
		
		// 图像标签下的JPanel
		JPanel pagePane = new PagePane();
		jTabbedpane.addTab(tabNames[i++], null, pagePane, "版面");// 加入第一个页面
		jTabbedpane.setMnemonicAt(0, KeyEvent.VK_6);
		
		// 纸张标签下的JPanel
		JPanel panel1 = new PaperTab();
		jTabbedpane.addTab(tabNames[i++], null, panel1, "纸张");// 加入第一个页面
		jTabbedpane.setMnemonicAt(0, KeyEvent.VK_2);
		
		// 页码标签下的JPanel
		JPanel jpanelOutputParamsTemp = new PageNumTab();
		jTabbedpane.addTab(tabNames[i++], null, jpanelOutputParamsTemp, "页码");// 加入第一个页面
		jTabbedpane.setMnemonicAt(1, KeyEvent.VK_3);
		
		// 设备选件标签下的JPanel
		JPanel deviceOptionPanel = new DeviceOptionTab();
		jTabbedpane.addTab(tabNames[i++], null, deviceOptionPanel, "设备选件");// 加入第一个页面
		jTabbedpane.setMnemonicAt(0, KeyEvent.VK_4);

		// 其他标签下的JPanel
		JPanel othersPanel = new OthersTab();
		jTabbedpane.addTab(tabNames[i++], null, othersPanel, "其他");// 加入第一个页面
		jTabbedpane.setMnemonicAt(1, KeyEvent.VK_5);

	}


	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				JFrame frame = new JFrame("Test Tab");
				// frame.setLayout(null);
				frame.setContentPane(new MainDlg());
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				// frame.setLocationRelativeTo(null);
				// frame.setResizable(false);
				frame.setSize(800, 800);
				frame.setVisible(true);
			}
		});
	}

}