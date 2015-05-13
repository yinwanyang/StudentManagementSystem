package com.xinhua.java.Sms;

import java.util.ArrayList;

import java.util.Scanner;
	/**
	 * 存储用户信息的信息
	 */
public class Register {	
	/**
	 * 定义一个全局动态数组，用于存储账号和密码
	 */
	static ArrayList<Register> array = new ArrayList<Register>();
	/**
	 * 定义用户登录账号、密码以及用户的姓名
	 */
	String account;				
	String password;			
	String name;	
		/**
		 * 老师登陆的方法
		 */
	void register(){	
		Student stu = new Student();
		Register reg = new Register();
		boolean temp;
		System.out.println("请输入账号：");
		Scanner read = new Scanner(System.in);
		String ress = read.next();
		reg.account = ress;			
		System.out.println("请输入密码：");
		Scanner reads = new Scanner(System.in);
		String rea = reads.next();
		reg.password = rea;
		/**
		 * 判断输入的账号和密码对不对 
		 */
		temp = judge(reg);				
		if(temp){
			System.out.println("欢迎进入学生管理系统！");
			stu.system(ress);
		}
		 else{
			System.out.println("账号/密码不对。");
			while(true){
				System.out.println("请选择   1：重新输入\t2：返回登录界面");
				int rea1 = 0;
				/**
				 * 判断输入的是否是数字，否则重新输入
				 */
				try{
					Scanner read1 = new Scanner(System.in);
					rea1 = read1.nextInt();
				}
				catch(Exception e){
					System.out.println("输入错误！");
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
						System.out.println("输入错误！");
				}
			 }			 
		}	
	}
	
		/**
		 *老师注册的方法
		 */
		void login(){	
			Student stu = new Student();
			Register reg = new Register();
			System.out.println("请输入您的注册账号,且账号长度不小于2位：");
			Scanner read = new Scanner(System.in);
			String res = read.next();
			if(res.length()<2){
				System.out.println("账号长度不够！");
				while(true){
					System.out.println("请选择\t1：返回上一级\t2:返回登录界面");
					int a1 = 0;
					/**
					 * 判断输入是否合理，不合理则重新输入
					 */
					try{
						Scanner aa = new Scanner(System.in);
						a1 = aa.nextInt();
					}
					catch(Exception e){
						System.out.println("没有这个选项，请重新输入");
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
							System.out.println("没有这个选项，请重新输入");
							break;
					}
				}	
			}
			/**
			 * 调用判断注册账号是否重复的方法，如果返回值为true，则重复
			 */
			boolean temp = judge(res);										
			if(temp){
				System.out.print("账号已存在！");
				login();
			}
			reg.account = res;
			y:
			while(true){
				System.out.println("请输入注册密码,且密码不小于4位：");
				Scanner reads = new Scanner(System.in);
				String rea = reads.next();
				if(rea.length()<4){
					System.out.println("密码长度不够！");
					while(true){
						/**
						 * 密码长度不够的处理
						 */	
						System.out.println("请选择\t1:重新输入密码\t2：返回上一级\t3:返回登录界面");
						Scanner aa = new Scanner(System.in);
						int a1;
						try{
							a1 = aa.nextInt();
						}
						catch(Exception e){
							System.out.println("没有这个选项，请重新输入");
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
								System.out.println("没有这个选项，请重新输入");	
						}
					}
				}
				reg.password = rea;									//密码		
				System.out.println("注册成功！请输入您的姓名");
				Scanner names = new Scanner(System.in);
				String nam = names.next();
				reg.name = nam;	
				array.add(reg);
				stu.in();
			}
				
	}
		/**
		 * 判断账号和密码是否正确的方法
		 */
		boolean judge(Register judge){				
			boolean temp = false;
			/**
			 * 判断动态数组里面是否有某个用户的账号和密码与输入的一致
			 * 如果有，返回true，否则返回false
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
		 * 判断注册的账号是否重复
		 * 如果重复，则返回true;
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
