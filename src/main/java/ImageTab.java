import java.awt.*;
import javax.swing.*;

/**
 * 图像面板
 * @author chen
 *
 */

public class ImageTab extends JPanel{

	//function:initPageNumScalePanel
	private JRadioButton allPagesRadioButton = new JRadioButton("所有页");
	private JRadioButton pageNumRadioButton = new JRadioButton("页码");
	private final SpinnerModel model1 = new SpinnerNumberModel(1, 0, 9999, 1);
	private JSpinner startPageNumSpinner = new JSpinner(model1);
	private final SpinnerModel model2 = new SpinnerNumberModel(1, 0, 9999, 1);
	private JSpinner endPageNumSpinner = new JSpinner(model2);
	private JRadioButton customRadioButton = new JRadioButton("自定义");
	private JTextField customTextField = new JTextField();
	//function:initZoomRotatePanel
	private final SpinnerModel model3 = new SpinnerNumberModel(100.0, 0, 9999, 0.1);
	private JSpinner xSpinner = new JSpinner(model3);
	private final SpinnerModel model4 = new SpinnerNumberModel(100.0, 0, 9999, 0.1);
	private JSpinner ySpinner = new JSpinner(model4);
	private JCheckBox resizeToMediaCheckBox = new JCheckBox("调整至介质大小");
	private String [] rotateStr = {"不旋转","旋转90度","旋转180度","旋转270度","自动旋转"};
	private JComboBox rotateComboBox = new JComboBox(rotateStr);
	//function:initNetworkHangingParaSettingsPanel
	private String [] imageDotShapeStr = {"Dot1","Dot2","随机网点"};
	private JComboBox imageDotShapeComboBox = new JComboBox(imageDotShapeStr);
	private String [] graphicDotShapeStr = {"图像网点类型","Dot1","Dot2"};
	private JComboBox graphicDotShapeComboBox = new JComboBox(graphicDotShapeStr);
	private String [] colorTypeStr = {"彩色","灰度"};
	private JComboBox colorTypeComboBox = new JComboBox(colorTypeStr);
	private String [] resolvingPowerStr = {"600*600","1200*1200"};
	private JComboBox resolvingPowerComboBox = new JComboBox(resolvingPowerStr);
	//function:initImageSettingsPanel
	private String [] imageQualityStr = {"正常","最佳"};
	private JComboBox imageQualityComboBox = new JComboBox(imageQualityStr);
	private String [] gradualChangeQualityStr = {"较好","普通","精细"};
	private JComboBox gradualChangeQualityComboBox = new JComboBox(gradualChangeQualityStr);
	private JCheckBox fontSubstitutionCheckBox = new JCheckBox("字体替换");
	private JCheckBox ignoreMissingGraphCheckBox = new JCheckBox("忽略缺图");
	private JCheckBox highQualityPatternCheckBox = new JCheckBox("高品质图案");
	private JTextField fileSearchPathTextField = new JTextField();
	private JButton searchButton = new JButton("浏览");
	//function:initOverPrintParaSettingsPanel
	private JCheckBox overlayVoerprintParaCheckBox = new JCheckBox("覆盖作业中的叠印参数");
	private String [] overprintTypeStr = {"不镂空","黑板不镂空","镂空"};
	private JComboBox overprintTypeComboBox = new JComboBox(overprintTypeStr);
	private JCheckBox overlayVoerprintTypeCheckBox = new JCheckBox("覆盖作业中的叠印模式");
	private JCheckBox nonZeroOverPrintCheckBox = new JCheckBox("非零叠印");
	//function:initLineweightAdjustmentSettingsPanel
	private JCheckBox overrideLineWeightAdjustmentCheckBox = new JCheckBox("覆盖作业中的线宽调整");
	private JCheckBox lineWeightAdjustmentCheckBox = new JCheckBox("线宽调整");
	private JCheckBox fineLineAdjusetmentCheckBox = new JCheckBox("细线调整");
	private final SpinnerModel model5 = new SpinnerNumberModel(0, 0, 9999, 1);
	private JSpinner minimumEquipmentLineWidthSpinner = new JSpinner(model5);
	private JCheckBox coarseWordFillingCheckBox = new JCheckBox("粗字填充");
	private final SpinnerModel model6 = new SpinnerNumberModel(0, 0, 9999, 1);
	private JSpinner fontLineWidthAdjustmentSpinner = new JSpinner(model6);
	//function:initOthersPanel
	private String [] spotColorStr = {"自定义"};
	private JComboBox spotColorComboBox = new JComboBox(spotColorStr);
	private String [] linearizationCurveStr = {"默认"};
	private JComboBox linearizationCurveComboBox = new JComboBox(linearizationCurveStr);
	private String [] trimmingCurveStr = {"默认"};
	private JComboBox trimmingCurveComboBox = new JComboBox(trimmingCurveStr);
	private JButton editButton = new JButton("编辑");
	private JButton checkCurveButton = new JButton("查看曲线");
	private JButton checkCurveButton2 = new JButton("查看曲线");

