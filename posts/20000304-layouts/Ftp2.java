import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.Frame;
import java.awt.Color;
import java.awt.Insets;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowListener;

/** This version of the solution uses the "blob"
 *    technique of writing the GUI code
 *  All GUI creation is done in a single big blob
 *    of code
 */
public class Ftp2 extends Frame {
  private Button        aboutButton       = new Button("About");
  private Button        rightButton       = new Button("-->");
  private Button        cancelButton      = new Button("Cancel");
  private Button        connectButton     = new Button("Connect");
  private Button        exitButton        = new Button("Exit");
  private Button        helpButton        = new Button("Help");
  private Button        leftButton        = new Button("<--");
  private Button        logWndButton      = new Button("LogWnd");
  private Button        optionsButton     = new Button("Options");

  private CheckboxGroup transferModeGroup = new CheckboxGroup();
  private Checkbox      asciiCheckbox     = new Checkbox("ASCII", true,
                                                         transferModeGroup);
  private Checkbox      binaryCheckbox    = new Checkbox("Binary", false,
                                                         transferModeGroup);
  private Checkbox      autoCheckbox      = new Checkbox("Auto");

  private TextArea      messageTextArea   = new TextArea(3,30);

  private FileDisplay2  localFileDisplay  = new FileDisplay2();
  private FileDisplay2  remoteFileDisplay = new FileDisplay2();

  private Panel         commandButtonPanel     = new Panel(new GridLayout());
  private Panel         fileTypePanel          = new Panel(new FlowLayout());
  private Panel         fileDisplayPanel       = new Panel(new GridBagLayout());
  private Panel         mainBottomSectionPanel = new Panel(new BorderLayout());


  /** Constructor 
   *  Overall, the GUI is composed of two parts:
   *    the bottom section (buttons, messages)
   *    the file-display section (two file displays & arrow buttons)
   */
  public Ftp2() {
    setLayout(new BorderLayout());
    setBackground(Color.lightGray);
    setTitle("CloneFTP");

    commandButtonPanel.add(connectButton);
    commandButtonPanel.add(cancelButton);
    commandButtonPanel.add(logWndButton);
    commandButtonPanel.add(helpButton);
    commandButtonPanel.add(optionsButton);
    commandButtonPanel.add(aboutButton);
    commandButtonPanel.add(exitButton);

    fileTypePanel.add(asciiCheckbox);
    fileTypePanel.add(binaryCheckbox);
    fileTypePanel.add(autoCheckbox);

    messageTextArea.setBackground(Color.white);

    localFileDisplay.setFileSystemLocationLabelText("Local System");
    remoteFileDisplay.setFileSystemLocationLabelText("Remote System");

    GridBagConstraints gbc = new GridBagConstraints();

    gbc.gridx      = 0;
    gbc.gridy      = 0;
    gbc.gridwidth  = 1;
    gbc.gridheight = 2;
    gbc.fill       = GridBagConstraints.BOTH;
    gbc.anchor     = GridBagConstraints.CENTER;
    gbc.weightx    = 0.5;
    gbc.weighty    = 1.0;
    fileDisplayPanel.add(localFileDisplay, gbc);

    gbc.gridx      = 2;
    gbc.gridy      = 0;
    gbc.gridwidth  = 1;
    gbc.gridheight = 2;
    gbc.fill       = GridBagConstraints.BOTH;
    gbc.anchor     = GridBagConstraints.CENTER;
    gbc.weightx    = 0.5;
    gbc.weighty    = 1.0;
    fileDisplayPanel.add(remoteFileDisplay, gbc);

    gbc.gridx      = 1;
    gbc.gridy      = 0;
    gbc.gridwidth  = 1;
    gbc.gridheight = 1;
    gbc.fill       = GridBagConstraints.NONE;
    gbc.anchor     = GridBagConstraints.SOUTH;
    gbc.weightx    = 0.0;
    gbc.weighty    = 0.5;
    gbc.insets     = new Insets(0, 4, 2, 4);
    fileDisplayPanel.add(leftButton, gbc);

    gbc.gridx      = 1;
    gbc.gridy      = 1;
    gbc.gridwidth  = 1;
    gbc.gridheight = 1;
    gbc.fill       = GridBagConstraints.NONE;
    gbc.anchor     = GridBagConstraints.NORTH;
    gbc.weightx    = 0.0;
    gbc.weighty    = 0.5;
    gbc.insets     = new Insets(2, 4, 0, 4);
    fileDisplayPanel.add(rightButton, gbc);


    mainBottomSectionPanel.add("South",  commandButtonPanel);
    mainBottomSectionPanel.add("North",  fileTypePanel);
    mainBottomSectionPanel.add("Center", messageTextArea);

    add("South",  mainBottomSectionPanel);
    add("Center", fileDisplayPanel);
    pack();

    // Note: the following two statements add event handlers to
    //       close the application -- event handling is discussed in a later
    //       section
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        setVisible(false);
        dispose();
        System.exit(0);
      }});
    exitButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        dispose();
        System.exit(0);
      }});
  }


  /** A simple main to let us test the GUI */
  public static void main(java.lang.String[] args) {
    (new Ftp2()).setVisible(true);
  }
}