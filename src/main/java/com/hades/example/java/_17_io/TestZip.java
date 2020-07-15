package com.hades.example.java._17_io;

import com.hades.example.java.lib.Log;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class TestZip {
    public static void main(String[] args) {
        TestZip testZip = new TestZip();
        testZip.test();
    }

    private void test() {
        final String zip_path = "zip_dir/GitTest-master.zip";
        unzip(new File(zip_path));
    }

    private void zip() {
    }


    private void unzip(File file) {
        InputStream is;
        ZipInputStream zis;
        String parentFolder;
        String filename;
        try {
            parentFolder = file.getParentFile().getPath();

            is = new FileInputStream(file.getAbsolutePath());
            zis = new ZipInputStream(new BufferedInputStream(is));
            ZipEntry ze;
            byte[] buffer = new byte[1024];
            int count;

            while ((ze = zis.getNextEntry()) != null) {
                filename = ze.getName();
                if (ze.isDirectory()) {
                    File fmd = new File(parentFolder + "/" + filename);
                    fmd.mkdirs();
                    continue;
                }
                FileOutputStream fout = new FileOutputStream(parentFolder + "/" + filename);
                while ((count = zis.read(buffer)) != -1) {
                    fout.write(buffer, 0, count);
                }
                fout.close();
                zis.closeEntry();
            }
            zis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        File extractedFile = new File(file.getAbsolutePath().replace(".zip", ""));
        if (!file.delete()) Log.d("unpackZip", "Failed to deleted the zip file.");
    }
}