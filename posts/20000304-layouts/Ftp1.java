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
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

/** This version of the solution uses lazy instantiation to
 *    create the GUI.
 *  This code was generated in VisualAge for Java and
 *    simplified by removing error processing and
 *    combining some methods.
 */
public class Ftp1 extends Frame {
  private Button        aboutButton;
  private Button        rightButton;
  private Button        cancelButton;
  private Button        connectButton;
  private Button        exitButton;
  private Button        helpButton;
  private Button        leftButton;
  private Button        logWndButton;
  private Button        optionsButton;

  private Checkbox      asciiCheckbox;
  private Checkbox      autoCheckbox;
  private Checkbox      binaryCheckbox;
  private CheckboxGroup transferModeGroup;

  private Panel         commandButtonPanel;
  private Panel         fileTypePanel;
  private Panel         fileDisplayPanel;
  private Panel         mainBottomSectionPanel;

  private TextArea      messageTextArea;

  private FileDisplay1  localFileDisplay;
  private FileDisplay1  remoteFileDisplay;

  /** Constructor 
   *  Overall, the GUI is composed of two parts:
   *    the bottom section (buttons, messages)
   *    the file-display section (two file displays & arrow buttons)
   */
  public Ftp1() {
    setLayout(new BorderLayout());
    setBackground(Color.lightGray);
    setTitle("CloneFTP");
    add("South",  getmainBottomSectionPanel());
    add("Center", getfileDisplayPanel());
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
    getexitButton().addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        dispose();
        System.exit(0);
      }});
  }


  /** The main bottom part of the GUI.  This is made up of
   *  three components: a row of command buttons, a message area
   *  and three checkboxes to indicate the file transfer type.
   *  We place these in a BorderLayout (which is the SOUTH part of
   *  the overall BorderLayout) to bind their heights to their
   *  preferred heights
   */
  private Panel getmainBottomSectionPanel() {
    if (mainBottomSectionPanel == null) {
      mainBottomSectionPanel = new Panel(new BorderLayout());
      getmainBottomSectionPanel().add("South",  getcommandButtonPanel());
      getmainBottomSectionPanel().add("North",  getfileTypePanel());
      getmainBottomSectionPanel().add("Center", getmessageTextArea());
    }
    return mainBottomSectionPanel;
  }


  /** This panel represents the command buttons at the bottom of
   *  of the GUI.  The buttons are all the same size, hence a GridLayout
   */
  private Panel getcommandButtonPanel() {
    if (commandButtonPanel == null) {
      commandButtonPanel = new Panel(new GridLayout());
      commandButtonPanel.add(getconnectButton());
      commandButtonPanel.add(getcancelButton());
      commandButtonPanel.add(getlogWndButton());
      commandButtonPanel.add(gethelpButton());
      commandButtonPanel.add(getoptionsButton());
      commandButtonPanel.add(getaboutButton());
      commandButtonPanel.add(getexitButton());
    }
    return commandButtonPanel;
  }

  //----- Buttons -----
  private Button getconnectButton() {
    if (connectButton == null)
      connectButton = new Button("Connect");
    return connectButton;
  }

  private Button getcancelButton() {
    if (cancelButton == null)
      cancelButton = new Button("Cancel");
    return cancelButton;
  }

  private Button getlogWndButton() {
    if (logWndButton == null)
      logWndButton = new Button("LogWnd");
    return logWndButton;
  }

  private Button gethelpButton() {
    if (helpButton == null)
      helpButton = new Button("Help");
    return helpButton;
  }

  private Button getoptionsButton() {
    if (optionsButton == null)
      optionsButton = new Button("Options");
    return optionsButton;
  }

  private Button getaboutButton() {
    if (aboutButton == null)
      aboutButton = new Button("About");
    return aboutButton;
  }

  private Button getexitButton() {
    if (exitButton == null)
      exitButton = new Button("Exit");
    return exitButton;
  }


  /** This panel holds the three file transfer mode chckboxes */
  private Panel getfileTypePanel() {
    if (fileTypePanel == null) {
      fileTypePanel = new Panel(new FlowLayout());
      fileTypePanel.add(getasciiCheckbox());
      fileTypePanel.add(getbinaryCheckbox());
      fileTypePanel.add(getautoCheckbox());
    }
    return fileTypePanel;
  }

  private Checkbox getasciiCheckbox() {
    if (asciiCheckbox == null)
      asciiCheckbox = new Checkbox("ASCII", true, gettransferModeGroup());
    return asciiCheckbox;
  }

  private Checkbox getbinaryCheckbox() {
    if (binaryCheckbox == null)
      binaryCheckbox = new Checkbox("Binary", false, gettransferModeGroup());
    return binaryCheckbox;
  }

  /** a checkbox group that collects the "Binary" and "ASCII" checkboxes */
  private CheckboxGroup gettransferModeGroup() {
    if (transferModeGroup == null)
      transferModeGroup = new CheckboxGroup();
    return transferModeGroup;
  }

  private Checkbox getautoCheckbox() {
    if (autoCheckbox == null)
      autoCheckbox = new Checkbox("Auto");
    return autoCheckbox;
  }


  /** This is the message text area in the bottom part of the GUI.
   *  It is sized to 3 rows, 30 columns, which drives its preferred
   *  size (the preferred height is respected due to its position in
   *  the GUI.
   */
  private TextArea getmessageTextArea() {
    if (messageTextArea == null) {
      messageTextArea = new TextArea(3,30);
      messageTextArea.setBackground(Color.white);
    }
    return messageTextArea;
  }


  /** This is the upper section of the GUI, containing the
   *  local & remote file displays and the direction buttons
   *  It is a big-bad-evil GridBagLayout (tm)
   *  The general idea is that the file displays expand
   *  horizontally to fill the remaining space equally and
   *  the arrow buttons float in the center between the
   *  two file displays.
   */
  private Panel getfileDisplayPanel() {
    if (fileDisplayPanel == null) {
      fileDisplayPanel = new Panel(new GridBagLayout());

      GridBagConstraints gbc = new GridBagConstraints();
 
      gbc.gridx      = 0;
      gbc.gridy      = 0;
      gbc.gridwidth  = 1;
      gbc.gridheight = 2;
      gbc.fill       = GridBagConstraints.BOTH;
      gbc.anchor     = GridBagConstraints.CENTER;
      gbc.weightx    = 0.5;
      gbc.weighty    = 1.0;
      fileDisplayPanel.add(getlocalFileDisplay(), gbc);

      gbc.gridx      = 2;
      gbc.gridy      = 0;
      gbc.gridwidth  = 1;
      gbc.gridheight = 2;
      gbc.fill       = GridBagConstraints.BOTH;
      gbc.anchor     = GridBagConstraints.CENTER;
      gbc.weightx    = 0.5;
      gbc.weighty    = 1.0;
      fileDisplayPanel.add(getremoteFileDisplay(), gbc);

      gbc.gridx      = 1;
      gbc.gridy      = 0;
      gbc.gridwidth  = 1;
      gbc.gridheight = 1;
      gbc.fill       = GridBagConstraints.NONE;
      gbc.anchor     = GridBagConstraints.SOUTH;
      gbc.weightx    = 0.0;
      gbc.weighty    = 0.5;
      gbc.insets     = new Insets(0, 4, 2, 4);
      fileDisplayPanel.add(getleftButton(), gbc);

      gbc.gridx      = 1;
      gbc.gridy      = 1;
      gbc.gridwidth  = 1;
      gbc.gridheight = 1;
      gbc.fill       = GridBagConstraints.NONE;
      gbc.anchor     = GridBagConstraints.NORTH;
      gbc.weightx    = 0.0;
      gbc.weighty    = 0.5;
      gbc.insets     = new Insets(2, 4, 0, 4);
      fileDisplayPanel.add(getrightButton(), gbc);
    }
    return fileDisplayPanel;
  }

  /** An instance of FileDisplay for the local system */
  private FileDisplay1 getlocalFileDisplay() {
    if (localFileDisplay == null) {
      localFileDisplay = new FileDisplay1();
      localFileDisplay.setFileSystemLocationLabelText("Local System");
    }
    return localFileDisplay;
  }

  /** An instance of FileDisplay for the remote system */
  private FileDisplay1 getremoteFileDisplay() {
    if (remoteFileDisplay == null) {
      remoteFileDisplay = new FileDisplay1();
      remoteFileDisplay.setFileSystemLocationLabelText("Remote System");
    }
    return remoteFileDisplay;
  }

  /** A direction button pointing left */
  private Button getleftButton() {
    if (leftButton == null)
      leftButton = new Button("<--");
    return leftButton;
  }

  /** A direction button pointing right */
  private Button getrightButton() {
    if (rightButton == null)
      rightButton = new Button("-->");
    return rightButton;
  }


  /** A simple main to let us test the GUI */
  public static void main(java.lang.String[] args) {
    (new Ftp1()).setVisible(true);
  }
}