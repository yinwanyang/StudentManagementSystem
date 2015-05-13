package com.xinhua.java.Sms;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {
	/**
	 * ����һ��ѧ���࣬��������������ѧ��
	 */
	String name;
	String nums;
	/**
	 * ����һ��ȫ�ֶ�̬���飬���ڴ���ѧ������Ϣ
	 */
	static ArrayList<Student> array1 = new ArrayList<Student>();
	/**
	 * ����ѧ������ϵͳ�ķ���
	 */
	void in(){
		Register reg = new Register();
		System.out.println("��ѡ��     1����½\t 2:ע��\t 3:�˳�ϵͳ");
		Scanner read = new Scanner(System.in);
		int rea = 0;
		try{
			rea = read.nextInt();
		}
		catch(Exception e){
			System.out.println("�Ƿ�������!");
			in();
		}
		switch(rea){
		case 1:
			reg.register();
			break;
		case 2:
			reg.login();
			break;
		case 3:
			System.out.println("���˳���");
			System.exit(0);
			break;
		default:
			System.out.println("�Ƿ�������!");
			in();	
			}			
	}
	/**
	 * ��ѧ������ϵͳ�Ĳ���
	 * @param zhanghao
	 */
	void system(String zhanghao) {
		String name = "";
		/**
		 * �ҵ�����˺��µ���ʦ������
		 */
		for (Register obj:Register.array) {
			if (zhanghao.equals(obj.account)) {
				name = obj.name;
				break;
			}
		}
		while (true) {
			System.out.println(name + "��ʦ���ã���ӭ���ĵ���");
			/**
			 * ������ֶ�̬��������û���κ���Ϣ
			 * ����������ѧ����Ϣ�ķ���
			 */
			if (array1.size() < 1) {
				System.out.println("Ŀǰ��ϵͳû��ѧ��������ӣ�");
				add(zhanghao);
			}
			/**
			 * ѭ��ѡ��
			 */
			while (true) {
				System.out.println("��ѡ������Ҫ��������Ŀ��1������\t2����ӣ�\t3��ɾ��\t4:�鿴����ѧ����Ϣ\t5:���ص�¼����");
				Scanner read = new Scanner(System.in);
				int reads = 0;
				/**
				 * �쳣�Ĵ�����ֹ�������ġ���ĸ��
				 * ��ϵͳ���쳣������
				 */
				try{
					reads = read.nextInt();
				}
				catch(Exception e){
					System.out.println("���������Ŀ�����ڣ�����������");
					continue;
				}
				/**
				 * ������ѡ��Ĵ�����switch�ٶȸ���
				 */
				switch(reads){
					case 1:
						Student obj = seek();
						if(obj==null){
							System.out.println("����ҵ�ѧ��������");
						}
						else{
							System.out.println("��������Ϣ����\t������"+obj.name+"\tѧ�ţ�"+obj.nums);
						}
						break;
					case 2:
						add(zhanghao);
						break;
					case 3:
						delete(zhanghao);
					case 4:
						lookall();
						break;
					case 5:
						in();
						break;
					default:
						System.out.println("�����������������룡");
						break;
				}
			}
		}
				
	}
	
	/**
	 * ����ѧ���ķ���
	 * �оͽ���ѧ�ŵĶ������
	 */
	static Student seek(){
		Student obj = null;
		System.out.println("������ѧ��");
		Scanner nums = new Scanner(System.in);
		String num = nums.next();
		for (Student obj1:array1){
			if (num.equals(obj1.nums)) {
				obj = obj1;
				break;
			}
		}
		return obj;
	}
		/**
		 * ���ѧ���ķ���
		 */
	void add(String zhanghao) { 
		Student stu = new Student();
		System.out.println("������ѧ������");
		Scanner names = new Scanner(System.in);
		String nam = names.next();
		stu.name = nam;
		y:
		while (true) {
			System.out.println("������ѧ��");
			Scanner nums = new Scanner(System.in);
			String num = nums.next();
			/**
			 * �����ж�ѧ���Ƿ��ظ��ķ���������ظ����򷵻�true
			 * ���򷵻�false
			 */
			boolean temp = repeat(num);
			if (temp) {
				System.out.println("ѧ���Ѵ���");
				while(true){
					System.out.println("��ѡ��\t1����������ѧ��\t2��������һ��\t3:���ص�¼����");
					Scanner read = new Scanner(System.in);
					int reads;
					try{
						reads = read.nextInt();
					}
					catch(Exception e){
						System.out.println("û�����ѡ��");
						continue;
					}
					switch(reads){
						case 1:
							continue y;
						case 2:
							system(zhanghao);
							break;
						case 3:
							in();
							break;
						default:
							System.out.println("û�����ѡ��");
					}
						
				}
			}
			stu.nums = num;
			array1.add(stu);
			System.out.println("��ӳɹ�!");
			while (true) {
				System.out.println("������ѡ��\t1:�������\t\t2:������һ��\t3�����ص�¼����");
				Scanner read = new Scanner(System.in);
				int reads = 0;
				try{
					reads = read.nextInt();
				}
				catch(Exception e){
					System.out.println("û�����ѡ��");
					continue;
				}
				switch(reads){
					case 1:
						add(zhanghao);
						break;
					case 2:
						system(zhanghao);
						break;
					case 3:
						in();
						break;
					default:
						System.out.println("û�����ѡ��");
				}
			}
		}
	}
	/**
	 * ɾ��ѧ���ķ���
	 */
	void delete(String zhanghao){
		if(array1.size()<1){
			System.out.println("Ŀǰû��ѧ�����Զ���ת����һ����");
			system(zhanghao);
		}
		System.out.println("������ѧ��");
			Scanner nums = new Scanner(System.in);
			String num = nums.next();
			for (Student stu:array1){
				if (num.equals(stu.nums)){
					while(true){
						System.out.println("�Ƿ�ɾ��ѧ����" + stu.name);
						System.out.println("1:��\t2:��");
						int reads;
						try{
							Scanner read = new Scanner(System.in);
							reads = read.nextInt();
						}
						catch(Exception e){
							System.out.println("�����������������");
							continue;
						}
						switch(reads){
							case 1:
								array1.remove(stu);
								System.out.println("ɾ���ɹ���");
								/**
								 * ɾ�����֮��ѡ���Ƿ����ɾ��
								 */
								while(true){
									System.out.println("�Ƿ����ɾ����\t1:��\t2:��");							
									Scanner read = new Scanner(System.in);
									int read1;
									try{
										read1 = read.nextInt();
									}
									catch(Exception e){
										System.out.println("�������");
										continue;
									}
									switch(read1){
										case 1:
											delete(zhanghao);
											break;
										case 2:
											System.out.println("�������ز�������");
											system(zhanghao);
											break;
									}
									break;
								}
							case 2:
								system(zhanghao);
								break;
							default:
								System.out.println("�����������������");
						}
					}
				}
			}
			
				/**
				 * ���������ѧ�Ų����ڵĴ���
				 */
			
					System.out.println("ѧ�Ų�����");
					while(true){
						System.out.println("��ѡ��\t1:��������ѧ��\t2��������һ��");
						int reads;
						try{
							Scanner read = new Scanner(System.in);
							reads = read.nextInt();
						}
						catch(Exception e){
							System.out.println("�����������������");
							continue;
						}
						switch(reads){
							case 1:
								delete(zhanghao);
								break;
							case 2:
								System.out.println("�������ز�������");
								system(zhanghao);
								break;
							default:
								System.out.println("�����������������");
								break;
						}
					}
				
			}
	
	/**
	 * �鿴����ѧ���ķ���
	 */
	static void lookall(){
		System.out.println("ѧ����Ϣ���£�\t����\tѧ��");
		for(Student stu:array1){
			System.out.println("\t\t"+stu.name+"\t"+stu.nums);
		}	
	}
		/** 
		 * �ж������ѧ���Ƿ��ظ��ķ���
		 */
	static boolean repeat(String nums) { 
		boolean temp = false;
		for (Student stu:array1) {
			if (nums.equals(stu.nums)) {
				temp = true;
				break;
			}
		}
		return temp;
	}

}
