package com.xinhua.java.Sms;

import java.util.ArrayList;

import java.util.Scanner;
	/**
	 * �洢�û���Ϣ����Ϣ
	 */
public class Register {	
	/**
	 * ����һ��ȫ�ֶ�̬���飬���ڴ洢�˺ź�����
	 */
	static ArrayList<Register> array = new ArrayList<Register>();
	/**
	 * �����û���¼�˺š������Լ��û�������
	 */
	String account;				
	String password;			
	String name;	
		/**
		 * ��ʦ��½�ķ���
		 */
	void register(){	
		Student stu = new Student();
		Register reg = new Register();
		boolean temp;
		System.out.println("�������˺ţ�");
		Scanner read = new Scanner(System.in);
		String ress = read.next();
		reg.account = ress;			
		System.out.println("���������룺");
		Scanner reads = new Scanner(System.in);
		String rea = reads.next();
		reg.password = rea;
		/**
		 * �ж�������˺ź�����Բ��� 
		 */
		temp = judge(reg);				
		if(temp){
			System.out.println("��ӭ����ѧ������ϵͳ��");
			stu.system(ress);
		}
		 else{
			System.out.println("�˺�/���벻�ԡ�");
			while(true){
				System.out.println("��ѡ��   1����������\t2�����ص�¼����");
				int rea1 = 0;
				/**
				 * �ж�������Ƿ������֣�������������
				 */
				try{
					Scanner read1 = new Scanner(System.in);
					rea1 = read1.nextInt();
				}
				catch(Exception e){
					System.out.println("�������");
					continue;
				}
				switch(rea1){
					case 1:
						register();
						break;
					case 2:
						stu.in();
						break;
					default:
						System.out.println("�������");
				}
			 }			 
		}	
	}
	
		/**
		 *��ʦע��ķ���
		 */
		void login(){	
			Student stu = new Student();
			Register reg = new Register();
			System.out.println("����������ע���˺�,���˺ų��Ȳ�С��2λ��");
			Scanner read = new Scanner(System.in);
			String res = read.next();
			if(res.length()<2){
				System.out.println("�˺ų��Ȳ�����");
				while(true){
					System.out.println("��ѡ��\t1��������һ��\t2:���ص�¼����");
					int a1 = 0;
					/**
					 * �ж������Ƿ��������������������
					 */
					try{
						Scanner aa = new Scanner(System.in);
						a1 = aa.nextInt();
					}
					catch(Exception e){
						System.out.println("û�����ѡ�����������");
						continue;
					}
					switch(a1){
						case 1:
							login();
							break;
						case 2:
							stu.in();
							break;
						default:
							System.out.println("û�����ѡ�����������");
							break;
					}
				}	
			}
			/**
			 * �����ж�ע���˺��Ƿ��ظ��ķ������������ֵΪtrue�����ظ�
			 */
			boolean temp = judge(res);										
			if(temp){
				System.out.print("�˺��Ѵ��ڣ�");
				login();
			}
			reg.account = res;
			y:
			while(true){
				System.out.println("������ע������,�����벻С��4λ��");
				Scanner reads = new Scanner(System.in);
				String rea = reads.next();
				if(rea.length()<4){
					System.out.println("���볤�Ȳ�����");
					while(true){
						/**
						 * ���볤�Ȳ����Ĵ���
						 */	
						System.out.println("��ѡ��\t1:������������\t2��������һ��\t3:���ص�¼����");
						Scanner aa = new Scanner(System.in);
						int a1;
						try{
							a1 = aa.nextInt();
						}
						catch(Exception e){
							System.out.println("û�����ѡ�����������");
							continue;
						}
						switch(a1){
							case 1:
								continue y;
							case 2:
								login();
								break;
							case 3:
								stu.in();
								break;
							default:
								System.out.println("û�����ѡ�����������");	
						}
					}
				}
				reg.password = rea;									//����		
				System.out.println("ע��ɹ�����������������");
				Scanner names = new Scanner(System.in);
				String nam = names.next();
				reg.name = nam;	
				array.add(reg);
				stu.in();
			}
				
	}
		/**
		 * �ж��˺ź������Ƿ���ȷ�ķ���
		 */
		boolean judge(Register judge){				
			boolean temp = false;
			/**
			 * �ж϶�̬���������Ƿ���ĳ���û����˺ź������������һ��
			 * ����У�����true�����򷵻�false
			 */
			for(Register i:array){
				String account = i.account;
				String password = i.password;
				if(judge.account.equals(account)&&judge.password.equals(password)){
					temp = true;
				}	
			}
			return temp;
			
		}
		
		/**
		 * �ж�ע����˺��Ƿ��ظ�
		 * ����ظ����򷵻�true;
		 */
		boolean judge(String a){					
			boolean temp = false;
			for(Register i:array){
				if(a.equals(i.account)){
					temp = true;
					break;
				}
			}
			return temp;
		}
}
