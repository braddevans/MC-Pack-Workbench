package net.mightypork.rpw.gui.widgets;

import net.mightypork.rpw.Config;
import net.mightypork.rpw.gui.Gui;
import net.mightypork.rpw.gui.Icons;
import net.mightypork.rpw.gui.helpers.FileChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * File picker field with file chooser dialog
 *
 * @author Ondřej Hruška (MightyPork)
 */
public class FileInput extends HBox {

    private final JButton buttonPickFile;
    private final JTextField importUrl;
    private final boolean mustExist;
    private File file;
    private FileChooser fc;
    private FilePickListener filePickListener;

    /**
     * File picker field with file chooser<br>
     * After instantiating, use "setListener" to listen for set files.
     *
     * @param parent
     *         parent dialog (for opening the filepicker)
     * @param placeholder
     *         field placeholder (shown before file is chosen)
     * @param pathEnum
     *         path slot (for saving to config)s
     * @param title
     *         filechooser dialog title
     * @param filter
     *         file filter (there are constants for it on FileChooser)
     * @param mustExist
     *         true if the file is required to exist
     */
    public FileInput(Component parent, String placeholder, Config.FilePath pathEnum, String title, FileChooser.FileChooserFilter filter, boolean mustExist) {
        this.mustExist = mustExist;

        importUrl = Gui.textField("", placeholder);
        importUrl.setEditable(false);
        Gui.readonly(importUrl, true);
        importUrl.setForeground(new Color(0x222222));
        importUrl.setHorizontalAlignment(SwingConstants.LEFT);
        Gui.setPrefWidth(importUrl, 250);

        buttonPickFile = new JButton(Icons.MENU_OPEN);
        buttonPickFile.setToolTipText("Browse");

        buttonPickFile.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                fc.showOpenDialog();

                if (fc.approved()) {
                    final File f = fc.getSelectedFile();

                    if (f == null) { return; }

                    if (FileInput.this.mustExist && ! f.exists()) {
                        return; // doesn't exist
                    }

                    file = f;

                    importUrl.setText(file.getPath());

                    if (filePickListener != null) {
                        filePickListener.onFileSelected(f);
                    }
                }

            }
        });

        // can be changed by setFileChooser()
        if (filter == FileChooser.FOLDERS) {
            fc = new FileChooser(parent, pathEnum, title, filter, false, true, false);
        }
        else if (filter == FileChooser.FOLDERS_ZIP) {
            fc = new FileChooser(parent, pathEnum, title, filter, true, true, false);
        }
        else {
            fc = new FileChooser(parent, pathEnum, title, filter, true, false, false);
        }

        // build the GUI
        add(buttonPickFile);
        gap();
        add(importUrl);
        glue();

        etchbdr();
    }

    public void setFileChooser(FileChooser fc) {
        this.fc = fc;
    }

    public JButton getButton() {
        return buttonPickFile;
    }

    @Override
    public void setEnabled(boolean state) {
        importUrl.setEnabled(state);
        buttonPickFile.setEnabled(state);
        super.setEnabled(state);
    }

    public void setListener(FilePickListener filePickListener) {
        this.filePickListener = filePickListener;
    }

    public File getFile() {
        return file;
    }

    public boolean hasFile() {
        return file != null && (! mustExist || file.exists());
    }

    public interface FilePickListener {

        void onFileSelected(File file);
    }
}
