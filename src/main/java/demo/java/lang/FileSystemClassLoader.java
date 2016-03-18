package demo.java.lang;

import java.io.*;
import java.lang.reflect.Field;

public class FileSystemClassLoader extends ClassLoader {

    public String fileSystem;

    private String rootDir;

    public FileSystemClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = getClassData(name);
        if (classData == null)
            throw new ClassNotFoundException();
        return defineClass(name, classData, 0, classData.length);
    }

    private byte[] getClassData(String name) {
        String path = classNameToPath(name);

        try {
            InputStream ins = new FileInputStream(new File(path));
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int bufferSize = 4096;
            byte[] buffer = new byte[bufferSize];
            int bufferNum = 0;
            while ((bufferNum = ins.read(buffer)) != -1) {
                bos.write(buffer, 0, bufferNum);
            }
            return bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private String classNameToPath(String className) {
        return rootDir + File.separatorChar + className.replace('.', File.separatorChar) + ".class";
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String rootDir = "F:\\Workspace\\master.netty\\target\\classes";
        String name = "action.rpc.simple.model.RpcRequest";
        FileSystemClassLoader cl = new FileSystemClassLoader(rootDir);
        Class clazz = cl.findClass(name);
        Object obj = clazz.newInstance();
        System.out.println(obj);

        Field[] fields = clazz.getDeclaredFields();
        for(Field field : fields) {
            field.setAccessible(true);
            System.out.println(field.getName());
        }

    }
}
