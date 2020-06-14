import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 输出面板
 * 
 * @author chen
 *
 */
public class OutputTab extends JPanel {

	// function:initBaseInfoPanel
	private final SpinnerModel model1 = new SpinnerNumberModel(1, 0, 9999, 1);
	private JSpinner copyNumberSpinner = new JSpinner(model1);
	private JCheckBox printOneByOneCheckBox = new JCheckBox("逐份打印");
	private JCheckBox dislocationOutputCheckBox = new JCheckBox("错位输出");
	private JCheckBox separatorPaperCheckBox = new JCheckBox("分隔纸");
	private JCheckBox reverseOrderCheckBox = new JCheckBox("逆序");

	// function:initFrontFacePanel
	private final SpinnerModel model2 = new SpinnerNumberModel(0, 0, 9999, 0.01);
	private JSpinner xFrontPositionSpinner = new JSpinner(model2);
	private final SpinnerModel model4 = new SpinnerNumberModel(0, 0, 9999, 0.01);
	private JSpinner yFrontPositionSpinner = new JSpinner(model4);
	// function:initBackFacePanel
	private final SpinnerModel model3 = new SpinnerNumberModel(0, 0, 9999, 0.01);
	private JSpinner xBackPositionSpinner = new JSpinner(model3);
	private final SpinnerModel model5 = new SpinnerNumberModel(0, 0, 9999, 0.01);
	private JSpinner yBackPositionSpinner = new JSpinner(model5);

	// function:initOutputLeftPanel
	private String[] coverTwoSideOutputStr = { "无", "长边翻转", "短边翻转" };
	private JComboBox doubleSideOutputComboBox = new JComboBox(coverTwoSideOutputStr);
	private String[] outputPaperBoxStr = { "自动", "[大容量集纸器 自动]", "[大容量主纸盘]", "[大容量集纸器 1/2 主纸盘/副纸盘]", "[多功能折叠器 主纸盘]",
			"[多功能折叠器 副纸盘]", "[骑马装订装置 副纸盘]", "[平订装置 主纸盘]", "[平订装置 副纸盘]", "[冷胶装订机副纸盘]", "[外部派线处理器]" };
	private JComboBox outputPaperBoxComboBox = new JComboBox(outputPaperBoxStr);
	private String[] outputPaperTypeStr = { "无", "折页", "Z形折", "内3折", "外3折", "双联折", "观音折", "多张3折", "风琴折" };
	private JComboBox outputPaperTypeComboBox = new JComboBox(outputPaperTypeStr);

	// function:initOutputRightPanel
	private JRadioButton verticalRadioButton = new JRadioButton("纵向");
	private JRadioButton horizontalRadioButton = new JRadioButton("横向");
	private JCheckBox printToFileCheckBox = new JCheckBox("打印到文件");
	private JCheckBox mirrorInversionCheckBox = new JCheckBox("镜像");
	private JCheckBox negativePictureCheckBox = new JCheckBox("阴图");

	// function:initFinishPanel
	private String[] gutterPositionStr = { "无", "左装订", "右装订", "上装订" };
	private JComboBox gutterPositionComboBox = new JComboBox(gutterPositionStr);
	private String[] foldingTypeStr = { "无", "折页", "Z形折", "内3折", "外3折", "双联折", "观音折", "多张3折", "风琴折" };
	private JComboBox foldingTypeComboBox = new JComboBox(foldingTypeStr);
	private String[] bingdingTypeStr = { "无", "左角", "右角", "2点", "2点位置(宽)", "2点位置(窄)", "2点位置(窄+)" };
	private JComboBox bingdingTypeComboBox = new JComboBox(bingdingTypeStr);
	private String[] punchHoleStr = { "无", "2孔", "3孔", "4孔", "多功能打孔", "双重多功能打孔" };
	private JComboBox punchHoleComboBox = new JComboBox(punchHoleStr);

