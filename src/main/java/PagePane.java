import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class PagePane extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//版面
	private JCheckBox pageCheckBox = new JCheckBox("版面");
	private JRadioButton bookletButton = new JRadioButton("小册子");
	private JRadioButton stepAndRepeatButton = new JRadioButton("步骤和重复");
		
//	JPanel bookletJPanel = booklet();
//	JPanel stepAndRepeatJpJPanel = stepAndRepeatJPanel();
	
	//装订
	private String[] bindingTypeStr = {"骑订","平订"};
	private JComboBox bindingTypeComboBox = new JComboBox(bindingTypeStr);
	private String[] bindingPositionStr = {"左边缘装订","右边缘装订","上边缘装订"};
	private JComboBox bindingPositionComboBox = new JComboBox(bindingPositionStr);
	
	
	//小页
	private JRadioButton alignToSpineButton = new JRadioButton("对齐到书脊");
	private JRadioButton alignToCenterButton = new JRadioButton("居中");
	private JTextField bindingAreaTextField = new JTextField();
	private JTextField bleedingFieldTextField = new JTextField();
	private JCheckBox shrinkToFitCheckBox = new JCheckBox("缩小至适合");
	
	//爬移
	private JTextField inwordCreepingTextField = new JTextField();
	private JTextField outwordCreepingTextField = new JTextField();
	
	//封皮
	private JCheckBox coverCheckBox = new JCheckBox("封皮");
	private String[] inputTrayStrings = {"进纸盒1","进纸盒2","手动进纸盒"};
	private JComboBox inputTrayComboBox = new JComboBox(inputTrayStrings);
	private JCheckBox frontCoverCheckBox = new JCheckBox("封面");
	private JCheckBox cover2CheckBox = new JCheckBox("封二");
	private JCheckBox cover3CheckBox = new JCheckBox("封三");
	private JCheckBox coverBottomCheckBox = new JCheckBox("封底");
	
	//步骤和重复小页
	private JTextField spaceBetweenPageJTextField = new JTextField();
	private JTextField stepAndRepeatBleedingTextField = new JTextField();
	private JCheckBox shrinkToFitStepCheckBox = new JCheckBox("缩小至适合");
	
	private JLabel preDisplayLabel = new JLabel();
	//private JLabel preDisplayStepLabel = new JLabel();
	
	
	
 	public PagePane() {
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints con = new GridBagConstraints();
		//JPanel panel = new JPanel(gridbag);// //
		this.setLayout(gridbag);
		
		JPanel selectJPanel = pageSelect();
		JPanel pageJPanel = PagePaneJpanel();
		JPanel blank = new JPanel();
		
		this.add(selectJPanel);
		this.add(pageJPanel);
		this.add(blank);
		
		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 1;
		con.weighty = 0;
		con.gridwidth = GridBagConstraints.REMAINDER;
		gridbag.setConstraints(selectJPanel, con);
		gridbag.setConstraints(pageJPanel, con);
		con.weighty = 1;
		gridbag.setConstraints(blank, con);
		
		//System.out.println("11111111111111111111111111111111111111111111111111111");
		
		//return panel;
	}
	
 	private JPanel pageSelect() {
 		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints con = new GridBagConstraints();
		JPanel panel = new JPanel(gridbag);// //
		//panel.setLayout(new FlowLayout(FlowLayout.LEFT,20,1));
		

		JPanel blank = new JPanel();
		ButtonGroup bg = new ButtonGroup();
		bg.add(bookletButton);
		bg.add(stepAndRepeatButton);
		bookletButton.setSelected(true);
		
		pageCheckBox.addActionListener(bookletOrStepAndRepeatActionListener);
		pageCheckBox.setSelected(false);
		bookletButton.setEnabled(false);
		stepAndRepeatButton.setEnabled(false);
		stepAndRepeatJpJPanel.setVisible(false);
		
		bookletButton.addActionListener(showBookletActionListener);
		stepAndRepeatButton.addActionListener(showStepAndRepeatActionListener);
		
		panel.add(pageCheckBox);
		panel.add(bookletButton);
		panel.add(stepAndRepeatButton);
		panel.add(blank);
		
		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.insets = new Insets(1, 0, 1, 20);
		gridbag.setConstraints(pageCheckBox, con);
		gridbag.setConstraints(bookletButton, con);
		gridbag.setConstraints(stepAndRepeatButton, con);
		con.weightx =1;
		con.gridwidth = GridBagConstraints.REMAINDER;
		gridbag.setConstraints(blank, con);
		
		return panel;
 	}
 	
 	private JPanel PagePaneJpanel() {
 		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints con = new GridBagConstraints();
		JPanel panel = new JPanel(gridbag);// //
		panel.setLayout(gridbag);
		
		//JPanel bookletJPanel = booklet();
		//JPanel stepAndRepeatJpJPanel = stepAndRepeatJPanel();
		JPanel blank = new JPanel();
		
		panel.add(bookletJPanel);
		panel.add(stepAndRepeatJpJPanel);
		panel.add(blank);
		
		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 1;
		con.weighty = 0;
		con.gridwidth = GridBagConstraints.REMAINDER;
		gridbag.setConstraints(bookletJPanel, con);
		gridbag.setConstraints(stepAndRepeatJpJPanel, con);
		con.weighty = 1;
		gridbag.setConstraints(blank, con);
		
		return panel;
 	}
 	
	private JPanel booklet() {
//		GridBagLayout gridbag = new GridBagLayout();
//		GridBagConstraints con = new GridBagConstraints();
//		JPanel panel = new JPanel(gridbag);
		//panel.setBorder(BorderFactory.createTitledBorder("装订:"));
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,2,5,5)); //默认为1行，n列；2行3列，水平间距10，垂直间距5
		
		JPanel bookletleftJPanel = bookletLeft();
		JPanel bookletRightJPanel = preDisplay();
		
		panel.add(bookletleftJPanel);
		panel.add(bookletRightJPanel);
		
