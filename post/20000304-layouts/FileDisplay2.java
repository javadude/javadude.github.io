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
 *  This version of the solution uses the "blob"
 *    technique of writing the GUI code
 *  All GUI creation is done in a single big blob
 *    of code
 */
public class FileDisplay2 extends Panel {
  private Button       chgDirButton            = new Button("ChgDir");
  private Button       deleteButton            = new Button("Delete");
  private Button       mkDirButton             = new Button("MkDir");
  private Button       refreshButton           = new Button("Refresh");
  private Button       renameButton            = new Button("Rename");
  private Button       viewButton              = new Button("View");
  private Button       dirInfoButton           = new Button("DirInfo");
  private Button       execButton              = new Button("Exec");

  private Choice       dirChoice               = new Choice();
  private Panel        fileButtonsInnerPanel   = new Panel(new GridLayout(0,1));
  private Panel        fileButtonsPanel        = new Panel(new BorderLayout());
  private Panel        fileHeaderPanel         = new Panel(new BorderLayout());
  private List         fileList                = new List();
  private Label        fileSystemLocationLabel = new Label("");
  private TextField    filterField             = new TextField("*.*");

  /** Constructor 
   *  This defines the overall GUI for this component
   *  It's a BorderLayout with a header, a set of buttons & a list
   */
  public FileDisplay2() {
    setLayout(new BorderLayout());
    setBackground(Color.lightGray);

    fileHeaderPanel.add("North", fileSystemLocationLabel);
    dirChoice.setBackground(Color.white);
    fileHeaderPanel.add("South", dirChoice);

    filterField.setBackground(Color.white);
    fileButtonsInnerPanel.add(chgDirButton);
    fileButtonsInnerPanel.add(mkDirButton);
    fileButtonsInnerPanel.add(filterField);
    fileButtonsInnerPanel.add(viewButton);
    fileButtonsInnerPanel.add(execButton);
    fileButtonsInnerPanel.add(renameButton);
    fileButtonsInnerPanel.add(deleteButton);
    fileButtonsInnerPanel.add(refreshButton);
    fileButtonsInnerPanel.add(dirInfoButton);

    fileButtonsPanel.add("North", fileButtonsInnerPanel);

    fileList.setBackground(Color.white);

    add("North",  fileHeaderPanel);
    add("East",   fileButtonsPanel);
    add("Center", fileList);
  }


  //----- public methods that make the file system label a property -----

  public String getFileSystemLocationLabelText() {
    return fileSystemLocationLabel.getText();
  }

  public void setFileSystemLocationLabelText(String arg1) {
    fileSystemLocationLabel.setText(arg1);
  }
}