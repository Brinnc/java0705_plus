package org.sp.project0705.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


class ImageCopy{
	


	public static void main(String[] args){
		//����̵Ǵ� ���Ͽ� ��������½�Ʈ���� �����غ���

		//������ ������ �ִ� ��ο� ������ ������ ���
		String path="D:/morning/javase_workspace/project0705/res/summer7.jpg";
		String path2="D:/morning/javase_workspace/project0705/data/copy2.jpg";
		
		//���ϴ� �ڿ��� �̹����� �Է½�Ʈ���� ����
		/*
		try~ catch���� ����: ���α׷��� ������ ���� ����
		����: try�������� ������ �߻��� ������ �ִ� �ڵ带 �ۼ��ϰ�,
		���� try�������� ����ߴ� ������ �߻��Ѵٸ�,
		�ڵ带 ��ġ���� ���� catch������ �����Ͽ� ������ ���� ó���� ����� ��
		�׷��� �ŷڼ��ִ� ���α׷��� ������ ������
		*/
		FileInputStream fis=null;
		FileOutputStream fos=null;

		try{
			//������ ������� �� �Է½�Ʈ��
			fis=new FileInputStream(path);
			System.out.println("��Ʈ�� ���� �Ϸ�");

			//������ ������� �� ��½�Ʈ��
			fos=new FileOutputStream(path2);
			
			//������ ��Ʈ���� �̿��Ͽ� Ÿ�� �̹����� �̷�� �ִ� ������ �˰���(����Ʈ ������) �� �ϳ��� ���̸��ð�(�а�)
			//�о���� ����Ʈ �����͸� ��� ��Ʈ���� ���� ������(�����, �� ����)
			while(true){

				int data=fis.read(); //�� ����Ʈ �б�, �Է�
				if(data==-1)break; //�о���� �����Ͱ� ���ٸ� �ݺ��� ����
				System.out.println(data);

				fos.write(data); //���
			}
			System.out.println("���Ϻ���Ϸ�");

			//���� ��Ʈ���� �ݵ�� �����ؾ����� ������ ��Ģ!
			//fos.close();
			//fis.close();

		}catch(FileNotFoundException e){ //�� �ڵ忡�� ������ ���� ĳġ������ ����ΰ� ���� ���� ������ �����س� ��������
			System.out.println("�������� �ʴ� ���� ����Դϴ�");
			//e.printStackTrace();
			//System.out.println(e);
		}catch(IOException e){ //����ĳġ��
			System.out.println("������ ���� �� �����ϴ�");
		}finally{ //����δ� Ʈ���̹��� �����ϵ� ĳġ���� �����ϵ� �ݵ�� finally�� ��ġ�Ե�, ���� ���⼭�� �ַ� ������ �ʴ� �ڿ����� ������ �� �ڵ� �ۼ�
			
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
