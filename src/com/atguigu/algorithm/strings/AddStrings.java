package com.atguigu.algorithm.strings;

public class AddStrings {
    public String addStrings(String num1, String num2) {
        //定义一个StringBuffer，保存最终的结果
        StringBuffer result = new StringBuffer();

        //定义两个字符串的初始位置
        int i = num1.length()-1;
        int j = num2.length()-1;
        int carry = 0;//保存当前的进位


        //从个位开始依次遍历所有数位，只要还有数没有计算，就继续，其他树位为0
        while (i>=0||j>=0||carry!=0){
            //取两数当前的对应树位
            int n1 = i>=0?num1.charAt(i)-'0':0;
            int n2 = j>=0?num2.charAt(j)-'0':0;

            //对当前数进行求和
            int sum = n1+n2+carry;

            //把结果的个位保存到reault中，十位作为进位保存下来，等待下次计算
            result.append(sum%10);
            carry = sum/10;

            //移动指针，继续遍历下一位
            i--;
            j--;
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String str1 = "123";String str2 = "123";
        AddStrings addStrings = new AddStrings();
        System.out.println(addStrings.addStrings(str1,str2));
    }
}
