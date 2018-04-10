package thumbnailator;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

public class Thumb {

	public static void main(String[] args) {
		Thumb thumb =new Thumb();
		try {
			thumb.test1();
			thumb.test2();
			thumb.test3();
			thumb.test4();
			thumb.test5();
			thumb.test6();
			thumb.test7();
			thumb.test8();
			thumb.test9();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	//指定大小进行缩放
		private void test1() throws Exception {
			//size(宽度, 高度)
			
	        /*  
	         * 若图片横比200小，高比300小，不变  
	         * 若图片横比200小，高比300大，高缩小到300，图片比例不变  
	         * 若图片横比200大，高比300小，横缩小到200，图片比例不变  
	         * 若图片横比200大，高比300大，图片按比例缩小，横为200或高为300  
	         */ 
			Thumbnails.of("image/girls.jpg") 
			        .size(200, 300)
			        .toFile("images/girls_200x300.jpg");
			
			Thumbnails.of("image/girls.jpg") 
			        .size(2560, 2048) 
			        .toFile("images/girls_2560x2048.jpg");
		}
		
		//按照比例进行缩放
		private void test2() throws Exception {
			//scale(比例)
			Thumbnails.of("image/girls.jpg") 
			        .scale(0.25f)
			        .toFile("images/girls_25%.jpg");
			
			Thumbnails.of("image/girls.jpg") 
			        .scale(1.10f)
			        .toFile("images/girls_110%.jpg");
		}
		
		//不按照比例，指定大小进行缩放
		private void test3() throws Exception {
			//keepAspectRatio(false) 默认是按照比例缩放的
			Thumbnails.of("image/girls.jpg") 
			        .size(200, 200) 
	                .keepAspectRatio(false) 
			        .toFile("images/girls_200x200.jpg");
		}
		
		//旋转
		private void test4() throws Exception {
			//rotate(角度),正数：顺时针 负数：逆时针
			Thumbnails.of("image/girls.jpg") 
					.size(1280, 1024)
			        .rotate(90) 
			        .toFile("images/girls_rotate+90.jpg"); 

			Thumbnails.of("image/girls.jpg") 
					.size(1280, 1024)
			        .rotate(-90) 
			        .toFile("images/girls_rotate-90.jpg"); 
		}
		
		//水印
		private void test5() throws Exception {
			//watermark(位置，水印图，透明度)
			Thumbnails.of("image/girls.jpg") 
					.size(1280, 1024)
			        .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File("image/watermark.jpg")), 0.5f) 
	                .outputQuality(0.8f) 
			        .toFile("images/girls_watermark_bottom_right.jpg");
			
			Thumbnails.of("image/girls.jpg") 
					.size(1280, 1024)
			        .watermark(Positions.CENTER, ImageIO.read(new File("image/watermark.jpg")), 0.5f) 
			        .outputQuality(0.8f) 
			        .toFile("images/girls_watermark_center.jpg");
		}
		
		//裁剪
		private void test6() throws Exception {
			//sourceRegion()
			
			//图片中心400*400的区域
			Thumbnails.of("image/girls.jpg")
					.sourceRegion(Positions.CENTER, 400,400)
					.size(200, 200)
	                .keepAspectRatio(false) 
			        .toFile("images/girls_region_center.jpg");
			
			//图片右下400*400的区域
			Thumbnails.of("image/girls.jpg")
					.sourceRegion(Positions.BOTTOM_RIGHT, 400,400)
					.size(200, 200)
	                .keepAspectRatio(false) 
			        .toFile("images/girls_region_bootom_right.jpg");
			
			//指定坐标
			Thumbnails.of("image/girls.jpg")
					.sourceRegion(600, 500, 400, 400)
					.size(200, 200)
			        .keepAspectRatio(false) 
			        .toFile("images/girls_region_coord.jpg");
		}
		
		//转化图像格式
		private void test7() throws Exception {
			//outputFormat(图像格式)
			Thumbnails.of("image/girls.jpg") 
					.size(1280, 1024)
	                .outputFormat("png") 
			        .toFile("images/girls_1280x1024.png"); 
			
			Thumbnails.of("image/girls.jpg") 
					.size(1280, 1024)
			        .outputFormat("gif") 
			        .toFile("images/girls_1280x1024.gif"); 
		}
		
		//输出到OutputStream
		private void test8() throws Exception {
			//toOutputStream(流对象)
			OutputStream os = new FileOutputStream("images/girls_1280x1024_OutputStream.png");
			Thumbnails.of("image/girls.jpg") 
					.size(1280, 1024)
	                .toOutputStream(os);
		}
		
		//输出到BufferedImage
		private void test9() throws Exception {
			//asBufferedImage() 返回BufferedImage
			BufferedImage thumbnail = Thumbnails.of("image/girls.jpg") 
					.size(1280, 1024)
					.asBufferedImage();
			ImageIO.write(thumbnail, "jpg", new File("images/girls_1280x1024_BufferedImage.jpg")); 
		}
}
