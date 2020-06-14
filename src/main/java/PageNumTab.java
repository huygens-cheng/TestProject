import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 页码面板
 * 
 * @author chen
 *
 */
public class PageNumTab extends JPanel {

	// PageNumTab
	private JCheckBox addPageNum = new JCheckBox("添加页码");

	// function: pageNumFont
	private String[] pageNumFontStr = { "Arial" };
	private JComboBox pageNumFontComboBox = new JComboBox(pageNumFontStr);
	private final SpinnerModel model = new SpinnerNumberModel(12.0, 0, 10000, 0.1);
	private JSpinner fontSizeSpinner = new JSpinner(model);
	private JComboBox fontPreSufComboBox = new JComboBox(pageNumFontStr);
	private final SpinnerModel model2 = new SpinnerNumberModel(13.0, 0.0, 10000.0, 0.1);
	private JSpinner fontSize2Spinner = new JSpinner(model2);
	private JTextField fontGapTextField = new JTextField();
	private final SpinnerModel model3 = new SpinnerNumberModel(13.0, 0, 10000, 1);
	private JSpinner insetDigitSpinner = new JSpinner(model3);

	// function:pageNumPositionFront
	private JTextField xPositionTextField = new JTextField();
	private JTextField yPositionTextField = new JTextField();

	// function:pageNumPositionBack
	private JTextField xBackPositionTextField = new JTextField();
	private JTextField yBackPositionTextField = new JTextField();

	// function:pageNUmAdvanceLeft
	final SpinnerModel model4 = new SpinnerNumberModel(1, 0, 1000000000, 1);
	private JSpinner startNumSpinner = new JSpinner(model4);
	private JTextField prefixTextField = new JTextField();
	private JTextField suffixTextField = new JTextField();

	// function:
	private JTextField keepPageNumTextField = new JTextField();
	private JTextField filterPageNumTextField = new JTextField();

	// function:PageNumTab
	JPanel panelFont = initPageNumFontPanel();
	JPanel panelPosition = initPageNumPositionPanel();
	JPanel panelAdvance = initPageNumAdcancePanel();

	public PageNumTab() {
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints con = new GridBagConstraints();
		// JPanel panel = new JPanel(gridbag);// //
		this.setLayout(gridbag);

		// JCheckBox addPageNum = new JCheckBox("添加页码");

//		  JPanel panelFont = initPageNumFontPanel();
//		  JPanel panelPosition = initPageNumPositionPanel();
//		  JPanel panelAdvance = initPageNumAdcancePanel();
		panelFont.setVisible(false);
		panelPosition.setVisible(false);
		panelAdvance.setVisible(false);
		JPanel panelEmpty = new JPanel();
		addPageNum.addActionListener(addPageNumActionListener);

		this.add(addPageNum);
		this.add(panelFont);
		this.add(panelPosition);
		this.add(panelAdvance);
		this.add(panelEmpty);

		con.fill = GridBagConstraints.BOTH;
		con.weightx = 1;
		con.weighty = 0;
		// con.anchor = GridBagConstraints.NORTH;
		con.insets = new Insets(3, 3, 3, 3);
		con.gridwidth = GridBagConstraints.REMAINDER;
		gridbag.setConstraints(addPageNum, con);
		con.gridwidth = GridBagConstraints.REMAINDER;
		con.weighty = 0;
		gridbag.setConstraints(panelFont, con);
		con.gridwidth = GridBagConstraints.REMAINDER;
		con.weighty = 0;
		gridbag.setConstraints(panelPosition, con);
		con.gridwidth = GridBagConstraints.REMAINDER;
		con.weighty = 0;
		gridbag.setConstraints(panelAdvance, con);
		con.weighty = 1;
		gridbag.setConstraints(panelEmpty, con);
		// return panel;

	}