	private JPanel initCopyNumPanel() {

		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints con = new GridBagConstraints();
		JPanel panel = new JPanel(gridbag);
		// panel.setBorder(BorderFactory.createTitledBorder("基本信息"));

		JLabel copyNumber = new JLabel("拷贝份数");
		JLabel number = new JLabel("1-9999");

		panel.add(copyNumber);
		panel.add(copyNumberSpinner);
		panel.add(number);

		con.fill = GridBagConstraints.HORIZONTAL;
		con.weightx = 0;
		con.insets = new Insets(3, 3, 0, 3);
		gridbag.setConstraints(copyNumber, con);
		con.gridwidth = GridBagConstraints.RELATIVE;
		con.weightx = 1;
		gridbag.setConstraints(copyNumberSpinner, con);
		con.gridwidth = GridBagConstraints.REMAINDER;
		con.weightx = 0;
		gridbag.setConstraints(number, con);

		return panel;
	}
	private JPanel initPrintOneByOnePanle() {
		
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
		
		JLabel imageLabel = new JLabel();
		ImageIcon colorIcon = new ImageIcon("/home/chen/Pictures/images/locationDiagram.png");
	  colorIcon.setImage(colorIcon.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));//宽高根据需要设定    
	  imageLabel.setIcon(colorIcon);
	  JLabel blank = new JLabel();
	  
	  panel.add(printOneByOneCheckBox);
		panel.add(imageLabel);
	    
