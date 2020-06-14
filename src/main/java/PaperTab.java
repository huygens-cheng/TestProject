import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import javax.swing.*;

/**
 * 纸张面板
 * 
 * @author chen
 *
 */
public class PaperTab extends JPanel {

	// function: pageBaseInfoPaperSize
	private JTextField widthTextField = new JTextField();
	private JTextField heightTextField = new JTextField();

	// function:pageBaseInfo
	private String[] devicePaperSizeStr = { "A3", "A4", "自定义" };
	private JComboBox devicePaperSizeComboBox = new JComboBox(devicePaperSizeStr);
	private String[] printPicSizeStr = { "同纸张可打印尺寸", "无边空打印" };
	private JComboBox printPicSizeComboBox = new JComboBox(printPicSizeStr);
	private String[] inputPaperBoxStr = { "自动选择", "纸盒1", "纸盒2", "手动进纸盒" };
	private JComboBox inputPaperBoxComboBox = new JComboBox(inputPaperBoxStr);
	private String[] paperTypeStr = { "无指定", "普通纸", "色彩特定", "优质纸", "铜板纸-GL", "铜板纸-ML", "铜板纸-GO", "铜板纸-MO", "信封",
			"皮纹纸" };
	private JComboBox paperTypeComboBox = new JComboBox(paperTypeStr);
	private String[] paperWeightStr = { "无指定", "[62-74]g/m2", "[75-80]g/m2", "[81-91]g/m2", "[92-105]g/m2",
			"[106-135]g/m2", "[136-176]g/m2", "[177-216]g/m2", "[217-256]g/m2", "[257-300]g/m2", "[301-350]g/m2" };
	private JComboBox paperWeightComboBox = new JComboBox(paperWeightStr);
	private String[] paperColorStr = { "无指定", "白色", "蓝色", "金麒麟色", "灰色", "绿色", "象牙白", "橙色", "粉红色", "红色", "黄色", "米色",
			"其他" };
	private JComboBox paperColorComboBox = new JComboBox(paperColorStr);

	// function:pageInsertCoverInfo
	private String[] coverInPaperBoxStr = { "手动进纸盒", "纸盒1", "纸盒2" };
	private JComboBox coverInPaperBoxComboBox = new JComboBox(coverInPaperBoxStr);
	private JRadioButton coverPlainPageRadioButton = new JRadioButton("空白页");
	private JRadioButton coverPrintRadioButton = new JRadioButton("打印");
	private String[] coverTwoSideOutputStr = { "无", "长边翻转", "短边翻转" };
	private JComboBox coverTwoSideOutputComboBox = new JComboBox(coverTwoSideOutputStr);

	// function: pageInsertCoverBackCover
	private String[] inPaperBoxStr = { "手动进纸盒", "纸盒1", "纸盒2" };
	private JComboBox inPaperBoxComboBox = new JComboBox(inPaperBoxStr);
	private JRadioButton plainPageRadioButton = new JRadioButton("空白页");
	private JRadioButton printRadioButton = new JRadioButton("打印");
	private JLabel twoSideOutput = new JLabel("双面输出:");
	private String[] twoSideOutputStr = { "无", "长边翻转", "短边翻转" };
	private JComboBox twoSideOutputComboBox = new JComboBox(twoSideOutputStr);

	// function:pageInsertCoverBackCover
	private JCheckBox coverCheckBox = new JCheckBox("封面");
	private JCheckBox backCoverHaveSameSettingsCheckBox = new JCheckBox("封底与封面使用相同设置");
	private JCheckBox backCoverCheckBox = new JCheckBox("封底");

	// function:pageInsertSettings
	private JCheckBox insertPageCheckBox = new JCheckBox("内插页");

	public PaperTab() {

		// JPanel panel = new JPanel();
		GridBagLayout gridbagp = new GridBagLayout();
		GridBagConstraints sp = new GridBagConstraints();
		this.setLayout(gridbagp);

		JPanel baseInfo = initPageBaseInfoPanel();
		JPanel insertSettings = initPageInsertSettingsPanel();

		this.add(baseInfo);
		this.add(insertSettings);

		sp.fill = GridBagConstraints.BOTH;
		sp.weightx = 1;
		sp.weighty = 0;
		sp.gridheight = 5;
		sp.gridwidth = GridBagConstraints.REMAINDER;
		gridbagp.setConstraints(baseInfo, sp);
		sp.fill = GridBagConstraints.BOTH;
		sp.weighty = 1;
		sp.gridheight = 10;
		sp.gridwidth = GridBagConstraints.REMAINDER;
		gridbagp.setConstraints(insertSettings, sp);

		// return panel;
	}

