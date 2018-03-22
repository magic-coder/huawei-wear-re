package org.apache.log4j.chainsaw;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import org.apache.log4j.Logger;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

class LoadXMLAction extends AbstractAction {
    private static final Logger LOG;
    static Class class$org$apache$log4j$chainsaw$LoadXMLAction;
    private final JFileChooser mChooser = new JFileChooser();
    private final XMLFileHandler mHandler;
    private final JFrame mParent;
    private final XMLReader mParser;

    static {
        Class class$;
        if (class$org$apache$log4j$chainsaw$LoadXMLAction == null) {
            class$ = class$("org.apache.log4j.chainsaw.LoadXMLAction");
            class$org$apache$log4j$chainsaw$LoadXMLAction = class$;
        } else {
            class$ = class$org$apache$log4j$chainsaw$LoadXMLAction;
        }
        LOG = Logger.getLogger(class$);
    }

    static Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    LoadXMLAction(JFrame jFrame, MyTableModel myTableModel) throws SAXException, ParserConfigurationException {
        this.mChooser.setMultiSelectionEnabled(false);
        this.mChooser.setFileSelectionMode(0);
        this.mParent = jFrame;
        this.mHandler = new XMLFileHandler(myTableModel);
        this.mParser = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
        this.mParser.setContentHandler(this.mHandler);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        LOG.info("load file called");
        if (this.mChooser.showOpenDialog(this.mParent) == 0) {
            LOG.info("Need to load a file");
            File selectedFile = this.mChooser.getSelectedFile();
            LOG.info(new StringBuffer().append("loading the contents of ").append(selectedFile.getAbsolutePath()).toString());
            try {
                JOptionPane.showMessageDialog(this.mParent, new StringBuffer().append("Loaded ").append(loadFile(selectedFile.getAbsolutePath())).append(" events.").toString(), "CHAINSAW", 1);
            } catch (Throwable e) {
                LOG.warn("caught an exception loading the file", e);
                JOptionPane.showMessageDialog(this.mParent, new StringBuffer().append("Error parsing file - ").append(e.getMessage()).toString(), "CHAINSAW", 0);
            }
        }
    }

    private int loadFile(String str) throws SAXException, IOException {
        int numEvents;
        synchronized (this.mParser) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("<?xml version=\"1.0\" standalone=\"yes\"?>\n");
            stringBuffer.append("<!DOCTYPE log4j:eventSet ");
            stringBuffer.append("[<!ENTITY data SYSTEM \"file:///");
            stringBuffer.append(str);
            stringBuffer.append("\">]>\n");
            stringBuffer.append("<log4j:eventSet xmlns:log4j=\"Claira\">\n");
            stringBuffer.append("&data;\n");
            stringBuffer.append("</log4j:eventSet>\n");
            this.mParser.parse(new InputSource(new StringReader(stringBuffer.toString())));
            numEvents = this.mHandler.getNumEvents();
        }
        return numEvents;
    }
}