		return panel;
	}
	private JPanel initDislocationOutputPanle() {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
		
		JLabel imageLabel = new JLabel();
		ImageIcon colorIcon = new ImageIcon("/home/chen/Pictures/images/locationDiagram.png");
	  colorIcon.setImage(colorIcon.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));//宽高根据需要设定    
	  imageLabel.setIcon(colorIcon);
	  JLabel blank = new JLabel();
	  
	  panel.add(dislocationOutputCheckBox);
		panel.add(imageLabel);
		
		return panel;
	}
	private JPanel initSeparatorPaperPanle() {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
		
		JLabel imageLabel = new JLabel();
		ImageIcon colorIcon = new ImageIcon("/home/chen/Pictures/images/locationDiagram.png");
	  colorIcon.setImage(colorIcon.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));//宽高根据需要设定    
	  imageLabel.setIcon(colorIcon);
	  JLabel blank = new JLabel();
	  
	  panel.add(separatorPaperCheckBox);
		panel.add(imageLabel);
		
		return panel;
	}
	private JPanel initReverseOrderPanle() {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
		
		JLabel imageLabel = new JLabel();
		ImageIcon colorIcon = new ImageIcon("/home/chen/Pictures/images/locationDiagram.png");
	  colorIcon.setImage(colorIcon.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));//宽高根据需要设定    
	  imageLabel.setIcon(colorIcon);
	  JLabel blank = new JLabel();
	  
	  panel.add(reverseOrderCheckBox);
		panel.add(imageLabel);
		
		return panel;
	}
	private JPanel initBaseInfoOtherInfoPanel() {
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints con = new GridBagConstraints();
		JPanel panel = new JPanel(gridbag);

		JPanel printOneByOnePanle = initPrintOneByOnePanle();
		JPanel dislocationOutputPanle = initDislocationOutputPanle();
		JPanel separatorPaperPanle = initSeparatorPaperPanle();
		JPanel reverseOrderPanle = initReverseOrderPanle();
		
		panel.add(printOneByOnePanle);
		panel.add(dislocationOutputPanle);
		panel.add(separatorPaperPanle);
		panel.add(reverseOrderPanle);
		
		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 1;
		con.insets = new Insets(1, 3, 1, 3);
		gridbag.setConstraints(printOneByOnePanle, con);
		con.gridwidth = GridBagConstraints.REMAINDER;
		gridbag.setConstraints(dislocationOutputPanle, con);
		
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		gridbag.setConstraints(separatorPaperPanle, con);
		con.gridwidth = GridBagConstraints.REMAINDER;
		gridbag.setConstraints(reverseOrderPanle, con);
		
		
		
		
		
//		JLabel functionDiagramLabel1 = new JLabel();
//		JLabel functionDiagramLabel2 = new JLabel();
//		JLabel functionDiagramLabel3 = new JLabel();
//		JLabel functionDiagramLabel4 = new JLabel();
//		ImageIcon colorIcon = new ImageIcon("/home/chen/Pictures/images/locationDiagram.png");
//    colorIcon.setImage(colorIcon.getImage().getScaledInstance(38, 38, Image.SCALE_DEFAULT));//宽高根据需要设定    
//    functionDiagramLabel1.setIcon(colorIcon);
//    functionDiagramLabel2.setIcon(colorIcon);
//    functionDiagramLabel3.setIcon(colorIcon);
//    functionDiagramLabel4.setIcon(colorIcon);
//    
//    JLabel blank1 = new JLabel();
//    JLabel blank2 = new JLabel();
//    JLabel blank3 = new JLabel();
//    JLabel blank4 = new JLabel();
//		
//		panel.add(printOneByOneCheckBox);
//		panel.add(functionDiagramLabel1);
//		panel.add(blank1);
//		panel.add(dislocationOutputCheckBox);
//		panel.add(functionDiagramLabel2);
//		panel.add(blank2);
//		panel.add(separatorPaperCheckBox);
//		panel.add(functionDiagramLabel3);
//		panel.add(blank3);
//		panel.add(reverseOrderCheckBox);
//		panel.add(functionDiagramLabel4);
//		panel.add(blank4);
		
		

//		con.fill = GridBagConstraints.HORIZONTAL;
//		con.gridwidth = GridBagConstraints.HORIZONTAL;
//		con.weightx = 0;
//		con.insets = new Insets(1, 3, 0, 3);
//		gridbag.setConstraints(printOneByOneCheckBox, con);
//		gridbag.setConstraints(functionDiagramLabel1, con);
//		con.gridwidth = GridBagConstraints.REMAINDER;
//		con.weightx = 1;
//		gridbag.setConstraints(blank1, con);
//		
//		con.gridwidth = GridBagConstraints.HORIZONTAL;
//		con.weightx = 0;
//		gridbag.setConstraints(dislocationOutputCheckBox, con);
//		gridbag.setConstraints(functionDiagramLabel2, con);
//		con.gridwidth = GridBagConstraints.REMAINDER;
//		con.weightx = 1;
//		gridbag.setConstraints(blank2, con);
//		
//		con.gridwidth = GridBagConstraints.HORIZONTAL;
//		con.weightx = 0;
//		gridbag.setConstraints(separatorPaperCheckBox, con);
//		gridbag.setConstraints(functionDiagramLabel3, con);
//		con.gridwidth = GridBagConstraints.REMAINDER;
//		con.weightx = 1;
//		gridbag.setConstraints(blank3, con);
//		
//		con.gridwidth = GridBagConstraints.HORIZONTAL;
//		con.weightx = 0;
//		gridbag.setConstraints(reverseOrderCheckBox, con);
//		gridbag.setConstraints(functionDiagramLabel4, con);
//		con.gridwidth = GridBagConstraints.REMAINDER;
//		con.weightx = 1;
//		gridbag.setConstraints(blank4, con);
		
		return panel;
	}
	private JPanel initBaseInfoPanel() {
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints con = new GridBagConstraints();
		JPanel panel = new JPanel(gridbag);
		panel.setBorder(BorderFactory.createTitledBorder("基本信息"));

		JPanel copyNumPanel = initCopyNumPanel();
		JPanel otherInfoPanel = initBaseInfoOtherInfoPanel();
		//JPanel blank = new JPanel();

		panel.add(copyNumPanel);
		panel.add(otherInfoPanel);
		//panel.add(blank);

		con.fill = GridBagConstraints.BOTH;
		con.weightx = 1;
		con.insets = new Insets(0,3,0,3);
		con.gridwidth = GridBagConstraints.REMAINDER;
		gridbag.setConstraints(copyNumPanel, con);
		gridbag.setConstraints(otherInfoPanel, con);
		con.weighty = 1;
		//gridbag.setConstraints(blank, con);

		return panel;
	}
	private JPanel initShowPositionImagePanel(){
		
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints con = new GridBagConstraints();
		JPanel panel = new JPanel(gridbag);
		
		JLabel imageLabel = new JLabel();
		ImageIcon colorIcon = new ImageIcon("/home/chen/Pictures/images/locationDiagram.png");
    colorIcon.setImage(colorIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));//宽高根据需要设定    
    imageLabel.setIcon(colorIcon);
    	
    	panel.add(imageLabel);
    
    con.fill = GridBagConstraints.HORIZONTAL;
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.insets = new Insets(0, 3, 0, 3);
		gridbag.setConstraints(imageLabel, con);
		
		return panel;
	}
	private JPanel initFrontFacePanel() {
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints con = new GridBagConstraints();
		JPanel panel = new JPanel(gridbag);
		panel.setBorder(BorderFactory.createTitledBorder("正面"));

		JPanel locationDiagramLabel = initShowPositionImagePanel();
		//locationDiagramLabel.setBorder(BorderFactory.createTitledBorder(""));
		JLabel xFrontPositionLabel = new JLabel("X");
		JLabel unit1 = new JLabel("mm");
		JLabel yFrontPositionLabel = new JLabel("Y");
		JLabel unit2 = new JLabel("mm");

		panel.add(locationDiagramLabel);
		panel.add(xFrontPositionLabel);
		panel.add(xFrontPositionSpinner);
		panel.add(unit1);
		panel.add(yFrontPositionLabel);
		panel.add(yFrontPositionSpinner);
		panel.add(unit2);

		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridwidth = GridBagConstraints.REMAINDER;
		con.weightx = 1;
		con.weighty = 1;
		con.ipady = 0;
		gridbag.setConstraints(locationDiagramLabel, con);

		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 0;
		con.ipady = 0;
		con.insets = new Insets(3, 3, 3, 3);
		gridbag.setConstraints(xFrontPositionLabel, con);
		con.weightx = 1;
		gridbag.setConstraints(xFrontPositionSpinner, con);
		con.gridwidth = GridBagConstraints.REMAINDER;
		con.weightx = 0;
		gridbag.setConstraints(unit1, con);

		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 0;
		gridbag.setConstraints(yFrontPositionLabel, con);
		con.weightx = 1;
		gridbag.setConstraints(yFrontPositionSpinner, con);
		con.gridwidth = GridBagConstraints.REMAINDER;
		con.weightx = 0;
		gridbag.setConstraints(unit2, con);

		return panel;
	}
	private JPanel initBackFacePanel() {

		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints con = new GridBagConstraints();
		JPanel panel = new JPanel(gridbag);
		panel.setBorder(BorderFactory.createTitledBorder("反面"));

		JPanel locationDiagramLabel = initShowPositionImagePanel();
		//locationDiagramLabel.setBorder(BorderFactory.createTitledBorder(""));
		JLabel xBackPositionLabel = new JLabel("X");
		JLabel unit1 = new JLabel("mm");
		JLabel yBackPositionLabel = new JLabel("Y");
		JLabel unit2 = new JLabel("mm");

		
		panel.add(locationDiagramLabel);
		panel.add(xBackPositionLabel);
		panel.add(xBackPositionSpinner);
		panel.add(unit1);
		panel.add(yBackPositionLabel);
		panel.add(yBackPositionSpinner);
		panel.add(unit2);

		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridwidth = GridBagConstraints.REMAINDER;
		con.weightx = 1;
		con.weighty = 1;
		con.ipady = 0;
		gridbag.setConstraints(locationDiagramLabel, con);

		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 0;
		con.ipady = 0;
		con.insets = new Insets(3, 3, 3, 3);
		gridbag.setConstraints(xBackPositionLabel, con);
		con.weightx = 1;
		gridbag.setConstraints(xBackPositionSpinner, con);
		con.gridwidth = GridBagConstraints.REMAINDER;
		con.weightx = 0;
		gridbag.setConstraints(unit1, con);

		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 0;
		gridbag.setConstraints(yBackPositionLabel, con);
		con.weightx = 1;
		gridbag.setConstraints(yBackPositionSpinner, con);
		con.gridwidth = GridBagConstraints.REMAINDER;
		con.weightx = 0;
		gridbag.setConstraints(unit2, con);

		return panel;
	}
	private JPanel initDisplacementPanel() {
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints con = new GridBagConstraints();
		JPanel panel = new JPanel(gridbag);
		panel.setBorder(BorderFactory.createTitledBorder("位移"));

		JPanel frontFacePanel = initFrontFacePanel();
		JPanel backFacePanel = initBackFacePanel();

		panel.add(frontFacePanel);
		panel.add(backFacePanel);

		con.fill = GridBagConstraints.HORIZONTAL;
		con.weightx = 0.5;
		con.weighty = 1;
		gridbag.setConstraints(frontFacePanel, con);
		gridbag.setConstraints(backFacePanel, con);

		return panel;
	}
	private JPanel initOutputLeftPanel() {

		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints con = new GridBagConstraints();
		JPanel panel = new JPanel(gridbag);

		JLabel doubleSideOutputLabel = new JLabel("双面输出:");
		JLabel outputPaperBoxLabel = new JLabel("出纸盒:");
		JLabel outputWayLabel = new JLabel("出纸方式:");

		panel.add(doubleSideOutputLabel);
		panel.add(doubleSideOutputComboBox);
		panel.add(outputPaperBoxLabel);
		panel.add(outputPaperBoxComboBox);
		panel.add(outputWayLabel);
		panel.add(outputPaperTypeComboBox);

		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 0;
		con.insets = new Insets(3, 3, 3, 3);
		gridbag.setConstraints(doubleSideOutputLabel, con);
		con.weightx = 0.7;
		con.gridwidth = GridBagConstraints.REMAINDER;
		gridbag.setConstraints(doubleSideOutputComboBox, con);

		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 0;
		gridbag.setConstraints(outputPaperBoxLabel, con);
		con.weightx = 1;
		con.gridwidth = GridBagConstraints.REMAINDER;
		gridbag.setConstraints(outputPaperBoxComboBox, con);

		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 0;
		gridbag.setConstraints(outputWayLabel, con);
		con.weightx = 1;
		con.gridwidth = GridBagConstraints.REMAINDER;
		gridbag.setConstraints(outputPaperTypeComboBox, con);

		return panel;
	}
	private JPanel initOutputRightPanel() {

		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints con = new GridBagConstraints();
		JPanel panel = new JPanel(gridbag);

		JLabel outputDirectionLabel = new JLabel("输出方向:");
		JLabel blank1 = new JLabel();
		JLabel blank2 = new JLabel();
		JPanel blankPanel = new JPanel();

		ButtonGroup bg = new ButtonGroup();
		bg.add(verticalRadioButton);
		bg.add(horizontalRadioButton);
		verticalRadioButton.setSelected(true);
		
		panel.add(outputDirectionLabel);
		panel.add(verticalRadioButton);
		panel.add(horizontalRadioButton);
		panel.add(blank1);
		panel.add(printToFileCheckBox);
		panel.add(blank2);
		panel.add(mirrorInversionCheckBox);
		panel.add(negativePictureCheckBox);
		panel.add(blankPanel);

		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 0;
		gridbag.setConstraints(outputDirectionLabel, con);
		con.weightx = 0.5;
		gridbag.setConstraints(verticalRadioButton, con);
		con.gridwidth = GridBagConstraints.REMAINDER;
		gridbag.setConstraints(horizontalRadioButton, con);

		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 0;
		gridbag.setConstraints(blank1, con);
		con.weightx = 1;
		con.gridwidth = GridBagConstraints.REMAINDER;
		gridbag.setConstraints(printToFileCheckBox, con);

		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 0;
		gridbag.setConstraints(blank2, con);
		con.weightx = 0.5;
		gridbag.setConstraints(mirrorInversionCheckBox, con);
		con.gridwidth = GridBagConstraints.REMAINDER;
		gridbag.setConstraints(negativePictureCheckBox, con);

		return panel;
	}
	private JPanel initOutputPanel() {

		JPanel panel = new JPanel(new GridLayout(1, 2, 0, 0));
		panel.setBorder(BorderFactory.createTitledBorder("输出"));

		JPanel outputLeftPanel = initOutputLeftPanel();
		JPanel outputRightPanel = initOutputRightPanel();

		panel.add(outputLeftPanel);
		panel.add(outputRightPanel);

		return panel;
	}
	private JPanel initFinishPanel() {
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints con = new GridBagConstraints();
		JPanel panel = new JPanel(gridbag);
		panel.setBorder(BorderFactory.createTitledBorder("Finish"));

		JLabel gutterPositionLabel = new JLabel("装订位置:");
		JLabel foldingTypeLabel = new JLabel("折叠方式:");
		JLabel bindingTypeLabel = new JLabel("装订类型");
		JLabel punchHoleLabel = new JLabel("打孔:");

		panel.add(gutterPositionLabel);
		panel.add(gutterPositionComboBox);
		panel.add(foldingTypeLabel);
		panel.add(foldingTypeComboBox);
		panel.add(bindingTypeLabel);
		panel.add(bingdingTypeComboBox);
		panel.add(punchHoleLabel);
		panel.add(punchHoleComboBox);

		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 0;
		con.insets = new Insets(3, 3, 3, 3);
		gridbag.setConstraints(gutterPositionLabel, con);
		con.weightx = 1;
		gridbag.setConstraints(gutterPositionComboBox, con);
		con.weightx = 0;
		gridbag.setConstraints(foldingTypeLabel, con);
		con.weightx = 1;
		con.gridwidth = GridBagConstraints.REMAINDER;
		gridbag.setConstraints(foldingTypeComboBox, con);

		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 0;
		gridbag.setConstraints(bindingTypeLabel, con);
		con.weightx = 1;
		gridbag.setConstraints(bingdingTypeComboBox, con);
		con.weightx = 0;
		gridbag.setConstraints(punchHoleLabel, con);
		con.weightx = 1;
		con.gridwidth = GridBagConstraints.REMAINDER;
		gridbag.setConstraints(punchHoleComboBox, con);

		return panel;
	}
	public OutputTab() {

		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints con = new GridBagConstraints();
		this.setLayout(gridbag);

		JPanel baseInfoPanel = initBaseInfoPanel();
		JPanel displacementPanel = initDisplacementPanel();
		JPanel outputPanel = initOutputPanel();
		JPanel finishPanel = initFinishPanel();
		JPanel blankTab = new JPanel();

		this.add(baseInfoPanel);
		this.add(displacementPanel);
		this.add(outputPanel);
		this.add(finishPanel);
		this.add(blankTab);

		con.fill = GridBagConstraints.HORIZONTAL;
		con.weightx = 1;
		gridbag.setConstraints(baseInfoPanel, con);
		con.gridwidth = GridBagConstraints.REMAINDER;
		gridbag.setConstraints(displacementPanel, con);
		gridbag.setConstraints(outputPanel, con);
		gridbag.setConstraints(finishPanel, con);
		con.weighty = 1;
		gridbag.setConstraints(blankTab, con);

	}
}
