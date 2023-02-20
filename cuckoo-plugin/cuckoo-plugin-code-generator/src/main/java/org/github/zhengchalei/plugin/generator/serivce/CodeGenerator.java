package org.github.zhengchalei.plugin.generator.serivce;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CodeGenerator {
    public static void main(String[] args) {
        String className = args[0];
        String packageName = args[1];
        try {
            // 根据用户输入的类名和包名构建文件
            File file = new File(className + ".java");
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
            // 写入文件
            FileWriter writer = new FileWriter(file);
            writer.write("package " + packageName + ";\n\npublic class " + className + " {\n\n}");
            writer.close();
            System.out.println("Code generated!");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}