	private JPanel initPageBaseInfoPaperSizePanel() {

		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints con = new GridBagConstraints();
		JPanel panel = new JPanel(gridbag);
		JLabel width = new JLabel("宽度:");
		// JTextField widhtFiled = new JTextField();
		JLabel unit1 = new JLabel("mm");
		JLabel height = new JLabel("高度:");
		// JTextField heightField = new JTextField();
		JLabel unit2 = new JLabel("mm");
		panel.add(width);
		panel.add(widthTextField);
		panel.add(unit1);
		panel.add(height);
		panel.add(heightTextField);
		panel.add(unit2);

		con.fill = GridBagConstraints.BOTH;
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 0.05;
		con.gridheight = 1;
		con.insets = new Insets(0, 0, 0, 0);
		gridbag.setConstraints(width, con);
		con.weightx = 0.4;
		gridbag.setConstraints(widthTextField, con);
		con.weightx = 0.05;
		gridbag.setConstraints(unit1, con);
		con.weightx = 0.05;
		gridbag.setConstraints(height, con);
		con.weightx = 0.4;
		gridbag.setConstraints(heightTextField, con);
		con.weightx = 0.05;
		gridbag.setConstraints(unit2, con);

		return panel;

	}

	private JPanel initPageBaseInfoPanel() {
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints con = new GridBagConstraints();
		JPanel baseInfo = new JPanel(gridbag);
		baseInfo.setBorder(BorderFactory.createTitledBorder("基本信息"));

		JLabel devicePaperSize = new JLabel("设备纸张尺寸:");
//        String [] devicePaperSizeStr = {"A3","A4","自定义"};
//        JComboBox devicePaperSizeC = new JComboBox(devicePaperSizeStr);
		JLabel printPicSize = new JLabel("打印图像尺寸:");
//        String [] printPicSizeStr = {"同纸张可打印尺寸","无边空打印"};
//        JComboBox printPicSizeC = new JComboBox(printPicSizeStr);
		JLabel T1 = new JLabel();
		JPanel paperSize = initPageBaseInfoPaperSizePanel();
		JLabel inputPaperBox = new JLabel("进纸盒:");
//        String [] inputPaperBoxStr = {"自动选择","纸盒1","纸盒2","手动进纸盒"};
//        JComboBox inputPaperBoxC = new JComboBox(inputPaperBoxStr);
		JLabel paperType = new JLabel("纸张类型:");
//        String [] paperTypeStr = {"无指定","普通纸","色彩特定","优质纸","铜板纸-GL","铜板纸-ML","铜板纸-GO","铜板纸-MO","信封","皮纹纸"};
//        JComboBox paperTypeC = new JComboBox(paperTypeStr);
		JLabel paperWeight = new JLabel("纸张克重:");
//        String[] paperWeightStr = {"无指定","[62-74]g/m2","[75-80]g/m2","[81-91]g/m2","[92-105]g/m2","[106-135]g/m2","[136-176]g/m2","[177-216]g/m2","[217-256]g/m2","[257-300]g/m2","[301-350]g/m2"};
//        JComboBox paperWeightC = new JComboBox(paperWeightStr);
		JLabel paperColor = new JLabel("纸张颜色:");
//        String [] paperColorStr = {"无指定","白色","蓝色","金麒麟色","灰色","绿色","象牙白","橙色","粉红色","红色","黄色","米色","其他"};
//        JComboBox paperColorC = new JComboBox(paperColorStr);
		JCheckBox prePunchHole = new JCheckBox("预打孔:");
		JLabel T2 = new JLabel();

		baseInfo.add(devicePaperSize);
		baseInfo.add(devicePaperSizeComboBox);
		baseInfo.add(printPicSize);
		baseInfo.add(printPicSizeComboBox);
		baseInfo.add(T1);
		baseInfo.add(paperSize);
		baseInfo.add(inputPaperBox);
		baseInfo.add(inputPaperBoxComboBox);
		baseInfo.add(paperType);
		baseInfo.add(paperTypeComboBox);
		baseInfo.add(paperWeight);
		baseInfo.add(paperWeightComboBox);
		baseInfo.add(paperColor);
		baseInfo.add(paperColorComboBox);
		baseInfo.add(prePunchHole);
		baseInfo.add(T2);

		con.fill = GridBagConstraints.BOTH;
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 0.1;
		con.gridheight = 1;
		con.insets = new Insets(3, 3, 3, 3);
		gridbag.setConstraints(devicePaperSize, con);
		con.weightx = 0.4;
		gridbag.setConstraints(devicePaperSizeComboBox, con);
		con.weightx = 0.1;
		gridbag.setConstraints(printPicSize, con);
		con.gridwidth = GridBagConstraints.REMAINDER;
		con.weightx = 0.4;
		gridbag.setConstraints(printPicSizeComboBox, con);
		con.fill = GridBagConstraints.BOTH;
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 0.1;
		gridbag.setConstraints(T1, con);
		con.weightx = 0.4;
		gridbag.setConstraints(paperSize, con);
		con.weightx = 0.1;
		gridbag.setConstraints(inputPaperBox, con);
		con.gridwidth = GridBagConstraints.REMAINDER;
		con.weightx = 0.6;
		gridbag.setConstraints(inputPaperBoxComboBox, con);
		con.fill = GridBagConstraints.BOTH;
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 0.1;
		gridbag.setConstraints(paperType, con);
		con.weightx = 0.4;
		gridbag.setConstraints(paperTypeComboBox, con);
		con.weightx = 0.1;
		gridbag.setConstraints(paperWeight, con);
		con.gridwidth = GridBagConstraints.REMAINDER;
		con.weightx = 0.6;
		gridbag.setConstraints(paperWeightComboBox, con);
		con.fill = GridBagConstraints.BOTH;
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 0.1;
		gridbag.setConstraints(paperColor, con);
		con.weightx = 0.4;
		gridbag.setConstraints(paperColorComboBox, con);
		con.weightx = 0.1;
		gridbag.setConstraints(prePunchHole, con);
		con.gridwidth = GridBagConstraints.REMAINDER;
		con.weightx = 0.6;
		gridbag.setConstraints(T2, con);

		return baseInfo;
	}

