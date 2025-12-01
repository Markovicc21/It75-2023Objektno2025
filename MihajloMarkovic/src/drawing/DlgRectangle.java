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

public class DlgRectangle extends JDialog {
	
	private final JPanel contentPanel = new JPanel();
    private JTextField txtX;
    private JTextField txtY;
    private JTextField txtHeight;
    private JTextField txtWidth;
    private boolean confirmation = false; 

    
    public static void main(String[] args) {
        try {
            DlgRectangle dialog = new DlgRectangle();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public DlgRectangle() {
    	setModal(true);
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        GridBagLayout gbl_contentPanel = new GridBagLayout();
        gbl_contentPanel.columnWidths = new int[]{207, 207, 0};
        gbl_contentPanel.rowHeights = new int[]{47, 47, 47, 47, 0, 0};
        gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
        gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        contentPanel.setLayout(gbl_contentPanel);
        
        
        JLabel lblX = new JLabel("X Coordinate:");
        GridBagConstraints gbc_lblX = new GridBagConstraints();
        gbc_lblX.fill = GridBagConstraints.BOTH;
        gbc_lblX.insets = new Insets(0, 0, 5, 5);
        gbc_lblX.gridx = 0;
        gbc_lblX.gridy = 0;
        contentPanel.add(lblX, gbc_lblX);
    
        
        txtX = new JTextField();
        GridBagConstraints gbc_txtX = new GridBagConstraints();
        gbc_txtX.fill = GridBagConstraints.BOTH;
        gbc_txtX.insets = new Insets(0, 0, 5, 0);
        gbc_txtX.gridx = 1;
        gbc_txtX.gridy = 0;
        contentPanel.add(txtX, gbc_txtX);
        txtX.setColumns(10);
        
        
    	JLabel lblY = new JLabel("Y Coordinate:");
        GridBagConstraints gbc_lblY = new GridBagConstraints();
        gbc_lblY.fill = GridBagConstraints.BOTH;
        gbc_lblY.insets = new Insets(0, 0, 5, 5);
        gbc_lblY.gridx = 0;
        gbc_lblY.gridy = 1;
        contentPanel.add(lblY, gbc_lblY);
        
        
        txtY = new JTextField();
        GridBagConstraints gbc_txtY = new GridBagConstraints();
        gbc_txtY.fill = GridBagConstraints.BOTH;
        gbc_txtY.insets = new Insets(0, 0, 5, 0);
        gbc_txtY.gridx = 1;
        gbc_txtY.gridy = 1;
        contentPanel.add(txtY, gbc_txtY);
        txtY.setColumns(10);
        
        
        JLabel lblHeight = new JLabel("Height:");
        GridBagConstraints gbc_lblHeight = new GridBagConstraints();
        gbc_lblHeight.fill = GridBagConstraints.BOTH;
        gbc_lblHeight.insets = new Insets(0, 0, 5, 5);
        gbc_lblHeight.gridx = 0;
        gbc_lblHeight.gridy = 2;
        contentPanel.add(lblHeight, gbc_lblHeight);
        
        
        txtHeight = new JTextField();
        GridBagConstraints gbc_txtHeight = new GridBagConstraints();
        gbc_txtHeight.fill = GridBagConstraints.BOTH;
        gbc_txtHeight.insets = new Insets(0, 0, 5, 0);
        gbc_txtHeight.gridx = 1;
        gbc_txtHeight.gridy = 2;
        contentPanel.add(txtHeight, gbc_txtHeight);
        txtHeight.setColumns(10);
        
        
        

    	JLabel lblWidth = new JLabel("Width:");
        GridBagConstraints gbc_lblWidth = new GridBagConstraints();
        gbc_lblWidth.fill = GridBagConstraints.BOTH;
        gbc_lblWidth.insets = new Insets(0, 0, 5, 5);
        gbc_lblWidth.gridx = 0;
        gbc_lblWidth.gridy = 3;
        contentPanel.add(lblWidth, gbc_lblWidth);
        
        
        txtWidth = new JTextField();
    	GridBagConstraints gbc_txtWidth = new GridBagConstraints();
    	gbc_txtWidth.insets = new Insets(0, 0, 5, 0);
    	gbc_txtWidth.fill = GridBagConstraints.BOTH;
    	gbc_txtWidth.gridx = 1;
    	gbc_txtWidth.gridy = 3;
    	contentPanel.add(txtWidth, gbc_txtWidth);
    	txtWidth.setColumns(10);
        
    	
    	JPanel buttonPane = new JPanel();
		buttonPane.setBackground(new Color(240, 250, 200));
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		
			JButton okButton = new JButton("OK");
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					if (txtX.getText().isEmpty() || txtY.getText().isEmpty() || txtHeight.getText().isEmpty()
							|| txtWidth.getText().trim().isEmpty()) {
						confirmation = false;
						JOptionPane.showMessageDialog(null, "Please enter all values!", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else {
						try {
							int width = Integer.parseInt(txtWidth.getText().toString());
							int height = Integer.parseInt(txtHeight.getText().toString());

							if (width <= 0 || height <= 0) {
								JOptionPane.showMessageDialog(null, "Values must be positive numbers.", "ERROR",
										JOptionPane.ERROR_MESSAGE);
							} else {
								
								confirmation = true;
								setVisible(false);
							}
						} catch (NumberFormatException ex) {
							JOptionPane.showMessageDialog(null, "The values must be numbers.", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			});
			okButton.setBackground(Color.GREEN);
			okButton.setActionCommand("OK");
			buttonPane.add(okButton);
			getRootPane().setDefaultButton(okButton);
        
			
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
    
    public JTextField getTxtX() {
		return txtX;
	}

	public void setTxtX(JTextField txtX) {
		this.txtX = txtX;
	}

	public JTextField getTxtY() {
		return txtY;
	}

	public void setTxtY(JTextField txtY) {
		this.txtY = txtY;
	}

	public JTextField getTxtHeight() {
		return txtHeight;
	}

	public void setTxtHeight(JTextField txtHeight) {
		this.txtHeight = txtHeight;
	}

	public JTextField getTxtWidth() {
		return txtWidth;
	}

	public void setTxtWidth(JTextField txtWidth) {
		this.txtWidth = txtWidth;
	}
    
	 public boolean isConfirmation() {
	        return confirmation;
	    }
	    
    
    
  }