	private JPanel initPageNumScalePanel() {
		
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints con = new GridBagConstraints();
		JPanel panel = new JPanel(gridbag);
		panel.setBorder(BorderFactory.createTitledBorder("页码范围"));
		
		JLabel fromLabel = new JLabel("从");
		JLabel endLabel = new JLabel("到");
		
		allPagesRadioButton.setSelected(true);
		
		panel.add(allPagesRadioButton);
		panel.add(pageNumRadioButton);
		panel.add(fromLabel);
		panel.add(startPageNumSpinner);
		panel.add(endLabel);
		panel.add(endPageNumSpinner);
		panel.add(customRadioButton);
		panel.add(customTextField);
		
		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridwidth = GridBagConstraints.REMAINDER;
		con.weightx = 0;
		con.insets = new Insets(3,3,3,3);
		gridbag.setConstraints(allPagesRadioButton, con);
		
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		gridbag.setConstraints(pageNumRadioButton, con);
		con.weightx = 0;
		gridbag.setConstraints(fromLabel, con);
		con.weightx = 1;
		gridbag.setConstraints(startPageNumSpinner, con);
		con.weightx = 0;
		gridbag.setConstraints(endLabel, con);
		con.weightx = 1;
		con.gridwidth = GridBagConstraints.REMAINDER;
		gridbag.setConstraints(endPageNumSpinner, con);
		
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 0;
		gridbag.setConstraints(customRadioButton, con);
		con.gridwidth = GridBagConstraints.REMAINDER;
		con.weightx = 1;
		gridbag.setConstraints(customTextField, con);
		
		return panel;
	}
	private JPanel initZoomRotatePanel() {
		
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints con = new GridBagConstraints();
		JPanel panel = new JPanel(gridbag);
		panel.setBorder(BorderFactory.createTitledBorder("缩放与旋转"));
		
		JLabel xLabel = new JLabel("X:");
		JLabel yLabel = new JLabel("Y:");
		JLabel rotateLabel = new JLabel("旋转:");
		
		panel.add(xLabel);
		panel.add(xSpinner);
		panel.add(yLabel);
		panel.add(ySpinner);
		panel.add(resizeToMediaCheckBox);
		panel.add(rotateLabel);
		panel.add(rotateComboBox);
		
		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 0;
		con.insets = new Insets(3,3,3,3);
		gridbag.setConstraints(xLabel, con);
		con.weightx = 1;
		gridbag.setConstraints(xSpinner, con);
		con.weightx = 0;
		gridbag.setConstraints(yLabel, con);
		con.gridwidth = GridBagConstraints.REMAINDER;
		con.weightx = 1;
		gridbag.setConstraints(ySpinner, con);
		
		con.weightx = 0;
		gridbag.setConstraints(resizeToMediaCheckBox, con);
		
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 0;
		gridbag.setConstraints(rotateLabel, con);
		con.weightx = 1;
		gridbag.setConstraints(rotateComboBox, con);
		
		return panel;
	}
	private JPanel initNetworkHangingParaSettingsPanel() {
	
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints con = new GridBagConstraints();
		JPanel panel = new JPanel(gridbag);
		panel.setBorder(BorderFactory.createTitledBorder("挂网参数设置"));
		
		JLabel imageDotShapeLabel = new JLabel("图像网点形状:");
		JLabel graphicDotShapeLabel = new JLabel("图形网点形状:");
		JLabel colorTypeLabel = new JLabel("颜色模式:");
		JLabel resolvingPowerLabel = new JLabel("分辨率:");
		
		panel.add(imageDotShapeLabel);
		panel.add(imageDotShapeComboBox);
		panel.add(graphicDotShapeLabel);
		panel.add(graphicDotShapeComboBox);
		panel.add(colorTypeLabel);
		panel.add(colorTypeComboBox);
		panel.add(resolvingPowerLabel);
		panel.add(resolvingPowerComboBox);
		
		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.insets = new Insets(3,3,3,3);
		con.weightx = 0;
		gridbag.setConstraints(imageDotShapeLabel, con);
		con.weightx = 1;
		con.gridwidth = GridBagConstraints.REMAINDER;
		gridbag.setConstraints(imageDotShapeComboBox, con);
		
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 0;
		gridbag.setConstraints(graphicDotShapeLabel, con);
		con.weightx = 1;
		con.gridwidth = GridBagConstraints.REMAINDER;
		gridbag.setConstraints(graphicDotShapeComboBox, con);
		
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 0;
		gridbag.setConstraints(colorTypeLabel, con);
		con.weightx = 1;
		con.gridwidth = GridBagConstraints.REMAINDER;
		gridbag.setConstraints(colorTypeComboBox, con);
		
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 0;
		gridbag.setConstraints(resolvingPowerLabel, con);
		con.weightx = 1;
		con.gridwidth = GridBagConstraints.REMAINDER;
		gridbag.setConstraints(resolvingPowerComboBox, con);

		return panel;
}
	private JPanel initSearchPanel() {
		
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints con = new GridBagConstraints();
		JPanel panel = new JPanel(gridbag);

		
		panel.add(fileSearchPathTextField);
		panel.add(searchButton);
		
		con.fill = GridBagConstraints.HORIZONTAL;
		con.ipady =7;
		con.weightx = 1;
		gridbag.setConstraints(fileSearchPathTextField, con);
		con.ipadx =40;
		con.ipady =0;
		con.weightx = 0;
		gridbag.setConstraints(searchButton, con);
		
		return panel;
	}
	private JPanel initImageSettingsPanel() {
	
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints con = new GridBagConstraints();
		JPanel panel = new JPanel(gridbag);
		panel.setBorder(BorderFactory.createTitledBorder("图像设置"));
		
		JLabel imageQualityLabel = new JLabel("图像质量:");
		JLabel gradualChangeQualityLabel = new JLabel("图像质量:");
		JLabel imageSearchPathLabel = new JLabel("文件搜索路径:");
		JPanel searchPanel = initSearchPanel();
		JPanel blank = new JPanel();
		searchButton.setPreferredSize(new Dimension(20,searchButton.getPreferredSize().height));
		
		panel.add(imageQualityLabel);
		panel.add(imageQualityComboBox);
		panel.add(gradualChangeQualityLabel);
		panel.add(gradualChangeQualityComboBox);
		panel.add(fontSubstitutionCheckBox);
		panel.add(ignoreMissingGraphCheckBox);
		panel.add(highQualityPatternCheckBox);
		panel.add(imageSearchPathLabel);
		panel.add(searchPanel);
		panel.add(blank);
		
		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.insets = new Insets(3,3,3,3);
		con.weightx = 0;
		gridbag.setConstraints(imageQualityLabel, con);
		con.gridwidth = GridBagConstraints.REMAINDER;
		con.weightx = 1;
		gridbag.setConstraints(imageQualityComboBox, con);
		
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 0;
		gridbag.setConstraints(gradualChangeQualityLabel, con);
		con.gridwidth = GridBagConstraints.REMAINDER;
		con.weightx = 1;
		gridbag.setConstraints(gradualChangeQualityComboBox, con);
		
		con.weightx = 0;
		gridbag.setConstraints(fontSubstitutionCheckBox, con);
		
		con.weightx = 0;
		gridbag.setConstraints(ignoreMissingGraphCheckBox, con);
		
		con.weightx = 0;
		gridbag.setConstraints(highQualityPatternCheckBox, con);
		
		con.weightx = 0;
		gridbag.setConstraints(imageSearchPathLabel, con);
		
		con.weightx = 1;
		gridbag.setConstraints(searchPanel, con);
		
		con.weighty = 1;
		gridbag.setConstraints(blank, con);
		
		return panel;
}
	private JPanel initOverPrintParaSettingsPanel() {
	
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints con = new GridBagConstraints();
		JPanel panel = new JPanel(gridbag);
		panel.setBorder(BorderFactory.createTitledBorder("叠印参数设置"));
		
		JLabel overprintTypeLabel = new JLabel("叠印类型");
		
		panel.add(overlayVoerprintParaCheckBox);
		panel.add(overprintTypeLabel);
		panel.add(overprintTypeComboBox);
		panel.add(overlayVoerprintTypeCheckBox);
		panel.add(nonZeroOverPrintCheckBox);
		
		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridwidth = GridBagConstraints.REMAINDER;
		con.weightx = 0;
		gridbag.setConstraints(overlayVoerprintParaCheckBox, con);
		
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		gridbag.setConstraints(overprintTypeLabel, con);
		con.gridwidth = GridBagConstraints.REMAINDER;
		con.weightx = 1;
		gridbag.setConstraints(overprintTypeComboBox, con);
		
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		gridbag.setConstraints(overlayVoerprintTypeCheckBox, con);
		con.gridwidth = GridBagConstraints.REMAINDER;
		gridbag.setConstraints(nonZeroOverPrintCheckBox, con);
		
		
		
		return panel;
}
	private JPanel initminimumEquipmentLineWidthPanel() {
		
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints con = new GridBagConstraints();
		JPanel panel = new JPanel(gridbag);
		
		JLabel minimumEquipmentLineWidthLabel = new JLabel("最小设备线宽:");
		
		panel.add(minimumEquipmentLineWidthLabel);
		panel.add(minimumEquipmentLineWidthSpinner);
		
		con.fill = GridBagConstraints.HORIZONTAL;
		con.insets = new Insets(0,3,0,3);
		con.weightx = 0;
		gridbag.setConstraints(minimumEquipmentLineWidthLabel, con);
		con.weightx = 1;
		gridbag.setConstraints(minimumEquipmentLineWidthSpinner, con);
		
		return panel;
	}
	private JPanel initfontLineWidthAdjustmentPanel() {
		
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints con = new GridBagConstraints();
		JPanel panel = new JPanel(gridbag);
		
		JLabel fontLineWidthAdjustmentLabel = new JLabel("字体线宽调整:");
		
		panel.add(fontLineWidthAdjustmentLabel);
		panel.add(fontLineWidthAdjustmentSpinner);
		
		con.fill = GridBagConstraints.HORIZONTAL;
		con.insets = new Insets(0,3,0,3);
		con.weightx = 0;
		gridbag.setConstraints(fontLineWidthAdjustmentLabel, con);
		con.weightx = 1;
		gridbag.setConstraints(fontLineWidthAdjustmentSpinner, con);
		
		return panel;
	}
	private JPanel initLineweightAdjustmentSettingsPanel() {
	
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints con = new GridBagConstraints();
		JPanel panel = new JPanel(gridbag);
		panel.setBorder(BorderFactory.createTitledBorder("线宽调整设置"));
		
		JPanel minimumEquipmentLineWidthPanel = initminimumEquipmentLineWidthPanel();
		JPanel fontLineWidthAdjustmentPanel = initfontLineWidthAdjustmentPanel();
		
		panel.add(overrideLineWeightAdjustmentCheckBox);
		panel.add(lineWeightAdjustmentCheckBox);
		panel.add(fineLineAdjusetmentCheckBox);
		panel.add(minimumEquipmentLineWidthPanel);
		panel.add(coarseWordFillingCheckBox);
		panel.add(fontLineWidthAdjustmentPanel);
		
		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridwidth = GridBagConstraints.REMAINDER;
		con.insets = new Insets(0,3,0,3);
		gridbag.setConstraints(overrideLineWeightAdjustmentCheckBox, con);
		gridbag.setConstraints(lineWeightAdjustmentCheckBox, con);
		gridbag.setConstraints(fineLineAdjusetmentCheckBox, con);
		con.weightx = 1;
		gridbag.setConstraints(minimumEquipmentLineWidthPanel, con);
		con.weightx = 0;
		gridbag.setConstraints(coarseWordFillingCheckBox, con);
		con.weightx = 1;
		gridbag.setConstraints(fontLineWidthAdjustmentPanel, con);
		
		
		
		
		return panel;
}
	private JPanel initOthersPanel() {
	
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints con = new GridBagConstraints();
		JPanel panel = new JPanel(gridbag);
		panel.setBorder(BorderFactory.createTitledBorder("其它"));
		
		JLabel spotColorLabel = new JLabel("专色:");
		JLabel linearizationCurveLabel = new JLabel("线性化曲线:");
		JLabel trimmingCurveLabel = new JLabel("微调曲线:");
		JPanel blank = new JPanel();
		//blank.setBorder(BorderFactory.createTitledBorder(""));
		
		panel.add(spotColorLabel);
		panel.add(spotColorComboBox);
		panel.add(editButton);
		panel.add(linearizationCurveLabel);
		panel.add(linearizationCurveComboBox);
		panel.add(checkCurveButton);
		panel.add(trimmingCurveLabel);
		panel.add(trimmingCurveComboBox);
		panel.add(checkCurveButton2);
		panel.add(blank);
		
		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.insets = new Insets(3,3,3,3);
		con.weightx = 0; 
		gridbag.setConstraints(spotColorLabel, con);
		con.weightx = 1;
		gridbag.setConstraints(spotColorComboBox, con);
		con.gridwidth = GridBagConstraints.REMAINDER;
		con.weightx = 0;
		gridbag.setConstraints(editButton, con);
		
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 0;
		gridbag.setConstraints(linearizationCurveLabel, con);
		con.weightx = 1;
		gridbag.setConstraints(linearizationCurveComboBox, con);
		con.gridwidth = GridBagConstraints.REMAINDER;
		con.weightx = 0;
		gridbag.setConstraints(checkCurveButton, con);
		
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 0;
		gridbag.setConstraints(trimmingCurveLabel, con);
		con.weightx = 1;
		gridbag.setConstraints(trimmingCurveComboBox, con);
		con.gridwidth = GridBagConstraints.REMAINDER;
		con.weightx = 0;
		gridbag.setConstraints(checkCurveButton2, con);
		
		con.weightx = 1;
		con.weighty = 1;
		con.ipady = 27;
		gridbag.setConstraints(blank, con);
		
		return panel;
}
	private JPanel initNethangingOverPrintPanel() {
		
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints con = new GridBagConstraints();
		JPanel panel = new JPanel(gridbag);
		
		JPanel networkHangingParaSettings = initNetworkHangingParaSettingsPanel();
		JPanel overPrintParaSettings = initOverPrintParaSettingsPanel();
		
		panel.add(networkHangingParaSettings);
		panel.add(overPrintParaSettings);
		
		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridwidth = GridBagConstraints.REMAINDER;
		con.weightx = 1;
		gridbag.setConstraints(networkHangingParaSettings, con);
		con.gridwidth = GridBagConstraints.REMAINDER;
		gridbag.setConstraints(overPrintParaSettings, con);
		
		return panel;
	}
	public ImageTab() {
		
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints con = new GridBagConstraints();
		this.setLayout(gridbag);
		
		JPanel pageNumScale = initPageNumScalePanel();
		JPanel zoomRotatePanel = initZoomRotatePanel();
		//JPanel networkHangingParaSettings = initNetworkHangingParaSettingsPanel();
		JPanel imageSettings = initImageSettingsPanel();
		//JPanel overPrintParaSettings = initOverPrintParaSettingsPanel();
		JPanel nethangingOverPrintPanel = initNethangingOverPrintPanel();
		JPanel lineweightAdjustmentSettings = initLineweightAdjustmentSettingsPanel();
		JPanel others = initOthersPanel();
		JPanel blank = new JPanel();
		
		this.add(pageNumScale);
		this.add(zoomRotatePanel);
		this.add(nethangingOverPrintPanel);
		this.add(imageSettings);
		this.add(lineweightAdjustmentSettings);
		this.add(others);
		this.add(blank);
		
		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.insets = new Insets(3,3,3,3);
		con.weightx = 1;
		gridbag.setConstraints(pageNumScale, con);
		con.gridwidth = GridBagConstraints.REMAINDER;
		gridbag.setConstraints(zoomRotatePanel, con);
		
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		gridbag.setConstraints(nethangingOverPrintPanel, con);
		con.gridwidth = GridBagConstraints.REMAINDER;
		gridbag.setConstraints(imageSettings, con);
		
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		gridbag.setConstraints(lineweightAdjustmentSettings, con);
		con.gridwidth = GridBagConstraints.REMAINDER;
		gridbag.setConstraints(others, con);
		con.weighty = 1;
		gridbag.setConstraints(blank, con);
		
		
		
	}
}
