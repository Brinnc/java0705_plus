package org.sp.project0705.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


class ImageCopy{
	


	public static void main(String[] args){
		//대상이되는 파일에 파일입출력스트림을 연결해보자

		//복사할 파일이 있는 경로와 파일을 복사할 경로
		String path="D:/morning/javase_workspace/project0705/res/summer7.jpg";
		String path2="D:/morning/javase_workspace/project0705/data/copy2.jpg";
		
		//원하는 자원인 이미지에 입력스트림을 연결
		/*
		try~ catch문의 목적: 프로그램의 비정상 종료 방지
		역할: try문에서는 에러가 발생할 소지가 있는 코드를 작성하고,
		만일 try영역에서 우려했던 에러가 발생한다면,
		코드를 방치하지 말고 catch문으로 유도하여 에러에 대한 처리를 해줘야 함
		그래야 신뢰성있는 프로그램의 개발이 가능함
		*/
		FileInputStream fis=null;
		FileOutputStream fos=null;

		try{
			//파일을 대상으로 한 입력스트림
			fis=new FileInputStream(path);
			System.out.println("스트림 생성 완료");

			//파일을 대상으로 한 출력스트림
			fos=new FileOutputStream(path2);
			
			//생성된 스트림을 이용하여 타겟 이미지를 이루고 있는 수많은 알갱이(바이트 데이터) 중 하나를 들이마시고(읽고)
			//읽어들인 바이트 데이터를 출력 스트림을 통해 내뱉음(출력함, 즉 복사)
			while(true){

				int data=fis.read(); //한 바이트 읽기, 입력
				if(data==-1)break; //읽어들일 데이터가 없다면 반복문 종료
				System.out.println(data);

				fos.write(data); //출력
			}
			System.out.println("파일복사완료");

			//사용된 스트림은 반드시 제거해야함이 개발의 원칙!
			//fos.close();
			//fis.close();

		}catch(FileNotFoundException e){ //위 코드에서 에러가 나면 캐치문으로 실행부가 들어가서 정상 수행을 유도해냄 에러종류
			System.out.println("존재하지 않는 파일 경로입니다");
			//e.printStackTrace();
			//System.out.println(e);
		}catch(IOException e){ //다중캐치문
			System.out.println("파일을 읽을 수 없습니다");
		}finally{ //실행부는 트라이문을 수행하든 캐치문을 수행하든 반드시 finally를 거치게됨, 따라서 여기서는 주로 사용되지 않는 자원들을 해제할 때 코드 작성
			
			try{
				fos.close();
				//fis.close();
			}catch(IOException e){
				e.printStackTrace();
			}

			try{
				//fos.close();
				fis.close();
			}catch(IOException e){
				e.printStackTrace();
			}
			
		}

	}
}
