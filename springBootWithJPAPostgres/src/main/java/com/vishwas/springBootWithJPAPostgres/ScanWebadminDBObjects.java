package com.vishwas.springBootWithJPAPostgres;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ScanWebadminDBObjects {

    public static void main(String[] args) {

        try (Stream<Path> walk = Files.walk(Paths.get("E:\\JAR_SOURCES"))) {

            List<String> allXsds = walk.map(x -> x.toString())
                    .filter(f -> (f.endsWith(".java"))).collect(Collectors.toList());
            for (String filePath : allXsds) {
                /*if (filePath.contains("\\dao\\") || filePath.contains("\\api\\")
                        || filePath.contains("\\batch\\") || filePath.contains("\\service\\")
                        || filePath.contains("\\util\\") || filePath.contains("\\action\\")
                        || filePath.contains("\\billing\\")) {*/
                if(true){

                    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF8"));
                    String sCurrentLine;
                    boolean isFileNamePrinted = false;
                    while ((sCurrentLine = br.readLine()) != null) {
                        String str = sCurrentLine.trim();
                        //System.out.println("str" + str);
                        if (str.contains("TSAU_") || str.contains("tsau_")
                                || str.contains("TCMS_") || str.contains("tcms_")
                                || str.contains("_SEQ") || str.contains("_seq") || str.contains("TANA_") || str.contains("tana_") || str.contains("TPFK_")) {
                            if (!isFileNamePrinted) {
                                isFileNamePrinted = true;
                                System.out.println("\n --------------------------------------------------------");
                                System.out.println(filePath + "   \n");
                                System.out.println("--------------------------------------------------------");

                            }
                            System.out.println(str);
                        }

                    }
                }
            }
        } catch (Exception ex) {
            System.out.println("The exception is=="+ex);
        }

    }
}