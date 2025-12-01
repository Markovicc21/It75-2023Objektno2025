package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class DlgPoint extends JDialog{
	private final JPanel contentPanel = new JPanel ();
	private JTextField txtXcoordinate;
	private JTextField txtYcoordinate;
	private boolean confirmation = false;
	private Color color = null;
	
	public static void main (String [] args) {
		try {
			DlgPoint dialog = new DlgPoint();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public DlgPoint() 
	{
		setModal(true);
		getContentPane().setBackground(new Color(240,250,200));
		setBounds(100,100,450,300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5,5,5,5));
		getContentPane().add(contentPanel,BorderLayout.CENTER);
		GridBagLayout gb1contentPanel = new GridBagLayout();
		gb1contentPanel.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gb1contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gb1contentPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gb1contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gb1contentPanel);
		
		{
			JLabel lblXCoordinate = new JLabel("X Coordinate:");
			GridBagConstraints gbc_lblXCoordinate = new GridBagConstraints();
			gbc_lblXCoordinate.insets = new Insets(0, 0, 5, 5);
			gbc_lblXCoordinate.gridx = 1;
			gbc_lblXCoordinate.gridy = 1;
			contentPanel.add(lblXCoordinate, gbc_lblXCoordinate);
		}
		
		{
			txtXcoordinate = new JTextField();
			GridBagConstraints gbc_txtXcoordinate = new GridBagConstraints();
			gbc_txtXcoordinate.insets = new Insets(0, 0, 5, 0);
			gbc_txtXcoordinate.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtXcoordinate.gridx = 3;
			gbc_txtXcoordinate.gridy = 1;
			contentPanel.add(txtXcoordinate, gbc_txtXcoordinate);
			txtXcoordinate.setColumns(10);
		}
		
		{
			JLabel lblYCoordinate = new JLabel("Y Coordinate:");
			GridBagConstraints gbc_lblYCoordinate = new GridBagConstraints();
			gbc_lblYCoordinate.insets = new Insets(0, 0, 5, 5);
			gbc_lblYCoordinate.gridx = 1;
			gbc_lblYCoordinate.gridy = 5;
			contentPanel.add(lblYCoordinate, gbc_lblYCoordinate);
		}
		
		{
			txtYcoordinate = new JTextField();
			GridBagConstraints gbc_txtYcoordinate = new GridBagConstraints();
			gbc_txtYcoordinate.insets = new Insets(0, 0, 5, 0);
			gbc_txtYcoordinate.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtYcoordinate.gridx = 3;
			gbc_txtYcoordinate.gridy = 5;
			contentPanel.add(txtYcoordinate, gbc_txtYcoordinate);
			txtYcoordinate.setColumns(10);
		}
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(240, 250, 200));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() 
				{
						public void actionPerformed(ActionEvent e) 
						{
							if (txtXcoordinate.getText().isEmpty() || txtYcoordinate.getText().isEmpty()) {
								JOptionPane.showMessageDialog(null, "Please enter values!", "WARNING",
										JOptionPane.WARNING_MESSAGE);
							} else {
								confirmation = true;
								setVisible(false);
							}
						}
					});
				okButton.setBackground(Color.GREEN);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);		
			}
			
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						dispose();
						confirmation = false;
					}
				});
				cancelButton.setBackground(Color.RED);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
	}
	
	public JTextField getTxtXcoordinate() {
		return txtXcoordinate;
	}

	public void setTxtXcoordinate(JTextField txtXcoordinate) {
		this.txtXcoordinate = txtXcoordinate;
	}

	public JTextField getTxtYcoordinate() {
		return txtYcoordinate;
	}

	public void setTxtYcoordinate(JTextField txtYcoordinate) {
		this.txtYcoordinate = txtYcoordinate;
	}

	public boolean isConfirmation() {
		return confirmation;
	}

	public void setConfirmation(boolean confirmation) {
		this.confirmation = confirmation;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}