//		con.fill = GridBagConstraints.HORIZONTAL;
//		con.gridwidth = GridBagConstraints.HORIZONTAL;
//		con.weightx = 1;
//		con.weighty = 0;
//		gridbag.setConstraints(bookletleftJPanel, con);
//		con.gridwidth = GridBagConstraints.REMAINDER;
//		gridbag.setConstraints(bookletRightJPanel, con);
		
		return panel;
	}
	
	private JPanel bookletLeft() {
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints con = new GridBagConstraints();
		JPanel panel = new JPanel(gridbag);
		//panel.setBorder(BorderFactory.createTitledBorder("装订:"));
		
		//JLabel bindingTypeJLabel = new JLabel("装订方式：");
		JPanel bindingPanel = binding();
		JPanel smallPagePanel = smallPage();
		JPanel creepingPanel = creeping();
		JPanel coverPanleJPanel = cover();
		//JPanel blank = new JPanel();
		
		panel.add(bindingPanel);
		panel.add(smallPagePanel);
		panel.add(creepingPanel);
		panel.add(coverPanleJPanel);
		//panel.add(blank);
		
		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 1;
		con.weighty = 0;
		con.gridwidth = GridBagConstraints.REMAINDER;
		gridbag.setConstraints(bindingPanel, con);
		gridbag.setConstraints(smallPagePanel, con);
		gridbag.setConstraints(creepingPanel, con);
		gridbag.setConstraints(coverPanleJPanel, con);
		//con.weighty = 1;
		//gridbag.setConstraints(blank, con);
		
		
	
		return panel;
	}
	
	private JPanel binding() {
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints con = new GridBagConstraints();
		JPanel panel = new JPanel(gridbag);
		panel.setBorder(BorderFactory.createTitledBorder("装订:"));
		
		JLabel bindingTypeJLabel = new JLabel("装订方式：");
		
		//bindingPositionComboBox.addActionListener(selectBindingPositionActionListener);
		//System.out.println(bindingTypeJLabel.toString());
		bindingPositionComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                String item = e.getItem().toString();//获取列表成员（字符串类）
                switch (0) {
					case 0://"左边缘装订":
		    				ImageIcon colorIcon1 = new ImageIcon("/home/chen/Pictures/images/leftNail.png");
		    				colorIcon1.setImage(colorIcon1.getImage().getScaledInstance(200, 265, Image.SCALE_DEFAULT));//宽高根据需要设定    
		    				preDisplayLabel.setIcon(colorIcon1);
		    				break;
					case 1://"右边缘装订":
		    				ImageIcon colorIcon2 = new ImageIcon("/home/chen/Pictures/images/RightNail.png");
		    				colorIcon2.setImage(colorIcon2.getImage().getScaledInstance(199, 266, Image.SCALE_DEFAULT));//宽高根据需要设定    
		    				preDisplayLabel.setIcon(colorIcon2);
		    				break;
					case 2://"上边缘装订":
		    				ImageIcon colorIcon3 = new ImageIcon("/home/chen/Pictures/images/TopNail.png");
		    				colorIcon3.setImage(colorIcon3.getImage().getScaledInstance(153, 263, Image.SCALE_DEFAULT));//宽高根据需要设定    
		    				preDisplayLabel.setIcon(colorIcon3);
		    				break;
		
		    			default:
		    				break;
                }
            }
        });
		
		panel.add(bindingTypeJLabel);
		panel.add(bindingTypeComboBox);
		panel.add(bindingPositionComboBox);
		
		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 0;
		con.insets = new Insets(3, 3, 3, 3);
		gridbag.setConstraints(bindingTypeJLabel, con);
		con.weightx = 0.5;
		gridbag.setConstraints(bindingTypeComboBox, con);
		con.gridwidth = GridBagConstraints.REMAINDER;
		gridbag.setConstraints(bindingPositionComboBox, con);
		
		return panel;
	}
	
	private JPanel smallPage() {
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints con = new GridBagConstraints();
		JPanel panel = new JPanel(gridbag);
		panel.setBorder(BorderFactory.createTitledBorder("小页:"));
		
		JLabel smallPageAlignmentLabel = new JLabel("小页对齐：");
		JLabel bindingAreaJLabel = new JLabel("装订区域：");
		JLabel bleedingLabel = new JLabel("出血："); 
		JLabel unit1 = new JLabel("mm");
		JLabel unit2 = new JLabel("mm");
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(alignToSpineButton);
		bg.add(alignToCenterButton);
		alignToSpineButton.setSelected(true);
		
		
		panel.add(smallPageAlignmentLabel);
		panel.add(alignToSpineButton);
		panel.add(alignToCenterButton);
		panel.add(bindingAreaJLabel);
		panel.add(bindingAreaTextField);
		panel.add(unit1);
		panel.add(bleedingLabel);
		panel.add(bleedingFieldTextField);
		panel.add(unit2);
		panel.add(shrinkToFitCheckBox);
		
		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 0;
		gridbag.setConstraints(smallPageAlignmentLabel, con);
		con.weightx = 0.5;
		gridbag.setConstraints(alignToSpineButton, con);
		con.gridwidth = GridBagConstraints.REMAINDER;
		gridbag.setConstraints(alignToCenterButton, con);

		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 0;
		gridbag.setConstraints(bindingAreaJLabel, con);
		con.weightx = 1;
		gridbag.setConstraints(bindingAreaTextField, con);
		con.weightx = 0;
		con.gridwidth = GridBagConstraints.REMAINDER;
		gridbag.setConstraints(unit1, con);
		
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 0;
		gridbag.setConstraints(bleedingLabel, con);
		con.weightx = 1;
		gridbag.setConstraints(bleedingFieldTextField, con);
		con.weightx = 0;
		con.gridwidth = GridBagConstraints.REMAINDER;
		gridbag.setConstraints(unit2, con);
		
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 0;
		gridbag.setConstraints(shrinkToFitCheckBox, con);
		
		return panel;
	}
	
	private JPanel creeping() {
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints con = new GridBagConstraints();
		JPanel panel = new JPanel(gridbag);
		panel.setBorder(BorderFactory.createTitledBorder("爬移:"));
		
		JLabel inwardCreepingLabel = new JLabel("内爬移：");
		JLabel outwardCreepingLabel = new JLabel("外爬移：");
		JLabel unit1 = new JLabel("mm");
		JLabel unit2 = new JLabel("mm");
		//JPanel blank1 = new JPanel();
		//JPanel blank2 = new JPanel();
		
		//inwordCreepingTextField.setMinimumSize();
		
		panel.add(inwardCreepingLabel);
		panel.add(inwordCreepingTextField);
		panel.add(unit1);
		//panel.add(blank1);
		panel.add(outwardCreepingLabel);
		panel.add(outwordCreepingTextField);
		panel.add(unit2);
		//panel.add(blank2);
		
		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 0;
		con.insets = new Insets(3, 3, 3, 3);
		gridbag.setConstraints(inwardCreepingLabel, con);
		con.weightx = 1;
		gridbag.setConstraints(inwordCreepingTextField, con);
		con.weightx = 0;
		con.gridwidth = GridBagConstraints.REMAINDER;
		gridbag.setConstraints(unit1, con);
		//con.weightx = 1;
		//gridbag.setConstraints(blank1, con);

		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 0;
		gridbag.setConstraints(outwardCreepingLabel, con);
		con.weightx = 1;
		gridbag.setConstraints(outwordCreepingTextField, con);
		con.weightx = 0;
		con.gridwidth = GridBagConstraints.REMAINDER;
		gridbag.setConstraints(unit2, con);
		//con.weightx = 1;
		//gridbag.setConstraints(blank2, con);
		
		return panel;
	}
	
	private JPanel cover() {
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints con = new GridBagConstraints();
		JPanel panel = new JPanel(gridbag);
		panel.setBorder(BorderFactory.createTitledBorder("封皮:"));
		
		JLabel inputPaperBoxLabel = new JLabel("进纸盒：");
		JLabel printCoverLabel = new JLabel("打印封面：");
		JLabel printBackCoverLabel = new JLabel("打印封底：");
		
		JPanel blank1 = new JPanel();
		JPanel blank2 = new JPanel();
		JPanel blank3 = new JPanel();
		
		panel.add(coverCheckBox);
		panel.add(inputPaperBoxLabel);
		panel.add(inputTrayComboBox);
		panel.add(blank1);
		panel.add(printCoverLabel);
		panel.add(frontCoverCheckBox);
		panel.add(cover2CheckBox);
		panel.add(blank2);
		panel.add(printBackCoverLabel);
		panel.add(cover3CheckBox);
		panel.add(coverBottomCheckBox);
		panel.add(blank3);
		
		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 0;
		con.insets = new Insets(3, 5, 3, 5);
		gridbag.setConstraints(coverCheckBox, con);
		con.weightx = 0;
		gridbag.setConstraints(inputPaperBoxLabel, con);
		
		gridbag.setConstraints(inputTrayComboBox, con);
		con.weightx = 1;
		con.gridwidth = GridBagConstraints.REMAINDER;
		gridbag.setConstraints(blank1, con);

		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 0;
		gridbag.setConstraints(printCoverLabel, con);
		con.weightx = 0;
		gridbag.setConstraints(frontCoverCheckBox, con);
		
		gridbag.setConstraints(cover2CheckBox, con);
		con.weightx = 1;
		con.gridwidth = GridBagConstraints.REMAINDER;
		gridbag.setConstraints(blank2, con);
		
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 0;
		gridbag.setConstraints(printBackCoverLabel, con);
		con.weightx = 0;
		gridbag.setConstraints(cover3CheckBox, con);
		
		gridbag.setConstraints(coverBottomCheckBox, con);
		con.weightx = 1;
		con.gridwidth = GridBagConstraints.REMAINDER;
		gridbag.setConstraints(blank3, con);
		
		
		return panel;
	}

	private JPanel preDisplay() {
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints con = new GridBagConstraints();
		JPanel panel = new JPanel(gridbag);
		panel.setBorder(BorderFactory.createTitledBorder("预显："));
		
		//JLabel bindingTypeJLabel = new JLabel("装订方式：");
		preDisplayLabel = new JLabel();
		ImageIcon colorIcon = new ImageIcon("/home/chen/Pictures/images/leftNail.png");
		colorIcon.setImage(colorIcon.getImage().getScaledInstance(200, 265, Image.SCALE_DEFAULT));//宽高根据需要设定    
		preDisplayLabel.setIcon(colorIcon);
		JLabel blank1 = new JLabel();
		JLabel blank2 = new JLabel();
		JLabel blank3 = new JLabel();
		JLabel blank4 = new JLabel();
		
		panel.add(blank1);
		panel.add(blank2);
		panel.add(preDisplayLabel);
		panel.add(blank3);
		panel.add(blank4);
		
		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 1;
		con.weighty = 1;
		con.insets = new Insets(0,0, 0, 0);
		con.gridwidth = GridBagConstraints.REMAINDER;
		gridbag.setConstraints(blank1, con);
		
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 1;
		con.weighty = 0;
		gridbag.setConstraints(blank2, con);
		con.weightx = 0;
		con.weighty = 0;
		gridbag.setConstraints(preDisplayLabel, con);
		con.weightx = 1;
		con.weighty = 0;
		con.gridwidth = GridBagConstraints.REMAINDER;
		gridbag.setConstraints(blank3, con);
		con.weightx = 1;
		con.weighty = 1;
		gridbag.setConstraints(blank4, con);
		
		return panel;
	}
	
	private JPanel stepAndRepeatJPanel() {
//		GridBagLayout gridbag = new GridBagLayout();
//		GridBagConstraints con = new GridBagConstraints();
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,2,5,5)); //默认为1行，n列；2行3列，水平间距10，垂直间距5
		
		JPanel smallPageJPanel = smallPageStepJPanel();
		JPanel stepRightJPanel = preDisplayStepJPanel();
		
		panel.add(smallPageJPanel);
		panel.add(stepRightJPanel);
		