	private JPanel initPageInsertCoverInfoPanel() {

		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints con = new GridBagConstraints();
		JPanel panel = new JPanel(gridbag);
		panel.setBorder(BorderFactory.createTitledBorder(""));

		JLabel coverInPaperBox = new JLabel("进纸盒:");
//        String [] coverInPaperBoxStr = {"手动进纸盒","纸盒1","纸盒2"};
//        JComboBox coverInPaperBoxC = new JComboBox(coverInPaperBoxStr);
		JLabel coverPrintOption = new JLabel("打印选项:");

		ButtonGroup bg = new ButtonGroup();
//        JRadioButton coverPlainPage = new JRadioButton("空白页");
//        JRadioButton coverPrint = new JRadioButton("打印");
		bg.add(coverPlainPageRadioButton);
		bg.add(coverPrintRadioButton);
		coverPrintRadioButton.setSelected(true);

		JLabel coverTwoSideOutput = new JLabel("双面输出:");
//        String [] coverTwoSideOutputStr = {"无","长边翻转","短边翻转"};
//        JComboBox coverTwoSideOutputC = new JComboBox(coverTwoSideOutputStr);

		panel.add(coverInPaperBox);
		panel.add(coverInPaperBoxComboBox);
		panel.add(coverPrintOption);
		panel.add(coverPlainPageRadioButton);
		panel.add(coverPrintRadioButton);
		panel.add(coverTwoSideOutput);
		panel.add(coverTwoSideOutputComboBox);

		con.fill = GridBagConstraints.BOTH;
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 0.3;
		con.gridheight = 1;
		con.insets = new Insets(2, 3, 2, 3);
		gridbag.setConstraints(coverInPaperBox, con);
		con.gridwidth = GridBagConstraints.REMAINDER;
		con.weightx = 0.7;
		gridbag.setConstraints(coverInPaperBoxComboBox, con);
		// scover.weightx = 1;
		con.gridwidth = GridBagConstraints.BOTH;
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 0.3;
		gridbag.setConstraints(coverPrintOption, con);
		con.weightx = 0.35;
		gridbag.setConstraints(coverPlainPageRadioButton, con);
		con.gridwidth = GridBagConstraints.REMAINDER;
		con.weightx = 0.35;
		gridbag.setConstraints(coverPrintRadioButton, con);
		con.gridwidth = GridBagConstraints.BOTH;
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 0.3;
		gridbag.setConstraints(coverTwoSideOutput, con);
		con.gridwidth = GridBagConstraints.REMAINDER;
		con.weightx = 0.7;
		gridbag.setConstraints(coverTwoSideOutputComboBox, con);

		return panel;
	}