	private JPanel initPageNumFontPanel() {

		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints con = new GridBagConstraints();
		JPanel panel = new JPanel(gridbag);
		panel.setBorder(BorderFactory.createTitledBorder("字体:"));

		JLabel pageNumFont = new JLabel("页码字体:");
		// JComboBox pageNumFontC = new JComboBox();
		JLabel blank1 = new JLabel();

		JLabel fontSize = new JLabel("字体大小:");
//	  final SpinnerModel model = new SpinnerNumberModel(12.0, 0, 10000, 0.1);
//	  JSpinner fontSizeS = new JSpinner(model);
		// JTextField T1 = new JTextField();
		JLabel unit1 = new JLabel("磅");

		JLabel fontPreSuf = new JLabel("前后缀字体：");
//	  JComboBox fontPreSufC = new JComboBox();
		JLabel balnk2 = new JLabel();

		JLabel fontSize2 = new JLabel("字体大小:");
//	  final SpinnerModel model2 = new SpinnerNumberModel(13.0, 0.0, 10000.0, 0.1);
//	  JSpinner fontSize2S = new JSpinner(model2);
		// JTextField T2 = new JTextField();
		JLabel unit2 = new JLabel("磅");

		JLabel fontGap = new JLabel("字体间距:");
//	  JTextField fontGapT = new JTextField();
		JLabel mm = new JLabel("mm");

		JLabel insetDigit = new JLabel("填充位数:");
//	  final SpinnerModel model3 = new SpinnerNumberModel(13.0, 0, 10000, 1);
//	  JSpinner insetDigitS = new JSpinner(model3);
		// JTextField T3 = new JTextField();
		JLabel balnk3 = new JLabel();

		fontGapTextField.setText("0.0");

		panel.add(pageNumFont);
		panel.add(pageNumFontComboBox);
		panel.add(blank1);
		panel.add(fontSize);
		panel.add(fontSizeSpinner);
		panel.add(unit1);

		panel.add(fontPreSuf);
		panel.add(fontPreSufComboBox);
		panel.add(balnk2);
		panel.add(fontSize2);
		panel.add(fontSize2Spinner);
		panel.add(unit2);

		panel.add(fontGap);
		panel.add(fontGapTextField);
		panel.add(mm);
		panel.add(insetDigit);
		panel.add(insetDigitSpinner);
		panel.add(balnk3);

		con.fill = GridBagConstraints.BOTH;
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 0.0;
		con.insets = new Insets(3, 3, 3, 3);
		// con.anchor = GridBagConstraints.WEST;
		gridbag.setConstraints(pageNumFont, con);
		con.weightx = 0.5;
		gridbag.setConstraints(pageNumFontComboBox, con);
		con.weightx = 0.00;
		gridbag.setConstraints(blank1, con);
		con.weightx = 0.0;
		gridbag.setConstraints(fontSize, con);
		con.weightx = 0.5;
		gridbag.setConstraints(fontSizeSpinner, con);
		con.weightx = 0.00;
		con.gridwidth = GridBagConstraints.REMAINDER;
		gridbag.setConstraints(unit1, con);

		con.fill = GridBagConstraints.BOTH;
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 0.0;
		gridbag.setConstraints(fontPreSuf, con);
		con.weightx = 0.5;
		gridbag.setConstraints(fontPreSufComboBox, con);
		con.weightx = 0.00;
		gridbag.setConstraints(balnk2, con);
		con.weightx = 0.0;
		gridbag.setConstraints(fontSize2, con);
		con.weightx = 0.5;
		gridbag.setConstraints(fontSize2Spinner, con);
		con.gridwidth = GridBagConstraints.REMAINDER;
		con.weightx = 0.00;
		gridbag.setConstraints(unit2, con);

		con.fill = GridBagConstraints.BOTH;
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 0.0;
		gridbag.setConstraints(fontGap, con);
		con.weightx = 0.5;
		gridbag.setConstraints(fontGapTextField, con);
		con.weightx = 0.00;
		gridbag.setConstraints(mm, con);
		con.weightx = 0.0;
		gridbag.setConstraints(insetDigit, con);
		con.weightx = 0.5;
		gridbag.setConstraints(insetDigitSpinner, con);
		con.gridwidth = GridBagConstraints.REMAINDER;
		con.weightx = 0.00;
		gridbag.setConstraints(balnk3, con);

		return panel;
	}

	private JPanel initPageNumPositionFrontPanel() {

		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints con = new GridBagConstraints();
		JPanel panel = new JPanel(gridbag);
		panel.setBorder(BorderFactory.createTitledBorder("正面"));

		JLabel xPosition = new JLabel("x坐标:");
		// JTextField xPositionT = new JTextField();
		JLabel unit1 = new JLabel("mm");

		JLabel yPosition = new JLabel("y坐标:");
		// JTextField yPositionT = new JTextField();
		JLabel unit2 = new JLabel("mm");

		xPositionTextField.setText("10.0");
		yPositionTextField.setText("15.0");

		panel.add(xPosition);
		panel.add(xPositionTextField);
		panel.add(unit1);

		panel.add(yPosition);
		panel.add(yPositionTextField);
		panel.add(unit2);

		con.fill = GridBagConstraints.BOTH;
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 0.0;
		con.insets = new Insets(3, 3, 3, 3);
		gridbag.setConstraints(xPosition, con);
		con.weightx = 0.8;
		gridbag.setConstraints(xPositionTextField, con);
		con.gridwidth = GridBagConstraints.REMAINDER;
		con.weightx = 0.00;
		gridbag.setConstraints(unit1, con);

		con.fill = GridBagConstraints.BOTH;
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 0.0;
		gridbag.setConstraints(yPosition, con);
		con.weightx = 0.8;
		gridbag.setConstraints(yPositionTextField, con);
		con.gridwidth = GridBagConstraints.REMAINDER;
		con.weightx = 0.00;
		gridbag.setConstraints(unit2, con);

		return panel;
	}

