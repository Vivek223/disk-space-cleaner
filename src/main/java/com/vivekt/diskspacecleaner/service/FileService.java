package com.vivekt.diskspacecleaner.service;

import ch.qos.logback.core.util.FileUtil;
import com.vivekt.diskspacecleaner.util.Converter;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.*;

@Component
public class FileService {

    public List<String> listFilesInDirectory(String dir){

        Iterator<File> fileIterator = FileUtils.iterateFiles(new File(dir), null, true);
        List<String> fileList = new ArrayList<>();
        Map<Long, String> treeMap = new TreeMap();
       while(fileIterator.hasNext()){
            File f = fileIterator.next();

            treeMap.put(FileUtils.sizeOf(f), f.getName());
           // fileList.add(f.getName() + " " + f.getAbsoluteFile());
        }

       int i = 0;
       List<Long> sortedKeys = new ArrayList<Long>(treeMap.keySet());
       Collections.sort(sortedKeys, Collections.reverseOrder());
       Iterator<Long> it = sortedKeys.iterator();
       while(it.hasNext() && i < 10){
           Long key = it.next();
           fileList.add(treeMap.get(key) + " >> " + Converter.getSize(key));
           i++;
       }

       return  fileList;

    }
}
