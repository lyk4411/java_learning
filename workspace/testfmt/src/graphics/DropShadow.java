package graphics;

import java.awt.*;

import javax.swing.*;

/**
 * DropShadow -- show overlapped painting.
 */
// BEGIN main
public class DropShadow extends JComponent {
	/** The text to draw */
	protected String theLabel;
	/** The name of the font */
	protected String fontName;
	/** The font */
	protected Font theFont;
	/** The size of the font */
	protected int fontSize = 18;
	/** The offset for the drop shadow */
	protected int theOffset = 3;

	/**
	 * Set up the GUI limit ourselves to the ubiquitous
	 * IllegalArgumentException.
	 */
	public DropShadow() {
		this("DropShadow");
	}

	public DropShadow(String theLabel) {
		this.theLabel = theLabel == null ? "DropShadow" : theLabel;
		// Now handle font stuff.
		fontName = "Sans";
		fontSize = 24;
		if (fontName != null || fontSize != 0) {
			theFont = new Font(fontName, Font.BOLD + Font.ITALIC, fontSize);
			System.out.println("Name " + fontName + ", font " + theFont);
		}
		setBackground(Color.green);
	}

	/** Paint method showing drop shadow effect */
	public void paint(Graphics g) {
		g.setFont(theFont);
		g.setColor(Color.black);
		g.drawString(theLabel, 30, 50);
		g.setColor(Color.white);
		
		g.drawString(theLabel, theOffset + 30, theOffset + 50);
	}
	public static void main(final String[] args) {
		final JFrame jf = new JFrame();
		jf.add(new DropShadow());
		jf.setBounds(200, 200, 200, 200);
		jf.setVisible(true);
	}
}
// END main