	private JPanel initPageNumPositionBackPanel() {

		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints con = new GridBagConstraints();
		JPanel panel = new JPanel(gridbag);
		panel.setBorder(BorderFactory.createTitledBorder("反面"));

		JLabel xPosition = new JLabel("x坐标:");
		// JTextField xPositionT = new JTextField();
		JLabel unit1 = new JLabel("mm");

		JLabel yPosition = new JLabel("y坐标:");
		// JTextField yPositionT = new JTextField();
		JLabel unit2 = new JLabel("mm");

		xBackPositionTextField.setText("10.0");
		yBackPositionTextField.setText("15.0");

		panel.add(xPosition);
		panel.add(xBackPositionTextField);
		panel.add(unit1);

		panel.add(yPosition);
		panel.add(yBackPositionTextField);
		panel.add(unit2);

		con.fill = GridBagConstraints.BOTH;
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 0.0;
		con.insets = new Insets(3, 3, 3, 3);
		gridbag.setConstraints(xPosition, con);
		con.weightx = 0.8;
		gridbag.setConstraints(xBackPositionTextField, con);
		con.gridwidth = GridBagConstraints.REMAINDER;
		con.weightx = 0.00;
		gridbag.setConstraints(unit1, con);

		con.fill = GridBagConstraints.BOTH;
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 0.0;
		gridbag.setConstraints(yPosition, con);
		con.weightx = 0.8;
		gridbag.setConstraints(yBackPositionTextField, con);
		con.gridwidth = GridBagConstraints.REMAINDER;
		con.weightx = 0.00;
		gridbag.setConstraints(unit2, con);

		return panel;
	}

	private JPanel initPageNumPositionPanel() {

		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints con = new GridBagConstraints();
		JPanel panel = new JPanel(gridbag);
		panel.setBorder(BorderFactory.createTitledBorder("页码位置"));

		JPanel front = initPageNumPositionFrontPanel();
		JPanel back = initPageNumPositionBackPanel();

		panel.add(front);
		panel.add(back);

		con.fill = GridBagConstraints.BOTH;
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 0.5;
		con.insets = new Insets(3, 3, 3, 3);
		gridbag.setConstraints(front, con);
		gridbag.setConstraints(back, con);

		return panel;
	}

	private JPanel initPageNUmAdvanceLeftPanel() {

		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints con = new GridBagConstraints();
		JPanel panel = new JPanel(gridbag);
		panel.setBorder(BorderFactory.createTitledBorder(""));

		JLabel startNum = new JLabel("起始号:");
//	   final SpinnerModel model = new SpinnerNumberModel(1, 0, 1000000000, 1);
//		 JSpinner startNumS = new JSpinner(model);
		// JTextField T1 = new JTextField();
		JLabel prefix = new JLabel("前缀:");
//	   JTextField prefixT = new JTextField();
		JLabel suffix = new JLabel("后缀:");
//	   JTextField suffixT = new JTextField();

		panel.add(startNum);
		panel.add(startNumSpinner);
		panel.add(prefix);
		panel.add(prefixTextField);
		panel.add(suffix);
		panel.add(suffixTextField);

		con.fill = GridBagConstraints.BOTH;
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 0.0;
		con.insets = new Insets(3, 3, 3, 3);
		gridbag.setConstraints(startNum, con);
		con.gridwidth = GridBagConstraints.REMAINDER;
		con.weightx = 0.7;
		gridbag.setConstraints(startNumSpinner, con);

		con.fill = GridBagConstraints.BOTH;
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 0.0;
		gridbag.setConstraints(prefix, con);
		con.gridwidth = GridBagConstraints.REMAINDER;
		con.weightx = 0.7;
		gridbag.setConstraints(prefixTextField, con);

		con.fill = GridBagConstraints.BOTH;
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 0.0;
		gridbag.setConstraints(suffix, con);
		con.gridwidth = GridBagConstraints.REMAINDER;
		con.weightx = 0.7;
		gridbag.setConstraints(suffixTextField, con);

		return panel;
	}

