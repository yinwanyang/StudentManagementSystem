package com.xinhua.java.Sms;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {
	/**
	 * 创建一个学生类，定义他的姓名和学号
	 */
	String name;
	String nums;
	/**
	 * 定义一个全局动态数组，用于储存学生的信息
	 */
	static ArrayList<Student> array1 = new ArrayList<Student>();
	/**
	 * 进入学生管理系统的方法
	 */
	void in(){
		Register reg = new Register();
		System.out.println("请选择     1：登陆\t 2:注册\t 3:退出系统");
		Scanner read = new Scanner(System.in);
		int rea = 0;
		try{
			rea = read.nextInt();
		}
		catch(Exception e){
			System.out.println("非法的输入!");
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
			System.out.println("已退出！");
			System.exit(0);
			break;
		default:
			System.out.println("非法的输入!");
			in();	
			}			
	}
	/**
	 * 对学生管理系统的操作
	 * @param zhanghao
	 */
	void system(String zhanghao) {
		String name = "";
		/**
		 * 找到相关账号下的老师的姓名
		 */
		for (Register obj:Register.array) {
			if (zhanghao.equals(obj.account)) {
				name = obj.name;
				break;
			}
		}
		while (true) {
			System.out.println(name + "老师您好，欢迎您的到来");
			/**
			 * 如果发现动态数组里面没有任何信息
			 * 则会跳到添加学生信息的方法
			 */
			if (array1.size() < 1) {
				System.out.println("目前本系统没有学生，请添加！");
				add(zhanghao);
			}
			/**
			 * 循环选择
			 */
			while (true) {
				System.out.println("请选择您想要操作的项目：1：查找\t2：添加：\t3：删除\t4:查看所有学生信息\t5:返回登录界面");
				Scanner read = new Scanner(System.in);
				int reads = 0;
				/**
				 * 异常的处理，防止输入中文、字母等
				 * 让系统报异常而崩溃
				 */
				try{
					reads = read.nextInt();
				}
				catch(Exception e){
					System.out.println("您输入的项目不存在，请重新输入");
					continue;
				}
				/**
				 * 对输入选项的处理，用switch速度更快
				 */
				switch(reads){
					case 1:
						Student obj = seek();
						if(obj==null){
							System.out.println("你查找的学生不存在");
						}
						else{
							System.out.println("该生的信息如下\t姓名："+obj.name+"\t学号："+obj.nums);
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
						System.out.println("输入有误，请重新输入！");
						break;
				}
			}
		}
				
	}
	
	/**
	 * 查找学生的方法
	 * 有就将该学号的对象输出
	 */
	static Student seek(){
		Student obj = null;
		System.out.println("请输入学号");
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
		 * 添加学生的方法
		 */
	void add(String zhanghao) { 
		Student stu = new Student();
		System.out.println("请输入学生姓名");
		Scanner names = new Scanner(System.in);
		String nam = names.next();
		stu.name = nam;
		y:
		while (true) {
			System.out.println("请输入学号");
			Scanner nums = new Scanner(System.in);
			String num = nums.next();
			/**
			 * 调用判断学号是否重复的方法，如果重复，则返回true
			 * 否则返回false
			 */
			boolean temp = repeat(num);
			if (temp) {
				System.out.println("学号已存在");
				while(true){
					System.out.println("请选择\t1：重新输入学号\t2：返回上一级\t3:返回登录界面");
					Scanner read = new Scanner(System.in);
					int reads;
					try{
						reads = read.nextInt();
					}
					catch(Exception e){
						System.out.println("没有这个选项");
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
							System.out.println("没有这个选项");
					}
						
				}
			}
			stu.nums = num;
			array1.add(stu);
			System.out.println("添加成功!");
			while (true) {
				System.out.println("您可以选择\t1:继续添加\t\t2:返回上一级\t3：返回登录界面");
				Scanner read = new Scanner(System.in);
				int reads = 0;
				try{
					reads = read.nextInt();
				}
				catch(Exception e){
					System.out.println("没有这个选项");
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
						System.out.println("没有这个选项");
				}
			}
		}
	}
	/**
	 * 删除学生的方法
	 */
	void delete(String zhanghao){
		if(array1.size()<1){
			System.out.println("目前没有学生！自动跳转到上一级。");
			system(zhanghao);
		}
		System.out.println("请输入学号");
			Scanner nums = new Scanner(System.in);
			String num = nums.next();
			for (Student stu:array1){
				if (num.equals(stu.nums)){
					while(true){
						System.out.println("是否删除学生：" + stu.name);
						System.out.println("1:是\t2:否");
						int reads;
						try{
							Scanner read = new Scanner(System.in);
							reads = read.nextInt();
						}
						catch(Exception e){
							System.out.println("输入错误，请重新输入");
							continue;
						}
						switch(reads){
							case 1:
								array1.remove(stu);
								System.out.println("删除成功！");
								/**
								 * 删除完毕之后选择是否继续删除
								 */
								while(true){
									System.out.println("是否继续删除？\t1:是\t2:否");							
									Scanner read = new Scanner(System.in);
									int read1;
									try{
										read1 = read.nextInt();
									}
									catch(Exception e){
										System.out.println("输入错误");
										continue;
									}
									switch(read1){
										case 1:
											delete(zhanghao);
											break;
										case 2:
											System.out.println("即将返回操作界面");
											system(zhanghao);
											break;
									}
									break;
								}
							case 2:
								system(zhanghao);
								break;
							default:
								System.out.println("输入错误，请重新输入");
						}
					}
				}
			}
			
				/**
				 * 对于输入的学号不存在的处理
				 */
			
					System.out.println("学号不存在");
					while(true){
						System.out.println("请选择\t1:重新输入学号\t2：返回上一级");
						int reads;
						try{
							Scanner read = new Scanner(System.in);
							reads = read.nextInt();
						}
						catch(Exception e){
							System.out.println("输入错误，请重新输入");
							continue;
						}
						switch(reads){
							case 1:
								delete(zhanghao);
								break;
							case 2:
								System.out.println("即将返回操作界面");
								system(zhanghao);
								break;
							default:
								System.out.println("输入错误，请重新输入");
								break;
						}
					}
				
			}
	
	/**
	 * 查看所有学生的方法
	 */
	static void lookall(){
		System.out.println("学生信息如下：\t姓名\t学号");
		for(Student stu:array1){
			System.out.println("\t\t"+stu.name+"\t"+stu.nums);
		}	
	}
		/** 
		 * 判断输入的学号是否重复的方法
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
