package cn.com.yikangbao.utils.common;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class QRCodeUtil {

    /**
     * 生成图像
     *
     * @throws WriterException
     * @throws IOException
     */
    public static void Encode(String url) throws WriterException, IOException {
        String filePath = "E://";
        String fileName = "zxing.png";
        int width = 1024; // 图像宽度
        int height = 1024; // 图像高度
        String format = "png";// 图像类型
        Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        BitMatrix bitMatrix = new MultiFormatWriter().encode(url,
                BarcodeFormat.QR_CODE, width, height, hints);// 生成矩阵
        Path path = FileSystems.getDefault().getPath(filePath, fileName);
        MatrixToImageWriter.writeToPath(bitMatrix, format, path);// 输出图像
        System.out.println("输出成功.");
    }

    public static InputStream EncodeUrlToInputStream(String url) throws WriterException, IOException {

        int width = 200; // 图像宽度
        int height = 200; // 图像高度
        String format = "png";// 图像类型
        Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        BitMatrix bitMatrix = new MultiFormatWriter().encode(url,
                BarcodeFormat.QR_CODE, width, height, hints);// 生成矩阵
        ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix,format,outputStream);
        return new ByteArrayInputStream(outputStream.toByteArray());
    }

    public static BufferedImage EncodeUrlToBufferedImage(String url, int size) throws WriterException, IOException {
//        String filePath = "D://";
//        String fileName = "zxing.png";
        int width = size; // 图像宽度
        int height = size; // 图像高度
//        String format = "png";// 图像类型
        Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        BitMatrix bitMatrix = new MultiFormatWriter().encode(url,
                BarcodeFormat.QR_CODE, width, height, hints);// 生成矩阵
//        Path path = FileSystems.getDefault().getPath(filePath, fileName);
//        MatrixToImageWriter.writeToPath(bitMatrix, format, path);// 输出图像
        BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
        return bufferedImage;
    }

    public static BufferedImage EncodeUrlToBufferedImage(String url, String content, int size) throws WriterException, IOException {
//        String filePath = "D://";
//        String fileName = "zxing.png";
        int width = size; // 图像宽度
        int height = size; // 图像高度
//        String format = "png";// 图像类型
        Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        BitMatrix bitMatrix = new MultiFormatWriter().encode(url,
                BarcodeFormat.QR_CODE, width, height, hints);// 生成矩阵
//        Path path = FileSystems.getDefault().getPath(filePath, fileName);
//        MatrixToImageWriter.writeToPath(bitMatrix, format, path);// 输出图像
        BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix);

        //data
        int textWrapperSize = 100;//文字背景尺寸
        int textSize = 30;

        Graphics2D g = (Graphics2D)bufferedImage.getGraphics();
        g.setBackground(Color.WHITE);
        int index = size / 2 - textWrapperSize / 2;
        g.clearRect(index, index, textWrapperSize, textWrapperSize);
        Font font = new Font("微软雅黑", Font.PLAIN, textSize);
        g.setPaint(Color.BLACK);
        FontRenderContext context = g.getFontRenderContext();
        g.setFont(font);
        Rectangle2D bounds = font.getStringBounds(content, context);
        double x = (width - bounds.getWidth()) / 2;
        double y = (height - bounds.getHeight()) / 2;
        double ascent = -bounds.getY();
        double baseY = y + ascent;
        g.drawString(content, (int) x, (int) baseY);

        return bufferedImage;
    }

    public static BufferedImage EncodeUrlAndBottomContent(String url, String content, int size) throws WriterException, IOException {
//        String filePath = "D://";
//        String fileName = "zxing.png";
        int width = size; // 图像宽度
        int height = size; // 图像高度
//        String format = "png";// 图像类型
        Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        BitMatrix bitMatrix = new MultiFormatWriter().encode(url,
                BarcodeFormat.QR_CODE, width, height, hints);// 生成矩阵
//        Path path = FileSystems.getDefault().getPath(filePath, fileName);
//        MatrixToImageWriter.writeToPath(bitMatrix, format, path);// 输出图像
        BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix);

        //data
        int textWrapperSize = 100;//文字背景尺寸
        int textSize = 30;

        Graphics2D g = (Graphics2D)bufferedImage.getGraphics();
        g.setBackground(Color.WHITE);
        int index = size / 2 - textWrapperSize / 2;
        g.clearRect(index, index, textWrapperSize, textWrapperSize);
        Font font = new Font("微软雅黑", Font.PLAIN, textSize);
        g.setPaint(Color.BLACK);
        FontRenderContext context = g.getFontRenderContext();
        g.setFont(font);
        Rectangle2D bounds = font.getStringBounds(content, context);
        double x = (width - bounds.getWidth()) / 2;
        double y = (height - bounds.getHeight()) / 2;
        double ascent = -bounds.getY();
        double baseY = y + ascent;
        g.drawString(content, (int) x, (int) baseY);

        return bufferedImage;
    }



    public static void main(String[] args) throws IOException, WriterException {
        Encode("http://www.baidu.com");
    }
}