	private JPanel initPageInsertBackCoverInfoPanel() {

		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints con = new GridBagConstraints();
		JPanel panel = new JPanel(gridbag);
		panel.setBorder(BorderFactory.createTitledBorder(""));

		JLabel inPaperBox = new JLabel("进纸盒:");
//        String [] inPaperBoxStr = {"手动进纸盒","纸盒1","纸盒2"};
//        JComboBox inPaperBoxC = new JComboBox(inPaperBoxStr);
		JLabel printOption = new JLabel("打印选项:");
//        
		ButtonGroup bg = new ButtonGroup();
//        JRadioButton plainPage = new JRadioButton("空白页");
//        JRadioButton print = new JRadioButton("打印");
		bg.add(plainPageRadioButton);
		bg.add(printRadioButton);

		inPaperBoxComboBox.setEnabled(false);
		plainPageRadioButton.setEnabled(false);
		printRadioButton.setEnabled(false);
		twoSideOutputComboBox.setEnabled(false);

		printRadioButton.setSelected(true);

//        JLabel twoSideOutput = new JLabel("双面输出:");
//        String [] twoSideOutputStr = {"无","长边翻转","短边翻转"};
//        JComboBox twoSideOutputC = new JComboBox(twoSideOutputStr);

		panel.add(inPaperBox);
		panel.add(inPaperBoxComboBox);
		panel.add(printOption);
		panel.add(plainPageRadioButton);
		panel.add(printRadioButton);
		panel.add(twoSideOutput);
		panel.add(twoSideOutputComboBox);

		con.fill = GridBagConstraints.BOTH;
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 0.3;
		con.insets = new Insets(2, 3, 2, 3);
		gridbag.setConstraints(inPaperBox, con);
		con.gridwidth = GridBagConstraints.REMAINDER;
		con.weightx = 0.7;
		gridbag.setConstraints(inPaperBoxComboBox, con);
		// scover.weightx = 1;
		con.gridwidth = GridBagConstraints.BOTH;
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 0.3;
		gridbag.setConstraints(printOption, con);
		con.weightx = 0.35;
		gridbag.setConstraints(plainPageRadioButton, con);
		con.gridwidth = GridBagConstraints.REMAINDER;
		con.weightx = 0.35;
		gridbag.setConstraints(printRadioButton, con);
		con.gridwidth = GridBagConstraints.BOTH;
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 0.3;
		gridbag.setConstraints(twoSideOutput, con);
		con.gridwidth = GridBagConstraints.REMAINDER;
		con.weightx = 0.7;
		gridbag.setConstraints(twoSideOutputComboBox, con);

		return panel;
	}