//		con.fill = GridBagConstraints.HORIZONTAL;
//		con.gridwidth = GridBagConstraints.HORIZONTAL;
//		con.weightx = 1;
//		con.weighty = 0;
//		gridbag.setConstraints(smallPageJPanel, con);
//		con.gridwidth = GridBagConstraints.REMAINDER;
//		gridbag.setConstraints(stepRightJPanel, con);
		
		return panel;
	}
	
	private JPanel smallPageStepJPanel() {
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints con = new GridBagConstraints();
		JPanel panel = new JPanel(gridbag);
		panel.setBorder(BorderFactory.createTitledBorder("小页:"));
		
		JPanel spacebetweenPageJPanel = spaceBetweenPageJPanel();
		JPanel blankJPanel = new JPanel();
		
		panel.add(spacebetweenPageJPanel);
		panel.add(shrinkToFitStepCheckBox);
		panel.add(blankJPanel);
		
		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 1;
		con.weighty = 0;
		con.insets = new Insets(3, 3, 3, 3);
		con.gridwidth = GridBagConstraints.REMAINDER;
		gridbag.setConstraints(spacebetweenPageJPanel, con);
		gridbag.setConstraints(shrinkToFitStepCheckBox, con);
		con.weightx = 1;
		con.weighty = 1;
		gridbag.setConstraints(blankJPanel, con);
		
		return panel;
	}
	
	private JPanel spaceBetweenPageJPanel() {
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints con = new GridBagConstraints();
		JPanel panel = new JPanel(gridbag);
		//panel.setBorder(BorderFactory.createTitledBorder("装订:"));
		
		JLabel spaceBetweenPageJLabel = new JLabel("页间空：");
		JLabel unitJLabel = new JLabel("mm");
		JLabel bleedingJLabel = new JLabel("出血：");
		JLabel unitJLabel2 = new JLabel("mm");
		
		panel.add(spaceBetweenPageJLabel);
		panel.add(spaceBetweenPageJTextField);
		panel.add(unitJLabel);
		
		panel.add(bleedingJLabel);
		panel.add(stepAndRepeatBleedingTextField);
		panel.add(unitJLabel2);
		
		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 0;
		con.weighty = 0;
		con.insets = new Insets(3, 3, 3, 3);
		gridbag.setConstraints(spaceBetweenPageJLabel, con);
		con.weightx = 1;
		con.weighty = 0;
		gridbag.setConstraints(spaceBetweenPageJTextField, con);
		con.gridwidth = GridBagConstraints.REMAINDER;
		con.weightx = 0;
		con.weighty = 0;
		gridbag.setConstraints(unitJLabel, con);
		
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 0;
		con.weighty = 0;
		gridbag.setConstraints(bleedingJLabel, con);
		con.weightx = 1;
		con.weighty = 0;
		gridbag.setConstraints(stepAndRepeatBleedingTextField, con);
		con.gridwidth = GridBagConstraints.REMAINDER;
		con.weightx = 0;
		con.weighty = 0;
		gridbag.setConstraints(unitJLabel2, con);
		
		return panel;
	}
	
	private JPanel preDisplayStepJPanel() {
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints con = new GridBagConstraints();
		JPanel panel = new JPanel(gridbag);
		panel.setBorder(BorderFactory.createTitledBorder("预显："));
		
		//JLabel bindingTypeJLabel = new JLabel("装订方式：");
		JLabel preDisplayLabel = new JLabel();
		ImageIcon colorIcon = new ImageIcon("/home/chen/Pictures/images/stepAndRepeat.png");
		colorIcon.setImage(colorIcon.getImage().getScaledInstance(222, 174, Image.SCALE_DEFAULT));//宽高根据需要设定    
		preDisplayLabel.setIcon(colorIcon);
		JLabel blank1 = new JLabel();
		JLabel blank2 = new JLabel();
		JLabel blank3 = new JLabel();
		JLabel blank4 = new JLabel();
		
		panel.add(blank1);
		panel.add(blank2);
		panel.add(preDisplayLabel);
		panel.add(blank3);
		panel.add(blank4);
		
		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 1;
		con.weighty = 1;
		con.insets = new Insets(0,0, 0, 0);
		con.gridwidth = GridBagConstraints.REMAINDER;
		gridbag.setConstraints(blank1, con);
		
		con.gridwidth = GridBagConstraints.HORIZONTAL;
		con.weightx = 1;
		con.weighty = 0;
		gridbag.setConstraints(blank2, con);
		con.weightx = 0;
		con.weighty = 0;
		gridbag.setConstraints(preDisplayLabel, con);
		con.weightx = 1;
		con.weighty = 0;
		con.gridwidth = GridBagConstraints.REMAINDER;
		gridbag.setConstraints(blank3, con);
		con.weightx = 1;
		con.weighty = 1;
		gridbag.setConstraints(blank4, con);
		
		
		return panel;
	}
	
	JPanel bookletJPanel = booklet();
	JPanel stepAndRepeatJpJPanel = stepAndRepeatJPanel();
	
	// 事件响应
	ActionListener showBookletActionListener = new ActionListener() {//showBookletActionListener
		public void actionPerformed(ActionEvent e) {
			
			if (bookletButton.isSelected()) {
				bookletJPanel.setVisible(true);
				stepAndRepeatJpJPanel.setVisible(false);
				

			} 
		}
	};
	
	ActionListener showStepAndRepeatActionListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			if (stepAndRepeatButton.isSelected()) {
				bookletJPanel.setVisible(false);
				stepAndRepeatJpJPanel.setVisible(true);
				

			} 
		}
	};
	
	ActionListener bookletOrStepAndRepeatActionListener = new ActionListener() {//bookletOrStepAndRepeatActionListener
		public void actionPerformed(ActionEvent e) {
			
			if (pageCheckBox.isSelected()) {
				bookletButton.setEnabled(true);
				stepAndRepeatButton.setEnabled(true);;
				

			} else {
				bookletButton.setEnabled(false);
				stepAndRepeatButton.setEnabled(false);
			}
		}
	};
	
}
