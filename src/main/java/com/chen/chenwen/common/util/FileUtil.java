package com.chen.chenwen.common.util;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import java.io.*;

/**
 * @Author 范小城
 * @Date 2022-06-25 19:29
 */
public class FileUtil {

    /*InputStream转化File*/
    public static void inputStreamToFile(InputStream ins, File file) {
        BufferedOutputStream bos = null;
        BufferedInputStream bis = new BufferedInputStream(ins);
        try {
            bos = new BufferedOutputStream(new FileOutputStream(file));
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = bis.read(buffer, 0, 8192)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ins != null) {
                try {
                    ins.close();
                } catch (IOException e) {
                }
                ins = null;
            }
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                }
                bos = null;
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                }
                bis = null;
            }
        }
    }

    /*File文件转化byte[]*/
    public static byte[] file2byte(String filePath) {
        byte[] buffer = null;
        try {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }

    /*byte[]转化File*/
    public static void byte2File(byte[] buf, String filePath, String fileName) {
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        File file = null;
        try {
            File dir = new File(filePath);
            if (!dir.exists() && dir.isDirectory()) {
                dir.mkdirs();
            }
            file = new File(filePath + File.separator + fileName);
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(buf);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*图片合入pdf文件（签字接口）*/
    public static void addImageAbsPosition(String dir, String suffix, String imagePath) {
        PdfReader reader = null;
        PdfStamper stamp = null;
        try {
            reader = new PdfReader(dir +"."+suffix);
            int totalPages = reader.getNumberOfPages();
            stamp = new PdfStamper(reader,
                    new FileOutputStream(dir + "_已签字." + suffix));
            BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA,
                    BaseFont.WINANSI, BaseFont.EMBEDDED);
            int currentPage = 1;
            PdfContentByte under;
            while (currentPage <= totalPages) {
                under = stamp.getUnderContent(currentPage);
                under.beginText();
                under.setFontAndSize(bf, 18);
                under.endText();
                currentPage++;
            }
            PdfContentByte over;
            // 加载图片
            Image image = Image.getInstance(imagePath);
            Document document = new Document(reader.getPageSize(totalPages));
            float width = document.getPageSize().getWidth();
            float height = document.getPageSize().getHeight();
            image.setAbsolutePosition(width - 200, 100);
            image.scalePercent(10);
            image.setAlignment(Image.ALIGN_JUSTIFIED_ALL);
            over = stamp.getOverContent(totalPages);
            over.addImage(image);
            stamp.close();
            reader.close();
        } catch (IOException | DocumentException exception) {
            exception.printStackTrace();
            try {
                if (stamp != null) {
                    stamp.close();
                }
                if (reader != null) {
                    reader.close();
                }
            } catch (DocumentException documentException) {
                documentException.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }


}
