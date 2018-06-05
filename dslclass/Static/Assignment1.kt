package assignment1

import java.awt.BorderLayout
import java.awt.FlowLayout
import java.awt.GridLayout
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.WindowConstants

class Assignment1 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val frame = JFrame()
                val n = JButton("North")
                val e = JButton("East")
                val w = JButton("West")
                val c = JButton("Center")
                frame.layout = BorderLayout()
                frame.add(n, BorderLayout.NORTH)
                frame.add(e, BorderLayout.EAST)
                frame.add(w, BorderLayout.WEST)
                frame.add(c, BorderLayout.CENTER)

                val panel = JPanel()
                panel.layout = FlowLayout(FlowLayout.RIGHT)
                val panel2 = JPanel()
                panel2.layout = GridLayout(1,0)
                val ok = JButton("Ok")
                val cancel = JButton("Cancel")
                panel2.add(ok)
                panel2.add(cancel)
                panel.add(panel2)
                frame.add(panel, BorderLayout.SOUTH)
                frame.pack()
                frame.defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
                frame.isVisible = true



            // The following should create the same GUI as above
            // Note - this is a recursive data structure!!! You'll need a stack to track where you are...
            // Hint: Swing's JFrame and JPanel have common superclass java.awt.Container, which allows
            //       you to add Components. JButton and Container extend Component
            // Unfortunately, without an explicit end() call to close off nested containers, our little
            //   language would be ambiguous...

            GUIBuilder()                        // creates a JFrame() with a BorderLayout
                .north()                        // next component will be at the NORTH part of the current BorderLayout
                    .button("North")            // JButton with label "NORTH"
                .east()                         // next component will be at the NORTH part of the current BorderLayout
                    .button("East")             // JButton with label "NORTH"
                .west()                         // next component will be at the NORTH part of the current BorderLayout
                    .button("West")             // JButton with label "NORTH"
                .center()                       // next component will be at the NORTH part of the current BorderLayout
                    .button("Center")           // JButton with label "NORTH"
                .south()                        // next component will be at the NORTH part of the current BorderLayout
                    .flow(FlowType.Right)       // JPanel with FlowLayout(FlowLayout.RIGHT)
                        .grid(1,0)              // JPanel with GridLayout(1,0)
                            .button("Ok")       // JButton with label "Ok"
                            .button("Cancel")   // JButton with label "Cancel"
                            .end()              // ends the current layout
                    .end()                      // ends the current layout
                .show()                         // pack the frame, set its defaultCloseOperation and make it visible
                                                // no explicit end() call needed to end the frame's border layout
        }
    }

    enum class FlowType { Left, Right, Center }

    // Define class GUIBuilder to implement the above. Note that it should handle other GUIs as well, but only needs to
    //   handle the following functions. You need to determine the function return types and implementations
    //
    //        grid(rows : Int, cols : Int)
    //        flow(flowType : FlowType)
    //        border()
    //        north()
    //        south()
    //        east()
    //        west()
    //        center()
    //        button(text : String)
    //        show()

}
