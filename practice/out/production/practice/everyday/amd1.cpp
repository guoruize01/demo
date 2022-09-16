#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
vector<char>op={'+','-','*','/'};
vector<char>operation;//存放当前运算符
double cal(vector<int>num,vector<char>operation);//计算当前顺序的操作数和运算符的结果
bool dfs(int a,int b,int c,int d);
int main()
{
    vector<int>num(4,0);
    // while(cin>>num[0]>>num[1]>>num[2]>>num[3])
    num = {6,6,6,6};
    
    sort(num.begin(),num.end());
    bool flag=false;
    char op[3];
    do{
        if(dfs(num[0],num[1],num[2],num[3]))
        {
            cout<<"true"<<endl;
            flag=true;
            break;
        }
    }while(next_permutation(num.begin(),num.end()));
    if(!flag)
            {
                cout<<"false"<<endl;
            }
    
    return 0;
}
 
double cal(vector<int>num,vector<char>operation)
{
    double sum=num[0];
    for(int i=0,j=1;i<operation.size();i++,j++)
    {
        switch(operation[i])
        {
            case '+':
                sum+=num[j];
                break;
            case '-':
                sum-=num[j];
                break;
            case '*':
                sum *=num[j];
                break;
            case '/':
                sum /=num[j];
                break;
        }
    }
    return sum;
}
bool dfs(int a,int b,int c,int d)
{
    vector<int>num={a,b,c,d};
    for(int i=0;i<op.size();i++)//三个循环枚举所有的操作符顺序可能
    {
        for(int j=0;j<op.size();j++)
        {
            for(int k=0;k<op.size();k++)
            {
                operation={op[i],op[j],op[k]};//枚举所有可能得运算符顺序
                double sum=cal(num,operation);//计算结果
                if(sum==24.0)
                    return true;
            }
        }
    }
    return false;
}