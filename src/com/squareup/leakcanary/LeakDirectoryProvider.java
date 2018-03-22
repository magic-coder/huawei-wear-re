package com.squareup.leakcanary;

import java.io.File;
import java.io.FilenameFilter;
import java.util.List;

public interface LeakDirectoryProvider {
    void clearLeakDirectory();

    List<File> listFiles(FilenameFilter filenameFilter);

    File newHeapDumpFile();
}
