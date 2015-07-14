package com.youguu.asteroid.tool.service.impl;

import java.util.ArrayList;
import java.util.List;

public class Combination {
	/**
	 * @param a :组合数组
	 * @param m :生成组合长度
	 * @return :所有可能的组合数组列表
	 */
	public List<String[]> combination(String[] a, int m) {
		Combination c = new Combination();
		List<String[]> list = new ArrayList<String[]>();
		int n = a.length;
		boolean end = false; // 是否是最后一种组合的标记
		// 生成辅助数组。首先初始化，将数组前n个元素置1，表示第一个组合为前n个数。
		int[] tempNum = new int[n];
		for (int i = 0; i < n; i++) {
			if (i < m) {
				tempNum[i] = 1;
			} else {
				tempNum[i] = 0;
			}
		}
//		printVir(tempNum);// 打印首个辅助数组
		list.add(c.createResult(a, tempNum, m));// 打印第一种默认组合
		int k = 0;// 标记位
		while (!end) {
			boolean findFirst = false;
			boolean swap = false;
			// 然后从左到右扫描数组元素值的"10"组合，找到第一个"10"组合后将其变为"01"
			for (int i = 0; i < n; i++) {
				int l = 0;
				if (!findFirst && tempNum[i] == 1) {
					k = i;
					findFirst = true;
				}
				if (tempNum[i] == 1 && tempNum[i + 1] == 0) {
					tempNum[i] = 0;
					tempNum[i + 1] = 1;
					swap = true;
					for (l = 0; l < i - k; l++) { // 同时将其左边的所有"1"全部移动到数组的最左端。
						tempNum[l] = tempNum[k + l];
					}
					for (l = i - k; l < i; l++) {
						tempNum[l] = 0;
					}
					if (k == i && i + 1 == n - m) {// 假如第一个"1"刚刚移动到第n-m+1个位置,则终止整个寻找
						end = true;
					}
				}
				if (swap) {
					break;
				}
			}
//			printVir(tempNum);// 打印辅助数组
			list.add(c.createResult(a, tempNum, m));// 添加下一种默认组合
		}
		return list;
	}

	// 根据辅助数组和原始数组生成结果数组
	public String[] createResult(String[] a, int[] temp, int m) {
		String[] result = new String[m];
		int j = 0;
		for (int i = 0; i < a.length; i++) {
			if (temp[i] == 1) {
				result[j] = a[i];
//				System.out.println("result[" + j + "]:" + result[j]);
				j++;
			}
		}
		return result;
	}

	// 打印整组数组
	public void print(List<String[]> list) {
		System.out.println("具体组合结果为:");
		for (int i = 0; i < list.size(); i++) {
			String[] temp = (String[]) list.get(i);
			for (int j = 0; j < temp.length; j++) {
//				java.text.DecimalFormat df = new java.text.DecimalFormat("0");// 将输出格式化
				System.out.print(temp[j]);
			}
			System.out.println();
		}
	}

	// 打印辅助数组的方法
	public void printVir(int[] a) {
		System.out.println("生成的辅助数组为：");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
		}
		System.out.println();
	}

	public static void main(String[] args) {
//		String[] a = { "人民币","美元","欧元","英镑","港币","日元","加拿大元","澳元","新加坡元","新西兰元","韩元","澳门元","菲律宾元","泰国铢","法郎","瑞士法郎","比利时法郎","卢布","挪威克朗","瑞典克朗","丹麦克朗","荷兰盾" }; // 整数数组
		String[] a = {"CNY","USD","EUR"};
		int m = 2; // 待取出组合的个数
		Combination c = new Combination();
		List<String[]> list = c.combination(a, m);
		c.print(list);
		System.out.println("一共" + list.size() + "组!");
	}
}