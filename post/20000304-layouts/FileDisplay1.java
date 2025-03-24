import java.awt.Button;
import java.awt.Choice;
import java.awt.Label;
import java.awt.Panel;
import java.awt.List;
import java.awt.TextField;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.GridLayout;

/** This class represents a small pane which will list the files present
 *  on a given platform.  This pane was made into its own class to allow
 *  easy reuse as both the local and remote file displays
 *  
 *  This GUI is built up using "lazy instantiation" via method calls
 *  for each part of the component.
 *  The code was generated using VisualAge for Java with extra 
 *    error processing removed for clarity
 */
public class FileDisplay1 extends Panel {
  private Button       chgDirButton;
  private Button       deleteButton;
  private Choice       dirChoice;
  private Button       dirInfoButton;
  private Button       execButton;
  private Panel        fileButtonsInnerPanel;
  private Panel        fileButtonsPanel;
  private Panel        fileHeaderPanel;
  private List         fileList;
  private Label        fileSystemLocationLabel;
  private TextField    filterField;
  private Button       mkDirButton;
  private Button       refreshButton;
  private Button       renameButton;
  private Button       viewButton;

  /** Constructor 
   *  This defines the overall GUI for this component
   *  It's a BorderLayout with a header, a set of buttons & a list
   */
  public FileDisplay1() {
    setLayout(new BorderLayout());
    setBackground(Color.lightGray);
    add("North",  getfileHeaderPanel());
    add("East",   getfileButtonsPanel());
    add("Center", getfileList());
  }


  /** The header panel -- it contains a label and Choice */
  private Panel getfileHeaderPanel() {
    if (fileHeaderPanel == null) {
      fileHeaderPanel = new Panel(new BorderLayout());
      fileHeaderPanel.add("North", getfileSystemLocationLabel());
      fileHeaderPanel.add("South", getdirChoice());
    }
    return fileHeaderPanel;
  }

  /** The label to show which system this file display refers to */
  private Label getfileSystemLocationLabel() {
    if (fileSystemLocationLabel == null)
      fileSystemLocationLabel = new Label("");
    return fileSystemLocationLabel;
  }

  /** A choice for previous directories */
  private Choice getdirChoice() {
    if (dirChoice == null) {
      dirChoice = new Choice();
      dirChoice.setBackground(Color.white);
    }
    return dirChoice;
  }


  /** This is merely a wrapper to bind the set of buttons to their
   *   preferred height
   */
  private Panel getfileButtonsPanel() {
    if (fileButtonsPanel == null) {
      fileButtonsPanel = new Panel(new BorderLayout());
      fileButtonsPanel.add("North", getfileButtonsInnerPanel());
    }
    return fileButtonsPanel;
  }

  /** The panel containing the buttons for the file list */
  private Panel getfileButtonsInnerPanel() {
    if (fileButtonsInnerPanel == null) {
      fileButtonsInnerPanel = new Panel(new GridLayout(0,1));
      fileButtonsInnerPanel.add(getchgDirButton());
      fileButtonsInnerPanel.add(getmkDirButton());
      fileButtonsInnerPanel.add(getfilterField());
      fileButtonsInnerPanel.add(getviewButton());
      fileButtonsInnerPanel.add(getexecButton());
      fileButtonsInnerPanel.add(getrenameButton());
      fileButtonsInnerPanel.add(getdeleteButton());
      fileButtonsInnerPanel.add(getrefreshButton());
      fileButtonsInnerPanel.add(getdirInfoButton());
    }
    return fileButtonsInnerPanel;
  }


  //----- Buttons ----- 
  private Button getchgDirButton() {
    if (chgDirButton == null)
      chgDirButton = new Button("ChgDir");
    return chgDirButton;
  }

  private Button getmkDirButton() {
    if (mkDirButton == null)
      mkDirButton = new Button("MkDir");
    return mkDirButton;
  }

  private TextField getfilterField() {
    if (filterField == null) {
      filterField = new TextField("*.*");
      filterField.setBackground(Color.white);
    }
    return filterField;
  }

  private Button getviewButton() {
    if (viewButton == null)
      viewButton = new Button("View");
    return viewButton;
  }

  private Button getexecButton() {
    if (execButton == null)
      execButton = new Button("Exec");
    return execButton;
  }

  private Button getrenameButton() {
    if (renameButton == null)
      renameButton = new Button("Rename");
    return renameButton;
  }

  private Button getdeleteButton() {
    if (deleteButton == null)
      deleteButton = new Button("Delete");
    return deleteButton;
  }

  private Button getrefreshButton() {
    if (refreshButton == null)
      refreshButton = new Button("Refresh");
    return refreshButton;
  }

  private Button getdirInfoButton() {
    if (dirInfoButton == null)
      dirInfoButton = new Button("DirInfo");
    return dirInfoButton;
  }


  /** The list of files */
  private List getfileList() {
    if (fileList == null) {
      fileList = new List();
      fileList.setBackground(Color.white);
    }
    return fileList;
  }


  //----- public methods that make the file system label a property -----

  public String getFileSystemLocationLabelText() {
    return getfileSystemLocationLabel().getText();
  }

  public void setFileSystemLocationLabelText(String arg1) {
    getfileSystemLocationLabel().setText(arg1);
  }
}