	private JPanel initPageInsertEditPaperPanel() {
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints con = new GridBagConstraints();
		JPanel panel = new JPanel(gridbag);
		panel.setBorder(BorderFactory.createTitledBorder(""));

		// buttons
		JPanel buttons = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
		// buttons.setBorder(BorderFactory.createTitledBorder(""));
		JButton add = new JButton("添加");
		JButton edit = new JButton("编辑");
		JButton delete = new JButton("删除");
		JButton clear = new JButton("清空");
		buttons.add(add);
		buttons.add(edit);
		buttons.add(delete);
		buttons.add(clear);

		// table
		// String [] columnName = {"页码","进纸盒","打印选项"};
//        Object[][] cellData = {{"1","box1","option1"},{"2","box2","option2"}};
		// Object[][] cellData = null;
		// DefaultTableModel model = new DefaultTableModel(cellData, columnName) ;
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new Object[] { "页码", "进纸盒", "打印选项" });
		model.setRowCount(2);
		JTable printInfo = new JTable(model);
		printInfo.setRowHeight(35);
		JScrollPane scrollPane = new JScrollPane(printInfo);

		panel.add(buttons);
		panel.add(scrollPane);

		con.fill = GridBagConstraints.BOTH;
		con.gridwidth = GridBagConstraints.REMAINDER;
		con.weightx = 1;
		con.weighty = 0;
		con.gridheight = 1;
		con.insets = new Insets(3, 3, 0, 3);
		gridbag.setConstraints(buttons, con);
		con.fill = GridBagConstraints.BOTH;
		con.gridwidth = GridBagConstraints.REMAINDER;
		con.weightx = 1;
		con.weighty = 1;
		con.gridheight = 5;
		gridbag.setConstraints(scrollPane, con);

		return panel;
	}

	private JPanel initPageInsertCoverBackCoverPanel() {

		JPanel panel = new JPanel(new GridLayout(1, 4, 3, 3));
		panel.setBorder(BorderFactory.createTitledBorder(""));

		// JCheckBox cover = new JCheckBox("封面");
		// JCheckBox backCoverHaveSameSettings = new JCheckBox("封底与封面使用相同设置");
		// JCheckBox backCover = new JCheckBox("封底");

		backCoverCheckBox.addActionListener(actionListener);
		panel.add(coverCheckBox);
		panel.add(backCoverHaveSameSettingsCheckBox);
		panel.add(backCoverCheckBox);
		panel.add(new JLabel());

		return panel;
	}

	private JPanel initPageInsertSettingsPanel() {
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints con = new GridBagConstraints();
		JPanel panel = new JPanel(gridbag);
		panel.setBorder(BorderFactory.createTitledBorder("插页设置"));

		JPanel coverBackCover = initPageInsertCoverBackCoverPanel();
		JPanel coverSettings = initPageInsertCoverInfoPanel();
		JPanel backCoverSettings = initPageInsertBackCoverInfoPanel();
		// JCheckBox insertPage = new JCheckBox("内插页");
		JPanel editPaper = initPageInsertEditPaperPanel();

		panel.add(coverBackCover);
		panel.add(coverSettings);
		panel.add(backCoverSettings);
		panel.add(insertPageCheckBox);
		panel.add(editPaper);

		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridwidth = GridBagConstraints.REMAINDER;
		con.weightx = 1;
		con.weighty = 0;
		con.gridheight = 1;
		con.insets = new Insets(3, 3, 3, 3);
		gridbag.setConstraints(coverBackCover, con);

		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 1;
		con.weighty = 0;
		con.gridheight = 3;
		gridbag.setConstraints(coverSettings, con);
		con.gridwidth = GridBagConstraints.REMAINDER;
		gridbag.setConstraints(backCoverSettings, con);

		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridwidth = GridBagConstraints.REMAINDER;
		con.weightx = 1;
		con.weighty = 0;
		con.gridheight = 1;
		gridbag.setConstraints(insertPageCheckBox, con);

		con.fill = GridBagConstraints.BOTH;
		con.weightx = 1;
		con.weighty = 1;
		con.gridheight = 15;
		gridbag.setConstraints(editPaper, con);

		return panel;
	}

	// 事件响应
	ActionListener actionListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int mode = 0;
			if (backCoverCheckBox.isSelected()) {
				inPaperBoxComboBox.setEnabled(true);
				plainPageRadioButton.setEnabled(true);
				printRadioButton.setEnabled(true);
				twoSideOutputComboBox.setEnabled(true);
			} else {
				inPaperBoxComboBox.setEnabled(false);
				plainPageRadioButton.setEnabled(false);
				printRadioButton.setEnabled(false);
				twoSideOutputComboBox.setEnabled(false);
			}
		}
	};

}
