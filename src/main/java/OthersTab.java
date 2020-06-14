import java.awt.*;
import javax.swing.*;

/**
 * 其他面板
 * @author chen
 *
 */

public class OthersTab extends JPanel{

	private String[] arrangedStr = { "最低", "较低", "普通", "较高","最高" };
	private JComboBox arrangedComboBox = new JComboBox(arrangedStr);
	private JCheckBox profileGenerationCheckBox = new JCheckBox("允许生成概貌图");
	
	private JPanel initjobPanel() {
		
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT,5,5));
		//panel.setBorder(BorderFactory.createTitledBorder("Finish"));
		
		JLabel jobPriorityLabel = new JLabel("作业优先级:");
		
		arrangedComboBox.setSelectedIndex(2);
		profileGenerationCheckBox.setSelected(true);
		
		panel.add(jobPriorityLabel);
		panel.add(arrangedComboBox);
		panel.add(profileGenerationCheckBox);
		
		return panel;
		
	}
	
	
	public OthersTab() {
		
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints con = new GridBagConstraints();
		this.setLayout(gridbag);

		JPanel jobPanel = initjobPanel();
		JPanel blank = new JPanel();
		
		this.add(jobPanel);
		this.add(blank);
		
		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridwidth = GridBagConstraints.REMAINDER;
		con.weightx = 1;
		gridbag.setConstraints(jobPanel, con);
		con.weighty = 1;
		gridbag.setConstraints(blank, con);
		
		
		
	}
	
	
}