	private JPanel initPageNUmAdvanceIgnorePageNumPanel() {

		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints con = new GridBagConstraints();
		JPanel panel = new JPanel(gridbag);
		panel.setBorder(BorderFactory.createTitledBorder("忽略页码"));

		JLabel keepPageNum = new JLabel("页码保留：");
		// JTextField keepPageNumT = new JTextField();
		JLabel sample1 = new JLabel("例：1,3-7,9");
		JLabel filterPageNum = new JLabel("页码过滤:");
//		 JTextField filterPageNumT = new JTextField();
		JLabel sample2 = new JLabel("例：1,3-7,9");

		keepPageNumTextField.setText("10.0");
		filterPageNumTextField.setText("15.0");

		panel.add(keepPageNum);
		panel.add(keepPageNumTextField);
		panel.add(sample1);
		panel.add(filterPageNum);
		panel.add(filterPageNumTextField);
		panel.add(sample2);

		con.fill = GridBagConstraints.BOTH;
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 0.0;
		con.insets = new Insets(3, 3, 3, 3);
		gridbag.setConstraints(keepPageNum, con);
		con.weightx = 0.8;
		gridbag.setConstraints(keepPageNumTextField, con);
		con.gridwidth = GridBagConstraints.REMAINDER;
		con.weightx = 0.0;
		gridbag.setConstraints(sample1, con);

		con.fill = GridBagConstraints.BOTH;
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 0.0;
		gridbag.setConstraints(filterPageNum, con);
		con.weightx = 0.8;
		gridbag.setConstraints(filterPageNumTextField, con);
		con.gridwidth = GridBagConstraints.REMAINDER;
		con.weightx = 0.0;
		gridbag.setConstraints(sample2, con);

		return panel;
	}

	private JPanel initPageNumAdcancePanel() {

		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints con = new GridBagConstraints();
		JPanel panel = new JPanel(gridbag);
		panel.setBorder(BorderFactory.createTitledBorder("高级"));

		JPanel left = initPageNUmAdvanceLeftPanel();
		JPanel ignorePageNum = initPageNUmAdvanceIgnorePageNumPanel();

		panel.add(left);
		panel.add(ignorePageNum);

		con.fill = GridBagConstraints.BOTH;
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 1.0;
		con.insets = new Insets(3, 3, 3, 3);
		gridbag.setConstraints(left, con);
		gridbag.setConstraints(ignorePageNum, con);

		return panel;
	}

	// 事件响应
	ActionListener addPageNumActionListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int mode = 0;
			if (addPageNum.isSelected()) {
				panelFont.setVisible(true);
				panelPosition.setVisible(true);
				panelAdvance.setVisible(true);

			} else {
				panelFont.setVisible(false);
				panelPosition.setVisible(false);
				panelAdvance.setVisible(false);

			}
		}
	};

//	private JPanel createPageNumTab(){
//	
//		GridBagLayout gridbag = new GridBagLayout();
//		GridBagConstraints con = new GridBagConstraints();
//    JPanel panel = new JPanel(gridbag);
//    
//    JCheckBox addPageNum = new JCheckBox("添加页码");
//    
//    JPanel panelFont = initPageNumFontPanel();
//    JPanel panelPosition = initPageNumPositionPanel();
//    JPanel panelAdvance = initPageNumAdcancePanel();
//    JPanel panelEmpty = new JPanel();
//    
//    panel.add(addPageNum);
//    panel.add(panelFont);
//    panel.add(panelPosition);
//    panel.add(panelAdvance);
//    panel.add(panelEmpty);
//    
//    con.fill = GridBagConstraints.BOTH;
//    con.weightx = 1;
//    con.weighty =0;
//    //con.anchor = GridBagConstraints.NORTH;
//    con.insets=new Insets(3, 3, 3, 3);
//    con.gridwidth = GridBagConstraints.REMAINDER;
//    gridbag.setConstraints(addPageNum, con);
//    con.gridwidth = GridBagConstraints.REMAINDER;
//    con.weighty =0;
//    gridbag.setConstraints(panelFont, con);
//    con.gridwidth = GridBagConstraints.REMAINDER;
//    con.weighty =0;
//    gridbag.setConstraints(panelPosition, con);
//    con.gridwidth = GridBagConstraints.REMAINDER;
//    con.weighty =0;
//    gridbag.setConstraints(panelAdvance, con);
//    con.weighty =1;
//    gridbag.setConstraints(panelEmpty, con);
//    
//    return panel;
//}

}
