package ch18.ex4;

import java.io.*;

public class Test {
    //File
    public static void main(String[] args) throws IOException {
        //File 객체 생성
        //throws Exception 필요
        {
            //folder
            File dir = new File("C:/Temp/images"); //dir
            if( ! dir.exists() ){
                dir.mkdir();
            }

            //file
            File file = new File("C:/Temp/myFile.txt");
            System.out.println(file.exists());
            if(!file.exists()){
                file.createNewFile();
            }
        }

        //file write (char 기반)
//        {
//            File file = new File("C:/Temp/myFile.txt");
////            try {
////                FileWriter fw = new FileWriter(file); //close() 필요
////            }catch(IOException e){
////                e.printStackTrace();
////            }
//
//            //try - resource
//            try (FileWriter fw = new FileWriter(file);){ //close() 필요 X
//                fw.write("안녕하세요!");
//            }catch(IOException e){
//                e.printStackTrace();
//            }
//        }

        //file copy (binary기반 image)
        {
            String dir = "C:" + File.separator + "Temp";
            String srcFileName = "test.jpg";
            String tgtFileName = "copy_test.jpg";
            File src = new File(dir, tgtFileName); //폴더, 파일명
            File tgt = new File(dir, tgtFileName); //폴더, 파일명

            try (
                    FileInputStream fis = new FileInputStream(src);
                    FileOutputStream fos = new FileOutputStream(tgt);
            ) {
                int read;

                while ((read = fis.read()) != -1) {
                    fos.write(read);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
